import {api} from './api.js';
import * as util from "./util.js";
import {render, html} from '../node_modules/lit-html/lit-html.js';


let table;
init();

function init() {
    let buttons = document.querySelectorAll('button');
    document.querySelector('#logoutBtn').addEventListener('click', onLogout);
    buttons[0].addEventListener('click', onCreate);
    buttons[1].addEventListener('click', onBuy);
    buttons[2].addEventListener('click', onAllOrders);
    table = document.querySelector('tbody')
    util.populateTable(table);
}

async function onLogout() {
    await api().get('http://localhost:3030/users/logout');
    sessionStorage.clear();
    window.location = 'index.html'
}

async function onCreate(e) {
    e.preventDefault();
    let formData = new FormData(e.target.parentElement);
    let [name, price, decFactor, img] = formData.values();
    let rowData = {name, price, decFactor, img}

    api().post('http://localhost:3030/data/furniture', rowData)
    e.target.parentElement.reset();
    let table = document.querySelector('tbody');
    util.addTableRow(rowData, table);
}

async function onBuy(e) {
    e.preventDefault();
    let items = Array.from(document.querySelectorAll('tbody input'))
        .filter(e => e.checked)
        .map(e => e.parentElement.parentElement)
        .map(e => {
            let c = e.children;
            return {name: c[1].textContent.trim(), price: c[2].textContent.trim()};
        });


    api().post('http://localhost:3030/data/orders', {items: items});
    Array.from(document.querySelectorAll('tbody input')).forEach(e => e.checked = false);

}

async function onAllOrders(e) {
    e.preventDefault();
    let userId = JSON.parse(sessionStorage.getItem('user'))._id;
    let data = await api().get('http://localhost:3030/data/orders?where=_ownerId%3D'
        + encodeURI('\"' + userId + '\"'));

    let names = data.map(e => e.items.map(e1 => e1.name).join(', ')).join(', ');
    let price = data.map(e => e.items.map(e1 => Number(e1.price)))
        .map(e => e.reduce((p1, p2) => p1 + p2))
        .reduce((p1, p2) => p1 + p2);

    let ordersDiv = document.querySelector('div.orders span');
    let ordersInfo = html`
        <p>Bought furniture: <span>${names}</span></p>
        <p>Total price: <span>${price} $</span></p>`
    render(ordersInfo, ordersDiv);
}



