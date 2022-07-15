function lockedProfile() {
    document.getElementById('main').innerHTML = '';
    populateCards();
}

async function populateCards() {
    let cardData = await ((await fetch('http://localhost:3030/jsonstore/advanced/profiles')).json());

    let profiles = new DocumentFragment();

    // let profiles = document.getElementById('main');

    for (let id of Object.keys(cardData)) {
        let username = cardData[id].username;
        let email = cardData[id].email;
        let age = cardData[id].age;
        let card = getCard(username, email, age);
        card.querySelector('input').checked = true;
        profiles.appendChild(card);
    }
    document.getElementById('main').appendChild(profiles);

}

function getCard(username, email, age) {
    let div = document.createElement('div');
    div.classList.add('profile');
    div.innerHTML = `
            <img src="./iconProfile2.png" class="userIcon"/>
            <label>Lock</label>
            <input type="radio" name="${username}Locked" value="lock" checked>
            <label>Unlock</label>
            <input type="radio" name="${username}Locked" value="unlock"><br>
            <hr>
            <label>Username</label>
            <input type="text" name="user1Username" value="${username}" disabled readOnly/>
            <div class="user1HiddenFields">
                <hr>
                <label>Email:</label>
                <input type="email" name="user1Email" value="${email}" disabled readOnly/>
                <label>Age:</label>
                <input type="email" name="user1Age" value="${age}" disabled readOnly/>
            </div>
            <button>Show more</button>`

    div.querySelector('div').style.display = 'none';
    div.querySelector('button').addEventListener('click', onClick);
    return div;
}

function onClick(e) {
    let isLocked = e.target.parentElement.querySelector('input').checked;
    let div = e.target.parentElement.querySelector('div');
    let isHidden = div.style.display === 'none';

    if (!isLocked) {
        if (isHidden) {
            div.style.display = 'block';
            e.target.textContent = 'Hide it';
        } else {
            div.style.display = 'none';
            e.target.textContent = 'Show more';
        }
    }
}