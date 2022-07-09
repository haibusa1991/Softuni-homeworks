function solve() {
    document.querySelector('#add').addEventListener('click', addTask);
    let sections = document.querySelectorAll('section');

    function addTask(e) {
        e.preventDefault();
        let fields = [
            document.getElementById('task').value,
            document.getElementById('description').value,
            document.getElementById('date').value
        ]

        if (fields.find(e => e.length === 0) !== undefined) return;

        createTask(fields);
    }

    function createTask(fieldValues) {
        let article = document.createElement('article');
        article.appendChild(createElementAndSetTextContent('h3', fieldValues[0]));
        article.appendChild(createElementAndSetTextContent('p', `Description: ${fieldValues[1]}`));
        article.appendChild(createElementAndSetTextContent('p', `Due Date: ${fieldValues[2]}`));

        let div = document.createElement('div');
        div.classList.add('flex');

        let startBtn = createElementAndSetTextContent('button', 'Start');
        startBtn.classList.add('green');
        startBtn.addEventListener('click', onStart)
        div.appendChild(startBtn);

        let deleteBtn = createElementAndSetTextContent('button', 'Delete');
        deleteBtn.classList.add('red');
        deleteBtn.addEventListener('click', onDelete)
        div.appendChild(deleteBtn);

        let finishBtn = createElementAndSetTextContent('button', 'Finish');
        finishBtn.addEventListener('click', onFinish)
        finishBtn.classList.add('orange');

        article.appendChild(div);

        sections[1].querySelectorAll('div')[1].appendChild(article);

        function createElementAndSetTextContent(element, content) {
            let e = document.createElement(`${element}`);
            e.textContent = content;
            return e;
        }

        function onStart() {
            startBtn.remove();
            div.appendChild(finishBtn);
            sections[2].querySelectorAll('div')[1].appendChild(article);
        }

        function onDelete() {
            article.remove();
        }

        function onFinish() {
            sections[3].querySelectorAll('div')[1].appendChild(article);
            div.remove();
        }
    }
}