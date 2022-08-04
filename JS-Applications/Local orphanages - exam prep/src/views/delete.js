import * as postsManager from '/src/api/postsManager.js'

export function showDeleteView(ctx) {
    let response = confirm('Are you sure you want to delete this post?');
    if (response) {
        postsManager.deletePost(ctx.params.id);
        ctx.page.redirect('/');
    }
}