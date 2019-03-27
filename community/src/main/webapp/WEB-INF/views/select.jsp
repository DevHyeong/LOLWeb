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

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/index.css?after" type="text/css">
	
</head>
	<body>
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
					        		<a href="/community/login" class="link">
					        			<i class="fa fa-sign-in">
					        			</i>
					        			<span class="nav-sidebar-label">로그인</span>
					        		
					        		
					        		</a>
					        	</li>
					        	
					        	
					        	<li>
					        		<a href="/community/join" class="link">
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
					        		<a href="#" class="link">
					        			<i class="nav-icon fa fa-database">
					        			</i>
					        			
					        			<span class="nav-sidebar-label nav-sidebar-category-label">커뮤니티</span>
					        		</a>
					        	
					        	</li>
					        
					        
					        
					        </ul>
				
				        
				    </nav>
					
					
					<div id="article" class="content" role="main">
						<div class="nav" role="navigation">
						
						
						
						
						
						</div>
						<div class="panel panel-default clearfix">
						
							${board.idx }<br>
							${board.title }<br>
						
						
						
						
						
						</div>
						
					
					
					
					
					
					
					
					
					
					</div>
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
			</div>
			
			
			
			
			
			
		</div>	
		

		








    <!-- Optional JavaScript -->
    <!-- 먼저 jQuery가 오고 그 다음 Popper.js 그 다음 Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>