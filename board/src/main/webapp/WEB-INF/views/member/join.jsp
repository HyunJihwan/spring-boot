<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.2.3/js/bootstrap.min.js"></script>
<!-- Add this link to include Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- Add these scripts to include Bootstrap JavaScript and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>


<style>
html {
    height: 100%;
    width: 100%;
}
body {
	font-family: 'Varela Round', sans-serif;
   display: flex;
   justify-content: center;
   align-items: center;
   height: 100%;
}
.modal-login {
	width: 500px;
   
}
.modal-login .modal-content {
	padding: 20px;
	border-radius: 5px;
	border: none;
}
.modal-login .modal-header {
	border-bottom: none;
	position: relative;
	justify-content: center;
}
.modal-login .close {
	position: absolute;
	top: -10px;
	right: -10px;
}
.modal-login h4 {
	color: #636363;
	text-align: center;
	font-size: 26px;
	margin-top: 0;
}
.modal-login .modal-content {
	color: #999;
	border-radius: 1px;
	margin-bottom: 15px;
	background: #fff;
	border: 1px solid #f3f3f3;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 25px;
}
.modal-login .form-group {
	margin-bottom: 20px;
}
.modal-login label {
	font-weight: normal;
	font-size: 13px;
}
.modal-login .form-control {
	min-height: 44px;
	padding-left: 5px;
	box-shadow: none !important;
	border-width: 0 0 1px 0;
	border-radius: 0;
}
.modal-login .form-control:focus {
	border-color: #ccc;
}
.modal-login .input-group-addon {
	max-width: 42px;
	text-align: center;
	background: none;
	border-bottom: 1px solid #ced4da;
	padding-right: 5px;
	border-radius: 0;
}
.modal-login .btn, .modal-login .btn:active {        
	font-size: 16px;
	font-weight: bold;
	background: #4685e4 !important;
	border-radius: 3px;
	border: none;
	min-width: 140px;
}
.modal-login .btn:hover, .modal-login .btn:focus {
	background: #4685e4 !important;
}
.modal-login .hint-text {
	text-align: center;
	padding-top: 5px;
	font-size: 13px;
}
.modal-login .modal-footer {
	color: #999;
	border-color: #dee4e7;
	text-align: center;
	margin: 0 -25px -25px;
	font-size: 13px;
	justify-content: center;
}
.modal-login a {
	color: #fff;
	text-decoration: underline;
}
.modal-login a:hover {
	text-decoration: none;
}
.modal-login a {
	color: #636363;
	text-decoration: none;
}	
.modal-login a:hover {
	text-decoration: underline;
}
.modal-login .fa {
	font-size: 21px;
	position: relative;
	top: 6px;
}
.trigger-btn {
	display: inline-block;
	margin: 100px auto;
}
.findbtn{
	display: flex;
	justify-content: center;
	align-items: center;
	
}
.inputText{
	width: 70%;
	display: inline-flex;
}
.chkbtn{
	color: #fff;
	background: #4685e4 !important;
	border: none;
    font-size: 0.85rem;
    padding: 12px 7px;
	border-radius: 7px;
}
</style>


