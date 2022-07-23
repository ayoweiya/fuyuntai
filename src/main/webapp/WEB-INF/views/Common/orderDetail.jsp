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
    <title>訂單詳細</title>

    <link href="${basePath}/resources/css/cssreset-min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/common.css" rel="stylesheet">
    <link href="${basePath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/font-awesome.min.css" rel="stylesheet">
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

        .order-box {
            margin-top: 5%;
        }

        .modal-center {
            user-select: none;
            text-align: center;
        }

        .modal-center:before {
            content: "";
            display: inline-block;
            width: 0;
            height: 100%;
            vertical-align: middle;
            pointer-events: none;
        }

        .modal-center > * {
            display: inline-block;
            vertical-align: middle;
            user-select: auto;
        }

        .modal-center > * {
            text-align: left;
            width: 100%;
        }

        .modal-popup {
            position: relative;
            width: 330px;
        }

        .modal-popup .modal-close {
            position: absolute;
            bottom: 100%;
            right: 0;
        }

        .modal-popup .modal-content {
            border-radius: 20px;
            box-shadow: none;
        }

        .modal-popup .modal-body {
            font-size: 19px;
            padding: 25px;
        }

        .modal-popup .modal-footer {
            text-align: center;
        }

        .modal-popup .modal-footer .btn {
            line-height: 2;
            padding-left: 35px;
            padding-right: 35px;
        }

        .modal-popup .modal-footer .btn + .btn {
            margin-left: 15px;
        }

        @media screen and (max-width: 350px) {
            .modal-popup {
                width: 85vw;
            }

            .modal-popup .modal-body {
                font-size: 10vw;
            }
        }
    </style>
