import * as api from '/src/api/api.js'

export async function getAllOffers() {
    let offers = api.get('/data/offers?sortBy=_createdOn%20desc');

    try {
        return await offers;
    } catch (e) {
        throw new Error(e);
    }
}

export async function getOfferDetails(id) {
    let offer = api.get('/data/offers/' + id);

    try {
        return await offer;
    } catch (e) {
        throw new Error(e);
    }
}

export async function editOffer(offerId, offerData) {
    let offer = api.put('/data/offers/' + offerId, offerData);

    try {
        return await offer;
    } catch (e) {
        throw new Error(e);
    }
}

export async function deleteOffer(offerId) {
    let offer = api.del('/data/offers/' + offerId);

    try {
        return await offer;
    } catch (e) {
        throw new Error(e);
    }
}

export async function createOffer(offerData) {
    let post = api.post('/data/offers', offerData);

    try {
        return await post;
    } catch (e) {
        throw new Error(e);
    }
}

export async function getOfferApplicationsById(offerId) {
    let applicationsCount = api.get(`/data/applications?where=offerId%3D%22${offerId}%22&distinct=_ownerId&count`);

    try {
        return await applicationsCount;
    } catch (e) {
        throw new Error(e);
    }
}

export async function getUserCanApply(offerId, userId) {
    let canApply = api.get(`/data/applications?where=offerId%3D%22${offerId}%22%20and%20_ownerId%3D%22${userId}%22&count`);

    try {
        return (await canApply) === 0;
    } catch (e) {
        throw new Error(e);
    }
}

export async function applyForOffer(offerId) {
    let apply = api.post('/data/applications', {offerId});

    try {
        return await apply;
    } catch (e) {
        throw new Error(e);
    }
}
