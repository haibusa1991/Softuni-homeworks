function loadRepos() {
    let username = document.getElementById('username').value;
    let request = new XMLHttpRequest();
    request.addEventListener('readystatechange', onFetch);
    request.open('get', `https://api.github.com/users/${username}/repos`);
    // request.setRequestHeader('Authorization','token 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') //added because reached limit for requests per day
    request.send();

    function onFetch() {
        let ul = document.getElementById('repos');
        ul.innerHTML = '';

        if (request.status === 200 && request.readyState === 4) {
            let ul = document.getElementById('repos');
            let result = JSON.parse(request.responseText);
            for (let repo of result) {
                ul.appendChild(getListItem(repo));
            }
            return;
        }

        if (request.readyState === 4) {
            ul.innerHTML = `
            <li><p>Error occurred while looking for user \"${username}"\. Check name and try again!</p></li>`
        }

    }

    function getListItem(jsonObject) {
        let name = jsonObject.full_name;
        let anchor = jsonObject.html_url;

        let li = document.createElement('li');
        let a = document.createElement('a');
        a.href = anchor;
        a.textContent = name;
        a.target = '_blank';
        li.appendChild(a);
        return li;
    }
}