<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

			<div class="account">
				<div class="account__sign-in">로그인</div>
				<div class="account__sign-up">회원가입</div>
			</div>

		</div>

		<nav>
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
	
	$('li').css('background-color', 'F7F7F7');
	
	if (selectedList == "전체 공고") {
		$('li')[0].style.backgroundColor = '#4E9F3D'
		$('li')[0].style.color = '#F7F7F7'
	} else if (selectedList == "나에게 맞는 공고") {
		$('li')[1].style.backgroundColor = '#4E9F3D'
		$('li')[1].style.color = '#F7F7F7'
	} else if (selectedList == "회사 목록") {
		$('li')[2].style.backgroundColor = '#4E9F3D'
		$('li')[2].style.color = '#F7F7F7'
	} else if (selectedList == "마이페이지") {
		$('li')[3].style.backgroundColor = '#4E9F3D'
		$('li')[3].style.color = '#F7F7F7'
	} else {
		$('li')[4].style.backgroundColor = '#4E9F3D'
		$('li')[4].style.color = '#F7F7F7'
	}
  
	$('.account__sign-in').on('click', () => location.href = "/account/sign_in_view")
	$('.account__sign-up').on('click', () => location.href = "/account/sign_up_view")
	
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