<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <!-- meta tags 필요 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	
<title>Insert title here</title>

	<style>
		html,body{
			width:100%;
			height:100%; 
			
		}
		.main{
			position:relative;
			min-height:100%;
			background-color:#f3f5f7;
			
		
		}
		.main-layout{
			min-width:320px;
			min-height:100%;
			width:550px;
			margin:0 auto;
			height:100%;
			background-color:#f3f5f7;
			
			
			
			
		}
	
		.main-content{
			
			display:block;
			width:550px;
			
			
			background-color:#fff;
			box-shadow:0 2px 4px 0 rgba(0,0,0,.2);
			
			
		
		}
		.header{
			text-align:center;
			padding-top:20px;
			padding-bottom:20px;
			line-height:30px;
		}
		.join-content{
			padding-left:30px;
			padding-right:30px;
		
		}
		.go-join{
			
			text-align:center;
			padding-bottom:20px;
		
		}
		
		.sign-up{
			display:block;
			width:100%;
			background-color:#007bff;
			border-color:#007bff;
			color:#fff;
			line-height:30px;
			border-radius:3px;
		
		}
		
	.error_next_box{
		margin:5px 0px;
		font-size:12px;
		line-height:1;
		color:red;
	
	}
	
	.green{
	
		color:green;
	
	}
		
		
	
	</style>
