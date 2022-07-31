window.onload = init;

let canvas = document.querySelector('main');

let registerView = generateRegisterView();
let loginView = generateLoginView();
let homeView = generateHomeView();

function init() {
    document.querySelector('#home').addEventListener('click', (e, view) => showView(e, homeView));
    document.querySelector('#register').addEventListener('click', (e, view) => showView(e, registerView));
    document.querySelector('#login').addEventListener('click', (e, view) => showView(e, loginView));
    document.querySelector('#logout').addEventListener('click', onLogout);
    validateExistingToken();

    document.querySelector('#home').click();
}

function showView(e, view) {
    deselectAllButtons();
    e.target.classList.add('active');
    canvas.replaceChildren(view);
    if (e.target.id === 'home') {
        updateTileButtons();
    }
    updateNavigationButtons();

}

function deselectAllButtons() {
    let buttons = Array.from(document.querySelectorAll('nav a'));
    for (let button of buttons) {
        button.classList.remove('active');
    }
}

function updateNavigationButtons() {
    sessionStorage.authToken === undefined
        ? showGuestButtons()
        : showUserButtons();
}

async function onLogout() {
    await fetch('http://localhost:3030/users/logout', {
        method: 'get',
        headers: {
            'X-Authorization': sessionStorage.authToken
        }
    });

    clearStorage();
    document.querySelector('#home').click();
}

async function onLogin(e) {
    e.preventDefault();
    let emailField = e.target.parentElement.querySelector('input[name=email]');
    let passwordField = e.target.parentElement.querySelector('input[name=password]');

    try {
        let body = JSON.stringify({email: emailField.value, password: passwordField.value});

        let response = await fetch('http://localhost:3030/users/login', {
            method: 'post',
            body
        });

        let data = await response.json();
        if (response.status === 403) {
            throw new Error('Email or password not correct');
        }

        sessionStorage.authToken = data.accessToken;
        sessionStorage.userId = data._id;
        sessionStorage.loggedUser = data.email;

        emailField.style.background = '';
        passwordField.style.background = '';

        emailField.value = '';
        passwordField.value = '';

        document.querySelector('#home').click();

    } catch (e) {
        alert(e.message);
        emailField.style.background = 'lightcoral';
        passwordField.style.background = 'lightcoral';
    }

}

async function onRegister(e) {
    e.preventDefault();

    let emailField = e.target.parentElement.querySelector('input[name=email]');
    let passwordField = e.target.parentElement.querySelector('input[name=password]');
    let repassField = e.target.parentElement.querySelector('input[name=rePass]');

    try {

        if (passwordField.value !== repassField.value) {
            throw new Error('Passwords do not match');
        }

        let body = JSON.stringify({email: emailField.value, password: passwordField.value});
        let response = await fetch('http://localhost:3030/users/register', {
            method: 'post',
            body
        });

        let data = await response.json();

        if (response.status === 409) {
            throw new Error(data.message);
        }

        sessionStorage.authToken = data.accessToken;
        sessionStorage.userId = data._id;
        sessionStorage.loggedUser = data.email;

        emailField.value = '';
        passwordField.value = '';
        repassField.value = '';

        document.querySelector('#home').click();

    } catch (e) {
        alert(e);
    }
}

function validateExistingToken() {
    let authToken = sessionStorage.authToken;

    if (authToken !== undefined) {
        let request = new XMLHttpRequest();
        request.open('post', 'http://localhost:3030/data/catches/', false);
        request.setRequestHeader('X-Authorization', authToken);
        request.send();

        if (request.status !== 500) {
            clearStorage();
        }
    }
}

function showGuestButtons() {
    document.querySelector('nav #user').style.display = 'none';
    document.querySelector('nav #guest').style.display = 'inline';
    document.querySelector('nav p span').textContent = 'guest'
}

function showUserButtons() {
    document.querySelector('nav #guest').style.display = 'none';
    document.querySelector('nav #user').style.display = 'inline';
    document.querySelector('nav p span').textContent = sessionStorage.loggedUser;
}

function clearStorage() {
    sessionStorage.removeItem('authToken');
    sessionStorage.removeItem('loggedUser');
    sessionStorage.removeItem('userId');
}

function generateHomeView() {
    let view = document.createElement('section');
    view.innerHTML = `
     <fieldset style="border: none" id="main">
                <legend>Click to load catches</legend>
                <div id="catches">
                </div>
            </fieldset>
            <aside>
                <button class="load">Load</button>
                <form id="addForm">
                    <fieldset>
                        <legend>Add Catch</legend>
                        <label>Angler</label>
                        <input type="text" name="angler" class="angler" />
                        <label>Weight</label>
                        <input type="number" name="weight" class="weight" />
                        <label>Species</label>
                        <input type="text" name="species" class="species" />
                        <label>Location</label>
                        <input type="text" name="location" class="location" />
                        <label>Bait</label>
                        <input type="text" name="bait" class="bait" />
                        <label>Capture Time</label>
                        <input type="number" name="captureTime" class="captureTime" />
                        <button disabled class="add">Add</button>
                    </fieldset>
                </form>
            </aside>`;

    view.querySelector('button.load').addEventListener('click', onCatchesLoad);
    view.querySelector('#catches').addEventListener('click', onCatchButtonClick)
    view.querySelector('aside .add').addEventListener('click', onAdd)
    return view;
}

