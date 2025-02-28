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

package com.bytechef.platform.component.definition;

import com.bytechef.commons.util.OptionalUtils;
import com.bytechef.component.definition.ActionDefinition;
import com.bytechef.component.definition.ActionEditorDescriptionFunction;
import com.bytechef.component.definition.ActionOutputSchemaFunction;
import com.bytechef.component.definition.Help;
import com.bytechef.component.definition.OutputSchema;
import com.bytechef.component.definition.Property;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Ivica Cardic
 */
public class ActionDefinitionWrapper implements ActionDefinition {

    protected final Boolean batch;
    protected final String componentName;
    protected final String componentDescription;
    protected final String componentTitle;
    protected final int componentVersion;
    protected final Boolean deprecated;
    protected final String description;
    protected final ActionEditorDescriptionFunction editorDescriptionFunction;
    protected final PerformFunction performFunction;
    protected final Help help;
    protected final Map<String, Object> metadata;
    protected final String name;
    protected final OutputSchema outputSchema;
    protected final ActionOutputSchemaFunction outputSchemaFunction;
    private final boolean outputSchemaDefaultFunction;
    protected final List<? extends Property> properties;
    protected final String title;

    public ActionDefinitionWrapper(
        ActionDefinition actionDefinition, Supplier<PerformFunction> performFunctionSupplier) {

        this.batch = OptionalUtils.orElse(actionDefinition.getBatch(), null);
        this.componentName = actionDefinition.getComponentName();
        this.componentDescription = OptionalUtils.orElse(actionDefinition.getComponentDescription(), null);
        this.componentTitle = OptionalUtils.orElse(actionDefinition.getComponentTitle(), null);
        this.componentVersion = actionDefinition.getComponentVersion();
        this.deprecated = OptionalUtils.orElse(actionDefinition.getDeprecated(), null);
        this.description = OptionalUtils.orElse(actionDefinition.getDescription(), null);
        this.editorDescriptionFunction =
            OptionalUtils.orElse(actionDefinition.getEditorDescriptionFunction(), null);
        this.performFunction = performFunctionSupplier.get();
        this.help = OptionalUtils.orElse(actionDefinition.getHelp(), null);
        this.metadata = OptionalUtils.orElse(actionDefinition.getMetadata(), null);
        this.name = actionDefinition.getName();
        this.outputSchema = OptionalUtils.orElse(actionDefinition.getOutputSchema(), null);
        this.outputSchemaFunction = OptionalUtils.orElse(actionDefinition.getOutputSchemaFunction(), null);
        this.outputSchemaDefaultFunction = actionDefinition.isOutputSchemaDefaultFunction();
        this.properties = OptionalUtils.orElse(actionDefinition.getProperties(), null);
        this.title = OptionalUtils.orElse(actionDefinition.getTitle(), null);
    }

    @Override
    public Optional<Boolean> getBatch() {
        return Optional.ofNullable(batch);
    }

    @Override
    public Optional<Boolean> getDeprecated() {
        return Optional.ofNullable(deprecated);
    }

    @Override
    public Optional<String> getComponentDescription() {
        return Optional.ofNullable(componentDescription);
    }

    @Override
    public String getComponentName() {
        return componentName;
    }

    @Override
    public Optional<String> getComponentTitle() {
        return Optional.ofNullable(componentTitle);
    }

    @Override
    public int getComponentVersion() {
        return componentVersion;
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Override
    public Optional<ActionEditorDescriptionFunction> getEditorDescriptionFunction() {
        return Optional.ofNullable(editorDescriptionFunction);
    }

    @Override
    public Optional<PerformFunction> getPerform() {
        return Optional.ofNullable(performFunction);
    }

    @Override
    public Optional<Help> getHelp() {
        return Optional.ofNullable(help);
    }

    @Override
    public Optional<Map<String, Object>> getMetadata() {
        return Optional.ofNullable(metadata == null ? null : new HashMap<>(metadata));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<OutputSchema> getOutputSchema() {
        return Optional.ofNullable(outputSchema);
    }

    @Override
    public Optional<ActionOutputSchemaFunction> getOutputSchemaFunction() {
        return Optional.ofNullable(outputSchemaFunction);
    }

    @Override
    public Optional<List<? extends Property>> getProperties() {
        return Optional.ofNullable(properties);
    }

    @Override
    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    @Override
    public boolean isOutputSchemaDefaultFunction() {
        return outputSchemaDefaultFunction;
    }
}
