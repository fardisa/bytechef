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

package com.bytechef.platform.connection.service;

import com.bytechef.commons.util.CollectionUtils;
import com.bytechef.commons.util.OptionalUtils;
import com.bytechef.platform.connection.domain.Connection;
import com.bytechef.platform.connection.repository.ConnectionRepository;
import com.bytechef.platform.constant.Type;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ivica Cardic
 */
@Service("connectionService")
@Transactional
public class ConnectionServiceImpl implements ConnectionService {

    private final ConnectionRepository connectionRepository;

    @SuppressFBWarnings("EI2")
    public ConnectionServiceImpl(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @Override
    public Connection create(Connection connection) {
        Validate.notNull(connection, "'connection' must not be null");
        Validate.notBlank(connection.getComponentName(), "'componentName' must not be empty");
        Validate.notBlank(connection.getName(), "'name' must not be empty");
        Validate.isTrue(connection.getId() == null, "'id' must be null");

        return connectionRepository.save(connection);
    }

    @Override
    public void delete(long id) {
        connectionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Connection getConnection(long id) {
        return OptionalUtils.get(connectionRepository.findById(id), "Connection does not exist for id=" + id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Connection> getConnections(Type type) {
        return CollectionUtils.filter(
            connectionRepository.findAll(Sort.by("name")),
            connection -> connection.getType() == type.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Connection> getConnections(List<Long> ids) {
        return connectionRepository.findAllById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Connection> getConnections(String componentName, int version, Type type) {
        return connectionRepository.findAllByComponentNameAndConnectionVersionAndTypeOrderByName(
            componentName, version, type.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Connection> getConnections(
        String componentName, Integer connectionVersion, Long tagId, Type type) {

        Iterable<Connection> connectionIterable;

        if (StringUtils.isBlank(componentName) && tagId == null) {
            connectionIterable = connectionRepository.findAllByType(type.getId());
        } else if (StringUtils.isNotBlank(componentName) && tagId == null) {
            if (connectionVersion == null) {
                connectionIterable = connectionRepository.findAllByComponentNameAndTypeOrderByName(
                    componentName, type.getId());
            } else {
                connectionIterable = connectionRepository.findAllByComponentNameAndConnectionVersionAndTypeOrderByName(
                    componentName, connectionVersion, type.getId());
            }
        } else if (StringUtils.isBlank(componentName)) {
            connectionIterable = connectionRepository.findAllByTagIdAndType(tagId, type.getId());
        } else {
            if (connectionVersion == null) {
                connectionIterable = connectionRepository.findAllByComponentNameAndTagIdAndType(
                    componentName, tagId, type.getId());
            } else {
                connectionIterable = connectionRepository.findAllByCNCVTIT(
                    componentName, connectionVersion, tagId, type.getId());
            }

        }

        return CollectionUtils.toList(connectionIterable);
    }

    @Override
    public Connection update(long id, List<Long> tagIds) {
        Connection connection = getConnection(id);

        connection.setTagIds(tagIds);

        return connectionRepository.save(connection);
    }

    @Override
    public Connection update(Connection connection) {
        Validate.notBlank(connection.getName(), "'name' must not be empty");

        Connection curConnection = OptionalUtils.get(
            connectionRepository.findById(Validate.notNull(connection.getId(), "id")));

        curConnection.setName(connection.getName());
        curConnection.setTagIds(connection.getTagIds());
        curConnection.setVersion(connection.getVersion());

        return connectionRepository.save(curConnection);
    }
}
