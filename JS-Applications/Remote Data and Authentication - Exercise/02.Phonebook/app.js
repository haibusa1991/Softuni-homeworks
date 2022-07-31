function attachEvents() {
    document.querySelector('#btnLoad').addEventListener('click', loadPhonebook);
    document.querySelector('#btnCreate').addEventListener('click', onCreate);
}

attachEvents();


async function loadPhonebook() {
    let response = await fetch('http://localhost:3030/jsonstore/phonebook');
    let data = await response.json();

    let phonebookUl = document.querySelector('#phonebook');
    phonebookUl.innerHTML = '';

    let records = document.createDocumentFragment();
    for (let [id, record] of Object.entries(data)) {
        records.appendChild(createRecord(record));
    }
    phonebookUl.appendChild(records);
}

function createRecord(record) {
    let li = document.createElement('li');
    li.textContent = `${record.person}: ${record.phone}`

    let button = document.createElement('button');
    button.id = record._id;
    button.textContent = 'Delete';
    button.addEventListener('click', onDelete);

    li.appendChild(button);

    return li;
}

async function onDelete(e) {
    let id = e.target.id;

    let response = await fetch('http://localhost:3030/jsonstore/phonebook/' + id, {
        method: 'delete'
    })

    await loadPhonebook();
}

async function onCreate() {
    let personField = document.querySelector('#person');
    let phoneField = document.querySelector('#phone');

    let person = personField.value;
    let phone = phoneField.value;

    let body = JSON.stringify({person, phone});

    let response = await fetch('http://localhost:3030/jsonstore/phonebook', {
        method: 'post',
        body
    });

    personField.value = '';
    phoneField.value = '';

    await loadPhonebook();
}