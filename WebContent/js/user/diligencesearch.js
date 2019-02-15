var root = "/cubegroupware";
var control="/admindiligence";



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


function date() {
//alert("date들어가?");	

	var now = new Date(); 
	var todayAtMidn = new Date(now.getFullYear(), now.getMonth(), now.getDate());

	// Set specificDate to a specified date at midnight.
	var specificDate1 = new Date($("#startdate").val());
	var specificDate2 = new Date($("#enddate").val());
	
	if (todayAtMidn.getTime() == specificDate1.getTime() && todayAtMidn.getTime() == specificDate2.getTime())
	{
		var url = root+control;	
		var param = "act=datesearch&startdate="+$("#startdate").val()+"&enddate="+$("#enddate").val();
		sendRequest(url, param, null, "POST");
	}
	else
	{
	    document.write("Different");
	}
	
	
}



function textsplit() {
	alert("textsplit들어왔니?");
}



function diligencesearch() {
	alert("diligencesearch");
	
	var string = $("#departsearchtext").val();
	var strArray = string.split(',');
	
	//console.log(strArray[0]+","+strArray[1]+","+strArray[2]+","+strArray[3]);
	
	//alert($("#employee_id2").val());
	
	var url = root+control;	
	
	var param = "act=allsearch&startdate="+$("#startdate").val()+"&enddate="+$("#enddate").val()+"&employee_id="+$("#employee_id2").val()+"&department_id="+$("#department_id2").val();
	
	sendRequest(url, param, null, "POST");
	
}


$("#modifybtn").click(function() {
	alert("수정?");
	document.form.getElementsByTagName("check").readOnly = true;
});
