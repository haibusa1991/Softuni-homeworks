function validate() {
    let field = document.querySelector('#email');
    field.addEventListener('change', onChange)

    let regex = RegExp('[a-z]+@[a-z]+\\.[a-z]+', 'g');


    function onChange(e) {
        e.target.value.match(regex) === null
            ? field.classList.add('error')
            : field.classList.remove('error');
    }
}