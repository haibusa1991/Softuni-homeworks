import {html} from '/node_modules/lit-html/lit-html.js';
import {repeat} from '/node_modules/lit-html/directives/repeat.js';
import {until} from '/node_modules/lit-html/directives/until.js';
import * as ideaManager from '/src/api/ideaManager.js';

function generateView(tileData) {
    return html`
        <div id="dashboard-holder">
            ${tileData.length === 0
                    ? html`<h1>No ideas yet! Be the first one :)</h1>`
                    : repeat(tileData, generateTile)
            }
        </div>
    `;
}


export async function showDashboard(ctx) {
    try {
        let tileData = ideaManager.getIdeas();
        ctx.render(until(tileData.then(e => generateView(e)), html`<div id="dashboard-holder"><h1>Loading...</h1></div>`));
    } catch (e) {
        alert(e.message);
    }
}

function generateTile(ideaObject) {
    return html`
        <div class="card overflow-hidden current-card details" style="width: 20rem; height: 18rem;">
            <div class="card-body">
                <p class="card-text">${ideaObject.title}</p>
            </div>
            <img class="card-image" src="${ideaObject.img}" alt="Card image cap">
            <a class="btn" id="${ideaObject._id}" href="/details/${ideaObject._id}">Details</a>
        </div>
    `;
}