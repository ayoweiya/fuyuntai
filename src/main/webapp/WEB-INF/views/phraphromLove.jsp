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
	<title>四面佛愛神燈－讓愛情守護神照亮你的姻緣路｜開運算算x福運泰</title>
	<meta name="title" content="開運算算｜相信的力量，一同體驗泰國愛侶灣四面佛的神威與靈驗">
	<meta name="description"
		  content="不用出國也能點到泰國最知名的四面佛愛神燈! 讓你魅力、姻緣、智慧通通提升!虔誠祈求，桃花來不完!">
	<meta name="keywords" content="開運算算,四面佛,線上點燈,愛神燈,戀愛,脫單,愛情運,">
	<link rel="canonical" href="https://fate.opoint.com.tw/fuyuntai/phraphromlove/">

	<meta property="og:title" content="四面佛愛神燈－讓愛情守護神照亮你的姻緣路｜開運算算x福運泰">
	<meta property="og:site_name" content="四面佛愛神燈－讓愛情守護神照亮你的姻緣路｜開運算算x福運泰">
	<meta property="og:type" content="website">
	<meta property="og:url" content="https://fate.opoint.com.tw/fuyuntai/phraphromlove/">
	<meta property="og:image" content="https://dlcdnimgs.asus.com/20160129_cosmo/cosmo/${basePath}/resources/images/asus_logo.jpg">
	<meta property="og:description" content="不用出國也能點到泰國最知名的四面佛愛神燈! 讓你魅力、姻緣、智慧通通提升!虔誠祈求，桃花來不完!">

	<!-- CSS LINK -->
	<link rel="stylesheet" href="${basePath}/resources/css/normalize.css" />
	<link rel="stylesheet" href="${basePath}/resources/css/main.css" />
	<link rel="stylesheet" href="${basePath}/resources/css/header.css" />
	<link rel="stylesheet" href="${basePath}/resources/css/footer.css" />
	<link rel="stylesheet" href="${basePath}/resources/css/aos.css" />
	<link rel="stylesheet" href="${basePath}/resources/css/swiper-bundle.min.css" />
	<link rel="stylesheet" href="${basePath}/resources/css/swiper.css" />
	<!-- JS -->
	<script src="${basePath}/resources/js/jquery-3.6.0.min.js"></script>
	<script src="${basePath}/resources/js/bootstrap.js"></script>
</head>

<body>
<header class="header">
	<header class="wrap-header">
		<h1 class="logo">
			<figure>
				<a href="https://fate.opoint.com.tw/home">
					<img
							class="object_fit_contain"
							src="${basePath}/resources/images/logo_M.svg"
							alt="開運算算"
					/>
				</a>
			</figure>
		</h1>
		<div class="wrap-right">
			<figure class="login">
				<a href="https://fate.opoint.com.tw/home/member/member.html">
					<img
							class="object_fit_contain"
							src="${basePath}/resources/images/icon_logIn.svg"
							alt="登入"
					/>
				</a>
			</figure>
			<div class="menu">
				<span class="bar"></span>
			</div>
		</div>
		<div class="wrap-menu-list">
			<ul class="menu-type-container">
				<li class="menu-type">
					線上占卜
					<ul class="menu-list-container">
						<li class="menu-list">
							<a href="https://truly.page.link/9i7u"
							>算算<sup>2</sup> App</a
							>
						</li>
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/vipPay/"
							>算算<sup>2</sup> VIP儲值</a
							>
						</li>
					</ul>
				</li>
				<li class="menu-type">
					祈福點燈
					<ul class="menu-list-container">
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/erawan/index.html"
							>四面佛點燈</a
							>
						</li>
					</ul>
				</li>
				<li class="menu-type">
					大師測算
					<ul class="menu-list-container">
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/marryMe/index.html"
							>命定戀愛指數</a
							>
						</li>
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/soul/index.html"
							>我的前世今生</a
							>
						</li>
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/lover/index.html"
							>理想情人</a
							>
						</li>
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/rice/index.html"
							>米卦占卜</a
							>
						</li>
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/rainbow/index.html"
							>彩虹占卜</a
							>
						</li>
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/Fortune/"
							>我有大富大貴之命?</a
							>
						</li>
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/Marriage"
							>今年是我的桃花年?</a
							>
						</li>
					</ul>
				</li>
				<li class="menu-type">
					優惠活動
					<ul class="menu-list-container">
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/home/#plan">優惠方案</a>
						</li>
						<li class="menu-list">
							<a href="https://fate.opoint.com.tw/home/#event">活動專區</a>
						</li>
					</ul>
				</li>
			</ul>
			<footer class="wrap-menu-footer">
				<figure class="hr-line">
					<img
							class="object_fit_cover"
							src="${basePath}/resources/images/icon_line.svg"
							alt="line"
					/>
				</figure>
				<div class="wrap-menu-social">
					<figure class="icon-star">
						<img
								class="object_fit_contain"
								src="${basePath}/resources/images/icon_star_S.svg"
								alt="star"
						/>
					</figure>
					<span class="social-text">FOLLOWS US</span>
					<a href="https://www.facebook.com/luckycc2020/" target="_blank">
						<figure class="facebook">
							<img
									class="object_fit_contain"
									src="${basePath}/resources/images/icon_fb.svg"
									alt="facebook"
							/>
						</figure>
					</a>
					<a href="https://www.instagram.com/luckycc_2020/" target="_blank">
						<figure class="instagram">
							<img
									class="object_fit_contain"
									src="${basePath}/resources/images/icon_ig.svg"
									alt="instagram"
							/>
						</figure>
					</a>
				</div>
			</footer>
		</div>
	</header>
