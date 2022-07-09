function attachGradientEvents() {
    let gradientBox = document.getElementById('gradient');
    gradientBox.addEventListener('mousemove', gradient);
    gradientBox.addEventListener('mouseout', hidePercentage);

    function gradient(event) {
        let width = event.target.clientWidth
        let offset = event.offsetX;

        let percentage = Math.floor(offset / width * 100) + '%';

        document.getElementById('result').textContent = percentage;
    }

    function hidePercentage(){
        document.getElementById('result').textContent = '';
    }
}