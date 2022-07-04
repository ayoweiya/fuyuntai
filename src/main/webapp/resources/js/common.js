$(function() {
    var swiper = new Swiper('.swiper-container', {
        loop: true,
        speed: 400,
        autoplay : 5000,
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
    });
    
    var swiper2 = new Swiper('.swiper-container2', {
        slidesPerView: 3,
        spaceBetween: 10,
        loop: true,
        speed: 400,
        autoplay : 5000,
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
    });
    
    $('.goIndex').on('click', function() {
    	itemId = 'luckycc_logo';
		addItemClickAjax(pageId, itemId);
        location.href="/home/index.html"
    });
    
    $('.goLogin').on('click', function() {
//    	itemId = 'luckycc_login';
    	itemId = 'luckycc_member';
		addItemClickAjax(pageId, itemId);
//        location.href="/home/ssoLogin.html"
    	location.href="/home/member/member.html"
    });
    
    $('.goLoginOut').on('click', function() {
    	itemId = 'luckycc_logout';
		addItemClickAjax(pageId, itemId);
        location.href="/home/logout.html"
    });
    
    $('.goRecordSheet').on('click', function() {
    	itemId = 'luckycc_tohs';
		addItemClickAjax(pageId, itemId);
        location.href="/home/member/recordsheet.html"
    });
    
    $('.goCcIndex').on('click', function() {
    	itemId = 'luckycc_index';
		addItemClickAjax(pageId, itemId);
        location.href="/home/index.html"
    });

    $('.goServIntro').on('click', function() {
    	itemId = 'luckycc_service';
		addItemClickAjax(pageId, itemId);
    	location.href="/home/serviceIntro.html";
    });

    $('.goFb').on('click', function() {
    	itemId = 'luckycc_gofb';
		addItemClickAjax(pageId, itemId);
        location.href="https://www.facebook.com/luckycc2020";
    });

    $('.goLine').on('click', function() {
    	itemId = 'luckycc_goline';
		addItemClickAjax(pageId, itemId);
        location.href="https://line.me/R/ti/p/%40luckycc";
    });

    $('.goMail').on('click', function() {
    	itemId = 'luckycc_gomail';
		addItemClickAjax(pageId, itemId);
        location.href="mailto:opftservice@gmail.com"
    });
    
    $('.goCoyright').on('click', function() {
        location.href="index.html"
    });
});