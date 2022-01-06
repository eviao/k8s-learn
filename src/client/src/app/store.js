import { configureStore } from '@reduxjs/toolkit';
import sessionReducer from '../features/session/sessionSlice';
import userReducer from '../features/user/userSlice';
import linkReducer from '../features/link/linkSlice';

export const store = configureStore({
  reducer: {
    session: sessionReducer,
    user: userReducer,
    link: linkReducer,
  },
});
