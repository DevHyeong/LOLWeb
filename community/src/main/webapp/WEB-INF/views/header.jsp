<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">





<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	
	<style>
		
		.search-form{
			display:inline-block;
			width:750px;
			
			padding-bottom: 5px;
		
		}
		
		.login-btn{
			
		
		}
			
		
		.search-content{
			padding: 20px 15px 10px 60px;
		}
		
		.search-tag{
			padding-left:5px;
			width:500px; 
			display:inline-block;
			height:30px;
		
		}
		.search-btn{
			width:50px;
			height:30px;
			background-color:#007bff;
			border-color:#007bff;
			color:#fff;
		
		}
		
		.menu{
			background-color:#5E5E5E;
			border-color:#5E5E5E;
		}
		
		.menu-header{
			
			list-style:none;
		}
		
		.menu-list{
			display:inline-block;
			line-height:20px;
			font-size:15px;
		
		}
		
		.menu-item{
			border-bottom: 2px solid #5E5E5E;
			
		}
		.menu-item:hover{
			border-bottom: 2px solid #D5D5D5;
			
		}
		.menu-item-active{
			border-bottom: 2px solid #D5D5D5;
			
		}
		
		.menu-link{
			color:#fff !important;
		}
	
	</style>
	
	
	<script>
	$(document).ready(function(){
		
		
		$(".menu-link").click(function(){
			/*var parentNode = $(this).parents("ul.nav");
			alert(parentNode);
			var btn = parentNode.childern("li");
			btn.removeClass("menu-item-active"); */
			alert("동작");
			$(this).parent().addClass("menu-item-active");
			
			
			
		});
		
		
		
		
	});
	
	
	
	</script>
	

</head>
<body>

	<div>
		<div class="search-form">
			<div class="search-content">
				<form action="/find" method="get" role="search" style="margin-top:10px;">
			        
			          <input type="text" name="summoner" class="search-tag">
			          <button type="submit" class="search-btn">
			          	<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			          </button>
			        
			        
		      	</form>
		      </div>
		</div>
		
		<div class="login-btn">
			
		
		</div>
		
	</div>
	
	
	<nav class="navbar navbar-default">
      <div class="container-fluid menu">
        <!-- Brand and toggle get grouped for better mobile display -->
       

    <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="menu-item">
          	<a href="/" class="menu-link">홈 
          	</a>
          </li>
          <li class="menu-item">
          	<a href="/Rank" class="menu-link">랭킹</a></li>
          <li class="menu-item">
            <a href="/community" class="menu-link">커뮤니티 </a>
            
          </li>
        </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>




	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
 

</body>
</html>