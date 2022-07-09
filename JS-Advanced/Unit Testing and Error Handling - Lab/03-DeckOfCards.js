function cards(cards) {
    let faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
    let suits = {
        S: '\u2660',
        H: '\u2665',
        D: '\u2666',
        C: '\u2663'
    }

    let validCards = [];
    for (let card of cards) {
        let face = card.slice(0, -1);
        let suit = card.slice(-1);

        if(!faces.includes(face) || suits[suit]===undefined){
            console.log(`Invalid card: ${face}${suit}`);
            return;
        }

        validCards.push({
                face,
                suit: suits[suit],

                toString() {
                    return this.face + this.suit;
                }
            })
    }

    console.log(validCards.join(' '))
}

cards(['5S', '3D', 'QD', '1C'])
cards(['AS', '10D', 'KH', 'ZS'])