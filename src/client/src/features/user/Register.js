import { React, useState } from 'react';
import { Link, Navigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { registerAsync } from './userSlice';

export function Register() {
  const dispatch = useDispatch();
  const { registered } = useSelector((root) => root.user);
  const [form, setForm] = useState({
    email: '',
    name: '',
    password: '',
  });

  const submitForm = (e) => {
    e.preventDefault();
    dispatch(registerAsync(form));
  };

  const updateField = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <>
      {registered && <Navigate to="/session/login" replace={true} />}
      <header>
        <h1>用户注册</h1>
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
            <label htmlFor="name">姓名:</label>
            <input
              type="text"
              id="text"
              name="name"
              placeholder="请输入姓名"
              value={form.name}
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
            <button type="submit">确认注册 &rarr;</button>
            &nbsp;&nbsp;
            <Link to="/session/login">已有账户？</Link>
          </form>
        </section>
      </main>
    </>
  );
}
