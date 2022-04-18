<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>이력서 수정</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <!-- Google Do Hyeon 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
    <!-- Google Material Icons -->
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/css/resume/modify.css">
  <script defer src="/js/resume/modify.js"></script>
</head>
<body>
  <div class="resume-modify">

    <div class="logo">
      <span class="logo__text">Someone Need You</span>
    </div>

    <div class="inner">
      

      <div class="oneLineIntroduction">
        <input type="text" class="form-control" maxlength="30" placeholder="기업에게 나에 대해 알려줍시다">
      </div>
      
      <h2>인적사항</h2>
      <div class="personalData">
        <div class="profile">
          <label for="profileFile">
            <img src="/image/resume/none_profile.png" id="profileImage">
          </label>
          <input type="file" id="profileFile">
        </div>
        <div class="data">
          <div>
            <input type="text" id="name" placeholder="이름" maxlength="5">
            <input type="text" id="birth" placeholder="생년월일 예)2003-11-04">
            <input type="text" id="email" placeholder="이메일">
          </div>
          <div>
            <select id="gender">
              <option value="">남자</option>
              <option value="">여자</option>
            </select>
            <input type="text" id="phoneNumber" placeholder="휴대폰번호" maxlength="13">
            <input type="text" id="residence" placeholder="주소">
          </div>
        </div>

      </div>

      <h2>학력</h2>
      <div class="education">
        <div class="school">
          <select id="school__classification">
            <option value="">고등학교</option>
            <option value="">전문대학교</option>
            <option value="">대학교</option>
            <option value="">대학원</option>
          </select>
          <input type="text" id="school__name" placeholder="학교명">
          <input type="text" id="school__graduation-year" placeholder="졸업년도">
        </div>
        <div class="education__add">
          <span class="material-icons">add_circle_outline</span>
          <div class="addBtn">추가</div>
        </div>
      </div>

      <h2>경력</h2>
      <div class="career">
        <div class="career__company">
          <div class="company-info">
            <input type="text" class="companyName" placeholder="회사명">
            <input type="text" class="startPeriod" placeholder="입사년월">
            <input type="text" class="endPeriod" placeholder="퇴사년월(재직중일시 공란)">
          </div>
          <div class="career__task">
            <textarea id="" class="" cols="140" rows="5" placeholder="담당하신 업무와 성과에 대해 간단명료하게 적어주세요."></textarea>
          </div>
        </div>
        <div class="career__add">
          <span class="material-icons">add_circle_outline</span>
          <div class="addBtn">추가</div>
        </div>
      </div>

      <h2>자격증</h2>
      <div class="license">
        <div class="license__info">
          <input type="text" id="" class="license__name" placeholder="자격증 명">
          <input type="text" id="" class="license__publication" placeholder="발행처">
          <input type="text" id="" class="license__date" placeholder="취득일">
        </div>
        <div class="license__add">
          <span class="material-icons">add_circle_outline</span>
          <div class="addBtn">자격증 추가</div>
        </div>
      </div>

      <h2>포트폴리오</h2>
      <div class="portfolio">
        <input type="text" class="portfolio__url" placeholder="포트폴리오 URL">
        <label class="portfolio__label" for="portfolio__file">
          <div>파일 추가<span class="material-icons">add_circle_outline</span></div>
        </label>
        <input type="file" id="portfolio__file">
      </div>

      <h2>자기소개서</h2>
      <div class="introduce">
        <textarea id="" cols="140" rows="8" class="" placeholder="해당 내용을 입력하세요"></textarea>
      </div>

      <button class="btn">이력서 수정하기</button>

    </div>
  </div>
</body>
</html>