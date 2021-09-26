<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.jsv.reserve.dto.TheaterDTO"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title></title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
    <link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/reserve.css">
	<link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
    <link rel="stylesheet" href="resources/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
</head>
<body onload="movies()">
<div class="reserve-container">
        <div class="movie-part">
            <div class="reserve-title">영화</div>
            <div class="sort-wrapper">
                <!-- <div class="sort-rate sort-selected">예매율순</div>
                <div class="sort-korean">가나다순</div> -->
            </div>
            <div class="movie-list-wrapper">
                <div class="movie-list">
                </div>
            </div>
        </div>
        <div class="theater-part">
            <div class="reserve-title">
               	극장
            </div>
            <div class="theater-container">
                <div class="theater-wrapper">
                    <div class="theater-location-wrapper">
                    	<input type="button" class="theater-location" value="서울" onclick="locations(this)">
                    	<input type="button" class="theater-location" value="경기" onclick="locations(this)">
                    	<input type="button" class="theater-location" value="인천" onclick="locations(this)">
                    	<input type="button" class="theater-location" value="강원" onclick="locations(this)">
                    	<input type="button" class="theater-location" value="대구" onclick="locations(this)">
                    	<input type="button" class="theater-location" value="대전/충청" onclick="locations(this)">
                    	<input type="button" class="theater-location" value="부산/울산" onclick="locations(this)">
                    	<input type="button" class="theater-location" value="광주/전라" onclick="locations(this)">
                    	<input type="button" class="theater-location" value="경상" onclick="locations(this)">
                    	<input type="button" class="theater-location" value="제주" onclick="locations(this)">
                    </div>
                    <div class="theater-place-wrapper">
                    	
                    </div>
                </div>
            </div>
        </div>
        <div class="day-part">
            <div class="reserve-title">
            	날짜
            </div>
            <div class="reserve-date"></div>
        </div>
        <div class="time-part">
            <div class="reserve-title">시간</div>
            <div class="reserve-time">
          <div class="reserve-where">1관(Laser) (총 120석) </div>
          <div class="reserve-time-wrapper">
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">10:10</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">12:20</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">14:30</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">16:40</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">18:50</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">20:00</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
                </div>
            </div>
            <div class="reserve-time">
          <div class="reserve-where">2관(일반관) (총 120석) </div>
          <div class="reserve-time-wrapper">
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">08:30</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">10:50</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">13:10</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">15:30</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">17:50</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">20:10</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
                </div>
            </div>
            <div class="reserve-time">
          <div class="reserve-where">3관(LCK관) (총 120석) </div>
          <div class="reserve-time-wrapper">
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">09:30</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">12:00</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">14:30</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">17:00</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">19:30</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">22:00</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
                </div>
            </div>
            <div class="reserve-time">
          <div class="reserve-where">4관(Business) (총 120석) </div>
          <div class="reserve-time-wrapper">
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">07:50</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">10:20</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">12:50</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">15:20</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">17:50</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">20:20</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
                </div>
            </div>
            <div class="reserve-time">
          <div class="reserve-where">5관(Laser) (총 120석) </div>
          <div class="reserve-time-wrapper">
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">08:10</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">10:30</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">12:50</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">15:10</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">17:30</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
	          <button class="reserve-time-button">
	            <span class="reserve-time-want">19:50</span>
	            <span class="reserve-time-remain">120석</span>
	          </button>
                </div>
            </div>
            <div>
            <form class="moveSeatForm" action="moveSeat.mo" method="post">
            <input type="hidden" class="title" name="title">
            <input type="hidden" class="movieAge" name="movieAge">
            <input type="hidden" class="selectedTheater" name="selectedTheater">
            <input type="hidden" class="reserveDate" name="movieDate">
            <input type="hidden" class="runningTime" name="runningTime">
            <button class="moveSeatButton" type="button">예약하기</button>
            <br>
            <a href="http://localhost/jsv/moveSeat.mo">강제이동<br>(영화 미구현으로 유효성 검사 문제로 강제 이동 요함)</a>
            </form>
            </div>
        </div>
	</div>
</body>
	<script src="resources/js/reserve.js"></script>
	
</html>