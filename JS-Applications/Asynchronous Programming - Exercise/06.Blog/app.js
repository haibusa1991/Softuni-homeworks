function attachEvents() {
    document.getElementById('btnLoadPosts').addEventListener('click', loadPostTitles);
}

attachEvents();

let posts;

async function loadPostTitles() {
    posts = await ((await fetch('http://localhost:3030/jsonstore/blog/posts')).json());

    let options = document.createDocumentFragment();

    // this doesn't work in judge for some reason

    // for (let postId of Object.keys(posts)) {
    //     let option = document.createElement('option');
    //     option.value = posts[postId].id;
    //     option.textContent = posts[postId].title;
    //     options.appendChild(option);
    //     console.log(option.outerHTML)
    // }

    for (let [id, postInfo] of Object.entries(posts)) {
        let option = document.createElement('option');
        option.value = id;
        option.textContent = postInfo.title;
        options.appendChild(option);
        console.log(option.outerHTML)
    }


    let postsDropdown = document.getElementById('posts');
    postsDropdown.innerHTML = '';
    postsDropdown.appendChild(options);
    document.getElementById('btnViewPost').addEventListener('click', viewPost);
}

function viewPost() {
    let postId = document.getElementById('posts').selectedOptions[0].value;

    loadPostContent(postId);
    loadPostComments(postId);

}

async function loadPostContent(postId) {
    let title = document.getElementById('post-title');
    let body = document.getElementById('post-body');


    title.textContent = posts[postId].title;
    body.textContent = posts[postId].body;
}

async function loadPostComments(postId) {
    let postComments = document.getElementById('post-comments');
    postComments.innerHTML = '';

    let response = await ((await fetch('http://localhost:3030/jsonstore/blog/comments')).json());

    let comments = [];

    for (let commentId of Object.keys(response)) {
        if (response[commentId].postId === postId) {
            comments.push(response[commentId]);
        }
    }

    let commentsFragment = document.createDocumentFragment();

    for (let comment of comments) {
        let li = document.createElement('li');
        li.id = comment.id;
        li.textContent = comment.text;
        commentsFragment.appendChild(li);
    }

    postComments.appendChild(commentsFragment);
}