</head>
<body>
<div class="wrap-content">

    <%-- header and footer --%>
    <%-- header --%>
    <jsp:include page="/WEB-INF/views/Common/header.jsp" flush="true"/>

    <div class="container-fluid py-3" style="background-color: #E0E0E0;">
        <h5 class="text-center mb-2">訂單資訊</h5>
        <c:choose>
            <c:when test="${not empty orderList && empty LuckyProductVO_List}">
                <c:forEach var="orderVO" items="${orderList}">
                    <div class="order-box bg-white rounded px-md-5 px-1 py-3">
                        <p>訂單編號:${orderVO.fateOrder}</p>
                        <table class="table table-bordered text-center">
                            <thead class="thead-light">
                            <tr>
                                <th>日期</th>
                                <th>產品</th>
                                <th>祈福資料</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="px-1">${orderVO.buyTime}</td>
                                <td class="px-1">${orderVO.lampType}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${orderVO.hasLampInfo==1}">
                                            <a href="paySuccessAndInfo.html?fateOrder=${orderVO.fateOrder}"
                                               class="btn btn-sm btn-outline-secondary">祈福內容</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="paySuccessAndInfo.html?fateOrder=${orderVO.fateOrder}"
                                               class="btn btn-sm btn-warning">立即填寫</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <div id="plan-detail">
                            <a class="btn btn-sm text-dark" data-toggle="collapse"
                               href="#plan-detail-info${orderVO.idx}">
                                <h5>訂單明細<span id="detail-toggle">▼</span></h5>
                            </a>
                            <div class="collapse pt-3" id="plan-detail-info${orderVO.idx}">
                                <!-- 	                        <div class="d-flex justify-content-between align-items-center mb-3"> -->
                                <!-- 	                            <p class="mb-0">開運算算獨家贈品-開運祈福卡</p> -->
                                <!-- 	                            <button class="btn btn-outline-secondary">檢視</button> -->
                                <!-- 	                        </div> -->
                                <div class="d-flex justify-content-between align-items-end mb-3">
                                    <p class="mb-0">您的祈福相片:</p>
                                    <button class="btn btn-outline-secondary checkPic" lampType='${orderVO.lampType}'
                                            order='${orderVO.fateOrder}'>檢視
                                    </button>
                                </div>
                                <c:if test="${orderVO.isVotive==1}">
                                    <div class="d-flex justify-content-between align-items-end mb-3">
                                        <p class="mb-0">您的還願相片:</p>
                                        <button class="btn btn-outline-secondary checkPic" lampType='votive'
                                                order='${orderVO.fateOrder}'>檢視
                                        </button>
                                    </div>
                                </c:if>

                                <div class="notice mt-5">
                                    <h5>貼心提醒</h5>
                                    <p>a) 在您送出祈福資料後，會於<span class="text-danger">【隔週】</span>進行點燈祈福。
                                    </p>
                                    <p>b) 祈福完畢後，將於<span class="text-danger">10個工作天</span>內將祈福點燈的資料照上傳至您在開運算算的訂單頁中。
                                    </p>
                                    <p>c) 開運贈品會於送出祈福資料後<span class="text-danger">【次月】</span>寄送到您填寫的現居地址。
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <%-- 有開運商品 --%>
            <c:when test="${not empty orderList && not empty LuckyProductVO_List}">
                <c:forEach var="orderVO" items="${orderList}">
                    <div class="order-box bg-white rounded px-md-5 px-1 py-3">
                        <p>訂單編號:${orderVO.fateOrder}</p>
                        <table class="table table-bordered text-center">
                            <thead class="thead-light">
                            <tr>
                                <th>日期</th>
                                <th>產品</th>
                                <th>祈福資料</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td class="px-1">${orderVO.buyTime}</td>
                                <td class="px-1">${orderVO.lampType}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${orderVO.hasLampInfo==1}">
                                            <a href="paySuccessAndInfo.html?fateOrder=${orderVO.fateOrder}"
                                               class="btn btn-sm btn-outline-secondary">祈福內容</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="paySuccessAndInfo.html?fateOrder=${orderVO.fateOrder}"
                                               class="btn btn-sm btn-warning">立即填寫</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <h5 class="mb-1">還願方案:</h5>
                        <c:choose>
                            <c:when test="${orderVO.isVotive==1}">
                                <div class="payed-plan border-bottom border-secondary">
                                    <p class="ml-3">${orderVO.votiveTimes} 還願,${orderVO.votiveType}</p>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="plan-choose d-flex justify-content-between border-bottom border-secondary">
                                    <ul>
                                        <li><input type="radio" name="plan" class="mr-2 plan-option" value="threeMonth">供象—三個月
                                        </li>
                                        <li><input type="radio" name="plan" class="mr-2 plan-option" value="halfYear">供象—六個月
                                        </li>
                                        <li><input type="radio" name="plan" class="mr-2 plan-option" value="oneYear">供象—十二個月
                                        </li>
                                    </ul>
                                    <div class="text-right">
                                        <p class="text-danger">NT$ <span class="plan-price">請選擇方案</span></p>
                                        <div class="btn btn-outline-secondary goVotive"
                                             fateOrder="${orderVO.fateOrder}">確定送出
                                        </div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                        <div id="plan-detail">
                            <a class="btn btn-sm text-dark" data-toggle="collapse"
                               href="#plan-detail-info${orderVO.idx}">
                                <h5>訂單明細<span id="detail-toggle">▼</span></h5>
                            </a>
                            <div class="collapse pt-3" id="plan-detail-info${orderVO.idx}">
                                <!-- 	                        <div class="d-flex justify-content-between align-items-center mb-3"> -->
                                <!-- 	                            <p class="mb-0">開運算算獨家贈品-開運祈福卡</p> -->
                                <!-- 	                            <button class="btn btn-outline-secondary">檢視</button> -->
                                <!-- 	                        </div> -->
                                <div class="d-flex justify-content-between align-items-end mb-3">
                                    <p class="mb-0">您的祈福相片:</p>
                                    <button class="btn btn-outline-secondary checkPic" lampType='${orderVO.lampType}'
                                            order='${orderVO.fateOrder}'>檢視
                                    </button>
                                </div>
                                <c:if test="${orderVO.isVotive==1}">
                                    <div class="d-flex justify-content-between align-items-end mb-3">
                                        <p class="mb-0">您的還願相片:</p>
                                        <button class="btn btn-outline-secondary checkPic" lampType='votive'
                                                order='${orderVO.fateOrder}'>檢視
                                        </button>
                                    </div>
                                </c:if>

                                <div class="px-3 mb-3">
                                    <p>貼心提醒</p>
                                    <small>1. 若您在<span class="text-danger">【當月】</span>送出祈福資料，則會於<span
                                            class="text-danger">【次月20日】</span>由無上元老師祈福，例如您在8/15送出祈福資料，則會於9/20由無上元老師祈福。</small><br>
                                    <small>2. 祈福完畢後，將於<span
                                            class="text-danger">10個工作天</span>內將祈福點燈的資料照上傳至您在開運算算的訂單頁中。</small><br>
                                </div>

                            </div>
                        </div>
                    </div>
                </c:forEach>

                <%-- 開運商品 --%>
                <c:forEach var="LuckyProductVO" items="${LuckyProductVO_List}">
                    <div class="order-box bg-white rounded px-md-5 px-1 py-3">
                        <p>訂單編號:${LuckyProductVO.fateOrder}</p>
                        <table class="table table-bordered text-center">
                            <thead class="thead-light">
                            <tr>
                                <th>日期</th>
                                <th>產品</th>
                                <th>祈福資料</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td class="px-1">${LuckyProductVO.createTime}</td>
                                <td class="px-1">開運商品</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${LuckyProductVO.hasLampInfo ==1}">
                                            <a href="paySuccessAndInfo.html?fateOrder=${LuckyProductVO.fateOrder}"
                                               class="btn btn-sm btn-outline-secondary">祈福內容</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="paySuccessAndInfo.html?fateOrder=${LuckyProductVO.fateOrder}"
                                               class="btn btn-sm btn-warning">立即填寫</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <div id="plan-detail">
                            <a class="btn btn-sm text-dark" data-toggle="collapse"
                               href="#plan-detail-info${LuckyProductVO.idx}-luckyProduct">
                                <h5>訂單明細<span id="detail-toggle">▼</span></h5>
                            </a>
                            <div class="collapse pt-3" id="plan-detail-info${LuckyProductVO.idx}-luckyProduct">

                                <c:choose>
                                    <c:when test="${LuckyProductVO.deliver_Time_LuckyProduct == null}">
                                        <h5>寄送狀態: <span class="text-info">準備寄送</span></h5>
                                    </c:when>
                                    <c:otherwise>
                                        <h5>寄送狀態: <span class="text-success">已寄送</span></h5>
                                        <h5>寄送方式: <span
                                                class="text-success">${LuckyProductVO.deliver_Way_LuckyProduct}</span>
                                        </h5>
                                        <h5>寄送ID: <span
                                                class="text-success">${LuckyProductVO.deliver_ID_LuckyProduct}</span>
                                        </h5>
                                        <h5>寄送時間: <span
                                                class="text-success">${LuckyProductVO.deliver_Time_LuckyProduct}</span>
                                        </h5>
                                    </c:otherwise>
                                </c:choose>

                                <div class="px-3 mb-3">
                                    <p>貼心提醒</p>
                                    <small>1. 開運商品寄送方式採郵寄掛號寄送，將於祈福資料送出後<span class="text-danger">14個工作天</span>內完成寄送(不含例假日及國定假日)。</small><br>
                                    <small>2. 開運商品寄送方式採郵寄掛號寄送，寄送範圍僅限<span class="text-danger">中華民國台澎金馬地區</span>之居民，另外，若投遞2次未能投交者，郵局將寄發招領通知單，請您前往指定郵局或其他指定地點領取。</small><br>
                                    <small>3. 若超過期限未收到開運商品，請與客服聯繫確認。</small><br>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h5 class="text-center mb-2">此門號目前無訂單紀錄</h5>
                <br>
                <div class="btn btn-secondary btn-lg w-100" id="btnBackIndex">回首頁購買</div>
                <br><br><br><br><br><br><br><br><br>
            </c:otherwise>
        </c:choose>
    </div>

    <div id="showPic" class="modal modal-center fade" role="dialog">
        <div class="modal-popup">
            <div class="modal-close closeModal">
                <button class="btn btn-icon" style="float: right; background: transparent;" data-dismiss="modal">
                    <i class="fa fa-times fa-3x text-light"></i>
                </button>
            </div>
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-body text-center">
                </div>
                <div class="modal-footer" style="display: block;">
                    <button class="btn btn-warning closeModal" data-dismiss="modal">確認</button>
                </div>
            </div>
        </div>
    </div>

        <%-- header and footer --%>
        <!-- footer -->
        <jsp:include page="/WEB-INF/views/Common/footer.jsp" flush="true"/>

