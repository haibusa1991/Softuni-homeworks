import {html} from '/node_modules/lit-html/lit-html.js';
import * as userManager from '/src/api/users.js';

function getView(ctx) {
    return html`
        <section id="register-page" class="auth">
            <form @submit="${e => onRegister(e, ctx)}" id="register">
                <h1 class="title">Register</h1>

                <article class="input-group">
                    <label for="register-email">Email: </label>
                    <input type="email" id="register-email" name="email">
                </article>

                <article class="input-group">
                    <label for="register-password">Password: </label>
                    <input type="password" id="register-password" name="password">
                </article>

                <article class="input-group">
                    <label for="repeat-password">Repeat Password: </label>
                    <input type="password" id="repeat-password" name="repeatPassword">
                </article>

                <input type="submit" class="btn submit-btn" value="Register">
            </form>
        </section>
    `;
}

export async function showRegisterView(ctx) {
    ctx.render(getView(ctx));
}

async function onRegister(e, ctx) {
    e.preventDefault();
    let formData = new FormData(e.target);
    let [email, password, repass] = formData.values();
    try {
        if (email.length === 0 || password.length === 0) {
            throw new Error('Form cannot contain empty fields!');
        }

        if (password !== repass) {
            throw new Error('Passwords do not match');

        }
        await userManager.registerUser(email, password);
        ctx.page.redirect('/');
    } catch (e) {
        alert(e.message);
    }
}