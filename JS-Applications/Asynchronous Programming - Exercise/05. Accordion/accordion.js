async function loadCards() {
    let data = await ((await fetch('http://localhost:3030/jsonstore/advanced/articles/list')).json());

    let cards = document.createDocumentFragment();

    for (let cardData of data) {
        cards.appendChild(generateCard(cardData))
    }

    document.getElementById('main').appendChild(cards);

}

function generateCard(cardData) {
    let title = cardData.title;
    let id = cardData._id;

    let div = document.createElement('div');
    div.classList.add('accordion');
    div.innerHTML = `            
            <div class="head">
                <span>${title}</span>
                <button class="button" id="${id}">More</button>
            </div>`

    div.addEventListener('click', toggleCardDetails)
    return div;
}

async function toggleCardDetails(e) {
    if(e.target.tagName!=='BUTTON'){
        console.log(e.target.tagName)
        return;
    }

    let id = e.target.id;
    let card = e.target.parentElement.parentElement;
    let button = card.querySelector('button');

    let divs = Array.from(card.querySelectorAll('div'));
    if (divs.length === 2) {
        divs[1].remove();
        button.textContent = 'More';
        return;
    }

    let details = await ((await fetch(`http://localhost:3030/jsonstore/advanced/articles/details/${id}`)).json());

    let div = document.createElement('div');
    div.classList.add('extra');
    div.innerHTML = `<p>${details.content}</p>`

    card.appendChild(div);
    div.style.display = 'block'
    button.textContent = 'Less';
}

loadCards();