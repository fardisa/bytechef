/* eslint-disable sort-keys */
import {ReactNode} from 'react';
import {create} from 'zustand';
import {devtools} from 'zustand/middleware';

interface Node {
    componentName?: string;
    icon?: ReactNode;
    id: string;
    label?: string;
    name: string;
    type: 'component' | 'flowControl';
    version: number;
}

interface WorkflowNodeDetailsPanelState {
    workflowNodeDetailsPanelOpen: boolean;
    setWorkflowNodeDetailsPanelOpen: (workflowNodeDetailsPanelOpen: boolean) => void;

    currentNode: Node;
    setCurrentNode: (currentNode: Node) => void;

    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    focusedInput: any;
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    setFocusedInput: (focusedInput: any) => void;
}

export const useWorkflowNodeDetailsPanelStore = create<WorkflowNodeDetailsPanelState>()(
    devtools(
        (set) => ({
            workflowNodeDetailsPanelOpen: false,
            setWorkflowNodeDetailsPanelOpen: (workflowNodeDetailsPanelOpen) =>
                set((state) => ({
                    ...state,
                    workflowNodeDetailsPanelOpen: workflowNodeDetailsPanelOpen,
                })),

            currentNode: {id: '', name: '', type: 'component', version: 1},
            setCurrentNode: (currentNode) => set((state) => ({...state, currentNode})),

            focusedInput: null,
            setFocusedInput: (focusedInput) => set((state) => ({...state, focusedInput})),
        }),
        {
            name: 'workflow-node-details-panel',
        }
    )
);
