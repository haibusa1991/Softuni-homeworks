import {html} from '/node_modules/lit-html/lit-html.js';
import * as offersManager from '/src/api/offersManager.js'

function getView(offerDetails, isOwner, ctx, application) {
    return html`
        <section id="details">
            <div id="details-wrapper">
                <img id="details-img" src="${offerDetails.imageUrl}" alt="${offerDetails.title}"/>
                <p id="details-title">${offerDetails.title}</p>
                <p id="details-category">
                    Category: <span id="categories">${offerDetails.category}</span>
                </p>
                <p id="details-salary">
                    Salary: <span id="salary-number">${offerDetails.salary}</span>
                </p>
                <div id="info-wrapper">
                    <div id="details-description">
                        <h4>Description</h4>
                        <span>${offerDetails.description}</span
                        >
                    </div>
                    <div id="details-requirements">
                        <h4>Requirements</h4>
                        <span>${offerDetails.requirements}</span
                        >
                    </div>
                </div>
                <p>Applications: <strong id="applications">${application.totalApplications}</strong></p>

                <!--Edit and Delete are only for creator-->

                <div id="action-buttons">
                    ${isOwner
                            ? html`
                                <a href="/edit-offer/${offerDetails._id}" id="edit-btn">Edit</a>
                                <a href="/delete-offer/${offerDetails._id}" id="delete-btn">Delete</a>
                            ` : ''}

                    <!--Bonus - Only for logged-in users ( not authors )-->
                    ${application.canApply
                            ? html`<a @click="${e => onApply(e, offerDetails._id, ctx)}" href=""
                                      id="apply-btn">Apply</a>`
                            : ''}
                </div>
            </div>
        </section>
    `;
}

export async function showDetailsView(ctx) {
    try {
        let offerId = ctx.params.id;
        let offerDetails = await offersManager.getOfferDetails(offerId);
        let ownerId = ctx.user?._id;

        let isOwner = ownerId === offerDetails._ownerId;

        let application = await getApplications(ctx, offerDetails._ownerId)
        ctx.render(getView(offerDetails, isOwner, ctx, application));
    } catch (e) {
        alert(e.message);
    }
}

async function getApplications(ctx, ownerId) {

    let offerId = ctx.params.id;
    let userId = ctx.user?._id;

    let totalApplications = await offersManager.getOfferApplicationsById(offerId);
    let canApplyToOffer = await offersManager.getUserCanApply(offerId, userId);
    let isOwner = ownerId === userId;

    let canApply = canApplyToOffer && !isOwner && userId;

    return {totalApplications, canApply}
}

async function onApply(e, offerId, ctx) {
    try {
        offersManager.applyForOffer(offerId);
        showDetailsView(ctx)
    } catch (e) {
        alert(e.message);
    }
}
