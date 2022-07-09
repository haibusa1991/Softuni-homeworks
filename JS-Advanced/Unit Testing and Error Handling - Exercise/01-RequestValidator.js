function validate(header) {

    if (!isValidMethod(header)) {
        throw Error('Invalid request header: Invalid Method')
    }

    if (!isValidUri(header)) {
        throw Error('Invalid request header: Invalid URI')
    }

    if (!isValidVersion(header)) {
        throw Error('Invalid request header: Invalid Version')
    }

    if (!isValidMessage(header)) {
        throw Error('Invalid request header: Invalid Message')
    }

    return header;

    function isValidMethod(header) {
        if (!header.hasOwnProperty('method')) {
            return false;
        }

        let validMethods = ['GET', 'POST', 'DELETE', 'CONNECT'];
        return validMethods.includes(header.method);
    }

    function isValidUri(header) {
        if (!header.hasOwnProperty('uri')) {
            return false;
        }

        let regex = new RegExp('[^a-zA-Z0-9\.\*]+', 'g')
        let matches = header.uri.matchAll(regex);

        if (Array.from(matches).length > 0) {
            return false;
        }

        if (header.uri.length === 0) {
            return false;
        }

        return true;
    }

    function isValidVersion(header) {
        if (!header.hasOwnProperty('version')) {
            return false;
        }

        let validVersions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];

        return validVersions.includes(header.version);
    }

    function isValidMessage(header) {
        if (!header.hasOwnProperty('message')) {
            return false;
        }

        let regex = new RegExp('[\<\>\\\\\&\'\"]+', 'g')
        let matches = header.message.matchAll(regex);

        if (Array.from(matches).length > 0) {
            return false;
        }

        return true;
    }

}

console.log(validate({
        method: 'GET',
        uri: '*',
        version: 'HTTP/1.1',
        message: '<script>alert("xss vulnerable")</script>'
    }
));