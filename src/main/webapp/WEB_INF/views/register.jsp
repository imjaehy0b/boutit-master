<!DOCTYPE html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>




<head>
    <meta charset="UTF-8">
    <style>
        .fieldError{
            border-color: red;
            color: red;
        }
    </style>
</head>
<script language="JavaScript">
    function check_email(){

        let emailCheck = 0;

        let inputed = $('input#email').val();
        console.log(inputed)

        $.ajax({
            data:inputed,
            url:"emailCheck",
            type:"POST",
            dataType:"JSON",
            contentType:"application/json; charset=UTF-8",
            success:function (data){
                let result = JSON.parse(data);

                if (result.check>0){
                    $('#email').css("background-color","#FFCECE");
                    $('.email-text').css("margin-bottom", "16px")
                    $(".email-text").text("이미 사용중인 이메일입니다.")
                    $('button#reg_submit').attr("disabled","true")
                }else if (result.check ==0){
                    $(".email-text").text("사용 가능한 이메일입니다.")
                    $('button#reg_submit').attr("disabled")

                }
            }
        })
    }
</script>


<body>
<h1>회원가입</h1>
<form action="/join" method="POST">
    <!-- 본인확인 이메일 -->
    <div class="form-group">
        <label for="email">이메일</label>
        <input type="text" class="form-control" name="email" id="email" placeholder="E-mail" oninput="check_email()" required>
        <div class="email-text"></div>
        <!-- <input type="text" style="margin-top: 5px;"class="email_form" name="email_confirm" id="email_confirm" placeholder="인증번호를 입력해주세요!" required>
            <button type="button" class="btn btn-outline-danger btn-sm px-3" onclick="confirm_email()">
                <i class="fa fa-envelope"></i>&nbsp;인증
            </button>&nbsp;
            <button type="button" class="btn btn-outline-info btn-sm px-3">
                <i class="fa fa-envelope"></i>&nbsp;확인
            </button>&nbsp; -->
        <div class="check_font" id="email_check"></div>
    <!-- 비밀번호 -->
    <div class="form-group">
        <label for="pwd">비밀번호</label>
        <input type="password" class="form-control" id="pwd" name="pwd" placeholder="PASSWORD" required>
        <div class="check_font" id="pw_check"></div>
    </div>
    <!-- 비밀번호 재확인 -->
    <div class="form-group">
        <label for="pwd2">비밀번호 확인</label>
        <input type="password" class="form-control" id="pwd2" name="pwd2" placeholder="Confirm Password" required>
        <div class="check_font" id="pw2_check"></div>
    </div>
    <!-- 이름 -->
        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
            <div class="check_font" id="name_check"></div>
        </div>
    <!-- 닉네임 -->
    <div class="form-group">
        <label for="nickname">닉네임</label>
        <input type="text" class="form-control" id="nickname" name="nickname" placeholder="nickname" required>
        <div class="check_font" id="nickname_check"></div>
    </div>
        <!-- 생년월일 -->
    <div class="form-group required">
        <label for="birth">생년월일</label>
        <input type="text" class="form-control" id="birth" name="birth" placeholder="ex) 19990415" required>
        <div class="check_font" id="birth_check"></div>
    </div>
    </div>
    <!-- 휴대전화 -->
    <div class="form-group">
        <label for="phone">전화번호</label>
        <input type="text" class="form-control" id="phone" name="phone" placeholder="('-' 없이 번호만 입력해주세요)" required>
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
    </div>
</div>


<%--<form action="/join" method="post" >
    <div class="container">
        <div class="form-group">
            <label for="email">이메일</label>
            <input type="email" required="required" class="form-control" id="email" name="email" placeholder="이메일">
        </div>



        <div class="form-group">
            <label for="pwd">비밀번호</label>
            <input type="password" required="required" class="form-control" id="pwd" name="pwd" placeholder="비밀번호">
            <div class="alert alert-warning" id="pwdCheck"> 비밀번호는 4자 이상이여야 합니다.</div>
        </div>


        <div class="form-group">
            <label for="name">이름</label>
            <input type="text" required="required" class="form-control" id="name" name="name" placeholder="이름">
        </div>

        <div class="form-group">
            <label th:for="nickname">닉네임</label>
            <input type="text" required="required"  class="form-control" placeholder="닉네임을 입력하세요" id="nickname" name="nickname">
        </div>

        <div class="form-group">
            <label for="birth">생년월일</label>
            <input type="text" required="required" class="form-control datepicker" id="birth" name="birth" placeholder="생년월일">
        </div>

        <div class="form-group">
            <label for="phone">전화번호</label>
            <input type="text" required="required" class="form-control" id="phone" name="phone" placeholder="전화번호">
        </div>



        <button type="submit" class="btn btn-primary">가입 완료</button>
    </div>
</form>--%>
</body>
</html>