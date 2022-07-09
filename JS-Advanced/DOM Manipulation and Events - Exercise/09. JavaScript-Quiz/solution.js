function solve() {

    let currentSection = 0;
    let sections = Array.from(document.querySelectorAll('#quizzie section'))

    Array.from(document.querySelectorAll('#quizzie'))
        .map(e => e.addEventListener('click', onClick));

    let answersKey = [2, 4, 2]
    let answers = []

    function onClick(event) {
        sections[currentSection].style.display = 'none';
        answers.push(getAnswer(event));
        currentSection++;

        if (currentSection >= sections.length) {
            let resultDiv = document.getElementById('results')
            resultDiv.style.display = 'block';

            let result = resultDiv.querySelector('h1');
            let correctAnswers = countCorrectAnswers();
            result.textContent = correctAnswers === answersKey.length ?
                'You are recognized as top JavaScript fan!' :
                `You have ${correctAnswers} right answers`;
            return;
        }
        sections[currentSection].style.display = 'block';
    }

    function countCorrectAnswers() {
        return answers.filter((e1, e2) => e1 === answersKey[e2]).length;
    }

    function getAnswer(event) {
        let currentElement = event.target;

        while (currentElement.nodeName !== 'LI') {
            currentElement = currentElement.parentElement;
        }

        return Number(currentElement.attributes['data-quizIndex'].value);
    }
}