</header>
<main class="wrap-phraphrom-love">
	<div class="wrap-btn fixed-btn-golight">
		<p class="btn-primary">幫你結緣，立即點燈</p>
	</div>
	<section class="wrap-kv">
		<figure class="kv-pc">
			<img class="object-fit-cover" src="${basePath}/resources/images/kv-pc.png" alt="" />
		</figure>
		<figure class="kv-mobile">
			<img class="object-fit-cover" src="${basePath}/resources/images/kv-mobile.png" alt="" />
		</figure>
		<figure class="bracelet">
			<img class="object-fit-contain" src="${basePath}/resources/images/bracelet.png" alt="" />
		</figure>
		<figure class="teacher">
			<img class="object-fit-contain" src="${basePath}/resources/images/teacher.png" alt="" />
		</figure>
		<div class="wrap-btn btn-golight">
			<p class="btn-primary">幫你結緣，立即點燈</p>
		</div>
	</section>
	<section class="wrap-section2">
		<figure class="section-title section2-title">
			<img class="object-fit-contain" src="${basePath}/resources/images/titile-02.png" alt="" />
		</figure>
		<div class="phraphrom-love-container wrap-circle-card">
			<div class="circle-card">
				<figure class="card-img">
					<img
							class="object-fit-contain"
							src="${basePath}/resources/images/icon-pray.png"
							alt=""
					/>
				</figure>
				<p class="card-title">還願率高!</p>
			</div>
			<div class="circle-card">
				<figure class="card-img">
					<img
							class="object-fit-contain"
							src="${basePath}/resources/images/icon-proof.png"
							alt=""
					/>
				</figure>
				<p class="card-title">靈驗見證!</p>
			</div>
			<div class="circle-card">
				<figure class="card-img">
					<img
							class="object-fit-contain"
							src="${basePath}/resources/images/icon-charming.png"
							alt=""
					/>
				</figure>
				<p class="card-title">桃花磁場!</p>
			</div>
		</div>
	</section>
	<section class="wrap-section3">
		<div class="warp-section3-title">
			<figure class="section-title section3-title">
				<img class="object-fit-contain" src="${basePath}/resources/images/titile-03.png" alt="" />
			</figure>
		</div>
		<div class="phraphrom-love-container wrap-circle-card">
			<div class="circle-card">
				<figure class="card-img">
					<img
							class="object-fit-contain"
							src="${basePath}/resources/images/icon-flower.png"
							alt=""
					/>
				</figure>
				<p class="card-title">魅力UP!</p>
				<p class="card-text">吸引異性與桃花靠近</p>
			</div>
			<div class="circle-card">
				<figure class="card-img">
					<img
							class="object-fit-contain"
							src="${basePath}/resources/images/icon-loveup.png"
							alt=""
					/>
				</figure>
				<p class="card-title">姻緣UP!</p>
				<p class="card-text">單身者迅速招來好姻緣</p>
			</div>
			<div class="circle-card">
				<figure class="card-img">
					<img
							class="object-fit-contain"
							src="${basePath}/resources/images/icon-wisdomup.png"
							alt=""
					/>
				</figure>
				<p class="card-title">智慧UP!</p>
				<p class="card-text">解決一切愛情難題</p>
			</div>
		</div>
	</section>
	<section class="wrap-section4">
		<div class="warp-section4-title">
			<figure class="section-title section4-title">
				<img
						class="object-fit-contain"
						src="${basePath}/resources/images/title-04-1.png"
						alt=""
				/>
			</figure>
		</div>
		<div class="youtube">
			<div class="swiper mySwiper">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<iframe
								src="https://www.youtube.com/embed/Uy0T0-LXx6M"
								title="YouTube video player"
								frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen
								class="video"
						></iframe>
					</div>
					<div class="swiper-slide">
						<iframe
								src="https://www.youtube.com/embed/esS-kklwEco"
								title="YouTube video player"
								frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen
								class="video"
						></iframe>
					</div>
					<div class="swiper-slide">
						<iframe
								src="https://youtube.com/embed/NW1-wBt0bnU?feature=share"
								title="YouTube video player"
								frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen
								class="video"
						></iframe>
					</div>
					<div class="swiper-slide">
						<iframe
								src="https://youtube.com/embed/34BdT2a7xEw"
								title="YouTube video player"
								frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen
								class="video"
						></iframe>
					</div>
				</div>
				<div class="swiper-button-next"></div>
				<div class="swiper-button-prev"></div>
			</div>
		</div>
		<figure class="section-title mobile-sub-section4-title">
			<img class="object-fit-contain" src="${basePath}/resources/images/title-04-2.png" alt="" />
		</figure>
		<div class="phraphrom-love-container section4">
			<figure class="card">
				<img class="object-fit-contain" src="${basePath}/resources/images/card.png" alt="" />
			</figure>
			<div class="section4-right">
				<figure class="section-title pc-section4-title">
					<img
							class="object-fit-contain"
							src="${basePath}/resources/images/title-04-2.png"
							alt=""
					/>
				</figure>
				<div class="section4-text">
					由專人祈福過的桃花開運手鍊，讓您的愛情獲得全方面的保佑!
				</div>
			</div>
		</div>
		<div class="phraphrom-love-container section4"></div>
		<div class="wrap-title-project">
			<figure class="title-project">
				<img
						class="object-fit-contain"
						src="${basePath}/resources/images/title-project.png"
						alt=""
				/>
			</figure>
		</div>
	</section>
	<section class="wrap-section5">
		<div class="warp-project-light-detail">
			<figure class="section-title project-light-detail">
				<img
						class="object-fit-contain"
						src="${basePath}/resources/images/project-light-detail.png"
						alt=""
				/>
			</figure>
		</div>
		<div class="wrap-plan-card">
			<div class="outline"></div>
			<figure class="tag">
				<img class="object-fit-contain" src="${basePath}/resources/images/tag.png" alt="" />
			</figure>
			<div class="plan-card">
				<figure class="section5-intro-icon">
					<img
							class="object-fit-contain"
							src="${basePath}/resources/images/icon-light.png"
							alt=""
					/>
				</figure>
				<p class="plan-card-title">愛神燈12個⽉</p>
				<p class="plan-card-price">$1,000</p>
				<div class="wrap-btn">
					<%-- 如使用popup.jsp，input的name='plan'一定要設定 --%>
					<input type="radio" name="plan" value="plan_1" id="plan_1" class="d-none">
					<label for="plan_1">
						<p id="buyyear" class="btn-primary">立即購買</p>
					</label>
				</div>
			</div>
		</div>
	</section>
	<section class="wrap-section6">
		<div class="wrap-btn">
			<p id="fuyuntaiorder" class="btn-secondary">查詢訂單</p>
		</div>
		<figure class="title-rec">
			<img class="object-fit-contain" src="${basePath}/resources/images/title-rec.png" alt="" />
		</figure>
	</section>
	<section class="wrap-section7">
		<div class="phraphrom-love-container">
			<div class="section7-intro">
				<div class="outline"></div>
				<div class="main">
					<figure class="section7-intro-icon">
						<img
								class="object-fit-contain"
								src="${basePath}/resources/images/face01.png"
								alt=""
						/>
					</figure>
					<div class="section7-right">
						<p class="section7-intro-name">陳⼩姐：</p>
						<figure class="reccommend-heart">
							<img
									class="object-fit-contain"
									src="${basePath}/resources/images/reccommend-heart.png"
									alt=""
							/>
						</figure>
						<p class="section7-intro-text">
							我在感情上的運勢一直都不是那麼順，後來聽朋友的推薦來到板橋的福運泰佛堂進行四面佛參拜及愛神點燈，神奇的是過了一星期後，因緣際會認識了一個不錯的異性，現在感情持續升溫中，感謝四面佛的保佑!
						</p>
					</div>
				</div>
			</div>
			<div class="section7-intro">
				<div class="outline"></div>
				<div class="main">
					<figure class="section7-intro-icon">
						<img
								class="object-fit-contain"
								src="${basePath}/resources/images/face02.png"
								alt=""
						/>
					</figure>
					<div class="section7-right">
						<p class="section7-intro-name">謝⼩姐：</p>
						<figure class="reccommend-heart">
							<img
									class="object-fit-contain"
									src="${basePath}/resources/images/reccommend-heart.png"
									alt=""
							/>
						</figure>
						<p class="section7-intro-text">
							最近跟男友在感情上常常有一些不愉快和小摩擦，來跟四面佛點燈祈求保佑我們的感情能夠更穩固，就在我祈求完成的當晚，男友很難得的跑來找聊開了許多心裡話，看來四面佛真的是有誠則靈!
						</p>
					</div>
				</div>
			</div>
			<div class="section7-intro">
				<div class="outline"></div>
				<div class="main">
					<figure class="section7-intro-icon">
						<img
								class="object-fit-contain"
								src="${basePath}/resources/images/face03.png"
								alt=""
						/>
					</figure>
					<div class="section7-right">
						<p class="section7-intro-name">王先⽣：</p>
						<figure class="reccommend-heart">
							<img
									class="object-fit-contain"
									src="${basePath}/resources/images/reccommend-heart.png"
									alt=""
							/>
						</figure>
						<p class="section7-intro-text">
							去年跟交往多年的女友因為價值觀問題而分手，低沉了好一陣子，抱持著試試看的心情來跟四面佛祈求心願，在今年就遇到了十分契合的另一半，也即將走入婚姻，感覺冥冥中被四面佛守護著!
						</p>
					</div>
				</div>
			</div>
		</div>
		<figure class="title-info">
			<img class="object-fit-contain" src="${basePath}/resources/images/title-info.png" alt="" />
		</figure>
		<div class="info-list">
			<div class="list-item">
				<div class="list-title">
					<p>營業時間</p>
				</div>
				<p class="item-content">12:00 - 22:00</p>
			</div>
			<div class="list-item">
				<div class="list-title">
					<p>地址</p>
				</div>
				<p class="item-content">新北市板橋區文化路二段497-1號</p>
			</div>
			<div class="list-item">
				<div class="list-title">
					<p>臉書</p>
				</div>
				<p class="item-content">
					<a
							style="color: #483429"
							target="_blank"
							href="https://www.facebook.com/fuyuntai1688/"
					>https://www.facebook.com/fuyuntai1688/</a
					>
				</p>
			</div>
		</div>
		<div class="wrap-map">
			<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3912.832595837506!2d121.47269210932417!3d25.03272218746957!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442a9a431087685%3A0xb2b0253a93180a8c!2z5p2_5qmLIOemj-mBi-azsOS9m-WggiAo5Zub6Z2i5L2bKQ!5e0!3m2!1szh-TW!2stw!4v1654244771310!5m2!1szh-TW!2stw"
					style="border: 0"
					allowfullscreen=""
					loading="lazy"
					class="frame-map"
			></iframe>
		</div>
	</section>
	<footer class="wrap-footer">
		<div class="container">
			<div class="footer-left">
				<figure class="footer-logo">
					<img
							class="object_fit_contain"
							src="${basePath}/resources/images/logo_w_M.svg"
							alt="開運算算"
					/>
				</figure>
				<div class="wrap-social">
					<a href="https://www.facebook.com/luckycc2020/" target="_blank">
						<figure class="facebook">
							<img
									class="object_fit_contain"
									src="${basePath}/resources/images/icon_fb_w.svg"
									alt="Facebook"
							/>
						</figure>
					</a>
					<a href="https://www.instagram.com/luckycc_2020/" target="_blank">
						<figure class="instagram">
							<img
									class="object_fit_contain"
									src="${basePath}/resources/images/icon_ig_w.svg"
									alt="Instagram"
							/>
						</figure>
					</a>
					<a href="https://lin.ee/ajXeu3I" target="_blank">
						<figure class="line">
							<img
									class="object_fit_contain"
									src="${basePath}/resources/images/icon_line_w.svg"
									alt="Line"
							/>
						</figure>
					</a>
					<a
							href="https://fate.opoint.com.tw/home/serviceIntro.html"
							target="_blank"
					>
						<figure class="service">
							<img
									class="object_fit_contain"
									src="${basePath}/resources/images/icon_service_w.svg"
									alt="服務條款"
							/>
						</figure>
					</a>
				</div>
			</div>
			<div class="footer-right">
				<h4 class="footer-title">SERVICE</h4>
				<div class="footer-connect">
					<a
							class="email"
							href="mailto:opftservice@gmail.com?subject=%E9%96%8B%E9%81%8B%E7%AE%97%E7%AE%97%E6%9C%8D%E5%8B%99%E5%95%8F%E9%A1%8C&amp;body=%20[%E8%AB%8B%E6%8F%90%E4%BE%9B%E6%82%A8%E7%9A%84%E6%89%8B%E6%A9%9F%E8%99%9F%E7%A2%BC]%EF%BC%8C[%E8%AB%8B%E6%8F%90%E4%BE%9B%E6%82%A8%E7%9A%84%E6%9A%B1%E7%A8%B1]%EF%BC%8C[%E7%99%BC%E7%94%9F%E6%99%82%E9%96%93%E5%8F%8A%E5%95%8F%E9%A1%8C%E6%8F%8F%E8%BF%B0]"
					>opftservice@gmail.com</a
					>
					<p></p>
					<p class="week">Mon.－Fri.</p>
					<p class="time">09:30－12:00／ 14:00－18:00</p>
				</div>
			</div>
		</div>
		<div class="footer-line"></div>
		<p class="copyright">© 開運算算 All Right Reserved.</p>
		<p class="back-top make-arrow">
			<span class="icon-line"></span><span class="icon-arrow"></span>
		</p>
	</footer>
	<jsp:include page="/WEB-INF/views/Common/popup.jsp" flush="true"/>
