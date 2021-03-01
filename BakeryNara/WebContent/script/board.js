
//글 작성, 글 수정시 필수입력란 유효성 검사 메소드
function boardCheck(){
	
	if (document.frm.name.value.length == 0) {
		alert("작성자란을 입력하세요.");
		return false;
	}else if (document.frm.title.value.length == 0) {
		alert("제목란을 입력하세요.");
		return false;
	}
	
	return true;
}

//글 삭제 확인 메서드
function deleteCheck(num){
	
    if(confirm("글을 삭제하시겠습니까?")==true){
    	location.href='board.do?command=board_delete&num='+num;
    	alert("삭제 되었습니다");
    }else{
    	return;
    }
};