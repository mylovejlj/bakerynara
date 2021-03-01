// 회원가입 폼 유효성 검사 메소드
function joinCheck() {

	var userid = document.frmJoin.userid;
	var reid = document.frmJoin.reid;
	var pwd = document.frmJoin.pwd;
	var pwd_check = document.frmJoin.pwd_check;
	var name = document.frmJoin.name;
	var phone = document.frmJoin.phone;
	var email = document.frmJoin.email;
	// 이메일 유효성 검사용
	var validForm = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

	// 아이디 체크
	if (userid.value == "") {
		alert("아이디를 입력해 주세요!");
		userid.focus();

		return false;
	}
	if (userid.value.length < 5 || userid.value.length > 20) {
		alert("아이디는 5 ~ 20글자 입니다.");
		userid.focus();

		return false;
	}
	if (reid.value == "") {
		alert("아이디 중복체크를 해주세요.!");
		userid.focus();

		return false;
	}
	if (userid.value != reid.value) {
		alert("아이디 중복 체크를 다시해주세요.");
		userid.focus();

		return false;
	}

	// 비밀번호 체크
	if (pwd.value == "") {
		alert("비밀번호를 입력해 주세요!");
		pwd.focus();

		return false;
	}
	if (pwd.value.length < 5 || pwd.value.length > 20) {
		alert("비밀번호는 5 ~ 20글자 입니다.");
		pwd.value = null;
		pwd.focus();

		return false;
	}
	if (pwd_check.value == "") {
		alert("확인용 비밀번호를 입력해 주세요!");
		pwd_check.focus();

		return false;
	}
	if (pwd.value != pwd_check.value) {
		alert("비밀번호가 확인용 비밀번호와 일치하지 않습니다.");
		pwd_check.value = null;
		pwd_check.focus();

		return false;
	}

	// 이름 체크
	if (name.value == "") {
		alert("이름을 입력해 주세요!");
		name.focus();

		return false;
	}
	if (name.value.length > 30) {
		alert("이름은 30글자까지 쓸 수 있습니다.");
		name.focus();

		return false;
	}

	// 전화번호 체크
	if (phone.value == "") {
		alert("전화번호를 입력해 주세요!");
		phone.focus();

		return false;
	}
	if (phone.value.length > 15) {
		alert("전화번호는 15글자까지 쓸 수 있습니다.");
		phone.focus();

		return false;
	}

	// 이메일 체크
	// 이메일이 쓰여있다면
	if (email.value != "") {

		if (!validForm.test(email.value)) {
			alert("올바른 이메일 주소를 입력하세요")
			email.focus();

			return false;
		}
		if (email.value.length > 50) {
			alert("이메일은 50글자까지 쓸 수 있습니다.");
			email.focus();

			return false;
		}
	}

	//관리자번호 유효성 체크
	return adminNoReCheck_join();

}

function adminNoReCheck_join() {

	var adminno = document.frmJoin.adminno;
	var readminno = document.frmJoin.readminno;

	if (document.getElementById("admin").checked) {
		
		// 관리자 번호 체크
		if (adminno.value == "") {
			alert("관리자 번호확인을 해주세요.!");
			return false;
		}
		if (adminno.value != readminno.value) {
			alert("관리자 번호확인을 다시해주세요.");
			return false;
		}
	}

}
// 회원정보수정 화면 유효성 검사 메소드
function updateCheck() {

	var pwd = document.frmUpdt.pwd;
	var pwd_check = document.frmUpdt.pwd_check;
	var phone = document.frmUpdt.phone;
	var email = document.frmUpdt.email;
	// 이메일 유효성 검사용
	var validForm = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

	// 비밀번호 체크
	if (pwd.value == "") {
		alert("비밀번호를 입력해 주세요!");
		pwd.focus();

		return false;
	}
	if (pwd.value.length < 5 || pwd.value.length > 20) {
		alert("비밀번호는 5 ~ 20글자 입니다.");
		pwd.value = null;
		pwd.focus();

		return false;
	}
	if (pwd_check.value == "") {
		alert("확인용 비밀번호를 입력해 주세요!");
		pwd_check.focus();

		return false;
	}
	if (pwd.value != pwd_check.value) {
		alert("비밀번호가 확인용 비밀번호와 일치하지 않습니다.");
		pwd_check.value = null;
		pwd_check.focus();

		return false;
	}

	// 전화번호 체크
	if (phone.value == "") {
		alert("전화번호를 입력해 주세요!");
		phone.focus();

		return false;
	}
	if (phone.value.length > 15) {
		alert("전화번호는 15글자까지 쓸 수 있습니다.");
		phone.focus();

		return false;
	}

	// 이메일 체크
	// 이메일이 쓰여있다면
	if (email.value != "") {

		if (!validForm.test(email.value)) {
			alert("올바른 이메일 주소를 입력하세요")
			email.focus();

			return false;
		}
		if (email.value.length > 50) {
			alert("이메일은 50글자까지 쓸 수 있습니다.");
			email.focus();

			return false;
		}
	}

	//관리자번호 유효성 체크
	return adminNoReCheck_updt();

}

