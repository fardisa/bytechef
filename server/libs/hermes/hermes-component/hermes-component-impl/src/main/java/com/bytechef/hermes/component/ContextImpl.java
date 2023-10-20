
/*
 * Copyright 2021 <your company/name>.
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

package com.bytechef.hermes.component;

import com.bytechef.event.EventPublisher;
import com.bytechef.atlas.event.TaskProgressedWorkflowEvent;
import com.bytechef.commons.util.MapValueUtils;
import com.bytechef.hermes.component.exception.ComponentExecutionException;
import com.bytechef.hermes.connection.WorkflowConnection;
import com.bytechef.hermes.connection.service.ConnectionService;
import com.bytechef.hermes.definition.registry.service.ConnectionDefinitionService;
import com.bytechef.hermes.file.storage.service.FileStorageService;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.springframework.core.convert.converter.Converter;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

/**
 * @author Ivica Cardic
 */
public class ContextImpl implements ActionContext, TriggerContext {

    static {
        MapValueUtils.addConverter(new ContextFileEntryConverter());
    }

    private final ConnectionDefinitionService connectionDefinitionService;
    private final ConnectionService connectionService;
    private final EventPublisher eventPublisher;
    private final FileStorageService fileStorageService;
    private final Long taskExecutionId;
    private final Map<String, WorkflowConnection> workflowConnectionMap;

    @SuppressFBWarnings("EI")
    public ContextImpl(
        ConnectionDefinitionService connectionDefinitionService, ConnectionService connectionService,
        EventPublisher eventPublisher, FileStorageService fileStorageService, Long taskExecutionId,
        Map<String, WorkflowConnection> workflowConnectionMap) {

        this.connectionDefinitionService = connectionDefinitionService;
        this.connectionService = connectionService;
        this.eventPublisher = eventPublisher;
        this.fileStorageService = fileStorageService;
        this.taskExecutionId = taskExecutionId;
        this.workflowConnectionMap = workflowConnectionMap;
    }

    @Override
    public Optional<Connection> fetchConnection() {
        return Optional.ofNullable(workflowConnectionMap.entrySet()
            .iterator()
            .next()
            .getValue())
            .map(this::getConnection)
            .map(this::toContextConnection);
    }

    @Override
    public Optional<Connection> fetchConnection(String name) {
        return Optional.ofNullable(workflowConnectionMap.get(name))
            .map(this::getConnection)
            .map(this::toContextConnection);
    }

    @Override
    public Connection getConnection() {
        WorkflowConnection workflowConnection = workflowConnectionMap.entrySet()
            .iterator()
            .next()
            .getValue();

        if (workflowConnection == null) {
            throw new IllegalStateException("Connection is not defined");
        }

        return toContextConnection(getConnection(workflowConnection));
    }

    @Override
    public Connection getConnection(String name) {
        return toContextConnection(getConnection(workflowConnectionMap.get(name)));
    }

    @Override
    public InputStream getFileStream(FileEntry fileEntry) {
        return fileStorageService.getFileStream(new com.bytechef.hermes.file.storage.domain.FileEntry(
            fileEntry.getName(), fileEntry.getExtension(), fileEntry.getMimeType(), fileEntry.getUrl()));
    }

    @Override
    public void publishActionProgressEvent(int progress) {
        eventPublisher.publishEvent(new TaskProgressedWorkflowEvent(taskExecutionId, progress));
    }

    @Override
    public String readFileToString(FileEntry fileEntry) {
        return fileStorageService.readFileToString(new com.bytechef.hermes.file.storage.domain.FileEntry(
            fileEntry.getName(), fileEntry.getExtension(), fileEntry.getMimeType(), fileEntry.getUrl()));
    }

    @Override
    public FileEntry storeFileContent(String fileName, String data) {
        return toContextFileEntry(fileStorageService.storeFileContent(fileName, data));
    }

    @Override
    public FileEntry storeFileContent(String fileName, InputStream inputStream) {
        try {
            return toContextFileEntry(fileStorageService.storeFileContent(fileName, inputStream));
        } catch (Exception exception) {
            throw new ComponentExecutionException("Unable to store file " + fileName, exception);
        }
    }

    private com.bytechef.hermes.connection.domain.Connection getConnection(WorkflowConnection workflowConnection) {
        return connectionService.getConnection(
            workflowConnection.getComponentName(), workflowConnection.getConnectionVersion());
    }

    private FileEntry toContextFileEntry(com.bytechef.hermes.file.storage.domain.FileEntry fileEntry) {
        return new ContextFileEntry(fileEntry);
    }

    private Connection toContextConnection(com.bytechef.hermes.connection.domain.Connection connection) {
        return new ContextConnectionImpl(
            connection.getAuthorizationName(), connection.getComponentName(), connectionDefinitionService,
            connection.getConnectionVersion(), connection.getParameters());
    }

    private static class ContextFileEntryConverter implements Converter<Map<?, ?>, FileEntry> {

        @Override
        public Context.FileEntry convert(Map<?, ?> source) {
            return new ContextFileEntry(
                (String) source.get("extension"),
                (String) source.get("mimeType"),
                (String) source.get("name"),
                (String) source.get("url"));
        }
    }

    public static class ContextFileEntry implements FileEntry {

        private final String extension;
        private final String mimeType;
        private final String name;
        private final String url;

        public ContextFileEntry(String extension, String mimeType, String name, String url) {
            this.extension = extension;
            this.mimeType = mimeType;
            this.name = name;
            this.url = url;
        }

        public ContextFileEntry(com.bytechef.hermes.file.storage.domain.FileEntry fileEntry) {
            this(fileEntry.getExtension(), fileEntry.getMimeType(), fileEntry.getName(), fileEntry.getUrl());
        }

        @Override
        public String getExtension() {
            return extension;
        }

        @Override
        public String getMimeType() {
            return mimeType;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            return "ContextFileEntry{" +
                "extension='" + extension + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
        }
    }
}
