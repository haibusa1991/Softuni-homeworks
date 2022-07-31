window.onload = init();

function init() {
    document.querySelector('table tbody').innerHTML = '';
    document.querySelector('#loadBooks').addEventListener('click', loadBooks);
    document.querySelector('form button').addEventListener('click', onSubmit);
    loadBooks();
}


async function loadBooks() {
    let response = await fetch('http://localhost:3030/jsonstore/collections/books/');

    let data = await response.json();
    let rows = document.createDocumentFragment();

    for (let [id, content] of Object.entries(data)) {
        rows.appendChild(createRow(id, content));
    }

    let table = document.querySelector('table tbody');
    table.innerHTML = '';
    table.appendChild(rows);
}

function createRow(id, content) {
    let author = content.author;
    let title = content.title;

    let tr = document.createElement('tr');

    let titleTd = document.createElement('td');
    titleTd.textContent = title;
    tr.appendChild(titleTd);

    let authorTd = document.createElement('td');
    authorTd.textContent = author;
    tr.appendChild(authorTd);

    let buttonsTd = document.createElement('td');

    let editBtn = document.createElement('button');
    editBtn.textContent = 'Edit';
    editBtn.id = id;
    editBtn.addEventListener('click', onEdit);
    buttonsTd.appendChild(editBtn);

    let deleteBtn = document.createElement('button');
    deleteBtn.textContent = 'Delete';
    deleteBtn.id = id;
    deleteBtn.addEventListener('click', onDelete);
    buttonsTd.appendChild(deleteBtn);
    tr.appendChild(buttonsTd);

    return tr;
}

function onEdit(e) {
    document.querySelector('form h3').textContent = 'Edit FORM';

    let titleField = document.querySelector('form input[name=title]');
    let authorField = document.querySelector('form input[name=author]');
    let tableRow = e.target.parentElement.parentElement;

    let title = tableRow.querySelectorAll('td')[0].textContent;
    let author = tableRow.querySelectorAll('td')[1].textContent;

    titleField.value = title;
    authorField.value = author;

    let button = document.querySelector('form button');
    button.id = e.target.id;
    button.textContent = 'Save';
}

async function onDelete(e) {
    console.log('deleting book with id ' + e.target.id);

    await fetch('http://localhost:3030/jsonstore/collections/books/' + e.target.id, {
        method: 'delete'
    });

    loadBooks();
}

async function onSubmit(e) {
    e.preventDefault();

    document.querySelector('form h3').textContent = 'FORM';

    let button = document.querySelector('form button');
    button.id = e.target.id;
    button.textContent = 'Submit';

    let titleField = document.querySelector('form input[name=title]');
    let authorField = document.querySelector('form input[name=author]');

    if (titleField.value === '' || authorField.value === '') {
        alert('both fields must be filled');
        return;
    }

    let isEdit = false;

    let url = 'http://localhost:3030/jsonstore/collections/books/';

    if (e.target.id !== '') {
        url = url + e.target.id;
        isEdit = true;
    }

    let body = JSON.stringify({'author': authorField.value, 'title': titleField.value});

    await fetch(url, {
        method: isEdit ? 'put' : 'post',
        body
    });

    titleField.value = '';
    authorField.value = '';
    button.id = '';

    loadBooks();
}