<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  

<%@ page session="true" %>
    
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


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
	<link rel="stylesheet" type="text/css" href="resources/css/CurrentGameInfo.css">
	
	
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	
	
    <!-- Bootstrap CSS -->
	<style>
		
		.main-content{
			
			width:1000px;
			margin:0 auto;
			min-height:700px;
			padding: 50px 50px 120px 50px;
			
			
		}
		
		
		
		
		
		.profile{
			height:100px;
			margin-bottom:10px;
		
		}
		
		.profileIcon{
			display:inline-block;
			width:100px;
			margin-right:5px;
			
			
		}
		
		
		.profileInfo{
			display:inline-block;
			position: relative;
			vertical-align:top;
			margin-left:20px;
		}
		.profileName{
			padding-top:5px;
			font-size: 20px;
			font-weight:bold;
		}
		
		.SemiRound{
			padding:11px 14px 10px;
			border-radius:2px;
			font-size:14px;
		
		} 
		
		.Blue{
			border: 0px solid #1a78ae;
			background:#1f8ecd;
			color:#f2f2f2;
		
		}
		
		.IngameBtn{
			border: 1px solid #c6cbcb;
			background:#fff;
			color:#1f8ecd;
		
		}
		
		
		
		
		
		.tier-box{
			display:table;
			position:relative;
			padding:10px;
			border-radius:2px;
			border:1px solid #cdd2d2;
			margin-bottom:30px;
			
		}
		
		
		
		.tier-img{
			display:table-cell;
			width:135px;
			text-align:center;
		}
			
		
		.tier-info{
			display:table-cell;
			
			line-height:14px;
			font-size:12px;
		}
		
		
	
		

		.win{
			background-color:#a3cfec;
			border-color:#99b9cf;
			
		}
		
		.Fail{
			background-color:#e2b6b3;
			border-color:#cea7a7;
			
		}
		
		
		.GameWrap{
			display:table;
			width:700px;
			border-radius:3px;
			margin-bottom:8px;
			
		}
		
		
		
		.Game{
			
			
			
		
		
		}
		.Game>div{
			display:table-cell;
			height:96px;
			vertical-align:middle;
		
		}
		
		
		
		.Game>.players{
			width:176px;
			
		
		
		}
		
		
		.champImg{
			width:20px;
			height:20px;
			
		
		}
		
		.team{
			float:left;
			width:50%;
		
		
		}
		
		.Summoner{
			display:block;
			width:80px;
			height:18px;
			margin-left: 3px;
			text-align:left;
			white-space:nowrap;
		
		}
		
		.champImage{
		
			display:inline-block;
			vertical-align:middle;
			margin-right:3px;
			
		
		
		}
		
		.Game>.players>.team>.Summoner>.SummonerName{
			display:inline-block;
			max-width:60px;
			vertical-align:middle;
			font-size:11px;
			color:#555;
			
		
		}
		
		.Game>.players>.team>.Summoner>.SummonerName>.Link{
			display:block;
			color:inherit;
			text-decoration:none;
			text-overflow:ellipsis;
			white-space: nowrap;
			overflow:hidden;
		
		}
		
		
		
		
		<!-- -->
		
		
		
		
		.gameStats{
			width:70px;
			text-align:center;
			font-size:11px;
			
			line-height:16px;
		
		
		}
		
		.GameType{
			font-weight:bold;
			width:70px;
			white-space:nowrap;
			overflow:hidden;
			text-overflow:ellipsis;
			
		
		}
		
	
		
		
		.GameSettingInfo{
			width:100px;
			font-size:0;
		
		
		}
		
		
		
		.Game>.GameSettingInfo>.champ{
			
			display:inline-block;
			width:46px;
			height:46px;
			vertical-align:middle;
			border-radius:50%;
			overflow:hidden;
			
			
			
		
		}
		
		.Game>.GameSettingInfo>.champ>.champImg{
			display:block;
			width:100%;
			height:100%;
		
		
		}
		
		.Game>.GameSettingInfo>.SummonerSpell{
			display:inline-block;
			vertical-align:middle;
			margin-left:4px;
		
		
		
		}
		
		.Game>.GameSettingInfo>.SummonerSpell>.Spell{
			display:block;
			width:22px;
			height:22px;
			margin-top:2px;
			border-radius:2px;
			overflow:hidden;
			
		
		
		}
		.Game>.GameSettingInfo>.SummonerSpell>.Spell>.Image{
			display:block;
			width:100%;
			height:100%;
		
		
		}
		
		
		
		
		.Game>.GameSettingInfo>.Runes{
			display: inline-block;
			vertical-align:middle;
			margin-left:4px;
			
		
		
		}
		.Game>.GameSettingInfo>.Runes>.Rune{
			width:22px;
			height:22px;
		
		}
		
		.Game>.GameSettingInfo>.Runes>.Rune>.RuneImg{
			display:block;
			width:100%;
			height:100%;
			border-radius:50%;
		
		}
		
		
		.Game>.Items{
			width:114px;
		}
		
	
		
		.Game>.Items>.ItemList>.Item>.itemImg{
			width:100%;
			height:100%;
		
		}
		
		.Game>.Items>.ItemList{
			width:110px;
			margin: 0 auto;
		
		}
		
		.Game>.Items>.ItemList>.Item{
			display:inline-block;
			width:22px;
			height:22px;
			border-radius:3px;
			margin-top:2px;
			margin-right:2px;
			overflow:hidden;
			
			
		
		
		}
		
		
		
		.Game>.StatsButton{
			width:30px;
			text-align:center;
			border: 1px solid #000;
		}
		
		
		
		.statsBtn{
			
			cursor:pointer;
			
		
		
		}
		
		.Game>.StatsButton>.statsBtn>.btnClick{
			
			
			font-size:15px;
			
		}
		
		
		
		
		.Game>.KDA{
			font-size:13px;
			text-align:center;
			width:100px;
			
		
		}
		
		
		<!-- -->
		
		.Game>.Stats{
			width:90px;
			font-size:11px;
			text-align:center;
			line-height:18px;
			color:#555e5e;
		
		
		}
		
		
		
		.GameDetails>.GameDetailTable{
			width:100%;
			table-layout:fixed;
		}
		
		.GameDetailTable>colgroup>.ChampionImage{
			width:44px;
		}
		.GameDetailTable>colgroup>.SummonerSpell{
			width:18px;
		}
		.GameDetailTable>colgroup>.KeystoneMastery{
			width:18px;
		}
		.GameDetailTable>colgroup>.SummonerName{
			width:78px;
		}
		.GameDetailTable>colgroup>.Tier{
			width:65px;
		}
		.GameDetailTable>colgroup>.KDA{
			width:76px;
		}
		.GameDetailTable>colgroup>.Damage{
			width:66px;
		}
		.GameDetailTable>colgroup>.Damaged{
			width:66px;
		}
		.GameDetailTable>colgroup>.Ward{
			width:44px;
		}
		.GameDetailTable>colgroup>.CS{
			width:55px;
		}
		.GameDetailTable>colgroup>.Items{
			width:170px;
		}
		
		.GameDetailTable>.Header{
			border:solid 1px #cdd2d2;
			background-color: #fff;
		
		}
		
		.GameDetailTable>.Header>.Row>.HeaderCell{
			height:32px;
			color:#555e5e;
			font-size:12px;
			font-weight:normal;
			text-align:center;
			
		}
		
		.GameDetailTable>.Content>.Row>.Cell.ChampionImage{
			position:relative;
			padding-left:10px;
			padding-right:4px;
		
		}
		.GameDetailTable>.Content>.Row>.Cell{
			padding:3px 0;
			vertical-align:middle;
		}
		.GameDetailTable>.Content>.Row>.Cell.ChampionImage>a>.Image{
			display:block;
			width:32px;
			height:32px;
			border-radius:50%;
		}
		.GameDetailTable>.Content>.Row>.Cell.ChampionImage>.Level{
			position:absolute;
			left:0;
			bottom:-1px;
			width: 15px;
			height: 15px;
			color:#000;
			font-size:10px;
			font-family:"Tahoma";
			text-align:center;
			line-height:15px;
		}
		
		.GameDetailTable>.Content>.Row>.Cell.SummonerSpell>.Image{
			display:block;
			width:16px;
			height:16px;
			border-radius:2px;
		}
		
		.GameDetailTable>.Content>.Row>.Cell.Rune>.Image{
			display:block;
			width:16px;
			height:16px;
			border-radius:8px;
		
		}
		
		.GameDetailTable>.Content>.Row>.Cell.SummonerName{
			padding-left:5px;
			white-space:nowrap;
			text-overflow:ellipsis;
			overflow:hidden;
		
		
		}
		.GameDetailTable>.Content>.Row>.Cell.SummonerName>.Link{
			color:#555e5e;
			font-size:11px;
			text-decoration:none;
		}
		
		.GameDetailTable>.Content>.Row>.Cell.Tier{
			color:#555e5e;
			font-size:11px;
			text-align:center;
		}
		.GameDetailTable>.Content>.Row>.Cell.KDA{
			text-align:center;
			white-space:nowrap;
			font-size: 11px;
		
		}
		
		.GameDetailTable>.Content>.Row>.Cell.Tier{
			color:#555e5e;
			font-size:11px;
			text-align:center;
		
		}
		
		
		.GameDetailTable>.Content>.Row>.Cell.Damage{
			text-align: center;
		}
		
		.GameDetailTable>.Content>.Row>.Cell.Damage>.ChampionDamage{
			color:#555e5e;
			font-size:11px;
		
		}
		.GameDetailTable>.Content>.Row>.Cell.Damage>.Progress{
			width:50px;
			height: 8px;
			margin: 0 auto;
			border:1px solid #cdd2d2;
			background-color:#f2f2f2;
		}
		.GameDetailTable>.Content>.Row>.Cell.Damage>.Progress>.Fill{
			height: 8px;
			margin: -1px;
			border: 1px solid #c6443e;
			background-color:#ee5a52;
		}
		
		.GameDetailTable>.Content>.Row>.Cell.Damaged{
			text-align: center;
		}
		
		.GameDetailTable>.Content>.Row>.Cell.Damaged>.ChampionDamaged{
			color:#555e5e;
			font-size:11px;
		
		}
		.GameDetailTable>.Content>.Row>.Cell.Damaged>.Progress{
			width:50px;
			height: 8px;
			margin: 0 auto;
			border:1px solid #cdd2d2;
			background-color:#f2f2f2;
		}
		.GameDetailTable>.Content>.Row>.Cell.Damaged>.Progress>.Fill{
			height:100%;
			
			border: 1px solid #393;
			background-color:green;
		}
		
		
		
		
		
		
		.GameDetailTable>.Content>.Row>.Cell.Ward{
			text-align:center;
			color:#555e5e;
			font-size:11px;
		}
		.GameDetailTable>.Content>.Row>.Cell.CS{
			text-align: center;
			color:#777;
			font-size:11px;
		
		}
		.GameDetailTable>.Content>.Row>.Cell.Items{
			text-align:center;
			font-size:0;
		}
		
		.GameDetailTable>.Content>.Row>.Cell.Items>.Item{
			display:inline-block;
			width:22px;
			height:22px;
			vertical-align:middle;
		
		}
		.GameDetailTable>.Content>.Row>.Cell.Items>.Item>.Image{
			display:block;
			width:100%;
			height:100%;
			border-radius:3px;
		
		}
		
		
		.Box{
			border: 1px solid #cdd2d2;
			background: #f2f2f2;
			width:700px;
		}
		
		.GameMoreButton{
			display:block;
			height:50px;
			font-size:13px;
			line-height: 50px;
			text-align:center;
			text-decoration:none;
			color:#555e5e;
		
		}
		
		.ChampionImage>.Champ>.Image{
			width:100%;
			height:100%;
		
		
		}
		.ChampionImage>.Champ{
			width:30px;
			height:30px;
			border-radius:50%;
			overflow:hidden;
		}
		
		
		
		
		
	
	</style>
	<script>
	
	
		
		function gamedetails(id,data){
			
			var gameId = String(data);
			var childNode = id.firstElementChild;
			var detailsNode = id.parentNode.parentNode.nextElementSibling;
			
			if(childNode.textContent == "▲"){
				childNode.textContent = "▼";
				while(detailsNode.firstChild){
					detailsNode.removeChild(detailsNode.firstChild);
				}
				
				
			}else{
				childNode.textContent = "▲";
				
				//detailsNode.style.display="none";
			
			
			
			
			
			
				$.ajax({
					//alert(typeof(gameId));
					async:true,
					type : "POST",
					data : gameId,
					url : "/gameDetails",
					dataType : "json",
					contentType: "application/json; charset=UTF-8",
					success: function(data){
						
						
						var gamePlayers = data.gameDetails;
						var html="";
						
						
						
						
						if(gamePlayers[0].teamResult == "Win" ){
							
							html += "<table class='GameDetailTable win'>";
						}else{
							html += "<table class='GameDetailTable Fail'>";
						}
						
						
						
						html += "<colgroup>";
						html += "<col class='ChampionImage'>";
						html +="<col class='SummonerSpell'>";
						html += "<col class='KeystoneMastery'>";
						html += "<col class='SummonerName'>";
						html += "<col class='Tier'>";
						html += "<col class='KDA'>";
						html += "<col class='Damage'>";					
						html += "<col class='Damaged'>";
						html += "<col class='Ward'>";
						html += "<col class='CS'>";
						html += "<col class='Items'>";
						
						
						
						
						html +="</colgroup>";
						html +="<thead class='Header'>";
						html +="<tr class='Row'>";
						html +="<th class='HeaderCell' colspan='4'></th>";
						
						html +="<th class='HeaderCell'>티어</th>";
						html +="<th class='HeaderCell'>KDA</th>";
						html +="<th class='HeaderCell'>딜량</th>";
						html +="<th class='HeaderCell'>피해량"
						html +="<th class='HeaderCell'>와드</th>";
						html +="<th class='HeaderCell'>CS</th>";
						html +="<th class='HeaderCell'>아이템</th>";
						html +="</tr>";
						html +="</thead>";
						
						
						html +="<tbody class='Content'>";
						for(i=0; i<5; i++){
							var gamePlayer = gamePlayers[i];
							
							
							html +="<tr class='Row'>";
							html +="<td class='ChampionImage Cell'>";
							html +="<div class='Champ'>";
							html +="<img src='"+gamePlayer.champ.id+"' class='Image'>";
							html +="</div>";
							html +="<div class='Level'>"+gamePlayer.champLevel+"</div>";
							html +="</a>";
							html +="</td>";
							
							html +="<td class='SummonerSpell Cell'>";
							html +="<img src='"+gamePlayer.spell1.id+"' class='Image'>";
							html +="<img src='"+gamePlayer.spell2.id+"' class='Image'>";
							html +="</td>";
							
							html +="<td class='Rune Cell'>";
							html +="<img src='"+gamePlayer.primaryRune.icon+"' class='Image'>";
							html +="<img src='"+gamePlayer.subRune.icon+"' class='Image'>";
							html +="</td>";
							
							html +="<td class='SummonerName Cell'>";
							html +="<a href='#' class='Link'>"+gamePlayer.summonerName+"</a>";
							html +="</td>";
							html +="<td class='Tier Cell'>Gold 3</td>";
							
							html +="<td class='KDA Cell'>";
							html +="<span class='KDARatio'>"+gamePlayer.ratio+"</span>";
							html +="<div class='KDA'>";
							html +="<span>"+gamePlayer.kills+"</span>";
							html +=" / ";
							html +="<span>"+gamePlayer.deaths+"</span>";
							html +=" / ";
							html +="<span>"+gamePlayer.assists+"</span>";
							html +=" (";
							html +="<span>"+gamePlayer.killRate+"%</span>";
							html +=")";
							html +="</div>";
							html +="</td>";
							
							html +="<td class='Damage Cell'>";
							html +="<div class='ChampionDamage'>"+gamePlayer.damageDealt+"</div>";
							html +="<div class='Progress'>";
							html +="<div class='Fill' style='width: "+gamePlayer.damageDealtPer+"%;'></div>";
							html +="</div>";
							html +="</td>";
							
							html +="<td class='Damaged Cell'>";
							html +="<div class='ChampionDamaged'>"+gamePlayer.damageTaken+"</div>";
							html +="<div class='Progress'>";
							html +="<div class='Fill' style='width:"+gamePlayer.damageTakenPer+"%;'></div>";
							html +="</div>";
							html +="</td>";
							
							html +="<td class='Ward Cell'>";
							html +="<div class='Buy'>";
							html +="<span>"+gamePlayer.visionWardsBoughtInGame+"</span>";
							html +="</div>";
							html +="<div class='Stats'>";
							html +="<span>"+gamePlayer.wardsPlaced+"</span>";
							html +=" / ";
							html +="<span>"+gamePlayer.wardsKilled+"</span></div>";
							html +="</td>";
							
							html +="<td class='CS Cell'>";
							html +="<div class='CS'>"+gamePlayer.cs+"</div>";
							html +="<div class='CSPerMinute'>"+gamePlayer.csRatio+"</div>";
							html +="</td>";
							
							html +="<td class='Items Cell'>";
							for(j=0; j<gamePlayer.items.length; j++){
								var item = gamePlayer.items[j];
								html +="<div class='Item'>";
								html +="<img src='"+item.id+"' class='Image'></div>";
								
							}
							html +="</td>";
							
						
						}
						
						if(gamePlayers[5].teamResult == "Win"){
							html += "<table class='GameDetailTable win'>";
						}else{
							html += "<table class='GameDetailTable Fail'>";
							
						}
						
						
						html += "<colgroup>";
						html += "<col class='ChampionImage'>";
						html +="<col class='SummonerSpell'>";
						html += "<col class='KeystoneMastery'>";
						html += "<col class='SummonerName'>";
						html += "<col class='Tier'>";
						html += "<col class='KDA'>";
						html += "<col class='Damage'>";					
						html += "<col class='Damaged'>";
						html += "<col class='Ward'>";
						html += "<col class='CS'>";
						html += "<col class='Items'>";
						
						
						
						
						html +="</colgroup>";
						html +="<thead class='Header'>";
						html +="<tr class='Row'>";
						html +="<th class='HeaderCell' colspan='4'></th>";
						
						html +="<th class='HeaderCell'>티어</th>";
						html +="<th class='HeaderCell'>KDA</th>";
						html +="<th class='HeaderCell'>딜량</th>";
						html +="<th class='HeaderCell'>피해량"
						html +="<th class='HeaderCell'>와드</th>";
						html +="<th class='HeaderCell'>CS</th>";
						html +="<th class='HeaderCell'>아이템</th>";
						html +="</tr>";
						html +="</thead>";
						
						
						html +="<tbody class='Content'>";
						for(i=5; i<10; i++){
							var gamePlayer = gamePlayers[i];
							
							
							html +="<tr class='Row'>";
							html +="<td class='ChampionImage Cell'>";
							html +="<div class='Champ'>";
							html +="<img src='"+gamePlayer.champ.id+"' class='Image'>";
							html +="</div>";
							html +="<div class='Level'>"+gamePlayer.champLevel+"</div>";
							html +="</a>";
							html +="</td>";
							
							html +="<td class='SummonerSpell Cell'>";
							html +="<img src='"+gamePlayer.spell1.id+"' class='Image'>";
							html +="<img src='"+gamePlayer.spell2.id+"' class='Image'>";
							html +="</td>";
							
							html +="<td class='Rune Cell'>";
							html +="<img src='"+gamePlayer.primaryRune.icon+"' class='Image'>";
							html +="<img src='"+gamePlayer.subRune.icon+"' class='Image'>";
							html +="</td>";
							
							html +="<td class='SummonerName Cell'>";
							html +="<a href='#' class='Link'>"+gamePlayer.summonerName+"</a>";
							html +="</td>";
							html +="<td class='Tier Cell'>Gold 3</td>";
							
							html +="<td class='KDA Cell'>";
							html +="<span class='KDARatio'>"+gamePlayer.ratio+"</span>";
							html +="<div class='KDA'>";
							html +="<span>"+gamePlayer.kills+"</span>";
							html +=" / ";
							html +="<span>"+gamePlayer.deaths+"</span>";
							html +=" / ";
							html +="<span>"+gamePlayer.assists+"</span>";
							html +=" (";
							html +="<span>"+gamePlayer.killRate+"%</span>";
							html +=")";
							html +="</div>";
							html +="</td>";
							
							html +="<td class='Damage Cell'>";
							html +="<div class='ChampionDamage'>"+gamePlayer.damageDealt+"</div>";
							html +="<div class='Progress'>";
							html +="<div class='Fill' style='width: "+gamePlayer.damageDealtPer+"%;'></div>";
							html +="</div>";
							html +="</td>";
							
							html +="<td class='Damaged Cell'>";
							html +="<div class='ChampionDamaged'>"+gamePlayer.damageTaken+"</div>";
							html +="<div class='Progress'>";
							html +="<div class='Fill' style='width:"+gamePlayer.damageTakenPer+"%;'></div>";
							html +="</div>";
							html +="</td>";
							
							html +="<td class='Ward Cell'>";
							html +="<div class='Buy'>";
							html +="<span>"+gamePlayer.visionWardsBoughtInGame+"</span>";
							html +="</div>";
							html +="<div class='Stats'>";
							html +="<span>"+gamePlayer.wardsPlaced+"</span>";
							html +=" / ";
							html +="<span>"+gamePlayer.wardsKilled+"</span></div>";
							html +="</td>";
							
							html +="<td class='CS Cell'>";
							html +="<div class='CS'>"+gamePlayer.cs+"</div>";
							html +="<div class='CSPerMinute'>"+gamePlayer.csRatio+"</div>";
							html +="</td>";
							
							html +="<td class='Items Cell'>";
							for(j=0; j<gamePlayer.items.length; j++){
								var item = gamePlayer.items[j];
								html +="<div class='Item'>";
								html +="<img src='"+item.id+"' class='Image'></div>";
								
							}
							html +="</td>";
							
						
						}
						
						
						
						
						
						
						detailsNode.innerHTML = html;
						
						
						
						
					
						
						
					},error:function(request,status,error){
						
						alert("error");
					}
				});
				
			}
		}
		$(function(){
			$(".RefeshBtn").click(function(){
				location.reload();

				$(this).text("갱신 불가");
				
				
			});
			
			
		});
		
		
		
	
	</script>

	
	    