</div>
<script src="${basePath}/resources/js/jquery-3.4.1.min.js"></script>
<script src="${basePath}/resources/js/bootstrap.js"></script>

<%--header and footer--%>
<script src="${basePath}/resources/js/Common/header.js"></script>
<script src="${basePath}/resources/js/Common/footer.js"></script>
<script src="${basePath}/resources/js/aos-master/dist/aos.js"></script>


<script type="text/javascript">

    var pageId = 'fuyuntai_order';
    var fromPageId = '${fromPageId}'.replace(/,/g, '').replace(/%20/g, '');

    function initPage() {
        // $(document).ready 的事情統一在此處理
        addPageViewAjax(pageId, fromPageId);

        $(".plan-option").on("click", function () {
            var price = 0;
            switch ($(this).val()) {
                case 'threeMonth':
                    price = '1800';
                    break;
                case 'halfYear':
                    price = '3600';
                    break;
                case 'oneYear':
                    price = '6000';
                    break;
                default:
            }

            $(this).parent().parent().parent().children('.text-right').children('p').children('span').text(price);
        });

        $('.goVotive').click(function () {
            btnId = 'fuyuntai_btn_sendVotive';
            addItemClickAjax(pageId, btnId);

            var plan = $(this).parent().parent().children('ul').children('li').children('.plan-option:checked').val();
            if (plan == null) {
                return false;
            }

            var fateOrder = $(this).attr('fateOrder');
            location.href = '${basePath}/goVotive.html?votiveType=' + plan + '&fateOrder=' + fateOrder;
        });

        // 秀出圖片
        $('.checkPic').click(function () {
            var path = '${pathUrl}/storage/fuyuntai/';

            switch ($(this).attr('lamptype')) {
                case "光明燈":
                    path += 'light/光明燈-';
                    break;
                case "安太歲":
                    path += 'safe/太歲燈-';
                    break;
                case "四面佛-事業招財燈(6個月)":
                    path += 'money6/事業招財燈-';
                    break;
                case "四面佛-事業招財燈(3個月)":
                    path += 'money3/事業招財燈-';
                    break;
                case "四面佛-愛神燈(6個月)":
                    path += 'love6/愛神燈-';
                    break;
                case "四面佛-愛神燈(3個月)":
                    path += 'love3/愛神燈-';
                    break;
                case "votive":
                    path += 'votive/還願-';
                    break;
                default:
            }

            var imgUrl = path + $(this).attr('order') + '.jpg';

            $('.modal-body').empty();
            var html = '<img id="lampImage" src="' + imgUrl + '" width="100%" escapeXml="false" onerror="noPic()"/>';
            $('.modal-body').html(html);

            // popUp
            $('#showPic').modal('show');
            $('body').addClass('modal-open');
            $('.modal-backdrop').show();
            $('#showPic').show();
        });

        $('.closeModal').click(function () {
            $('#lampImage').show();
            $('#showPic').hide();
            $('.modal-backdrop').hide();
            $('body').removeClass('modal-open');
        });
    }

    function noPic() {
        $('#lampImage').hide();

        $('.modal-body').empty();

        var html = '<p>您的相片尚未上傳，再請稍候！</p><p>--</p><p>1.在您送出祈福資料後，會於<span class="text-danger">【隔週】</span>進行點燈祈福。</li></p><p>2.祈福完畢後，將於<span class="text-danger">10個工作天</span>內將祈福點燈的資料照上傳至您在開運算算的訂單頁中。</p><p>3.開運贈品會於送出祈福資料後<span class="text-danger">【次月】</span>寄送到您填寫的現居地址。</p>';
        $('.modal-body').html(html);
    }
</script>
<jsp:include page="/WEB-INF/views/Common/common.jsp" flush="true"/>
</body>
</html>