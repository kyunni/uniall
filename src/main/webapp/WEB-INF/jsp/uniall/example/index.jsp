<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>2021년도 원서접수</title>
  <link rel="stylesheet" href="/common/css/import.css">
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
  <div id="wrap_main">
    <div id="container_m">
      <section id="main_sec">
        <div class="m_tit_area">
          <h1 class="mtitle">2021년도 원서접수</h1>
          <span class="m_sub">Application for university admission in 2021</span>
        </div>
        <ul class="user_type">
          <li class="student_go">
            <img src="img/user_stu_big_img.png" alt="수험생 이미지">
            <p>STUDENT</p>
            <button class="cmn_btn01" onclick="location.href='stu_login.html'">수험생 무료 원서접수</button>
          </li>
          <li class="teacher_go">
            <img src="img/user_tch_big_img.png" alt="수험생 이미지">
            <p>TEACHER</p>
            <button class="cmn_btn01" onclick="location.href='tch_login.html'">교사 로그인</button>
          </li>
        </ul>
      </section>
    </div>
  </div>
</body>
</html>