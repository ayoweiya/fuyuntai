const btnGoLight = $(".btn-golight").offset().top;
const planPosition = $(".title-project").position().top;
const titleRecPosition = $(".title-rec").position().top;

$(window).scroll(function () {
  if ($(window).scrollTop() >= btnGoLight) {
    $(".fixed-btn-golight").addClass("active");
  } else {
    $(".fixed-btn-golight").removeClass("active");
  }

  if (
    $(window).scrollTop() >= planPosition &&
    $(window).scrollTop() <= titleRecPosition
  ) {
    $(".fixed-btn-golight").removeClass("active");
  }
});

$(".btn-golight").on("click", function () {
  $("html,body").animate(
    { scrollTop: $(".title-project").offset().top - 90 },
    200
  );
  $(".fixed-btn-golight").removeClass("active");
});
$(".fixed-btn-golight").on("click", function () {
  $("html,body").animate(
    { scrollTop: $(".title-project").offset().top - 90 },
    200
  );
});