<script>
$(function(){
	$("#userID").change(function(){
		var userid = $("#userID").val();
		var errorText1 = "이미 등록된 아이디입니다";
		var errorText2 = "필수정보입니다";
		var errorText3 = "6~20자의 영문 소문자, 숫자만 사용가능합니다";
		var successText = "사용가능한 아이디입니다.";
		var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
		
		
		if(userid == ""){
			$("#idMsg").text(errorText2);
			$("#idMsg").css("display","block");
			$("#idMsg").removeClass("green");
			
			
		}else if(!idReg.test(userid)){
			$("#idMsg").text(errorText3);
			$("#idMsg").css("display","block");
			$("#idMsg").removeClass("green");
			
		
		
		}else{
			
			
			$.ajax({
				async:true,
			    type:"POST",
			    data : userid,
			    url : "/idcheck",
			    dataType : "json",
			    contentType: "application/json; charset=UTF-8",
			    success: function(data){
			    	if(data.cnt>0){	
			    		$("#idMsg").text(errorText1);
			    		$("#idMsg").css("display","block");
			    		$("#idMsg").removeClass("green");
			    	}else{
			    		
			    		$("#idMsg").text(successText);
			    		$("#idMsg").css("display","block");
			    		$("#idMsg").addClass("green");
			    		
			    	}
			    	
			    },error:function(error){
			    	
			    	alert("error");
			    	
			    }
			    	
				
			});
		}
		
		
		
	});
	
	
	$("#Nickname").change(function(){
		
		var name = $("#Nickname").val();
		var errorText1 = "이미 등록된 아이디입니다";
		var errorText2 = "필수정보입니다";
		var errorText3 = "6~20자의 영문 소문자, 숫자만 사용가능합니다";
		var successText = "사용가능한 닉네임입니다.";
		
		if(name == ""){
			$("#NicknameMsg").text(errorText2);
			$("#NicknameMsg").css("display","block");
			$("#NicknameMsg").removeClass("green");
			
			
		}else{
			
			$.ajax({
				async:true,
			    type:"POST",
			    data : name,
			    url : "/NicknameCheck",
			    dataType : "json",
			    contentType: "application/json; charset=UTF-8",
			    success: function(data){
			    	if(data.cnt>0){	
			    		$("#NicknameMsg").text(errorText1);
			    		$("#NicknameMsg").css("display","block");
			    		$("#NicknameMsg").removeClass("green");
			    	}else{
			    		
			    		$("#NicknameMsg").text(successText);
			    		$("#NicknameMsg").css("display","block");
			    		$("#NicknameMsg").addClass("green");
			    		
			    	}
			    	
			    },error:function(error){
			    	
			    	alert("error");
			    	
			    }
			    	
				
			});
			
			
			
			
		}
	
		
		
		
	});
	$("#pswd1").change(function(){
		var pswd1 = $("#pswd1").val();
		var pattern1 = /[0-9]/;
		var pattern2 = /[a-zA-Z]/;
		var pattern3 = /[~!@#$%^&*()]/;
		var ErrorText = "필수정보입니다";
		var ErrorText1 = "8자 이상의 영문 소문자,숫자,특스문자를사용하세요"
		var successText = "사용가능합니다"
		
		if(pswd1 == ""){
			$("#pswd1Msg").text(ErrorText);
			$("#pswd1Msg").css("display","block");
			$("#pswd1Msg").removeClass("green");
			
			
		}else if(!pattern1.test(pswd1) || !pattern2.test(pswd1)
				|| !pattern3.test(pswd1) || pswd1.length<8){
			
			$("#pswd1Msg").text(ErrorText1);
			$("#pswd1Msg").css("display","block");
			$("#pswd1Msg").removeClass("green");
		}else{
			$("#pswd1Msg").text(successText);
			$("#pswd1Msg").css("display","block");
			$("#pswd1Msg").addClass("green");
		}
		
		
	});
	$("#pswd2").change(function(){
		var pswd1 = $("#pswd1").val();
		var pswd2 = $("#pswd2").val();
		
		var ErrorText = "비밀번호가 일치하지 않습니다";
		var SuccessText="비밀번호가 일치합니다"
		if(pswd1 != pswd2){
			$("#pswd2Msg").text(ErrorText);
			$("#pswd2Msg").css("display","block");
			$("#pswd2").val("");
			$("#pswd2Msg").removeClass("green");
			//$(".error_next_box").css("display","block");
		}else{
			$("#pswd2Msg").text(SuccessText);
			$("#pswd2Msg").css("display","block");
			$("#pswd2Msg").addClass("green");
		}
		
		
	});
	
	$("#name").change(function(){
		
		var name = $("#name").val();
		var pattern = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
		var ErrorMsg = "한글과 영문 대 소문자를 사용하세요.(특수기호, 공백 사용 불가)";
		
		if(!pattern.test(name)){
			$("#nameMsg").text(ErrorMsg);
			$("#nameMsg").css("display","block");
			$("#nameMsg").removeClass("green");
			
		}else{
			//$("#nameMsg").text("success");
			$("#nameMsg").css("display","none"); 
			$("#nameMsg").addClass("green");
		}
		
	});
	$("#mobile").change(function(){
		var mobile = $("#mobile").val();
		var Pattern = /^[0-9]*$/;
		var ErrorText = "11자리 전화번호를 입력해주세요";
		
		if(mobile == ""){
			$("#mobileMsg").text(ErrorText);
			$("#mobileMsg").css("display","block");
			$("#mobileMsg").removeClass("green");
		}else if(!Pattern.test(mobile) || mobile.length != 11){
			$("#mobileMsg").text(ErrorText);
			$("#mobileMsg").css("display","block");
			$("#mobileMsg").removeClass("green");
			
			
		}else{
			$("#mobileMsg").text("");
			$("#mobileMsg").css("display","none");
			$("#mobileMsg").addClass("green");
		}
	});
	
	
	
	
});

function signUp(){
	
	var userid = $("#idMsg").hasClass("green");
	var userpwd = $("#pswd2Msg").hasClass("green");
	var username = $("#nameMsg").hasClass("green");
	var phoneNumber =$("#mobileMsg").hasClass("green");
	var name = $("#NicknameMsg").hasClass("green");
	
	
	if(!userid){
		alert("아이디");
		$("#userID").focus();
		return false;
		
	}
	if(!userpwd){
		alert("패스워드");
		$("#pswd1").focus();
		return false;
	}
	
	if(!username){
		alert("이름");
		$("#name").focus();
		return false;
	}
	
	
	
	if(!phoneNumber){
		$("#mobile").focus();
		alert("폰번호");
		return false;	
	}
	if(!name){
		$("#Nickname").focus();
		alert("닉네임");
		return false;
		
		
	}
	
	
	$("#join_form").submit();
	return true;
	
}







</script>


</head>
<body>

	<div class="main">
		<div style="padding-top:100px;
			padding-bottom:150px;">
		<div class="main-layout">
		<div class="main-content">
			<div class="header">
				회원가입
			</div>
			<form action="/joinAction" id="join_form"class="join-content" method="post">
			<div class="form-group">
				
				<input type="text" id="name"name="username" class="form-control" placeholder="이름">
				<span class="error_next_box" id="nameMsg" style="display:none;"></span>
			</div>
			
			<div class="form-group">
				<input type="text" id="userID" name="userid" class="form-control" placeholder="아이디">
				<span class="error_next_box" id="idMsg" style="display:none;"></span>
			</div>
			
			<div class="form-group">
				<input type="password" id="pswd1" name="password" class="form-control" placeholder="비밀번호">
				<span class="error_next_box" id="pswd1Msg" style="display:none;"></span>
			</div>
			
			<div class="form-group">
				<input type="password" id="pswd2" name="passwordCheck" class="form-control" placeholder="비밀번호확인">
				<span class="error_next_box" id="pswd2Msg" style="display:none;"></span>
			</div>
			<div class="form-group">
				<input type="text" id="Nickname" name="nickname" class="form-control" placeholder="닉네임">
				<span class="error_next_box" id="NicknameMsg" style="display:none;"></span>
			</div>
			
			<div class="form-group">
				<input type="text" id="mobile" name="mobile" class="form-control" placeholder="휴대폰번호">
				<span class="error_next_box" id="mobileMsg" style="display:none;"></span>
			</div>
			
			<div class="form-group">
				<button type="button" class="sign-up" onclick="signUp()">가입완료</button>
				
			</div>
			
			</form>
			
			<div class="go-join">
				이미 가입되어 있으신가요?
				<a href="/login" style="text-decoration:none;">로그인</a>
			</div>
			
			
			
		</div>
		</div>
		</div>
	</div>






</body>
</html>