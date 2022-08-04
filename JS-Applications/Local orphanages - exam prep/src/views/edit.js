import {html} from '/node_modules/lit-html/lit-html.js';
import * as postsManager from '/src/api/postsManager.js'

function getView(ctx, postDetails) {
    return html`
        <section id="edit-page" class="auth">
            <form @submit="${e => onSubmit(e, ctx, postDetails._id)}" id="edit">
                <h1 class="title">Edit Post</h1>

                <article class="input-group">
                    <label for="title">Post Title</label>
                    <input type="title" name="title" id="title" value="${postDetails.title}">
                </article>

                <article class="input-group">
                    <label for="description">Description of the needs </label>
                    <input type="text" name="description" id="description" value="${postDetails.description}">
                </article>

                <article class="input-group">
                    <label for="imageUrl"> Needed materials image </label>
                    <input type="text" name="imageUrl" id="imageUrl" value="${postDetails.imageUrl}">
                </article>

                <article class="input-group">
                    <label for="address">Address of the orphanage</label>
                    <input type="text" name="address" id="address" value="${postDetails.address}">
                </article>

                <article class="input-group">
                    <label for="phone">Phone number of orphanage employee</label>
                    <input type="text" name="phone" id="phone" value="${postDetails.phone}">
                </article>

                <input type="submit" class="btn submit" value="Edit Post">
            </form>
        </section>
    `;
}

export async function showEditView(ctx) {
    try {
        let postId = ctx.params.id;
        let postDetails = await postsManager.getPostDetails(postId);
        // let ownerId = ctx.user?._id;
        //
        // let isOwner = ownerId === postDetails._ownerId;
        // let isUser = (ownerId && isOwner === false);

        ctx.render(getView(ctx, postDetails));
    } catch (e) {
        alert(e.message);
    }
}

async function onSubmit(e, ctx, postId) {
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

        await postsManager.editPost(postId, postData);
        ctx.page.redirect('/details/' + postId);
    } catch (e) {
        alert(e.message);
    }
}