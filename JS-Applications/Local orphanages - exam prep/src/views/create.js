import {html} from '/node_modules/lit-html/lit-html.js';
import * as postsManager from '/src/api/postsManager.js';

function getView(ctx) {
    return html`
        <section id="create-page" class="auth">
            <form @submit="${e => onSubmit(e, ctx)}" id="create">
                <h1 class="title">Create Post</h1>

                <article class="input-group">
                    <label for="title">Post Title</label>
                    <input type="title" name="title" id="title">
                </article>

                <article class="input-group">
                    <label for="description">Description of the needs </label>
                    <input type="text" name="description" id="description">
                </article>

                <article class="input-group">
                    <label for="imageUrl"> Needed materials image </label>
                    <input type="text" name="imageUrl" id="imageUrl">
                </article>

                <article class="input-group">
                    <label for="address">Address of the orphanage</label>
                    <input type="text" name="address" id="address">
                </article>

                <article class="input-group">
                    <label for="phone">Phone number of orphanage employee</label>
                    <input type="text" name="phone" id="phone">
                </article>

                <input type="submit" class="btn submit" value="Create Post">
            </form>
        </section>
    `;
}

export async function showCreateView(ctx) {
    ctx.render(getView(ctx));
}

async function onSubmit(e, ctx) {
    e.preventDefault();
    let formData = new FormData(e.target);
    let [title, description, image, address, phoneNo] = formData.values();
    try {
        let postData = {
            title: title,
            description: description,
            imageUrl: image,
            address: address,
            phone: phoneNo
        };

        let emptyValues = Object.values(postData).map(e => e.trim()).filter(e => e.length === 0);
        if (emptyValues.length > 0) {
            throw new Error('All fields are required!');
        }

        postsManager.createPost(postData);
        ctx.page.redirect('/');
    } catch (e) {
        alert(e.message);
    }
}