function adminNoReCheck_updt() {

	var adminno = document.frmUpdt.adminno;
	var readminno = document.frmUpdt.readminno;

	if (document.getElementById("admin").checked) {
		
		// 관리자 번호 체크
		if (adminno.value == "") {
			alert("관리자 번호확인을 해주세요.!");
			return false;
		}
		if (adminno.value != readminno.value) {
			alert("관리자 번호확인을 다시해주세요.");
			return false;
		}
	}

}
// 로그인 화면 유효성 검사 메소드
function loginCheck() {

	var userid = document.frmLogin.userid;
	var pwd = document.frmLogin.pwd;

	// 아이디 체크
	if (userid.value == "") {
		alert("아이디를 입력해 주세요!");
		userid.focus();

		return false;
	}
	if (userid.value.length < 5 || userid.value.length > 20) {
		alert("아이디는 5 ~ 20글자 입니다.");
		userid.focus();

		return false;
	}

	// 비밀번호 체크
	if (pwd.value == "") {
		alert("비밀번호를 입력해 주세요!");
		pwd.focus();

		return false;
	}
	if (pwd.value.length < 5 || pwd.value.length > 20) {
		alert("비밀번호는 5 ~ 20글자 입니다.");
		pwd.value = null;
		pwd.focus();

		return false;
	}

	return true;
}

// 아이디 중복 확인 메소드
function idCheck() {

	var userid = document.frmJoin.userid;

	if (userid.value == "") {
		alert("아이디를 입력하세요.");
		userid.focus();

		return;
	}
	if (userid.value.length < 5 || userid.value.length > 20) {
		alert("아이디는 5 ~ 20글자 입니다.");
		userid.focus();

		return;
	}

	// 아이디 중복 확인 창 생성
	var url = "member.do?command=id_check&userid=" + userid.value;

	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");

	return;
}
// 아이디 사용 버튼 클릭 시
function idOk(userid) {

	// 원래 창(부모 창) 아이디 값에 현재 창의 아이디 값을 셋팅
	opener.frmJoin.userid.value = document.frmIdChk.userid.value;
	// 중복확인이 된 아이디 값을 원래 창 reid(hidden속성) 값에 셋팅
	opener.frmJoin.reid.value = document.frmIdChk.userid.value;

	self.close();
}

function pwdCheck() {

	var pwd = document.frmPwdChk.pwd;

	// 비밀번호 체크
	if (pwd.value == "") {
		alert("비밀번호를 입력해 주세요!");
		pwd.focus();

		return false;
	}
	if (pwd.value.length < 5 || pwd.value.length > 20) {
		alert("비밀번호는 5 ~ 20글자 입니다.");
		pwd.value = null;
		pwd.focus();

		return false;
	}

	location.href = 'member.do?command=pwd_check&pwd=' + pwd.value;
}

function logout() {

	if (confirm("정말로 로그아웃 하시겠습니까?") == true) {
		location.href = 'member.do?command=logout';
	} else {
		return;
	}

}

function setAdminNo() {
	if ($('input:radio[id=user]').is(':checked')) {
		$('#adminno').hide();
	} else {
		$('#adminno').show();
	}
}

// 회원가입화면. 관리자번호 확인 메소드
function adminNoCheck_join() {

	var adminno = document.frmJoin.adminno;

	if (adminno.value == "") {
		alert("관리자번호를 입력하세요.");
		adminno.focus();

		return;
	}
	if (adminno.value.length < 8) {
		alert("관리자번호는 8글자 입니다.");
		adminno.focus();

		return;
	}
	
	// 관리자번호 확인 창 생성
	var url = "member.do?command=admin_check_join&adminno=" + adminno.value;

	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");

	return;

}

function adminNoCheck_updt() {

	var adminno = document.frmUpdt.adminno;

	if (adminno.value == "") {
		alert("관리자번호를 입력하세요.");
		adminno.focus();

		return;
	}
	if (adminno.value.length < 8) {
		alert("관리자번호는 8글자 입니다.");
		adminno.focus();

		return;
	}
	// 관리자번호 확인 창 생성
	var url = "member.do?command=admin_check_updt&adminno=" + adminno.value;

	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");

	return;

}
// 사용 버튼 클릭 시
function adminnoOk_join(adminno) {

	opener.frmJoin.adminno.value = document.frmAdminChk.adminno.value;
	opener.frmJoin.readminno.value = document.frmAdminChk.adminno.value;

	self.close();
}
function adminnoOk_updt(adminno) {

	opener.frmUpdt.adminno.value = document.frmAdminChk.adminno.value;
	opener.frmUpdt.readminno.value = document.frmAdminChk.adminno.value;

	self.close();
}