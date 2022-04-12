<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>로그인</title>
    <!-- Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <!-- Google Do Hyeon 폰트 -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/css/signIn.css">
  <script defer src="/js/signIn.js"></script>
</head>
<body>
  <div class="sign-in">

    <div class="logo">
      <div class="logo__text">Someone Need You</div>
    </div>

    <div class="input-info">

      <nav>
        <ul>
          <li class="list-user">일반 회원 로그인</li>
          <li class="list-company">기업 회원 로그인</li>
        </ul>
      </nav>


      <div class="user">
        <div class="inner">

          <div class="loginId-user">
            <input type="text" id="loginIdUser" class="form-control" placeholder="아이디를 입력하세요">
          </div>
          <div class="password-user">
            <input type="password" id="passwordUser" class="form-control" placeholder="비밀번호를 입력하세요">
          </div>

          <input id="signIn_user_btn" type="button" class="btn" value="로그인">
          
          <div class="link-sign-up">계정 생성하기&nbsp;&nbsp;<a href="/account/sign_up_view">회원가입</a></div>

        </div>
      </div>

      <div class="company">
        <div class="inner">

          <div class="loginId-company">
            <input type="text" id="loginIdCompany" class="form-control" placeholder="아이디를 입력하세요">
          </div>
          <div class="password-company">
            <input type="password" id="passwordComapny" class="form-control" placeholder="비밀번호를 입력하세요">
          </div>
          <input id="signIn_company_btn" type="button" class="btn" value="로그인">
          
          <div class="link-sign-up">계정 생성하기&nbsp;&nbsp;<a href="/account/sign_up_view">회원가입</a></div>

        </div>
      </div>
    </div>

  </div>
</body>
</html>