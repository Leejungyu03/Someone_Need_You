$(document).ready(function() {
  
	// 일반 회원 가입을 클릭
	$('.list-user').on('click', () => changeColor("green"))
	
	// 기업 회원 가입을 클릭
	$('.list-company').on('click', () => changeColor("orange"))
	
	
	$('#is_duplicated_user').on('click', () => {
		
		// 경고 문구 초기화
		$('.idCheckDuplicatedUser').addClass('d-none')
		$('.idCheckOkUser').addClass('d-none')
		
		let loginId = $('#loginIdUser').val().trim()
		if (loginId == '') {
			alert("아이디를 입력해주세요")
			return;
		}
		
		$.ajax({
			type : "POST",
			url : "/account/is_duplicated_user",
			data : {"loginId" : loginId},
			success : function(data) {
				if (data.result) {
					$('.idCheckDuplicatedUser').removeClass('d-none')
				} else {
					$('.idCheckOkUser').removeClass('d-none')
				}
			},
			error : function(e) {
				alet("오류입니다. 관리자에게 문의주세요.")
			}
		})
	})
	
	// User 회원 가입
	$('#signUp_user_btn').on('click', () => {
		
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
		
		let name = $('#nameUser').val().trim()
		if (name == '') {
			alert("이름을 입력해주세요")
			return;
		}
		
	    let email = $('#emailUser').val().trim()
		if (email == '') {
			alert("이메일을 입력해주세요")
			return;
		}
		
		if ($('.idCheckOkUser').hasClass('d-none')) {
			alert("아이디 중복확인을 다시 해주세요.");
			return;
		}
		
		let formData = new FormData();
		formData.append("loginId", loginId)
		formData.append("password", password)
		formData.append("name", name)
		formData.append("email", email)
		
		$.ajax({
			type : "POST",
			url : "/account/sign_up_user",
			data : formData,
			enctype : "multipart/form-data",
			processData : false,
			contentType : false,
			success : function(data) {
				if (data.result) {
					alert("회원가입이 완료되었습니다. 로그인 해주세요")
					$('#loginIdUser').val("")
					$('#passwordUser').val("")
					$('#nameUser').val("")
					$('#emailUser').val("")
					location.href = "/account/sign_in_view"
				} else {
					alert("회원가입에 실패하였습니다.")
				}
			},
			error : function(e) {
				alert("오류입니다. 관리자에게 문의하세요")
			}
		})
		
	})
	
	// Company 아이디 중복 확인
	$('#is_duplicated_company').on('click', () => {
		
		// 경고 문구 초기화
		$('.idCheckDuplicatedCompany').addClass('d-none');
		$('.idCheckOkUserCompany').addClass('d-none');
		
		let loginId = $('#loginIdCompany').val().trim()
		if (loginId == '') {
			alert("아이디를 입력해주세요")
			return;
		}
		
		$.ajax({
			type : "POST",
			url : "/account/is_duplicated_company",
			data : {"loginId" : loginId},
			success : function(data) {
				if (data.result) {
					$('.idCheckDuplicatedCompany').removeClass('d-none')
				} else {
					$('.idCheckOkUserCompany').removeClass('d-none')
				}
			},
			error : function(e) {
				alet("오류입니다. 관리자에게 문의주세요.")
			}
		})
	})
	
	// Comapny 회원가입
	$('#signUp_company_btn').on('click', () => {
		
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
		
		let name = $('#nameComapny').val().trim()
		if (name == '') {
			alert("이름을 입력해주세요")
			return;
		}
		
	    let email = $('#emailComapny').val().trim()
		if (email == '') {
			alert("이메일을 입력해주세요")
			return;
		}
		
		if ($('.idCheckOkUserCompany').hasClass('d-none')) {
			alert("아이디 중복확인을 다시 해주세요.");
			return;
		}
		
		let formData = new FormData();
		formData.append("loginId", loginId)
		formData.append("password", password)
		formData.append("name", name)
		formData.append("email", email)
		
		$.ajax({
			type : "POST",
			url : "/account/sign_up_company",
			data : formData,
			enctype : "multipart/form-data",
			processData : false,
			contentType : false,
			success : function(data) {
				if (data.result) {
					alert("회원가입이 완료되었습니다. 로그인 해주세요")
					$('#loginIdCompany').val("")
					$('#passwordComapny').val("")
					$('#nameComapny').val("")
					$('#emailComapny').val("")
					$('.idCheckDuplicatedCompany').addClass('d-none');
					$('.idCheckOkUserCompany').addClass('d-none');
					location.href = "/account/sign_in_view"
				} else {
					alert("회원가입에 실패하였습니다.")
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
    $('.sign-up').css("border", "2px solid #4E9F3D")
  } else if (color == "orange") {
    $('.user').css("display", "none")
    $('.company').css("display", "block")

    $('.list-company').css("background-color", "#FEB139").css("color", "#fff")
    $('.list-user').css("background-color", "#fff").css("color", "#333")
   
    $('.logo__text').css("color", "#FEB139")
    $('.sign-up').css("border", "2px solid #FEB139")
  }
}