<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.cube.model.dto.*"%>
<%@ include file="/common/user_public.jsp" %>
<%
	List<Confirmlist_infoDto> list = (List<Confirmlist_infoDto>) request.getAttribute("confirmlist");
	List<EmployeesDto> confirmlistview = (List<EmployeesDto>) request.getAttribute("confirmlistview");
	VacdocDto vacdocDto = (VacdocDto) request.getAttribute("vacdocwrite");
%>
		<form name ="vacForm" id="vacForm" method="post" action="">
        <input type="hidden" id="act" name="act" value="vacupdate">
        <input type="hidden" id="dockind" name="dockind" value="휴가계">
        <input type="hidden" id="docseq" name="docseq" value="<%=vacdocDto.getDoc_seq() %>">
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header"><%=vacdocDto.getDoc_name() %></h1>
                    	<div style="text-align:right; vertical-align:middle">
	                        <select class="form-control22" id="vacconfirmlist" name="vacconfirmlist" style="height:32px"
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
            <!-- <form name ="vacform" method="get" action="">
            <input type="hidden" name="act" value="vacregister">
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
					                <td><%=vacdocDto.getDoc_seq() %></td>
					                <th rowspan="5" style="text-align:center; vertical-align:middle">결<br><br><br><br>재</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">기안자</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					              </tr>
					              <tr>
					                <th>문서종류</th>
					                <td>
					                  <label><%=vacdocDto.getDoc_name() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>문서상태</th>
					                <td>
					                  <label><%=vacdocDto.getDoc_state() %></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                  <label><%=employeesDto.getGarde_name()%><br><%=employeesDto.getName()%></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="vacconfirmname0" name="vacconfirmname0" value="" text=""><%=vacdocDto.getConfirmlistname1() %></div>
					                <input type="text" id="vacconfirm0" name="vacconfirm0" value="<%=vacdocDto.getConfirmlist1() %>" style="display:none;">
					                <input type="text" id="vacconfirms0" name="vacconfirms0" value="<%=vacdocDto.getConfirmlistname1() %>" style="display:none;">
					                  <span><button type="button" class="btn btn-primary btn-lg" id="vacdoc_approval0" value="cancel" onclick="javascript:test(this.value, this.id);" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#confirmemployee">취소</button></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="vacconfirmname1" name="vacconfirmname1" value="" text=""><%=vacdocDto.getConfirmlistname2() %></div>
					                <input type="text" id="vacconfirm1" name="vacconfirm1" value="<%=vacdocDto.getConfirmlist2() %>" style="display:none;">
					                <input type="text" id="vacconfirms1" name="vacconfirms1" value="<%=vacdocDto.getConfirmlistname2() %>" style="display:none;">
					                  <span><button type="button" class="btn btn-primary btn-lg" id="vacdoc_approval1" value="cancel" onclick="javascript:test(this.value, this.id);" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#confirmemployee">취소</button></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="vacconfirmname2" name="vacconfirmname2" value="" text=""><%=vacdocDto.getConfirmlistname3() %></div>
					                <input type="text" id="vacconfirm2" name="vacconfirm2" value="<%=vacdocDto.getConfirmlist3() %>" style="display:none;">
					                <input type="text" id="vacconfirms2" name="vacconfirms2" value="<%=vacdocDto.getConfirmlistname3() %>" style="display:none;">
					                  <span><button type="button" class="btn btn-primary btn-lg" id="vacdoc_approval2" value="cancel" onclick="javascript:test(this.value, this.id);" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#confirmemployee">취소</button></span>
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
					                <td><label><%=vacdocDto.getDoc_writer() %><label></td>
					              </tr>
					              <tr>
					                <th>기안일</th>
					                <td colspan="6">
										      <form class="demo-3">
										        <input type='text' id="nodayinputtext" name="nodayinputtext" value="" class="form-control" style="width:50%; display:none">
										      </form>
										<span class="col-lg-4" style="margin-left:-16px">
										      <form class="demo-3">
										        <input type='text' id="dayinputtext" name="dayinputtext" value="<%=vacdocDto.getDoc_date() %>" class="form-control" style="width:50%; text-align:center">
										      </form>
										</span>
										<input type='text' id="daytext" name="daytext" value="<%=vacdocDto.getDoc_date() %>" class="form-control" style="width:50%; display:none">
					                </td>
					              </tr>
					              <tr>
					                <th>수신부서</th>
					                <td colspan="6">
					                  <input id="receiveinputbox" name="receiveinputbox" value="<%=vacdocDto.getDoc_receiver() %>" class="form-controltext" readonly="readonly">&nbsp;&nbsp;&nbsp;&nbsp;
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
					                  <input id="referenceinputbox" name="referenceinputbox" class="form-controltext" value="<%=vacdocDto.getDoc_reference() %>" readonly="readonly">&nbsp;&nbsp;&nbsp;&nbsp;
					                  <!-- Button trigger modal -->
				                            <button type="button" class="btn btn-primary btn-lg" id="vacreferencebtn" onclick="javascript:test(this.value, this.id);" style="width:115px; height:35px; padding-top: 8px;" data-toggle="modal" data-target="#referencedep">
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
					           <!--   <tr>
					                <th>파일첨부</th>
					                <td colspan="6" >
					                  <div class="form-group" style="margin:auto">
                                            <input type="file" id="vacfilename" name="vacfilename" value="">
                                        </div>
                                        
					                </td>
					              </tr> --> 
					              <tr>
					                <th>제목</th>
					                <td colspan="6">
					                  <input class="form-controltext" id="vacsubject" name="vacsubject" value="<%=vacdocDto.getDoc_subject() %>">
					                </td>
					              </tr>
					              <tr>
					              	<tbody>
					              		<tr>
					              			<th>휴가기간</th>
					              			<td colspan="6">
						              			<span class="col-lg-4" style="margin-left:-16px">
											      <form class="demo-3">
											        <input type='text' id="vacinputtext1" name="vacinputtext1" value="<%=vacdocDto.getVacdoc_start() %>" class="form-control" style="width:80%; text-align:center">
											      </form>  
											    </span>
											    <span class="col-lg-4" style="margin-left:-16px">  
											      <form class="demo-3">
											        <input type='text' id="vacinputtext2" name="vacinputtext2" value="<%=vacdocDto.getVac_end() %>" class="form-control" style="width:80%; text-align:center">
											      </form>
												</span>
												<input type='text' id="vacstart" name="vacstart" value="<%=vacdocDto.getVacdoc_start() %>" class="form-control" style="width:50%; display:none">
												<input type='text' id="vacend" name="vacend" value="<%=vacdocDto.getVac_end() %>" class="form-control" style="width:50%; display:none">
												<!-- (현재 사용한 연차는 '0일',잔여 연차는 '10일'입니다.) -->
					              			</td>
					              		</tr>
					              		<tr>
					              			<th>종류</th>
					              			<td colspan="6">
					              				<div class="form-group">
		                                            <label class="radio-inline">
		                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="연차" checked>연차
		                                            </label>
		                                            <label class="radio-inline">
		                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="공가">공가
		                                            </label>
		                                            <label class="radio-inline">
		                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline3" value="병가">병가
		                                            </label>
		                                            <label class="radio-inline">
		                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline4" value="반차">반차
		                                            </label>
		                                            <label class="radio-inline">
		                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline5" value="조퇴">조퇴
		                                            </label>
		                                            <label class="radio-inline">
		                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline6" value="기타">기타
		                                            </label>
		                                            <input type='text' id="vackind" name="vackind" value="" class="form-control" style="width:50%; display:none">
		                                        </div>
					              			</td>
					              		</tr>
					              		<tr>
					              			<th>행선지</th>
					              			<td colspan="6"><input type="text" class="form-controltext" id="route" name="route" value="<%=vacdocDto.getVacdoc_route() %>"></td>
					              		</tr>
					              		<tr>
					              			<th>사유</th>
					              			<td colspan="6">
					              			<!-- <input type="text" class="form-controltext" id="content" name="content" value=""> -->
					              				<textarea class="form-control" rows="3" id="content" name="content" value=""><%=vacdocDto.getVacdoc_content() %></textarea>
					              			</td>
					              		</tr>
				              		</tbody>
					              </tr>
					            </thead>

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
			var str = "#vacconfirmname"+i;
			var str1 = "#vacdoc_approval"+i;
			var str2 = "#vacconfirm"+i;
			var str3 = "#vacconfirms"+i;
	    	if($(str3).val()){
				$(str1).val("cancel");
				$(str1).html("취소");
    		}
    	}
    	var vackind = '<%=vacdocDto.getVacdoc_kind() %>';
    	if($("#optionsRadiosInline1").val()==vackind){
    		 $('input:radio[name="optionsRadiosInline"]:input[value=' + vackind + ']').attr("checked", true);
    	} else if($("#optionsRadiosInline2").val()==vackind){
    		 $('input:radio[name="optionsRadiosInline"]:input[value=' + vackind + ']').attr("checked", true);
    	} else if($("#optionsRadiosInline3").val()==vackind){
    		 $('input:radio[name="optionsRadiosInline"]:input[value=' + vackind + ']').attr("checked", true);
    	} else if($("#optionsRadiosInline4").val()==vackind){
    		 $('input:radio[name="optionsRadiosInline"]:input[value=' + vackind + ']').attr("checked", true);
    	} else if($("#optionsRadiosInline5").val()==vackind){
    		 $('input:radio[name="optionsRadiosInline"]:input[value=' + vackind + ']').attr("checked", true);
    	} else if($("#optionsRadiosInline6").val()==vackind){
    		 $('input:radio[name="optionsRadiosInline"]:input[value=' + vackind + ']').attr("checked", true);
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
	  					if(btnids=="vacdoc_approval0"){
	   					document.getElementById("vacconfirmname0").innerHTML = node.data.title;
	   					document.getElementById("vacconfirm0").value = node.data.key;
	   					document.getElementById("vacconfirms0").value = node.data.title;
						document.getElementById("vacdoc_approval0").value="cancel";
						document.getElementById("vacdoc_approval0").innerHTML="취소";
	  					} else if(btnids=="vacdoc_approval1"){
	 					document.getElementById("vacconfirmname1").innerHTML = node.data.title;
	 					document.getElementById("vacconfirm1").value = node.data.key;
	 					document.getElementById("vacconfirms1").value = node.data.title;
						document.getElementById("vacdoc_approval1").value="cancel";
						document.getElementById("vacdoc_approval1").innerHTML="취소";
	  					} else if(btnids=="vacdoc_approval2"){
	 					document.getElementById("vacconfirmname2").innerHTML = node.data.title;
	 					document.getElementById("vacconfirm2").value = node.data.key;
	 					document.getElementById("vacconfirms2").value = node.data.title;
						document.getElementById("vacdoc_approval2").value="cancel";
						document.getElementById("vacdoc_approval2").innerHTML="취소";
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
	    					} else if(btnids=="vacreferencebtn"){
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
			var str = "vacconfirmname"+btstr;
			var str1 = "vacdoc_approval"+btstr;
			var str2 = "vacconfirm"+btstr;
			var str3 = "vacconfirms"+btstr;
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
					var str = "vacconfirmname"+i;
					var str1 = "vacdoc_approval"+i;
					var str2 = "vacconfirm"+i;
					var str3 = "vacconfirms"+i;
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
		 if(!$("#vacconfirmname0").text()){
				alert("결재선을 지정해주시기바랍니다.");
				return;
			} else if(!document.getElementById("dayinputtext").value){
				alert("기안일을 선택해주시기바랍니다.");
				return;
			} else if(!document.getElementById("receiveinputbox").value){
				alert("수신부서를 지정해주시기바랍니다.");
				return;
			} else if(!document.getElementById("vacsubject").value){
				alert("제목을 작성해주시기바랍니다.");
				return;
			} else if(!$("#vacinputtext1").val()){
				alert("시작일을 작성해주시기바랍니다.");
				return;
			} else if(!$("#vacinputtext2").val()){
				alert("종료일을 작성해주시기바랍니다.");
				return;
			} else if(!$("#route").val()){
				alert("행선지를 작성해주시기바랍니다.");
				return;
			} else if(!$("#content").val()){
				alert("내용을 작성해주시기바랍니다.");
				return;
			} else if(confirm("상신하시겠습니까?")== true){
				$("#daytext").val(document.getElementById("dayinputtext").value);
				$("#vacstart").val(document.getElementById("vacinputtext1").value);
				$("#vacend").val(document.getElementById("vacinputtext2").value);
				$("#vackind").val($(':radio[name="optionsRadiosInline"]:checked').val());
				document.vacForm.action="<%=root%>/userdocupdate";				
				$("#vacForm").submit();
			} else {
				return;
			}
	});	
	</script>


</form>
</body>

</html>
