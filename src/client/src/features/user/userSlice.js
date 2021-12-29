import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { fetchAll } from './userAPI';

const initialState = {
    list: [],
    status: 'done',
};

export const fetchAllAsync = createAsyncThunk(
    'user/fetchAll',
    async () => await fetchAll(),
);

export const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(fetchAllAsync.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(fetchAllAsync.fulfilled, (state, action) => {
                state.status = 'done';
                state.list = action.payload;
            });
    },
});

export default userSlice.reducer;