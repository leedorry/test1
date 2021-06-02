$(function(){
	getJson();
});

// json 데이터 읽어오는 함수

function getJson(){
	$.getJSON("json/Seodaemun.json", function(data){
		$.each(data, function(key, val){
			if(key=="DESCRIPTION"){
				$("table").attr("border","1");
				$("thead").append(
					"<tr>" +
						"<th>" + val.BPLCNM + "</th>" +
						"<th>" + val.RDNWHLADDR +"</th>" +
						"<th>" + val.SITEWHLADDR + "</th>" +
						"<th>" + val.SITETEL + "</th>" +
						"<th>" + val.X + ", " + val.Y + "</th>" +
					"</tr>"
				);
			}else{
				console.log(key);
				var string1 = "영업";
				var string2 = "과자점";
				var string3 = "떡카페";
				var string4 = "아이스크림";
				var string5 = "전통찻집";
				var string6 = "커피숍";
				
				var list1 = val;				
					
				if(list1[8]==string1){
					if(list1[32]==string2 || list1[32]==string3 || list1[32]==string4 || list1[32]==string5 || list1[32]==string6){
						var list = val;
						for(var i=0; i<list.length; i++){
							var str = list[i];
							$("tbody").append(
								"<tr>"+
										"<td>"+ str.bplcnm + "</td>"+
										"<td>" + str.sitewhladdr +"</td>" +
										"<td>"+ str.rdnwhladdr + "</td>" +
										"<td>" + str.sitetel + "</td>" +
										"<td>" + str.x +", " + str.y + "</td>" +
								"</tr>"
							);
						}
					}
				}
			}
		});
			
	});
}