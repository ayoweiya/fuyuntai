function initPage() {
  var pageId = 'fuyuntai';

  // $(document).ready 的事情統一在此處理
  addPageViewAjax(pageId, fromPageId, channel);

  const btnGoLight = $(".btn-golight").position().top;
  const btnSlide = $(".btn-slide").position().top;
  const planPosition = $(".title-project").position().top;
  const titleRecPosition = $(".title-rec").position().top;

  function myFunction(x) {
    if (x.matches) {
      if ($(window).scrollTop() >= btnSlide) {
        $(".fixed-btn-golight").addClass("active");
      } else {
        $(".fixed-btn-golight").removeClass("active");
      }
    } else {
      if ($(window).scrollTop() >= btnGoLight) {
        $(".fixed-btn-golight").addClass("active");
      } else {
        $(".fixed-btn-golight").removeClass("active");
      }
    }
  }
  const mobileWidth = window.matchMedia("(max-width: 768px)")
  myFunction(mobileWidth);


  $(window).scroll(function () {
    myFunction(mobileWidth);

    // if ($(window).scrollTop() >= btnGoLight) {
    //   $(".fixed-btn-golight").addClass("active");
    // } else {
    //   $(".fixed-btn-golight").removeClass("active");
    // }

    if (
        $(window).scrollTop() >= planPosition &&
        $(window).scrollTop() <= titleRecPosition
    ) {
      $(".fixed-btn-golight").removeClass("active");
    }
  });

  $(".btn-golight").on("click", function () {
    addItemClickAjax(pageId, 'fuyuntailight', channel);

    $("html,body").animate(
        { scrollTop: $(".title-project").offset().top - 90 },
        200
    );
    $(".fixed-btn-golight").removeClass("active");
  });
  $(".fixed-btn-golight").on("click", function () {
    addItemClickAjax(pageId, 'fuyuntailight', channel);
    $("html,body").animate(
        { scrollTop: $(".title-project").offset().top - 90 },
        200
    );
  });

  $('#buyyear').on('click',()=>{
    addItemClickAjax(pageId, "buyyear", channel);
    /*popup.jsp裡的方法，用於顯示popup*/
    showPopup();
  });
  $('#fuyuntaiorder').on('click',()=>{
    addItemClickAjax(pageId, "fuyuntaiorder", channel);
    location.href=`${basePath}/orderList`;
  });
}