</main>
<!-- script -->
<script src="${basePath}/resources/js/main.js"></script>
<script src="${basePath}/resources/js/swiper-bundle.js"></script>
<script src="${basePath}/resources/js/swiper-bundle.min.js"></script>

<script src="${basePath}/resources/js/header.js"></script>
<script src="${basePath}/resources/js/footer.js"></script>
<script src="${basePath}/resources/js/aos.js"></script>

<script>
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag("js", new Date());

	gtag("config", "G-PBVMMVL5TC");
</script>
<script>
	var fromPageId = "".replace(/,/g, "").replace(/%20/g, "");
	var channel = '${channel}';
</script>
<script>
	console.log("ok");
	var swiper = new Swiper(".mySwiper", {
		slidesPerView: 1.3,
		spaceBetween: 0,
		centeredSlides: true,
		mousewheel: true,
		loop: true,
		navigation: {
			nextEl: ".swiper-button-next",
			prevEl: ".swiper-button-prev",
		},
		breakpoints: {
			720: {
				slidesPerView: 2,
				spaceBetween: 30,
			},
			1024: {
				slidesPerView: 2,
				spaceBetween: 70,
			},
		},
		centeredSlides: true,
	});
</script>
<jsp:include page="/WEB-INF/views/Common/common.jsp" flush="true"/>
</body>
</html>