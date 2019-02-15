var root = "/cubegroupware";

var control = "/admindiligence";






$(document).ready(function() {
	aa();
});





var happyDayDtolist;
var len;

var idx;
function aa(){

$.ajax({
	type : "GET",
	dataType : 'json',
	url : root + control,
	data : {
		act : "happydaylist"

	},
	success : function(data) {
		//alert("happylist 뿌리기 성공!");
		
		happyDayDtoList(data);
				
				
	},
	error : function(e) {
		alert("에러!");
	}
});

}


function happyDayDtoList(data) {

	len = data.happyDayDtolist.length;// jsonlist

	happyDayDtolist = document.getElementById("happyDayDtolist"); // tbody

	//alert(data.happyDayDtolist[0].happy_end);
	for (var i = 0; i < len; i++) {
	
	var happy_name = data.happyDayDtolist[i].happy_name;
	var happy_code = data.happyDayDtolist[i].happy_code;
	var happy_start = data.happyDayDtolist[i].happy_start+" - "+data.happyDayDtolist[i].happy_end;

	/*
	var a = document.createElement("input");// <input></input>
	a.setAttribute("type", "button");
	a.setAttribute("id", "deletehappy");
	a.setAttribute("class", "btn btn-primary");
	a.setAttribute("value", "삭제");
	

	var cell4 = document.createElement("td");// <td></td>
	cell4.setAttribute("bgcolor", "#ffffff");// <td
												// bgcolor="#99ffff"></td>
	cell4.setAttribute("align", "center");
	cell4.appendChild(a);*/

	var row = selectcreateRow(happy_name, happy_code, happy_start);


	happyDayDtolist.appendChild(row);
	}
	

}


function selectcreateCell(data) {
	
	var cell = document.createElement("td");// <td></td>

	cell.setAttribute("bgcolor", "#ffffff");// <td bgcolor="#99ffff"></td>
	cell.setAttribute("align", "center");

	var txtNode = document.createTextNode(data);// "java2"

	cell.appendChild(txtNode);// <td bgcolor="#99ffff">java2</td>

	return cell;

}


function selectcreateRow(happy_name, happy_code, happy_start) {

	var row = document.createElement("tr");

	
	row.appendChild(selectcreateCell(happy_name));
	row.appendChild(selectcreateCell(happy_code));
	row.appendChild(selectcreateCell(happy_start));
//	row.appendChild(selectcreateCell(cell4));


	return row;
}










$("#addbtn").click(function(){
	
//alert("저장할꺼야?");
alert($("#scal1").val() +
		$("#scal2").val() +
		$("#happytext").val());

	
		if($("#happytext").val() ==''){
			
			alert("휴일제목을 지정해주세요!");
			
		}else{

			ff();
		}


});







function ff() {
	
	
	$.ajax({
		type : "GET",
		dataType : 'text',
		url : root + control,
		data : {
			act : "happyday",
			happy_start : $("#scal1").val(),
			happy_end : $("#scal2").val(),
			happytext : $("#happytext").val()
			
		},
		success : function(data) {
			//alert("성공!");
			
		},
		error : function(e) {
			alert("저장실패!");
		}
	});
	
}	


$("#deletehappy").click(function(){
	//alert("삭제?");
	$(document).ready(function() {
	$("#happyt").css("dispay", "none");
	});
	$.ajax({
		type : "GET",
		dataType : 'text',
		url : root + control,
		data : {
			act : "happydaydel",
			happyday_seq : $("")
			
		},
		success : function(data) {
			//alert("성공!");
			
		},
		error : function(e) {
			alert("삭제실패!");
		}
	});

	
});

