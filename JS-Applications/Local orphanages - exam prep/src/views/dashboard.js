import {html} from '/node_modules/lit-html/lit-html.js';
import {repeat} from '/node_modules/lit-html/directives/repeat.js';
import * as postsManager from '/src/api/postsManager.js'

function getView(posts) {
    return html`
        <section id="dashboard-page">
            <h1 class="title">All Posts</h1>
            ${posts.length === 0
                    ? html`<h1 class="title no-posts-title">No posts yet!</h1>`
                    : html`
                        <div class="all-posts">
                            ${repeat(posts, generatePost)}
                        </div>
                    `
            }
        </section>
    `;
}

export async function showDashboard(ctx) {
    try {
        let posts = await postsManager.getAllPosts();
        ctx.render(getView(posts));
    } catch (e) {
        alert(e.message);
    }
}

function generatePost(postData) {
// "_ownerId": "847ec027-f659-4086-8032-5173e2f9c93a",
// "title": "School Supplies",
// "description": "We need 20 striped notebooks and 10 squared notebooks, 5 backpacks, and other school supplies, such as pens, pencils, rulers, erasers, etc.",
// "address": "ul. Manioka Tapioka 25",
// "phone": "0888264871",
// "imageUrl": "/images/school-supplies.jpeg",
// "_createdOn": 1617194295474,
// "_id": "126777f5-3277-42ad-b874-76d043b069cb"
    return html`
        <div class="post">
            <h2 class="post-title">${postData.title}</h2>
            <img class="post-image" src="${postData.imageUrl}" alt="${postData.title}">
            <div class="btn-wrapper">
                <a href="/details/${postData._id}" class="details-btn btn">Details</a>
            </div>
        </div>
    `;
}