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
    <title>開運算算｜四面佛愛神燈－讓愛情守護神照亮你的姻緣路</title>
	<link rel="shortcut icon" href="/fateStorage/fate/logo_S.svg">
	
	<meta name=“description” content=“不用出國也能點燈招桃花!四面佛線上愛神燈給你魅力、姻緣、智慧通通提升!虔誠祈求，無邊保佑!">
	<meta name=“keywords” content=“開運算算,四面佛,線上,點燈,愛神燈,戀愛，脫單 ">
	<link rel="canonical" href="https://fate.opoint.com.tw/fuyuntaiwish/index.html">
	<meta property="og:title" content="開運算算｜四面佛愛神燈－讓愛情守護神照亮你的姻緣路">
	<meta property="og:site_name" content="開運算算｜四面佛愛神燈－讓愛情守護神照亮你的姻緣路">
	<meta property="og:type" content="website">
	<meta property="og:url" content="https://fate.opoint.com.tw/fuyuntailove/index.html">
	<meta property="og:description" content="不用出國也能點燈招桃花!四面佛線上愛神燈給你魅力、姻緣、智慧通通提升!虔誠祈求，無邊保佑! ">

    <!-- CSS LINK -->
   	<link href="${basePath}/resources/css/main.css" rel="stylesheet">
    <link href="${basePath}/resources/css/normalize.css" rel="stylesheet">
	<link rel="stylesheet" href="${basePath}/resources/css/2022/03/normalize.css" />
    <link rel="stylesheet" href="${basePath}/resources/css/2022/03/main.css" />

    <%-- header and footer--%>
    <link href="${basePath}/resources/css/header.css" rel="stylesheet">
    <link href="${basePath}/resources/css/footer.css" rel="stylesheet">
    <link rel="stylesheet" href="${basePath}/resources/js/aos-master/dist/aos.css"/>
    
    <script src="${basePath}/resources/js/jquery-3.4.1.min.js"></script>
	<script src="${basePath}/resources/js/swiper-bundle.js"></script>
	<script src="${basePath}/resources/js/bootstrap.js"></script>
    
    <!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=G-2NHXQXFWYR"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());
	
	  gtag('config', 'G-2NHXQXFWYR');
	</script>
		
    <style>
    
        
    </style>
