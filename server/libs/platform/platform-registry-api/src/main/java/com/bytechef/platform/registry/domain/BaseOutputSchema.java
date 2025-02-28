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

package com.bytechef.platform.registry.domain;

import java.util.Objects;

/**
 * @author Ivica Cardic
 */
public abstract class BaseOutputSchema<P extends BaseProperty> {

    private final P definition;
    private final Object sampleOutput;

    public BaseOutputSchema(P definition, Object sampleOutput) {
        this.definition = definition;
        this.sampleOutput = sampleOutput;
    }

    public P getDefinition() {
        return definition;
    }

    public Object getSampleOutput() {
        return sampleOutput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BaseOutputSchema<?> that)) {
            return false;
        }

        return Objects.equals(definition, that.definition) && Objects.equals(sampleOutput, that.sampleOutput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(definition, sampleOutput);
    }

    @Override
    public String toString() {
        return "BaseOutputSchema{" +
            "definition=" + definition +
            ", sampleOutput=" + sampleOutput +
            '}';
    }
}
