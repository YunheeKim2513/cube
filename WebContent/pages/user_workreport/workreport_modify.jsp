<%@page import="com.cube.model.dto.Work_reportDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/common/user_public.jsp" %>
<%	
	List<EmployeesDto> confirmemployeelist = (List<EmployeesDto>) request.getAttribute("confirmemployeelist");
	Work_reportDto work_report_view = (Work_reportDto) request.getAttribute("work_report_view");
%>
        <!-- /#page-wrapper -->
        <form name ="userworkForm" id="userworkForm" method="post" action="">
        <input type="hidden" id="act" name="act" value="userworkupdate">
        <input type="hidden" id="dockind" name="dockind" value="업무보고">
        <input type="hidden" id="docseq" name="docseq" value="<%=work_report_view.getDoc_seq()%>">
        <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header">내 업무보고 작성</h1>
                    	<div style="text-align:right">
                    		<span><button type="button" class="btn btn-primary" id="worksubmit">수정하기</button></span>
                    		<span><button type="button" class="btn btn-primary" id="worklist">목록</button></span>
                    	</div>
                    	<br>
                </div>
            </div>
                <!-- /.col-lg-12 -->
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                 <tr>
			              			<th>문서종류</th>
			              			<td>
			              			<label class="radio-inline">
                                        <input type="radio" name="workreportkind" id="dayreport" value="일일 업무 보고">일일 업무 보고
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="workreportkind" id="weekreport" value="주간 업무 보고">주간 업무 보고
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="workreportkind" id="monthreport" value="월간 업무 보고">월간 업무 보고
                                    </label>
			              			</td>
				              	  </tr>
				              	  <tr>
				              	    <th>업무 보고일</th>
				              	  	 <td>
										<span class="col-lg-4" style="margin-left:-16px">
										        <input type='text' id="dayinputtext" name="dayinputtext" value="<%=work_report_view.getDoc_date() %>" class="form-control" style="width:50%; text-align:center" readonly="readonly">
										</span>
										<input type='text' id="daytext" name="daytext" value="<%=work_report_view.getDoc_date() %>" class="form-control" style="width:50%; display:none">
					                </td>
				              	  </tr>
				              	  <tr>
			              			<th>보고자</th>
			              			<td><label><%=work_report_view.getDoc_writer() %></label></td>
				              	  </tr>
				              	  <tr>
				              	    <th>보고받는 자</th>
				              	  	<td><input class="form-controltext" id="employees" name="employees" value="<%=work_report_view.getConfirmlist() %>" readonly="readonly">&nbsp&nbsp&nbsp&nbsp
				              	  	<input class="form-controltext" id="eids" name="eids" value="<%=work_report_view.getConfirmlist() %>" style="display: none">
				              	  	<span><button type="button" class="btn btn-primary btn-lg" id="confirmemployees" style="width:120px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#workconfirmemployee">보고 받는 자</button></span>
					                </td>
					                <!-- Modal -->
			                            <div class="modal fade" id="workconfirmemployee" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
			                                           <div id="tree">
			                                           <ul>
			                                           	<%
			                                           	int size=confirmemployeelist.size();
			                                           	String tmp="";
			                                           	for(int i=0; i<size; i++) {
			                                           		EmployeesDto employeesDto2 = confirmemployeelist.get(i);
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
			                                           		if(!confirmemployeelist.get(i+1).getDepartment_name().equals(employeesDto2.getDepartment_name())){%></ul><%}}
			                                           	}%>
		                                           </ul>
		                                           </div>
												  </div>
		                                        </div>
		                                    </div>
		                                    <!-- /.modal-content -->
		                                </div>
		                                <!-- /.modal-dialog -->
				              	  </tr>
				              	  <tr>
			              			<th>공개여부</th>
			              			<td>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="workviewkind" id="allview" value="전체공개">전체공개
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="workviewkind" id="departmentview" value="부서공개">부서공개
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="workviewkind" id="seceretview" value="비공개">비공개
	                                    </label>
			              			 </td>
			              			</tr>
				              		<tr>
				              			<th>제목</th>
				              			<td><input class="form-controltext" id="worksubject" name="worksubject" value="<%=work_report_view.getDoc_subject()%>"></td>
				              		</tr>
				              		<tr>
				              			<th><div id="daywork">오늘 한일</div></th>
				              			<td><textarea class="form-control" rows="10" id="daycontent" name="daycontent"><%=work_report_view.getWorkdoc_open() %></textarea></td>
				              		</tr>
				              		<tr>
				              			<th><div id="nextwork">내일 계획</div></th>
				              			<td><textarea class="form-control" rows="10" id="nextcontent" name="nextcontent"><%=work_report_view.getWorkdoc_nextcontent() %></textarea></td>
				              		</tr>
				              		<tr>
					                <th>파일첨부</th>
					                <td colspan="6" >
					                  <div class="form-group" style="margin:auto">
                                            <input type="file" id="workfilename" name="workfilename" value="">
                                      </div>
					                </td>
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
	</form>
    <!-- jQuery -->
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
    	if("일일 업무 보고"=="<%=work_report_view.getWorkdoc_kind()%>"){
    		$("input:radio[name=workreportkind]:radio[value='일일 업무 보고']").attr("checked", true);
    	} else if("주간 업무 보고"=="<%=work_report_view.getWorkdoc_kind()%>"){
    		$("input:radio[name=workreportkind]:radio[value='주간 업무 보고']").attr("checked", true);
    	} else if("월간 업무 보고"=="<%=work_report_view.getWorkdoc_kind()%>"){
    		$("input:radio[name=workreportkind]:radio[value='월간 업무 보고']").attr("checked", true);
    	} 
    	if("전체공개"=="<%=work_report_view.getWorkdoc_open()%>"){
    		$("input:radio[name=workviewkind]:radio[value='전체공개']").attr("checked", true);
    	} else if("부서공개"=="<%=work_report_view.getWorkdoc_open()%>"){
    		$("input:radio[name=workviewkind]:radio[value='부서공개']").attr("checked", true);
    	} else if("비공개"=="<%=work_report_view.getWorkdoc_open()%>"){
    		$("input:radio[name=workviewkind]:radio[value='비공개']").attr("checked", true);
    	} 
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>


    <!-- Bootstrap Core JavaScript -->
    <script src="<%=root %>/css/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=root %>/css/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="<%=root %>/css/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%=root %>/css/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<%=root %>/css/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=root %>/css/dist/js/sb-admin-2.js"></script>

	<script src="<%=root %>/modal/jquery/jquery-ui.custom.js" type="text/javascript"></script>
	<script src="<%=root %>/modal/jquery/jquery.cookie.js" type="text/javascript"></script>
	<link href="<%=root %>/modal/src/skin-vista/ui.dynatree.css" rel="stylesheet" type="text/css">
	<script src="<%=root %>/modal/src/jquery.dynatree.js" type="text/javascript"></script>
	<script type="text/javascript">
	 $(function(){
	   // Initialize the tree inside the <div>element.
	   // The tree structure is read from the contained <ul> tag.
	   $("#tree").dynatree({
	     onActivate: function(node) {
	  		var parameter="act=confirmbtn&confirmname="+encodeURI(node.data.title);
	  		sendRequest("<%=root%>/userdocwrite",parameter,receiveParams, "GET");
	  		function receiveParams() {
	  			if(httpRequest.readyState==4){
	  				if(httpRequest.status==200){
	   					document.getElementById("eids").value = node.data.key;
	   					document.getElementById("employees").value = node.data.title;
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
	       $("#tree").dynatree("getRoot").visit(function(node){
	         node.expand(true);
	       });
	       return false;
	     });
	     $("#btnCollapseAll").click(function(){
	       $("#tree").dynatree("getRoot").visit(function(node){
	         node.expand(false);
	       });
	       return false;
	     });
	 });  
	 
	 $("input:radio[name=workreportkind]").click(function(){
		var workreportkind=$("input:radio[name=workreportkind]:checked").val();
		if($("#dayreport").val()==workreportkind){
			$("#worksubject").val("");
			$("#daywork").html("오늘 한일");
			$("#nextwork").html("내일 계획");
		} else if($("#weekreport").val()==workreportkind){
			var weekstartsubject=$.datepicker.formatDate('yy-mm-dd', new Date());
			var date = new Date(); 
			date.setDate(date.getDate() + 6);
			var weekendsubject=$.datepicker.formatDate('yy-mm-dd', date);
			$("#worksubject").val("["+weekstartsubject+"]"+"~"+"["+weekendsubject+"] 주간 업무 보고");
			$("#daywork").html("이번주 한일");
			$("#nextwork").html("다음주 계획");
		} else if($("#monthreport").val()==workreportkind){
			var monthsubject=$.datepicker.formatDate('yy-mm', new Date());
			$("#worksubject").val("["+monthsubject+"] 월간 업무 보고");
			$("#daywork").html("이번달 한일");
			$("#nextwork").html("다음달 계획");
		}	 
	 });
	 
	 $("#worksubmit").click(function(){
		if(!$("#eids").val()){
			alert("보고 받는 자를 선택해 주시기랍니다.");
		} else if(!$("#worksubject").val()){
			alert("제목을 작성해주시기바랍니다.");
		} else if(!$("#daycontent").val()){
			alert("오늘 한 일을 작성해주시기바랍니다.");
		} else if(!$("#nextcontent").val()){
			alert("내일 한 일을 작성해주시기바랍니다.");
		} else {
			if(confirm("업뭅보고를 수정하시겠습니까?")==true){
				$("#daytext").val(document.getElementById("dayinputtext").value);
				document.userworkForm.action="<%=root%>/usermyworkreport";
				$("#userworkForm").submit();
			} else
				return;
		}
	 });
	 </script>
	   

</body>

</html>
