export async function create(link) {
  return await fetch('http://localhost:8001/links', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(link),
  })
    .then((resp) => resp.json())
    .then((data) => data);
}

export async function remove(id) {
  return await fetch(`http://localhost:8001/links/${id}`, {
    method: 'DELETE',
  })
    .then((resp) => resp.json())
    .then(({ data }) => data);
}
