/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Workflow Test API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface UpdateWorkflowTestConfigurationConnectionRequestModel
 */
export interface UpdateWorkflowTestConfigurationConnectionRequestModel {
    /**
     * 
     * @type {number}
     * @memberof UpdateWorkflowTestConfigurationConnectionRequestModel
     */
    connectionId?: number;
}

/**
 * Check if a given object implements the UpdateWorkflowTestConfigurationConnectionRequestModel interface.
 */
export function instanceOfUpdateWorkflowTestConfigurationConnectionRequestModel(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function UpdateWorkflowTestConfigurationConnectionRequestModelFromJSON(json: any): UpdateWorkflowTestConfigurationConnectionRequestModel {
    return UpdateWorkflowTestConfigurationConnectionRequestModelFromJSONTyped(json, false);
}

export function UpdateWorkflowTestConfigurationConnectionRequestModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): UpdateWorkflowTestConfigurationConnectionRequestModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'connectionId': !exists(json, 'connectionId') ? undefined : json['connectionId'],
    };
}

export function UpdateWorkflowTestConfigurationConnectionRequestModelToJSON(value?: UpdateWorkflowTestConfigurationConnectionRequestModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'connectionId': value.connectionId,
    };
}

