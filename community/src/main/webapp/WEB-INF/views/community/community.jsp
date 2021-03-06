<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<%@ page session="true" %>
    
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
    <title>Hello, world!</title>
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
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="resources/css/Community.css">
	
	
    <!-- Bootstrap CSS -->
	<style>
		
		
		
	
		.button{
			display:block;
			width:100%;
			background-color:#5abef5;
			border-color:#5abef5;
			color:#fff;
			line-height:20px;
			padding:10px;
			border-radius:4px;
		
		}
		
		
		
		.content{
			width:790px;
			float:right;
			padding:26px 20px 26px 20px;
			border:2px solid #DBDBDB;
		
		}
		
		.header-content{
			position:relative;
			
		}
		.sub-header{
			padding-bottom:100px;
		
		}
		
		
		.sub-content{
			margin-top:7px;
			padding:5px;
		
		}
		
		.sub-title{
			font-size:18px;
		
		}
		
		.sub-write{
			float:right;
		}
		
		.list-sort{
			position:absolute;
			
			list-style:none;
			float: left;
			bottom:0;
			margin-bottom:0;
			line-height:20px;
			font-size:15px;
		
		
		}
		.list-sort-item{
			float: left;
			margin-right: 20px;
			
		}
		.list-sort-item-active{
			color:#16ae81;
		
		
		}
		
		.sub-search-content{
			position: absolute;
			right:0;
			bottom:0;
			
		}
		
		.sub-link{
			height:30px;
			padding: 0px 5px 0 5px;
			
			
		
		}
		
		
		.list-content{
			position:relative;
			display:table;
			table-layout:fixed;
			width:100%;
			background-color:#fff;
			min-height:76px;
			border-top: 1px solid #ebeef1;
		
		
		}
		.list-content> div{
			vertical-align: middle;
		}
		
		.list-id{
			display: table-cell;
			width:72px;
			
			
		}
		
		.list-title{
			display:table-cell;
			width:370px;
		
		}
		.list-author{
			display:table-cell;
			font-size:14px;
			text-align:center;
		
		}
		
		.list-paging{
			display:table;
			width:100%;
			height:30px;
		
		
		}
		.list-vote{
			display:table-cell;
			position:relative;
			width:90px;
			text-align:center;
		
		}
		
		.list-vote span{
			font-family: initial;
			font-size:14px;
			position:absolute;
			top:29px;
			right:23px;
		
		}
		
		.list-vote>.material-icons{
			font-size:20px;
		}
		.list-view>.material-icons{
			font-size:20px;
		}
		
		.list-view span{
			font-family: initial;
			font-size:14px;
			position:absolute;
			top:29px;
			right:23px;
		
		}
		
		
		.list-view{
			display:table-cell;
			position:relative;
			width:90px;
			text-align:center;
		}
		
		
		a{
			text-decoration:none!important;
			color:inherit!important;
		}
		
		.article-page{
			padding: 10px 30px 10px 30px;
		
		
		}
		.article-page-list{
			
			text-align:center;
			font-size:16px;
		}
		
		
		.article-page-content{
			display:inline-block;
			padding:5px 15px 5px 15px;
			border-radius:4px;
			border:1px solid #dddfe4;
		
		}
		
		.article-page-content > a > span{
			vertical-align:middle;
		
		}
		
		.article-page-content > a{
			
		
		}
		
		.article-page-content>a>i{
			vertical-align:middle;
		
		}
		
		
		ul{
			list-style:none;
			margin-bottom:0px;
		
		
		}
		
		.sub-search-content button{
			position:absolute;
			height:26px;
			background:none;
			border:0;
			top:0;
			right:0;
			margin-top:4px;
		
		}
		
		.sub-search-content select{
			width:80px;
			height:36px;
			font-size:14px;
			border:1px solid #ebeef1;
		
		}
		
		
		
		.sub-search-content input{
			
			width:200px;
			border:none;
			line-height:26px;
			background-color:#ebeef1;
			padding:5px 25px 5px 20px;
		
		}
		
		
		.page-active{
			color:#007bff;
		
		}
		
		
		
	</style>
	
	<script>
	$(document).ready(function(){
		var locationName = window.location.href;
		
		if(locationName.indexOf("/community?sort=popular")!=-1){
			
			$(".list-sort").children().eq(1).addClass("list-sort-item-active");
			
		}else if(locationName.indexOf("/community?sort=lookup")!=-1){
			
			$(".list-sort").children().eq(2).addClass("list-sort-item-active");
			
		}else if(locationName.indexOf("/community")!=-1){
			
			$(".list-sort").children().eq(0).addClass("list-sort-item-active");
			
		}
		
		
		
		
		
		
		
		
		$("._submit").click(function(){
			
			var formdata = $("#form-search").serialize();
			var decodeData = decodeURIComponent(formdata);
			
			$("#form-search").attr("action","/community/find");
			$("#form-search").attr("method","/get");
			$("#form-search").submit();
			
		});
		
		
		
		
		
		
	});
	
	
	</script>
	    
