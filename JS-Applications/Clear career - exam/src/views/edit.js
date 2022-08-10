import {html} from '/node_modules/lit-html/lit-html.js';
import * as offersManager from '/src/api/offersManager.js'

function getView(ctx, offerDetails) {
    return html`
        <section id="edit">
            <div class="form">
                <h2>Edit Offer</h2>
                <form @submit="${e=> onSubmit(e,ctx,offerDetails._id)}" class="edit-form">
                    <input
                            type="text"
                            name="title"
                            id="job-title"
                            placeholder="Title"
                            value="${offerDetails.title}"
                    />
                    <input
                            type="text"
                            name="imageUrl"
                            id="job-logo"
                            placeholder="Company logo url"
                            value="${offerDetails.imageUrl}"
                    />
                    <input
                            type="text"
                            name="category"
                            id="job-category"
                            placeholder="Category"
                            value="${offerDetails.category}"
                    />
                    <textarea
                            id="job-description"
                            name="description"
                            placeholder="Description"
                            rows="4"
                            cols="50"
                    >${offerDetails.description}</textarea>
                    <textarea
                            id="job-requirements"
                            name="requirements"
                            placeholder="Requirements"
                            rows="4"
                            cols="50"
                            
                    >${offerDetails.requirements}</textarea>
                    <input
                            type="text"
                            name="salary"
                            id="job-salary"
                            placeholder="Salary"
                            value="${offerDetails.salary}"
                    />
                    <button type="submit">post</button>
                </form>
            </div>
        </section>
    `;
}

export async function showEditView(ctx) {
    try {
        let offerId = ctx.params.id;
        let offerDetails = await offersManager.getOfferDetails(offerId);

        ctx.render(getView(ctx, offerDetails));
    } catch (e) {
        alert(e.message);
    }
}

async function onSubmit(e, ctx, offerId) {

    e.preventDefault();
    let formData = new FormData(e.target);
    let [title, imageUrl, category, description, requirements,salary] = formData.values();

    try {
        let offerData = {
            title,
            imageUrl,
            category,
            description,
            requirements,
            salary
        };

        let emptyValues = Object.values(offerData).map(e => e.trim()).filter(e => e.length === 0);
        if (emptyValues.length > 0) {
            throw new Error('All fields are required!');
        }

        await offersManager.editOffer(offerId, offerData);
        ctx.page.redirect('/details/' + offerId);
    } catch (e) {
        alert(e.message);
    }
}