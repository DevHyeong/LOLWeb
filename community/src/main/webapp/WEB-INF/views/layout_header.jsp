<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	

<title>Insert title here</title>

<style>
	.main-header{
		
		background:rgba(255,255,255,1);
		box-shadow:0px 3px 5px rgba(0,0,0,0.2);
		
		width:100%;
	}

	ul{
		list-style:none;
		margin-bottom:0;
	
	}
	.nav-header{
		position:relative;
		height:50px;	
	
	
	}
	
	.layout-top-sub{
		display:inline-block;
		text-align:center;
		
		
		position:absolute;
		top:7px;
		
		left:400px;
	
	}
	
	.layout-top-sub li{
		display:inline-block;
		padding:10px 0px 14px;
		
		
	}
	
	.layout-top-sub li a{
		text-decoration : none;
		color:#000;
		font-weight:bold;
		line-height:14px;
		font-size:14px;
		margin: 0 17px;
	
	}
	.layout-top-sub li a:hover{
		color:#007bff;
	
	}
	
	.layout-top-search{
		position:absolute;
		top:7px;
		
		right:200px;
		display:inline-block;
	
	
	
	}
	.layout-top-search input{
		width: 200px;
		border: none;
		line-height:26px;
		background-color:#ebeef1;
		padding:5px 25px 5px 20px;
	}
	.layout-top-search button{
		border:0;
		position:absolute;
		top:10px;
		right:0;
		background:none;
	
	}
	.layout-top-login{
		display:inline-block;
		position:absolute;
		
		right:80px;
		
		
	}
	.login-btn{
		padding:14px 0px 14px;
	
	}
	
	.login-btn a{
		text-decoration:none;
		color:#000;
		font-size:14px;
		line-height:25px;
	}
	.login-btn a:hover{
		color:#007bff;
	
	}
	
	
</style>



</head>
<body>
<div class="main-header">
		<div class="nav-header">
			<div class="layout-top-sub">
				<ul>
					<li><a href="/">홈</a></li>
					<li><a href="#">랭킹</a></li>
					<li><a href="/community">커뮤니티</a></li>
					
				
				
				</ul>
			</div>
			<div class="layout-top-search">
				<form action="/find" method="get">
							
					<input  class="summoner-id" name ="summoner" type="text" placeholder="소환사검색">
					<button type="button" class="_submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
			
			
			</div>
			
			
			
			<div class="layout-top-login">
				<div class="login-btn">
				<c:choose>
					<c:when test="${sessionScope.user ne null }">
						<a href="/logout">${sessionScope.user.nickname }님</a>
					</c:when>
					<c:otherwise>
					
						<a href="/login">로그인</a>
					
					</c:otherwise>
				</c:choose>
					
				</div>
				
				
			</div>
			
		</div>
	</div>

	








</body>
</html>