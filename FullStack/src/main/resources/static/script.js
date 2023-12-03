function sendData() {
    const inputData = document.getElementById('inputData').value;
    const inputAge = parseInt(document.getElementById('inputAge').value);

    fetch('/api/submit', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({data: inputData, age: inputAge}),
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('result').innerText = `Server response: ${data.message}`;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
