var root = "/cubegroupware";

var control = "/adminhome";




$(document).ready(function(){ 
	aa();
});






var nolist;
var len;

var idx;
function aa(){

	
	$.ajax({
		type : "POST",
		dataType : 'json',// 데이타 타입을 text으로 받겠다.
		url : root + control,
		data : {
			act : "nolist"
		},
		success : function(data) {// 알아서 맞춰준다.
			//alert("성공!");
			noList(data);
		},
		error : function(e) {
			alert("에러!");
		}
	});

}


function noList(data) {

	len = data.nolist.length;// jsonlist

	nolist = document.getElementById("nolist"); // tbody

	//alert(data.happyDayDtolist[0].happy_end);
	for (var i = 0; i <10; i++) {
	
	var notice_seq = data.nolist[i].notice_seq;
	var notice_subject = data.nolist[i].notice_subject;
	var notice_writer = data.nolist[i].notice_writer;
	var notice_date = data.nolist[i].notice_date;
	
	

	var row = selectcreateRow(notice_seq, notice_subject, notice_writer, notice_date);


	nolist.appendChild(row);
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


function selectcreateRow(notice_seq, notice_subject, notice_writer, notice_date) {

	var row = document.createElement("tr");

	
	row.appendChild(selectcreateCell(notice_seq));
	row.appendChild(selectcreateCell(notice_subject));
	row.appendChild(selectcreateCell(notice_writer));
	row.appendChild(selectcreateCell(notice_date));


	return row;
}








