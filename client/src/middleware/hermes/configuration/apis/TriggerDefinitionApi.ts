/* tslint:disable */
/* eslint-disable */
/**
 * Core Workflow API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import * as runtime from '../runtime';
import type {
  ComponentOperationRequestModel,
  OptionModel,
  PropertyModel,
  TriggerDefinitionBasicModel,
  TriggerDefinitionModel,
} from '../models/index';
import {
    ComponentOperationRequestModelFromJSON,
    ComponentOperationRequestModelToJSON,
    OptionModelFromJSON,
    OptionModelToJSON,
    PropertyModelFromJSON,
    PropertyModelToJSON,
    TriggerDefinitionBasicModelFromJSON,
    TriggerDefinitionBasicModelToJSON,
    TriggerDefinitionModelFromJSON,
    TriggerDefinitionModelToJSON,
} from '../models/index';

export interface GetComponentTriggerDefinitionRequest {
    componentName: string;
    componentVersion: number;
    triggerName: string;
}

export interface GetComponentTriggerDefinitionsRequest {
    componentName: string;
    componentVersion: number;
}

export interface GetComponentTriggerEditorDescriptionRequest {
    componentName: string;
    componentVersion: number;
    triggerName: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

export interface GetComponentTriggerOutputSchemaRequest {
    componentName: string;
    componentVersion: number;
    triggerName: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

export interface GetComponentTriggerPropertyDynamicPropertiesRequest {
    componentName: string;
    componentVersion: number;
    triggerName: string;
    propertyName: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

export interface GetComponentTriggerPropertyOptionsRequest {
    componentName: string;
    componentVersion: number;
    triggerName: string;
    propertyName: string;
    searchText?: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

export interface GetComponentTriggerSampleOutputRequest {
    componentName: string;
    componentVersion: number;
    triggerName: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

export interface GetTriggerDefinitionsRequest {
    triggerTypes?: Array<string>;
}

/**
 * 
 */
export class TriggerDefinitionApi extends runtime.BaseAPI {

    /**
     * Get a trigger definition of a component.
     * Get a trigger definition of a component
     */
    async getComponentTriggerDefinitionRaw(requestParameters: GetComponentTriggerDefinitionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<TriggerDefinitionModel>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentTriggerDefinition.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentTriggerDefinition.');
        }

