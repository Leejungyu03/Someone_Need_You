<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="header-user">
	<div class="inner">
		<div class="head-user">

			<div class="logo">
				<div class="logo__text">Someone Need You</div>
			</div>

			<div class="search input-group">
				<input type="text" class="form-control">
				<div class="material-icons input-group-text">search</div>
			</div>
			
			<c:choose>
				<c:when test="${(empty userName) && (empty companyName)}">
					<div class="account">
						<div class="account__sign-in">로그인</div>
						<div class="account__sign-up">회원가입</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="account-user">
						<div class="account__userName"><span>${userName}</span>님 환영합니다</div>
						<div class="account__user-logout">로그아웃</div>
					</div>
				</c:otherwise>
			</c:choose>

		</div>

		<nav class="user">
			<ul>
				<li>전체 공고</li>
				<li>나에게 맞는 공고</li>
				<li>회사 목록</li>
				<li>마이페이지</li>
			</ul>
		</nav>

	</div>
</header>

<script>
$(document).ready(function() {
	let selectedList = "${title}";
	// 개인으로 들어왔을때
	if (selectedList == "전체 공고") {
		$('li')[0].style.backgroundColor = '#4E9F3D'
		$('li')[0].style.color = '#F7F7F7'
	} else if (selectedList == "나에게 맞는 공고") {
		$('li')[1].style.backgroundColor = '#4E9F3D'
		$('li')[1].style.color = '#F7F7F7'
	} else if (selectedList == "회사 목록") {
		$('li')[2].style.backgroundColor = '#4E9F3D'
		$('li')[2].style.color = '#F7F7F7'
	} else {
		$('li')[3].style.backgroundColor = '#4E9F3D'
		$('li')[3].style.color = '#F7F7F7'
	}
	
  
	$('.account__sign-in').on('click', () => location.href = "/account/sign_in_view")
	$('.account__sign-up').on('click', () => location.href = "/account/sign_up_view")
	
	$('.account__user-logout').on('click', () => location.href = "/account/sign_out_user")
	
	$('.logo__text').on('click', () => location.href = "/main/notice_view")
	  
	$('li').on('click', (e) => {
		let listText = e.target.innerText;
		if (listText == "전체 공고") {
			location.href = "/main/notice_view"
		} else if (listText == "나에게 맞는 공고") {
		    location.href = "/main/appropriate_view"
		} else if (listText == "회사 목록") {
		    location.href = "/main/company_list_view"
		} else if (listText == "마이페이지") {
			let userName = "${userName}"
			if (userName == "") {
				alert("로그인 후 이용해주세요")
				location.href = "/account/sign_in_view"
			} else {
			    location.href = "/user/mypage_view"
			}
		} else {
		    location.href = "/company/info_view"
		}
	})
})
</script>