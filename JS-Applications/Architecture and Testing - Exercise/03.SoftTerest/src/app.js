import page from '/node_modules/page/page.mjs';
import {render} from '/node_modules/lit-html/lit-html.js';
import * as sessionManager from '/src/api/sessionManager.js';
import * as users from '/src/api/users.js';

import {showMainView} from '/src/views/mainView.js';
import {showNavigation} from '/src/views/navigation.js';
import {showLoginView} from '/src/views/login.js';
import {showRegisterView} from '/src/views/register.js';
import {showDashboard} from '/src/views/dashboard.js';
import {showCreateView} from '/src/views/create.js';
import {showDetails} from '/src/views/details.js';
import {showEmpty} from '/src/views/empty.js';

const main = document.querySelector('#mainContainer');
const navContainer = document.querySelector('#navContainer');

page(decorateContext);
page('/', showMainView);
page('/dashboard', showDashboard);
page('/login', showLoginView);
page('/register', showRegisterView);
page('/logout', users.logoutUser)
page('/create', showCreateView)
page('/details/:id', showDetails)
page.start();

function decorateContext(ctx, next) {
    ctx.user = getUser;
    navRenderer(ctx);
    ctx.render = viewRenderer;
    next();
}

function viewRenderer(view) {
    render(view, main);
}

function navRenderer(ctx) {
    render(showNavigation(ctx), navContainer);
}

function getUser() {
    return sessionManager.getUserData();
}