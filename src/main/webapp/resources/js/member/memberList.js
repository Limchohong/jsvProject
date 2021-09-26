/**
 * 관리자 - 회원 목록 조회시 회원 활동 정지 or 해제 js
 */

function stop(u_no){
	if(confirm("해당 회원의 활동을 정지하시겠습니까?")){
		location.href="memberStop.mo?uno="+u_no;
	}
}
function release(u_no){
	if(confirm("해당 회원의 활동정지를 해제하시겠습니까?")){
		location.href="memberRelease.mo?uno="+u_no;
	}
}