function loadCommits() {
    // Try it with Fetch API
    let username = document.getElementById('username').value;
    let repoName = document.getElementById('repo').value;


    fetch(`https://api.github.com/repos/${username}/${repoName}/commits`)
        .then(response => onHeaderResolve(response));
}

function onHeaderResolve(response) {
    if (!response.ok) {
        onError(response.status)
        return;
    }
    response.json().then(e => onSuccess(e));
}


function onSuccess(commits) {
    let list = document.getElementById('commits');

    for (let commit of commits) {
        let author = commit.commit.author.name;
        let message = commit.commit.message;

        let li = document.createElement('li');
        li.innerHTML = `
        ${author}: ${message}`
        list.appendChild(li);
    }
}

function onError(error) {
    let list = document.getElementById('commits');
    let li = document.createElement('li');
    li.innerHTML = `
        Error: ${error} (Not Found)`
    list.appendChild(li);
}
