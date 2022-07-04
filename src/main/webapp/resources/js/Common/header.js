(function () {
  // 初始值變數
  let windowWidth = $(window).width();
  const phoneMode = windowWidth <= 768;
  let windowHeight = $(window).height() - (phoneMode ? 300 : 500);
  let originLogoWidth = windowWidth * (phoneMode ? 0.9 : 0.6);
  let originTranslateY = phoneMode ? 80 : 60;
  let finalLogoWidth = phoneMode ? 100 : 160;
  let logoTop, percent, translateY, logoWidth, logoOpacity;

  const bannerVideo = document.getElementById("bannerVideo");
  let documentHeightWithPhone = phoneMode ? 80 : 60;
  if ($(document).scrollTop() >= windowHeight) {
    $("h1.logo figure").css({
      transform: `translate3d(0px,0px,0px)`,
      width: `100px`,
      opacity: 1,
    });
  }

  // 選單
  $(".menu").click(function () {
    if ($(this).is(".active:not(.back)")) {
      $(this).addClass("back");
      closeHeaderMenu();
    } else if ($(this).is(".back")) {
      $("body").addClass("noScroll");
      $(this).removeClass("back");
      openHeaderMenu();
    } else {
      $("body").addClass("noScroll");
      $(this).addClass("active");
      openHeaderMenu();
    }
  });
  $(".menu-list").click(function () {
    $(".menu").addClass("back");
    closeHeaderMenu();
  });

  function closeHeaderMenu() {
    $(".wrap-menu-list").removeClass("active");
    $(".wrap-header").removeClass("active");
    $("body").removeClass("noScroll");

    $(".wrap-eventAd").css({
      zIndex: "99"
    });
    $("h1.logo figure").css({
      transform: `translate3d(0px,0px,0px)`,
      width: `100px`,
      opacity: 1,
    });
    safariHacks();
  }

  function openHeaderMenu() {
    $(".wrap-menu-list").addClass("active");
    $(".wrap-header").addClass("active");
    $(".wrap-eventAd").css({
      zIndex: "98"
    });
    $("h1.logo figure").css({
      transform: `translate3d(0px,0px,0px)`,
      width: `100px`,
      opacity: 1,
    });
    safariHacks();
  }

  function safariHacks() {
    let windowsVH = window.innerHeight * 0.01;
    document
      .querySelector(".wrap-menu-list.active")
      .style.setProperty("--vh", windowsVH + "px");
    window.addEventListener("resize", function () {
      document
        .querySelector(".wrap-menu-list.active")
        .style.setProperty("--vh", windowsVH + "px");
    });
  }
})();