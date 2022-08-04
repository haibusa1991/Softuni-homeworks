import {html} from '/node_modules/lit-html/lit-html.js';

function getView(ctx) {
    return html`
        <h1><a href="/">Orphelp</a></h1>
        <nav>
            <a href="/">Dashboard</a>
            ${ctx.user ?
                    html`


                        <!-- Logged-in users -->
                        <div id="user">
                            <a href="/my-posts">My Posts</a>
                            <a href="/create-post">Create Post</a>
                            <a href="/logout">Logout</a>
                        </div>`
                    : html`
                        <!-- Guest users -->
                        <div id="guest">
                            <a href="/login">Login</a>
                            <a href="/register">Register</a>
                        </div>
                        </nav>
                    `}
    `;
}

export function showNavigation(ctx) {
    return getView(ctx);
}