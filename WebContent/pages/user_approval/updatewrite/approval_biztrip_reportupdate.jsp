<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.cube.model.dto.*"%>
<%@ include file="/common/user_public.jsp" %>
<%
	List<Confirmlist_infoDto> list = (List<Confirmlist_infoDto>) request.getAttribute("confirmlist");
	List<EmployeesDto> confirmlistview = (List<EmployeesDto>) request.getAttribute("confirmlistview");
	Biztrip_reportDto biztrip_reportDto = (Biztrip_reportDto) request.getAttribute("biztripreportwrite");
%>
		<form name ="biztripForm" id="biztripForm" method="post" action="">
        <input type="hidden" id="act" name="act" value="triprepotupdate">
        <input type="hidden" name="dockind" value="출장보고서">
        <input type="hidden" id="docseq" name="docseq" value="<%=biztrip_reportDto.getDoc_seq() %>">
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header"><%=biztrip_reportDto.getDoc_name() %></h1>
                    	<div style="text-align:right; vertical-align:middle">
	                        <select class="form-control22" id="biztripconfirmlist" name="biztripconfirmlist" style="height:32px"
	                        		onchange="javascript:confirmline(this.value)">
	                            <option value="choice">-- 결재선 선택 --</option>
	                            <%
	                            	for(Confirmlist_infoDto confirmlist_infoDto : list) {
                           		%>
                           			<option value="<%= confirmlist_infoDto.getConfirm_code()%>">
                           				<%=confirmlist_infoDto.getConfirm_name() %>
                           			</option>
                           		<%
	                            	}	
	                            %>
	                        </select>
	                        <button type="button" id="registorok" class="btn btn-primary" style="margin-bottom:7px">상신하기</button>
	                        <!-- <button type="button" id="registrotemp" class="btn btn-primary" style="margin-bottom:7px">임시저장</button> -->
                        </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <!-- <form name ="biztripform" method="get" action="">
            <input type="hidden" name="act" value="biztripregister">
            <input type="hidden" name="dockind" value="기안서"> -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
					              <tr>
					                <th>문서번호</th>
					                <td><%=biztrip_reportDto.getDoc_seq() %></td>
					                <th rowspan="5" style="text-align:center; vertical-align:middle">결<br><br><br><br>재</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">기안자</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					              </tr>
					              <tr>
					                <th>문서종류</th>
					                <td>
					                  <label><%=biztrip_reportDto.getDoc_name() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>문서상태</th>
					                <td>
					                  <label><%=biztrip_reportDto.getDoc_state() %></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                  <label><%=employeesDto.getGarde_name()%><br><%=employeesDto.getName()%></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="biztripconfirmname0" name="biztripconfirmname0" value="" text=""><%=biztrip_reportDto.getConfirmlistname1() %></div>
					                <input type="text" id="biztripconfirm0" name="biztripconfirm0" value="<%=biztrip_reportDto.getConfirmlist1() %>" style="display:none;">
					                <input type="text" id="biztripconfirms0" name="biztripconfirms0" value="<%=biztrip_reportDto.getConfirmlistname1() %>" style="display:none;">
					                  <span><button type="button" class="btn btn-primary btn-lg" id="biztripdoc_approval0" value="appoint" onclick="javascript:test(this.value, this.id);" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#confirmemployee">지정</button></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="biztripconfirmname1" name="biztripconfirmname1" value="" text=""><%=biztrip_reportDto.getConfirmlistname2() %></div>
					                <input type="text" id="biztripconfirm1" name="biztripconfirm1" value="<%=biztrip_reportDto.getConfirmlist2() %>" style="display:none;">
					                <input type="text" id="biztripconfirms1" name="biztripconfirms1" value="<%=biztrip_reportDto.getConfirmlist2() %>" style="display:none;">
					                  <span><button type="button" class="btn btn-primary btn-lg" id="biztripdoc_approval1" value="appoint" onclick="javascript:test(this.value, this.id);" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#confirmemployee">지정</button></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="biztripconfirmname2" name="biztripconfirmname2" value="" text=""><%=biztrip_reportDto.getConfirmlistname3() %></div>
					                <input type="text" id="biztripconfirm2" name="biztripconfirm2" value="<%=biztrip_reportDto.getConfirmlist3() %>" style="display:none;">
					                <input type="text" id="biztripconfirms2" name="biztripconfirms2" value="<%=biztrip_reportDto.getConfirmlistname3() %>" style="display:none;">
					                  <span><button type="button" class="btn btn-primary btn-lg" id="biztripdoc_approval2" value="appoint" onclick="javascript:test(this.value, this.id);" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#confirmemployee">지정</button></span>
					                </td>
					                <!-- Modal -->
				                            <div class="modal fade" id="confirmemployee" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				                                <div class="modal-dialog">
				                                    <div class="modal-content">
				                                        <div class="modal-header" style="padding-right:30px">
				                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				                                            <h4 class="modal-title" id="myModalLabel">결재자 지정하기</h4>
				                                            <p></p>
				                                                <button type="button" class="btn btn-primary" id="btnExpandAll"">전체부서 열기</button>&nbsp;&nbsp;&nbsp;
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
				                                    </div>
				                                    <!-- /.modal-content -->
				                                </div>
				                                <!-- /.modal-dialog -->
				                            </div>
				                            <!-- /.modal -->
					              </tr>
					              <tr>
					                <th>부서</th>
					                <td><label><%=employeesDto.getDepartment_name() %></label></td>
					              </tr>
					              <tr>
					                <th>기안자</th>
					                <td><label><%=biztrip_reportDto.getDoc_writer() %><label></td>
					              </tr>
					              <tr>
					                <th>기안일</th>
					                <td colspan="6">
										      <form class="demo-3">
										        <input type='text' id="nodayinputtext" name="nodayinputtext" value="" class="form-control" style="width:50%; display:none">
										      </form>
										<span class="col-lg-4" style="margin-left:-16px">
										      <form class="demo-3">
										        <input type='text' id="dayinputtext" name="dayinputtext" value="<%=biztrip_reportDto.getDoc_date() %>" class="form-control" style="width:50%; text-align:center">
										      </form>
										</span>
										<input type='text' id="daytext" name="daytext" value="<%=biztrip_reportDto.getDoc_date() %>" class="form-control" style="width:50%; display:none">
					                </td>
					              </tr>
					              <tr>
					                <th>수신부서</th>
					                <td colspan="6">
					                  <input id="receiveinputbox" name="receiveinputbox" value="<%=biztrip_reportDto.getDoc_receiver() %>" class="form-controltext" readonly="readonly">&nbsp;&nbsp;&nbsp;&nbsp;
				                            <!-- Button trigger modal -->
				                            <button type="button" class="btn btn-primary btn-lg" id="receivebtn" onclick="javascript:test(this.value, this.id);" style="width:115px; height:35px; padding-top: 8px;" data-toggle="modal" data-target="#receivedep">
				                                	수신부서지정
				                            </button>
				                            <!-- Modal -->
				                            <div class="modal fade" id="receivedep" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				                                <div class="modal-dialog">
				                                    <div class="modal-content">
				                                        <div class="modal-header">
				                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				                                            <h4 class="modal-title" id="myModalLabel">수신부서 지정하기</h4>
				                                            <p></p>
				                                            	<button type="button" class="btn btn-primary" id="btnExpandAll"">전체부서 열기</button>&nbsp;&nbsp;&nbsp;
    															<button type="button" class="btn btn-primary" id="btnCollapseAll">전체부서 닫기</button>
				                                        </div>
				                                        <div class="modal-body">
				                                         <div id="tree2">
				                                           <ul>
				                                           	<%
				                                           	size=confirmlistview.size();
				                                           	tmp="";
				                                           	for(EmployeesDto employeesDto2 : confirmlistview) {
				                                           		if(!employeesDto2.getDepartment_name().equals(tmp)){
				                                           	%>	
				                                           		<li class="folder"><%=employeesDto2.getDepartment_name() %>
				                                           	<%			tmp = employeesDto2.getDepartment_name();
				                                           		} 
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
					                </td>
					              </tr>
					              <tr>
					                <th>참조부서</th>
					                <td colspan="6">
					                  <input id="referenceinputbox" name="referenceinputbox" class="form-controltext" value="<%=biztrip_reportDto.getDoc_reference() %>" readonly="readonly">&nbsp;&nbsp;&nbsp;&nbsp;
					                  <!-- Button trigger modal -->
				                            <button type="button" class="btn btn-primary btn-lg" id="biztripreferencebtn" onclick="javascript:test(this.value, this.id);" style="width:115px; height:35px; padding-top: 8px;" data-toggle="modal" data-target="#referencedep">
				                                	참조부서지정
				                            </button>
				                            <!-- Modal -->
				                            <div class="modal fade" id="referencedep" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				                                <div class="modal-dialog">
				                                    <div class="modal-content">
				                                        <div class="modal-header">
				                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				                                            <h4 class="modal-title" id="myModalLabel">참조부서 지정하기</h4>
				                                            <p></p>
				                                            	<button type="button" class="btn btn-primary" id="btnExpandAll">전체부서 열기</button>&nbsp;&nbsp;&nbsp;
    															<button type="button" class="btn btn-primary" id="btnCollapseAll">전체부서 닫기</button>
				                                        </div>
				                                        <div class="modal-body">
				                                            	<div id="tree2">
				                                           <ul>
				                                           	<%
				                                           	size=confirmlistview.size();
				                                           	tmp="";
				                                           	for(EmployeesDto employeesDto2 : confirmlistview) {
				                                           		if(!employeesDto2.getDepartment_name().equals(tmp)){
				                                           	%>	
				                                           		<li class="folder"><%=employeesDto2.getDepartment_name() %>
				                                           	<%			tmp = employeesDto2.getDepartment_name();
				                                           		} 
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
					                </td>
					              </tr>
					            <!--  <tr>
					                <th>파일첨부</th>
					                <td colspan="6" >
					                  <div class="form-group" style="margin:auto">
                                            <input type="file" id="biztripfilename" name="biztripfilename" value="">
                                        </div>
                                        
					                </td>
					              </tr> --> 
					              <tr>
					                <th>제목</th>
					                <td colspan="6">
					                  <input class="form-controltext" id="biztripsubject" name="biztripsubject" value="<%=biztrip_reportDto.getDoc_subject()%>">
					                </td>
					              </tr>
					              <tr>
					              	<tbody>
					              		<tr>
					              			<th>출장기간</th>
					              			<td colspan="6">
						              			<span class="col-lg-4" style="margin-left:-16px">
											      <form class="demo-3">
											        <input type='text' id="biztripinputtext1" name="biztripinputtext1" value="<%=biztrip_reportDto.getBiztrip_report_start() %>" class="form-control" style="width:80%; text-align:center">
											      </form>  
											    </span>
											    <span class="col-lg-4" style="margin-left:-16px">  
											      <form class="demo-3">
											        <input type='text' id="biztripinputtext2" name="biztripinputtext2" value="<%=biztrip_reportDto.getBiztrip_report_end() %>" class="form-control" style="width:80%; text-align:center">
											      </form>
												</span>
												<input type='text' id="biztripstart" name="biztripstart" value="<%=biztrip_reportDto.getBiztrip_report_start() %>" class="form-control" style="width:50%; display:none">
												<input type='text' id="biztripend" name="biztripend" value="<%=biztrip_reportDto.getBiztrip_report_end() %>" class="form-control" style="width:50%; display:none">
												<!-- (현재 사용한 연차는 '0일',잔여 연차는 '10일'입니다.) -->
					              			</td>
					              		</tr>
					              		<tr>
					              			<th>출장지</th>
					              			<td colspan="6">
					              			<!-- <input type="text" class="form-controltext" id="content" name="content" value=""> -->
					              			<input class="form-controltext" id="route" name="route" value="<%=biztrip_reportDto.getBiztrip_report_route()%>">
					              			</td>
					              		</tr>
					              		<tr>
					              			<th>출장 업무 내용</th>
					              			<td colspan="6">
					              			<!-- <input type="text" class="form-controltext" id="content" name="content" value=""> -->
					              				<textarea class="form-control" rows="3" id="content" name="content" value=""><%=biztrip_reportDto.getBiztrip_report_content() %></textarea>
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
    <!-- /#wrapper -->


       <!-- jQuery -->
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>

	<!-- Calendar -->
	<script src="<%=root %>/calendar/jquery.minical.js"></script>
	<script>
	$("form.demo-1 :text").minical();
	$("form.demo-2 :text").minical({inline: true});
	$("form.demo-3 :text").minical({trigger: "i.trigger-icon"});
	
	</script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=root %>/css/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=root %>/css/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Flot Charts JavaScript -->
    <script src="<%=root %>/css/vendor/flot/excanvas.min.js"></script>
    <script src="<%=root %>/css/vendor/flot/jquery.flot.js"></script>
    <script src="<%=root %>/css/vendor/flot/jquery.flot.pie.js"></script>
    <script src="<%=root %>/css/vendor/flot/jquery.flot.resize.js"></script>
    <script src="<%=root %>/css/vendor/flot/jquery.flot.time.js"></script>
    <script src="<%=root %>/css/vendor/flot-tooltip/jquery.flot.tooltip.min.js"></script>
    <script src="<%=root %>/css/data/flot-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=root %>/css/dist/js/sb-admin-2.js"></script>

	
	
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
    	for(var i=0; i<3; i++){
			var str = "#biztripconfirmname"+i;
			var str1 = "#biztripdoc_approval"+i;
			var str2 = "#biztripconfirm"+i;
			var str3 = "#biztripconfirms"+i;
	    	if($(str3).val()){
				$(str1).val("cancel");
				$(str1).html("취소");
    		}
    	}
        $('#dataTables-example').DataTable({
            responsive: true
        });
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
	  					if(btnids=="biztripdoc_approval0"){
	   					document.getElementById("biztripconfirmname0").innerHTML = node.data.title;
	   					document.getElementById("biztripconfirm0").value = node.data.key;
	   					document.getElementById("biztripconfirms0").value = node.data.title;
						document.getElementById("biztripdoc_approval0").value="cancel";
						document.getElementById("biztripdoc_approval0").innerHTML="취소";
	  					} else if(btnids=="biztripdoc_approval1"){
	 					document.getElementById("biztripconfirmname1").innerHTML = node.data.title;
	 					document.getElementById("biztripconfirm1").value = node.data.key;
	 					document.getElementById("biztripconfirms1").value = node.data.title;
						document.getElementById("biztripdoc_approval1").value="cancel";
						document.getElementById("biztripdoc_approval1").innerHTML="취소";
	  					} else if(btnids=="biztripdoc_approval2"){
	 					document.getElementById("biztripconfirmname2").innerHTML = node.data.title;
	 					document.getElementById("biztripconfirm2").value = node.data.key;
	 					document.getElementById("biztripconfirms2").value = node.data.title;
						document.getElementById("biztripdoc_approval2").value="cancel";
						document.getElementById("biztripdoc_approval2").innerHTML="취소";
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
	    					} else if(btnids=="biztripreferencebtn"){
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
	 function confirmline(optionval) {
		var parameter="act=docconfirmnum&confirmname="+encodeURI(optionval);
		sendRequest("<%=root%>/userdocwrite",parameter,receiveParam, "GET");
	}
	
	function test(btval, btid){
		btnids=btid;
		if(btval=="appoint"){
			return;
		} else {
			var btstr = btid.substr(btid.length-1);
			var str = "biztripconfirmname"+btstr;
			var str1 = "biztripdoc_approval"+btstr;
			var str2 = "biztripconfirm"+btstr;
			var str3 = "biztripconfirms"+btstr;
			document.getElementById(str).innerHTML = "";
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
				for(var i=0; i<result1.length; i++){
					var str = "biztripconfirmname"+i;
					var str1 = "biztripdoc_approval"+i;
					var str2 = "biztripconfirm"+i;
					var str3 = "biztripconfirms"+i;
					if(result1[i]!="null" && result1[i].length!=6){
						document.getElementById(str).innerHTML = result1[i];
						document.getElementById(str2).value = result2[i];
						document.getElementById(str3).value = result1[i];
						document.getElementById(str1).value="cancel";
						document.getElementById(str1).innerHTML="취소";
					} else{
						document.getElementById(str).innerHTML = "";
						document.getElementById(str2).value = "";
						document.getElementById(str3).value = "";
						document.getElementById(str1).value="appoint";
						document.getElementById(str1).innerHTML="지정";
					}
				}
			} 
		}	
	}
	
	$("#registorok").click(function () {
		 if(!$("#biztripconfirmname0").text()){
				alert("결재선을 지정해주시기바랍니다.");
				return;
			} else if(!document.getElementById("dayinputtext").value){
				alert("기안일을 선택해주시기바랍니다.");
				return;
			} else if(!document.getElementById("receiveinputbox").value){
				alert("수신부서를 지정해주시기바랍니다.");
				return;
			} else if(!document.getElementById("biztripsubject").value){
				alert("제목을 작성해주시기바랍니다.");
				return;
			} else if(!$("#biztripinputtext1").val()){
				alert("시작일을 작성해주시기바랍니다.");
				return;
			} else if(!$("#biztripinputtext2").val()){
				alert("종료일을 작성해주시기바랍니다.");
				return;
			} else if(!$("#route").val()){
				alert("출장지를 작성해주시기바랍니다.");
				return;
			} else if(!$("#content").val()){
				alert("내용을 작성해주시기바랍니다.");
				return;
			} else if(confirm("상신하시겠습니까?")== true){
				$("#daytext").val(document.getElementById("dayinputtext").value);
				$("#biztripstart").val(document.getElementById("biztripinputtext1").value);
				$("#biztripend").val(document.getElementById("biztripinputtext2").value);
				document.biztripForm.action="<%=root%>/userdocupdate";				
				$("#biztripForm").submit();
			} else {
				return;
			}
	});	
	</script>



</body>

</html>
