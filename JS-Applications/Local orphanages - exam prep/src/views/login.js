import {html} from '/node_modules/lit-html/lit-html.js';
import * as userManager from '/src/api/users.js';

function getView(ctx) {
    return html`
        <section id="login-page" class="auth">
            <form @submit="${(e) => onSubmit(e, ctx)}" id="login">
                <h1 class="title">Login</h1>

                <article class="input-group">
                    <label for="login-email">Email: </label>
                    <input type="email" id="login-email" name="email">
                </article>

                <article class="input-group">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password">
                </article>

                <input type="submit" class="btn submit-btn" value="Log In">
            </form>
        </section>
    `;
}

export async function showLoginView(ctx) {
    ctx.render(getView(ctx));
}

async function onSubmit(e, ctx) {
    e.preventDefault();
    let formData = new FormData(e.target);
    let [email, password] = formData.values();
    try {
        if (email.length === 0 || password.length === 0) {
            throw new Error('Form cannot contain empty fields!');
        }

        await userManager.loginUser(email, password);
        ctx.page.redirect('/');
    } catch (e) {
        alert(e.message);
    }
}