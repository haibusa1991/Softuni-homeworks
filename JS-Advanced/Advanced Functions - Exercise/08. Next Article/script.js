function getArticleGenerator(articles) {

    function update() {
        if (articles.length === 0) {
            return;
        }

        let paragraph = document.createElement('article');
        paragraph.textContent = articles.shift();
        document.querySelector('#content').appendChild(paragraph);
    }

    return update;
}
