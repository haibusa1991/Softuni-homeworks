function loadRepos() {
    let url = "https://api.github.com/users/testnakov/repos";
    let request = new XMLHttpRequest();
    let div = document.getElementById('res');
    request.addEventListener('readystatechange', populateDiv);
    request.open('GET', url);
    request.send();
    div.textContent = 'Loading GitHub...'


    function populateDiv(e) {
        if (request.readyState === 4 && request.status === 200) {
            div.textContent = request.responseText;
        }
    }
}