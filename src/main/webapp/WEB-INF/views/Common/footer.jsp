<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" scope="page" value="${pageContext.request.contextPath}" />

<!-- footer -->
<footer class="wrap-footer">
    <div class="container d-flex">
        <div class="footer-left">
            <figure class="footer-logo">
                <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/logo_w_M.svg" alt="開運算算" />
            </figure>
            <div class="wrap-social d-flex">
                <a href="https://www.facebook.com/luckycc2020/" target="_blank">
                    <figure class="facebook">
                        <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/icon_fb_w.svg" alt="Facebook" /></figure>
                </a>
                <a href="https://www.instagram.com/luckycc_2020/" target="_blank">
                    <figure class="instagram">
                        <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/icon_ig_w.svg" alt="Instagram" /></figure>
                </a>
                <a href="https://lin.ee/ajXeu3I" target="_blank">
                    <figure class="line">
                        <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/icon_line_w.svg" alt="Line" /></figure>
                </a>
                <a href="https://fate.opoint.com.tw/home/serviceIntro.html" target="_blank">
                    <figure class="service">
                        <img class="object_fit_contain" src="${basePath}/resources/img/header_footer/icon_service_w.svg" alt="服務條款" /></figure>
                </a>
            </div>
        </div>
        <div class="footer-right">
            <h4 class="footer-title">SERVICE</h4>
            <div class="footer-connect">
                <a class="email"
                   href="mailto:opftservice@gmail.com?subject=開運算算服務問題&body= [請提供您的手機號碼]，[請提供您的暱稱]，[發生時間及問題描述]">opftservice@gmail.com</a>
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