import { React } from 'react';
import { Navigate } from 'react-router-dom';
import { useSelector } from 'react-redux';

import styles from './Home.module.css';

export function Home() {
  const { user } = useSelector((root) => root.session);

  const images = [
    'https://images.ctfassets.net/f60q1anpxzid/asset-4854f431796a126b6beeb14ab0a84562/198e728b8866f4fa89be3a70afbca2bf/high-angle-photo-of-a-corgi-looking-upwards-2664417.jpg?fm=jpg&fl=progressive&q=50&w=1200',
    'https://images.ctfassets.net/f60q1anpxzid/asset-89fdf181bf1263d5300842536acee205/eb34f7ac6cef02109c0fcd5a302d4c1b/white-brown-and-black-shih-tzu-puppy-936317.jpg?fm=jpg&fl=progressive&q=50&w=1200',
    'https://images.ctfassets.net/f60q1anpxzid/asset-ec6b124b6bab73df54d726238f1c157b/896f8fc4cfcc37316e4980effb051281/adorable-animal-blur-breed-319975.jpg?fm=jpg&fl=progressive&q=50&w=1200',
    'https://images.ctfassets.net/f60q1anpxzid/asset-043bbd27b829e9b40e54e3feac0365a1/f550047216051e49c130f06cbf9e3288/dog-pet-14644.jpg?fm=jpg&fl=progressive&q=50&w=1200',
    'https://images.ctfassets.net/f60q1anpxzid/asset-8186cb9ec867f8f24dde8ebccfe6c806/33320d0e3a70724920898e9e82296830/dog-puppy-rescue-dog-shelter-dog-53261.jpg?fm=jpg&fl=progressive&q=50&w=1200',
  ];

  const data = [
    {
      name: 'NFS (简体中文) - ArchWiki',
      description: 'NFS (简体中文) - ArchWiki',
      url: 'https://wiki.archlinux.org/title/NFS_(%E7%AE%80%E4%BD%93%E4%B8%AD%E6%96%87)',
    },
    {
      name: 'Getting Started with Contour',
      description: 'Getting Started with Contour',
      url: 'https://projectcontour.io/getting-started/',
    },
  ];

  return (
    <>
      {!user && <Navigate to="/session/login" replace={true} />}
      <header className={styles.header}>
        <nav>
          <span className={styles.logo}>k8s-learn</span>
          <ul>
            <li>
              <span>
                &#128172;&nbsp;
                {user && user.name}
                {!user && '未登录'}
              </span>
              <ul>
                <li>
                  <a href="/">个人资料</a>
                </li>
                <li>
                  <a href="/">退出</a>
                </li>
              </ul>
            </li>
          </ul>
        </nav>
      </header>
      <main className={styles.links}>
        <section>
          <aside className={styles.creator}>
            <span>+</span>
          </aside>
          {data.map((it, idx) => (
            <aside
              style={{
                // backgroundImage: `url('${images[idx]}')`,
              }}
            >
              <h3><u>{it.name}</u></h3>
              <p>
                <small>
                  <a href={it.url}>{it.url}</a>
                </small>
              </p>
              <hr />
              <div className={styles.actions}>
                <a href="/">删除</a>
              </div>
            </aside>
          ))}
        </section>
      </main>
    </>
  );
}
