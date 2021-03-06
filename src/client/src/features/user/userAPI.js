export async function register(user) {
  return await fetch('http://localhost:8000/user/register', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(user),
  })
    .then((resp) => resp.json())
    .then((data) => data);
}
