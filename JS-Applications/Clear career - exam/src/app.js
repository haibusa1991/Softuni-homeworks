import page from '/node_modules/page/page.mjs';
import {render} from '/node_modules/lit-html/lit-html.js';
import * as sessionManager from '/src/api/sessionManager.js';
import * as users from '/src/api/users.js';

import {showHomeView} from '/src/views/homeView.js';
import {showNavigation} from '/src/views/navigation.js';
import {showLoginView} from '/src/views/login.js';
import {showRegisterView} from '/src/views/register.js';
import {showDashboard} from '/src/views/dashboard.js';
import {showCreateView} from '/src/views/create.js';
import {showDetailsView} from '/src/views/details.js';
import {showEditView} from '/src/views/edit.js';
import {showDeleteView} from '/src/views/delete.js';

const main = document.querySelector('main');
const navContainer = document.querySelector('header');

page(decorateContext);
page('/', showHomeView);
page('/dashboard', showDashboard);
page('/login', showLoginView);
page('/register', showRegisterView);
page('/logout', users.logoutUser)
page('/create-offer', showCreateView)
page('/details/:id', showDetailsView)
page('/edit-offer/:id', showEditView)
page('/delete-offer/:id', showDeleteView)
page.start();

function decorateContext(ctx, next) {
    ctx.user = getUser();
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