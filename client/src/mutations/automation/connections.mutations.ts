import {ConnectionApi, ConnectionModel} from '@/middleware/automation/connection';
import {useMutation} from '@tanstack/react-query';

type CreateConnectionMutationProps = {
    onSuccess?: (result: ConnectionModel, variables: ConnectionModel) => void;
    onError?: (error: Error, variables: ConnectionModel) => void;
};

export const useCreateConnectionMutation = (mutationProps?: CreateConnectionMutationProps) =>
    useMutation<ConnectionModel, Error, ConnectionModel>({
        mutationFn: (connectionModel: ConnectionModel) => {
            return new ConnectionApi().createConnection({
                connectionModel,
            });
        },
        onError: mutationProps?.onError,
        onSuccess: mutationProps?.onSuccess,
    });

type DeleteConnectionMutationProps = {
    onSuccess?: () => void;
    onError?: (error: Error, id: number) => void;
};

export const useDeleteConnectionMutation = (mutationProps?: DeleteConnectionMutationProps) =>
    useMutation<void, Error, number>({
        mutationFn: (id: number) => {
            return new ConnectionApi().deleteConnection({
                id,
            });
        },
        onError: mutationProps?.onError,
        onSuccess: mutationProps?.onSuccess,
    });

type UpdateConnectionMutationProps = {
    onSuccess?: (result: ConnectionModel, variables: ConnectionModel) => void;
    onError?: (error: Error, variables: ConnectionModel) => void;
};

export const useUpdateConnectionMutation = (mutationProps?: UpdateConnectionMutationProps) =>
    useMutation<ConnectionModel, Error, ConnectionModel>({
        mutationFn: (connection: ConnectionModel) => {
            return new ConnectionApi().updateConnection({
                connectionModel: connection,
                id: connection.id!,
            });
        },
        onError: mutationProps?.onError,
        onSuccess: mutationProps?.onSuccess,
    });
