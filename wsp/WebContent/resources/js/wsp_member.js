// 입력 값들이 유효성 검사가 진행되었는지 확인하기 위한 객체 생성
var validateCheck = {
    "id" : false,
    "pwd1" : false,
    "pwd2" : false,
    "name" : false,
    "phone2" : false,
    "email" : false
}

// 아이디 유효성 검사
// 첫 글자는 영어 소문자, 나머지 글자는 영어 대,소문자 + 숫자, 총 6~12글자
$("#id").on("input", function() {
    var regExp = /^[a-z][a-zA-z\d]{5,11}$/;

    var value = $("#id").val();

    if(!regExp.test(value)) {
        $("#checkId").text("아이디 형식이 유효하지 않습니다.")
                    .css("color", "red");
        validateCheck.id = false;
    } else {
        $("#checkId").text("유효한 아이디 형식입니다.")
                    .css("color", "green");
        validateCheck.id = true;
    }
});

// 이름
$("#name").on("input", function() {
    var regExp = /^[가-힣]{2,}$/; // 한글 두 글자 이상

    var value = $("#name").val();

    if(!regExp.test(value)) {
        $("#checkName").text("유효하지 않은 이름입니다.").css("color", "red");
        validateCheck.name = false;
    } else {
        $("#checkName").text("유효한 이름입니다.").css("color", "green");
        validateCheck.name = true;
    }

});

// 이메일
$("#email").on("input", function() {
    var regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/; // 4글자 아무단어 @ 아무단어 . * 3

    var value = $("#email").val();

    if(!regExp.test(value)) {
        $("#checkEmail").text("유효하지 않은 이메일 형식입니다.").css("color", "red");
        validateCheck.email = false;
    } else {
        $("#checkEmail").text("유효한 이메일 형식입니다.").css("color", "green");
        validateCheck.email = true;
    }
});

// 비밀번호 유효성 검사
// 영어 대, 소문자 + 숫자, 총 6~12글자
// + 비밀번호, 비밀번호 확인의 일치여부
// + 비밀번호를 입력하지 않거나 유효하지 않은 상태로
//   비밀번호 확인을 작성하는 경우

$("#pwd1, #pwd2").on("input", function() {

    // 비밀번호 유효성 검사
    var regExp = /^[a-zA-Z\d]{6,12}$/;

    var v1 = $("#pwd1").val();
    var v2 = $("#pwd2").val();

    if(!regExp.test(v1)) {
        $("#checkPwd1").text("비밀번호 형식이 유효하지 않습니다.").css("color", "red");
        validateCheck.pwd1 = false;
    } else {
        $("#checkPwd1").text("유효한 비밀번호 형식입니다.").css("color", "green");
        validateCheck.pwd1 = true;
    }

    // 비밀번호가 유효하지 않은 상태에서 비밀번호 확인 작성 시
    if(!validateCheck.pwd1 && v2.length > 0) {
        swal("유효한 비밀번호를 먼저 작성해 주세요.");
        $("#pwd2").val(""); // 비민번호 확인에 입력한 값 삭ㅈ데
        $("#pwd1").focus();
    } else {
        if(v1.length == 0 || v2.length == 0) {
            $("#checkPwd2").html("&nbsp;");
        } else if(v1 == v2) {
            $("#checkPwd2").text("비밀번호 일치").css("color", "green");
            validateCheck.pwd2 = true;
        } else {
            $("#checkPwd2").text("비밀번호 불일치").css("color", "red");
            validateCheck.pwd2 = false;
        }
    }
});

// 전화번호 유효성 검사
$(".phone").on("input", function() {
    // 전화번호 input 태그에 4글자 초과 입력하지 못하게 하는 이벤ㅌ,
    if ($(this).val().length > 4) {
		$(this).val( $(this).val().slice(0, 4));
	}

    var regExp1 = /^\d{3,4}$/;
    var regExp2 = /^\d{4}$/;

    var v1 = $("#phone2").val();
    var v2 = $("#phone3").val();

    if(!regExp1.test(v1) || !regExp2.test(v2)) {
        $("#checkPhone").text("전화번호가 유효하지 않습니다.").css("color", "red");
        validateCheck.phone2 = false;
    } else {
        $("#checkPhone").text("유효한 형식의 전화번호 입니다.").css("color", "green");
        validateCheck.phone2 = true;
    }
});


function validate() {

    // 유효성 검사 여부 확인
    for(var key in validateCheck) {
        if(!validateCheck[key]) {
            var msg;

            switch(key) {
                case "id" : msg = "아이디가"; break;
                case "pwd1" :
                case "pwd2" : msg = "비밀번호가"; break;
                case "name" : msg = "이름이"; break;
                case "phone2" : msg = "전화번호가"; break;
                case "email" : msg = "이메일이"; break;
            }

            swal(msg + " 유효하지 않습니다.");

            $("#"+key).focus();
            return false;
        }
    }
}

$(function() {
    $("#postcodify_search_button").postcodifyPopUp();
});

// 아이디 중복 체크창 오픈
$("#idDupCheck").on("click",function () {
	window.open("idDupForm.do", "idDupForm","width=450, height=250");
	 //			  팝업 주소		팝업창 name			설정
});
