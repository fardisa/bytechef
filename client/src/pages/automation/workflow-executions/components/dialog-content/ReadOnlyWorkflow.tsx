import {Cross1Icon} from '@radix-ui/react-icons';
import Button from 'components/Button/Button';
import {WorkflowExecutionModel} from 'middleware/helios/execution';

const ReadOnlyWorkflow = ({
    execution,
    setWorkflowExecutionDetailsDialogOpen,
}: {
    execution: WorkflowExecutionModel;
    setWorkflowExecutionDetailsDialogOpen: (
        workflowExecutionDetailsDialogOpen: boolean
    ) => void;
}) => {
    const {instance, project, workflow} = execution;

    return (
        <div className="flex w-full justify-between bg-gray-100 p-4">
            <h3>
                {workflow?.label
                    ? `${project?.name ? project.name + ' / ' : ''}${
                          instance?.name ? instance.name + ' / ' : ''
                      }${workflow?.label}`
                    : 'No data to show'}
            </h3>

            <div>
                <Button
                    label="Edit"
                    className="ml-4"
                    size="small"
                    displayType="secondary"
                />

                <Button
                    aria-label="Close panel"
                    className="ml-auto"
                    displayType="icon"
                    size="small"
                    icon={
                        <Cross1Icon
                            className="h-3 w-3 cursor-pointer"
                            aria-hidden="true"
                        />
                    }
                    onClick={() => setWorkflowExecutionDetailsDialogOpen(false)}
                />
            </div>
        </div>
    );
};

export default ReadOnlyWorkflow;
