import {Button} from '@/components/ui/button';
import * as SheetPrimitive from '@radix-ui/react-dialog';
import {Cross2Icon} from '@radix-ui/react-icons';
import {PencilIcon} from 'lucide-react';
import {WorkflowExecutionModel} from 'middleware/automation/workflow/execution';
import {useNavigate} from 'react-router-dom';

const WorkflowExecutionDetailsSheetWorkflowView = ({
    workflowExecution,
}: {
    workflowExecution: WorkflowExecutionModel;
}) => {
    const {project, projectInstance, workflow} = workflowExecution;

    const navigate = useNavigate();

    return (
        <div className="flex w-full justify-between bg-gray-100 p-4 align-middle">
            <h3>
                {workflow?.label
                    ? `${project?.name ? project.name + ' / ' : ''}${
                          projectInstance?.name ? projectInstance.name + ' / ' : ''
                      }${workflow?.label}`
                    : 'No data to show'}
            </h3>

            <div className="flex align-middle">
                <Button
                    className="mr-1"
                    onClick={() => navigate(`/automation/projects/${project?.id}/workflows/${workflow?.id}`)}
                    size="sm"
                    variant="outline"
                >
                    <PencilIcon className="mr-1 size-4 cursor-pointer" /> Edit
                </Button>

                <SheetPrimitive.Close asChild>
                    <Cross2Icon className="size-4 cursor-pointer opacity-70" />
                </SheetPrimitive.Close>
            </div>
        </div>
    );
};

export default WorkflowExecutionDetailsSheetWorkflowView;
