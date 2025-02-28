import ProjectInstanceDialogWorkflowsStepItem from '@/pages/automation/project-instances/components/ProjectInstanceDialogWorkflowsStepItem';
import {useGetProjectWorkflowsQuery} from '@/queries/automation/projects.queries';
import {ProjectInstanceModel} from 'middleware/automation/configuration';
import {Control, UseFormGetValues, UseFormRegister} from 'react-hook-form';
import {FormState} from 'react-hook-form/dist/types/form';

export interface ProjectInstanceDialogWorkflowsStepProps {
    control: Control<ProjectInstanceModel>;
    formState: FormState<ProjectInstanceModel>;
    getValues: UseFormGetValues<ProjectInstanceModel>;
    register: UseFormRegister<ProjectInstanceModel>;
}

const ProjectInstanceDialogWorkflowsStep = ({
    control,
    formState,
    getValues,
    register,
}: ProjectInstanceDialogWorkflowsStepProps) => {
    const {data: workflows} = useGetProjectWorkflowsQuery(getValues().projectId!);

    return (
        <ul className="h-full space-y-4">
            {workflows?.map((workflow, workflowIndex) => (
                <ProjectInstanceDialogWorkflowsStepItem
                    control={control}
                    formState={formState}
                    key={workflow.id!}
                    label={workflow.label!}
                    register={register}
                    workflow={workflow}
                    workflowIndex={workflowIndex}
                />
            ))}
        </ul>
    );
};

export default ProjectInstanceDialogWorkflowsStep;
