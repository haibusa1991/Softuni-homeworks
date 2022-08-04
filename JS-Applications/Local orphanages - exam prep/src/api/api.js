import * as sessionManager from '/src/api/sessionManager.js';

const host = ' http://localhost:3030';

async function request(url, method = 'get', postData = null) {
    try {
        let options = {method: method, headers: {}, postData};

        let user = sessionManager.getUserData();

        if (user) {
            options.headers['X-Authorization'] = user.accessToken;
        }

        if (postData) {
            options.body = JSON.stringify(postData);
        }

        let response = await fetch(host + url, options);

        if(!response.ok){
            let r = await response.json();
            throw new Error(r.message);
        }

        if (response.status === 204) {
            return response;
        }
        return response.json();

    } catch (e) {
        throw e;
    }
}

export function get(url) {
    return request(url);
}

export function post(url, postData) {
    return request(url, 'post', postData);
}

export function put(url, postData) {
    return request(url, 'put', postData);
}

export function del(url) {
    return request(url, 'delete');
}