/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Configuration API
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
  ComponentDefinitionBasicModel,
  ComponentDefinitionModel,
} from '../models/index';
import {
    ComponentDefinitionBasicModelFromJSON,
    ComponentDefinitionBasicModelToJSON,
    ComponentDefinitionModelFromJSON,
    ComponentDefinitionModelToJSON,
} from '../models/index';

export interface GetComponentDefinitionRequest {
    componentName: string;
    componentVersion?: number;
}

export interface GetComponentDefinitionVersionsRequest {
    componentName: string;
}

export interface GetComponentDefinitionsRequest {
    actionDefinitions?: boolean;
    connectionDefinitions?: boolean;
    triggerDefinitions?: boolean;
    include?: Array<string>;
}

/**
 * 
 */
export class ComponentDefinitionApi extends runtime.BaseAPI {

    /**
     * Get a component definition.
     * Get a component definition
     */
    async getComponentDefinitionRaw(requestParameters: GetComponentDefinitionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<ComponentDefinitionModel>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentDefinition.');
        }

        const queryParameters: any = {};

        if (requestParameters.componentVersion !== undefined) {
            queryParameters['componentVersion'] = requestParameters.componentVersion;
        }

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/component-definitions/{componentName}`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => ComponentDefinitionModelFromJSON(jsonValue));
    }

    /**
     * Get a component definition.
     * Get a component definition
     */
    async getComponentDefinition(requestParameters: GetComponentDefinitionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<ComponentDefinitionModel> {
        const response = await this.getComponentDefinitionRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get all component definition versions of a component.
     * Get all component definition versions of a component
     */
    async getComponentDefinitionVersionsRaw(requestParameters: GetComponentDefinitionVersionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<ComponentDefinitionBasicModel>>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentDefinitionVersions.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/component-definitions/{componentName}/versions`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(ComponentDefinitionBasicModelFromJSON));
    }

    /**
     * Get all component definition versions of a component.
     * Get all component definition versions of a component
     */
    async getComponentDefinitionVersions(requestParameters: GetComponentDefinitionVersionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<ComponentDefinitionBasicModel>> {
        const response = await this.getComponentDefinitionVersionsRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get all component definitions.
     * Get all component definitions
     */
    async getComponentDefinitionsRaw(requestParameters: GetComponentDefinitionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<ComponentDefinitionBasicModel>>> {
        const queryParameters: any = {};

        if (requestParameters.actionDefinitions !== undefined) {
            queryParameters['actionDefinitions'] = requestParameters.actionDefinitions;
        }

        if (requestParameters.connectionDefinitions !== undefined) {
            queryParameters['connectionDefinitions'] = requestParameters.connectionDefinitions;
        }

        if (requestParameters.triggerDefinitions !== undefined) {
            queryParameters['triggerDefinitions'] = requestParameters.triggerDefinitions;
        }

        if (requestParameters.include) {
            queryParameters['include'] = requestParameters.include;
        }

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/component-definitions`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(ComponentDefinitionBasicModelFromJSON));
    }

    /**
     * Get all component definitions.
     * Get all component definitions
     */
    async getComponentDefinitions(requestParameters: GetComponentDefinitionsRequest = {}, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<ComponentDefinitionBasicModel>> {
        const response = await this.getComponentDefinitionsRaw(requestParameters, initOverrides);
        return await response.value();
    }

}
