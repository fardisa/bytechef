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

package com.integri.atlas.task.handler.xmlhelpers.v1_0;

import static com.integri.atlas.task.descriptor.model.DSL.ANY_PROPERTY;
import static com.integri.atlas.task.descriptor.model.DSL.ARRAY_PROPERTY;
import static com.integri.atlas.task.descriptor.model.DSL.OBJECT_PROPERTY;
import static com.integri.atlas.task.descriptor.model.DSL.OPERATION;
import static com.integri.atlas.task.descriptor.model.DSL.STRING_PROPERTY;
import static com.integri.atlas.task.handler.xmlhelpers.XmlHelpersTaskConstants.SOURCE;
import static com.integri.atlas.task.handler.xmlhelpers.XmlHelpersTaskConstants.VERSION_1_0;
import static com.integri.atlas.task.handler.xmlhelpers.XmlHelpersTaskConstants.XML_HELPERS;

import com.integri.atlas.task.descriptor.handler.TaskDescriptorHandler;
import com.integri.atlas.task.descriptor.model.DSL;
import com.integri.atlas.task.descriptor.model.TaskDescriptor;
import com.integri.atlas.task.handler.xmlhelpers.XmlHelpersTaskConstants;
import org.springframework.stereotype.Component;

/**
 * @author Ivica Cardic
 */
@Component
public class XmlHelpersTaskDescriptorHandler implements TaskDescriptorHandler {

    private static final TaskDescriptor TASK_DESCRIPTOR = DSL
        .createTaskDescriptor(XML_HELPERS)
        .displayName("XML Helpers")
        .description("Converts between XML string and object/array.")
        .version(VERSION_1_0)
        .operations(
            OPERATION(XmlHelpersTaskConstants.PARSE)
                .displayName("Convert from XML string")
                .description("Converts the XML string to object/array.")
                .inputs(
                    STRING_PROPERTY(SOURCE)
                        .displayName("Source")
                        .description("The XML string to convert to the data.")
                        .required(true)
                )
                .outputs(OBJECT_PROPERTY()),
            OPERATION(XmlHelpersTaskConstants.STRINGIFY)
                .displayName("Convert to XML string")
                .description("Writes the object/array to a XML string.")
                .inputs(
                    ANY_PROPERTY(SOURCE)
                        .displayName("Source")
                        .description("The data to convert to XML string.")
                        .required(true)
                        .types(ARRAY_PROPERTY(), OBJECT_PROPERTY())
                )
                .outputs(STRING_PROPERTY())
        );

    @Override
    public TaskDescriptor getTaskDescriptor() {
        return TASK_DESCRIPTOR;
    }
}
