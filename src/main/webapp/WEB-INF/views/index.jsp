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
    <title>開運算算｜相信的力量，一同體驗泰國愛侶灣四面佛的神威與靈驗</title>
    <meta name="title" content="開運算算｜相信的力量，一同體驗泰國愛侶灣四面佛的神威與靈驗">
    <meta name="description"
          content="四面佛的『有求必應』，讓來自四面八方的信徒，透過的獻花、點燈、供香祈願，對佛訴說著自己的故事及未來的許諾，願佛的慈悲與寬容像是一道曙光，指引著正向的道路，與開運算算一起透過誠心的點燈，體驗四面佛－相信的力量！">
    <meta name="keywords" content="開運算算,四面佛,線上,點燈">
    <link rel="canonical" href="https://fate.opoint.com.tw/erawan/index.html">

    <meta property="og:title" content="開運算算｜相信的力量，一同體驗泰國愛侶灣四面佛的神威與靈驗">
    <meta property="og:site_name" content="開運算算｜相信的力量，一同體驗泰國愛侶灣四面佛的神威與靈驗">
    <meta property="og:type" content="website">
    <meta property="og:url" content=" https://fate.opoint.com.tw/erawan/index.html ">
    <meta property="og:image" content="https://dlcdnimgs.asus.com/20160129_cosmo/cosmo/images/asus_logo.jpg">
    <meta property="og:description" content="對佛訴說著自己的故事及未來的許諾，願佛的慈悲與寬容像是一道曙光，指引著正向的道路，與開運算算一起透過誠心的點燈，體驗四面佛－相信的力量！ ">

    <!-- CSS LINK -->
    <link rel="stylesheet" href="${basePath}/resources/css/cssreset-min.css">
    <link rel="stylesheet" href="${basePath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${basePath}/resources/css/swiper-bundle.min.css">
    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
    <link rel="stylesheet" href="${basePath}/resources/css/fontawesome-free-5.15.1.min.css">

    <%-- header and footer--%>
    <link href="${basePath}/resources/css/header.css" rel="stylesheet">
    <link href="${basePath}/resources/css/footer.css" rel="stylesheet">
    <link href="${basePath}/resources/css/main.css" rel="stylesheet">
    <link href="${basePath}/resources/css/normalize.css" rel="stylesheet">
    <link rel="stylesheet" href="${basePath}/resources/js/aos-master/dist/aos.css"/>

    <style>
        body {
            background-color: grey;
        }

        .clear-padding {
            padding-right: 0px;
            padding-left: 0px;
        }

        .productPlan {
            padding-bottom: 20%;
        }

        .planGroup {
            padding: 5% 10% 10%;
            border: 2px solid #ccaf0a;
            border-top: none;
        }

        .col input + label .fa-circle {
            display: block;
        }

        .col input + label .fa-check-circle {
            display: none;
        }

        .col input:checked + label .fa-circle {
            display: none;
        }

        .col input:checked + label .fa-check-circle {
            display: block;
        }

        .planImg {
            flex: 4;
            margin-left: 1rem;
        }

        .col label {
            width: 100%;
        }

        .plan-info {
            margin-left: 15%;
        }

        .order-btn {
            cursor: pointer;
        }

        .btn-nofixed {
            width: 300px;
            margin: 0 auto;
        }

        .btn-fixed {
            width: 300px;
            position: fixed;
            left: 50%;
            transform: translateX(-50%);
            bottom: 30px;
            z-index: 50;
        }

        .checkOredr-btn {
            width: 50%;
            position: absolute;
            transform: translateX(-50%);
            left: 50%;
            bottom: 10%;
            cursor: pointer;
        }

        .map-section {
            position: relative;
            padding-bottom: 70%; /* 此為地圖長寬比 */
            overflow: hidden;
        }

        .map-section iframe {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
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
            transform: translateY(calc(50vh - 125px));
        }

        .popup_box {
            transition: .5s;
            position: absolute;
            width: 500px;
            /* height: 250px; */
            background: #e2e1e0;
            transform: translateY(100vh);
            left: calc(50vw - 250px);
            border-radius: 20px;
            box-shadow: 2px 2px 4px 1px rgba(0, 0, 0, .3);
        }

        .popup_box select {
            appearance: none;
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

        .popup_title {
            margin: 20px 0;
            text-align: center;
        }

        .btn_submit,
        .btn_cancel {
            text-align: center;
            margin: 25px 0 20px 0;
        }

        .btn_submit span,
        .btn_cancel span {
            background: #f2bc67;
            padding: 5px 80px;
            border-radius: 20px;
            color: white;
            cursor: pointer;
        }

        .btn_submit span:hover,
        .btn_cancel span:hover {
            box-shadow: 1px 1px 3px rgba(0, 0, 0, .5);
        }

        @media screen and (max-width: 575px) {
            .btn-nofixed {
                width: 150px;
            }

            .btn-fixed {
                width: 150px;
            }

            .popup_box {
                width: 400px;
                /* height: 250px; */
                transform: translateY(1000px);
                left: calc(50vw - 200px);
            }

            .popup_box.show {
                transform: translateY(calc(50vh - 110px));
            }

            .popup_cancel {
                margin-left: 80%;
            }

            .fa-3x {
                font-size: 1.5em
            }
        }

        @media screen and (max-width: 393px) {
            .popup_box {
                width: 90%;
                /* height: 200px; */
                left: calc(50vw - 45%);
            }

            .popup_box.show {
                transform: translateY(calc(50vh - 100px));
            }

            .popup_cancel {
                position: relative;
                width: 50px;
                height: 30px;
                background: #f2bc67;
                clip-path: inset(0px 0px 0px 0px round 0 0 20% 20%);
                margin-left: 80%;
            }
        }

        @media screen and (max-width: 320px) {
            .popup_box {
                width: 250px;
                /* height: 200px; */
                left: calc(50vw - 125px);
            }

            .popup_box.show {
                transform: translateY(calc(50vh - 100px));
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
<div class="container-lg clear-padding">

    <%-- header and footer --%>
    <%-- header --%>
    <jsp:include page="/WEB-INF/views/Common/header.jsp" flush="true"/>

    <img src="${basePath}/resources/img/erawan_index_01.png" alt="" width="100%">
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <img src="${basePath}/resources/img/erawan_index_02-1.png" alt="" width="100%">
            </div>
            <div class="swiper-slide">
                <img src="${basePath}/resources/img/erawan_index_02-2.png" alt="" width="100%">
            </div>
            <div class="swiper-slide">
                <img src="${basePath}/resources/img/erawan_index_02-3.png" alt="" width="100%">

            </div>
            <div class="swiper-slide">
                <img src="${basePath}/resources/img/erawan_index_02-4.png" alt="" width="100%">
            </div>
        </div>
        <div class="swiper-button-prev" style="color:#c9a02a;"></div>
        <div class="swiper-button-next" style="color:#c9a02a;"></div>
    </div>
    <img src="${basePath}/resources/img/erawan_index_03.png" alt="" width="100%">
    <img src="${basePath}/resources/img/erawan_index_04_title.png" alt="" width="100%">
    <div class="productPlan px-sm-5 px-4 bg-white" id="productPlan">
        <div class="planGroup">
            <form action="" class="row flex-column align-items-center">
                <div class="col pb-3">
                    <input type="radio" name="plan" value="plan_1" id="plan1" class="d-none">
                    <label for="plan1" class="d-flex align-items-center outer_option">
                        <i class="far fa-circle text-warning fa-3x"></i>
                        <i class="fas fa-check-circle text-warning fa-3x"></i>
                        <div class="planImg">
                            <img src="${basePath}/resources/img/erawan_index_04_btn_1.png" alt="" width="100%">
                        </div>
                    </label>
                </div>
                <div class="col pb-3">
                    <input type="radio" name="plan" value="plan_2" id="plan2" class="d-none">
                    <label for="plan2" class="d-flex align-items-center outer_option">
                        <i class="far fa-circle text-warning fa-3x"></i>
                        <i class="fas fa-check-circle text-warning fa-3x"></i>
                        <div class="planImg">
                            <img src="${basePath}/resources/img/erawan_index_04_btn_2.png" alt="" width="100%">
                        </div>
                    </label>
                </div>
                <div class="col pb-3">
                    <input type="radio" name="planToggle" value="" id="plan3Toogle" class="d-none">
                    <label for="plan3Toogle" class="d-flex align-items-center infoToggle">
                        <i class="far fa-circle text-warning fa-3x"></i>
                        <i class="fas fa-check-circle text-warning fa-3x"></i>
                        <div class="planImg">
                            <img src="${basePath}/resources/img/erawan_index_04_btn_3.png" alt="" width="100%">
                        </div>
                    </label>
                    <div class="plan-info mt-3" style="display: none;">
                        <div class="form-group">
                            <input type="radio" name="plan" value="plan_3-1" id="plan3-1" class="d-none">
                            <label for="plan3-1" class="d-flex align-items-center inner_option">
                                <i class="far fa-circle text-warning fa-3x"></i>
                                <i class="fas fa-check-circle text-warning fa-3x"></i>
                                <div class="">
                                    <h5 class="ml-3">六個月/$990</h5>
                                </div>
                            </label>
                        </div>
                        <div class="form-group">
                            <input type="radio" name="plan" value="plan_3-2" id="plan3-2" class="d-none">
                            <label for="plan3-2" class="d-flex align-items-center inner_option">
                                <i class="far fa-circle text-warning fa-3x"></i>
                                <i class="fas fa-check-circle text-warning fa-3x"></i>
                                <div class="">
                                    <h5 class="ml-3">三個月/$495</h5>
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col pb-3">
                    <input type="radio" name="planToggle" value="" id="plan4Toogle" class="d-none">
                    <label for="plan4Toogle" class="d-flex align-items-center infoToggle">
                        <i class="far fa-circle text-warning fa-3x"></i>
                        <i class="fas fa-check-circle text-warning fa-3x"></i>
                        <div class="planImg">
                            <img src="${basePath}/resources/img/erawan_index_04_btn_4.png" alt="" width="100%">
                        </div>
                    </label>
                    <div class="plan-info mt-3" style="display: none;">
                        <div class="form-group">
                            <input type="radio" name="plan" value="plan_4-1" id="plan4-1" class="d-none">
                            <label for="plan4-1" class="d-flex align-items-center inner_option">
                                <i class="far fa-circle text-warning fa-3x"></i>
                                <i class="fas fa-check-circle text-warning fa-3x"></i>
                                <div>
                                    <h5 class="ml-3">六個月/$990</h5>
                                </div>
                            </label>
                        </div>
                        <div class="form-group">
                            <input type="radio" name="plan" value="plan_4-2" id="plan4-2" class="d-none">
                            <label for="plan4-2" class="d-flex align-items-center inner_option">
                                <i class="far fa-circle text-warning fa-3x"></i>
                                <i class="fas fa-check-circle text-warning fa-3x"></i>
                                <div>
                                    <h5 class="ml-3">三個月/$495</h5>
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </form>
            <div class="wrap-btn btn-fixed">
                <a href="#productPlan">
                    <img src="${basePath}/resources/img/erawan_index_btn_send_2.png" alt="" width="100%">
                </a>
            </div>
            <div class="order-btn btn-nofixed">
                <img src="${basePath}/resources/img/erawan_index_btn_send_2.png" alt="" width="100%">
            </div>
        </div>
    </div>
    <div class="position-relative">
        <img src="${basePath}/resources/img/erawan_index_05.png" alt="" width="100%">
        <a href="${basePath}/orderList.html" class="checkOredr-btn">
            <img src="${basePath}/resources/img/erawan_index_btn_order_2.png" alt="" width="100%">
        </a>
    </div>
    <div class="content-info d-flex flex-column align-items-center bg-white pb-5">
        <img src="${basePath}/resources/img/erawan_index_06.png" alt="" width="100%">
        <div class="map-section col-10">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1807.128338572836!2d121.5302248760025!3d25.05928800874058!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442a95c3c56a8f3%3A0x64ec89810381c7c2!2zMTA0OTHlj7DljJfluILkuK3lsbHljYDlkInmnpfot68xNzXomZ8!5e0!3m2!1szh-TW!2stw!4v1609901081340!5m2!1szh-TW!2stw"
                    frameborder="0" style="border:0;" tabindex="0"></iframe>
        </div>
    </div>

    <%-- header and footer --%>
    <!-- footer -->
    <jsp:include page="/WEB-INF/views/Common/footer.jsp" flush="true"/>

</div>
<div class="wrap_popup">
    <div class="popup_box box_1">
        <div class="popup_cancel"><span>Ｘ</span></div>
        <p class="popup_title"></p>
        <div class="btn_cancel"><span>確認</span></div>
    </div>
    <div class="popup_box box_2">
        <div class="popup_cancel"><span>Ｘ</span></div>
        <p class="popup_title">請輸入手機門號後進行購買流程！</p>
        <div class="row justify-content-center">
            <select class="col-4 mr-2 pr-2 display-md-1" placeholder="國碼" id="cCode">
                <option value="886" selected="">臺灣 +886</option>
                <option value="86">中國 +86</option>
                <option value="852">香港 +852</option>
                <option value="853">澳門 +853</option>
                <option value="65">新加坡 +65</option>
                <option value="60">馬來西亞 +60</option>
            </select>
            <input type="text" class="col-6 py-2" placeholder="請輸入電話號碼" id="userPhone"">
        </div>
        <p class=" error_text text-danger text-center d-none">請輸入正確國碼及門號</p>
        <div class="btn_submit"><span>確認</span></div>
    </div>
</div>

<script src="${basePath}/resources/js/jquery-3.4.1.min.js"></script>
<script src="${basePath}/resources/js/swiper-bundle.js"></script>
<script src="${basePath}/resources/js/bootstrap.js"></script>

<%--header and footer--%>
<script src="${basePath}/resources/js/Common/header.js"></script>
<script src="${basePath}/resources/js/Common/footer.js"></script>
<script src="${basePath}/resources/js/aos-master/dist/aos.js"></script>

<script type="text/javascript">
    var pageId = 'erawan_index';
    var fromPageId = '${fromPageId}'.replace(/,/g, '').replace(/%20/g, '');

    function initPage() {
        // $(document).ready 的事情統一在此處理
        addPageViewAjax(pageId, fromPageId);

        //for swiper config
        var mySwiper = new Swiper('.swiper-container', {
            // Optional parameters
            direction: 'horizontal',
            loop: true,
            // Navigation arrows
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
        })
        //展開方案及預設選取A方案
        $(".infoToggle").click(function () {
            $(this).next().find('[name="plan"]').first().prop("checked", true);
            $(this).next().slideDown();
        })
        $(".outer_option").click(function () {
            $('[name=planToggle]').prop("checked", false);
            $('.infoToggle').next().slideUp();
        })
        $('.inner_option').click(function () {
            $(this).parent().parent().parent().children('[name="planToggle"]').prop("checked", true);
        })
        //判斷是否固定btn位置
        document.addEventListener('scroll', function () {
            var scrollTop = $(window).height() + $(window).scrollTop();
            if (scrollTop > $(".btn-nofixed").offset().top - 500) {
                $(".btn-nofixed").css('visibility', 'visible');
                $(".btn-fixed").hide();
            } else {
                $(".btn-nofixed").css('visibility', 'hidden');
                $(".btn-fixed").show();
            }
        }, true);
        //檢查是否選擇方案
        $('.order-btn').click(function () {
            btnId = 'erawan_btn_send';
            addItemClickAjax(pageId, btnId);

            let chosenPlan = $('input[name="plan"]:checked').val();

            if (!chosenPlan) {
                showPopup("您尚未選擇方案")
            } else {
                showPopup();
            }
        });
        //檢視訂單
        $('.checkOredr-btn').click(function () {
            btnId = 'erawan_btn_order';
            addItemClickAjax(pageId, btnId);
        });
        //判斷電話是否正確 送出購買結果
        $('.btn_submit').click(function () {
            let cCode = $("#cCode").val();
            let userPhone = $("#userPhone").val();
            let chosenPlan = $('input[name="plan"]:checked').val();
            if (cCode == '' || userPhone == '' || !checkNum(cCode, userPhone)) {
                $('.error_text').removeClass("d-none");
                return;
            }
//                 alert("成功購買" + chosenPlan + "\n您的手機號碼是" + cCode + "" + userPhone);

            location.href = '${basePath}/goPaymentCom.html?cCode=' + cCode + '&userPhone=' + userPhone + '&buyType=' + chosenPlan;
        })

        function showPopup(remark) {
            if (remark) {
                $(".wrap_popup .popup_title").html(remark);
                $('.box_1').addClass('show');
            } else {
                $('.box_2').addClass('show');
            }
            $('.wrap_popup').addClass('show');
        }

        // 彈跳視窗
        // 點擊X後視窗關閉
        $('.popup_cancel').click(function () {
            $('.popup_box').removeClass('show');
            $('.wrap_popup').removeClass('show');
        });
        // 點擊確認後視窗關閉
        $('.btn_cancel').click(function () {
            $('.popup_box').removeClass('show');
            $('.wrap_popup').removeClass('show');
        });

        //檢查電話號碼是否符合格式
        function checkNum(country, msisdn) {
            var mobileReg = /^\d{8,15}$/;
            var phoneReg = /^\d{8,15}$/;

            if (country == '886') {
                mobileReg = /^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$/i;
                phoneReg = /^0\d{2,3}-?\d{7,8}$/i;
            }
            if (!mobileReg.test(msisdn) && !phoneReg.test(msisdn)) {
                return false;
            } else {
                return true;
            }
        }
    }
</script>
<jsp:include page="/WEB-INF/views/Common/common.jsp" flush="true"/>
</body>
</html>