</head>
	<body>
	<script type="text/javascript" src="resources/js/ingame.js"></script>
	<jsp:include page="layout_header.jsp" flush="false"/>
	
	<div class="main-content">
	<c:if test="${tier_info ne null }">
		<div class="profile">
			<div class="profileIcon">
				<img src=${Icon } style="width:100px; height:100px;">
				
			</div>
			
			<div class="profileInfo">
				<div class="profileName">
					
					<span>${summoner.name }</span>
					<input type="hidden" id="summoner_id" value="${summoner.id }">
				</div>
				<div style="padding-left:3px;">
					<span>Level ${summoner.summonerLevel }</span>
				
				</div>
				
				<div style="margin-top:7px;">
					<button class="SemiRound RefeshBtn Blue">전적 갱신</button>
					<button class="SemiRound IngameBtn">인게임 정보</button>
				
				</div>
				
				
			</div>
			
			
		</div>
		
		<div class="CurrentGameInfo"></div>
		
		
		</c:if>
		<c:if test="${tier_info ne null }">
		<div class="tier-box">
		
		
			<div class="tier-img">
				<img src="/resources/img/emblem/${tier_img }" style="width:104px; height:104px; margin:-5px 0 -10px 0;">
			</div>
			<div class="tier-info">
			
				<c:choose>
					<c:when test="${tier_info eq 'unranked' }">
					<div>
						<span style="color:#1f8ecd;">Unranked</span>
					</div>
					
					</c:when>
					
					<c:otherwise>
					<div>
						<span style="color:#1f8ecd;">${tier_info.tier} ${tier_info.rank }</span>
					</div>
					<div>
						리그포인트 : <span style="font-weight:bold;">${tier_info.leaguePoints }LP</span>
					</div>
					<div>
						<span>${tier_info.wins+tier_info.losses }전</span>
						<span>${tier_info.wins }승 </span>
						<span>${tier_info.losses }패</span>  
						<span>(${tier_info.average }%)</span>
					</div>
					</c:otherwise>
				</c:choose>
				
				
				
			</div>
		
		
		
		</div>
		</c:if>
		
		
		
		<c:if test="${match ne null }">
		<div class="GameList">
		
			<c:forEach var="game" items="${match }">
				
					<div class="GameWrap">
					<c:choose>
						<c:when test="${game.result eq '승리'}">
							<div class="Game win" style="background-color:#a3cfec; border-color:#99b9cf;">
						</c:when>	
						<c:otherwise>
							<div class="Game Fail">
						</c:otherwise>
					
					</c:choose>
					<div class="gameStats" style="width:70px; text-align:center; font-size:11px; line-height:16px;">
						<div class="GameType">
							${game.gameMode }
						</div>
						<div class="TimeStamp">
							<span>${game.gameCreation }</span>
						</div>
						<div class="GameResult">
							${game.result }
						</div>
						<div class="GameLength">
							${game.gameTime }
						</div>
						
						
					
					
					</div>
					
					<div class="GameSettingInfo" style="width:120px;">
						<div class="champ">
					
							<img src=${game.champ.id } class="champImg">
					
						</div>
						
						<div class="SummonerSpell">
							<div class="Spell">
								<img src="${game.spell1.id }" class="Image">
							</div>
						
							<div class="Spell">
								<img src="${game.spell2.id }" class="Image">
							</div>
							
							
							
						
						</div>
						<div class="Runes">
							<div class="Rune">
								<img src="${game.primaryRune.icon }" class="RuneImg">
								
							</div>
							<div class="Rune">
								<img src="${game.subRune.icon }" class="RuneImg">
								
							</div>
							
							
							
							
						</div>
					</div>
					
					<div class="KDA">
						<div class="kda">
							<span>${game.kills }</span>
							 / 
							<span>${game.deaths }</span>
							 / 
							<span>${game.assists }</span>
						</div>
						
						
						<div class="killRate">
							<span>킬관여 ${game.killRate }%</span>
						</div>
						<div class="kdaRatio">
							<span>평점 ${game.ratio} </span>
							
						</div>
					
					</div>
					
					<div class="Stats">
					
						<div class="champLevel">
							<span>레벨 ${game.champLevel }</span>
						</div>
						
						<div class="CS">
							<span>CS ${game.cs }(${game.csRatio })</span>
						</div>
					
						
						
					</div>
					
					
					
					<div class="Items">
							<div class="ItemList">
							<c:forEach var="item" items="${game.items }">
								<div class="Item">
									<c:choose>
										<c:when test="${empty item.id }">
											<img src="/resources/img/item/3637.png" class="itemImg" style="width:100%;height:100%;">
										
										</c:when>	
										<c:otherwise>
											<img src="${item.id }" class="itemImg" style="width:100%;height:100%;">
										</c:otherwise>
									
									</c:choose>
									
						
								</div>
							</c:forEach>
							</div>
						</div>
					
					
					
					
					
					
					
					
					<div class="players">
						<div class="team">
							<c:forEach var="player" items="${game.player }" begin="0" end="4" step="1">
								<div class="Summoner">
									<div class="champImage">
										<img src=${player.id } class="champImg">
									
									
									</div>
									<div class="SummonerName">
										<a href="#" class="Link">${player.summonername }</a>
									
									</div>
								
								</div>
								
								
								
							</c:forEach>
						</div>
						
						<div class="team">
							<c:forEach var="player" items="${game.player }" begin="5" end="9" step="1">
								<div class="Summoner">
									<div class="champImage">
										<img src=${player.id } class="champImg">
									
									
									</div>
									<div class="SummonerName">
										<a href="#" class="Link">${player.summonername }</a>
									
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="StatsButton">
					
							<a href="javascript:;" class="statsBtn" onclick="gamedetails(this,${game.gameId});">
							<span class="btnClick">▼</span></a>
						
					
					</div>
				</div>
				<div class="GameDetails">
				</div>
				</div>
			</c:forEach>
			
			
		
		
		</div>
		
		
		<div class="Box">
			<a href="javascript:;" onclick="loadMoreGame(this)" class="GameMoreButton">더보기</a>
		</div>
		</c:if>
			
		
		
		</div>
		
		
		
		
	
	
	
	
	
	
	</div>	
  	
  	<!-- Optional JavaScript -->
    <!-- 먼저 jQuery가 오고 그 다음 Popper.js 그 다음 Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>