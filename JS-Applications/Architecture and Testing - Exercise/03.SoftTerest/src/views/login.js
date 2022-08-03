import {html} from '/node_modules/lit-html/lit-html.js';
import * as users from '/src/api/users.js';

function generateView(ctx) {
    return html`
        <div class="row-form d-md-flex flex-mb-equal ">
            <div class="col-md-4">
                <img class="responsive" src="./images/idea.png" alt="">
            </div>
            <form @submit="${(e) => onLogin(e, ctx)}" class="form-user col-md-7" action="" method="">
                <div class="text-center mb-4">
                    <h1 class="h3 mb-3 font-weight-normal">Login</h1>
                </div>
                <div class="form-label-group">
                    <label for="inputEmail">Email</label>
                    <input type="text" id="inputEmail" name="email" class="form-control" placeholder="Email" required=""
                           autofocus="">
                </div>
                <div class="form-label-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" id="inputPassword" name="password" class="form-control"
                           placeholder="Password" required="">
                </div>
                <div class="text-center mb-4 text-center">
                    <button class="btn btn-lg btn-dark btn-block" type="submit">Sign In</button>
                    <p class="alreadyUser"> Don't have account? Then just
                        <a href="/register">Sign-Up</a>!
                    </p>
                </div>
                <p class="mt-5 mb-3 text-muted text-center">© SoftTerest - 2019.</p>
            </form>
        </div>
    `;
}

export async function showLoginView(ctx) {
    ctx.render(generateView(ctx));
}

async function onLogin(e, ctx) {
    e.preventDefault();
    let form = new FormData(e.target);

    let [email, password] = Array.from(form.values());
    try {
        await users.loginUser(email, password);
        e.target.reset();
        ctx.page.redirect('/');
    } catch (e) {
        alert(e.message);
    }

}