import {html} from '/node_modules/lit-html/lit-html.js';

function getView(ctx) {
    return html`
        <a id="logo" href="/"
        ><img id="logo-img" src="./images/logo.jpg" alt=""/></a>
        <nav>
            <div>
                <a href="/dashboard">Dashboard</a>
            </div>
            ${ctx.user ?
                    html`
                        <!-- Logged-in users -->
                        <div class="user">
                            <a href="/create-offer">Create Offer</a>
                            <a href="/logout">Logout</a>
                        </div>`
                    : html`
                        <!-- Guest users -->
                        <div class="guest">
                            <a href="/login">Login</a>
                            <a href="/register">Register</a>
                        </div>`}
        </nav>

    `;
}

export function showNavigation(ctx) {
    return getView(ctx);
}