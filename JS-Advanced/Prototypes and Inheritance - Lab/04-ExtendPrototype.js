function extendPrototype(classToExtend) {
    let proto = classToExtend.prototype;
    proto.species = 'Human';
    proto.toSpeciesString = function () {
        return `I am a ${this.species}. ${this.toString()}`;
    }
}