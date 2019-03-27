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
		.main{
			padding-top:150px;
			padding-bottom:100px;
		
		}
	
		.main-content{
			display:block;
			width:550px;
			margin:0 auto;
			min-height:130vh;
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
		.go-login{
			
			text-align:center;
		
		
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
		
		.naver-login{
			text-align:center;
			
			
		
		
		}
		
		.naver-login a{
			
			display:block;
			
			height:38px;
			line-height:34px;
			color:#666;
			text-decoration:none;
			
		}
		.naver-login img{
			width:40px;
			height:40px;
		}
		
		
		
	</style>



</head>
<body>

	<div class="main">
		<div class="main-content">
			<div class="header">
				로그인
			</div>
			<form action="/auth" class="join-content" method="post">
			
			
			<div class="form-group">
				<input type="text" name="userid" class="form-control" placeholder="아이디">
			</div>
			
			<div class="form-group">
				<input type="password" name="password" class="form-control" placeholder="비밀번호">
			</div>
			
			
			
			
			<div class="form-group">
				<button type="submit" class="sign-up">로그인</button>
			
			</div>
			
			</form>
			
			<div class="go-login">
				계정이 없으신가요?
				<a href="/join" style="text-decoration:none;">회원가입</a>
			</div>
			
			<div class="naver-login">
				<a href="${apiURL }"><img src="/resources/img/naver.jpg">네이버 로그인
				</a>
			</div>
			
			
			
		</div>
	</div>






</body>
</html>