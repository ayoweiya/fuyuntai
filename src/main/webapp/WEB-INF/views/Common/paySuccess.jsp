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
    <title>付款成功!</title>

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

        .form-control {
            background-color: #E0E0E0;
        }

        .wrap_popup {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100vh;
            color: #333;
            transition: .5s;
            z-index: -1;
            background: transparent;
        }

        .wrap_popup.show {
            z-index: 100;
            background: rgba(0, 0, 0, .5);
        }

        .popup_box.show {
            transform: translateY(calc(25vh - 125px));
        }

        .popup_box {
            transition: .5s;
            position: absolute;
            width: 500px;
            /* height: 250px; */
            text-align: center;
            background: #e2e1e0;
            transform: translateY(1500px);
            left: calc(50vw - 250px);
            border-radius: 20px;
            box-shadow: 2px 2px 4px 1px rgba(0, 0, 0, .3);
        }

        .popup_cancel {
            position: relative;
            width: 50px;
            height: 50px;
            background: #f2bc67;
            clip-path: inset(0px 0px 0px 0px round 0 0 20% 20%);
            -webkit-clip-path: inset(0px 0px 0px 0px round 0 0 20% 20%);
            margin-left: 420px;
        }

        .popup_cancel span {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
            font-size: 1.5rem;
            cursor: pointer;
        }

        .luckyProduct {
            display: none;
        }

        .btn_submit {
            text-align: center;
            margin: 25px 0 20px 0;
        }

        .btn_submit span {
            background: #f2bc67;
            padding: 5px 80px;
            border-radius: 20px;
            color: white;
            cursor: pointer;
        }

        .btn_submit span:hover {
            box-shadow: 1px 1px 3px rgba(0, 0, 0, .5);
        }

        @media (max-width: 575px) {
            .popup_box {
                width: 300px;
                /* height: 250px; */
                transform: translateY(1000px);
                left: calc(50vw - 150px);
            }

            .popup_box.show {
                transform: translateY(calc(25vh - 110px));
            }

            .popup_cancel {
                margin-left: 220px;
            }
        }

        @media (max-width: 320px) {
            .popup_box {
                width: 250px;
                /* height: 200px; */
                left: calc(50vw - 125px);
            }

            .popup_box.show {
                transform: translateY(calc(25vh - 100px));
            }

            .popup_cancel {
                position: relative;
                width: 50px;
                height: 30px;
                background: #f2bc67;
                clip-path: inset(0px 0px 0px 0px round 0 0 20% 20%);
                margin-left: 180px;
            }
        }
    </style>
