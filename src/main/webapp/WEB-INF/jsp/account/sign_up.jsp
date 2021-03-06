<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <!-- Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <!-- Google Do Hyeon 폰트 -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
  <!-- Google Nanum Gothic 폰트 -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/css/account/signUp.css">
  <script type="text/javascript" defer="defer" src="/js/account/signUp.js"></script>
</head>
<body>
  <div class="sign-up">

    <div class="logo">
      <div class="logo__text">Someone Need You</div>
    </div>

    <div class="input-info">

      <nav>
        <ul>
          <li class="list-user">일반 회원 가입</li>
          <li class="list-company">기업 회원 가입</li>
        </ul>
      </nav>


      <div class="user">
        <div class="inner">

          <div class="loginId-user">
            <input type="text" id="loginIdUser" class="form-control" placeholder="아이디를 입력하세요">
            <button id="is_duplicated_user" class="btn">중복확인</button>
          </div>
          <div class="idCheckDuplicatedUser d-none">이미 사용중인 ID입니다.</div>
          <div class="idCheckOkUser d-none">사용 가능한 ID입니다</div>
          <div class="password-user">
            <input type="password" id="passwordUser" class="form-control" placeholder="비밀번호를 입력하세요">
          </div>
          <div class="name-user">
            <input type="text" id="nameUser" class="form-control" placeholder="이름을 입력하세요">
          </div>
          <div class="email-user">
            <input type="text" id="emailUser" class="form-control" placeholder="이메일을 입력하세요">
          </div>

          <input id="signUp_user_btn" type="button" class="btn" value="회원가입">
			
		  <div class="link-sign-in">계정이 있으신가요?&nbsp;&nbsp;<a href="/account/sign_in_view">로그인</a></div>
        
        </div>
      </div>

      <div class="company">
        <div class="inner">

          <div class="loginId-company">
            <input type="text" id="loginIdCompany" class="form-control" placeholder="아이디를 입력하세요">
            <button id="is_duplicated_company" class="btn">중복확인</button>
          </div>
          <div class="idCheckDuplicatedCompany d-none">이미 사용중인 ID입니다.</div>
          <div class="idCheckOkUserCompany d-none">사용 가능한 ID입니다</div>
          <div class="password-company">
            <input type="password" id="passwordComapny" class="form-control" placeholder="비밀번호를 입력하세요">
          </div>
          <div class="name-company">
            <input type="text" id="nameComapny" class="form-control" placeholder="회사명을 입력하세요">
          </div>
          <div class="email-company">
            <input type="text" id="emailComapny" class="form-control" placeholder="회사 이메일을 입력하세요">
          </div>

          <input id="signUp_company_btn" type="button" class="btn" value="회원가입">
          
          <div class="link-sign-in">계정이 있으신가요?&nbsp;&nbsp;<a href="/account/sign_in_view">로그인</a></div>
        
        </div>
      </div>
    </div>

  </div>
</body>
</html>