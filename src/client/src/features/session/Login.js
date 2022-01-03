import { React, useState } from 'react';
import { Link, Navigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { loginAsync } from './sessionSlice';

export function Login() {
  const dispatch = useDispatch();
  const { user } = useSelector((root) => root.session);
  const [form, setForm] = useState({
    email: '',
    password: '',
  });

  const submitForm = (e) => {
    e.preventDefault();
    dispatch(loginAsync(form));
  };

  const updateField = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <>
      {user && <Navigate to="/" replace={true} />}
      <header>
        <h1>登录系统</h1>
      </header>
      <main>
        <section>
          <form onSubmit={submitForm}>
            <label htmlFor="email">邮箱:</label>
            <input
              type="email"
              id="email"
              name="email"
              placeholder="请输入常用邮箱"
              value={form.email}
              onChange={updateField}
            />
            <label htmlFor="password">密码:</label>
            <input
              type="password"
              id="password"
              name="password"
              placeholder="请输入密码"
              value={form.password}
              onChange={updateField}
            />
            <button type="submit">确认登录 &rarr;</button>
            &nbsp;&nbsp;
            <Link to="/user/register">注册新用户</Link>
          </form>
        </section>
      </main>
    </>
  );
}