</head>
	<body>
	<jsp:include page="../layout_header.jsp" flush="false"/>
		
		
		
	<div class="l-wrap">
	<div class="main-content">
		
		<div class="side-bar">
			
		
			<div class="sidebar-menu">
				<ul class="sidebar-items">
					<li>
						<a href="#" onclick="dateFormat()">
							전체
						</a>
					</li>
				
				</ul>
			
			
			
			</div>
		
		</div>
		<div class="content">
			<div class="header-content" style="position:relative;">
				<div class="sub-header">
					<span class="sub-title">커뮤니티</span>
					<div class="sub-write">
						<a href="/write">
						<i class="medium material-icons">create</i>
						</a>
					</div>
				</div>
			
				<div class="sub-link">
					<ul class="list-sort">
						<li class="list-sort-item">
						<a href="/community">최신순</a></li>
						<li class="list-sort-item">
						<a href="/community?sort=popular">인기순</a></li>
						<li class="list-sort-item">
						<a href="/community?sort=lookup">조회순</a></li>
						
						
					</ul>
					<div class="sub-search-content">
						<form id = "form-search">
							<select name="target">
								<option value="title">제목</option>
								<option value="username">작성자</option>
							</select>
							<input type="text" name="content">
							<button type="button" class="_submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</form>
					</div>
				
				</div>
				
			</div>
			
			<div class="sub-content">
				
				
				<c:forEach var="board" items="${board }" begin="${page.startIndex }" end="${page.lastIndex-1 }" step="1">
				<div class="list-content">
					<div class="list-id">
						${board.idx }
					</div>
					<c:set var="index" value="${board.idx }"/>
					<div class="list-title">
						<a href="/community/${index }" class="list-info">${board.title }</a>
					</div>
					
					<div class="list-vote">
						<i class="material-icons">favorite_border<span>${board.voteUp - board.voteDown }</span></i>
						
					</div>
					
					<div class="list-view">
						<i class="material-icons">visibility<span>${board.view_count }</span></i>
						
					</div>
					
					
					
					<div class="list-author">
						<span>
						${board.date}
						</span>
						<div>
							${board.nickname }
						</div>
					</div>
					
				
				
				</div>
				</c:forEach>
				
			</div>
			
			<div class="article-page">
				<div class="article-page-list">
					<ul>
					<c:if test="${page.startPage ne '1'}">
					<li class="article-page-content">
					
							<a href="/community?page=${page.startPage-1}">
							<i class="medium material-icons">chevron_left</i>
							<span>이전</span></a>
						</li>
					</c:if>
					<c:forEach var="item" begin="${page.startPage }" end="${page.lastPage }" step="1">
						
						<c:choose>
						<c:when test="${page.curPage eq item }">
						<li class="article-page-content page-active">
							<a href="/community?page=${item }">
							<span>${item}</span>
							</a>
						</li>
						
						
						</c:when>
						<c:otherwise>
						<li class="article-page-content">
							<a href="/community?page=${item }">
							<span>${item}</span>
							</a>
						</li>
						</c:otherwise>
						
						</c:choose>
						
						</c:forEach>
	
						<c:if test="${page.lastPage ne page.totalPage }">
						<li class="article-page-content">
						
							<a href="/community?page=${page.lastPage+1 }">
							<span>다음</span>
							<i class="medium material-icons">chevron_right</i>
							</a>
						</li>
						</c:if>
					</ul>
				</div>
			</div>
			
		</div>
		
		
	</div>
	
	
	
	
  	</div>
  	<!-- Optional JavaScript -->
    <!-- 먼저 jQuery가 오고 그 다음 Popper.js 그 다음 Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>