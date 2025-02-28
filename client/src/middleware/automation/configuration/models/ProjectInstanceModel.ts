/* tslint:disable */
/* eslint-disable */
/**
 * The Automation Configuration API
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
import type { ProjectInstanceProjectModel } from './ProjectInstanceProjectModel';
import {
    ProjectInstanceProjectModelFromJSON,
    ProjectInstanceProjectModelFromJSONTyped,
    ProjectInstanceProjectModelToJSON,
} from './ProjectInstanceProjectModel';
import type { ProjectInstanceWorkflowModel } from './ProjectInstanceWorkflowModel';
import {
    ProjectInstanceWorkflowModelFromJSON,
    ProjectInstanceWorkflowModelFromJSONTyped,
    ProjectInstanceWorkflowModelToJSON,
} from './ProjectInstanceWorkflowModel';
import type { TagModel } from './TagModel';
import {
    TagModelFromJSON,
    TagModelFromJSONTyped,
    TagModelToJSON,
} from './TagModel';

/**
 * Contains configurations and connections required for the execution of project workflows.
 * @export
 * @interface ProjectInstanceModel
 */
export interface ProjectInstanceModel {
    /**
     * The description of a project instance.
     * @type {string}
     * @memberof ProjectInstanceModel
     */
    description?: string;
    /**
     * The created by.
     * @type {string}
     * @memberof ProjectInstanceModel
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof ProjectInstanceModel
     */
    readonly createdDate?: Date;
    /**
     * The id of a project instance.
     * @type {number}
     * @memberof ProjectInstanceModel
     */
    readonly id?: number;
    /**
     * The last execution date.
     * @type {Date}
     * @memberof ProjectInstanceModel
     */
    readonly lastExecutionDate?: Date;
    /**
     * The last modified by.
     * @type {string}
     * @memberof ProjectInstanceModel
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof ProjectInstanceModel
     */
    readonly lastModifiedDate?: Date;
    /**
     * The name of a project instance.
     * @type {string}
     * @memberof ProjectInstanceModel
     */
    name: string;
    /**
     * 
     * @type {ProjectInstanceProjectModel}
     * @memberof ProjectInstanceModel
     */
    project?: ProjectInstanceProjectModel;
    /**
     * Th id of a project.
     * @type {number}
     * @memberof ProjectInstanceModel
     */
    projectId?: number;
    /**
     * 
     * @type {Array<ProjectInstanceWorkflowModel>}
     * @memberof ProjectInstanceModel
     */
    projectInstanceWorkflows?: Array<ProjectInstanceWorkflowModel>;
    /**
     * If a workflow is enabled or not in the project instance.
     * @type {boolean}
     * @memberof ProjectInstanceModel
     */
    enabled?: boolean;
    /**
     * 
     * @type {Array<TagModel>}
     * @memberof ProjectInstanceModel
     */
    tags?: Array<TagModel>;
    /**
     * 
     * @type {number}
     * @memberof ProjectInstanceModel
     */
    version?: number;
}

/**
 * Check if a given object implements the ProjectInstanceModel interface.
 */
export function instanceOfProjectInstanceModel(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "name" in value;

    return isInstance;
}

export function ProjectInstanceModelFromJSON(json: any): ProjectInstanceModel {
    return ProjectInstanceModelFromJSONTyped(json, false);
}

export function ProjectInstanceModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): ProjectInstanceModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'description': !exists(json, 'description') ? undefined : json['description'],
        'createdBy': !exists(json, 'createdBy') ? undefined : json['createdBy'],
        'createdDate': !exists(json, 'createdDate') ? undefined : (new Date(json['createdDate'])),
        'id': !exists(json, 'id') ? undefined : json['id'],
        'lastExecutionDate': !exists(json, 'lastExecutionDate') ? undefined : (new Date(json['lastExecutionDate'])),
        'lastModifiedBy': !exists(json, 'lastModifiedBy') ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': !exists(json, 'lastModifiedDate') ? undefined : (new Date(json['lastModifiedDate'])),
        'name': json['name'],
        'project': !exists(json, 'project') ? undefined : ProjectInstanceProjectModelFromJSON(json['project']),
        'projectId': !exists(json, 'projectId') ? undefined : json['projectId'],
        'projectInstanceWorkflows': !exists(json, 'projectInstanceWorkflows') ? undefined : ((json['projectInstanceWorkflows'] as Array<any>).map(ProjectInstanceWorkflowModelFromJSON)),
        'enabled': !exists(json, 'enabled') ? undefined : json['enabled'],
        'tags': !exists(json, 'tags') ? undefined : ((json['tags'] as Array<any>).map(TagModelFromJSON)),
        'version': !exists(json, '__version') ? undefined : json['__version'],
    };
}

export function ProjectInstanceModelToJSON(value?: ProjectInstanceModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'description': value.description,
        'name': value.name,
        'project': ProjectInstanceProjectModelToJSON(value.project),
        'projectId': value.projectId,
        'projectInstanceWorkflows': value.projectInstanceWorkflows === undefined ? undefined : ((value.projectInstanceWorkflows as Array<any>).map(ProjectInstanceWorkflowModelToJSON)),
        'enabled': value.enabled,
        'tags': value.tags === undefined ? undefined : ((value.tags as Array<any>).map(TagModelToJSON)),
        '__version': value.version,
    };
}

