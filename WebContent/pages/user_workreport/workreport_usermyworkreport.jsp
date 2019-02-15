<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/common/user_public.jsp" %>
<%	
	List<EmployeesDto> confirmemployeelist = (List<EmployeesDto>) request.getAttribute("confirmemployeelist");
%>
        <!-- /#page-wrapper -->
        <form name ="userworkForm" id="userworkForm" method="post" action="">
        <input type="hidden" id="act" name="act" value="userworkwirte">
        <input type="hidden" id="dockind" name="dockind" value="��������">
        <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header">�� �������� �ۼ�</h1>
                    	<div style="text-align:right">
                    		<span><button type="button" class="btn btn-primary" id="worksubmit">�����ϱ�</button></span>
                    		<span><button type="button" class="btn btn-primary" id="worklist">���</button></span>
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
			              			<th>��������</th>
			              			<td>
			              			<label class="radio-inline">
                                        <input type="radio" name="workreportkind" id="dayreport" value="���� ���� ����" checked>���� ���� ����
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="workreportkind" id="weekreport" value="�ְ� ���� ����">�ְ� ���� ����
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="workreportkind" id="monthreport" value="���� ���� ����">���� ���� ����
                                    </label>
			              			</td>
				              	  </tr>
				              	  <tr>
				              	    <th>���� ������</th>
				              	  	 <td>
										<form class="demo-3">
								        	<input type='text' id="nodayinputtext" name="nodayinputtext" value="" class="form-control" style="width:50%; display:none">
								        </form>
										<span class="col-lg-4" style="margin-left:-16px">
										      <form class="demo-3">
										        <input type='text' id="dayinputtext" name="dayinputtext" value="" class="form-control" style="width:50%; text-align:center">
										      </form>
										</span>
										<input type='text' id="daytext" name="daytext" value="" class="form-control" style="width:50%; display:none">
					                </td>
				              	  </tr>
				              	  <tr>
			              			<th>������</th>
			              			<td><label><%=employeesDto.getGarde_name()%> <%=employeesDto.getName() %></label></td>
				              	  </tr>
				              	  <tr>
				              	    <th>����޴� ��</th>
				              	  	<td><input class="form-controltext" id="employees" name="employees" value="" readonly="readonly">&nbsp&nbsp&nbsp&nbsp
				              	  	<input class="form-controltext" id="eids" name="eids" value="" style="display: none">
				              	  	<span><button type="button" class="btn btn-primary btn-lg" id="confirmemployees" style="width:120px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#workconfirmemployee">���� �޴� ��</button></span>
					                </td>
					                <!-- Modal -->
			                            <div class="modal fade" id="workconfirmemployee" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			                                <div class="modal-dialog">
			                                    <div class="modal-content">
			                                        <div class="modal-header" style="padding-right:30px">
			                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                                            <h4 class="modal-title" id="myModalLabel">������ �����ϱ�</h4>
			                                            <p></p>
			                                                <button type="button" class="btn btn-primary" id="btnExpandAll"">��ü�μ� ����</button>&nbsp;&nbsp;&nbsp;
   															<button type="button" class="btn btn-primary" id="btnCollapseAll">��ü�μ� �ݱ�</button>
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
			              			<th>��������</th>
			              			<td>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="workviewkind" id="allview" value="��ü����" checked>��ü����
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="workviewkind" id="departmentview" value="�μ�����">�μ�����
	                                    </label>
	                                    <label class="radio-inline">
	                                        <input type="radio" name="workviewkind" id="seceretview" value="�����">�����
	                                    </label>
			              			 </td>
			              			</tr>
				              		<tr>
				              			<th>����</th>
				              			<td><input class="form-controltext" id="worksubject" name="worksubject" value=""></td>
				              		</tr>
				              		<tr>
				              			<th><div id="daywork">���� ����</div></th>
				              			<td><textarea class="form-control" rows="10" id="daycontent" name="daycontent"></textarea></td>
				              		</tr>
				              		<tr>
				              			<th><div id="nextwork">���� ��ȹ</div></th>
				              			<td><textarea class="form-control" rows="10" id="nextcontent" name="nextcontent"></textarea></td>
				              		</tr>
				              		<tr>
					                <th>����÷��</th>
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

	<!-- Calendar -->
	<script src="<%=root %>/calendar/jquery.minical.js"></script>
	<script>
	$("form.demo-1 :text").minical();
	$("form.demo-2 :text").minical({inline: true});
	$("form.demo-3 :text").minical({trigger: "i.trigger-icon"});
	</script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
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
			$("#daywork").html("���� ����");
			$("#nextwork").html("���� ��ȹ");
		} else if($("#weekreport").val()==workreportkind){
			var weekstartsubject=$.datepicker.formatDate('yy-mm-dd', new Date());
			var date = new Date(); 
			date.setDate(date.getDate() + 6);
			var weekendsubject=$.datepicker.formatDate('yy-mm-dd', date);
			$("#worksubject").val("["+weekstartsubject+"]"+"~"+"["+weekendsubject+"] �ְ� ���� ����");
			$("#daywork").html("�̹��� ����");
			$("#nextwork").html("������ ��ȹ");
		} else if($("#monthreport").val()==workreportkind){
			var monthsubject=$.datepicker.formatDate('yy-mm', new Date());
			$("#worksubject").val("["+monthsubject+"] ���� ���� ����");
			$("#daywork").html("�̹��� ����");
			$("#nextwork").html("������ ��ȹ");
		}	 
	 });
	 
	 $("#worksubmit").click(function(){
		if(!$("#eids").val()){
			alert("���� �޴� �ڸ� ������ �ֽñ���ϴ�.");
		} else if(!$("#worksubject").val()){
			alert("������ �ۼ����ֽñ�ٶ��ϴ�.");
		} else if(!$("#daycontent").val()){
			alert("���� �� ���� �ۼ����ֽñ�ٶ��ϴ�.");
		} else if(!$("#nextcontent").val()){
			alert("���� �� ���� �ۼ����ֽñ�ٶ��ϴ�.");
		} else {
			if(confirm("�������� �ø��ðڽ��ϱ�?")==true){
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
