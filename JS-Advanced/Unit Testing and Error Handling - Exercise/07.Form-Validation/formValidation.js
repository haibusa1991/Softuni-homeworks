function validate() {
    let checkbox = document.querySelector('#company');
    checkbox.addEventListener('change', onCheckboxClick)

    document.querySelector('#submit').addEventListener('click', onSubmit)

    let usernameField = document.querySelector('#username');
    let emailField = document.querySelector('#email');
    let passwordField = document.querySelector('#password');
    let passwordConfirmField = document.querySelector('#confirm-password');
    let companyNumber = document.querySelector('#companyNumber');

    let invalidFields = [];
    let fields = [usernameField,
        emailField,
        passwordField,
        passwordConfirmField,
        companyNumber]

    function validateUsername() {
        let regex = RegExp('^[A-Za-z0-9]{3,20}$', 'g');
        if (!regex.test(usernameField.value)) {
            invalidFields.push(usernameField);
        }
    }

    function validateEmail() {
        let regex = RegExp('^[^@]*@[^@]*\\.[^@]*$');
        if (!regex.test(emailField.value)) {
            invalidFields.push(emailField);
        }
    }

    function validatePassword(field) {
        let regex = RegExp('^[\\w]{5,15}$', 'g');
        if (!regex.test(field.value)) {
            invalidFields.push(field);
        }
    }

    function validatePasswordMatch() {
        if (passwordField.value !== passwordConfirmField.value) {
            invalidFields.push(passwordField);
            invalidFields.push(passwordConfirmField);
        }
    }

    function validateNumber() {
        if (checkbox.checked) {
            let num = Number(companyNumber.value);
            if (num < 1000 || num > 9999 || Number.isNaN(num)) {
                invalidFields.push(companyNumber);
            }
        }
    }


    function setWhite(field) {
        field.style.border = 'none';
    }

    function setRed(field) {
        field.style.borderColor = 'red';
    }

    function onSubmit(e) {
        e.preventDefault();

        validateUsername();
        validateEmail();
        validatePassword(passwordField);
        validatePassword(passwordConfirmField);
        validatePasswordMatch();
        validateNumber();


        invalidFields.forEach(e => setRed(e));

        fields.filter(e => !invalidFields.includes(e)).forEach(e => setWhite(e));

        let okDiv = document.querySelector('#valid');
        invalidFields.length === 0
            ? okDiv.style.display = 'block'
            : okDiv.style.display = 'none';

        invalidFields = [];
    }


    function onCheckboxClick(e) {
        let companyInfo = document.querySelector('#companyInfo');
        e.target.checked
            ? companyInfo.style.display = 'block'
            : companyInfo.style.display = 'none';
    }
}

