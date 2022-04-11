$(document).ready(function() {
  
	// 일반 회원 가입을 클릭
	$('.list-user').on('click', () => changeColor("green"))
	
	// 기업 회원 가입을 클릭
	$('.list-company').on('click', () => changeColor("orange"))
	
	// User 회원 가입
	$('#signIn_user_btn').on('click', () => {
		
		let loginId = $('#loginIdUser').val().trim()
		if (loginId == '') {
			alert("아이디를 입력해주세요")
			return;
		}
		
		let password = $('#passwordUser').val()
		if (password == '') {
			alert("비밀번호를 입력해주세요")
			return;
		}
		
		let formData = new FormData();
		formData.append("loginId", loginId)
		formData.append("password", password)
		
		$.ajax({
			type : "POST",
			url : "/account/sign_in_user",
			data : formData,
			enctype : "multipart/form-data",
			processData : false,
			contentType : false,
			success : function(data) {
				if (data.result) {
					alert(data.userName + "님 환영합니다.")
					$('#loginIdUser').val("")
					$('#passwordUser').val("")
					location.href = "/main/notice_view"
				} else {
					alert(data.error_message)
        }
			},
			error : function(e) {
				alert("오류입니다. 관리자에게 문의하세요")
			}
		})
		
	})

	
	// Comapny 회원가입
	$('#signIn_company_btn').on('click', () => {
		
		let loginId = $('#loginIdCompany').val().trim()
		if (loginId == '') {
			alert("아이디를 입력해주세요")
			return;
		}
		
		let password = $('#passwordComapny').val()
		if (password == '') {
			alert("비밀번호를 입력해주세요")
			return;
		}
		
		let formData = new FormData();
		formData.append("loginId", loginId)
		formData.append("password", password)
		
		$.ajax({
			type : "POST",
			url : "/account/sign_in_company",
			data : formData,
			enctype : "multipart/form-data",
			processData : false,
			contentType : false,
			success : function(data) {
				if (data.result) {
					alert(data.companyName + "님 환영합니다.")
					$('#loginIdCompany').val("")
					$('#passwordComapny').val("")
					location.href = "/main/notice_view"
				} else {
					alert(error_message)
				}
			},
			error : function(e) {
				alert("오류입니다. 관리자에게 문의하세요")
			}
		})
		
	})

})

function changeColor (color) {
  if (color == "green") {
    $('.company').css("display", "none")
    $('.user').css("display", "block")

    $('.list-user').css("background-color", "#4E9F3D").css("color", "#fff")
    $('.list-company').css("background-color", "#fff").css("color", "#333")
    
    $('.logo__text').css("color", "#4E9F3D")
    $('.sign-in').css("border", "2px solid #4E9F3D")
  } else if (color == "orange") {
    $('.user').css("display", "none")
    $('.company').css("display", "block")

    $('.list-company').css("background-color", "#FEB139").css("color", "#fff")
    $('.list-user').css("background-color", "#fff").css("color", "#333")
   
    $('.logo__text').css("color", "#FEB139")
    $('.sign-in').css("border", "2px solid #FEB139")
  }
}