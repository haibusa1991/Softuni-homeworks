import * as api from '/src/api/api.js'

export async function getIdeas() {
    let ideas = api.get('/data/ideas?select=_id%2Ctitle%2Cimg&sortBy=_createdOn%20desc');

    try {
        return await ideas;
    } catch (e) {
        throw new Error(e);
    }
}

export async function sendIdea(ideaData) {
    let post = api.post('/data/ideas', ideaData);

    try {
        return await post;
    } catch (e) {
        throw new Error(e);
    }
}

export async function getIdeaDetails(id) {
    let idea = api.get('/data/ideas/' + id);

    try {
        return await idea;
    } catch (e) {
        throw new Error(e);
    }
}

export async function deleteIdea(id){
    try {
        return await api.del('/data/ideas/' + id);
    } catch (e) {
        throw new Error(e);
    }
}