const template = {
    extensionMethod: function () {
    },
    extensionProperty: 'someString'
}

function extensibleObject() {
    let obj = {};

    function extend(template) {
        let keys = Object.keys(template)
        for (let key of keys) {
            if (typeof template[key] === 'function') {
                obj.__proto__[key] = template[key];
            } else {
                obj[key] = template[key];
            }
        }

    }

    obj.extend = extend;
    return obj;
}

let o = extensibleObject();
o.extend(template)