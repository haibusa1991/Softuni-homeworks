window.onload = init();

function init() {
    loadStudents();
    document.querySelector('#submit').addEventListener('click', onSubmit);
}

async function loadStudents() {

    let response = await fetch(' http://localhost:3030/jsonstore/collections/students');
    let data = await response.json();

    let tableRows = document.createDocumentFragment();
    for (let [id, content] of Object.entries(data)) {
        tableRows.appendChild(createTableRow(content));
    }

    let table = document.querySelector('#results tbody');
    table.innerHTML = '';
    table.appendChild(tableRows);
}

function createTableRow(data) {
    let content = [
        data.firstName,
        data.lastName,
        data.facultyNumber,
        data.grade
    ];

    let tr = document.createElement('tr');

    for (let td of content) {
        tr.appendChild(createTd(td));
    }

    return tr;
}

function createTd(textContent) {
    let td = document.createElement('td');
    td.textContent = textContent;
    return td;
}

async function onSubmit(e) {
    e.preventDefault();

    let firstName = document.querySelector('input[name=firstName]').value;
    let lastName = document.querySelector('input[name=lastName]').value;
    let facultyNumber = document.querySelector('input[name=facultyNumber]').value;
    let grade = document.querySelector('input[name=grade]').value;

    let body = JSON.stringify({firstName, lastName, facultyNumber, grade});

    await fetch(' http://localhost:3030/jsonstore/collections/students',{
        method:'post',
        body
    });

    loadStudents();
}
