import {html} from '/node_modules/lit-html/lit-html.js';

function generateNav(activeView, isGuest) {
    return html`
        <div class="container">
            <a class="navbar-brand" href="">
                <a href="/"><img src="./images/idea.png" alt=""></a>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item ${activeView === '/dashboard' ? 'active' : ''}">
                        <a class="nav-link" href="/dashboard">Dashboard</a>
                    </li>
                    ${isGuest ?
                            html`
                                <li class="nav-item ${activeView === '/create' ? 'active' : ''}">
                                    <a class="nav-link" href="/create">Create</a>
                                </li>
                                <li class="nav-item ${activeView === '/logout' ? 'active' : ''}">
                                    <a class="nav-link" href="/logout">Logout</a>
                                </li>`
                            : html`
                                <li class="nav-item ${activeView === '/login' ? 'active' : ''}">
                                    <a class="nav-link" href="/login">Login</a>
                                </li>
                                <li class="nav-item ${activeView === '/register' ? 'active' : ''}">
                                    <a class="nav-link" href="/register">Register</a>
                                </li>`
                    }
                </ul>
            </div>
        </div>
    `;
}

export function showNavigation(ctx) {
    return generateNav(ctx.path, !(!ctx.user()));
}