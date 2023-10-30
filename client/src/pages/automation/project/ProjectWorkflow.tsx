import {ReactFlowProvider} from 'reactflow';

import NodeDetailsPanel from './components/NodeDetailsPanel';

import 'reactflow/dist/base.css';

import './Workflow.css';

import {useGetComponentDefinitionsQuery} from '@/queries/componentDefinitions.queries';

import DataPillPanel from './components/DataPillPanel';
import WorkflowEditor, {WorkflowEditorProps} from './components/WorkflowEditor';
import {useNodeDetailsPanelStore} from './stores/useNodeDetailsPanelStore';

const ProjectWorkflow = ({components, flowControls}: WorkflowEditorProps) => {
    const {data: componentDefinitions} = useGetComponentDefinitionsQuery({
        connectionDefinitions: true,
    });

    const {currentNode} = useNodeDetailsPanelStore();

    return (
        <ReactFlowProvider>
            <WorkflowEditor
                components={components}
                flowControls={flowControls}
            />

            {componentDefinitions && currentNode.name && (
                <NodeDetailsPanel componentDefinitions={componentDefinitions} />
            )}

            <DataPillPanel />
        </ReactFlowProvider>
    );
};

export default ProjectWorkflow;