<body>
<!-- Modal HTML -->
	<div class="modal-dialog modal-login ">
		<div class="modal-content ">
			<div class="modal-header">				
				<h4 class="modal-title">회원가입</h4>
			</div>
			<div class="modal-body">
				
				<form id="registForm" action="<%=request.getContextPath()%>/member/register.do" style="margin-left: 20px;" method="post">
					<div class="form-group d-flex">
						<div class="input-group inputText">
							<span class="fa"><i class="fa fa-user"></i></span><span style="width: 15px;"></span>
							<input type="text" class="form-control" id="id" name="id" placeholder="ID"  required="required">
						</div>
						<div>
							<input type="button" class="chkbtn" name="idchk" style="margin-left: 30px;" required="required" onclick="idCheck_go();" value="중복확인">							
						</div>
					</div>
					<div class="form-group">
						<div class="input-group inputText">
							<span class="fa"><i class="fa fa-lock"></i></span><span style="width: 15px;"></span>
							<input type="password" class="form-control" id="password" name="password" style="font-size: 0.7em;" placeholder="영어 대소문자, 특수문자, 숫자 포함 9자~16자" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group inputText">
							<span class="fa"><i class="fa fa-lock"></i></span><span style="width: 15px;"></span>
							<input type="password" style="font-size: 0.7em;" class="form-control" id="pwdchk" name="pwchk" placeholder="PW check" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group inputText">
							<span class="fa"><i class="fa fa-user"></i></span><span style="width: 15px;"></span>
							<input type="text" class="form-control" id="name" name="name" placeholder="이름" required="required">
						</div>
					</div>
					<!-- 이메일 -->
					<div class="form-group d-flex">
							<div class="input-group inputText">
									<span class="fa"><i class="fa fa-envelope"></i></span><span style="width: 15px;"></span>
									<input type="text" class="form-control" value="" placeholder="이메일" name="email" id="email" required="required"/> 
								</div>
									<div class="input-group" style="width: 50%;align-items: center;margin-right: 20px; margin-left: 10px;" >
										@
										<select name="domainselect" id="domainselect" class="form-select form-select-sm" style="align-items: baseline;margin-left: 10px;border-radius: 3px;">
											<option disabled="disabled" selected="selected">선택</option>
											<option value="@naver.com">naver.com</option>
											<option value="@gmail.com">gmail.com</option>
											<option value="@hanmail.net">hanmail.net</option>
											<option value="@daum.net">daum.net</option>
											<option value="">직접입력</option>
										</select>
										<div class="select-dropdown"></div>
									</div>
						<div>
							<input type="button" class="chkbtn" name="emailauth" id="emailauth" required="required"  value="인증번호 전송">							
						</div>
					</div>
					<div class="form-group d-flex">
						<div class="input-group">
							<span class="fa"><i class="fa fa-envelope"></i></span><span style="width: 15px;"></span>
							<input type="text" class="form-control mail-check-input" name="password" style="margin-right: 30px;" placeholder="인증번호" required="required">
						</div>
						<div>
							<input type="button" class="chkbtn" id="emailauthchk" name="emailauthchk" value="인증번호 확인">			
						</div>
					</div>
					<!-- 이메일 끝 -->
				</form>
					<div class="form-group findbtn">
						<button class="btn btn-info btn-block btn-sm" style="width: 60%; margin-top: 30px; color:#fff;" id="registBtn" onclick="submit_go();">회원가입</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn btn-info btn-block btn-sm" style="width: 60%; margin-top: 30px; color:#fff;" id="cancelBtn">취 소</button>
					</div>

			</div>
			
		</div>
	</div>    
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
<script>	




$(function(){
// 	$('#birth').datepicker({
// 		dateFormat: "yy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
//  		startDate: '',	//달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
//  		language : "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
//  		});	
	
/* 	$('#registBtn').on('click', function(){
		$('#registForm').submit();
	}); */
// 	let gen = $('#gen').val();
	
	$('#cancelBtn').on('click', function(){
		location.href = "/"; 
	});
})

