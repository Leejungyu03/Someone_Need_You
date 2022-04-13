<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="mypage">
	<div class="inner">
		
		<div class="table">
			<div class="head">
				<div>아이디</div>
				<div>비밀번호</div>
				<div>이메일</div>
				<div>이름</div>
			</div>
			<div class="info">
				<div>
					<input type="text" id="modify-userId" class="form-control" value="${user.loginId}">
				</div>
				<div>
					<input type="password" id="modify-password" class="form-control" placeholder="새 비밀번호를 입력하세요">
				</div>
				<div>
					<input type="text" id="modify-email" class="form-control" value="${user.email}">
				</div>
				<div>
					<input type="text" id="modify-name" class="form-control" value="${user.name}">
				</div>
			</div>
			<button class="mypageModifyBtn btn">수정하기</button>

			<button class="deleteUserBtn btn">탈퇴하기</button>

		</div>


		<div class="resume">
			<div class="profile">
				<div class="profile__image">
					<img src="/image/user/none_profile.png" alt="">
				</div>
			</div>
			<div class="oneLineIntroduction">
				<div class="oneLineIntroduction__text">
					안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요
				</div>
			</div>
			<div class="applyCompanyList">
				<div class="applyCompanyList__text">내가 지원한 채용 공고</div>
				<button class="applyCompanyListBtn btn">확인하기</button>
			</div>
			<div class="modifyResume">
				<div class="modifyResume__text">내 이력서 수정</div>
				<button class="modifyResumeBtn btn">수정하러가기</button>
			</div>
			<div class="viewResume">
				<div class="viewResume__text">기업 담당자가 보는 내 이력서</div>
				<button class="viewResumeBtn btn">미리보기</button>
			</div>
		</div>

	</div>
</section>

<script>
$(document).ready(function() {
	  
	// 수정하기
	$('.mypageModifyBtn').on('click', () => {
		let modifyCheck = confirm("변경내용을 수정하시겠습니까?")
	  	if (modifyCheck == false) {
	    	return
	  	}
		
		let modifyUserId = $('#modify-userId').val().trim();
		if (modifyUserId == "") {
			alert("변경할 아이디를 입력해주세요")
			return
		}
		let modifyPassword = $('#modify-password').val()
		if (modifyPassword == "") {
			let checkModifyPassword = confirm("비밀번호를 수정하지 않겠습니까?")
			if (checkModifyPassword == false) {
				return
			}
		}
		let modifyEmail = $('#modify-email').val().trim();
		if (modifyEmail == "") {
			alert("변경할 이메일 입력해주세요")
			return
		}
		let modifyName = $('#modify-name').val().trim();
		if (modifyName == "") {
			alert("변경할 이름을 입력해주세요")
			return
		}
		
		
		let formData = new FormData();
		formData.append("modifyUserId", modifyUserId)
		formData.append("modifyPassword", modifyPassword)
		formData.append("modifyEmail", modifyEmail)
		formData.append("modifyName", modifyName)
		
	  	$.ajax({
			type : "PUT",
			url : "/user/mypage_modify",
			data : formData,
			enctype : "multipart/form-data",
			processData : false,
			contentType : false,
			success : function(data) {
				if (data.result == "success") {
					alert("수정하였습니다.")
					location.reload()
				} else {
					alert(data.error_message)
				}
			},
	  		error : function(e) {
				alert("에러, 관리자에게 문의해주세요")	
	  		}
	  	})
	})

	// 탈퇴하기
	$('.deleteUserBtn').on('click', () => {
		let deleteCheck = confirm("회원탈퇴하시겠습니까?")
		if (deleteCheck == false) {
	    	return;
	  	} 

		$.ajax({
		  	type : "DELETE",
		  	url : "/user/mypage_delete",
			success : function(data) {
				if (data.result == "success") {
					alert("회원 탈퇴에 성공하였습니다.")
					location.href = "/main/notice_view"
				} else {
					alert("error_message")
				}
			},
			error : function(e) {
				alert("에러, 관리자에게 문의하세요")
			}
	  })
	})

	// 내가 지원한 채용공고 확인하기
	$('.applyCompanyListBtn').on('click', () => {
	  location.href = "/resume/apply_list_view"
	})

	// 이력서 수정하러 가기
	$('.modifyResumeBtn').on('click', () => {
	  location.href = "/resume/modify_view"
	})

	// 이력서 미리보기
	$('.viewResumeBtn').on('click', () => {
	  location.href = "/resume/info_view"
	})
});
</script>