console.clear();
const navSlide = () => {
    const burger = document.querySelector('.burger');
    const nav = document.querySelector('.nav-liens');
    const navLiens = document.querySelectorAll('.nav-liens li');
    //Toggle nav 
    burger.addEventListener('click', () => {
        nav.classList.toggle('nav-active');
    // 
    //Animate links
    navLiens.forEach((link, index) => {
       
        link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7 + 1}s`;
        console.log(index / 5);
    });
        //burger animation

        burger.classList.toggle('toggle');
        
    });



}

navSlide();

