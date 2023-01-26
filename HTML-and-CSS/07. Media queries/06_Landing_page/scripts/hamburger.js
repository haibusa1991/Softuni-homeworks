window.onload = attachListeners;

function attachListeners() {
    document.getElementById('hamburger-menu').addEventListener("click", onMenuClick);
    document.querySelectorAll('#hamburger-menu-contents .nav-link').forEach(e=>e.addEventListener("click",onMenuClick));
    document.getElementById('hamburger-menu-overlay').addEventListener("click", onMenuClick);

}

function onMenuClick() {
    document.getElementById('hamburger-menu-contents').classList.toggle('active-menu');
    document.getElementById('hamburger-menu-overlay').classList.toggle('hamburger-menu-overlay-visible');
    document.querySelector('body').classList.toggle('overflow-active');
}
