import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { register } from './userAPI';

const initialState = {
  status: '',
  registered: false,
};

export const registerAsync = createAsyncThunk('user/register', register);

export const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(registerAsync.pending, (state) => {
        state.status = '处理中';
      })
      .addCase(registerAsync.fulfilled, (state, action) => {
        state.status = '已完成';
        state.registered = true;
      });
  },
});

export default userSlice.reducer;
