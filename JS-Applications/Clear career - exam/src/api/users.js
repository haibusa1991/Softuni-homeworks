import * as api from '/src/api/api.js';
import * as sessionManager from '/src/api/sessionManager.js';

export async function loginUser(email, password) {
    let body = {email: email, password: password};
    try {
        let user = await api.post('/users/login', body);
        sessionManager.setUserData(user);
    } catch (e) {
        throw new Error(e.message);
    }
}

export async function registerUser(email, password) {
    let body = {email: email, password: password};
    try {
        let user = await api.post('/users/register', body);
        sessionManager.setUserData(user);
    } catch (e) {
        throw new Error(e.message);
    }
}

export async function logoutUser(ctx) {
    api.get('/users/logout');
    sessionManager.clearUserData();
    ctx.page.redirect('/');
}