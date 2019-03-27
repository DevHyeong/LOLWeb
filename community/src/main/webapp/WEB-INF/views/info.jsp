<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  

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
	<base href="/"> 
	<link rel="stylesheet" type="text/css" href="resources/css/Community.css">
	
	
    <!-- Bootstrap CSS -->
	<style>
		
		
		.article-header{
			padding-top:24px;
			padding-left:24px;
			padding-right:24px;
			padding-bottom:24px;
			border-bottom:1px solid #ebeef1;
		}
		
		.article-title{
			position:relative;
			line-height:36px;
			font-size:24px;
			color:#1e2022;
			
		
		}
		.article-meta{
			margin-top:9px;
			
			font-size:14px;
			color:#7b858e;
		
		}
		.article-meta-left{
			float:left;
		}
		
		.article-meta-right{
			float:right;
		}
		
		.article-content{
			
			width:100%;
			margin-top:5px;
			padding-right:24px;
			padding-left:24px;
			color:#1e2022;
			line-height:24px;
			padding-top:24px;
			padding-bottom:24px;
			font-size:16px;
			
		
		}
		.comment{
			padding-right:24px;
			padding-left:24px;
		
		
		}
		
		.comment-header{
			margin-bottom:10px;
		
		}
		
		.repeat-content{
			
			padding: 12px 12px 12px 12px;
		}
		
		.repeat-header{
			line-height:36px;
			
		}
		
		
		.repeat-name{
			display:inline-block;
			font-size:15px;
			margin-right:10px;
			
		}
		
		.repeat-nickname{
			color:inherit!important;
		}
		
		
		.repeat-date{
			display:inline-block;
			font-size:14px;
			color:#7b858e;
			
			
		}
		
		.repeat-text{
			line-height:30px;
			
		}
		
		.repeat-footer{
			
			position:relative;
			min-height:30px;
			margin-top:5px;
		
		}
		.repeat-write {
			border-top:1px solid #dddfe4;
			position:relative;
		}
		
		.repeat-write-submit{
			position:absolute;
			right:0;
			bottom:0;
		
		}
		
		
		.repeat{
			border-top:1px solid #dddfe4;
			position:relative;
		}
		
		.reply-content{
			padding:8px 12px 12px 94px;
			
		
		}
		
		
		.reply-content:before{
			position:absolute;
			top:12px;
			left:64px;
			content: "";
			width:12px;
			height:12px;
			border-left:1px solid #c5cbd0;
			border-bottom:1px solid #c5cbd0;
		
		}
		
		
		.register{
			width:100%;
		
		
		}
		
		.repeat-btn{
			width:90px;
			background-color:#007bff;
			border-color:#007bff;
			color:#fff;
			
			line-height:20px;
			padding:5px;
		}
		
		
		
		a{
			text-decoration:none!important;
			
		}
		
		.comment-write{
			
			margin-bottom:10px;
			padding:12px 12px 12px 12px;
			border : 1px solid #dddfe4;
		
		}
		
		.comment-write-header{
			line-height:30px;
			font-size:15px;
			font-weight:700;
		}
		
		
		.comment-write-content{
			line-height:30px;
			width:100%;
			
			
		
		
		}
		
		.comment-write-footer{
			position:relative;
			min-height:30px;
			margin-top:5px;
		
		
		}
		.comment-write-submit{
			position:absolute;
			right:0;
			bottom:0;
		}
		
		.footer{
			padding-top:30px;
			height:50px;
		
		
		}
		
		.nickname{
			color:#007bff;
		
		
		}
		
		.reply{
			color:inherit!important;
		}
		
		
		ul{
			list-style:none;
			
		}
		
		.article-popular{
			text-align:center;
			
			padding:12px 0px;
		
		}
		.article-popular-item{
			display:inline-block;
			line-height:30px;
			font-size:14px;
			padding: 2px 12px;
			border: 1px solid #dddfe4;
			margin-left:10px;
			width:80px;
			vertical-align:middle;
			color:#1e2022;
			
			
		
		}
		
		
		.article-popular-item a{
			color:#dddfe4;
			
			
		
		}
		
		.article-popular-item a i{
			font-size:20px;
			vertical-align:middle;
		}
		
		.article-popular-item a span{
			color:#1e2022;
			margin-left:4px;
			
			
		
		}
		
		.article-popular-item >.article-vote-active{
			color:#337ab7;
		
		
		}
		
		.article-modify{
			position:absolute;
			right:10px;
			bottom:1px;
			display:inline-block;
			line-height:14px;
			font-size:14px;
		}
		
		.article-modify a{
			color:#7b858e;
		}
		
		
		.article-content img{
			max-width:100%;
		}
		
		
		.footer{
			height:100px;
		
		}
		
		
		
	</style>
	<script>
		$(document).ready(function(){
			
			
			
			
			
			$(".reply").click(function(){
				var member = "<%=(Object)session.getAttribute("user") %>";
				if(member == "null"){
					location.href="/loginCheck";		
				}else{
					var parentsNode = $(this).parents("div.repeat");
					var parentNode = $(this).parent("div.repeat-footer").siblings(".repeat-header");
					var userid = parentNode.find("a").text();
					var repeat_idx = parentsNode.children("#repeat-id").val();
					var pointer = parentsNode.children("#pointer").val();
					
					
					if(pointer == undefined){
						
						pointer = 0;
						
					}
					//alert(parentsNode.attr("class"));
					var check = parentsNode.next();
					if( check.attr("class") == "repeat-write"){
						check.remove();
						return;
					}
					
					var html = "";
					
					
					
					
					html += "<div class='repeat-write'>";
					html +="<form id='form-reply' method='post'>";
					html += "<input type='hidden' name='board_idx' value=${board.idx }>";
					html += "<input type='hidden' name='userid' value=${sessionScope.user.userid }>";
					html += "<input type='hidden' name='nickname' value=${sessionScope.user.nickname }>";
					html += "<input type='hidden' name='repeat_idx' value="+repeat_idx+">";
					html += "<input type='hidden' name='pointer' value="+pointer+">";
					
					html += "<div class='reply-content'>"
					html +=	"<div class='repeat-header'>";
					html +=	"<div class='repeat-name'>";
					html +=	"<span>${sessionScope.user.nickname}</span>";
					html +=	"</div>";
							
					html +=	"</div>";
						
					html +=	"<div class='repeat-text'>";
					html +=	"	<textarea name = 'content'class='register' placeholder='댓글'></textarea>";
					html +=	"</div>";
						
					html +=	"<div class='repeat-footer'>";
					html +="<div class='repeat-write-submit'>";
					html +=	"<button class='repeat-btn reply-submit'>작성완료</button>";
					html +=	"</div>";
					html +=	"</div>";
					
					html +="</div>";
					html +="</div>";
					html +="</form>";
					
					parentsNode.after(html);
			
					
					
				}
				
				
			
					
				
				
				
				
				
				
			});
			
			// 댓글클릭시
			$(".repeat-submit").click(function(){
				var formdata = $("#form-write").serialize();
				var decodeData = decodeURIComponent(formdata);
				
				
				$.ajax({
					async:true,
					url : "/writeRepeat",
					type: 'POST',
					data : convertJson(decodeData),
					dataType : "json",
					contentType: "application/json; charset=UTF-8",
					
					success:function(data){
						alert(data);
						
					},error:function(){
						
						
						alert("error");
						
					}
				});
				reload_list();
				
			});
			
			//답글클릭시
			$(document).on("click",".reply-submit",function(){
				
				
				var formdata = $("#form-reply").serialize();
				var decodeData = decodeURIComponent(formdata);
				$.ajax({
					async:true,
					url : "/writeReply",
					type: 'POST',
					data : convertJson(decodeData),
					dataType : "json",
					contentType: "application/json; charset=UTF-8",
					
					success:function(data){
						
						
					},error:function(){
						
						
						alert("error");
						
					}
				});
				reload_list();
				
			});
			
			
			$("._article-vote").click(function(){
				
				var sibling = $(this).parent().siblings().children("a"); // 
				var sibling_cnt = sibling.children("span"); // 좋아요 갯수
				
				
				var classname = $(this).attr("class"); // 클릭된 요소의 class
				var count = 0;
				
				var cnt = $(this).children("span"); // 좋아요 갯수
				
				var check = 0;
				var vote_value = $(this).children(".material-icons").text();
				var board_idx = "${board.idx}";
				
				
				var userid = "${sessionScope.user.userid }";
				
				
				
				
				if(userid==""){
					
					location.href="/login";
					return;
				}
				
				if(classname.indexOf("article-vote-active")!=-1){
					$(this).removeClass("article-vote-active");
					
					
					count = 0;
					cnt.text(Number(cnt.text())-1);
					
					
				}else{
					if(sibling.attr("class").indexOf("article-vote-active")!=-1){
						sibling.removeClass("article-vote-active");
						check = 1;
						sibling_cnt.text(Number(sibling_cnt.text())-1);
					}
					$(this).addClass("article-vote-active");
					count = 1;
					cnt.text(Number(cnt.text())+1);
				}
				

				
				var obj = {vote:vote_value,index:board_idx, count:count, userid:userid,
						check:check};
				
				// count = 1, 0 ,-1;
				// vote_value = thumb_up, thumb_down
				
				
				var jsondata = JSON.stringify(obj);
				
				
				
				alert(jsondata);
				
				
				$.ajax({
					async:true,
					url : "/vote",
					type: 'POST',
					data : jsondata,
					dataType : "json",
					contentType: "application/json; charset=UTF-8",
					
					success:function(data){
						
						
					},error:function(){
						
						
						alert("error");
						
					}
					
					
					
					
					
				});
				 
				
				
				
			});
			
			
			
			
		});
		
		function reload_list(){
			/* var currentLocation = window.location;
			$(".content").load(currentLocation); */
			window.location.reload();
			
		}
		
		
		function convertJson(formdata){
			
			var json_data = new Object();
			
			var test = formdata.split("&");
			
			
			
			for(i=0; i<test.length; i++){
				
				
				var data = test[i].split("=");
				var key = data[0];
				var value = data[1];
				
				
				json_data[key] = value;
			
				
			}
			return JSON.stringify(json_data);
			
		}
		
		
		
	
	</script>
