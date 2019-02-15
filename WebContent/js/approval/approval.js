var root="/cubegroupware";

function approvalok(confirmlist_ok, seq, id, docname, docwriteid){
	if(confirm("결제하시겠습니까?")== true){
		$.ajax({
		    type: "GET",
		    url: root+"/usernook",
		    data: { act: "approvalok", confirmlist: confirmlist_ok, seq:seq, id:id, docname:docname, docwriteid:docwriteid},
		    success:function(data) {
		    	approvalimg(data);
		    },
		    error: function(e) {
		    	alert("error!!");
		    }
	    });
	} else 
		return;
}

function approvalimg(data){
	var output =data.split('@');
	var approvaldiv = "#approvalok"+output[0];
	var approvalcommit="결재완료";
	if(output[0]==output[2]){
		document.getElementById("docstate").innerHTML=approvalcommit;
	}
	$(approvaldiv).append(output[1]);
	$(approvaldiv).show();
	$("button#confbtn,button#deferbtn,button#returnbtn").attr("disabled",true);
}

function approvalcancel(confirmlist_ok, seq, id, docname){
	if(confirm("반려하시겠습니까?")== true){
		$.ajax({
		    type: "GET",
		    url: root+"/usernook",
		    data: { act: "approvalcancel", confirmlist: confirmlist_ok, seq:seq, id:id, docname:docname},
		    success:function(data) {
		    	approvalcancelimg(data);
		    },
		    error: function(e) {
		    	alert("error!!");
		    }
	    });
	} else 
		return;
}


function approvalcancelimg(data){
	var output =data.split('@');
	var approvaldiv = "#approvalok"+output[0];
	var approvalcommit="반려";
	if(output[0]==output[2]){
		document.getElementById("docstate").innerHTML=approvalcommit;
	}
	$(approvaldiv).append(approvalcommit);
	$(approvaldiv).show();
	$("button#confbtn,button#deferbtn,button#returnbtn").attr("disabled",true);
}

function previouspage(docview){
	if("userreport"==docview){
		document.location.href=root+"/usersenddoc?act=approval_userreport";
	} else if ("usernodoc"==docview){
		document.location.href=root+"/usernook?act=approval_nook";
	} else if ("userwithdrawdoc"==docview){
		document.location.href=root+"/userwithdrawdoc?act=approval_userwithdrawdoc";
	} else if ("userokdoc"==docview){
		document.location.href=root+"/usernook?act=approval_okok";
	} else if ("userreturndoc"==docview){
		document.location.href=root+"/userreturndoc?act=approval_userreturn";
	} else if ("business"==docview){
		document.location.href=root+"/userapprovalmain?act=approval_business";
	} else if ("department"==docview){
		document.location.href=root+"/userapprovalmain?act=approval_department";
	} else if ("usersavedoc"==docview){
		document.location.href=root+"/usersavedoc?act=approval_usersavedoc";
	} else if ("workreport"==docview){
		document.location.href=root+"/usermyworkreport?act=usermyworkcheck";
	} else if ("receiveworkreport"==docview){
		document.location.href=root+"/usermyworkreport?act=receiveworkcheck";
	} else if ("docmanage"==docview){
		document.location.href=root+"/adminapproval?act=confirm_docmanage";
	} else if ("noticeview"==docview){
		document.location.href=root+"/adminhome?act=helpdesk_list";
	} else
		document.location.href=root+"/usersenddoc?act=approval_userreport";
};

function approvalsave(seq){
	if(confirm("회수하시겠습니까?")== true){
		document.location.href=root+"/usersavedoc?act=approval_usersavedoc&seq="+seq;
	} else
		return;
}

function newpage(dockind){
	if('기안서'==dockind){
		document.location.href=root+"/userdocwrite?act=approval_signdocwrite";
	} else if('품의서'==dockind){
		document.location.href=root+"/userdocwrite?act=approval_orderdocwrite";
	} else if('휴가계'==dockind){
		document.location.href=root+"/userdocwrite?act=approval_vacdoc";
	} else if('출장신청서'==dockind){
		document.location.href=root+"/userdocwrite?act=approval_biztripdoc";
	} else if('출장보고서'==dockind){
		document.location.href=root+"/userdocwrite?act=approval_biztrip_report";
	} else if('사직서'==dockind){
		document.location.href=root+"/userdocwrite?act=approval_deaddoc";
	}
}

function approvalupdate(seq, dockind){
	if('기안서'==dockind){
		document.location.href=root+"/userdocupdate?act=signdocupdate&seq="+seq;
	} else if('품의서'==dockind){
		document.location.href=root+"/userdocupdate?act=orderdocupdate&seq="+seq;
	} else if('휴가계'==dockind){
		document.location.href=root+"/userdocupdate?act=vacdocupdate&seq="+seq;
	} else if('출장신청서'==dockind){
		document.location.href=root+"/userdocupdate?act=biztripdocupdate&seq="+seq;
	} else if('출장보고서'==dockind){
		document.location.href=root+"/userdocupdate?act=biztrip_reportupdate&seq="+seq;
	} else if('사직서'==dockind){
		document.location.href=root+"/userdocupdate?act=deaddocupdate&seq="+seq;
	} else if('업무보고'==dockind){
		document.location.href=root+"/usermyworkreport?act=workreportupdate&seq="+seq;
	}
}

function approvalupdates(seq, dockind){
	if('기안서'==dockind){
		document.location.href=root+"/userdocupdate?act=signdocupdate&admin=admin&seq="+seq;
	} else if('품의서'==dockind){
		document.location.href=root+"/userdocupdate?act=orderdocupdate&admin=admin&seq="+seq;
	} else if('휴가계'==dockind){
		document.location.href=root+"/userdocupdate?act=vacdocupdate&admin=admin&seq="+seq;
	} else if('출장신청서'==dockind){
		document.location.href=root+"/userdocupdate?act=biztripdocupdate&admin=admin&seq="+seq;
	} else if('출장보고서'==dockind){
		document.location.href=root+"/userdocupdate?act=biztrip_reportupdate&admin=admin&seq="+seq;
	} else if('사직서'==dockind){
		document.location.href=root+"/userdocupdate?act=deaddocupdate&admin=admin&seq="+seq;
	} 
}

function approvaldelete(seq, dockind){
	if(confirm("삭제하시겠습니까?")== true){
		document.location.href=root+"/usersavedoc?act=usersavedoc_delete&seq="+seq+"&dockind="+dockind;
	} else
		return;
}

function approvalreport(seq){
	if(confirm("상신하시겠습니까?")== true){
		document.location.href=root+"/usersavedoc?act=usersavedoc_update&seq="+seq;
	} else
		return;
}