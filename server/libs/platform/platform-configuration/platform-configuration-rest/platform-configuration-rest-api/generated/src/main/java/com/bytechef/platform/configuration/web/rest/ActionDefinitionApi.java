/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.platform.configuration.web.rest;

import com.bytechef.platform.configuration.web.rest.model.ActionDefinitionBasicModel;
import com.bytechef.platform.configuration.web.rest.model.ActionDefinitionModel;
import com.bytechef.platform.configuration.web.rest.model.ComponentOperationRequestModel;
import com.bytechef.platform.configuration.web.rest.model.ComponentOutputSchemaModel;
import com.bytechef.platform.configuration.web.rest.model.OptionModel;
import com.bytechef.platform.configuration.web.rest.model.PropertyModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-19T11:58:57.058637+01:00[Europe/Zagreb]")
@Validated
@Tag(name = "action-definition", description = "The Platform Action Definition API")
public interface ActionDefinitionApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /action-definitions : Get all action definitions
     * Get all action definitions.
     *
     * @param taskTypes The list of task types defined in workflows.(E.g. mailchimp/v1/addMemberToList) (optional)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getActionDefinitions",
        summary = "Get all action definitions",
        description = "Get all action definitions.",
        tags = { "action-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ActionDefinitionModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/action-definitions",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ActionDefinitionModel>> getActionDefinitions(
        @Parameter(name = "taskTypes", description = "The list of task types defined in workflows.(E.g. mailchimp/v1/addMemberToList)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "taskTypes", required = false) List<String> taskTypes
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputSchema\" : { \"definition\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, \"sampleOutput\" : \"{}\" }, \"editorDescriptionDataSource\" : true, \"name\" : \"name\", \"description\" : \"description\", \"outputSchemaDataSource\" : true, \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputSchema\" : { \"definition\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, \"sampleOutput\" : \"{}\" }, \"editorDescriptionDataSource\" : true, \"name\" : \"name\", \"description\" : \"description\", \"outputSchemaDataSource\" : true, \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName} : Get an action definition of a component
     * Get an action definition of a component.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @param actionName The name of the action to get. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getComponentActionDefinition",
        summary = "Get an action definition of a component",
        description = "Get an action definition of a component.",
        tags = { "action-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ActionDefinitionModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ActionDefinitionModel> getComponentActionDefinition(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "actionName", description = "The name of the action to get.", required = true, in = ParameterIn.PATH) @PathVariable("actionName") String actionName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputSchema\" : { \"definition\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, \"sampleOutput\" : \"{}\" }, \"editorDescriptionDataSource\" : true, \"name\" : \"name\", \"description\" : \"description\", \"outputSchemaDataSource\" : true, \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /component-definitions/{componentName}/{componentVersion}/action-definitions : Get a list of action definitions for a component
     * Get a list of action definitions for a component.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getComponentActionDefinitions",
        summary = "Get a list of action definitions for a component",
        description = "Get a list of action definitions for a component.",
        tags = { "action-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ActionDefinitionBasicModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/component-definitions/{componentName}/{componentVersion}/action-definitions",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ActionDefinitionBasicModel>> getComponentActionDefinitions(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"name\" : \"name\", \"description\" : \"description\", \"title\" : \"title\" }, { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"name\" : \"name\", \"description\" : \"description\", \"title\" : \"title\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/editor-description : Get an action description shown in the editor
     * Get an action description shown in the editor.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @param actionName The name of an action. (required)
     * @param componentOperationRequestModel  (optional)
     * @return The editor description. (status code 200)
     */
    @Operation(
        operationId = "getComponentActionEditorDescription",
        summary = "Get an action description shown in the editor",
        description = "Get an action description shown in the editor.",
        tags = { "action-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The editor description.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/editor-description",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<String> getComponentActionEditorDescription(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "actionName", description = "The name of an action.", required = true, in = ParameterIn.PATH) @PathVariable("actionName") String actionName,
        @Parameter(name = "ComponentOperationRequestModel", description = "") @Valid @RequestBody(required = false) ComponentOperationRequestModel componentOperationRequestModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/output-schema : Get an action output schema shown in the editor
     * Get an action output schema shown in the editor.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @param actionName The name of an action. (required)
     * @param componentOperationRequestModel  (optional)
     * @return The output schema. (status code 200)
     */
    @Operation(
        operationId = "getComponentActionOutputSchema",
        summary = "Get an action output schema shown in the editor",
        description = "Get an action output schema shown in the editor.",
        tags = { "action-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The output schema.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ComponentOutputSchemaModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/output-schema",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<ComponentOutputSchemaModel> getComponentActionOutputSchema(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "actionName", description = "The name of an action.", required = true, in = ParameterIn.PATH) @PathVariable("actionName") String actionName,
        @Parameter(name = "ComponentOperationRequestModel", description = "") @Valid @RequestBody(required = false) ComponentOperationRequestModel componentOperationRequestModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"definition\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, \"sampleOutput\" : \"{}\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/properties/{propertyName}/dynamic-properties : Get dynamic properties for an action property shown in the editor
     * Get dynamic properties for an action property shown in the editor.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @param actionName The name of an action. (required)
     * @param propertyName The name of a property. (required)
     * @param componentOperationRequestModel  (optional)
     * @return The list of options. (status code 200)
     */
    @Operation(
        operationId = "getComponentActionPropertyDynamicProperties",
        summary = "Get dynamic properties for an action property shown in the editor",
        description = "Get dynamic properties for an action property shown in the editor.",
        tags = { "action-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of options.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PropertyModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/properties/{propertyName}/dynamic-properties",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<List<PropertyModel>> getComponentActionPropertyDynamicProperties(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "actionName", description = "The name of an action.", required = true, in = ParameterIn.PATH) @PathVariable("actionName") String actionName,
        @Parameter(name = "propertyName", description = "The name of a property.", required = true, in = ParameterIn.PATH) @PathVariable("propertyName") String propertyName,
        @Parameter(name = "ComponentOperationRequestModel", description = "") @Valid @RequestBody(required = false) ComponentOperationRequestModel componentOperationRequestModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/properties/{propertyName}/options : Get an action property options shown in the editor
     * Get an action property options shown in the editor.
     *
     * @param componentName The name of a component. (required)
     * @param componentVersion The version of a component. (required)
     * @param actionName The name of an action. (required)
     * @param propertyName The name of a property. (required)
     * @param searchText Optional search text used to filter option items (optional)
     * @param componentOperationRequestModel  (optional)
     * @return The list of options. (status code 200)
     */
    @Operation(
        operationId = "getComponentActionPropertyOptions",
        summary = "Get an action property options shown in the editor",
        description = "Get an action property options shown in the editor.",
        tags = { "action-definition" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of options.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OptionModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/properties/{propertyName}/options",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<List<OptionModel>> getComponentActionPropertyOptions(
        @Parameter(name = "componentName", description = "The name of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentName") String componentName,
        @Parameter(name = "componentVersion", description = "The version of a component.", required = true, in = ParameterIn.PATH) @PathVariable("componentVersion") Integer componentVersion,
        @Parameter(name = "actionName", description = "The name of an action.", required = true, in = ParameterIn.PATH) @PathVariable("actionName") String actionName,
        @Parameter(name = "propertyName", description = "The name of a property.", required = true, in = ParameterIn.PATH) @PathVariable("propertyName") String propertyName,
        @Parameter(name = "searchText", description = "Optional search text used to filter option items", in = ParameterIn.QUERY) @Valid @RequestParam(value = "searchText", required = false) String searchText,
        @Parameter(name = "ComponentOperationRequestModel", description = "") @Valid @RequestBody(required = false) ComponentOperationRequestModel componentOperationRequestModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"displayCondition\" : \"displayCondition\", \"description\" : \"description\", \"label\" : \"label\", \"value\" : \"\" }, { \"displayCondition\" : \"displayCondition\", \"description\" : \"description\", \"label\" : \"label\", \"value\" : \"\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
