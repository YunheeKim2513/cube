var root = "/cubegroupware";

var control = "/admindiligence";

$("#diligencegroupInputbtn").click(function() {

	$.ajax({
		type : "POST",
		dataType : 'text',// 데이타 타입을 text으로 받겠다.
		url : root + control,
		data : {
			act : "diligenceinsert",
			diligencegrouptext : $("#diligencegrouptext").val(),
			diligenceselect : $("#diligenceselect").val()
		},
		success : function(data) {// 알아서 맞춰준다.
			// alert("그룹넣기 성공!");
			
			aa();

		},
		error : function(e) {
			alert("값을 넣어주세요!");
		}
	});

});
// ---------------------------------------------------------------------------------------------

$("#diligencesave").click(function() {// 근태 시간 설정

	$.ajax({
		type : "POST",
		dataType : 'text',// 데이타 타입을 text으로 받겠다.
		url : root + control,
		data : {
			act : "diligencesaveact",
			starttime : $("#starttime").val(),
			starthour : $("#starthour").val(),
			startmin : $("#startmin").val(),
			endtime : $("#endtime").val(),
			endhour : $("#endhour").val(),
			endmin : $("#endmin").val(),
			diligencelist : $("#diligencelist").val()
		},
		success : function(data) {// 알아서 맞춰준다.
			// alert("근태리스트를 넣고 뿌리기성공!");

			bb();
		},
		error : function(e) {
			alert("에러!");
		}
	});

});

// -------------------------------------------------------------------------------------

var diligencelist;

$(document).ready(function() {
	aa();

	bb();
});

function aa() {// 이걸 통째로 함수로 만들어서 호출해야지 계속적으로 보인다.
	$.ajax({
		type : "POST",
		dataType : 'json',// 데이타 타입을 json으로 받겠다.
		url : root + control,
		data : {
			act : "diligencegroupselect"
		},
		success : function(data) {// 알아서 맞춰준다.
			// alert("그룹뿌리기 성공!");
			
			diligenceList(data);
		},
		error : function(e) {
			alert("에러!");
		}
	});
}

var len;

function diligenceList(data) {

	len = data.diligencelist.length;// jsonlist

	diligencelist = document.getElementById("diligencelist"); // tbody
	
	clearListt();
	
	for (var i = 0; i < len; i++) {

		var group_standard = data.diligencelist[i].group_standard;

		var row = createRow(group_standard);

		diligencelist.appendChild(row);

	}
}



function clearListt() {
	var len = diligencelist.childNodes.length;
	for (var i = len - 1; i >= 0; i--) {// 뒤에서 부터 지워야 된다 안 그럼 더럽게 지워짐
		diligencelist.removeChild(diligencelist.childNodes[i]);
	}
}


function createCell(data) {

	var cell = document.createElement("option");// <td></td>
	cell.setAttribute("bgcolor", "#99ffff");// <td bgcolor="#99ffff"></td>
	var txtNode = document.createTextNode(data);// "java2"
	cell.appendChild(txtNode);// <td bgcolor="#99ffff">java2</td>

	return cell;

}

function createRow(group_standard) {

	var row = document.createElement("option");
	row.appendChild(createCell(group_standard));

	return row;
}

// -----------------------------------------------------------------------------------------------

var diligencegrouplist;

function bb() {// 이걸 통째로 함수로 만들어서 호출해야지 계속적으로 보인다.
	$.ajax({
		type : "POST",
		dataType : 'json',// 데이타 타입을 json으로 받겠다.
		url : root + control,
		data : {
			act : "diligenceselectact"
		},
		success : function(data) {// 알아서 맞춰준다.
			// alert("리스트를 뿌려주는 부분 ");

			diligencegroupList(data);
		},
		error : function(e) {
			alert("에러!");
		}
	});
}

var idx = 0;

