/**
 * 
 */

function getArrayList(){
	$.ajax({
		url:'getGoodsSales.mo',
		success:function(arrayList){
			columnChart1(arrayList);
		}
	});
}

//구글 시각화 API를 로딩하는 메소드
google.charts.load('current', {packages: ['corechart']});

/* 30초마다 재갱신 */
google.charts.setOnLoadCallback(function(){
	setInterval(columnChart1(),30000);
});

function columnChart1(arrayList) {
	
	// 실 데이터를 가진 데이터테이블 객체를 반환하는 메소드
	var dataTable = google.visualization.arrayToDataTable(arrayList);

	var options = {// 옵션
		width : 980,
        height : 400,
		title: 'JSV 기프트샵 연매출',
		hAxis: {
            format:''
        }
	};

	var objDiv = document.getElementById('chart_wrap');// 차트 그릴 영역 div 객체
	var chart = new google.visualization.ColumnChart(objDiv);// div 영역에 컬럼차트를 그릴수 있는 차트 반환

	chart.draw(dataTable, options);
	
} // drawColumnChart1()의 끝