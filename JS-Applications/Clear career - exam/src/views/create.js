import {html} from '/node_modules/lit-html/lit-html.js';
import * as offersManager from '/src/api/offersManager.js'

function getView(ctx) {
    return html`
        <section id="create">
          <div class="form">
            <h2>Create Offer</h2>
            <form @submit="${e=> onSubmit(e,ctx)}" class="create-form">
              <input
                type="text"
                name="title"
                id="job-title"
                placeholder="Title"
              />
              <input
                type="text"
                name="imageUrl"
                id="job-logo"
                placeholder="Company logo url"
              />
              <input
                type="text"
                name="category"
                id="job-category"
                placeholder="Category"
              />
              <textarea
                id="job-description"
                name="description"
                placeholder="Description"
                rows="4"
                cols="50"
              ></textarea>
              <textarea
                id="job-requirements"
                name="requirements"
                placeholder="Requirements"
                rows="4"
                cols="50"
              ></textarea>
              <input
                type="text"
                name="salary"
                id="job-salary"
                placeholder="Salary"
              />

              <button type="submit">post</button>
            </form>
          </div>
        </section>
    `;
}

export async function showCreateView(ctx) {
    try {
        ctx.render(getView(ctx));
    } catch (e) {
        alert(e.message);
    }
}

async function onSubmit(e, ctx) {

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

        await offersManager.createOffer(offerData);
        ctx.page.redirect('/dashboard');
    } catch (e) {
        alert(e.message);
    }
}