var len;
//var admintime_seq;
function diligencegroupList(data) {// 여기는 처음 접근했을때만 생성 부분
	// alert("그룹뿌리기 성공!fffffffffff");

	len = data.diligencegrouplist.length;// jsonlist

	diligencegrouplist = document.getElementById("diligencegrouplist"); // tbody

	// var row =document.createElement("tr");
	clearList();
	

	
	for (var i = 0; i < len; i++) {

		var admintime_seq = data.diligencegrouplist[i].admintime_seq;
		var group_standard = data.diligencegrouplist[i].group_standard;
		var startcon = data.diligencegrouplist[i].startcon;
		var endcon = data.diligencegrouplist[i].endcon;

		var ck = document.createElement("input");// <input></input>
		ck.setAttribute("type", "checkbox");
		ck.setAttribute("value", idx++);
		ck.setAttribute("name", "chklist");
		ck.setAttribute("class", "select");
		
		var cell2 = document.createElement("td");// <td></td>
		cell2.setAttribute("bgcolor", "#ffffff");// <td
													// bgcolor="#99ffff"></td>
		cell2.setAttribute("align", "center");
		cell2.appendChild(ck);

		var row = selectcreateRow(admintime_seq, group_standard, startcon,
				endcon, cell2);

		diligencegrouplist.appendChild(row);

	}
	
	
	
	$("#deletebtn").click(function() {
		// 체크박스를 누른것을 감지해 버튼을 누르면 삭제되는 부분

		 if( $(":checkbox[name='chklist']:checked").length ==0 ){
			    alert("수정할 항목을 하나만 체크해주세요.");
			    return;
		 }else{
			 var chk_val = "";
			 
			 $(":checkbox[name='chklist']:checked").each(function(diligencegrouplist) {
	
				// alert(data.diligencegrouplist[diligencegrouplist].admintime_seq);
				 var seqnum = data.diligencegrouplist[diligencegrouplist].admintime_seq;
				 
				// alert(seqnum);
				 
				 
				 $.ajax({
						type : "POST",
						dataType : 'text',// 데이타 타입을 json으로 받겠다.
						url : root + control,
						data : {
							act : "deletebtn", admintime_seq : seqnum
						},
						success : function() {// 알아서 맞춰준다.
							//alert("삭제 컨트롤러로~ 고고싱~!");
							 bb();
						},
						error : function(e) {
							alert("에러!");
						}
					});
				 
				 
			});

			
		 }
		 
		 
		
	});
	
	
	

}

function clearList() {
	var len = diligencegrouplist.childNodes.length;
	for (var i = len - 1; i >= 0; i--) {// 뒤에서 부터 지워야 된다 안 그럼 더럽게 지워짐
		diligencegrouplist.removeChild(diligencegrouplist.childNodes[i]);
	}
}

$("#allck").click(function() {

	for (var i = 0; i < len; i++) {// 첨부터 체크를 하려면 이렇게 초기화를 해야 한다.

		$("input[type=checkbox]").prop("checked", true);

	}

});

$("#alldeck").click(function() {

	for (var i = 0; i < len; i++) {// 첨부터 체크를 하려면 이렇게 초기화를 해야 한다.

		$("input[type=checkbox]").prop("checked", false);

	}

});

function selectcreateCell(data) {

	var cell = document.createElement("td");// <td></td>

	cell.setAttribute("bgcolor", "#ffffff");// <td bgcolor="#99ffff"></td>
	cell.setAttribute("align", "center");

	var txtNode = document.createTextNode(data);// "java2"

	cell.appendChild(txtNode);// <td bgcolor="#99ffff">java2</td>

	return cell;

}

function selectcreateRow(admintime_seq, group_standard, startcon, endcon, cell2) {

	var row = document.createElement("tr");

	
	
	row.appendChild(selectcreateCell(admintime_seq));
	row.appendChild(selectcreateCell(group_standard));
	row.appendChild(selectcreateCell(startcon));
	row.appendChild(selectcreateCell(endcon));
	row.appendChild(cell2);

	// row.appendChild(createBtn(btn));

	return row;
}





