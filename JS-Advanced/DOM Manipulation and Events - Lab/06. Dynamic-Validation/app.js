function validate() {
    let field = document.getElementById('email');
    let regex = new RegExp('[a-z]+@[a-z]+\\.[a-z]+', 'g');

    field.addEventListener('change', onChange);

    function onChange(event) {
        if (field.value.match(regex) === null) {
            event.target.classList.add('error');
            return;
        }

        event.target.classList.remove('error');
    }

}