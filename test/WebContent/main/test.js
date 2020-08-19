
//로그인
function login(){
	if($('#loginid').val()==0){
		$('.check').hide();
		$('#checkid').text("아이디를 입력하세요").show();
	}else if($('#loginpwd').val()==0){
		$('#checkid').hide();
		$('#checkpwd').text('비밀번호 입력하세요.').show();
	}else{
		$('.check').hide();
		$.ajax({
			type : 'POST',
			url : '/test/user/login.do',
			data : {'id' : $('#loginid').val(),
					'pwd' : $('#loginpwd').val()},
			dataType : 'text',
			success : function(data){
				if(data == 'not_exist'){
					$('#checkpwd').text('아이디 or 비밀번호 불일치').show();
				}else if(data == 'exist'){
					$('#checkpwd').hide();
					$('#login').html('<input type="button" value="로그아웃" onclick="javascript:logout()">');
					$('#main').html('<h3>로그인 성공</h3>');
				}
			}
		});
	}
}

function create(){
	$('#main').load('create.jsp');
}

function logout(){
	$('#login').load('login.jsp');
	$('#main').html('<h3>로그아웃</h3>');
}
//회원가입
function checkWrite(){
 	if(document.writeForm.name.value==""){
 		$('.check2').hide();
 		$('#nameDiv').text("이름을 입력하세요!").show();
	}else if(document.writeForm.id.value==""){
		$('.check2').hide();
 		$('#idDiv').text("아이디를 입력하세요!").show();
 	}else if(document.writeForm.pwd.value==""){
 		$('.check2').hide();
		$('#pwdDiv').text("비밀번호를 입력하세요!").show();
 	}else if(document.writeForm.pwd.value!=document.writeForm.repwd.value){
 		$('.check2').hide();
		$('#repwdDiv').text("비밀번호를 불일치!").show();
 	}else if($('#id').val()!=$('#confirm').val()){
 		$('.check2').hide();
		$('#idDiv').text("아이디 중복체크가 필요합니다.").css('color','red').css('font-size', '8pt').css('font-weight','bold').show();
 	}else {
 		$('.check2').hide();
 		$.ajax({
			type : 'POST',
			url : '/test/user/write.do',
			data : {'id' : $('#id').val(),
					'pwd' : $('#pwd').val(),
					'name' : $('#name').val(),
					'email1' : $('#email1').val(),
					'email2' : $('#email2').val()},
			dataType : 'text',
			success : function(data){
				$('#main').html('<h3>회원가입 성공</h3>');
			}
		});
 	}
  }


//아이디 중복체크
function checkId(){
		$('#idDiv').empty();
		if($('#id').val()==''){
			$('#idDiv').text("아이디를 입력하세요").css('color','red').css('font-size', '8pt').css('font-weight','bold').show();
		}else {
			$('#idDiv').empty();
			$.ajax({
				type : 'POST',
				url : '/test/user/checkId.do',
				data : 'id='+$('#id').val(),
				dataType : 'text',
				success : function(data){
					if(data == 'not_exist'){
						$('#idDiv').text('사용 가능한 아이디입니다.').show();
						$('#confirm').val($('#id').val());
					}else if(data == 'exist'){
						$('#idDiv').text('이미 존재하는 아이디입니다.').show();
					}
				}
			});
		}
}