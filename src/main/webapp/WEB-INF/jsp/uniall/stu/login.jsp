<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>수험생 무료 원서접수</title>
  <link rel="stylesheet" href="css/import.css">
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
  <div id="wrap_sub1">
    <div id="container_s">
      <!-- header title -->
      <header id="cmn_head01">
        <h1 class="sub1_tit">수험생 무료 원서접수</h1>
      </header>

      <!-- login 영역 -->
      <article id="sbtye01">
        <div class="login_s_box01">
          <div class="login_input_area">
            <span class="avata_stu">STUDENT</span>
            
            <div class="input_zone">
              <div class="hp_input">
                <label for="hp_num" class="blind">휴대폰번호</label>
                <input id="hp_num" type="text" placeholder="휴대폰 번호를 입력해주세요" maxlength="11" class="input_typ01" />
                <button class="cmn_btn01" onclick="location.href='stu_login02.html'">비밀번호 전송</button>
              </div>
              <div class="pw_input">
                <label for="pw_num" class="blind">비밀번호 입력</label>
                <input id="pw_num" type="password" placeholder="발급된 비밀번호를 입력해주세요!" class="input_typ01" />
                <button class="cmn_btn02">비밀번호 확인</button>
              </div>
              <div class="rad_select">
                <input id="admiss_chk" type="radio" class="chk_cmn01">
                <label for="admiss_chk">원서접수</label>
                <input id="confirm_chk" type="radio" class="chk_cmn01">
                <label for="confirm_chk">접수확인</label>
              </div>
            </div>
          </div>
          <span class="exp_txt">
            휴대폰으로 전송된 비밀번호는 본 시스템 이용 시 계속 이용 됩니다.<br>
            별도로 잘 관리하시어 이용에 불편함이 없도록 부탁드립니다.
          </span>
        </div>
      </article>
    </div>
  </div>
</body>
</html>