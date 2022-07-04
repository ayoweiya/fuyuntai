<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="basePath" scope="page" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" type="image/png" href="${basePath}/resources/img/logo.png"/>
    <title>付款失敗!</title>

    <link href="${basePath}/resources/css/cssreset-min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/common.css" rel="stylesheet">
    <link href="${basePath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/swiper.min.css" rel="stylesheet">

    <%-- header and footer--%>
    <link href="${basePath}/resources/css/header.css" rel="stylesheet">
    <link href="${basePath}/resources/css/footer.css" rel="stylesheet">
    <link href="${basePath}/resources/css/main.css" rel="stylesheet">
    <link href="${basePath}/resources/css/normalize.css" rel="stylesheet">
    <link rel="stylesheet" href="${basePath}/resources/js/aos-master/dist/aos.css"/>

    <style>
        body {
            background-color: #FFF6E7;
        }

        .wrap-content {
            height: 100vh;
        }

        .container-fluid {
            flex: 1;
            background-color: #E0E0E0;
        }

        .btn {
            border: none;
            color: white;
            background-color: #ccaf0a;
        }
    </style>
</head>
<body>
<div class="wrap-content d-flex flex-column">

    <%-- header and footer --%>
    <%-- header --%>
    <jsp:include page="/WEB-INF/views/Common/header.jsp" flush="true"/>

    <div class="container-fluid text-center py-5 h-100">
        <h2>付款失敗</h2>
        <p class="mb-5">本次交易失敗不扣款，若有任何問題請洽開運算算客服，謝謝！</p>
        <a href="index.html" class="btn btn-lg btn-dark goIndex">回首頁</a>
    </div>

    <%-- header and footer --%>
    <!-- footer -->
    <jsp:include page="/WEB-INF/views/Common/footer.jsp" flush="true"/>

</div>
<script src="${basePath}/resources/js/jquery-3.4.1.min.js"></script>
<script src="${basePath}/resources/js/Common/header.js"></script>

<%--header and footer--%>
<script src="${basePath}/resources/js/Common/header.js"></script>
<script src="${basePath}/resources/js/Common/footer.js"></script>
<script src="${basePath}/resources/js/aos-master/dist/aos.js"></script>

<script type="text/javascript">

    var pageId = 'fuyuntai_fail';
    var fromPageId = '${fromPageId}'.replace(/,/g, '').replace(/%20/g, '');

    function initPage() {
        // $(document).ready 的事情統一在此處理
        addPageViewAjax(pageId, fromPageId);

        $('.goIndex').click(function () {
            btnId = 'fuyuntai_btn_backHome';
            addItemClickAjax(pageId, btnId);
        });
    }
</script>
<jsp:include page="/WEB-INF/views/Common/common.jsp" flush="true"/>
</body>
</html>