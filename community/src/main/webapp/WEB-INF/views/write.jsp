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
	
	<link rel="stylesheet" type="text/css" href="resources/css/Community.css">
	
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
	
	
       
</head>
	<body>
	
	<jsp:include page="layout_header.jsp" flush="false"/>
	<div class="l-wrap">
	<div class="main-content">
		
		<div class="side-bar">
			
			<c:choose>
				<c:when test="${sessionScope.user ne null }">
				</c:when>
				<c:otherwise>
					<div class="login-btn">
						<a href="/join" class="button">로그인</a>
					</div>
				</c:otherwise>
			</c:choose>
			
		
			<div class="sidebar-menu">
				<ul class="sidebar-items">
					<li>
						<a href="">
							전체
						</a>
					</li>
				
				</ul>
			
			
			
			</div>
		
		</div>
		<div class="content">
			<div class="article-header">
				<span class="header-title">글쓰기</span>
			</div>
			
			
			<form action="/insert" method="post" id="article-form" class="article-form">
			<div class="article-title">
				<input type="text" name="title" placeholder="제목을 입력해 주세요"
											class="form-control" id="title" style="border-radius:0px;">
			</div>
			<input type="hidden" name="userid" value="${sessionScope.user.userid}">
			<input type="hidden" name="userid" value="${sessionScope.user.nickname}">
			<input type="hidden" id="image1" name="image">
			
			<div class="article-content">
				
				<textarea id="content_text" name="content_text" rows="20" cols="100"></textarea>
				
				<div class="writeBtn">
					<input type="button" class="cancelbtn"value="취소">
					<input type="button" id="writebtn" name="writebtn" value="저장">					
				</div>
			</div>
			</form>
			
		</div>
		
		</div>
	</div>
  			
	<script>
	$(function(){
		
		
		var oEditors=[];
		nhn.husky.EZCreator.createInIFrame({
			
			
			oAppRef: oEditors,
			elPlaceHolder: "content_text",
			sSkinURI: "<%=request.getContextPath()%>/resources/editor/SmartEditor2Skin.html",
			
			htParams:{
				
				
				bUseToolbar:true,
				bUseVerticalResizer:true,
				bUseModeChanger:false,
			}
		});
		
		
		
		
		
		$("#writebtn").click(function(){
  			
  			
  			oEditors.getById["content_text"].exec("UPDATE_CONTENTS_FIELD",[]);
  			
  			
  			
  			
  			var contents = $("iframe").contents().find("#se2_iframe").contents().find(".se2_inputarea");
  			var image = contents.find("img");
  			var imgsrc = {};
  			
  			if(image.length){	
	  			image.each(function(index){
	  				imgsrc["key"+index] = $(this).attr("src");
	  			});
	  			
	  			$("#image1").val(JSON.stringify(imgsrc));
	  			
	  		}
  			
  			/* if(image){
  				alert("exist");
  				alert(image);
  			}else{
  				alert("not");
  			}
  			 */
  			
  			$("#article-form").submit();
  			 
  			
  		});
	});
  	
  		
 
  	</script>
  	<!-- Optional JavaScript -->
    <!-- 먼저 jQuery가 오고 그 다음 Popper.js 그 다음 Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>