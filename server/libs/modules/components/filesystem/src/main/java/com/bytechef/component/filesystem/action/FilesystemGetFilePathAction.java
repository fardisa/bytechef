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

package com.bytechef.component.filesystem.action;

import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.filesystem.constant.FilesystemConstants.FILENAME;
import static com.bytechef.component.filesystem.constant.FilesystemConstants.GET_FILE_PATH;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import com.bytechef.component.definition.Parameters;
import java.io.File;
import java.util.Map;

/**
 * @author Ivica Cardic
 */
public class FilesystemGetFilePathAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(GET_FILE_PATH)
        .title("File Path")
        .description(
            "Gets the full path from a full filename, which is the prefix + path, and also excluding the final directory separator.")
        .properties(string(FILENAME)
            .label("Filename")
            .description("The path to full filename.")
            .placeholder("/data/your_file.pdf")
            .required(true))
        .outputSchema(string())
        .sampleOutput("/sample_data")
        .perform(FilesystemGetFilePathAction::perform);

    /**
     * Gets the full path from a full filename, which is the prefix + path, and also excluding the final directory
     * separator.
     *
     * <p>
     * This method will handle a file in either Unix or Windows format. The method is entirely text based and returns
     * the text before the last forward or backslash.
     */
    protected static Map<String, ?> perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext context) {

        String filename = inputParameters.getRequiredString(FILENAME);

        return Map.of("path", filename.substring(0, filename.lastIndexOf(File.separator)));
    }
}
