import { React } from 'react';
import { useSelector } from 'react-redux';

export function Home() {
  const { user } = useSelector((root) => root.session);

  return (
    <>
      <h1>hello, {user && user.name}!</h1>
    </>
  );
}
