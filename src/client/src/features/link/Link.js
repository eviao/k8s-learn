import { React, useEffect } from 'react';
import { Navigate } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import {
  setAddable,
  setForm,
  createAsync,
  removeAsync,
  findAllByUseridAsync,
} from './linkSlice';

import styles from './Link.module.css';

export function Link() {
  const dispatch = useDispatch();
  const { user } = useSelector((root) => root.session);
  const { addable, form, links } = useSelector((root) => root.link);

  useEffect(() => {
    (() => {
      if (!user) {
        return;
      }
      dispatch(findAllByUseridAsync(user.id));
    })();
  }, []);

  const submitForm = (e) => {
    dispatch(
      createAsync({
        ...form,
        userid: user.id,
        username: user.name,
      })
    );
  };

  const updateField = (e) => {
    dispatch(setForm({ [e.target.name]: e.target.value }));
  };

  return (
    <>
      {!user && <Navigate to="/session/login" replace={true} />}
      <header className={styles.header}>
        <nav>
          <span className={styles.logo}>k8s-learn</span>
          <ul>
            <li>
              <span>
                {user && user.name}
                {!user && '未登录'}
              </span>
            </li>
          </ul>
        </nav>
      </header>
      <main className={styles.links}>
        <section>
          {addable ? (
            <aside className={styles.form}>
              <form>
                <div>
                  <input
                    name="name"
                    value={form.name}
                    onChange={updateField}
                    placeholder="#名称"
                  />
                </div>
                <div>
                  <textarea
                    name="url"
                    value={form.url}
                    onChange={updateField}
                    cols="30"
                    rows="2"
                    placeholder="#链接地址"
                  ></textarea>
                </div>
                <hr />
                <div className={styles.actions}>
                  <a href="#" onClick={(e) => submitForm()}>
                    保存
                  </a>
                  &nbsp;&nbsp;
                  <a href="#" onClick={(e) => dispatch(setAddable(false))}>
                    取消
                  </a>
                </div>
              </form>
            </aside>
          ) : (
            <aside
              onClick={(e) => dispatch(setAddable(true))}
              className={styles.add}
            >
              <span>+</span>
            </aside>
          )}

          {links.map((it, idx) => (
            <aside
              key={it.id}
              style={
                {
                  // backgroundImage: `url('${images[idx]}')`,
                }
              }
            >
              <h3>
                <u>{it.name}</u>
              </h3>
              <p>
                <small>
                  <a href={it.url} target="_blank">
                    {it.url}
                  </a>
                </small>
              </p>
              <hr />
              <div className={styles.actions}>
                <a href="#" onClick={(e) => dispatch(removeAsync(it.id))}>
                  删除
                </a>
              </div>
            </aside>
          ))}
        </section>
      </main>
    </>
  );
}