</head>
<body>
<div class="wrap-content">

    <%-- header and footer --%>
    <%-- header --%>
    <jsp:include page="/WEB-INF/views/Common/header.jsp" flush="true"/>

    <div class="container-fluid text-center py-3" style="background-color: #E0E0E0;">
        <h2 class="h5 mb-2">付費成功</h2>
        <p>請誠心地述說自己的心願和對佛的許諾</p>
        <form action="${basePath}/saveInfo.html" class="px-md-5 px-2 pb-3 text-left bg-white rounded" id="main-form">

            <h3 class="h5 pt-3">祈福內容:${lampTypeName}</h3>

            <div class="form-group">
                <label for="name">姓名</label>
                <c:choose>
                    <c:when test="${empty name}">
                        <input type="text" name="name" id="name" class="form-control">
                    </c:when>
                    <c:otherwise>
                        <input type="text" name="name" id="name" class="form-control" value='${name}' disabled>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="form-group">
                <label>出生日期</label>
                <div class="form-row">
                    <div class="col">
                        <c:choose>
                        <c:when test="${empty birthYear}">
                        <select name="birth-year" id="birth-year" class="form-control">
                            </c:when>
                            <c:otherwise>
                            <select class="form-control" disabled>
                                <option value="${birthYear}" selected>${birthYear}</option>
                                </c:otherwise>
                                </c:choose>
                            </select>
                    </div>
                    <div class="col">
                        <c:choose>
                        <c:when test="${empty birthMonth}">
                        <select name="birth-month" id="birth-month" class="form-control">
                            </c:when>
                            <c:otherwise>
                            <select class="form-control" disabled>
                                <option value="${birthMonth}" selected>${birthMonth}</option>
                                </c:otherwise>
                                </c:choose>
                            </select>
                    </div>
                    <div class="col">
                        <c:choose>
                        <c:when test="${empty birthDate}">
                        <select name="birth-day" id="birth-day" class="form-control">
                            </c:when>
                            <c:otherwise>
                            <select class="form-control" disabled>
                                <option value="${birthDate}" selected>${birthDate}</option>
                                </c:otherwise>
                                </c:choose>
                            </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label>現居地址</label>
                <div class="form-check pl-1">
                    <c:choose>
                        <c:when test="${empty area}">
                            <input type="radio" name="area" value="taiwan" style="transform: scale(2);" class="mr-2"
                                   checked>
                            <label class="mr-md-5 mr-2">台灣地區</label>
                            <input type="radio" name="area" value="foreign" style="transform: scale(2);" class="mr-2">
                            <label>海外地區</label>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${area=='foreign'}">
                                    <input type="radio" name="area" value="foreign" id="taiwanArea"
                                           style="transform: scale(2);" class="mr-2" disabled>
                                    <label class="mr-md-5 mr-2">台灣地區</label>
                                    <input type="radio" name="area" value="foreign" id="foreignArea"
                                           style="transform: scale(2);" class="mr-2" checked disabled>
                                    <label>海外地區</label>
                                </c:when>
                                <c:otherwise>
                                    <input type="radio" name="area" value="taiwan" style="transform: scale(2);"
                                           class="mr-2" checked disabled>
                                    <label class="mr-md-5 mr-2">台灣地區</label>
                                    <input type="radio" name="area" value="taiwan" style="transform: scale(2);"
                                           class="mr-2" disabled>
                                    <label>海外地區</label>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="form-row">
                    <div class="col">
                        <c:choose>
                            <c:when test="${empty city}">
                                <select name="city" id="city" class="form-control area-selector">
                                </select>
                            </c:when>
                            <c:otherwise>
                                <select id="city" class="form-control">
                                    <option selected disabled>${city}</option>
                                </select>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="col">
                        <c:choose>
                            <c:when test="${empty dist}">
                                <select name="dist" id="dist" class="form-control area-selector">
                                    <option value="" selected disabled>鄉/鎮/市/區</option>
                                </select>
                            </c:when>
                            <c:otherwise>
                                <select id="dist" class="form-control">
                                    <option selected disabled>${dist}</option>
                                </select>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${empty road}">
                        <input type="text" id="road" name="road" class="form-control mt-2">
                    </c:when>
                    <c:otherwise>
                        <input type="text" value="${road}" class="form-control mt-2" readonly>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="form-group">
                <label>請誠心地許下您的願望</label>
                <c:choose>
                    <c:when test="${empty wishMsg}">
                        <textarea name="wish-msg" id="wish-msg" cols="30" rows="10" maxlength="70"
                                  style="resize : none;" class="form-control"></textarea>
                    </c:when>
                    <c:otherwise>
                        <textarea name="wish-msg" id="wish-msg" cols="30" rows="10" maxlength="70"
                                  style="resize : none;" class="form-control" disabled>${wishMsg}</textarea>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="px-3 mb-3">
                <p>貼心提醒</p>
                <small>1. 提醒您，送出資料後才算完成點燈祈福&開運商品領取步驟喔！</small><br>
                <small>2. 若您在<span class="text-danger">【當月】</span>送出祈福資料，則會於<span class="text-danger">【次月20日】</span>由無上元老師祈福，例如您在8月15日送出祈福資料，則會於9月20日由無上元老師祈福。</small><br>
                <small>3. 祈福完畢後，將於<span class="text-danger">10個工作天</span>內將祈福點燈的資料照上傳至您在開運算算的訂單頁中。</small><br>
            </div>


            <div class="luckyProduct">
                <h3 class="h5 pt-3">購買品項: ${luckyProduct}</h3>
                <div class="form-group">
                    <label for="name_luckyProduct">收件人姓名</label> <%-- 對應下面的id --%>
                    <c:choose>
                        <%-- 如果後端沒有傳值過來，就給填--%>
                        <c:when test="${empty name_luckyProduct}">
                            <input type="text" name="name_luckyProduct" id="name_luckyProduct" class="form-control">
                        </c:when>

                        <%-- 如果後端有傳值過來，就不給填--%>
                        <c:otherwise>
                            <input type="text" name="name_luckyProduct" id="name_luckyProduct" class="form-control"
                                   value="${name_luckyProduct}" disabled>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="form-group">
                    <label>現居地址</label>
                    <div class="form-check pl-1">
                        <c:choose>
                            <%-- 如果後端沒有傳值過來，就給填--%>
                            <c:when test="${empty area_luckyProduct}">
                                <input type="radio" name="area_luckyProduct" value="taiwan" style="transform: scale(2);"
                                       class="mr-2"
                                       checked>
                                <label class="mr-md-5 mr-2">台灣地區</label>
                                <input type="radio" name="area_luckyProduct" value="foreign"
                                       style="transform: scale(2);" class="mr-2" disabled>
                                <label>海外地區</label>
                            </c:when>

                            <%-- 如果後端有傳值過來，就不給填--%>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${area_luckyProduct=='foreign'}">
                                        <input type="radio" name="area_luckyProduct" value="taiwan" id="taiwanArea"
                                               style="transform: scale(2);" class="mr-2" disabled>
                                        <label class="mr-md-5 mr-2">台灣地區</label>
                                        <input type="radio" name="area_luckyProduct" value="foreign" id="foreignArea"
                                               style="transform: scale(2);" class="mr-2" checked disabled>
                                        <label>海外地區</label>
                                    </c:when>

                                    <c:otherwise>
                                        <input type="radio" name="area_luckyProduct" value="taiwan"
                                               style="transform: scale(2);"
                                               class="mr-2" checked disabled>
                                        <label class="mr-md-5 mr-2">台灣地區</label>
                                        <input type="radio" name="area_luckyProduct" value="foreign"
                                               style="transform: scale(2);"
                                               class="mr-2" disabled>
                                        <label>海外地區</label>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="form-row">
                        <div class="col">
                            <c:choose>
                                <c:when test="${empty city_luckyProduct}">
                                    <select name="city_luckyProduct" id="city_luckyProduct"
                                            class="form-control area-selector">
                                    </select>
                                </c:when>

                                <c:otherwise>
                                    <select id="city_luckyProduct" class="form-control">
                                        <option selected disabled>${city_luckyProduct}</option>
                                    </select>
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <div class="col">
                            <c:choose>
                                <c:when test="${empty dist_luckyProduct}">
                                    <select name="dist_luckyProduct" id="dist_luckyProduct"
                                            class="form-control area-selector">
                                        <option value="" selected disabled>鄉/鎮/市/區</option>
                                    </select>
                                </c:when>

                                <c:otherwise>
                                    <select id="dist_luckyProduct" class="form-control">
                                        <option selected disabled>${dist_luckyProduct}</option>
                                    </select>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>

                    <c:choose>
                        <c:when test="${empty road_luckyProduct}">
                            <input type="text" id="road_luckyProduct" name="road_luckyProduct"
                                   class="form-control mt-2">
                        </c:when>

                        <c:otherwise>
                            <input type="text" value="${road_luckyProduct}" class="form-control mt-2" readonly>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="px-3 mb-3">
                    <p>貼心提醒</p>
                    <small>1. 開運商品寄送方式採郵寄掛號寄送，將於祈福資料送出後<span class="text-danger">14個工作天</span>內完成寄送(不含例假日及國定假日)。</small><br>
                    <small>2. 開運商品寄送方式採郵寄掛號寄送，寄送範圍僅限<span class="text-danger">中華民國台澎金馬地區</span>之居民，另外，若投遞2次未能投交者，郵局將寄發招領通知單，請您前往指定郵局或其他指定地點領取。</small><br>
                    <small>3. 若超過期限未收到開運商品，請與客服聯繫確認。</small><br>
                </div>

            </div>

            <div class="row my-3">
                <div class="col">
                    <c:choose>

                        <c:when test="${empty wishMsg}">
                            <div class="btn btn-lg w-100 text-white" id="confirm-btn"
                                 style="background-color: #c9a02a;">萬分感恩，送出資料
                            </div>
                        </c:when>

                        <c:otherwise>
                            <div class="btn btn-secondary btn-lg w-100" id="btnBackOrder">回訂單頁</div>
                        </c:otherwise>

                    </c:choose>
                </div>
            </div>

            <input type="hidden" name="fateOrder" id="fateOrder" value="${fateOrder}">
            <input type="hidden" name="userMsisdn" id="userMsisdn" value="${userMsisdn}">

        </form>
    </div>

        <div class="wrap_popup">
            <div class="popup_box">
                <div class="popup_cancel"><span>Ｘ</span></div>
                <p class="popup_content"></p>
                <div class="btn_submit"><span>確認</span></div>
            </div>
        </div>

        <%-- header and footer --%>
        <!-- footer -->
        <jsp:include page="/WEB-INF/views/Common/footer.jsp" flush="true"/>

