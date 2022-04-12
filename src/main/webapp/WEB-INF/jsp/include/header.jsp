<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<div class="inner">
		<div class="head">

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
				<c:when test="${(not empty userName)}">
					<div class="account-user">
						<div class="account__userName"><span>${userName}</span>님 환영합니다</div>
						<div class="account__user-logout">로그아웃</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="account-company">
						<div class="account__companyName"><span>${companyName}</span>님 환영합니다</div>
						<div class="account__company-logout">로그아웃</div>
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
		<nav class="company d-none">
			<ul>
				<li>전체 공고</li>
				<li>나에게 맞는 공고</li>
				<li>회사 목록</li>
				<li>기업 정보 관리</li>
			</ul>
		</nav>


	</div>
</header>

<script>
$(document).ready(function() {
	let selectedList = "${title}";
	
	if (${(not empty userName)}) {
		$('header').css("border-bottom", "1.5px solid #4E9F3D")
		$('.logo__text').css("color", "#4E9F3D")
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
	} else {
		$('header').css("border-bottom", "1.5px solid #FEB139")
		$('.logo__text').css("color", "#FEB139")
		if (selectedList == "전체 공고") {
			$('li')[0].style.backgroundColor = '#FEB139'
			$('li')[0].style.color = '#F7F7F7'
		} else if (selectedList == "나에게 맞는 공고") {
			$('li')[1].style.backgroundColor = '#FEB139'
			$('li')[1].style.color = '#F7F7F7'
		} else if (selectedList == "회사 목록") {
			$('li')[2].style.backgroundColor = '#FEB139'
			$('li')[2].style.color = '#F7F7F7'
		} else {
			$('li')[3].style.backgroundColor = '#FEB139'
			$('li')[3].style.color = '#F7F7F7'
		}
	}
	
  
	$('.account__sign-in').on('click', () => location.href = "/account/sign_in_view")
	$('.account__sign-up').on('click', () => location.href = "/account/sign_up_view")
	
	$('.account__user-logout').on('click', () => location.href = "/account/sign_out_user")
	$('.account__company-logout').on('click', () => location.href = "/account/sign_out_company")
	
	$('.logo__text').on('click', () => location.href = "/main/notice_view")
	  
	$('li').on('click', (e) => {
		for (let i = 0; i < 4; i++) {
			e.target.parentElement.children[i].style.backgroundColor = "#F7F7F7"
		    e.target.parentElement.children[i].style.color = "black"
		}
		e.target.style.backgroundColor = "#4E9F3D"
		e.target.style.color = "#F7F7F7"
		let listText = e.target.innerText;
		if (listText == "전체 공고") {
			location.href = "/main/notice_view"
		} else if (listText == "나에게 맞는 공고") {
		    location.href = "/main/appropriate_view"
		} else if (listText == "회사 목록") {
		    location.href = "/main/company_list_view"
		} else if (listText == "마이페이지") {
		    location.href = "/user/mypage_view"
		} else {
		    location.href = "/company/info_view"
		}
	})
})
</script>