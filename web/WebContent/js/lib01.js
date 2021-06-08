$(function() {
	getJson();
});

// json 데이터 읽어오는 함수

function getJson() {
	$.getJSON("json/Seodaemun.json", function(data) {
		$.each(data, function(key, val) {
			if (key == "DESCRIPTION") {
				$("table").attr("border", "1");
				$("thead").append(
					"<tr>" +
					"<th>" + val.DTLSTATENM + "</th>" +
					"<th>" + val.UPTAENM + "</th>" +
					"<th>" + val.BPLCNM + "</th>" +
					"<th>" + val.RDNWHLADDR + "</th>" +
					"<th>" + val.SITEWHLADDR + "</th>" +
					"<th>" + val.SITETEL + "</th>" +
					"<th>" + val.X + ", " + val.Y + "</th>" +
					"</tr>"
				);
			} else {
				var list = val;

				for (var i = 0; i < list.length; i++) {
					var str = list[i];

					if (str.dtlstatenm == "영업") {
						if (str.uptaenm == "과자점" || str.uptaenm == "떡카페" || str.uptaenm == "아이스크림" || str.uptaenm == "전통찻집" || str.uptaenm == "커피숍") {
							$("tbody").append(
								"<tr>" +
									"<td>" + str.dtlstatenm + "</td>" +
									"<td>" + str.uptaenm + "</td>" +
									"<td>" + str.bplcnm + "</td>" +
									"<td>" + str.rdnwhladdr + "</td>" +
									"<td>" + str.sitewhladdr + "</td>" +
									"<td>" + str.sitetel + "</td>" +
									"<td>" + str.x + ", " + str.y + "</td>" +
								"</tr>"
							);
						}
					}
				}
			}
		});

	});
}