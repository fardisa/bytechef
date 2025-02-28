/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.platform.connection.facade;

import com.bytechef.atlas.configuration.domain.Workflow;
import com.bytechef.atlas.configuration.domain.WorkflowTask;
import com.bytechef.atlas.configuration.service.WorkflowService;
import com.bytechef.commons.util.CollectionUtils;
import com.bytechef.component.definition.Authorization;
import com.bytechef.component.definition.Authorization.AuthorizationCallbackResponse;
import com.bytechef.component.definition.Authorization.AuthorizationType;
import com.bytechef.platform.component.registry.domain.ComponentConnection;
import com.bytechef.platform.component.registry.domain.ConnectionDefinition;
import com.bytechef.platform.component.registry.facade.ConnectionDefinitionFacade;
import com.bytechef.platform.component.registry.service.ConnectionDefinitionService;
import com.bytechef.platform.configuration.domain.WorkflowConnection;
import com.bytechef.platform.configuration.facade.WorkflowConnectionFacade;
import com.bytechef.platform.configuration.instance.accessor.InstanceAccessor;
import com.bytechef.platform.configuration.instance.accessor.InstanceAccessorRegistry;
import com.bytechef.platform.connection.domain.Connection;
import com.bytechef.platform.connection.dto.ConnectionDTO;
import com.bytechef.platform.connection.service.ConnectionService;
import com.bytechef.platform.constant.Type;
import com.bytechef.platform.oauth2.service.OAuth2Service;
import com.bytechef.tag.domain.Tag;
import com.bytechef.tag.service.TagService;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ivica Cardic
 */
@Service
@Transactional
public class ConnectionFacadeImpl implements ConnectionFacade {

    private final ConnectionDefinitionFacade connectionDefinitionFacade;
    private final ConnectionDefinitionService connectionDefinitionService;
    private final ConnectionService connectionService;
    private final InstanceAccessorRegistry instanceAccessorRegistry;
    private final OAuth2Service oAuth2Service;
    private final TagService tagService;
    private final WorkflowConnectionFacade workflowConnectionFacade;
    private final WorkflowService workflowService;

    @SuppressFBWarnings("EI2")
    public ConnectionFacadeImpl(
        ConnectionDefinitionFacade connectionDefinitionFacade, ConnectionDefinitionService connectionDefinitionService,
        ConnectionService connectionService, InstanceAccessorRegistry instanceAccessorRegistry,
        OAuth2Service oAuth2Service, TagService tagService, WorkflowConnectionFacade workflowConnectionFacade,
        WorkflowService workflowService) {

        this.connectionDefinitionFacade = connectionDefinitionFacade;
        this.connectionDefinitionService = connectionDefinitionService;
        this.connectionService = connectionService;
        this.instanceAccessorRegistry = instanceAccessorRegistry;
        this.oAuth2Service = oAuth2Service;
        this.tagService = tagService;
        this.workflowConnectionFacade = workflowConnectionFacade;
        this.workflowService = workflowService;
    }

    @Override
    public ConnectionDTO create(ConnectionDTO connectionDTO, Type type) {
        Connection connection = connectionDTO.toConnection();

        if (StringUtils.isNotBlank(connection.getAuthorizationName()) &&
            connection.containsParameter(Authorization.CODE)) {

            // TODO add support for OAUTH2_AUTHORIZATION_CODE_PKCE

            AuthorizationType authorizationType = connectionDefinitionService.getAuthorizationType(
                connection.getComponentName(), connection.getConnectionVersion(), connection.getAuthorizationName());

            if (authorizationType == AuthorizationType.OAUTH2_AUTHORIZATION_CODE ||
                authorizationType == AuthorizationType.OAUTH2_AUTHORIZATION_CODE_PKCE) {

                AuthorizationCallbackResponse authorizationCallbackResponse = connectionDefinitionFacade
                    .executeAuthorizationCallback(
                        connection.getComponentName(),
                        new ComponentConnection(
                            connection.getConnectionVersion(),
                            oAuth2Service.checkPredefinedParameters(
                                connection.getComponentName(), connection.getParameters()),
                            connection.getAuthorizationName()),
                        oAuth2Service.getRedirectUri());

                connection.putAllParameters(authorizationCallbackResponse.toMap());
            }
        }

        Map<String, ?> parameters = new HashMap<>(connection.getParameters());

        parameters.remove("clientId");
        parameters.remove("clientSecret");
        parameters.remove("state");

        connection.setParameters(parameters);

        List<Tag> tags = checkTags(connectionDTO.tags());

        if (!tags.isEmpty()) {
            connection.setTags(tags);
        }

        connection.setType(type.getId());

        connection = connectionService.create(connection);

        return new ConnectionDTO(isConnectionUsed(Validate.notNull(connection.getId(), "id"), type), connection, tags);
    }

