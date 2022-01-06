import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { create, remove } from './linkAPI';

const initialState = {
  status: '',
  addable: false,
  form: {
    name: '',
    url: '',
  },
  links: [],
};

export const createAsync = createAsyncThunk('link/create', create);

export const removeAsync = createAsyncThunk('link/remove', remove);

export const linkSlice = createSlice({
  name: 'link',
  initialState,
  reducers: {
    setAddable: (state, action) => {
      state.addable = action.payload;
    },
    setForm: (state, action) => {
      state.form = {
        ...state.form,
        ...action.payload,
      };
    },
  },
  extraReducers: (builder) => {
    builder
      .addCase(createAsync.pending, (state) => {
        state.status = '保存中';
      })
      .addCase(createAsync.fulfilled, (state, action) => {
        state.status = '已完成';
        state.addable = false;
        state.form = {
          name: '',
          url: '',
        };
        state.links = [action.payload.data, ...state.links];
      });

    builder
      .addCase(removeAsync.pending, (state) => {
        state.status = '删除中';
      })
      .addCase(removeAsync.fulfilled, (state, action) => {
        state.status = '已完成';
        state.links = state.links.filter((it) => it.id !== action.payload);
      });
  },
});

export const { setAddable, setForm } = linkSlice.actions;

export default linkSlice.reducer;