</head>
	<body>
	
	<jsp:include page="layout_header.jsp" flush="false"/>
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
			
			<div class="article">
				<div class="article-header">
					<div class="article-title">
						<span>${board.title }</span>
						<c:if test="${sessionScope.user.userid eq board.userid }">
						<div class="article-modify">
							<a href="/community/update/${board.idx }" style="margin-right:5px;">수정</a>
							<a href="javascript:;">삭제</a>
						</div>
						</c:if>
					</div>
					<div class="article-meta">
						<div class="article-meta-left">
							<div style="display:inline-block; margin-right:10px;">
								<a href="#">${board.nickname }</a>
							</div>
							<div style="display:inline-block;margin-right:10px;">
								<span>${board.date }</span>
							</div>
						</div>
						
						<div class="article-meta-right">
							<div style="display:inline-block;margin-right:10px;">
								<span>조회 ${board.view_count }</span>
							</div>
							<div style="display:inline-block;margin-right:10px;">
								<span>댓글  ${count } </span>
							</div>
							<div style="display:inline-block;margin-right:10px;">
								<span>추천 ${board.voteUp - board.voteDown }</span>
							</div>
							
						</div>
						
						
					</div>
				</div>
				
				<div class="article-content">
					<p>${board.content_text }</p>
				
				</div>
				
				<div class="article-popular">
					<ul>
						<li class="article-popular-item">
							<c:choose>
								<c:when test="${vote eq '1' }">
								<a href="javascript:;" class="_article-vote article-vote-active">
								</c:when>
								<c:otherwise>
								<a href="javascript:;" class="_article-vote">
								</c:otherwise>
							</c:choose>
							
							 <i class="material-icons">thumb_up</i><span>${board.voteUp }</span>
							</a>
							
						</li>
						<li class="article-popular-item">
							<c:choose>
								<c:when test="${vote eq '-1' }">
								<a href="javascript:;" class="_article-vote article-vote-active">
								</c:when>
								<c:otherwise>
								<a href="javascript:;" class="_article-vote">
								</c:otherwise>
							</c:choose>
							 <i class="material-icons">thumb_down</i><span>${board.voteDown }</span>
							</a>
						
						</li>
					</ul>
				
				</div>
			</div>
			
			<div class="comment">
				<div class="comment-header">
					<h2 style="font-size:20px; color:#1e2022; display:inline-block;">댓글</h2>
					<span style="margin-left:10px;">${count }개</span>
				</div>
				<c:if test="${sessionScope.user ne null }">
				<form id="form-write" method="post" accept-charset="UTF-8">
				
					<input type="hidden" name="board_idx" value=${board.idx }>
					<input type="hidden" name="userid" value=${sessionScope.user.userid }>
					<input type="hidden" name="nickname" value=${sessionScope.user.nickname }>
					
					<div class="comment-write">
						<div class="comment-write-header">
							<span>${sessionScope.user.nickname }</span>
						</div>
						
						<div class="comment-write-content">
							<textarea name="content" class="register" placeholder="댓글"></textarea>
						
						</div>
						
						<div class="comment-write-footer">
							<div class="comment-write-submit">
								<button class="repeat-btn repeat-submit">댓글쓰기</button>
							</div>
						</div>
						
						
					</div>
				</form>
				</c:if>
				<div class="comment-list">
					<c:forEach var="items" items="${repeat }">
					<div class="repeat">
						
						<input type="hidden" id = "repeat-id" value="${items.idx }">
						<div class="repeat-content">
							<div class="repeat-header">
								<div class="repeat-name">
									<a href="#" class="repeat-nickname" onclick="">${items.nickname }</a>
								</div>
								<div class="repeat-date">
									${items.date }
								</div>
								
							</div>
							
							<div class="repeat-text">
								<p>${items.content }</p>
							</div>
							
							<div class="repeat-footer">
								<a href="javascript:;" class="reply">답글쓰기</a>
							</div>
							
						</div>
						
					
					</div>
					
					
					<c:forEach var="replyItem" items="${reply }">
						<c:if test ="${replyItem.repeat_idx eq items.idx }" >
						<div class="repeat">
							<input type="hidden" id = "repeat-id" value="${items.idx }">
							<input type="hidden" id = "pointer" value="${replyItem.idx }">
							<div class="reply-content">
							
								<div class="repeat-header">
									<div class="repeat-name">
										<a href="#" class="repeat-nickname" onclick="">${replyItem.nickname }</a>
									</div>
									<div class="repeat-date">
										${replyItem.date }
									</div>
									
								</div>
								
								<div class="repeat-text">
									<c:if test="${replyItem.pointer ne '0' }">
									
									<c:forEach var="entry" items="${reply }">
										<c:if test="${entry.idx eq replyItem.pointer }">
											<a href="#" class="nickname" style="margin-right:20px";>${entry.nickname }</a>	
										</c:if>
									</c:forEach>
									
									</c:if>
									 
									<p style="display:inline-block;">${replyItem.content }</p>
								</div>
								
								<div class="repeat-footer">
									<a href="javascript:;" class="reply">답글쓰기</a>
								</div>
							
							</div>
						</div>
						
						</c:if>
					</c:forEach>
				
					</c:forEach>
				
				</div>
			</div>
			
			
		</div>
		
		
		
		
	</div>
	
	<div class="footer">
	
	</div>
	</div>
  	<!-- Optional JavaScript -->
    <!-- 먼저 jQuery가 오고 그 다음 Popper.js 그 다음 Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>