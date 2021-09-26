const date = new Date();
// console.log(date.getFullYear());
const lastDay = new Date(date.getFullYear(), date.getMonth(), 0);
const reserveDate = document.querySelector('.reserve-date');
const theaterPlace = document.querySelectorAll('.theater-place');
const reserveTimeWant = document.querySelectorAll('.reserve-time-want');
const inputTitle = document.querySelector('.title');
const inputSelectedTheater = document.querySelector('.selectedTheater');
const inputReserveDate = document.querySelector('.reserveDate');
const inputRunningTime = document.querySelector('.runningTime');
const moveSeatForm = document.querySelector('.moveSeatForm');
const moveSeatButton = document.querySelector('.moveSeatButton');
const movieAge = document.querySelector('.movieAge');

let movieListAge = '';
let year = 0;
let month = 0;

document.addEventListener('DOMContentLoaded', () => {
    addDate();
});

function addDate() {
    const weekOfDay = ['일', '월', '화', '수', '목', '금', '토'];
    year = date.getFullYear();
    month = date.getMonth()+1;
    reserveDate.append(year + '/' + month);
    for (i = date.getDate(); i <= lastDay.getDate(); i++) {
        const button = document.createElement('button');
        const spanWeekOfDay = document.createElement('span');
        const spanDay = document.createElement('span');

        //class넣기
        button.classList = 'movie-date-wrapper';
        spanWeekOfDay.classList = 'movie-week-of-day';
        spanDay.classList = 'movie-day';

        //weekOfDay[new Date(2020-03-날짜)]
        const dayOfWeek =
            weekOfDay[new Date(year + '-' + month + '-' + i).getDay()];

        //요일 넣기
        if (dayOfWeek === '토') {
            spanWeekOfDay.classList.add('saturday');
            spanDay.classList.add('saturday');
        } else if (dayOfWeek === '일') {
            spanWeekOfDay.classList.add('sunday');
            spanDay.classList.add('sunday');
        }
        spanWeekOfDay.innerHTML = dayOfWeek;
        button.append(spanWeekOfDay);
        //날짜 넣기
        spanDay.innerHTML = i;
        button.append(spanDay);
        //button.append(i);

        reserveDate.append(button);

        dayClickEvent(button);
    }
}

function dayClickEvent(button) {
    button.addEventListener('click', function() {
        const movieDateWrapperActive = document.querySelectorAll(
            '.movie-date-wrapper-active'
        );
        movieDateWrapperActive.forEach(list => {
            list.classList.remove('movie-date-wrapper-active');
        });
        button.classList.add('movie-date-wrapper-active');
        console.log(button.childNodes[1].innerHTML);
        inputReserveDate.value =
            year +
            '.' +
            month +
            '.' +
            button.childNodes[1].innerHTML +
            '(' +
            button.childNodes[0].innerHTML +
            ')';
        console.log(inputReserveDate.value);
    });
}

reserveTimeWant.forEach(list => {
	list.addEventListener('click', function() {
		const reserveTimeActive = document.querySelectorAll('.reserve-time-active');
		reserveTimeActive.forEach(li => {
			li.classList.remove('reserve-time-active');
		});
		list.classList.add('reserve-time-active');
		console.log(list.innerHTML);
		inputRunningTime.value = list.innerHTML;
	});
});

function movies(){
	console.log("Obj.value : " );
	$.ajax({
		url: "movieList",
		type: "POST",
		dataType: "json",
		}).done(function(data){
			mov = [];
			console.log("data[0].title : " + data[0].title);
				for(var i=0; i<data.length; i++){
					mov += data[i].title;
					$(".movie-list-wrapper").append('<input type="button" name="movieList" class="movieList" value="'+ data[i].title +'">');
				}
		})
}
			
$(document).on("click", "input[name=movieList]", function(){
	console.log($(this).val());
	inTitle = $(this).val();
	console.log("inTitle : " + inTitle);
});

$(document).on("click", "input[name=theater-place]", function() {
    console.log($(this).val())
    inSelectedTheater = $(this).val();
    console.log("inSelectedTheater : " + inSelectedTheater);
});

function locations(Obj){
	console.log("Obj.value : " + Obj.value);
	$.ajax({
		url: "theaterList",
		type: "POST",
		data:{"location":Obj.value},
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		dataType:"json",
		success: function(data){
			if(data!=null){
				loc = [];
				$(".theater-place-wrapper").empty();
				
				
				
				function thClick(obj){
					console.log("값 : " + obj.value)
				};
				
				for(var i=0;i<data.length;i++){
					loc += data[i].theaterName;
					$(".theater-place-wrapper").append('<input type="button" name="theater-place" class="theater-place" value="'+data[i].theaterName+'">');
				}	
				
				
			};
			
			
		
			console.log("theaterList 서버 다녀옴");
			console.log("data : " + data);
			
		},
		error: function(){
			console.log("theaterList 실패");
		}
	});
	
}


moveSeatButton.addEventListener('click', function() {
    if (!!inTitle &&
        !!inSelectedTheater &&
        !!inputReserveDate.value &&
        !!inputRunningTime.value
    ) {
        moveSeatForm.submit();
    } else {
        toastr.options = {
            positionClass: 'toast-top-full-width',
            progressBar: true,
            timeOut: 1000,
        };
        toastr.error(
            '<div style="color:white">모든 항목을 체크해 주세요</div>',
            '<div style="color:white">경고</div>', {
                timeOut: 3000,
            }
        );
    }
});