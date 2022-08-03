import {html} from '/node_modules/lit-html/lit-html.js';


export async function showEmpty(ctx) {
        ctx.render(html`<div id="dashboard-holder"><h1>Nothing here: ${ctx.params.id}</h1></div>`);
}