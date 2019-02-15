var root = "/cubegroupware";
var control = "/login";
var select = "admin";
var user = "";
var pass = "";
var act = "";
var url = root + control;

var admin = document.getElementById("admin").value;

var member = document.getElementById("member").value;


function getXMLHttpRequest() {
	if (window.ActiveXObject) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
				return null;
			}
		}
	} else if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else {
		return null;
	}
}

var httpRequest = null;

function sendRequest(url, params, callback, method) {
	httpRequest = getXMLHttpRequest();

	var httpMethod = method ? method : 'GET';
	if (httpMethod != 'GET' && httpMethod != 'POST') {
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if (httpMethod == 'GET' && httpParams != null) {
		httpUrl = httpUrl + "?" + params;
	}

	// alert("method == " + httpMethod + "\turl == " + httpUrl + "\tparam == " +
	// httpParams);
	httpRequest.open(httpMethod, httpUrl, true);
	httpRequest.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback;
	// alert(httpMethod == 'POST' ? httpParams : null);
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}

// 로그인 유효성 펑션
function loginCheck() {

	if (document.loginForm.username.value == "") {
		alert("ID를 입력해 주세요!");
	} else if (document.loginForm.password.value == "") {
		alert("PASSWORD를 입력해 주세요!");
	} else if($(':radio[name="logincheck"]:checked').length < 1){//유효성 체크가 안되네?
		
			alert("체크박스를 체크 해 주세요!");
	}else{

		 if (document.loginForm.logincheck.value == member) {
				
				if (document.loginForm.username.value != admin) {
					
					document.loginForm.action = root + control;
					
					document.loginForm.submit();
					
				} else {
					
					location.href;
				
				}
			
		
			// document.location.href ="test.jsp"; //단순 페이지 이동
		}
		 
		 if (document.loginForm.logincheck.value == admin) {// admin이다
				
				if (document.loginForm.username.value == admin) {
					
					document.loginForm.action = root + control;
					
					document.loginForm.submit();
					
				} else {
					
					location.href;
					
				}
				
			}
	}
}

// 로그인 성공시 다시 돌아오는 오류 페이지
function displayResult() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			result = httpRequest.responseText;
			window.location.href = "pages/loginpage/test.jsp";
		}
	}
}
