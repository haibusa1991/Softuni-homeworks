import {api} from './api.js';

init();

function init() {
    let buttons = Array.from(document.querySelectorAll('form button'));
    buttons[0].addEventListener('click', onRegister);
    buttons[1].addEventListener('click', onLogin);

}

async function onRegister(e) {
    e.preventDefault();
    let formData = new FormData(document.querySelector('form'));
    let [email, password, repass] = formData.values();

    try {
        if (email === '' || password === '') {
            throw new Error('Empty fields are not allowed!');
        }

        if (password !== repass) {
            throw new Error('Passwords do not match!');
        }

        let user = await api().post('http://localhost:3030/users/register', {email, password});
        sessionStorage.user = JSON.stringify(user);
        window.location = 'index.html'


    } catch (e) {
        if (e.message === 'Error: 409') {
            alert('Email already registered!')
        } else {
            alert(e.message);
        }
    }
}

async function onLogin(e) {
    e.preventDefault();
    let formData = new FormData(Array.from(document.querySelectorAll('form'))[1]);
    let [email, password] = formData.values();

    try {
        if (email === '' || password === '') {
            throw new Error('Empty fields are not allowed!');
        }

        let user = await api().post('http://localhost:3030/users/login', {email, password});
        sessionStorage.user = JSON.stringify(user);
        window.location = 'index.html'
    } catch (e) {
        alert('Email or password incorrect!');
    }
}