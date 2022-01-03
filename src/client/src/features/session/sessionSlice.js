import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { login } from './sessionAPI';

const initialState = {
  status: '',
  user: null,
};

export const loginAsync = createAsyncThunk('session/login', login);

export const sessionSlice = createSlice({
  name: 'session',
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(loginAsync.pending, (state) => {
        state.status = '登录中';
      })
      .addCase(loginAsync.fulfilled, (state, action) => {
        state.status = '已完成';
        state.user = action.payload.data;
      });
  },
});

export default sessionSlice.reducer;
