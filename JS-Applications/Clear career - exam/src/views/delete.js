import * as offersManager from '/src/api/offersManager.js'

export function showDeleteView(ctx) {
    let response = confirm('Are you sure you want to delete this offer?');
    if (response) {
        offersManager.deleteOffer(ctx.params.id);
        ctx.page.redirect('/dashboard');
    }
}