        if (requestParameters.triggerName === null || requestParameters.triggerName === undefined) {
            throw new runtime.RequiredError('triggerName','Required parameter requestParameters.triggerName was null or undefined when calling getComponentTriggerDefinition.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"triggerName"}}`, encodeURIComponent(String(requestParameters.triggerName))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => TriggerDefinitionModelFromJSON(jsonValue));
    }

    /**
     * Get a trigger definition of a component.
     * Get a trigger definition of a component
     */
    async getComponentTriggerDefinition(requestParameters: GetComponentTriggerDefinitionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<TriggerDefinitionModel> {
        const response = await this.getComponentTriggerDefinitionRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get a list of trigger definitionss for a component.
     * Get a list of trigger definitionss for a component
     */
    async getComponentTriggerDefinitionsRaw(requestParameters: GetComponentTriggerDefinitionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<TriggerDefinitionBasicModel>>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentTriggerDefinitions.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentTriggerDefinitions.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/trigger-definitions`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(TriggerDefinitionBasicModelFromJSON));
    }

    /**
     * Get a list of trigger definitionss for a component.
     * Get a list of trigger definitionss for a component
     */
    async getComponentTriggerDefinitions(requestParameters: GetComponentTriggerDefinitionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<TriggerDefinitionBasicModel>> {
        const response = await this.getComponentTriggerDefinitionsRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get an trigger description shown in the editor.
     * Get an trigger description shown in the editor
     */
    async getComponentTriggerEditorDescriptionRaw(requestParameters: GetComponentTriggerEditorDescriptionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<string>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentTriggerEditorDescription.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentTriggerEditorDescription.');
        }

        if (requestParameters.triggerName === null || requestParameters.triggerName === undefined) {
            throw new runtime.RequiredError('triggerName','Required parameter requestParameters.triggerName was null or undefined when calling getComponentTriggerEditorDescription.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/editor-description`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"triggerName"}}`, encodeURIComponent(String(requestParameters.triggerName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        if (this.isJsonMime(response.headers.get('content-type'))) {
            return new runtime.JSONApiResponse<string>(response);
        } else {
            return new runtime.TextApiResponse(response) as any;
        }
    }

    /**
     * Get an trigger description shown in the editor.
     * Get an trigger description shown in the editor
     */
    async getComponentTriggerEditorDescription(requestParameters: GetComponentTriggerEditorDescriptionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<string> {
        const response = await this.getComponentTriggerEditorDescriptionRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get a trigger output schema shown in the editor.
     * Get a trigger output schema shown in the editor
     */
    async getComponentTriggerOutputSchemaRaw(requestParameters: GetComponentTriggerOutputSchemaRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<PropertyModel>>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentTriggerOutputSchema.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentTriggerOutputSchema.');
        }

        if (requestParameters.triggerName === null || requestParameters.triggerName === undefined) {
            throw new runtime.RequiredError('triggerName','Required parameter requestParameters.triggerName was null or undefined when calling getComponentTriggerOutputSchema.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/output-schema`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"triggerName"}}`, encodeURIComponent(String(requestParameters.triggerName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(PropertyModelFromJSON));
    }

    /**
     * Get a trigger output schema shown in the editor.
     * Get a trigger output schema shown in the editor
     */
    async getComponentTriggerOutputSchema(requestParameters: GetComponentTriggerOutputSchemaRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<PropertyModel>> {
        const response = await this.getComponentTriggerOutputSchemaRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get dynamic properties for a trigger property shown in the editor.
     * Get dynamic properties for a trigger property shown in the editor
     */
    async getComponentTriggerPropertyDynamicPropertiesRaw(requestParameters: GetComponentTriggerPropertyDynamicPropertiesRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<PropertyModel>>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentTriggerPropertyDynamicProperties.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentTriggerPropertyDynamicProperties.');
        }

        if (requestParameters.triggerName === null || requestParameters.triggerName === undefined) {
            throw new runtime.RequiredError('triggerName','Required parameter requestParameters.triggerName was null or undefined when calling getComponentTriggerPropertyDynamicProperties.');
        }

        if (requestParameters.propertyName === null || requestParameters.propertyName === undefined) {
            throw new runtime.RequiredError('propertyName','Required parameter requestParameters.propertyName was null or undefined when calling getComponentTriggerPropertyDynamicProperties.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/properties/{propertyName}/dynamic-properties`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"triggerName"}}`, encodeURIComponent(String(requestParameters.triggerName))).replace(`{${"propertyName"}}`, encodeURIComponent(String(requestParameters.propertyName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(PropertyModelFromJSON));
    }

    /**
     * Get dynamic properties for a trigger property shown in the editor.
     * Get dynamic properties for a trigger property shown in the editor
     */
    async getComponentTriggerPropertyDynamicProperties(requestParameters: GetComponentTriggerPropertyDynamicPropertiesRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<PropertyModel>> {
        const response = await this.getComponentTriggerPropertyDynamicPropertiesRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get a trigger property options shown in the editor.
     * Get a trigger property options shown in the editor
     */
    async getComponentTriggerPropertyOptionsRaw(requestParameters: GetComponentTriggerPropertyOptionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<OptionModel>>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentTriggerPropertyOptions.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentTriggerPropertyOptions.');
        }

        if (requestParameters.triggerName === null || requestParameters.triggerName === undefined) {
            throw new runtime.RequiredError('triggerName','Required parameter requestParameters.triggerName was null or undefined when calling getComponentTriggerPropertyOptions.');
        }

        if (requestParameters.propertyName === null || requestParameters.propertyName === undefined) {
            throw new runtime.RequiredError('propertyName','Required parameter requestParameters.propertyName was null or undefined when calling getComponentTriggerPropertyOptions.');
        }

        const queryParameters: any = {};

        if (requestParameters.searchText !== undefined) {
            queryParameters['searchText'] = requestParameters.searchText;
        }

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/properties/{propertyName}/options`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"triggerName"}}`, encodeURIComponent(String(requestParameters.triggerName))).replace(`{${"propertyName"}}`, encodeURIComponent(String(requestParameters.propertyName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(OptionModelFromJSON));
    }

    /**
     * Get a trigger property options shown in the editor.
     * Get a trigger property options shown in the editor
     */
    async getComponentTriggerPropertyOptions(requestParameters: GetComponentTriggerPropertyOptionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<OptionModel>> {
        const response = await this.getComponentTriggerPropertyOptionsRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get a trigger sample output shown in the editor.
     * Get a trigger sample output shown in the editor
     */
    async getComponentTriggerSampleOutputRaw(requestParameters: GetComponentTriggerSampleOutputRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<object>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentTriggerSampleOutput.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentTriggerSampleOutput.');
        }

        if (requestParameters.triggerName === null || requestParameters.triggerName === undefined) {
            throw new runtime.RequiredError('triggerName','Required parameter requestParameters.triggerName was null or undefined when calling getComponentTriggerSampleOutput.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/trigger-definitions/{triggerName}/sample-output`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"triggerName"}}`, encodeURIComponent(String(requestParameters.triggerName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        return new runtime.JSONApiResponse<any>(response);
    }

    /**
     * Get a trigger sample output shown in the editor.
     * Get a trigger sample output shown in the editor
     */
    async getComponentTriggerSampleOutput(requestParameters: GetComponentTriggerSampleOutputRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<object> {
        const response = await this.getComponentTriggerSampleOutputRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get all trigger definitions.
     * Get all trigger definitions
     */
    async getTriggerDefinitionsRaw(requestParameters: GetTriggerDefinitionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<TriggerDefinitionModel>>> {
        const queryParameters: any = {};

        if (requestParameters.triggerTypes) {
            queryParameters['triggerTypes'] = requestParameters.triggerTypes;
        }

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/trigger-definitions`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(TriggerDefinitionModelFromJSON));
    }

    /**
     * Get all trigger definitions.
     * Get all trigger definitions
     */
    async getTriggerDefinitions(requestParameters: GetTriggerDefinitionsRequest = {}, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<TriggerDefinitionModel>> {
        const response = await this.getTriggerDefinitionsRaw(requestParameters, initOverrides);
        return await response.value();
    }

}
