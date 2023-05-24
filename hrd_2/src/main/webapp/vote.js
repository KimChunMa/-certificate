function vote(){
	let f = document.voteForm

	if(f.v_jumin.value == ""){alert('주민등록번호!'); f.v_jumin.focus(); return false;}
	if(f.v_name.value == ""){alert('이름!');  return false;}
	if(f.m_no.value ==  ""){alert('투표번호!'); f.m_no.focus();  return false;}
	
	if(f.v_time.value ==  ""){alert('투표시간!'); f.v_time.focus();  return false;}
	
	if(f.v_area.value ==  ""){alert('투표장소!'); f.v_area.focus();  return false;}
	
	if(f.v_confirm.value ==  ""){alert('유권자!'); f.v_confirm.focus();  return false;}
	
	document.voteForm.submit()
	alert('전송!')
}

function voteReset(){
	alert('초기화');
	document.voteForm.reset();
	document.querySelector('.v_jumin').focus()
}