$(document).ready(function() {
  
  // 일반 회원 가입을 클릭
  $('.list-user').on('click', () => changeColor("green"))

  // 기업 회원 가입을 클릭
  $('.list-company').on('click', () => changeColor("orange"))\
  
  

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