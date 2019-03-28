/**
 * 
 */

var script = document.createElement('script');

script.src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js";
script.type = "text/javascript";
document.getElementsByTagName("head")[0].appendChild(script);



$(function(){
	$(".IngameBtn").click(function(){
		
		var node = $(this).parents(".profile").next();
		
		
		var summonerId = $(this).parents(".profile").find("#summoner_id").val();
		
		
		
		$.ajax({
			async:true,
			type : "POST",
			data : summonerId,
			url : "/gameInfo",
			dataType : "json",
			contentType: "application/json; charset=UTF-8",
			success: function(data){
				//현재 게임중이 아닐떄 처리.
				
				var players = data.CurrentPlayers;
				var banned = data.bannedchampions;
				var time = data.time;
				
				var html = "";


				
				html +="<div class='Content'>";
				html +="<div class='Gametitle'>";

				html +="<span class='gameQueueType'>솔랭</span>";
				html +="<span class='gameMap'>소환사의협곡</span>";
				html +="<span class='gameTime'>"+time+"</span>";
				
				html +="</div>";
				html +="<div class='tableTeam'>";
				html +="<table class='Table blueteam'>";
				html +="<colgroup>";
				
				html +="<col width='40'>";
				html +="<col width='20'>";
				html +="<col width='20'>";
				html +="<col width='120'>";
				html +="<col width='30'>";
				html +="<col width='100'>";
				
				
				html +="</colgroup>";
				
				html +="<thead class='Header'>";
				html +="<tr class='Row'>";
				html +="<th class='teamName' colspan='2'>블루팀</th>";
				html +="<th></th>";
				html +="<th></th>";
				html +="<th></th>";
				html +="<th></th>";
				
				
				
				
				html +="</tr>";
				html +="</thead>";
				html +="<tbody class='Body'>";
				
				
				
				
				for(i=0; i<5; i++){
					var player = players[i];
					
					
					html +="<tr class='Row'>";
					html +="<td class='Champion'>";
					html +="<div class='champ'>";
					html +="<img src='"+player.champ.id+"'>";
					html +="</div>";
					html +="</td>";
					html +="<td class='SummonerSpell'>";
					html +="<img src='"+player.spell1.id+"'>";
					html +="<img src='"+player.spell2.id+"'>";
					html +="</td>";
					html +="<td class='Rune'>";
					html +="<img src='"+player.primaryRune.icon+"'>";
					html +="<img src='"+player.subRune.icon+"'>";
					
					html +="</td>";
					html +="<td class='SummonerName'>";
					html +="<a href='#'>"+player.summonerName+"</a>";
					html +="</td>";
					
					html +="<td class='Tier'>";
					html +="<img src='/resources/img/emblem/"+player.tier+"_Emblem.png'>";
					html +="</td>";
					
					html +="<td class='TierInfo'>";
					html +="<div>";
					html +="<span>"+player.tier+"</span>";
					html +="<span>"+" "+player.rank+"</span><span>"+" ("+player.leaguePoints+"LP)"+"</span></div>";
					
					html +="</tr>"
				}
				
				html +="</tbody>";
				
				
				
				html+="</table>";
				
				html +="<table class='Table redteam'>";
				html +="<colgroup>";
				
				html +="<col width='40'>";
				html +="<col width='20'>";
				html +="<col width='20'>";
				html +="<col width='120'>";
				html +="<col width='30'>";
				html +="<col width='100'>";
				
				
				html +="</colgroup>";
				
				html +="<thead class='Header'>";
				html +="<tr class='Row'>";
				html +="<th class='teamName' colspan='2'>레드팀</th>";
				html +="<th class=''></th>";
				html +="<th class=''></th>";
				html +="<th class=''></th>";
				html +="<th class=''></th>";
				
				
				
				html +="</tr>";
				html +="</thead>";
				html +="<tbody class='Body'>";
				
				
				
				
				for(i=5; i<10; i++){
					var player = players[i];
					
					
					html +="<tr class='Row'>";
					html +="<td class='Champion'>";
					html +="<div class='champ'>";
					html +="<img src='"+player.champ.id+"'>";
					html +="</div>";
					html +="</td>";
					html +="<td class='SummonerSpell'>";
					html +="<img src='"+player.spell1.id+"'>";
					html +="<img src='"+player.spell2.id+"'>";
					html +="</td>";
					html +="<td class='Rune'>";
					html +="<img src='"+player.primaryRune.icon+"'>";
					html +="<img src='"+player.subRune.icon+"'>";
					
					html +="</td>";
					html +="<td class='SummonerName'>";
					html +="<a href='#'>"+player.summonerName+"</a>";
					html +="</td>";
					
					html +="<td class='Tier'>";
					html +="<img src='/resources/img/emblem/"+player.tier+"_Emblem.png'>";
					
					html +="</td>";
					
					html +="<td class='TierInfo'>";
					
					html +="<div>";
					html +="<span>"+player.tier+"</span>";
					html +="<span>"+" "+player.rank+"</span><span>"+' ('+player.leaguePoints+'LP)'+"</span></div>";
					
					
					
					html +="</td>";
					
					
					html +="</tr>"
				}
				
				html +="</tbody>";
				
				
				
				html+="</table>";
				html+="</div>";	
				html+="<div class='bannedchamp'>";
				html +="<div class='blueBanned'>";
				for(i=0; i<5; i++){
					html += "<img src='"+banned[i].id+"'>";
					
					
					
					
				}
				html +="</div>";
				
				html +="<span>밴목록</span>"
				
				html +="<div class='redBanned'>";
				for(i=5; i<10; i++){
					html += "<img src='"+banned[i].id+"'>";
				}
				html +="</div>";
				
				html+="</div>";
				
				
				html +="</div>";
				
				
				node.html(html);
				
				
			
			
			
			},error:function(request,status,error){
				var html = "";
				
				html +="<div class='Content'>";
				
				html +="<div class='currentNotGame'>";
				html +="<span>현재 게임중이 아닙니다.</span>";
				
				
				
				html +="</div>";
				html +="</div>";
				
				node.html(html);
				
				
				
			}
			
			
			
			
		});
		
		
		
		
		
		
	});
	
	
	
	
});


