<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
   <title></title>
</head>
<style>
   @import url(http://fonts.googleapis.com/css?family=Lato:300,400,700);
/* Starter CSS for Flyout Menu */


#cssmenu,
#cssmenu ul,
#cssmenu ul li,
#cssmenu ul ul {
  list-style: none;
  margin: 0;
  padding: 0;
  border: 0;
}
#cssmenu ul {
  position: relative;
  z-index: 597;
  float: left;
}
#cssmenu ul li {
  float: left;
  min-height: 1px;
  line-height: 1em;
  vertical-align: middle;
}
#cssmenu ul li.hover,
#cssmenu ul li:hover {
  position: relative;
  z-index: 599;
  cursor: default;
}
#cssmenu ul ul {
  margin-top: -1px; /* submenu 위치 */
  visibility: hidden;
  position: absolute;
  top: 1px;
  left: 99%;
  z-index: 598;
  width: 100%;
}
#cssmenu ul ul li {
  float: none;
}
#cssmenu ul ul ul {
  top: 1px;
  left: 99%;
}
#cssmenu ul li:hover > ul {
  visibility: visible;
}
#cssmenu ul li {
  float: none;
}
#cssmenu ul ul li {
  font-weight: normal;
}
/* Custom CSS Styles */
#cssmenu {
  font-family: 'Lato', sans-serif;
  font-size: 18px;
  width: 200px;
}
#cssmenu ul a,
#cssmenu ul a:link,
#cssmenu ul a:visited {
  display: block;
  color: #848889;
  text-decoration: none;
  font-weight: 300;
}
#cssmenu > ul {
  float: none;
}
#cssmenu ul {
  background: #fcfcfc; /* 1depth 배경컬러 */
}
#cssmenu > ul > li {
  border-left: 3px solid #d7d8da;
}
#cssmenu > ul > li > a {
  padding: 10px 20px;
}
#cssmenu > ul > li:hover {
  border-left: 3px solid #3dbd99;
}
#cssmenu ul li:hover > a {
  color: #3dbd99;
}
#cssmenu > ul > li:hover {
  background: #f6f6f6;
}
/* Sub Menu */
#cssmenu ul ul a:link,
#cssmenu ul ul a:visited {
  font-weight: 400;
  font-size: 14px;
}
#cssmenu ul ul {
  width: 180px;
  background: none;
  border-left: 20px solid transparent;
}
#cssmenu ul ul a {
  padding: 8px 0;
  border-bottom: 1px solid #eeeeee;
}
#cssmenu ul ul li {
  padding: 0 20px;
  background: #f5f5f5; /* 2depth, 3depth 배경컬러 */
}
#cssmenu ul ul li:last-child {
  border-bottom: 3px solid #d7d8da;
  padding-bottom: 10px;
}
#cssmenu ul ul li:first-child {
  padding-top: 10px;
}
#cssmenu ul ul li:last-child > a {
  border-bottom: none;
}
#cssmenu ul ul li:first-child:after {
  content: '';
  display: block;
  width: 0;
  height: 0;
  position: absolute;
  left: -20px;
  top: 13px;
  border-left: 10px solid transparent;
  border-right: 10px solid #f5f5f5; /* 2depth, 3depth 화살표 컬러-106번째 라인과 같은 색이어야 함 */
  border-bottom: 10px solid transparent;
  border-top: 10px solid transparent;
}
.test{
	position:relative;
	float:left;
}
#cssmenu{
	position:absolute;
	margin:0px
}
</style>
<body>
<div class="test">
	<div id='cssmenu'>
		<ul>
		   <li><span> &nbsp;  &nbsp; &nbsp;메뉴</span></li>
		   <li class='active has-sub'><a href='#'><span>회원관리</span></a>
		      <ul>
		         <li class='has-sub'><a href='${contextPath}/member/memberList.mo'><span>회원목록</span></a></li>
		      </ul>
		   </li>
		   <li class='active has-sub'><a href='#'><span>예매관리</span></a>
		      <ul>
		         <li class='has-sub'><a href='#'><span>메뉴판 1</span></a></li>
		         <li class='has-sub'><a href='#'><span>메뉴판 2</span></a></li>
		      </ul>
		   </li>
		   <li class='active has-sub'><a href='#'><span>기프트샵</span></a>
		      <ul>
		         <li class='has-sub'><a href="${contextPath}/admin/gift-shop.mo"><span>상품관리</span></a></li>
		         <li class='has-sub'><a href="${contextPath}/admin/gift-shop/getGoodsSales.mo"><span>매출조회</span></a></li>
		      </ul>
		   </li>
		</ul>
	</div>
</div>

</body>
</html>
