/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the ByteChef Enterprise license (the "Enterprise License");
 * you may not use this file except in compliance with the Enterprise License.
 */

package com.bytechef.hermes.configuration.remote.client.facade;

import com.bytechef.atlas.configuration.domain.WorkflowTask;
import com.bytechef.commons.rest.client.LoadBalancedRestClient;
import com.bytechef.hermes.configuration.domain.WorkflowConnection;
import com.bytechef.hermes.configuration.domain.WorkflowTrigger;
import com.bytechef.hermes.configuration.facade.WorkflowConnectionFacade;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * @version ee
 *
 * @author Ivica Cardic
 */
@Component
public class RemoteWorkflowConnectionFacadeClient implements WorkflowConnectionFacade {

    private static final String CONFIGURATION_APP = "configuration-app";
    private static final String WORKFLOW_CONNECTION_FACADE = "/remote/workflow-connection-facade";

    private final LoadBalancedRestClient loadBalancedRestClient;

    @SuppressFBWarnings("EI")
    public RemoteWorkflowConnectionFacadeClient(LoadBalancedRestClient loadBalancedRestClient) {
        this.loadBalancedRestClient = loadBalancedRestClient;
    }

    @Override
    public List<WorkflowConnection> getWorkflowConnections(WorkflowTask workflowTask) {
        return loadBalancedRestClient.post(
            uriBuilder -> uriBuilder
                .host(CONFIGURATION_APP)
                .path(WORKFLOW_CONNECTION_FACADE + "/get-workflow-task-connections")
                .build(),
            workflowTask,
            new ParameterizedTypeReference<>() {});
    }

    @Override
    public List<WorkflowConnection> getWorkflowConnections(WorkflowTrigger workflowTrigger) {
        return loadBalancedRestClient.post(
            uriBuilder -> uriBuilder
                .host(CONFIGURATION_APP)
                .path(WORKFLOW_CONNECTION_FACADE + "/get-workflow-trigger-connections")
                .build(),
            workflowTrigger,
            new ParameterizedTypeReference<>() {});
    }
}
