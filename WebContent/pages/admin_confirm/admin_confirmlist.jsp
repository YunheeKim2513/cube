<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.Confirmlist_infoDto, com.cube.model.dto.EmployeesDto"%>
<%@ include file="/common/admin_public.jsp" %>
<%
	List<Confirmlist_infoDto> list = (List<Confirmlist_infoDto>) request.getAttribute("confirmlist");
	List<EmployeesDto> confirmlistview = (List<EmployeesDto>) request.getAttribute("confirmlistview");
%>
        <!-- /#page-wrapper -->
        <form name ="confirmForm" id="confirmForm" method="post" action="">
        <input type="hidden" id="act" name="act" value="confirmlistregistor">
        <input type="hidden" name="dockind" value="기안서">
               <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header">결재선리스트</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <!-- <form name ="form" method="get" action="">
            <input type="hidden" name="act" value="register">
            <input type="hidden" name="dockind" value="기안서"> -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table style="width:100%" class="table table-striped table-bordered table-hover">
                                <thead>
					              <tr>
					                <th>결재선 라인 그룹 목록</th>
					                <td align="center">
					                	<div id="confirmlistview"></div>
					                </td>
					                <td rowspan="2" align="center" valign="middle">
					                	<button type="button"  class="btn btn-primary btn-lg" id="confirmlistdelete" style="width:60px; height:70px; padding-top: 8px;">
			                                	삭제
			                            </button>
					                </td>
					              </tr>
					              <tr>
					                <th>결재선 라인 그룹 이름</th>
					                <td align="center">
										<input type='text' id="inputtext" name="inputtext" value="" class="form-control" style="width:90%;">
					                </td>
					              </tr>
					            </thead>
					         </table>
					         <table style="width:100%" class="table table-striped table-bordered table-hover">   
					            <tbody>
					              <tr>
					                <th style="width:95%; text-align:left">1. 결재자</th>
					                <td align="center" valign="middle" rowspan="2" >  
			                            <!-- Button trigger modal -->
			                            <button type="button" class="btn btn-primary btn-lg" id="confirmnamebtn0" onclick="javascript:test(this.value, this.id);" style="width:60px; height:70px; padding-top: 8px;" data-toggle="modal" data-target="#receivedep">
			                                	지정
			                            </button>
					                </td>
					              </tr>
					              <tr>  
					                <th style="width:95%">
					                  <input type="text" id="confirm0" name="confirm0" value="" class="form-control" readonly="readonly">
					                <input type="text" id="confirms0" name="confirms0" value="" class="form-control" readonly="readonly">
					                </th>
					              </tr>
					              <tr>
					                <th style="width:95%; text-align:left">2. 결재자</th>
					                <td align="center" valign="middle" rowspan="2">  
			                            <!-- Button trigger modal -->
			                            <button type="button" class="btn btn-primary btn-lg" id="confirmnamebtn1" onclick="javascript:test(this.value, this.id);" style="width:60px; height:70px; padding-top: 8px;" data-toggle="modal" data-target="#receivedep">
			                                	지정
			                            </button>
					                </td>
					              </tr>
					              <tr style="width:95%">  
					                <th>
					                  <input type="text" id="confirm1" name="confirm1" value="" class="form-control" readonly="readonly">
					                  <input type="text" id="confirms1" name="confirms1" value="" class="form-control" readonly="readonly">
					                </th>
					              </tr><tr>
					                <th style="width:95%; text-align:left">3. 결재자</th>
					                <td align="center" valign="middle" rowspan="2">  
			                            <!-- Button trigger modal -->
			                            <button type="button" class="btn btn-primary btn-lg" id="confirmnamebtn2" onclick="javascript:test(this.value, this.id);" style="width:60px; height:70px; padding-top: 8px;" data-toggle="modal" data-target="#receivedep">
			                                	지정
			                            </button>
					                </td>
					              </tr>
					              <tr>  
					                <th style="width:95%">
					                  <input type="text" id="confirm2" name="confirm2" value="" class="form-control" readonly="readonly">
					                  <input type="text" id="confirms2" name="confirms2" value="" class="form-control" readonly="readonly">
					                </th>
					              </tr>
					               <!-- Modal -->
		                            <div class="modal fade" id="receivedep" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		                                <div class="modal-dialog">
		                                    <div class="modal-content">
		                                        <div class="modal-header">
		                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                                            <h4 class="modal-title" id="myModalLabel">수신부서 지정하기</h4>
		                                            <p></p>
		                                            	<button type="button" class="btn btn-primary" id="btnExpandAll">전체부서 열기</button>&nbsp;&nbsp;&nbsp;
	 															<button type="button" class="btn btn-primary" id="btnCollapseAll">전체부서 닫기</button>
		                                        </div>
		                                        <div class="modal-body">
		                                         <div id="tree1">
		                                           <ul>
		                                           	<%
		                                           	int size=confirmlistview.size();
		                                           	String tmp="";
		                                           	for(int i=0; i<size; i++) {
		                                           		EmployeesDto employeesDto2 = confirmlistview.get(i);
		                                           		int idx=1;
		                                           		if(!employeesDto2.getDepartment_name().equals(tmp)){
		                                           	%>
		                                           		<li id="cid<%=idx++ %>" class="folder"><%=employeesDto2.getDepartment_name() %>
		                                           		<ul>
		                                           	<%		
		                                           		} 
		                                           	%>
		                                           		<li id="<%=employeesDto2.getEmployee_id()%>"><%=employeesDto2.getDepartment_name()+" ("+employeesDto2.getGarde_name()+")"+employeesDto2.getName() %>
		                                           	<%	
		                                           		tmp = employeesDto2.getDepartment_name();
		                                           		if(i<size-1){
		                                           		if(!confirmlistview.get(i+1).getDepartment_name().equals(employeesDto2.getDepartment_name())){%></ul><%}}
		                                           	}%>
		                                           </ul>
		                                           </div>
		                                        </div>
		                                    </div>
		                                    <!-- /.modal-content -->
		                                </div>
		                                <!-- /.modal-dialog -->
		                            </div>
		                            <!-- /.modal -->
		                            <tr>
		                            	<td colspan="2" align="center" valign="middle">
		                            		<button type="button" id="confirmlistregistor" class="btn btn-primary" style="margin-bottom:7px; width:500px; height:60px">결재선 저장</button>
		                            	</td>
		                            </tr>
					            </tbody>
                            </table>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
    </form>
    
     <!--/#wrapper -->

       <!-- jQuery -->
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=root %>/css/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=root %>/css/vendor/metisMenu/metisMenu.min.js"></script>


    <!-- Custom Theme JavaScript -->
    <script src="<%=root %>/css/dist/js/sb-admin-2.js"></script>

	
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
    	confirmajax();
    });
    </script>
    
	
	<script src="<%=root %>/modal/jquery/jquery-ui.custom.js" type="text/javascript"></script>
	<script src="<%=root %>/modal/jquery/jquery.cookie.js" type="text/javascript"></script>
	<link href="<%=root %>/modal/src/skin-vista/ui.dynatree.css" rel="stylesheet" type="text/css">
	<script src="<%=root %>/modal/src/jquery.dynatree.js" type="text/javascript"></script>
	<script type="text/javascript">
	var btnids;
	 $(function(){
	   // Initialize the tree inside the <div>element.
	   // The tree structure is read from the contained <ul> tag.
	   $("#tree1").dynatree({
	     onActivate: function(node) {
	  		var parameter="act=confirmbtn&confirmname="+encodeURI(node.data.title);
	  		sendRequest("<%=root%>/userdocwrite",parameter,receiveParams, "GET");
	  		function receiveParams() {
	  			if(httpRequest.readyState==4){
	  				if(httpRequest.status==200){
	  					if(btnids=="confirmnamebtn0"){
	   					document.getElementById("confirm0").value = node.data.key;
	   					document.getElementById("confirms0").value = node.data.title;
						document.getElementById("confirmnamebtn0").value="update";
						document.getElementById("confirmnamebtn0").innerHTML="수정";
	  					} else if(btnids=="confirmnamebtn1"){
	 					document.getElementById("confirm1").value = node.data.key;
	 					document.getElementById("confirms1").value = node.data.title;
						document.getElementById("confirmnamebtn1").value="update";
						document.getElementById("confirmnamebtn1").innerHTML="수정";
	  					} else if(btnids=="confirmnamebtn2"){
	 					document.getElementById("confirm2").value = node.data.key;
	 					document.getElementById("confirms2").value = node.data.title;
						document.getElementById("confirmnamebtn2").value="update";
						document.getElementById("confirmnamebtn2").innerHTML="수정";
	  					}
	  				}
	  			}
	  		} 
	     if( node.data.url )
	       window.open(node.data.url, node.data.target);
	     },
	     onDeactivate: function(node) {
	       $("#echoSelected").text("-");
	     },
	     onFocus: function(node) {
	       $("#echoFocused").text(node.data.title);
	     },
	     onBlur: function(node) {
	       $("#echoFocused").text("-");
	     },
	     onLazyRead: function(node){
	       var fakeJsonResult = [
	         { title: 'Lazy node 1', isLazy: true },
	         { title: 'Simple node 2', select: true }
	       ];
	     }
	   });
	   $("#tree2, #tree3").dynatree({
	       onActivate: function(node) {
	    		var parameter="act=docconfirmbtn&confirmname="+encodeURI(node.data.title);
	    		sendRequest("<%=root%>/userdocwrite",parameter,receiveParams, "GET");
	    		function receiveParams() {
	    			if(httpRequest.readyState==4){
	    				if(httpRequest.status==200){
	    					if(btnids=="receivebtn"){
	    						$("#receiveinputbox").val(node.data.title);
	    					} else if(btnids=="referencebtn"){
	    						$("#referenceinputbox").val(node.data.title);
	    					}
	    				}
	    			}
	    		} 
	       if( node.data.url )
	         window.open(node.data.url, node.data.target);
	       },
	       onDeactivate: function(node) {
	         $("#echoSelected").text("-");
	       },
	       onFocus: function(node) {
	         $("#echoFocused").text(node.data.title);
	       },
	       onBlur: function(node) {
	         $("#echoFocused").text("-");
	       },
	       onLazyRead: function(node){
	         var fakeJsonResult = [
	           { title: 'Lazy node 1', isLazy: true },
	           { title: 'Simple node 2', select: true }
	         ];
	       }
	     });
	   $("#btnExpandAll").click(function(){
	       $("#tree1, #tree2, #tree3").dynatree("getRoot").visit(function(node){
	         node.expand(true);
	       });
	       return false;
	     });
	     $("#btnCollapseAll").click(function(){
	       $("#tree1, #tree2, #tree3").dynatree("getRoot").visit(function(node){
	         node.expand(false);
	       });
	       return false;
	     });
	 });  
	 
	 var resultlen;
	 
	 function confirmline(optionval) {
		 var selectval=optionval;
		if(selectval!="choice"){
		var parameter="act=docconfirmnum&confirmname="+encodeURI(optionval);
		sendRequest("<%=root%>/userdocwrite",parameter,receiveParam, "GET");
		} else{ 
			$("#inputtext").val("");
			$("#inputtext").attr("readonly",false);
			for(var i=0; i<resultlen; i++){
				var str1 = "confirmnamebtn"+i;
				var str2 = "confirm"+i;
				var str3 = "confirms"+i;
				document.getElementById(str2).value = "";
				document.getElementById(str3).value = "";
				document.getElementById(str1).value="appoint";
				document.getElementById(str1).innerHTML="지정";
			}
			return;
		}
	}
	
	function test(btval, btid){
		btnids=btid;
		if(btval=="appoint"){
			return;
		} else {
			var btstr = btid.substr(btid.length-1);
			var str1 = "confirmnamebtn"+btstr;
			var str2 = "confirm"+btstr;
			var str3 = "confirms"+btstr;
			document.getElementById(str2).value = "";
			document.getElementById(str3).value = "";
			document.getElementById(str1).value="appoint";
			document.getElementById(str1).innerHTML="지정";
			event.stopPropagation();
		}
	}
	
	function receiveParam() {
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				result = httpRequest.responseText;
				var result3 = result.split('@');
				var id = result3[0];
				var name = result3[1];
				var result1 = name.split('|');
				var result2 = id.split(',');
				resultlen=result1.length;
				$("#inputtext").val($("#confirmlist option:selected").text());
				$("#inputtext").attr("readonly",true);
				for(var i=0; i<resultlen; i++){
					var str1 = "confirmnamebtn"+i;
					var str2 = "confirm"+i;
					var str3 = "confirms"+i;
					if(result1[i]){
						document.getElementById(str2).value = result2[i];
						document.getElementById(str3).value = result1[i];
						document.getElementById(str1).value="update";
						document.getElementById(str1).innerHTML="수정";
					} else{
						document.getElementById(str2).value = "";
						document.getElementById(str3).value = "";
						document.getElementById(str1).value="appoint";
						document.getElementById(str1).innerHTML="지정";
					}
				}
			} 
		}	
	}
	
	var insertupdate;
	
	$("#confirmlistregistor").click(function(){
		if(!$("#inputtext").val()){
			alert("결재선 라인 그룹 이름을 입력해주세요");
			return;
		}else if(!$("#confirm0").val()){
			alert("1. 결재자를 선택해 주시기 바랍니다.");
			return;
		}
		var flag=0;
		for(var i=0; i<<%=list.size()%>; i++){
			var optionid="#choice"+i;
			var optiontext=$(optionid).text();
			if($("#inputtext").val()==optiontext){
				if(confirm("덮어쓰기를 하시겠습니까?")== true){
					flag=1;
					insertupdate="update";
					confirminupajax();		
				}else{
					return;
				}
			} else if(i==<%=list.size()-1%> && $("#inputtext").val()!=optiontext && flag==0){
				if(confirm("결재선을 만드시겠습니까?")== true){
					insertupdate="insert";
					confirminupajax();					
				}else{
					return;
				}
			}
		}
	});
	
	function confirminupajax(){
		var conname=$("#inputtext").val();
		var conid1=$("#confirm0").val();
		var conid2=$("#confirm1").val();
		var conid3=$("#confirm2").val();
		var conname=$("#inputtext").val();
		var parameter="act=admin_confirmlists&confirmname="+encodeURI(conname)+"&con1="+conid1+"&con2="+conid2+"&con3="+conid3+"&inup="+insertupdate;
		sendRequest("<%=root%>/adminapproval",parameter,receiveParams1, "GET");
	}
	
	function confirmajax(){
		var parameter="act=admin_confirmlists";
		sendRequest("<%=root%>/adminapproval",parameter,receiveParams1, "GET");
	}
	
	$("#confirmlistdelete").click(function(){
		if($("#inputtext").val()){
			if(confirm("해당 결재선을 삭제하시겠습니까?")==true){
				insertupdate = "delete";
				var parameter="act=admin_confirmlists&confirmcode="+$("#confirmlist").val()+"&inup="+insertupdate+"&con1="+$("#confirm0").val();
				sendRequest("<%=root%>/adminapproval",parameter,receiveParams1, "GET");
			} else {
				return;
			}
		} else 
			alert("삭제할 결재선을 선택해주시기바랍니다.");
			return;
	});
	
	function receiveParams1() {
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				var result = httpRequest.responseText;
				$("#confirmlistview").html(result);
				for(var i=0; i<3; i++){
					var str1 = "confirmnamebtn"+i;
					var str2 = "confirm"+i;
					var str3 = "confirms"+i;
					document.getElementById(str2).value = "";
					document.getElementById(str3).value = "";
					document.getElementById(str1).value="appoint";
					document.getElementById(str1).innerHTML="지정";
				}
				$("#inputtext").val("");
				$("#inputtext").attr("readonly", false);
				result="";
			}
		}
	} 
		
	</script>
	
	
</body>
</html>
