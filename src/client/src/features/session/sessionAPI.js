export async function login(user) {
  return await fetch('http://localhost:8000/session/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(user),
  })
    .then((resp) => resp.json())
    .then((data) => data);
}
