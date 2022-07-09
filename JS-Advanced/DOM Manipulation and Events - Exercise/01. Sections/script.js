function create(words) {
    for (let word of words) {
        let div = document.createElement('div')
        div.addEventListener('click', onClick);
        let p = document.createElement('p');
        p.textContent = word;
        p.style.display = 'none';
        div.appendChild(p);
        document.getElementById('content').appendChild(div);
    }

    function onClick(event) {
        event.target.children[0].style.display = '';
    }

}