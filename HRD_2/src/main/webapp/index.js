function add(){
	let sno = document.querySelector('.sno');
	if(sno.value==""){alert('학생번호를 입력해주세요.');sno.focus();return false;}
	
	let ekor = document.querySelector('.ekor');
	if(ekor.value==""){alert('국어점수를 입력해주세요.');ekor.focus();return false;}

	let emath = document.querySelector('.emath');
	if(emath.value==""){alert('수학점수를 입력해주세요.');emath.focus();return false;}

	let eeng = document.querySelector('.eeng');
	if(eeng.value==""){alert('영어점수를 입력해주세요.');eeng.focus();return false;}

	let ehist = document.querySelector('.ehist');
	if(ehist.value==""){alert('역사점수를 입력해주세요.');ehist.focus();return false;}
	
	document.addForm.submit();// 폼전송
	alert('전송완료!');
	
}