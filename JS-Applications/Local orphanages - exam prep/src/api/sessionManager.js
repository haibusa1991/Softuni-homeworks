export function getUserData() {
    let user = localStorage.getItem('user');
    if (user) {
        return JSON.parse(user);
    }
    return user;
}

export function setUserData(userData) {
    localStorage.setItem('user', JSON.stringify(userData));
}

export function clearUserData() {
    localStorage.removeItem('user');
}