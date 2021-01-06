<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<style>
	#board-area{ height: 700px; }
	#board-content{ padding-bottom:150px;}

	.boardImgArea{
		height: 300px;
	}

	.boardImg{
		width : 100%;
		height: 100%;
		
		max-width : 300px;
		max-height: 300px;
		
		margin : auto;
	}
	
	/* 이미지 화살표 색 조정
	-> fill='%23000' 부분의 000을
	   RGB 16진수 값을 작성하여 변경 가능 
	 */
	.carousel-control-prev-icon {
 		background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E") !important;
	}
	
	.carousel-control-next-icon {
  		background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E") !important;
	}
	
	.replyWrite > table{
		width: 90%;
		align: center;
	}
	
	#replyContentArea{ width: 90%; }
	
	#replyContentArea > textarea{
	    resize: none;
    	width: 100%;
	}
	
	#replyBtnArea{
	    width: 100px;
	    text-align: center;
	}
	
	.rWriter{ margin-right: 30px;}
	.rDate{
		font-size: 0.7em;
		color : gray;
	}
	
	#replyListArea{
		list-style-type: none;
	}
	
	.board-dateArea{
		font-size: 14px;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container  my-5">

		<div>

			<div id="board-area">

				<!-- Category -->
				<h6 class="mt-4">카테고리 : [${board.categoryName}]</h6>
				
				<!-- Title -->
				<h3 class="mt-4">${board.boardTitle}</h3>

				<!-- Writer -->
				<p class="lead">
					작성자 : ${board.memberId}
				</p>

				<hr>

				<!-- Date -->
				<p>
					<span class="board-dateArea">
						작성일 : <fmt:formatDate value="${board.boardCreateDate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/>
						<br>
						마지막 수정일 : <fmt:formatDate value="${board.boardModifyDate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/>
					</span>
			 		<span class="float-right">조회수 ${board.readCount}</span>
				</p>

				<hr>
				<!-- 이미지 출력 -->


				<!-- Content -->
				<div id="board-content">${board.boardContent}</div>
				

				<hr>
				 
				
				<div>
				
					<%-- 로그인된 회원과 해당 글 작성자가 같은 경우--%>
					<c:if test="${!empty loginMember && (board.memberId == loginMember.memberId)}">
						<button id="deleteBtn" class="btn btn-primary float-right">삭제</button> 
						<a href="#" class="btn btn-primary float-right ml-1 mr-1">수정</a>
					</c:if>
					
					<c:url var="goToList" value="list.do">
						<c:param name="cp">${param.cp}</c:param>
					</c:url>
					
					<a href="${goToList}" class="btn btn-primary float-right">목록으로</a>
				</div>
			</div>



		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
	
	<script>
		
	</script>
</body>
</html>