function generateLoginView() {
    let view = document.createElement('section');
    view.innerHTML = `
         <section id="login-view">
            <h2>Login</h2>
            <form id="login">
                <label>Email: <input type="text" name="email"></label>
                <label>Password: <input type="password" name="password"></label>
                <p class="notification"></p>
                <button>Login</button>
            </form>
        </section>`;

    view.querySelector('button').addEventListener('click', onLogin);

    return view;
}

function generateRegisterView() {
    let view = document.createElement('section');
    view.innerHTML = `
        <section id="register-view">
            <h2>Register</h2>
            <form id="register">
                <label>Email: <input type="text" name="email"></label>
                <label>Password: <input type="password" name="password"></label>
                <label>Repeat: <input type="password" name="rePass"></label>
                <p class="notification"></p>
                <button>Register</button>
            </form>
        </section>`;

    view.querySelector('button').addEventListener('click', onRegister);

    return view;
}

function generateCatchTile(data) {
    let div = document.createElement('div');
    div.innerHTML = `
  <label>Angler</label>
        <input type="text" class="angler" value="${data.angler}" disabled>
        <label>Weight</label>
        <input type="text" class="weight" value="${data.weight}" disabled>
        <label>Species</label>
        <input type="text" class="species" value="${data.species}" disabled>
        <label>Location</label>
        <input type="text" class="location" value="${data.location}" disabled>
        <label>Bait</label>
        <input type="text" class="bait" value="${data.bait}" disabled>
        <label>Capture Time</label>
        <input type="number" class="captureTime" value="${data.captureTime}" disabled>
        <button class="update" name="testUpdateButton" data-id="${data._id}" disabled>Update</button>
        <button class="delete" data-id="${data._id}" disabled>Delete</button>
 `;

    div.dataset.ownerId = data._ownerId;
    div.classList.add('catch');
    return div;
}

async function onCatchesLoad() {

    let response = await fetch('http://localhost:3030/data/catches/');
    let data = await response.json();

    let catches = [];
    for (let fishCatch of data) {
        catches.push(generateCatchTile(fishCatch));
    }
    document.querySelector('main legend').textContent = 'Catches';
    document.querySelector('fieldset').style.border = ''

    document.querySelector('#catches').replaceChildren(...catches);

    updateTileButtons();
}

function updateTileButtons() {
    let addButton = homeView.querySelector('aside button.add');
    let tileElements = Array.from(document.querySelectorAll('.catch input, .catch button'));

    addButton.disabled = true;
    for (let e of tileElements) {
        e.disabled = true;
    }

    let isUser = sessionStorage.authToken !== undefined;

    if (!isUser) return;

    if (isUser) {
        addButton.disabled = false;
    }

    let ownTiles = Array.from(document.querySelectorAll('.catch'))
        .filter(e => e.dataset.ownerId === sessionStorage.userId);
    ownTiles.forEach(e => Array.from(e.querySelectorAll('.catch input, .catch button'))
        .forEach(e1 => e1.disabled = false));
}

function onCatchButtonClick(e) {
    let id = e.target.dataset.id;

    if (id === undefined) {
        return;
    }

    if (e.target.className === 'update') {
        onUpdate(e.target);
        return;
    }

    onDelete(id);
}

async function onAdd(e) {
    e.preventDefault();
    let fields = Array.from(e.target.parentElement.querySelectorAll('input'));

    let angler = fields[0].value;
    let weight = fields[1].value;
    let species = fields[2].value;
    let location = fields[3].value;
    let bait = fields[4].value;
    let captureTime = fields[5].value;

    let body = JSON.stringify({angler, weight, species, location, bait, captureTime});

    let response = await fetch('http://localhost:3030/data/catches', {
        method: 'post',
        headers: {
            'X-Authorization': sessionStorage.authToken
        },
        body
    });

    let data = await response.json();

    for (let field of fields) {
        field.value = '';
    }
    onCatchesLoad();
    // document.querySelector('#home').click();
}

async function onDelete(postId) {
    await fetch('http://localhost:3030/data/catches/' + postId, {
        method: 'delete',
        headers: {
            'X-Authorization': sessionStorage.authToken
        }
    });

    onCatchesLoad();
}

async function onUpdate(tileButton) {
    console.log(`updating tile with id ${tileButton.dataset.id} and owner ${tileButton.parentElement.dataset.ownerId}`);

    let fields = Array.from(tileButton.parentElement.querySelectorAll('input'));

    let angler = fields[0].value;
    let weight = fields[1].value;
    let species = fields[2].value;
    let location = fields[3].value;
    let bait = fields[4].value;
    let captureTime = fields[5].value;

    let body = JSON.stringify({angler, weight, species, location, bait, captureTime});

    let response = await fetch('http://localhost:3030/data/catches/' + tileButton.dataset.id, {
        method: 'put',
        headers: {
            'X-Authorization': sessionStorage.authToken
        },
        body
    });

    onCatchesLoad();
}

