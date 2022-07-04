<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" scope="page" value="${pageContext.request.contextPath}"/>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-151818705-6"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-151818705-6');
</script>

<script>
	let basePath = '${basePath}';

	// if (window.location.protocol == "http:") {
	// 	window.location.href = "https://" + location.hostname
	// 	+ location.pathname + location.search + location.hash;
	// }
	
	$(function initCommon() {
		initPage();
	});
	
	function addPageView(pageId, fromPageId) {
		$.post("${pageContext.request.contextPath}/report/pageView", {
			"fromPageId" : fromPageId,
			"pageId" : pageId
		}, "json");
	}

    function addPageViewAjax(pageId, fromPageId, channel) {
        $.ajax({
            type : 'POST',
            traditional : true,
            async: false,
            url : '${pageContext.request.contextPath}/report/pageView',
            data : {
                '${_csrf.parameterName}' : '${_csrf.token}',
                "fromPageId" : fromPageId,
                "pageId" : pageId,
                "channel": channel
            },
            dataType : 'json',
            success : function(json) {}
        });
    }

    function addItemClick(pageId, itemId) {
		$.post("${pageContext.request.contextPath}/report/itemClick", {
			"pageId" : pageId,
			"itemId" : itemId
		}, "json");
	}
    
    function addItemClickAjax(pageId, itemId, channel) {
        $.ajax({
            type : 'POST',
            traditional : true,
            async: false,
            url : '${pageContext.request.contextPath}/report/itemClick',
            data : {
                '${_csrf.parameterName}' : '${_csrf.token}',
                "pageId" : pageId,
                "itemId" : itemId,
                "channel": channel
            },
            dataType : 'json',
            success : function(json) {}
        });
    }
	
	function addParamToHref() {
		$("a").each(function() {
			var href = $(this).attr("href");
			if (href != undefined) {
				if ((href != "" && href != "#") && href.substring(0,1) != '#') {
					if ($(this).attr("href").indexOf("?") !== -1) {
						$(this).attr("href", href + "&pageId=" + pageId + "&actPageId=" + actPageId);
					} else {
						$(this).attr("href", href + "?pageId=" + pageId + "&actPageId=" + actPageId);
					}
				}
			}
		});
	}
</script>