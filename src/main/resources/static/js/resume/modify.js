$(document).ready(function() {
	
	// resumeId를 구하는 AJAX
	let resumeId;
	$.ajax({
			type : "POST",
			url : "/resume/find_resumeId",
			success : function(data) {
				resumeId = data.resumeId
			},
			error : function() {
				alert("오류입니다. 관리자에게 문의주세요")
			}
		})
	
	
	// 학력 입력 AJAX
	$('.education__add').on('click', () => {
		let classification = $('#school__classification').val()
		let name = $('#school__name').val()
		if (name == "") {
			alert("학교명을 입력해주세요")
			return
		}

		let graduation = $('#school__graduation').val()
		if (graduation == "") {
			alert("졸업(예정)년도를 입력해주세요")
			return
		}		
		
		let formData = new FormData();
		formData.append("resumeId", resumeId)
		formData.append("classification", classification)
		formData.append("name", name)
		formData.append("graduation", graduation)
		$.ajax({
			type : "POST",
			url : "/resume/education_create",
			data : formData,
			enctype : "multipart/form-data",
			processData : false,
			contentType : false,
			success : function(data) {
				if (data.result == "success") {
					location.reload();
				}
			},
			error : function(e) {
				alert("오류입니다. 관리자에게 문의해주세요")
			}
		})
	})
	
	// 학력 삭제 AJAX
	$('.school-list__delete').on('click', function() {
		let resumeEducationId = $(this).data('education-id')
		
		$.ajax({
			type : "DELETE",
			url : "/resume/education_delete",
			data : {"resumeEducationId" : resumeEducationId},
			success : function(data) {
				if (data.result == "success") {
					location.reload()
				}
			},
			error : function(e) {
				alert("오류입니다. 관리자에게 문의해주세요")
			}
		})
	})
	
	// 경력 추가하는 AJAX
	$('.career__add').on('click', () => {
		let companyName = $('#companyName').val().trim()
		if (companyName == "") {
			alert("회사명을 입력해주세요")
			return
		}
		
		let startPeriod = $('#startPeriod').val()
		if (startPeriod == "") {
			alert("입산년월을 입력해주세요")
			return
		}
		
		let endPeriod = $('#endPeriod').val()
		if (endPeriod == "") {
			endPeriod = "재직중"
		}
		
		let task = $('#task').val()
		if (task == "") {
			alert("담당 업무를 입력해주세요")
			return
		}
		
		let formData = new FormData();
		formData.append("resumeId", resumeId)
		formData.append("companyName", companyName)
		formData.append("startPeriod", startPeriod)
		formData.append("endPeriod", endPeriod)
		formData.append("task", task)
		$.ajax({
			type : "POST",
			url : "/resume/career_create",
			data : formData,
			enctype : "multipart/form-data",
			processData : false,
			contentType : false,
			success : function(data) {
				if (data.result == "success") {
					location.reload();
				}
			},
			error : function(e) {
				alert("오류입니다. 관리자에게 문의해주세요")
			}
		})
	})
	
	// 경력 삭제 AJAX
	$('.career-list__delete').on('click', function() {
		let resumeCareerId = $(this).data('career-id')
		
		$.ajax({
			type : "DELETE",
			url : "/resume/career_delete",
			data : {"resumeCareerId" : resumeCareerId},
			success : function(data) {
				if (data.result == "success") {
					location.reload()
				}
			},
			error : function(e) {
				alert("오류입니다. 관리자에게 문의해주세요")
			}
		})
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 프로필 사진 바꾸기
	$('#profileFile').on('change', function() {
		console.dir($(this)[0])
		let profileImage = $(this)[0].files[0]
		profileImage = URL.createObjectURL(profileImage)
		console.log(profileImage)
		$('#profileImage').attr("src", profileImage)
	})
	// 자격증에 datepicker 추가
	$('#license__date').datepicker({
		changeMonth: true
		, changeYear: true
		, dateFormat: "yy년 mm월 dd일"
	});
	
})