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

package com.bytechef.task.dispatcher.loop;

import static com.bytechef.platform.workflow.task.dispatcher.definition.TaskDispatcherDSL.array;
import static com.bytechef.platform.workflow.task.dispatcher.definition.TaskDispatcherDSL.bool;
import static com.bytechef.platform.workflow.task.dispatcher.definition.TaskDispatcherDSL.integer;
import static com.bytechef.platform.workflow.task.dispatcher.definition.TaskDispatcherDSL.task;
import static com.bytechef.platform.workflow.task.dispatcher.definition.TaskDispatcherDSL.taskDispatcher;
import static com.bytechef.task.dispatcher.loop.constant.LoopTaskDispatcherConstants.INDEX;
import static com.bytechef.task.dispatcher.loop.constant.LoopTaskDispatcherConstants.ITEM;
import static com.bytechef.task.dispatcher.loop.constant.LoopTaskDispatcherConstants.ITERATEE;
import static com.bytechef.task.dispatcher.loop.constant.LoopTaskDispatcherConstants.LIST;
import static com.bytechef.task.dispatcher.loop.constant.LoopTaskDispatcherConstants.LOOP;
import static com.bytechef.task.dispatcher.loop.constant.LoopTaskDispatcherConstants.LOOP_FOREVER;

import com.bytechef.commons.util.MapUtils;
import com.bytechef.platform.registry.util.SchemaUtils;
import com.bytechef.platform.workflow.task.dispatcher.TaskDispatcherDefinitionFactory;
import com.bytechef.platform.workflow.task.dispatcher.definition.Property;
import com.bytechef.platform.workflow.task.dispatcher.definition.PropertyFactoryFunction;
import com.bytechef.platform.workflow.task.dispatcher.definition.TaskDispatcherDefinition;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author Ivica Cardic
 */
@Component
public class LoopTaskDispatcherDefinitionFactory implements TaskDispatcherDefinitionFactory {

    private static final TaskDispatcherDefinition TASK_DISPATCHER_DEFINITION = taskDispatcher(LOOP)
        .title("Loop")
        .description("Loops sequentially over list of items.")
        .icon("path:assets/loop.svg")
        .properties(
            array(LIST).label("List of items")
                .description("List of items to iterate over."),
            bool(LOOP_FOREVER)
                .label("Loop Forever")
                .description("Should loop iterate until condition set by 'Loop Break' statement is met.")
                .defaultValue(false))
        .taskProperties(task(ITERATEE))
        .variableProperties(LoopTaskDispatcherDefinitionFactory::getVariableProperties);

    @Override
    public TaskDispatcherDefinition getDefinition() {
        return TASK_DISPATCHER_DEFINITION;
    }

    private static List<Property> getVariableProperties(Map<String, ?> inputParameters) {
        List<Property> properties;

        List<?> list = MapUtils.getRequiredList(inputParameters, LIST);

        if (list.isEmpty()) {
            properties = List.of();
        } else {
            properties = List.of(
                (Property.ValueProperty<?>) SchemaUtils.getSchemaDefinition(
                    ITEM, new PropertyFactoryFunction(list.getFirst())),
                integer(INDEX));
        }

        return properties;
    }
}
