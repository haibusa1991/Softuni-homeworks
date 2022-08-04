import * as api from '/src/api/api.js'

export async function getAllPosts() {
    let ideas = api.get('/data/posts?sortBy=_createdOn%20desc');

    try {
        return await ideas;
    } catch (e) {
        throw new Error(e);
    }
}

export async function getPostsByUserId(userId) {
    let ideas = api.get(`/data/posts?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);

    try {
        return await ideas;
    } catch (e) {
        throw new Error(e);
    }
}

export async function getPostDonationsById(postId) {
    let donationsCount = api.get(`/data/donations?where=postId%3D%22${postId}%22&distinct=_ownerId&count`);

    try {
        return await donationsCount;
    } catch (e) {
        throw new Error(e);
    }
}

export async function donateToPost(postId) {
    let donate = api.post('/data/donations', {postId});

    try {
        return await donate;
    } catch (e) {
        throw new Error(e);
    }
}

export async function getUserCanDonate(postId, userId) {
    let canDonate = api.get(`/data/donations?where=postId%3D%22${postId}%22%20and%20_ownerId%3D%22${userId}%22&count`);

    try {
        return (await canDonate) === 0;
    } catch (e) {
        throw new Error(e);
    }
}

export async function createPost(postData) {
    let post = api.post('/data/posts', postData);

    try {
        return await post;
    } catch (e) {
        throw new Error(e);
    }
}

export async function getPostDetails(id) {
    let post = api.get('/data/posts/' + id);

    try {
        return await post;
    } catch (e) {
        throw new Error(e);
    }
}

export async function editPost(postId, postData) {
    let post = api.put('/data/posts/' + postId, postData);

    try {
        return await post;
    } catch (e) {
        throw new Error(e);
    }
}

export async function deletePost(postId) {
    let post = api.del('/data/posts/' + postId);

    try {
        return await post;
    } catch (e) {
        throw new Error(e);
    }
}
