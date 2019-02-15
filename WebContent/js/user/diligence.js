var root = "/cubegroupware";
var control="/userdiligence";


	function getXMLHttpRequest(){
	if(window.ActiveXObject){
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e1){
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e2){
				return null;
			}
		}
	}else if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else{
		return null;
	}
}
	

	function sendRequest(url, params, callback, method){
		httpRequest = getXMLHttpRequest();
		
		var httpMethod = method ? method : 'GET';
		if(httpMethod != 'GET' && httpMethod != 'POST'){
			httpMethod = 'GET';
		}
		var httpParams = (params == null || params == '') ? null : params;
		var httpUrl = url;
		if(httpMethod == 'GET' && httpParams != null){
			httpUrl = httpUrl + "?" + params;
		}
		
		//alert("method == " + httpMethod + "\turl == " + httpUrl + "\tparam == " + httpParams);
		httpRequest.open(httpMethod, httpUrl, true);
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		httpRequest.onreadystatechange = callback;
		//alert(httpMethod == 'POST' ? httpParams : null);
		httpRequest.send(httpMethod == 'POST' ? httpParams : null);
	}
	
//----------------------------------------------------------------------------------------------------------------------------------
	
	$(document).ready(function(){
		
		$("#inbutton").click(function(){
		
			$("#intime").val($("#showtime").text());
			$("#inbutton").attr("disabled",true);
			
			$.ajax({
				type : "POST",
				dataType : 'text',
				url : root + control,
				data : {
					act : "getstarttime", intime : $("#intime").val(), user_diligence:"출근"
				},
				success : function(data) {
					null
				},
				error : function(e) {
					alert("에러!");
				}
			});
	
		
		});
		
		
		
		$("#outbutton").click(function(){
			
			$("#outtime").val($("#showtime").text()); 
			
			
			$.ajax({
				type : "POST",
				dataType : 'text',
				url : root + control,
				data : {
					act : "getendtime", outtime : $("#outtime").val(), intime : $("#intime").val(), user_diligence:"퇴근"
				},
				success : function(data) {
					null
				},
				error : function(e) {
					alert("에러!");
				}
			});
	
		
		});
		
	});
	



	
//----------------------------------------------------------------------------------------------------------------------------------------------
	
	function starttime() {
	    httpRequest = getXMLHttpRequest();//이런함수를 만든다.
	    httpRequest.onreadystatechange = gettime;//callback function 호출하고 수행 후, 돌아가는 곳 
	    //time.jsp
	    httpRequest.open("GET", "time.jsp", true);//무슨방식인지, 열파일경로,true 비동기, get
	    httpRequest.send(null);//여기는 파라메터 넘기는 곳, post
		
	 }//서버와 통신할 준비가 끝났다.

	

	 function gettime() {
	    if(httpRequest.readyState == 4){
	       if(httpRequest.status == 200){
	    	   //alert("200들어왔니?!");
	          result = httpRequest.responseText;//받아 온 값을 보낸다.
	          document.getElementById("showtime").innerHTML = result;
	          window.setTimeout("starttime();",1000);

	       }else{
	          alert("에러당!");
	       }
	    }
	 }


	 
	 
	 
	 
	 
