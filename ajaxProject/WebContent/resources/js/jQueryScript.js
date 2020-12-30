// 1. 버튼 클릭 시 GET 방식으로 서버에 입력 값 전달 및 응답
$("#jqBtn1").on("click", function() {
    $.ajax({
        // url : 요청을 보낼 주소(필수!!)
        url : "jqTest1.do",
        type : "GET", // type : 데이터 전송 방식
        data : { "input" : $("#input1").val() }, // data : 전달할 데이터
        success : function(result){
            // success : ajax 통신 성공 시 동작
            // 매개변수 result : 서버 응답 데이터
            $("#result-area").html(result);
        },

        error : function() {
            // error : ajax 통신 실패 시 동작
            console.log("ajax 통신 실패");
        },

        complete : function() {
            // complete : 통신 성공 여부와 관계없이 수행
            console.log("통신 성공 여부 관계 없이 수행됨.");
        }

    });
});


// 실시간 아이디 중복 검사
$("#inputId").on("input", function() {
    $.ajax({
        url : "member/idDupCheck.do",
        data : {"inputId" : $("#inputId").val()},
        type : "GET",
        success : function(result) {
            if(result == 0) {
                $("#idDupResult").text("사용 가능한 아이디 입니다.");
            } else { 
                $("#idDupResult").text("이미 사용 중인 아이디 입니다.");
            }
        }, 

        error : function(request, status, error) {
            console.log("ajax 통신 오류");
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
});