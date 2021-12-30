import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { fetchAll, update } from './userAPI';

const initialState = {
    list: [],
    status: 'done',
    editable: false,
    user: {},
};

export const fetchAllAsync = createAsyncThunk(
    'user/fetchAll',
    async () => await fetchAll(),
);

export const updateAsync = createAsyncThunk(
    'user/update',
    async (user) => await update(user.id, user.name)
);

export const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        startEdit: (state, action) => {
            if (state.editable) {
                return;
            }
            state.editable = true;
            state.user = action.payload;
        },
        cancelEdit: (state) => {
            state.editable = false;
            state.user = {};
        },
        setUser: (state, action) => {
            state.user.name = action.payload;
        },
    },
    extraReducers: (builder) => {
        builder
            .addCase(fetchAllAsync.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(fetchAllAsync.fulfilled, (state, action) => {
                state.status = 'done';
                state.list = action.payload;
            });

        builder
            .addCase(updateAsync.pending, (state) => {
                state.status = 'updateing';
            })
            .addCase(updateAsync.fulfilled, (state, action) => {
                const { list, user } = state;

                const index = list.findIndex((it) => it.id == user.id);
                const newList = [...list];
                newList.splice(index, 1, action.payload);

                state.list = newList;
                state.status = 'done';
                state.editable = false;
                state.user = {};
            });
    },
});

export const { startEdit, cancelEdit, setUser } = userSlice.actions;

export default userSlice.reducer;