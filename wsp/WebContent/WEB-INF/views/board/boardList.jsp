<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
					
					</tbody>
				</table>
			</div>


			<%-- 로그인이 되어있는 경우 --%>
			<button type="button" class="btn btn-primary float-right" id="insertBtn" onclick="location.href = 'insertForm.do'">글쓰기</button>
			
			
			<%---------------------- Pagination ----------------------%>
			
			
			
			<div class="my-5">
				<ul class="pagination">
				

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
	</script>
</body>
</html>
