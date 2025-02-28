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

package com.bytechef.platform.workflow.execution.facade;

import com.bytechef.atlas.configuration.service.WorkflowService;
import com.bytechef.atlas.execution.domain.Job;
import com.bytechef.atlas.execution.dto.JobParameters;
import com.bytechef.atlas.execution.facade.JobFacade;
import com.bytechef.atlas.execution.service.JobService;
import com.bytechef.platform.constant.Type;
import com.bytechef.platform.workflow.execution.service.InstanceJobService;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ivica Cardic
 */
@Service
public class InstanceJobFacadeImpl implements InstanceJobFacade {

    private final InstanceJobService instanceJobService;
    private final JobFacade jobFacade;
    private final JobService jobService;
    private final WorkflowService workflowService;

    @SuppressFBWarnings("EI")
    public InstanceJobFacadeImpl(
        InstanceJobService instanceJobService, JobFacade jobFacade, JobService jobService,
        WorkflowService workflowService) {

        this.instanceJobService = instanceJobService;
        this.jobFacade = jobFacade;
        this.jobService = jobService;
        this.workflowService = workflowService;
    }

    @Override
    // TODO @Transactional
    public Job createJob(JobParameters jobParameters, long instanceId, Type type) {
        long jobId = jobFacade.createJob(jobParameters);

        instanceJobService.create(jobId, instanceId, type);

        return jobService.getJob(jobId);
    }

    @Override
    @Transactional
    public Job createSyncJob(JobParameters jobParameters, long instanceId, Type type) {
        Job job = jobService.create(jobParameters, workflowService.getWorkflow(jobParameters.getWorkflowId()));

        instanceJobService.create(Validate.notNull(job.getId(), "id"), instanceId, type);

        return job;
    }
}