</script> 	 
<script>
var code = ""; // 전역 변수로 선언


	var idChek = 0;
 	$('#id').on('change', function(){
		idChek = 0;
	}) 
	// 아이디 중복확인으로 확인된 아이디가 저장될 곳
	let checkedID = "";	
	function idCheck_go(){
		let input_ID = $('#id');
		
		if(input_ID.val() == ""){
			alert("아이디를 입력하세요.");
			input_ID.focus();
			return;
		}else{
			// 아이디는 4~13 글자의 영문자와 숫자로만 입력
			let reqID = /^[a-z]{1}[a-zA-Z0-9]{3,12}$/;
			if(!reqID.test(input_ID.val())){
				alert("아이디는 첫 글자는 영소문자이며, \n4~13자리의 영문자와 숫자로만 입력해야 합니다.");
				input_ID.focus();
				return;
			};
		};
		
		// 중복확인
		let data = {id : input_ID.val().trim()}; 
		
		$.ajax({
			url : "<%=request.getContextPath()%>/member/idCheck.do",
			data : data,
			type : 'post',
			success : function(result){
				if(result){	// 빈 스트링은 false 처리 됨
					alert("사용가능한 아이디 입니다.");
					checkedID = result;
					$('input[name="id"]').val(checkedID);
					idChek = 1; 
				}else{
					alert("중복된 아이디 입니다.");
					input_ID.focus();
				};
			},
			error : function(error){
				
			}
		});
		
	};
	var passChk = 0;
	$('#password').on('change', function(){
		passChk = 0;
	})
	// password 정규식 체크 - 영문 소문자, 대문자, 특수문자, 숫자가 반드시 하나 이상씩 입력
	let pass = $("input[name=pwd]");
	pass.on("keyup",  function () {
		passVal = pass.val().trim();
		
		regPass =  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[`~!@$%&?*])[A-Za-z\d`~!@$%&?*]{8,15}/;
		
		if ( !(regPass.test(passVal)) ) {
			pass.attr("class", "form-control is-invalid");
		} else {
			pass.attr("class", "form-control is-valid");
		}
	});
	
	// pass2 pass일치 비교
	let passCheck = $("input[name=pwchk]");
	passCheck.on("keyup", function () {
		let passCheckVal = passCheck.val().trim();
		
		if (passVal != passCheckVal) {
			passCheck.attr("class", "form-control is-invalid");
		} else {
			passChk = 1;
			passCheck.attr("class", "form-control is-valid");
		}
	});	

	
	let emailChk = 0;
	$('#email').on('change', function(){
		emailChk = 0;
	})
		
	$('th#emailau').click(function () {
    const email = $('#email').val() + $('#domainselect').val(); // 이메일 주소값 얻어오기!
    console.log('완성된 이메일 : ' + email); // 이메일 오는지 확인
    const checkInput = $('.mail-check-input') // 인증번호 입력하는 곳 

    // 서버에 이메일 주소를 전송하고 인증번호를 요청
    $.ajax({
        type: 'get',
        url:  '<%=request.getContextPath()%>/member/mailCheck.do?email=' + email,
        success: function (data) {
            checkInput.attr('disabled', false);
            code = data; // 서버에서 받은 인증번호를 code 변수에 저장
            console.log(code);
            alert('인증번호가 전송되었습니다.');
        },
        error: function (err) {
            alert(err.status);
        }
    });
});
	
	// 인증번호 비교 
	// blur -> focus가 벗어나는 경우 발생
	$('#emailauthchk').click(function () {
		const inputCode = $('.mail-check-input').val();
		const $resultMsg = $('#emailauthchk');
		
		if(inputCode === code){
			emailChk = 1;
			alert('인증번호가 일치합니다.');
			$resultMsg.css('color','green');
			$('#mail-Check-Btn').attr('disabled',true);
			$('#email').attr('readonly',true);
			$('#domainselect').attr('readonly',true);
	 		$('#domainselect').attr('onFocus', 'this.initialSelect = this.selectedIndex');
	        $('#domainselect').attr('onChange', 'this.selectedIndex = this.initialSelect'); 
		}else{
			alert('인증번호가 불일치 합니다. 다시 확인해주세요!.');
			emailChk = 0;
			$resultMsg.css('color','red');
		}
	});	
	
	function submit_go(){
		if($('input[name="id"]').val() == ""){
			alert("아이디는 필수 입니다.");
			return false;
		};
		if($('input[name="id"]').val() != checkedID){
			alert("아이디 중복확인이 필요합니다.");
			return false;
		};
		if($('input[name="password"]').val() == ""){
			alert("패스워드는 필수입니다.");
			return false;
		};
		if($('input[name="name"]').val() == ""){
			alert("이름은 필수입니다.");
			return false;
		};

  		if(emailChk != 1){
			alert("이메일 인증이 필요합니다.");
			return false;
		};  
		
	$('#registForm').submit();
		alert('회원가입이 정상적으로 되었습니다.');
		
	
	}; 
</script>


