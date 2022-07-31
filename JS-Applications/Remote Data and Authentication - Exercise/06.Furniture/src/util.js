import {api} from "./api.js";
import {html, render} from '../node_modules/lit-html/lit-html.js';

export function validateToken() {
    if (sessionStorage.user) {
        try {
            api().get('http://localhost:3030/data/orders?where=_ownerId%3Dnull');
            return true;
        } catch (e) {
            return false;
        }
    }
    return false;
}

let tableContents = [];

export async function populateTable(htmlTableElement) {
    let data = await api().get('http://localhost:3030/data/furniture');
    tableContents.push(...data);
    renderTableContents(htmlTableElement);
}

function tableRow(data) {
    return html`
        <tr>
            <td>
                <img src="${data.img}">
            </td>
            <td>
                <p>${data.name}</p>
            </td>
            <td>
                <p>${data.price}</p>
            </td>
            <td>
                <p>${data.decFactor}</p>
            </td>
            <td>
                <input type="checkbox"/>
            </td>
        </tr>
    `;
}


export function addTableRow(contents, htmlTableElement) {
    tableContents.push(contents);
    renderTableContents(htmlTableElement);
}

function renderTableContents(htmlTableElement) {
    render(tableContents.map(tableRow), htmlTableElement);
}