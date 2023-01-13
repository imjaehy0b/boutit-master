<!DOCTYPE html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
    <head>
        <meta charset="UTF-8">
        <style>
            .fieldError{
                border-color: red;
                color: red;
            }
        </style>
    </head>



<body>
    <h1>회원가입</h1>
    <form action="/joinForm" method="POST">
        <!-- 본인확인 이메일 -->
        <div class="form-group">
            <label for="user_email">이메일</label>
            <input type="text" class="form-control" name="email" id="user_email" placeholder="E-mail" required>
            <!-- <input type="text" style="margin-top: 5px;"class="email_form" name="email_confirm" id="email_confirm" placeholder="인증번호를 입력해주세요!" required>
                <button type="button" class="btn btn-outline-danger btn-sm px-3" onclick="confirm_email()">
                    <i class="fa fa-envelope"></i>&nbsp;인증
                </button>&nbsp;
                <button type="button" class="btn btn-outline-info btn-sm px-3">
                    <i class="fa fa-envelope"></i>&nbsp;확인
                </button>&nbsp; -->
            <div class="check_font" id="email_check"></div>
        </div>
        <!-- 비밀번호 -->
        <div class="form-group">
            <label for="user_pw">비밀번호</label>
            <input type="password" class="form-control" id="user_pw" name="pwd" placeholder="PASSWORD" required>
            <div class="check_font" id="pwd_check"></div>
        </div>
        <!-- 비밀번호 재확인 -->
        <div class="form-group">
            <label for="user_pw2">비밀번호 확인</label>
            <input type="password" class="form-control" id="user_pw2" name="pwd2" placeholder="Confirm Password" required>
            <div class="check_font" id="pwd2_check"></div>
        </div>
        <!-- 이름 -->
        <div class="form-group">
            <label for="user_name">이름</label>
            <input type="text" class="form-control" id="user_name" name="name" placeholder="Name" required>
            <div class="check_font" id="name_check"></div>
        </div>
        <!-- 닉네임 -->
        <div class="form-group">
            <label for="nickname">아이디</label>
            <input type="text" class="form-control" id="nickname" name="nickname" placeholder="nickname" required>
            <div class="check_font" id="nick_check"></div>
        </div>
        <!-- 생년월일 -->
        <div class="form-group required">
            <label for="user_birth">생년월일</label>
            <input type="text" class="form-control" id="user_birth" name="birth" placeholder="ex) 19990415" required>
            <div class="check_font" id="birth_check"></div>
        </div>

        <!-- 휴대전화 -->
        <div class="form-group">
            <label for="user_phone">휴대전화 ('-' 없이 번호만 입력해주세요)</label>
            <input type="text" class="form-control" id="user_phone" name="phone" placeholder="Phone Number" required>
            <div class="check_font" id="phone_check"></div>
        </div>

        <div class="reg_button">
            <a class="btn btn-danger px-3" href="${pageContext.request.contextPath}">
                <i class="fa fa-rotate-right pr-2" aria-hidden="true"></i>취소하기
            </a>&emsp;&emsp;
            <button class="btn btn-primary px-3" id="reg_submit">
                <i class="fa fa-heart pr-2" aria-hidden="true"></i>가입하기
            </button>
        </div>
    </form>

<script>
    //중복검사
    $("#user_email").blur(function (){
        let user_email = $('#user_email').val();
        $.ajax({
            url : "${pageContext.request.contextPath}/join/emailCheck?useremail="+user_email,
            type: 'get',
            success : function (data){
                console.log("1=중복 / 0=중복x"+data);

                if (data == 1){
                    $("#email_check").text("사용중인 이메일 입니다.");
                    $("#email_check").css("color","red");
                    $("#reg_submit").attr("disabled", true);
                }else {
                    $("#email_check").text("사용가능한 이메일 입니다.");
                    $("#email_check").css("color","green");
                    $("#reg_submit").attr("disabled", false);
                }

            }
        })
    })
</script>
</body>
</html>