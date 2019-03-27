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
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/index.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/create.css" type="text/css">
	
	
	
	

  	
</head>
<body>

<script>
	function move(){
		if(confirm("내용이 삭제됩니다. 괜찮으신가요?")){
			
			location.href="/";
				
		};
	}
</script>
	
  		<div class="layout-container">
			
			<div class="wrapper">
	    <!-- Sidebar -->
				   <nav id="sidebar">
				       <div class="sidebar-header">
				          
				        </div>
				        
				        
				        <div class="nav-user nav-sidebar">
				        
				        <c:set var="userid" value="${ sessionScope.user.userid}"/>
				        
				        <c:choose>
				        
				        	<c:when test="${userid eq null }">
					        <ul class="list-unstyled">
					        	<li>
					        		<a href="/login" class="link">
					        			<i class="fa fa-sign-in">
					        			</i>
					        			<span class="nav-sidebar-label">로그인</span>
					        		
					        		
					        		</a>
					        	</li>
					        	
					        	
					        	<li>
					        		<a href="/join" class="link">
					        			<i class="fa fa-user"></i>
					        				<span class="nav-sidebar-label">회원가입</span>
					        			
					        		
					        		
					        		</a>
					        	
					        	</li>
					        
					        </ul>
					        </c:when>
					        <c:otherwise>
					        <div class="avatar avatar-medium clearfix">
					        	<a href="#" class="avatar-photo">
					        		<img src="#">
					        	</a>
					        	
					        	<div class="avatar-info">
					        		<a class="nickname" href="#"></a>
					        	</div>
					         
					        </div>
					        <div class="nav-user-action">
					        	<div class="nav-user-func">
					        		<a href="#" id="user-func" data-toggle="popover" data-trigger="click">
					        			<i id="user-func-icon" class="fa fa-cog">
					        			</i>
					        		</a>
					        	
					        	</div>
					        	
					        	<div class="nav-user-func">
					        		<a href="#" id="user-notification" data-toggle="popover" data-trigger="click"
					        		tabindex="0">
					        			<i id="user-notification-icon" class="fa fa-bell">
					        			
					        			</i>
					        			<span id="user-notification-count" class="badge notification" style="display:none;"></span>
					        		
					        		
					        		</a>
					        	</div>
					        	
					        
					        </div>
					        	
					        	
					        	
					        	
					        
					        </c:otherwise>
					        	
					        
					        
					        </c:choose>
					        </div>
					        
					        <ul class="nav nav-sidebar nav-main">
					        	<li>
					        		<a href="javascript:void(0);" class="link" onclick="move(); return false;">
					        			<i class="nav-icon fa fa-database">
					        			</i>
					        			
					        			<span class="nav-sidebar-label nav-sidebar-category-label">커뮤니티</span>
					        		</a>
					        	
					        	</li>
					        
					        
					        
					        </ul>
				
				        
				    </nav>
					
					<div id="article-create" class="article-content">
						<div class="content-header">
							<h3>새 글 쓰기</h3>
						
						</div>
						
						<div class="panel panel-default clearfix">
							<div class="panel-heading clearfix">
								<div class="avatar avatar-medium clearfix pull-left">
									<a href="#" class="avatar-photo">
										<img src="#">
									</a>
									
									<div class="avatar-info">
										<a class="nickname" href="#">${sessionScope.user.nickname}</a>
									
									
									</div>
									
								
								
								</div>
							
							</div>
							
							<div class="panel-body">
								<form action="/insert" method="post" id="article-form" class="article-form"
								role="form">
								<!-- userid,title,  -->
								<input type="hidden" name="userid" value="${sessionScope.user.userid}">
								
								
								<fieldset class="form">
									<div class="form-group has-feedback">
										<div>
											<input type="text" name="title" placeholder="제목을 입력해 주세요"
											class="form-control" id="title">
										</div>
									</div>
									<div class="form-group has-feedback">
										<textarea id="content_text" name="content_text" rows="20" cols="100"></textarea>
										<input type="button" id="writebtn" name="writebtn" value="저장">
									</div>
								
								</fieldset>
									
								</form>
							
							
							</div>
							
							
						
						</div>
					
					
					
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
  			
  			$("#article-form").submit();
  		});
	});
  	
  		
 
  	</script>

    <!-- Optional JavaScript -->
    <!-- 먼저 jQuery가 오고 그 다음 Popper.js 그 다음 Bootstrap JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  
  
  
  
  
  </body>
</html>