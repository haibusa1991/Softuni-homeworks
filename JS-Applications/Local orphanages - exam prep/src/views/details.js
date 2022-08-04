import {html} from '/node_modules/lit-html/lit-html.js';
import * as postsManager from '/src/api/postsManager.js'

function getView(postDetails, isOwner, donations, ctx) {
    return html`
        <section id="details-page">
            <h1 class="title">Post Details</h1>

            <div id="container">
                <div id="details">
                    <div class="image-wrapper">
                        <img src="${postDetails.imageUrl}" alt="${postDetails.title}" class="post-image">
                    </div>
                    <div class="info">
                        <h2 class="title post-title">${postDetails.title}</h2>
                        <p class="post-description">Description: ${postDetails.description}</p>
                        <p class="post-address">Address: ${postDetails.address}</p>
                        <p class="post-number">Phone number: ${postDetails.phone}</p>
                        <p class="donate-Item">Donate Materials: ${donations.totalDonations}</p>

                        <!--Edit and Delete are only for creator-->
                        <div class="btns">
                            ${isOwner ? html`
                                <a href="/edit/${postDetails._id}" class="edit-btn btn">Edit</a>
                                <a href="/delete/${postDetails._id}" class="delete-btn btn">Delete</a>` : ''}
                            <!--Bonus - Only for logged-in users ( not authors )-->
                            ${donations.canDonate ? html`<a @click="${e => onDonate(e, postDetails._id, ctx)}" href=""
                                                            class="donate-btn btn">Donate</a>` : ''}
                        </div>

                    </div>
                </div>
            </div>
        </section>
    `;
}

export async function showDetailsView(ctx) {
    try {
        let postId = ctx.params.id;
        let postDetails = await postsManager.getPostDetails(postId);
        let ownerId = ctx.user?._id;

        let isOwner = ownerId === postDetails._ownerId;

        let donations = await getDonations(ctx, postDetails._ownerId)
        ctx.render(getView(postDetails, isOwner, donations, ctx));
    } catch (e) {
        alert(e.message);
    }
}

async function getDonations(ctx, ownerId) {

    let postId = ctx.params.id;
    let userId = ctx.user?._id;

    let totalDonations = await postsManager.getPostDonationsById(postId);
    let canDonateToPost = await postsManager.getUserCanDonate(postId, userId);
    let isOwner = ownerId === userId;

    let canDonate = canDonateToPost && !isOwner &&userId;

    return {totalDonations, canDonate}
}

async function onDonate(e, postId, ctx) {
    try {
        postsManager.donateToPost(postId);
        showDetailsView(ctx)
    } catch (e) {
        alert(e.message);
    }
}
