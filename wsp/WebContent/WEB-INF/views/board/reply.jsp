<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
/*댓글*/
.replyWrite>table {
	width: 90%;
	margin-top: 100px;
}

#replyContentArea {
	width: 90%;
}

#replyContentArea > textarea {
	resize: none;
	width: 100%;
}

#replyBtnArea {
	width: 100px;
	text-align: center;
}

.rWriter {
	display: inline-block;
	margin-right: 30px;
	vertical-align: top;
}

.rDate {
	display: inline-block;
	font-size: 0.5em;
	color: gray;
}

#replyListArea {
	list-style-type: none;
}

.rContent, .replyBtnArea {
	height: 100%;
	width: 100%;
}

.replyBtnArea {
	text-align: right;
}

.replyUpdateContent {
	resize: none;
	width: 100%;
}

.reply-row{
	border-top : 1px solid #ccc;
	padding : 15px 0;
}
</style>
<div id="reply-area ">
	<!-- 댓글 작성 부분 -->
	<div class="replyWrite">
		<table align="center">
			<tr>
				<td id="replyContentArea">
					<textArea rows="3" id="replyContent"></textArea>
				</td>
				<td id="replyBtnArea">
					<button class="btn btn-primary" id="addReply">
						댓글<br>등록
					</button>
				</td>
			</tr>
		</table>
	</div>


	<!-- 댓글 출력 부분 -->
	<div class="replyList mt-5 pt-2">
		<ul id="replyListArea">
			
			<!-- 로그인 x 또는 댓글 작성자가 아닌 회원의 화면 -->
			<li class="reply-row">
				<div>
					<p class="rWriter">작성자</p>
					<p class="rDate">작성일 : 2021.01.11 10:30</p>
				</div>
				
				<p class="rContent">댓글 내용1</p>
			</li>

			
			<!-- 로그인한 회원이 댓글 작성자인 경우 -->
			<li class="reply-row">
				<div>
					<p class="rWriter">작성자</p>
					<p class="rDate">작성일 : 2021.01.11 10:30</p>
				</div>

				<p class="rContent">댓글 내용2</p>
				
				<div class="replyBtnArea">
					<button class="btn btn-primary btn-sm ml-1" id="updateReply" onclick="showUpdateReply(2, this)">수정</button>
					<button class="btn btn-primary btn-sm ml-1" id="deleteReply" onclick="deleteReply(2)">삭제</button>
				</div>
			</li>
	
		</ul>
	</div>


</div>

<script>
var loginMemberId = "${loginMember.memberId}";
var parentBoardNo = ${board.boardNo};

// 페이지 로딩 완료 시 댓글 목록 호출
$(function(){
	selectReplyList();
});


// 해당 게시글 댓글 목록 조회 함수(ajax)
function selectReplyList(){
 
}

//-----------------------------------------------------------------------------------------

// 댓글 등록 (ajax)
$("#addReply").on("click", function(){
	
});


// -----------------------------------------------------------------------------------------


var beforeReplyRow;

// 댓글 수정 폼 출력 함수
function showUpdateReply(replyNo, el){
	
	
}

//-----------------------------------------------------------------------------------------


// 댓글 수정 함수
function updateReply(replyNo, el){
	
	
	
}

//-----------------------------------------------------------------------------------------


// 댓글 수정 취소 시 원래대로 돌아가는 함수
function updateCancel(el){
}



//-----------------------------------------------------------------------------------------

//댓글 삭제 함수
function deleteReply(replyNo){
}


</script>