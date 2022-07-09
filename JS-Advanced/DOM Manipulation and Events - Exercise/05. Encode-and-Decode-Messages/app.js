function encodeAndDecodeMessages() {
    let buttons = Array.from(document.querySelectorAll('button'));

    buttons[0].addEventListener('click', onEncode)
    buttons[1].addEventListener('click', onDecode)

    let textBoxes = Array.from(document.querySelectorAll('textarea'));

    let textBoxOutput = textBoxes[1];

    function onEncode(event) {
        let text = event.target.parentElement.querySelector('textarea').value;

        textBoxes[0].value = '';
        textBoxOutput.value = processText(text);

    }

    function onDecode(event) {
        let text = event.target.parentElement.querySelector('textarea').value;
        textBoxOutput.value = processText(text,false);
    }

    function processText(text, shouldEncode = true) {
        let offset = 1;

        if (!shouldEncode) {
            offset = -1;
        }

        let output = [];
        for (let i = 0; i < text.length; i++) {
            output.push(String.fromCharCode(text.charCodeAt(i) + offset));
        }

        return output.join('');
    }
}