import {validateToken} from "./util.js";

redirect();

function redirect() {
    let isValid = validateToken();

    if(isValid){
        window.location = 'homeLogged.html';
        return;
    }
    window.location = 'home.html';
}

