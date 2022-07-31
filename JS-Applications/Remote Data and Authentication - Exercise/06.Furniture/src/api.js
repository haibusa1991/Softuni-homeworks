async function request(url, method = 'get', data = null) {
    try {
        let user = sessionStorage.user;
        let options = {method: method, headers: {}}

        if (user) {
            let userData = JSON.parse(user);
            options.headers['X-Authorization'] = userData.accessToken;
        }

        if (data) {
            options.body = JSON.stringify(data);
        }

        let serverRequest = fetch(url, options);
        let response = await serverRequest;

        if (response.status === 403) {
            sessionStorage.removeItem('user');
            throw new Error("invalid token");
        }

        if (!response.ok) {
            throw new Error("" + response.status);
        }

        if (response.status === 204) {
            return serverRequest;
        }

        return response.json();
    } catch (e) {
        throw new Error(e);
    }
}

function get(url) {
    return request(url);
}

function post(url, data) {
    return request(url, 'post', data);
}

function put(url, data) {
    return request(url, 'post', data);
}

function del(url) {
    return request(url, 'delete');
}

export function api() {
    return {get, post, put, del}
}