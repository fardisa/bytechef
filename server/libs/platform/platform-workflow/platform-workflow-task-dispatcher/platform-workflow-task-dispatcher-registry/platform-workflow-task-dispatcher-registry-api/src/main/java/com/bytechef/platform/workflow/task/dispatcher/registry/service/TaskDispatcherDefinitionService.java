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

package com.bytechef.platform.workflow.task.dispatcher.registry.service;

import com.bytechef.platform.workflow.task.dispatcher.registry.domain.OutputSchema;
import com.bytechef.platform.workflow.task.dispatcher.registry.domain.TaskDispatcherDefinition;
import java.util.List;
import java.util.Map;

/**
 * @author Ivica Cardic
 */
public interface TaskDispatcherDefinitionService {

    OutputSchema executeOutputSchema(String name, int version, Map<String, Object> inputParameters);

    TaskDispatcherDefinition getTaskDispatcherDefinition(String name, Integer version);

    List<TaskDispatcherDefinition> getTaskDispatcherDefinitions();

    List<TaskDispatcherDefinition> getTaskDispatcherDefinitionVersions(String name);
}
