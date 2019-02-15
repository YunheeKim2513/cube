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
					act : "getstarttime", intime : $("#intime").val(), user_diligence:"���"
				},
				success : function(data) {
					null
				},
				error : function(e) {
					alert("����!");
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
					act : "getendtime", outtime : $("#outtime").val(), intime : $("#intime").val(), user_diligence:"���"
				},
				success : function(data) {
					null
				},
				error : function(e) {
					alert("����!");
				}
			});
	
		
		});
		
	});
	



	
//----------------------------------------------------------------------------------------------------------------------------------------------
	
	function starttime() {
	    httpRequest = getXMLHttpRequest();//�̷��Լ��� �����.
	    httpRequest.onreadystatechange = gettime;//callback function ȣ���ϰ� ���� ��, ���ư��� �� 
	    //time.jsp
	    httpRequest.open("GET", "time.jsp", true);//�����������, �����ϰ��,true �񵿱�, get
	    httpRequest.send(null);//����� �Ķ���� �ѱ�� ��, post
		
	 }//������ ����� �غ� ������.

	

	 function gettime() {
	    if(httpRequest.readyState == 4){
	       if(httpRequest.status == 200){
	    	   //alert("200���Դ�?!");
	          result = httpRequest.responseText;//�޾� �� ���� ������.
	          document.getElementById("showtime").innerHTML = result;
	          window.setTimeout("starttime();",1000);

	       }else{
	          alert("������!");
	       }
	    }
	 }


	 
	 
	 
	 
	 