</div>

<script src="${basePath}/resources/js/jquery-3.4.1.min.js"></script>

<%--header and footer--%>
<script src="${basePath}/resources/js/Common/header.js"></script>
<script src="${basePath}/resources/js/Common/footer.js"></script>
<script src="${basePath}/resources/js/aos-master/dist/aos.js"></script>

<script type="text/javascript">
    var pageId = 'fuyuntai_success';
    var fromPageId = '${fromPageId}'.replace(/,/g, '').replace(/%20/g, '');
    var withLuckyProduct = false;

    function initPage() {
        // $(document).ready 的事情統一在此處理
        addPageViewAjax(pageId, fromPageId);

        // 判斷有沒有伴隨著開運商品
        if ("${luckyProduct}" !== "none" || "${name_luckyProduct}" !== "") {
            withLuckyProduct = true;
        }

        if (withLuckyProduct) {
            $('.luckyProduct').show();
        }

        initPaySuccess();

        //render date select
        function initPaySuccess() {

            renderYear(1910); //set deafult year
            $('#birth-year').change(dateChange);
            $('#birth-month').change(dateChange);

            if (${empty area}) {
                let cityOptionStr = '<option value="" selected disabled>縣/市</option>';
                $.getJSON("${basePath}/resources/js/areadata.json", function (data) {
                    $.each(data, function (i, item) {
                        cityOptionStr += '<option value="' + item.name + '">' + item.name + '</option>';
                    })
                    $("#city").append(cityOptionStr);
                });
            }

            // 開運商品的city資料, city增加預設值
            if (${empty area_luckyProduct}) {
                let cityOptionStr = '<option value="" selected disabled>縣/市</option>';
                $.getJSON("${basePath}/resources/js/areadata.json", function (data) {
                    $.each(data, function (i, item) {
                        cityOptionStr += '<option value="' + item.name + '">' + item.name + '</option>';
                    })
                    $("#city_luckyProduct").append(cityOptionStr);
                });
            }
        }

        // birthday
        function renderYear(yearStart) {
            let now = new Date();
            let yearStr = "";
            for (i = yearStart; i <= now.getFullYear(); i++) {
                if (i == 1985) {
                    yearStr += '<option value="' + i + '" selected>' + i + '</option>';
                }
                yearStr += '<option value="' + i + '">' + i + '</option>';
            }
            $('#birth-year').append(yearStr);
            renderMonth();
            dateChange();
        }

        function renderMonth() {
            let monthStr = "";
            for (i = 1; i <= 12; i++) {
                if (i == 6) {
                    monthStr += '<option value="' + i + '" selected>' + i + '</option>';
                } else {
                    monthStr += '<option value="' + i + '">' + i + '</option>';
                }
            }
            $('#birth-month').append(monthStr);
        }

        function dateChange() {
            $('#birth-day').empty();
            let bigM = ['1', '3', '5', '7', '8', '12']
            let dayLen = 31;
            let dayStr = "";
            let year = $('#birth-year').val();
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) && $('#birth-month') == 2) {
                dayLen = 29;
            } else if ($('#birth-month').val() == 2) {
                dayLen = 28;
            } else if (bigM.indexOf($('#birth-month').val()) == -1) {
                dayLen = 30;
            }
            for (i = 1; i <= dayLen; i++) {
                if (i == 15) {
                    dayStr += '<option value="' + i + '" selected>' + i + '</option>';
                } else {
                    dayStr += '<option value="' + i + '">' + i + '</option>';
                }
            }
            $('#birth-day').append(dayStr);
        }

        // 燈
        // "taiwan or foreign" check, dist增加預設值
        $('input[name="area"]').click(function (e) {
            if ($(this).val() === "taiwan") {

                $('#city').empty().removeClass('d-none');
                $('#dist').empty().removeClass('d-none');

                $('#dist').append('<option value="" selected disabled>鄉/鎮/市/區</option>');
                var cityOptionStr = '<option value="" selected disabled>縣/市</option>';
                $.getJSON("${basePath}/resources/js/areadata.json", function (data) {
                    $.each(data, function (i, item) {
                        cityOptionStr += '<option value="' + item.name + '">' + item.name + '</option>';
                    })
                    $("#city").append(cityOptionStr);
                })
            } else if ($(this).val() === "foreign") {
                $("#city").addClass('d-none');
                $("#dist").addClass('d-none');
            }
        });

        // 開運商品
        // "taiwan or foreign" check, dist增加預設值
        $('input[name="area_luckyProduct"]').click(function (e) {
            if ($(this).val() === "taiwan") {

                $('#city_luckyProduct').empty().removeClass('d-none');
                $('#dist_luckyProduct').empty().removeClass('d-none');

                $('#dist_luckyProduct').append('<option value="" selected disabled>鄉/鎮/市/區</option>');
                var cityOptionStr = '<option value="" selected disabled>縣/市</option>';
                $.getJSON("${basePath}/resources/js/areadata.json", function (data) {
                    $.each(data, function (i, item) {
                        cityOptionStr += '<option value="' + item.name + '">' + item.name + '</option>';
                    })
                    $("#city_luckyProduct").append(cityOptionStr);
                })
            } else if ($(this).val() === "foreign") {
                $("#city_luckyProduct").addClass('d-none');
                $("#dist_luckyProduct").addClass('d-none');
            }
        });

        // 燈
        //render dist list
        $("#city").change(function () {
            $("#dist").empty();
            $.getJSON("${basePath}/resources/js/areadata.json", function (data) {
                let distOptionStr = '<option value="" selected disabled>鄉/鎮/市/區</option>';
                let distObj = data.find(function (item) {
                    return item.name === $("#city").val()
                })
                $.each(distObj.districts, function (i, item) {
                    distOptionStr += '<option value="' + item.name + '">' + item.name + '</option>'
                })
                $('#dist').append(distOptionStr);
            })
        });

        // 開運商品
        //render dist list
        $("#city_luckyProduct").change(function () {
            $("#dist_luckyProduct").empty();
            $.getJSON("${basePath}/resources/js/areadata.json", function (data) {
                let distOptionStr = '<option value="" selected disabled>鄉/鎮/市/區</option>';
                let distObj = data.find(function (item) {
                    return item.name === $("#city_luckyProduct").val()
                })
                $.each(distObj.districts, function (i, item) {
                    distOptionStr += '<option value="' + item.name + '">' + item.name + '</option>'
                })
                $('#dist_luckyProduct').append(distOptionStr);
            })
        });

        //data validation
        $("#confirm-btn").click(function () {
            btnId = 'fuyuntai_btn_sendInfo';
            addItemClickAjax(pageId, btnId);

            let name = $("#name").val();
            let birthYear = $("#birth-year").val();
            let birthMonth = $("#birth-month").val();
            let birthDay = $("#birth-day").val();
            let birth = birthYear + '/' + birthMonth + '/' + birthDay;
            let area = $('input[name=area]:checked').val();
            let addrCity = $("#city").val();
            let addrDist = $("#dist").val();
            let addrRoad = $("#road").val();
            let wishMsg = $('#wish-msg').val();
            if (wishMsg.length > 0 && wishMsg.length < 5) {
                alert("願望不得少於5個字");
                return;
            }

            let name_luckyProduct = $("#name_luckyProduct").val();
            let area_luckyProduct = $('input[name=area_luckyProduct]:checked').val();
            let city_luckyProduct = $("#city_luckyProduct").val();
            let dist_luckyProduct = $("#dist_luckyProduct").val();
            let road_luckyProduct = $("#road_luckyProduct").val();

            // 有開運商品
            if (withLuckyProduct) {
                console.log(0);
                console.log(area);
                console.log(name);
                console.log(birthYear);
                console.log(birthMonth);
                console.log(birthDay);
                console.log(addrCity);
                console.log(addrDist);
                console.log(addrRoad);
                console.log(wishMsg);
                console.log(name_luckyProduct);
                console.log(area_luckyProduct);
                console.log(city_luckyProduct);
                console.log(dist_luckyProduct);
                console.log(road_luckyProduct);


                if ((area === 'taiwan') && name && birthYear && birthMonth && birthDay && addrCity && addrDist && addrRoad && wishMsg
                    && name_luckyProduct && area_luckyProduct && city_luckyProduct && dist_luckyProduct && road_luckyProduct) {
                    console.log(1);
                    let confirmStr = '<p>=====祈福內容===== </p>' + '<p>姓名:' + name + '</p><p>出生日期:' + birth + '</p><p>地址:' + addrCity + addrDist + addrRoad + '</p><p>願望:' + wishMsg + '</p>'
                        + '<br>' + '<p>=====購買品項===== </p>' + '<p>姓名:' + name_luckyProduct + '</p><p>地址:' + city_luckyProduct + dist_luckyProduct + road_luckyProduct + '</p>';
                    $('.popup_content').empty().append(confirmStr);
                    $('.popup_box').addClass('show');
                    $('.wrap_popup').addClass('show');
                } else if (((area === 'foreign')) && name && birthYear && birthMonth && birthDay && addrRoad && wishMsg
                    && name_luckyProduct && area_luckyProduct && road_luckyProduct) {
                    console.log(2);
                    let confirmStr = '<p>=====祈福內容===== </p>' + '<p>姓名:' + name + '</p><p>出生日期:' + birth + '</p><p>地址:' + addrRoad + '</p><p>願望:' + wishMsg
                        + '<br>' + '<p>=====購買品項===== </p>' + '<p>姓名:' + name_luckyProduct + '</p><p>地址:' + city_luckyProduct + dist_luckyProduct + road_luckyProduct + '</p>';
                    $('.popup_content').empty().append(confirmStr);
                    $('.popup_box').addClass('show');
                    $('.wrap_popup').addClass('show');
                } else {
                    alert('請您完整填寫資料><"');
                }
            } else {
                // 沒有開運商品
                if ((area === 'taiwan') && name && birthYear && birthMonth && birthDay && addrCity && addrDist && addrRoad && wishMsg) {
                    let confirmStr = '<p>姓名:' + name + '</p><p>出生日期:' + birth + '</p><p>地址:' + addrCity + addrDist + addrRoad + '</p><p>願望:' + wishMsg + '</p>';
                    $('.popup_content').empty().append(confirmStr);
                    $('.popup_box').addClass('show');
                    $('.wrap_popup').addClass('show');
                } else if (((area === 'foreign')) && name && birthYear && birthMonth && birthDay && addrRoad && wishMsg) {
                    let confirmStr = '<p>姓名:' + name + '</p><p>出生日期:' + birth + '</p><p>地址:' + addrRoad + '</p><p>願望:' + wishMsg + '</p>';
                    $('.popup_content').empty().append(confirmStr);
                    $('.popup_box').addClass('show');
                    $('.wrap_popup').addClass('show');
                } else {
                    alert('請您完整填寫資料><"');
                }
            }

        })

        //close popup box
        $(".popup_cancel").click(function () {
            $(".popup_box").removeClass("show");
            $(".wrap_popup").removeClass("show");
        })

        //submit data
        $(".btn_submit").click(function () {
            btnId = 'fuyuntai_btn_check';
            addItemClickAjax(pageId, btnId);

            $("#main-form").submit();
        })

        $("#btnBackOrder").click(function () {
            location.href = "${basePath}/orderList.html";
        });

    }

    if (${area=='foreign'}) {
        $("#city").addClass('d-none');
        $("#dist").addClass('d-none');
    }
</script>
<jsp:include page="/WEB-INF/views/Common/common.jsp" flush="true"/>
</body>
</html>