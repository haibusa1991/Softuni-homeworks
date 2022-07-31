import {populateTable} from './util.js'

let table;
init();

async function init() {
    table = document.querySelector('tbody');
    table.innerHTML = '';
    await populateTable(table);
    Array.from(document.querySelectorAll('input')).forEach(e => e.disabled = true);
}