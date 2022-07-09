function lockedProfile() {
    let buttons = Array.from(document.querySelectorAll('button'));
    for (let button of buttons) {
        button.addEventListener('click', onClick);
    }

    function onClick(event) {
        let isLocked = event.target.parentElement.querySelector('input').checked;
        if (!isLocked) {
            let buttonText = event.target.parentElement.querySelector('button').textContent;
            if (buttonText === 'Hide it') {
                hideExtraInfo(event);
            } else {
                showExtraInfo(event);
            }
        }
    }

    function showExtraInfo(event) {
        event.target.textContent = 'Hide it';
        event.target.parentElement.querySelector('div').style.display = 'inline';
    }

    function hideExtraInfo(event) {
        event.target.textContent = 'Show more';
        event.target.parentElement.querySelector('div').style.display = 'none';
    }
}