/* tslint:disable */
/* eslint-disable */
/**
 * The Embedded Configuration API
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
 * A group of workflows that make one logical integration.
 * @export
 * @interface IntegrationBasicModel
 */
export interface IntegrationBasicModel {
    /**
     * The created by.
     * @type {string}
     * @memberof IntegrationBasicModel
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof IntegrationBasicModel
     */
    readonly createdDate?: Date;
    /**
     * The description of a integration.
     * @type {string}
     * @memberof IntegrationBasicModel
     */
    description?: string;
    /**
     * The id of a integration.
     * @type {number}
     * @memberof IntegrationBasicModel
     */
    readonly id?: number;
    /**
     * The last modified by.
     * @type {string}
     * @memberof IntegrationBasicModel
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof IntegrationBasicModel
     */
    readonly lastModifiedDate?: Date;
    /**
     * The name of a integration.
     * @type {string}
     * @memberof IntegrationBasicModel
     */
    name: string;
    /**
     * The published date.
     * @type {Date}
     * @memberof IntegrationBasicModel
     */
    publishedDate?: Date;
    /**
     * The version of a integration.
     * @type {number}
     * @memberof IntegrationBasicModel
     */
    integrationVersion?: number;
    /**
     * The status of a integration.
     * @type {string}
     * @memberof IntegrationBasicModel
     */
    status?: IntegrationBasicModelStatusEnum;
}


/**
 * @export
 */
export const IntegrationBasicModelStatusEnum = {
    Published: 'PUBLISHED',
    Unpublished: 'UNPUBLISHED'
} as const;
export type IntegrationBasicModelStatusEnum = typeof IntegrationBasicModelStatusEnum[keyof typeof IntegrationBasicModelStatusEnum];


/**
 * Check if a given object implements the IntegrationBasicModel interface.
 */
export function instanceOfIntegrationBasicModel(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "name" in value;

    return isInstance;
}

export function IntegrationBasicModelFromJSON(json: any): IntegrationBasicModel {
    return IntegrationBasicModelFromJSONTyped(json, false);
}

export function IntegrationBasicModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): IntegrationBasicModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'createdBy': !exists(json, 'createdBy') ? undefined : json['createdBy'],
        'createdDate': !exists(json, 'createdDate') ? undefined : (new Date(json['createdDate'])),
        'description': !exists(json, 'description') ? undefined : json['description'],
        'id': !exists(json, 'id') ? undefined : json['id'],
        'lastModifiedBy': !exists(json, 'lastModifiedBy') ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': !exists(json, 'lastModifiedDate') ? undefined : (new Date(json['lastModifiedDate'])),
        'name': json['name'],
        'publishedDate': !exists(json, 'publishedDate') ? undefined : (new Date(json['publishedDate'])),
        'integrationVersion': !exists(json, 'integrationVersion') ? undefined : json['integrationVersion'],
        'status': !exists(json, 'status') ? undefined : json['status'],
    };
}

export function IntegrationBasicModelToJSON(value?: IntegrationBasicModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'description': value.description,
        'name': value.name,
        'publishedDate': value.publishedDate === undefined ? undefined : (value.publishedDate.toISOString()),
        'integrationVersion': value.integrationVersion,
        'status': value.status,
    };
}

