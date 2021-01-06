<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
.pagination {
	justify-content: center;
}

#searchForm {
	position: relative;
}

#searchForm>* {
	top: 0;
}

.boardTitle>img {
	width: 50px;
	height: 50px;
}

#list-table th {
	text-align: center;
}

#list-table td:not(:nth-of-type(3)) {
	text-align: center;
}

.list-wrapper{
	height: 540px;
}

#list-table td:hover {
	cursor: pointer;
}


</style>

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container my-5">
		
		<h1>게시판</h1>
		
			<div class="list-wrapper">
				<table class="table table-hover table-striped my-5" id="list-table">
					<thead>
						<tr>
							<th>글번호</th>
							<th>카테고리</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일</th>
						</tr>
					</thead>
					
					<%-- 게시글 목록 출력 --%>
					<tbody>
						<c:choose>
							<c:when test="${empty bList}">
								<tr>
									<td colspan="6">존재하는 게시글이 없습니다.</td>
								</tr>
							</c:when>
							
							<c:otherwise> <%-- 조회된 게시글 목록이 있을 때 --%>
								<c:forEach var="board" items="${bList}">
									<tr>
										<td>${board.boardNo}</td>
										<td>${board.categoryName}</td>
										<td class="boardTitle">
											${board.boardTitle}
										</td>
										<td>${board.memberId}</td>
										<td>${board.readCount}</td>
										<td>
											<%-- 날짜 출력 모양 지정 --%>
											<fmt:formatDate var="createDate" value="${board.boardCreateDate}" pattern="yyyy-MM-dd"/>
											<fmt:formatDate var="today" value="<%= new java.util.Date() %>" pattern="yyyy-MM-dd"/>
											
											<c:choose>
												<%-- 글 작성일이 오늘이 아닐 경우 --%>
												<c:when test="${createDate != today}">
													${createDate}
												</c:when>
												
												<%-- 글 작성일이 오늘일 경우 --%>
												<c:otherwise>
													<fmt:formatDate value="${board.boardCreateDate}" pattern="HH:mm"/>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>


			<%-- 로그인이 되어있는 경우 --%>
			<button type="button" class="btn btn-primary float-right" id="insertBtn" onclick="location.href = 'insertForm.do'">글쓰기</button>
			
			
			<%---------------------- Pagination ----------------------%>
			<%-- 페이징 처리 주소를 쉽게 사용할 수 있도록 미리 변수에 저장 --%>
			<c:url var="pageUrl" value="/board/list.do"/>
			
			<!-- 화살표에 들어갈 주소를 변수로 생성 -->
			<c:set var="firstPage" value="${pageUrl}?cp=1"/>
			<c:set var="lastPage" value="${pageUrl}?cp=${pInfo.maxPage}"/>
			
			<%-- EL을 이용한 숫자 연산의 단점 : 연산이 자료형의 영향을 받지 않는다. --%>
			<%-- 
				<fmt:parseNumber>		:	숫자 형태를 지정하여 변수 선언
				integerOnly="true"	:	정수로만 숫자 표현(소수점 버림)
			--%>
			
			<fmt:parseNumber var="c1" value="${(pInfo.currentPage - 1) / 10 }" integerOnly="true"/>
			<fmt:parseNumber var="prev" value="${c1 * 10}" integerOnly="true"/>
			<c:set var="prevPage" value="${pageUrl}?cp=${prev}"/>
			
			<fmt:parseNumber var="c2" value="${(pInfo.currentPage + 9) / 10}" integerOnly="true"/>
			<fmt:parseNumber var="next" value="${c2 * 10 + 1}" integerOnly="true"/>
			<c:set var="nextPage" value="${pageUrl}?cp=${next}" />
			
			<div class="my-5">
				<ul class="pagination">
				
					<%-- 현재 페이지가 10페이지 초과인 경우 --%>
					<c:if test="${pInfo.currentPage > 10}">
						<li> <!-- 첫페이지로 이동(<<) -->
							<a class="page-link" href="${firstPage}">&lt;&lt;</a>
						</li>
						
						<li> <!-- 이전 페이지로 이동(<) -->
							<a class="page-link" href="${prevPage}">&lt;</a>
						</li>
					</c:if>
					
					<!-- 페이지 목록 -->
					<c:forEach var="page" begin="${pInfo.startPage}" end="${pInfo.endPage}">
						<c:choose>
							<c:when test="${pInfo.currentPage == page }">
								<li>
									<a class="page-link">${page}</a>
								</li>
							</c:when>
							
							<c:otherwise>
								<li>
									<a class="page-link" href="${pageUrl}?cp=${page}">${page}</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<%-- 다음 페이지가 마지막 페이지 미만인 경우 --%>
					<c:if test="${next < pInfo.maxPage}">
						<li> <!-- 다음 페이지로 이동(>) -->
							<a class="page-link" href="${nextPage}">&gt;</a>
						</li>
						
						<li> <!-- 마지막페이지로 이동(>>) -->
							<a class="page-link" href="${lastPage}">&gt;&gt;</a>
						</li>
					</c:if>
				</ul>
			</div>
		
		
				<!-- 검색창 -->
			<div class="my-5">
				<form action="${contextPath }/search.do" method="GET" class="text-center" id="searchForm">
					<select name="sk" class="form-control" style="width: 100px; display: inline-block;">
						<option value="title">글제목</option>
						<option value="content">내용</option>
						<option value="titcont">제목+내용</option>
						<option value="writer">작성자</option>
					</select>
					<input type="text" name="sv" class="form-control" style="width: 25%; display: inline-block;">
					<button class="form-control btn btn-primary" style="width: 100px; display: inline-block;">검색</button>
				</form>


			</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>


	<script>
		// 게시글 상세보기 기능 (jquery를 통해 작업)
		
		$("#list-table td").on("click", function() {
			// 게시글 번호 얻어오기
			var boardNo = $(this).parent().children().eq(0).text();
			//console.log(boardNo);
			
			var url = "${contextPath}/board/view.do?cp=${pInfo.currentPage}&no=" + boardNo;
			
			location.href = url;
		});
		
	</script>
</body>
</html>
