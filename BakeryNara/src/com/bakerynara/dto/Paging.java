package com.bakerynara.dto;

public class Paging {

	private int page = 1; //현재 페이지 (get)
	private int totalCount; //row 전체의 수 (get)
	private int beginPage;  //출력 시작 페이지
	private int endPage;    //출력 끝 페이지
	private int displayRow =5;  //한 페이지에 몇 개의 행 보일건지 (선택 set)
	private int displayPage =5;  //한 페이지에 몇 개의 페이지 보일건지(선택 set)
	boolean prev; //prev 버튼이 보일건지 안보일건지
	boolean next; //next 버튼이 보일건지 안보일건지
	private int startNum;
	private int endNum;

	public int getPage() {
	    return page;
	}
	public void setPage(int page) {
	    this.page = page;
	}
	public int getTotalCount() {
	    return totalCount;
	}
	public void setTotalCount(int totalCount) {
	    //setTotalCount()를 꼭 호출해야 paging이 되기 때문에
	    //setTotalCount()를 호출했을 때 paging()함수를 자동으로 호출되게 한다.
	    this.totalCount = totalCount;
	    paging();
	}
	public int getDisplayRow() {
	    return displayRow;
	}
	public void setDisplayRow(int displayRow) {
	    this.displayRow = displayRow;
	}
	public int getDisplayPage() {
	    return displayPage;
	}
	public void setDisplayPage(int displayPage) {
	    this.displayPage = displayPage;
	}
	public int getBeginPage() {
	    return beginPage;
	}
	public int getEndPage() {
	    return endPage;
	}
	public boolean isPrev() {
	    return prev;
	}
	public boolean isNext() {
	    return next;
	}
	// prev, next, beginPage, endPage를 계산해서 만드는 메소드
	private void paging(){
		/* 공식
			※ endPage = Math.ceil(page/displayPage) * displayPage
			※ beginPage = endPage - (displayPage - 1)
			※ totalPage = Math.ceil(totalCount/displayRow)
			※ nextBtn:
			  	if(totalPage<endPage){
			            endPage = totalPage;
			            nextBtn = false;
			        }else{
			            nextBtn = true;
			        }
			※ prevBtn:
				if(beginPage==1){prevBtn = false}
				
				else{prevBtn = true}
			※ prevBtn = (beginPage==1)?false:true;
		 */
	
		//화면에 표시 될 마지막 페이지
	    // 1/10 = 0.1 를 올림하면 1. 1  * 10 = 10
	    endPage = ((int)Math.ceil(page/(double)displayPage))*displayPage;
	    
	    //화면에 표시 될 시작 페이지
	    beginPage = endPage - (displayPage - 1);
	    
	    //총 페이지 수
	    //전체 글이 32개라고 할때 32/10(보여줄 페이지 수) = 3.2 를 올림하면 4페이지
	    int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
	    
	    //다음 페이지 보기 버튼
	    //총 페이지 수 < 화면에 표시 될 마지막 페이지 가 될 경우
	    if(totalPage<endPage){
	        endPage = totalPage;
	        //버튼 없앰
	        next = false;
	    }else{
	    	//버튼 생성
	        next = true;
	    }
	    
	    //이전 페이지 보기 버튼
	    //시작 페이지가 1 인경우에만 버튼 없앰
	    prev = (beginPage==1) ? false : true;
	    
	    //System.out.println("totalPage : " + totalPage);
	    
	}
	public int getStartNum() {
		startNum = (page-1)*displayRow+1;
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		endNum=page*displayRow;
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	 
}
