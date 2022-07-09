class Contact {
    constructor(firstName, lastName, phone, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.online = false;

        this.generateInfobox();
    }

    generateInfobox() {
        this.infobox = document.createElement('article');
        this.infobox.innerHTML = `<div class="title">${this.firstName} ${this.lastName}<button>&#8505;</button></div>
            <div class="info">
            <span>&phone; ${this.phone}</span>
            <span>&#9993; ${this.email}</span>
        </div>`

        this.infobox.querySelectorAll('div')[1].style.display = 'none';
        this.infobox.querySelector('button').addEventListener('click', onClick);

        function onClick(e) {
            let div = e.target.parentElement.parentElement.querySelectorAll('div')[1];

            if (div.style.display === 'none' || div.style.display === '') {
                div.style.display = 'block';
                return;
            }

            div.style.display = 'none';
        }
    }

    set online(value) {
        this._online = value;
        if (this.infobox === undefined) {
            return;
        }

        value === true
            ? this.infobox.querySelector('div').classList.add('online')
            : this.infobox.querySelector('div').classList.remove('online');
    }

    get online() {
        return this._online;
    }

    render(id) {
        document.getElementById(id).appendChild(this.infobox);
    }
}