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

import { exists, mapValues } from '../runtime';
import type { ControlTypeModel } from './ControlTypeModel';
import {
    ControlTypeModelFromJSON,
    ControlTypeModelFromJSONTyped,
    ControlTypeModelToJSON,
} from './ControlTypeModel';
import type { OptionModel } from './OptionModel';
import {
    OptionModelFromJSON,
    OptionModelFromJSONTyped,
    OptionModelToJSON,
} from './OptionModel';
import type { OptionsDataSourceModel } from './OptionsDataSourceModel';
import {
    OptionsDataSourceModelFromJSON,
    OptionsDataSourceModelFromJSONTyped,
    OptionsDataSourceModelToJSON,
} from './OptionsDataSourceModel';
import type { PropertyTypeModel } from './PropertyTypeModel';
import {
    PropertyTypeModelFromJSON,
    PropertyTypeModelFromJSONTyped,
    PropertyTypeModelToJSON,
} from './PropertyTypeModel';
import type { ValuePropertyModel } from './ValuePropertyModel';
import {
    ValuePropertyModelFromJSON,
    ValuePropertyModelFromJSONTyped,
    ValuePropertyModelToJSON,
} from './ValuePropertyModel';

/**
 * A string property.
 * @export
 * @interface StringPropertyModel
 */
export interface StringPropertyModel extends ValuePropertyModel {
    /**
     * The property default value.
     * @type {string}
     * @memberof StringPropertyModel
     */
    defaultValue?: string;
    /**
     * The property sample value.
     * @type {string}
     * @memberof StringPropertyModel
     */
    exampleValue?: string;
    /**
     * The maximum string length.
     * @type {number}
     * @memberof StringPropertyModel
     */
    maxLength?: number;
    /**
     * The minimum string length.
     * @type {number}
     * @memberof StringPropertyModel
     */
    minLength?: number;
    /**
     * The list of valid property options.
     * @type {Array<OptionModel>}
     * @memberof StringPropertyModel
     */
    options?: Array<OptionModel>;
    /**
     * 
     * @type {OptionsDataSourceModel}
     * @memberof StringPropertyModel
     */
    optionsDataSource?: OptionsDataSourceModel;
}

/**
 * Check if a given object implements the StringPropertyModel interface.
 */
export function instanceOfStringPropertyModel(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function StringPropertyModelFromJSON(json: any): StringPropertyModel {
    return StringPropertyModelFromJSONTyped(json, false);
}

export function StringPropertyModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): StringPropertyModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        ...ValuePropertyModelFromJSONTyped(json, ignoreDiscriminator),
        'defaultValue': !exists(json, 'defaultValue') ? undefined : json['defaultValue'],
        'exampleValue': !exists(json, 'exampleValue') ? undefined : json['exampleValue'],
        'maxLength': !exists(json, 'maxLength') ? undefined : json['maxLength'],
        'minLength': !exists(json, 'minLength') ? undefined : json['minLength'],
        'options': !exists(json, 'options') ? undefined : ((json['options'] as Array<any>).map(OptionModelFromJSON)),
        'optionsDataSource': !exists(json, 'optionsDataSource') ? undefined : OptionsDataSourceModelFromJSON(json['optionsDataSource']),
    };
}

export function StringPropertyModelToJSON(value?: StringPropertyModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        ...ValuePropertyModelToJSON(value),
        'defaultValue': value.defaultValue,
        'exampleValue': value.exampleValue,
        'maxLength': value.maxLength,
        'minLength': value.minLength,
        'options': value.options === undefined ? undefined : ((value.options as Array<any>).map(OptionModelToJSON)),
        'optionsDataSource': OptionsDataSourceModelToJSON(value.optionsDataSource),
    };
}

