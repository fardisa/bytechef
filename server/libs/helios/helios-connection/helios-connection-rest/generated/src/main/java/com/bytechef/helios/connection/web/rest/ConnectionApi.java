/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.helios.connection.web.rest;

import com.bytechef.helios.connection.web.rest.model.ConnectionModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-02T11:55:59.203171+01:00[Europe/Zagreb]")
@Validated
@Tag(name = "connection", description = "The Automation Connection API")
public interface ConnectionApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /connections : Create a new connection
     * Create a new connection.
     *
     * @param connectionModel  (required)
     * @return The connection object. (status code 200)
     */
    @Operation(
        operationId = "createConnection",
        summary = "Create a new connection",
        description = "Create a new connection.",
        tags = { "connection" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The connection object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectionModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/connections",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ConnectionModel> createConnection(
        @Parameter(name = "ConnectionModel", description = "", required = true) @Valid @RequestBody ConnectionModel connectionModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"authorizationName\" : \"authorizationName\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"active\" : true, \"tags\" : [ { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 }, { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 } ], \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"componentName\" : \"componentName\", \"id\" : 6, \"parameters\" : { \"key\" : \"{}\" }, \"connectionVersion\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /connections/{id} : Delete a connection
     * Delete a connection.
     *
     * @param id The id of a connection. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "deleteConnection",
        summary = "Delete a connection",
        description = "Delete a connection.",
        tags = { "connection" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/connections/{id}"
    )
    default ResponseEntity<Void> deleteConnection(
        @Parameter(name = "id", description = "The id of a connection.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /connections/{id} : Get a connection by id
     * Get a connection by id.
     *
     * @param id The id of a connection. (required)
     * @return The connection object. (status code 200)
     */
    @Operation(
        operationId = "getConnection",
        summary = "Get a connection by id",
        description = "Get a connection by id.",
        tags = { "connection" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The connection object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectionModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/connections/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<ConnectionModel> getConnection(
        @Parameter(name = "id", description = "The id of a connection.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"authorizationName\" : \"authorizationName\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"active\" : true, \"tags\" : [ { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 }, { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 } ], \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"componentName\" : \"componentName\", \"id\" : 6, \"parameters\" : { \"key\" : \"{}\" }, \"connectionVersion\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /connections : Get all connections
     * Get all connections.
     *
     * @param componentName The component name used for filtering connections. (optional)
     * @param connectionVersion The connection version. (optional)
     * @param tagId The tag id of used for filtering connections. (optional)
     * @return A list of connections. (status code 200)
     */
    @Operation(
        operationId = "getConnections",
        summary = "Get all connections",
        description = "Get all connections.",
        tags = { "connection" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of connections.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ConnectionModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/connections",
        produces = { "application/json" }
    )
    default ResponseEntity<List<ConnectionModel>> getConnections(
        @Parameter(name = "componentName", description = "The component name used for filtering connections.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "componentName", required = false) String componentName,
        @Parameter(name = "connectionVersion", description = "The connection version.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "connectionVersion", required = false) Integer connectionVersion,
        @Parameter(name = "tagId", description = "The tag id of used for filtering connections.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "tagId", required = false) Long tagId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"authorizationName\" : \"authorizationName\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"active\" : true, \"tags\" : [ { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 }, { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 } ], \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"componentName\" : \"componentName\", \"id\" : 6, \"parameters\" : { \"key\" : \"{}\" }, \"connectionVersion\" : 0 }, { \"authorizationName\" : \"authorizationName\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"active\" : true, \"tags\" : [ { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 }, { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 } ], \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"componentName\" : \"componentName\", \"id\" : 6, \"parameters\" : { \"key\" : \"{}\" }, \"connectionVersion\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /connections/{id} : Update an existing connection
     * Update an existing connection.
     *
     * @param id The id of a connection. (required)
     * @param connectionModel  (required)
     * @return The updated connection object. (status code 200)
     */
    @Operation(
        operationId = "updateConnection",
        summary = "Update an existing connection",
        description = "Update an existing connection.",
        tags = { "connection" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The updated connection object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConnectionModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/connections/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ConnectionModel> updateConnection(
        @Parameter(name = "id", description = "The id of a connection.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "ConnectionModel", description = "", required = true) @Valid @RequestBody ConnectionModel connectionModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"authorizationName\" : \"authorizationName\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"active\" : true, \"tags\" : [ { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 }, { \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 1 } ], \"__version\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"name\" : \"name\", \"componentName\" : \"componentName\", \"id\" : 6, \"parameters\" : { \"key\" : \"{}\" }, \"connectionVersion\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
