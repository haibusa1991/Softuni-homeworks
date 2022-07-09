function notify(message) {
    let notificationDiv = document.querySelector('#notification');
    notificationDiv.textContent = message;
    notificationDiv.style.display = 'block';

    notificationDiv.addEventListener('click',onClick);

    function onClick(e){
        e.target.style.display = 'none';
    }
}