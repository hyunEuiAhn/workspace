$('#checkWrite').click(function(){
	 var name = $('input[name=name]').val();
	 var id = $('input[id=writeId]').val();
	 var pwd = $('input[id=writePwd]').val();
	 var repwd = $('input[id=repwd]').val();
	 var check = $('input[id=check]').val();

	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	$('#repwdDiv').empty();

	if(name.length == 0) {
		$('#nameDiv').text("이름을 입력하세요.").css('color', 'red').css('font-size', '8pt');
	} else if(id.length == 0) {
		$('#idDiv').text("아이디를 입력하세요.").css('color', 'red').css('font-size', '8pt');
	} else if(pwd == '') {
		$('#pwdDiv').text("비밀번호를 입력하세요.").css('color', 'red').css('font-size', '8pt');
	} else if(pwd != repwd) {
		$('#repwdDiv').text("비밀번호가 일치하지 않습니다.").css('color', 'red').css('font-size', '8pt');
	} else if(id != check) {
		$('#idDiv').text("중복체크를 해주세요.").css('color', 'magenta').css('font-size', '8pt');
	} else document.writeForm.submit();
 });

 
$('#checkPost').click(function(){
     window.open("/springProject/member/checkPost.do","","width=400 height=400 left=350 top=200 scrollbars=yes");
});

$('#postSearchBtn').click(function(){
	if($('#sido').val()=='시도선택' ||  $('#roadname').val()=='')
		alert('주소를 입력하세요');
	else{
		$.ajax({
			type : 'POST',
			url : '/springProject/member/postSearch.do',
			data : {'sido':$('#sido').val(),
				'sigungu':$('#sigungu').val(),
				'roadname':$('#roadname').val()},
			dataType : 'json',
			success : function(data){
				//alert(JSON.stringify(data));
				
				$('table tr:gt(2)').remove();
				$.each(data.list, function(index, items){
					var address = items.sido+" "
								+ items.sigungu+" "
								+ items.yubmyundong+" "
								+ items.ri+" "
								+ items.roadname+" "
								+ items.buildingname;
					
					address = address.replace(/null/g,'');
					
					$('<tr/>').append($('<td/>',{
						align : 'center',
						text : items.zipcode
					})).append($('<td/>',{
						colspan : '3',
						
						}).append($('<a/>',{
							href : 'javascript:void(0)',
							class : 'addressA',
							text : address
						}))
					).appendTo($('#postTable'));
				});
				
				$('#postTable').on('click','a',function(){
					$('#daum_zipcode',opener.document).val($(this).parent().prev().text());
					$('#daum_addr1',opener.document).val($(this).text());
					$('#daum_addr2',opener.document).focus();
					window.close();
				});
			}
		});
	}
});


 $('#checkId').click(function(){
	    var sId = $('input[id=writeId]').val();

		if(sId=="")
			$('#idDiv').text("먼저 아이디를 입력하세요.").css('color', 'magenta').css('font-size', '8pt');
		else{
			$.ajax({
				type : 'POST',
				url : '/springProject/member/checkId.do',
				data : 'id='+sId,
				dataType : 'text',
				success : function(data){
					if(data=='exist')
						$('#idDiv').text("사용 불가능").css('color', 'magenta').css('font-size', '8pt');
					else if(data=='not_exist')
						$('#idDiv').text("사용 가능").css('color', 'magenta').css('font-size', '8pt');
						$('#check').val(sId);
				}
			});
		}     
	});

 function checkPostClose(zipcode, address){
 	//opener.writeForm.zipcode.value=zipcode;
 	//opener.writeForm.addr1.value=address;
 	//window.close();
 	//opener.writeForm.addr2.focus();
	 
//	opener.document.forms[0].zipcode.value=zipcode;
//	opener.document.forms[0].addr1.value=address;
//	window.close();
//	opener.document.forms[0].addr2.focus();
	 
	 opener.document.getElementById('daum_zipcode').value = zipcode;
	 opener.document.getElementById('daum_addr1').value = address;
	 window.close();
	 opner.document.getElementById('daum_addr2').focus();
 }
 
 
 
 