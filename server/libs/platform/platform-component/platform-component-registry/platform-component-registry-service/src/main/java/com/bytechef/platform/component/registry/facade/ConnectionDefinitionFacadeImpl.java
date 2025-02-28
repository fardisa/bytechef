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

package com.bytechef.platform.component.registry.facade;

import com.bytechef.component.definition.Authorization.ApplyResponse;
import com.bytechef.component.definition.Authorization.AuthorizationCallbackResponse;
import com.bytechef.platform.component.definition.factory.ContextFactory;
import com.bytechef.platform.component.registry.domain.ComponentConnection;
import com.bytechef.platform.component.registry.domain.OAuth2AuthorizationParameters;
import com.bytechef.platform.component.registry.service.ConnectionDefinitionService;
import java.util.Optional;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/**
 * @author Ivica Cardic
 */
@Service("connectionDefinitionFacade")
public class ConnectionDefinitionFacadeImpl implements ConnectionDefinitionFacade {

    private final ConnectionDefinitionService connectionDefinitionService;
    private final ContextFactory contextFactory;

    public ConnectionDefinitionFacadeImpl(
        ConnectionDefinitionService connectionDefinitionService, ContextFactory contextFactory) {

        this.connectionDefinitionService = connectionDefinitionService;
        this.contextFactory = contextFactory;
    }

    @Override
    public ApplyResponse executeAuthorizationApply(
        @NonNull String componentName, @NonNull ComponentConnection connection) {

        return connectionDefinitionService.executeAuthorizationApply(
            componentName, connection, contextFactory.createContext(componentName, null));
    }

    @Override
    public AuthorizationCallbackResponse executeAuthorizationCallback(
        @NonNull String componentName, @NonNull ComponentConnection connection, @NonNull String redirectUri) {

        return connectionDefinitionService.executeAuthorizationCallback(
            componentName, connection, contextFactory.createContext(componentName, null), redirectUri);
    }

    @Override
    public Optional<String> executeBaseUri(@NonNull String componentName, ComponentConnection connection) {
        return connectionDefinitionService.executeBaseUri(
            componentName, connection, contextFactory.createContext(componentName, null));
    }

    @Override
    public OAuth2AuthorizationParameters getOAuth2AuthorizationParameters(
        @NonNull String componentName, ComponentConnection connection) {

        return connectionDefinitionService.getOAuth2AuthorizationParameters(
            componentName, connection, contextFactory.createContext(componentName, null));
    }
}