</head>
<body>
<div class="container-lg clear-padding">

    <%-- header and footer --%>
    <%-- header --%>
    <jsp:include page="/WEB-INF/views/Common/header.jsp" flush="true"/>

	<main class="wrap-phraphrom-love">
		<div class="wrap-btn fixed-btn-golight">
			<p class="btn-primary">幫你結緣，立即點燈</p>
		</div>
		<section class="wrap-kv">
			<figure class="kv-pc">
				<img class="object-fit-cover" src="${basePath}/resources/img/2022/03/kv-pc.png" alt="" />
			</figure>
			<figure class="kv-mobile">
				<img class="object-fit-cover" src="${basePath}/resources/img/2022/03/kv-mobile.png" alt="" />
			</figure>
			<div class="wrap-btn btn-golight">
				<p class="btn-primary">幫你結緣，立即點燈</p>
			</div>
		</section>
		<section class="wrap-section2">
			<figure class="section-title section2-title">
				<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/titile-02.png" alt="" />
			</figure>
			<div class="phraphrom-love-container">
				<figure class="bg-road">
					<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/road.png" alt="" />
				</figure>
				<div class="section2-intro">
					<div class="outline"></div>
					<div class="main">
						<figure class="section2-intro-icon">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/icon-light.png"
								alt="" />
						</figure>
						<p class="section2-intro-text">
							想求好桃花、讓感情⼀路順遂，絕不能少了愛神的守護!還願率⾼、相當靈驗的「愛神」為泰國愛的守護神，能幫你建立桃花好磁場，守護你的桃花姻緣路!
						</p>
					</div>
				</div>
			</div>
		</section>
		<section class="wrap-section3">
			<div class="warp-section3-title">
				<figure class="section-title section3-title">
					<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/titile-03.png" alt="" />
				</figure>
			</div>
			<div class="phraphrom-love-container">
				<figure class="bg-flower">
					<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/flower03.png" alt="" />
				</figure>
				<figure class="bg-shadow">
					<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/god-shadow.png" alt="" />
				</figure>
				<div class="section3-intro">
					<div class="outline"></div>
					<div class="main">
						<figure class="section3-intro-icon">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/up-charm.png" alt="" />
						</figure>
						<p class="section3-intro-text">
							魅⼒提升讓你到哪都是眾人的焦點!自然⽽然地吸引異性與桃花靠近!</p>
						<figure class="section3-intro-step">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/1.png" alt="" />
						</figure>
					</div>
				</div>
				<div class="section3-intro">
					<div class="outline"></div>
					<div class="main">
						<figure class="section3-intro-icon">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/up-love.png" alt="" />
						</figure>
						<p class="section3-intro-text">
							單⾝者迅速招來「好」的姻緣對象，有對象者則能修成正果、幸福美滿!</p>
						<figure class="section3-intro-step">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/2.png" alt="" />
						</figure>
					</div>
				</div>
				<div class="section3-intro">
					<div class="outline"></div>
					<div class="main">
						<figure class="section3-intro-icon">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/up-wisdom.png"
								alt="" />
						</figure>
						<p class="section3-intro-text">
							在愛情裡EQ越高，感情主導權就越⼤，解決一切愛情難題，事事得⼼應⼿!</p>
						<figure class="section3-intro-step">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/3.png" alt="" />
						</figure>
					</div>
				</div>
			</div>
		</section>
		<section class="wrap-section4">
			<figure class="section-title mobile-section4-title">
				<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/title-04.png" alt="" />
			</figure>
			<div class="phraphrom-love-container section4">
				<figure class="card">
					<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/card1.png" alt="" />
				</figure>
				<div class="section4-right">
					<figure class="section-title pc-section4-title">
						<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/title-04.png" alt="" />
					</figure>
					<div class="section4-text">
						點燈後會由無上元老師親⾃自幫您祈福，您可以在查詢訂單查看您的祈福照片，感受四⾯佛的靈氣與莊嚴。</div>
				</div>
			</div>
			<figure class="title-project">
				<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/title-project.png"
					alt="" />
			</figure>
		</section>
		<section class="wrap-section5">
			<div class="wrap-plan-card">
				<div class="outline"></div>
				<figure class="tag">
					<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/tag.png" alt="" />
				</figure>
				<div class="plan-card">
					<figure class="section5-intro-icon">
						<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/icon-light.png"
							alt="" />
					</figure>
					<p class="plan-card-title">愛神燈6個⽉</p>
					<p class="plan-card-price">$990</p>
					<div class="plan-card-orign-price">
						(原價$1,040)
						<figure class="orign-price-line">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/line.png" alt="" />
						</figure>
					</div>
					<div class="wrap-btn">
						<%-- 如使用popup.jsp，input的name='plan'一定要設定 --%>
						<input type="radio" name="plan" value="plan_4-1" id="plan_4-1" class="d-none">
						<label for="plan_4-1">
							<p id="buysix" class="btn-primary">
								立即購買
							</p>
						</label>
					</div>
				</div>
			</div>
			<div class="wrap-plan-card">
				<div class="outline"></div>
				<div class="plan-card">
					<figure class="section5-intro-icon">
						<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/icon-light.png"
							alt="" />
					</figure>
					<p class="plan-card-title">愛神燈3個⽉</p>
					<p class="plan-card-price">$520</p>
					<p class="plan-card-orign-price opacity">(原價$1,040)</p>
					<div class="wrap-btn">
						<%-- 如使用popup.jsp，input的name='plan'一定要設定 --%>
						<input type="radio" name="plan" value="plan_4-2" id="plan_4-2" class="d-none">
						<label for="plan_4-2">
							<p id="buythree" class="btn-primary">立即購買</p>
						</label>
					</div>
				</div>
			</div>
		</section>
		<section class="wrap-section6">
			<div class="wrap-btn">
				<p id="fuyuntailoveorder" class="btn-secondary">查詢訂單</p>
			</div>
			<figure class="title-rec">
				<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/title-rec.png" alt="" />
			</figure>
		</section>
		<section class="wrap-section7">
			<div class="phraphrom-love-container">
				<div class="section7-intro">
					<div class="outline"></div>
					<div class="main">
						<figure class="section7-intro-icon">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/face01.png" alt="" />
						</figure>
						<div class="section7-right">
							<p class="section7-intro-name">林⼩姐：</p>
							<figure class="reccommend-heart">
								<img class="object-fit-contain"
									src="${basePath}/resources/img/2022/03/reccommend-heart.png" alt="" />
							</figure>
							<p class="section7-intro-text">
								我在感情最低潮時，請四⾯佛保佑我的感情順利、告白成功，就在我祈求完成的當晚，願望就實現了!我想拜四⾯佛的祕訣就在「許的願望⼀定要清楚明瞭，誠實⾯對⾃己。」四⾯佛就能給你想要的!
							</p>
						</div>
					</div>
				</div>
				<div class="section7-intro">
					<div class="outline"></div>
					<div class="main">
						<figure class="section7-intro-icon">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/face02.png" alt="" />
						</figure>
						<div class="section7-right">
							<p class="section7-intro-name">黃⼩姐：</p>
							<figure class="reccommend-heart">
								<img class="object-fit-contain"
									src="${basePath}/resources/img/2022/03/reccommend-heart.png" alt="" />
							</figure>
							<p class="section7-intro-text">
								去年跟前男友分⼿，來跟四⾯佛點燈祈求好姻緣，希望祂能幫我斬斷過去找到對的人，過一陣⼦後，真的遇到跟我開的條件⼀模⼀樣的他!在⼀起後也感覺四面佛一直在保佑我們，讓我們感情不斷加溫!
							</p>
						</div>
					</div>
				</div>
				<div class="section7-intro">
					<div class="outline"></div>
					<div class="main">
						<figure class="section7-intro-icon">
							<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/face03.png" alt="" />
						</figure>
						<div class="section7-right">
							<p class="section7-intro-name">鄭先⽣：</p>
							<figure class="reccommend-heart">
								<img class="object-fit-contain"
									src="${basePath}/resources/img/2022/03/reccommend-heart.png" alt="" />
							</figure>
							<p class="section7-intro-text">
								有誠則靈!讓我在最不如意的感情中重拾我最需要的那一伴，抱著最後一絲希望祈求四面佛慈悲，讓她回心轉意並能好好的在一起，⼀個禮拜後我們復合了，⽽且感情也更加穩定!
							</p>
						</div>
					</div>
				</div>
			</div>
			<figure class="title-info">
				<img class="object-fit-contain" src="${basePath}/resources/img/2022/03/title-info.png" alt="" />
			</figure>
			<div class="info-list">
				<div class="list-item">
					<div class="list-title">
						<p>營業時間</p>
					</div>
					<p class="item-content">10:00 ~ 23:00</p>
				</div>
				<div class="list-item">
					<div class="list-title">
						<p>地址</p>
					</div>
					<p class="item-content">台北市中⼭區吉林路175號1樓</p>
				</div>
				<div class="list-item">
					<div class="list-title">
						<p>臉書</p>
					</div>
					<p class="item-content">
						<a style="color: #483429" target="_blank"
							href="https://www.facebook.com/fuyuntaitp/">https://www.facebook.com/fuyuntaitp/</a>
					</p>
				</div>
			</div>
			<div class="wrap-map">
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3614.254222175601!2d121.52817291537913!3d25.05937124342716!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442a95c3c4f6567%3A0x265f955750448474!2z5oSb5L6254Gj5Zub6Z2i5L2b!5e0!3m2!1szh-TW!2stw!4v1646925960807!5m2!1szh-TW!2stw"
					style="border: 0" allowfullscreen="" class="frame-map"
					loading="lazy"></iframe>
			</div>
		</section>
	</main>

	<%-- header and footer --%>
    <!-- footer -->
    <jsp:include page="/WEB-INF/views/Common/footer.jsp" flush="true"/>
</div>
<jsp:include page="/WEB-INF/views/Common/popup.jsp" flush="true"/>

<%--header and footer--%>
<script src="${basePath}/resources/js/Common/header.js"></script>
<script src="${basePath}/resources/js/Common/footer.js"></script>
<script src="${basePath}/resources/js/aos-master/dist/aos.js"></script>

<script>
var fromPageId = '${fromPageId}'.replace(/,/g, '').replace(/%20/g, '');
var channel = '${channel}';
</script>
<script type="text/javascript" src="${basePath}/resources/js/2022/03/main.js"></script>
<jsp:include page="/WEB-INF/views/Common/common.jsp" flush="true"/>

</body>
</html>