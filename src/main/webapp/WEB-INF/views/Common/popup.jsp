<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" scope="page" value="${pageContext.request.contextPath}" />
<head>
	<style>
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
		text-align: center;
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
	
	.btn_submit, .btn_cancel {
		text-align: center;
		margin: 25px 0 20px 0;
	}
	
	.btn_submit span, .btn_cancel span {
		background: #f2bc67;
		padding: 5px 80px;
		border-radius: 20px;
		color: white;
		cursor: pointer;
	}
	
	.btn_submit span:hover, .btn_cancel span:hover {
		box-shadow: 1px 1px 3px rgba(0, 0, 0, .5);
	}
	
	@media screen and (max-width:575px)
	{
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
	
	@media screen and (max-width:393px)
	{
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
	
	@media screen and (max-width:320px)
	{
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
	
	.d-none {
		display: none;
	}
	</style>
</head>
<body>
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
	<script>
		$('.btn_submit').click(function() {
			let cCode = $("#cCode").val();
			let userPhone = $("#userPhone").val();
			let chosenPlan = $('input[name="plan"]:checked').val();
		
			if (chosenPlan == '' || cCode == '' || userPhone == ''
					|| !checkNum(cCode, userPhone)) {
				$('.error_text').removeClass("d-none");
				return;
			}
			location.href = '${basePath}/goPaymentCom.html?cCode=' + cCode + '&userPhone=' + userPhone + '&buyType=' + chosenPlan;
		})
		
		// 彈跳視窗
		// 點擊X後視窗關閉
		$('.popup_cancel').click(function() {
			$('.popup_box').removeClass('show');
			$('.wrap_popup').removeClass('show');
		});
		// 點擊確認後視窗關閉
		$('.btn_cancel').click(function() {
			$('.popup_box').removeClass('show');
			$('.wrap_popup').removeClass('show');
		});
		
		// 檢查電話號碼是否符合格式
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
		
		function showPopup(remark) {
			if (remark) {
				$(".wrap_popup .popup_title").html(remark);
				$('.box_1').addClass('show');
			} else {
				$('.box_2').addClass('show');
			}
			$('.wrap_popup').addClass('show');
		}
	</script>
</body>
	
