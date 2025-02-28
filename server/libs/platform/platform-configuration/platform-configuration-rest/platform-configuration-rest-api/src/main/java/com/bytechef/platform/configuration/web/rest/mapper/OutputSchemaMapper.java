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

package com.bytechef.platform.configuration.web.rest.mapper;

import com.bytechef.platform.component.registry.domain.OutputSchema;
import com.bytechef.platform.configuration.web.rest.mapper.config.PlatformConfigurationMapperSpringConfig;
import com.bytechef.platform.configuration.web.rest.model.ComponentOutputSchemaModel;
import com.bytechef.platform.configuration.web.rest.model.TaskDispatcherOutputSchemaModel;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Ivica Cardic
 */
public class OutputSchemaMapper {

    @Mapper(config = PlatformConfigurationMapperSpringConfig.class)
    public interface OutputSchemaComponentMapper extends Converter<OutputSchema, ComponentOutputSchemaModel> {

        @Override
        ComponentOutputSchemaModel convert(OutputSchema outputSchema);
    }

    @Mapper(config = PlatformConfigurationMapperSpringConfig.class)
    public interface OutputSchemaTaskDispatcherMapper
        extends
        Converter<com.bytechef.platform.workflow.task.dispatcher.registry.domain.OutputSchema, TaskDispatcherOutputSchemaModel> {

        @Override
        TaskDispatcherOutputSchemaModel convert(
            com.bytechef.platform.workflow.task.dispatcher.registry.domain.OutputSchema outputSchema);
    }
}
