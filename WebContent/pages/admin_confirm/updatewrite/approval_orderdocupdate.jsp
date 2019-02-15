<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"  import="java.util.List, com.cube.model.dto.*"%>
<%@ include file="/common/admin_public.jsp" %>
<%
	List<Confirmlist_infoDto> list = (List<Confirmlist_infoDto>) request.getAttribute("confirmlist");
	List<EmployeesDto> confirmlistview = (List<EmployeesDto>) request.getAttribute("confirmlistview");
	OrderdocDto orderdocDto = (OrderdocDto) request.getAttribute("orderdocwrite");
%>
        <!-- /#page-wrapper -->
        <form name ="orderForm" id="orderForm" method="post" action="">
        <input type="hidden" id="act" name="act" value="orderupdate">
        <input type="hidden" id="dockind" name="dockind" value="휴가계">
        <input type="hidden" id="docseq" name="docseq" value="<%=orderdocDto.getDoc_seq() %>">
               <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    	<h1 class="page-header"><%=orderdocDto.getDoc_name() %></h1>
                    	<div style="text-align:right; vertical-align:middle">
                        <select class="form-control22" id="orderconfirmlist" name="confirmlist" style="height:32px"
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
	                        <button type="button" id="registorok" class="btn btn-primary" style="margin-bottom:7px">수정하기</button>
	                       <!--  <button type="button" id="registrotemp" class="btn btn-primary" style="margin-bottom:7px">임시저장</button> -->
                        </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
					              <tr>
					                <th>문서번호</th>
					                <td><%=orderdocDto.getDoc_seq() %></td>
					                <th rowspan="5" style="text-align:center; vertical-align:middle">결<br><br><br><br>재</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">기안자</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					              </tr>
					              <tr>
					                <th>문서종류</th>
					                <td>
					                  <label><%=orderdocDto.getDoc_name() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>문서상태</th>
					                <td>
					                  <label><%=orderdocDto.getDoc_state() %></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                  <label><%=employeesDto.getGarde_name()%><br><%=employeesDto.getName()%></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="orderconfirmname0" name="orderconfirmname0" value="" text=""><%=orderdocDto.getConfirmlistname1() %></div>
					                <input type="text" id="orderconfirm0" name="orderconfirm0" value="<%=orderdocDto.getConfirmlist1() %>" style="display:none;">
					                <input type="text" id="orderconfirms0" name="orderconfirms0" value="<%=orderdocDto.getConfirmlistname1() %>" style="display:none;">
					                  <span><button type="button" class="btn btn-primary btn-lg" id="orderdoc_approval0" value="appoint" onclick="javascript:test(this.value, this.id);" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#confirmemployee">지정</button></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="orderconfirmname1" name="orderconfirmname1" value="" text=""><%=orderdocDto.getConfirmlistname2() %></div>
					                <input type="text" id="orderconfirm1" name="orderconfirm1" value="<%=orderdocDto.getConfirmlist2() %>" style="display:none;">
					                <input type="text" id="orderconfirms1" name="orderconfirms1" value="<%=orderdocDto.getConfirmlistname2() %>" style="display:none;">
					                  <span><button type="button" class="btn btn-primary btn-lg" id="orderdoc_approval1" value="appoint" onclick="javascript:test(this.value, this.id);" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#confirmemployee">지정</button></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="orderconfirmname2" name="orderconfirmname2" value="" text=""><%=orderdocDto.getConfirmlistname3() %></div>
					                <input type="text" id="orderconfirm2" name="orderconfirm2" value="<%=orderdocDto.getConfirmlist3() %>" style="display:none;">
					                <input type="text" id="orderconfirms2" name="orderconfirms2" value="<%=orderdocDto.getConfirmlistname3() %>" style="display:none;">
					                  <span><button type="button" class="btn btn-primary btn-lg" id="orderdoc_approval2" value="appoint" onclick="javascript:test(this.value, this.id);" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#confirmemployee">지정</button></span>
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
					                <td><label><%=orderdocDto.getDoc_writer() %><label></td>
					              </tr>
					              <tr>
					                <th>기안일</th>
					                <td colspan="6">
										      <form class="demo-3">
										        <input type='text' id="nodayinputtext" name="nodayinputtext" value="" class="form-control" style="width:50%; display:none">
										      </form>
										<span class="col-lg-4" style="margin-left:-16px">
										      <form class="demo-3">
										        <input type='text' id="dayinputtext" name="dayinputtext" value="<%=orderdocDto.getDoc_date() %>" class="form-control" style="width:50%; text-align:center">
										      </form>
										</span>
										<input type='text' id="daytext" name="daytext" value="" class="form-control" style="width:50%; display:none">
					                </td>
					              </tr>
					              <tr>
					                <th>수신부서</th>
					                <td colspan="6">
					                  <input id="receiveinputbox" name="receiveinputbox" value="<%=orderdocDto.getDoc_receiver() %>" class="form-controltext" readonly="readonly">&nbsp;&nbsp;&nbsp;&nbsp;
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
					                  <input id="referenceinputbox" name="referenceinputbox" class="form-controltext" value="<%=orderdocDto.getDoc_reference() %>" readonly="readonly">&nbsp;&nbsp;&nbsp;&nbsp;
					                  <!-- Button trigger modal -->
				                            <button type="button" class="btn btn-primary btn-lg" id="orderreferencebtn" onclick="javascript:test(this.value, this.id);" style="width:115px; height:35px; padding-top: 8px;" data-toggle="modal" data-target="#referencedep">
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
					          <!--    <tr>
					                <th>파일첨부</th>
					                <td colspan="6" >
					                  <div class="form-group" style="margin:auto">
                                            <input type="file" id="orderfilename" name="orderfilename" value="">
                                        </div>
                                        
					                </td>
					              </tr> --> 
					              <tr>
					                <th>제목</th>
					                <td colspan="6">
					                  <input class="form-controltext" id="ordersubject" name="ordersubject" value="<%=orderdocDto.getDoc_subject() %>">
					                </td>
					              </tr>
					              <tr>
					                <th colspan="7">
					                <!-- SE2 -->
										<textarea name="ir1" id="ir1" rows="10" cols="100" style="width:100%; height:412px; display:none;"><%=orderdocDto.getOrderdoc_content() %></textarea>
					                </th>
					              </tr>
					            </thead>

                            </table>
                            </from>
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
    <!-- /#wrapper -->

       <!-- jQuery -->
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
    	for(var i=0; i<3; i++){
			var str = "#orderconfirmname"+i;
			var str1 = "#orderdoc_approval"+i;
			var str2 = "#orderconfirm"+i;
			var str3 = "#orderconfirms"+i;
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
	<script src="<%=root %>/calendar/jquery.minical.js"></script>
	<script>
	$("form.demo-1 :text").minical();
	$("form.demo-2 :text").minical({
	        inline: true
	      });
		  $("form.demo-3 :text").minical({
	        trigger: "i.trigger-icon"
	      });
	</script>
	
	<!-- SE2 -->
	<script type="text/javascript" src="<%=root %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript">
	
	var oEditors = [];
	
	// 추가 글꼴 목록
	//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];
	$(function(){
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "ir1",
		sSkinURI: "<%=SE2%>/SmartEditor2Skin.jsp",	
		htParams : {
			bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
			fOnBeforeUnload : function(){
				//alert("완료!");
			}
		}, //boolean
		fOnAppLoad : function(){
			//예제 코드
			//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
		},
		fCreator: "createSEditor2"
		});
		
		function pasteHTML() {
			var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
			oEditors.getById["ir1"].exec("PASTE_HTML", [sHTML]);
		}
		
		function showHTML() {
			var sHTML = oEditors.getById["ir1"].getIR();
			alert(sHTML);
		}
			
		$("#registorok").click(function () {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
			 //에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
			 if(!$("#orderconfirmname0").text()){
					alert("결재선을 지정해주시기바랍니다.");
					return;
				} else if(!document.getElementById("dayinputtext").value){
					alert("기안일을 선택해주시기바랍니다.");
					return;
				} else if(!document.getElementById("receiveinputbox").value){
					alert("수신부서를 지정해주시기바랍니다.");
					return;
				} else if(!document.getElementById("ordersubject").value){
					alert("제목을 작성해주시기바랍니다.");
					return;
				} else if(!$("#ir1").val()){
					alert("내용을 작성해주시기바랍니다.");
					return;
				} else if(confirm("상신하시겠습니까?")== true){
					$("#daytext").val(document.getElementById("dayinputtext").value);
					document.orderForm.action="<%=root%>/userdocupdate";
					$("#orderForm").submit();
				} else {
					return;
				}
		});	
			
			
			//try {
				//elClickedObj.form.submit();
			//} catch(e) {}
		//}
		
		function setDefaultFont() {
			var sDefaultFont = '궁서';
			var nFontSize = 24;
			oEditors.getById["ir1"].setDefaultFont(sDefaultFont, nFontSize);
		}
	});
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

    <!-- DataTables JavaScript -->
    <script src="<%=root %>/css/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%=root %>/css/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<%=root %>/css/vendor/datatables-responsive/dataTables.responsive.js"></script>
	
	    
	
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
	  					if(btnids=="orderdoc_approval0"){
	   					document.getElementById("orderconfirmname0").innerHTML = node.data.title;
	   					document.getElementById("orderconfirm0").value = node.data.key;
	   					document.getElementById("orderconfirms0").value = node.data.title;
						document.getElementById("orderdoc_approval0").value="cancel";
						document.getElementById("orderdoc_approval0").innerHTML="취소";
	  					} else if(btnids=="orderdoc_approval1"){
	 					document.getElementById("orderconfirmname1").innerHTML = node.data.title;
	 					document.getElementById("orderconfirm1").value = node.data.key;
	 					document.getElementById("orderconfirms1").value = node.data.title;
						document.getElementById("orderdoc_approval1").value="cancel";
						document.getElementById("orderdoc_approval1").innerHTML="취소";
	  					} else if(btnids=="orderdoc_approval2"){
	 					document.getElementById("orderconfirmname2").innerHTML = node.data.title;
	 					document.getElementById("orderconfirm2").value = node.data.key;
	 					document.getElementById("orderconfirms2").value = node.data.title;
						document.getElementById("orderdoc_approval2").value="cancel";
						document.getElementById("orderdoc_approval2").innerHTML="취소";
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
	    					} else if(btnids=="orderreferencebtn"){
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
			var str = "orderconfirmname"+btstr;
			var str1 = "orderdoc_approval"+btstr;
			var str2 = "orderconfirm"+btstr;
			var str3 = "orderconfirms"+btstr;
			document.getElementById(str).innerHTML = "";
			document.getElementById(str2).value = "";
			document.getElementById(str3).value = "";
			document.getElementById(str2).value = "";
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
					var str = "orderconfirmname"+i;
					var str1 = "orderdoc_approval"+i;
					var str2 = "orderconfirm"+i;
					var str3 = "orderconfirms"+i;
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
	</script>
	

</body>

</html>

