import {html} from '/node_modules/lit-html/lit-html.js';
import * as ideaManager from '/src/api/ideaManager.js';

function generateView(ctx) {
    return html`
        <div class=" d-md-flex flex-mb-equal ">
            <div class="col-md-6">
                <img class="responsive-ideas create" src="./images/creativity_painted_face.jpg" alt="">
            </div>
            <form @submit="${(e) => onSubmit(e, ctx)}" class="form-idea col-md-5" action="#/create" method="post">
                <div class="text-center mb-4">
                    <h1 class="h3 mb-3 font-weight-normal">Share Your Idea</h1>
                </div>
                <div class="form-label-group">
                    <label for="ideaTitle">Title</label>
                    <input type="text" id="ideaTitle" name="title" class="form-control" placeholder="What is your idea?"
                           required="" autofocus="">
                </div>
                <div class="form-label-group">
                    <label for="ideaDescription">Description</label>
                    <textarea type="text" name="description" class="form-control" placeholder="Description"
                              required=""></textarea>
                </div>
                <div class="form-label-group">
                    <label for="inputURL">Add Image</label>
                    <input type="text" id="inputURL" name="imageURL" class="form-control" placeholder="Image URL"
                           required="">

                </div>
                <button class="btn btn-lg btn-dark btn-block" type="submit">Create</button>

                <p class="mt-5 mb-3 text-muted text-center">© SoftTerest - 2021.</p>
            </form>
        </div>
    `;
}


export async function showCreateView(ctx) {
    ctx.render(generateView(ctx));
}

async function onSubmit(e, ctx) {
    e.preventDefault();
    let formData = new FormData(e.target);
    let [title, description, image] = formData.values();
    try {
        if (title.length < 6) {
            throw new Error("Title must be at least 6 characters long.");
        }
        if (description.length < 10) {
            throw new Error("Description must be at least 10 characters long.");
        }
        if (image.length < 5) {
            throw new Error("Title must be at least 6 characters long.");
        }

        let idea = {
            title: title,
            description: description,
            img: image
        }

        ideaManager.sendIdea(idea);
        e.target.reset();
        ctx.page.redirect('/dashboard');

    } catch (e) {
        alert(e.message);
    }
}