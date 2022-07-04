<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" scope="page" value="${pageContext.request.contextPath}"/>

<!-- header -->
<header class="wrap-header">
    <h1 class="logo">
        <figure>
            <a href="https://fate.opoint.com.tw/home">
                <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/logo_M.svg"
                     alt="開運算算"/>
            </a>
        </figure>
    </h1>
    <div class="wrap-right d-flex">
        <figure class="login">
            <a href="https://fate.opoint.com.tw/home/member/member.html">
                <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/icon_logIn.svg"
                     alt="登入"/>
            </a>
        </figure>
        <div class="menu">
            <span class="bar"></span>
        </div>
    </div>
    <div class="wrap-menu-list d-flex">
        <ul class="menu-type-container">
            <li class="menu-type">
                線上占卜
                <ul class="menu-list-container">
                    <li class="menu-list">
                        <a href="https://truly.page.link/9i7u">算算<sup>2</sup> App</a>
                    </li>
                    <li class="menu-list">
                        <a href="https://fate.opoint.com.tw/vipPay/">算算<sup>2</sup> VIP儲值</a>
                    </li>
                </ul>
            </li>
            <li class="menu-type">
                祈福點燈
                <ul class="menu-list-container">
                    <li class="menu-list">
                        <a href="https://fate.opoint.com.tw/fuyuntai/index.html">四面佛點燈</a>
                    </li>
                </ul>
            </li>
            <li class="menu-type">
                大師測算
                <ul class="menu-list-container">
                    <li class="menu-list">
                        <a href="https://fate.opoint.com.tw/marryMe/index.html">命定戀愛指數</a>
                    </li>
                    <li class="menu-list">
                        <a href="https://fate.opoint.com.tw/soul/index.html">我的前世今生</a>
                    </li>
                    <li class="menu-list">
                        <a href="https://fate.opoint.com.tw/lover/index.html">理想情人</a>
                    </li>
                    <li class="menu-list">
                        <a href="https://fate.opoint.com.tw/rice/index.html">米卦占卜</a>
                    </li>
                    <li class="menu-list">
                        <a href="https://fate.opoint.com.tw/rainbow/index.html">彩虹占卜</a>
                    </li>
                    <li class="menu-list">
                        <a href="https://fate.opoint.com.tw/Fortune/">我有大富大貴之命?</a>
                    </li>
                    <li class="menu-list">
                        <a href="https://fate.opoint.com.tw/Marriage">今年是我的桃花年?</a>
                    </li>
                </ul>
            </li>
            <li class="menu-type">
                優惠活動
                <ul class="menu-list-container">
                    <li class="menu-list"><a href="https://fate.opoint.com.tw/home/#plan">優惠方案</a></li>
                    <li class="menu-list"><a href="https://fate.opoint.com.tw/home/#event">活動專區</a></li>
                </ul>
            </li>
        </ul>
        <footer class="wrap-menu-footer">
            <figure class="hr-line">
                <img class="object_fit_cover" src="${basePath}/resources/img/header_footer/icon_line.svg" alt="line"/>
            </figure>
            <div class="wrap-menu-social d-flex">
                <figure class="icon-star">
                    <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/icon_star_S.svg"
                         alt="star"/>
                </figure>
                <span class="social-text">FOLLOWS US</span>
                <a href="https://www.facebook.com/luckycc2020/" target="_blank">
                    <figure class="facebook">
                        <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/icon_fb.svg"
                             alt="facebook"/>
                    </figure>
                </a>
                <a href="https://www.instagram.com/luckycc_2020/" target="_blank">
                    <figure class="instagram">
                        <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/icon_ig.svg"
                             alt="instagram"/>
                    </figure>
                </a>
            </div>
        </footer>
    </div>
</header>