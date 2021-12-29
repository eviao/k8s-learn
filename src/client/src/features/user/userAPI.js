export async function fetchAll() {
    return await fetch('http://localhost:5000/users').then(resp => {
            return resp.json();
        }).then(data => {
            return data;
        });
}