    @Override
    public void delete(Long id) {
//        Connection connection = connectionService.getConnection(id);

        connectionService.delete(id);

// TODO find a way to delete ll tags not referenced anymore
//        connection.getTagIds()
//            .forEach(tagService::delete);
    }

    @Override
    @Transactional(readOnly = true)
    public ConnectionDTO getConnection(Long id) {
        Connection connection = connectionService.getConnection(id);

        return new ConnectionDTO(
            isConnectionUsed(Validate.notNull(connection.getId(), "id"), Type.valueOf(connection.getType())),
            connection, tagService.getTags(connection.getTagIds()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ConnectionDTO> getConnections(String componentName, Integer componentVersion, Type type) {
        List<Connection> connections = new ArrayList<>();

        List<ConnectionDefinition> connectionDefinitions = connectionDefinitionService.getConnectionDefinitions(
            componentName, componentVersion);

        for (ConnectionDefinition connectionDefinition : connectionDefinitions) {
            connections.addAll(connectionService.getConnections(
                connectionDefinition.getComponentName(), connectionDefinition.getVersion(), type));
        }

        return getConnections(connections);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ConnectionDTO> getConnections(
        String componentName, Integer connectionVersion, Long tagId, Type type) {

        List<Connection> connections = connectionService.getConnections(componentName, connectionVersion, tagId, type);

        return getConnections(connections);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tag> getConnectionTags(Type type) {
        List<Connection> connections = connectionService.getConnections(type);

        return tagService.getTags(connections.stream()
            .map(Connection::getTagIds)
            .flatMap(Collection::stream)
            .toList());
    }

    @Override
    public ConnectionDTO update(Long id, List<Tag> tags) {
        tags = checkTags(tags);

        Connection connection = connectionService.update(id, CollectionUtils.map(tags, Tag::getId));

        return new ConnectionDTO(
            isConnectionUsed(Validate.notNull(connection.getId(), "id"), Type.valueOf(connection.getType())),
            connection, tags);
    }

    @Override
    public ConnectionDTO update(ConnectionDTO connectionDTO) {
        List<Tag> tags = checkTags(connectionDTO.tags());

        Connection connection = connectionDTO.toConnection();

        connection = connectionService.update(connection);

        return new ConnectionDTO(
            isConnectionUsed(connectionDTO.id(), Type.valueOf(connection.getType())), connection, tags);
    }

    private List<Tag> checkTags(List<Tag> tags) {
        return CollectionUtils.isEmpty(tags) ? Collections.emptyList() : tagService.save(tags);
    }

    private static boolean containsTag(Connection connection, Tag tag) {
        List<Long> curTagIds = connection.getTagIds();

        return curTagIds.contains(tag.getId());
    }

    private boolean isConnectionUsed(long connectionId, Type type) {
        List<Workflow> workflows = workflowService.getWorkflows(type.getId());

        for (Workflow workflow : workflows) {
            for (WorkflowTask workflowTask : workflow.getTasks()) {
                if (isConnectionUsed(workflow.getId(), workflowTask, connectionId, type)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isConnectionUsed(
        String workflowId, WorkflowConnection workflowConnection, long connectionId, Type type) {

        return workflowConnection.getId()
            .map(curConnectionId -> connectionId == curConnectionId)
            .orElseGet(() -> isConnectionUsed(
                workflowId, workflowConnection.getOperationName(), workflowConnection.getKey(),
                connectionId, type));
    }

    private boolean isConnectionUsed(String workflowId, WorkflowTask workflowTask, long id, Type type) {
        return workflowConnectionFacade.getWorkflowConnections(workflowTask)
            .stream()
            .map(workflowConnection -> isConnectionUsed(workflowId, workflowConnection, id, type))
            .findFirst()
            .orElse(false);
    }

    private boolean isConnectionUsed(
        String workflowId, String workflowConnectionOperationName, String workflowConnectionKey, long connectionId,
        Type type) {

        InstanceAccessor instanceAccessor = instanceAccessorRegistry.getInstanceAccessor(type);

        return instanceAccessor.isConnectionUsed(
            connectionId, workflowId, workflowConnectionOperationName, workflowConnectionKey);
    }

    private List<Tag> filterTags(List<Tag> tags, Connection connection) {
        return tags.stream()
            .filter(tag -> containsTag(connection, tag))
            .toList();
    }

    private List<ConnectionDTO> getConnections(List<Connection> connections) {
        List<Tag> tags = tagService.getTags(connections.stream()
            .flatMap(connection -> CollectionUtils.stream(connection.getTagIds()))
            .filter(Objects::nonNull)
            .toList());

        return CollectionUtils.map(
            connections,
            connection -> new ConnectionDTO(
                isConnectionUsed(Validate.notNull(connection.getId(), "id"),
                    Type.valueOf(connection.getType())),
                connection, filterTags(tags, connection)));
    }
}
