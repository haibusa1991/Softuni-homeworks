import {html} from '/node_modules/lit-html/lit-html.js';
import * as userManager from '/src/api/users.js';

function getView(ctx) {
    return html`
        <section id="login">
            <div class="form">
                <h2>Login</h2>
                <form @submit="${e => onSubmit(e, ctx)}" class="login-form">
                    <input type="text" name="email" id="email" placeholder="email"/>
                    <input
                            type="password"
                            name="password"
                            id="password"
                            placeholder="password"
                    />
                    <button type="submit">login</button>
                    <p class="message">
                        Not registered? <a href="/register">Create an account</a>
                    </p>
                </form>
            </div>
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
        ctx.page.redirect('/dashboard');
    } catch (e) {
        alert(e.message);
    }
}