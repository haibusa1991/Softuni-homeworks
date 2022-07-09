function focused() {

    let divs = Array.from(document.querySelectorAll('div div'));
    for (let div of divs) {
        div.querySelector('input').addEventListener('focus', onFocus);
        div.querySelector('input').addEventListener('blur', onBlur);
    }

    function onFocus(event) {
        event.target.parentElement.classList.add('focused');
    }

    function onBlur(event) {
        event.target.parentElement.classList.remove('focused');
    }
}