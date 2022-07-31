function attachEvents() {
    // loadMessages();
    document.querySelector('#refresh').addEventListener('click', loadMessages);
    document.querySelector('#submit').addEventListener('click', submitMessage);
}

attachEvents();

async function loadMessages() {
    let response = await fetch('http://localhost:3030/jsonstore/messenger');
    let data = await response.json();

    let messageArea = document.querySelector('#messages');
    messageArea.value = '';

    let messages = [];
    for (let [k, content] of Object.entries(data)) {
        messages.push(`${content.author}: ${content.content}`);
    }
    messageArea.value = messages.join('\n');
}

async function submitMessage() {
    let author = document.querySelector('input[name=author]').value;
    let content = document.querySelector('input[name=content]').value;

    let body = JSON.stringify({author, content});

    let response = await fetch('http://localhost:3030/jsonstore/messenger',
        {
            method: 'post',
            body
        })
}