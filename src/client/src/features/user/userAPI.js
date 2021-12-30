export async function fetchAll() {
    return await fetch('http://localhost:5000/users').then((resp) => {
        return resp.json();
    }).then((data) => {
        return data;
    });
}

export async function update(id, name) {
    return await fetch(`http://localhost:5000/users/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name }),
    }).then((resp) => {
        return resp.json();
    }).then((data) => {
        return data;
    })
}