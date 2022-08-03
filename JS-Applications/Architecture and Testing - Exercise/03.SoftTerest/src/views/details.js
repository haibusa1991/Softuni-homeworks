import {html} from '/node_modules/lit-html/lit-html.js';
import * as ideaManager from '/src/api/ideaManager.js';
import * as sessionManager from '/src/api/sessionManager.js';

function generateView(ctx, ideaDetails, isOwner) {
    return html`
        <div class="container home some">
            <img class="det-img" src="${ideaDetails.img}"/>
            <div class="desc">
                <h2 class="display-5">${ideaDetails.title}</h2>
                <p class="infoType">Description:</p>
                <p class="idea-description">${ideaDetails.description}</p>
            </div>
            ${isOwner
                    ? html`
                        <div @click="${() => onDelete(ctx, ideaDetails._id)}" class="text-center">
                            <a class="btn detb" href="">Delete</a>
                        </div>`
                    : ''
            }
        </div>
    `;
}

export async function showDetails(ctx) {
    let ideaId = ctx.params.id;
    let ideaDetails = await ideaManager.getIdeaDetails(ideaId);
    let id = sessionManager.getUserData()?._id;
    let isOwner = id === ideaDetails._ownerId;
    ctx.render(generateView(ctx, ideaDetails, isOwner));
}

async function onDelete(ctx, ideaId) {
    try {
        await ideaManager.deleteIdea(ideaId)
        ctx.page.redirect('/dashboard');
    } catch (e) {
        alert(e.message);
    }
}