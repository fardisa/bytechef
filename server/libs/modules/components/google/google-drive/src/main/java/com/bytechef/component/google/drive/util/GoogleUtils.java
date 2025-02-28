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

package com.bytechef.component.google.drive.util;

import static com.bytechef.component.definition.Authorization.ACCESS_TOKEN;

import com.bytechef.component.definition.Parameters;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.Preconditions;
import com.google.api.services.drive.Drive;

/**
 * @author Mario Cvjetojevic
 * @author Ivica Cardic
 */
public class GoogleUtils {

    public static Drive getDrive(Parameters connectionParameters) {
        return new Drive.Builder(
            new NetHttpTransport(),
            GsonFactory.getDefaultInstance(),
            new OAuthAuthentication(connectionParameters.getRequiredString(ACCESS_TOKEN)))
                .setApplicationName("Google Drive Component")
                .build();
    }

    private record OAuthAuthentication(String token)
        implements HttpRequestInitializer, HttpExecuteInterceptor {

        private OAuthAuthentication(String token) {
            this.token = Preconditions.checkNotNull(token);
        }

        public void initialize(HttpRequest request) {
            request.setInterceptor(this);
        }

        public void intercept(HttpRequest request) {
            HttpHeaders httpHeaders = request.getHeaders();

            httpHeaders.set("Authorization", "Bearer " + token);
        }
    }
}
