import {html} from '/node_modules/lit-html/lit-html.js';
import * as userManager from '/src/api/users.js';

function getView(ctx) {
    return html`
        <section id="register">
            <div class="form">
                <h2>Register</h2>
                <form @submit="${e => onRegister(e, ctx)}" class="login-form">
                    <input
                            type="text"
                            name="email"
                            id="register-email"
                            placeholder="email"
                    />
                    <input
                            type="password"
                            name="password"
                            id="register-password"
                            placeholder="password"
                    />
                    <input
                            type="password"
                            name="re-password"
                            id="repeat-password"
                            placeholder="repeat password"
                    />
                    <button type="submit">register</button>
                    <p class="message">Already registered? <a href="/login">Login</a></p>
                </form>
            </div>
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
        ctx.page.redirect('/dashboard');
    } catch (e) {
        alert(e.message);
    }
}