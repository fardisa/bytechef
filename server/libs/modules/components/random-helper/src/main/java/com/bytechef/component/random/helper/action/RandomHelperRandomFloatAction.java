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

package com.bytechef.component.random.helper.action;

import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.integer;
import static com.bytechef.component.definition.ComponentDSL.number;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.random.helper.constant.RandomHelperConstants;

/**
 * @author Ivica Cardic
 */
public class RandomHelperRandomFloatAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(RandomHelperConstants.RANDOM_FLOAT)
        .title("Float")
        .description("Generates a random float value.")
        .properties(
            integer(RandomHelperConstants.START_INCLUSIVE)
                .description("The minimum possible generated value.")
                .required(true)
                .defaultValue(0),
            integer(RandomHelperConstants.END_INCLUSIVE)
                .description("The maximum possible generated value.")
                .required(true)
                .defaultValue(100))
        .outputSchema(number())
        .perform(RandomHelperRandomFloatAction::perform);

    /**
     * Generates a random float.
     */
    protected static Object perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext context) {

        int startInclusive = inputParameters.getInteger(RandomHelperConstants.START_INCLUSIVE, 0);
        int endInclusive = inputParameters.getInteger(RandomHelperConstants.END_INCLUSIVE, 100);

        return nextFloat(startInclusive, endInclusive);
    }

    private static float nextFloat(final float startInclusive, final float endExclusive) {
        if (endExclusive < startInclusive) {
            throw new IllegalArgumentException("Start value must be smaller or equal to end value");
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException("Both range values must be non-negative");
        }

        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + ((endExclusive - startInclusive) * RandomHelperConstants.RANDOM.nextFloat());
    }
}
