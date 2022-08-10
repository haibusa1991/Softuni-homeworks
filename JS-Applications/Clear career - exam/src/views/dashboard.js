import {html} from '/node_modules/lit-html/lit-html.js';
import {repeat} from '/node_modules/lit-html/directives/repeat.js';
import * as offersManager from '/src/api/offersManager.js'

function getView(offers) {
    return html`
        <section id="dashboard">
            <h2>Job Offers</h2>
            ${offers.length > 0
                    ? html`${repeat(offers, generateOffer)}`
                    : html`<h2>No offers yet.</h2>`}
        </section>`

}

export async function showDashboard(ctx) {
    try {
        let offers = await offersManager.getAllOffers();
        ctx.render(getView(offers));
    } catch (e) {
        alert(e.message);
    }
}

function generateOffer(offerData) {
    return html`
        <div class="offer">
            <img src="${offerData.imageUrl}" alt="${offerData.title}"/>
            <p>
                <strong>Title: </strong><span class="title">${offerData.title}</span>
            </p>
            <p><strong>Salary:</strong><span class="salary">${offerData.salary}</span></p>
            <a class="details-btn" href="/details/${offerData._id}">Details</a>
        </div>
    `;
}