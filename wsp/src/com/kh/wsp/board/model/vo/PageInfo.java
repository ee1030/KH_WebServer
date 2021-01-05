package com.kh.wsp.board.model.vo;

public class PageInfo { // 페이징 처리를 위한 값을 저장할 객체
	
	// 얻어올 값
	private int currentPage;	// 현재 페이지 번호를 저장할 변수
	private int listCount;		// 전체 게시글 수를 저장할 변수
	
	// 설정할 값
	private int limit = 10;		// 한 페이지에 보여질 게시글 목록 수
	private int pageSize = 10;	// 페이징 바에 표시될 페이지 수
	
	// 계산할 값
	private int maxPage;		// 전체 목록 페이지의 수 == 마지막 페이지
	private int startPage;		// 페이징바 시작 페이지 번호
	private int endPage;		// 페이징바 끝 페이지 번호
	
	// 기본 생성자 사용 X
	
	public PageInfo(int currentPage, int listCount) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
	}

	public PageInfo(int currentPage, int listCount, int limit, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit + ", pageSize="
				+ pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}

	// 페이징 처리에 필요한 값을 계산하는 메소드
}
