function initPage() {
	var pageId = 'fuyuntailove';
	
	// $(document).ready 的事情統一在此處理
    addPageViewAjax(pageId, fromPageId,channel);
	
    const btnGoLight = $(".btn-golight").offset().top;
    const planPosition = $(".title-project").position().top;
    const section6Position = $(".wrap-section6").position().top;

    $(window).scroll(function () {
    	
      if ($(window).scrollTop() >= btnGoLight) {
        $(".fixed-btn-golight").addClass("active");
      } else {
        $(".fixed-btn-golight").removeClass("active");
      }

      if (
        $(window).scrollTop() >= planPosition - 100 &&
        $(window).scrollTop() <= section6Position - 100
      ) {
        $(".fixed-btn-golight").removeClass("active");
      }
    });

    $(".btn-golight").on("click", function () {
    	addItemClickAjax(pageId, 'fuyuntailight', channel);
    	
      $("html,body").animate(
        { scrollTop: $(".title-project").offset().top -100 },
        200
      );
      $(".fixed-btn-golight").removeClass("active");
    });
    $(".fixed-btn-golight").on("click", function () {
    	addItemClickAjax(pageId, 'fuyuntailight', channel);
      $("html,body").animate(
        { scrollTop: $(".title-project").offset().top - 100 },
        200
      );
    });
    
    $('#buysix').on('click',()=>{
    	addItemClickAjax(pageId, "buysix", channel);
    	/*popup.jsp裡的方法，用於顯示popup*/
    	showPopup();
    });
    $('#buythree').on('click',()=>{
    	addItemClickAjax(pageId, "buythree", channel);
    	/*popup.jsp裡的方法，用於顯示popup*/
    	showPopup();
    });
    $('#fuyuntailoveorder').on('click',()=>{
    	addItemClickAjax(pageId, "fuyuntailoveorder", channel);
    	location.href=`${basePath}/orderList`;
    });
}

