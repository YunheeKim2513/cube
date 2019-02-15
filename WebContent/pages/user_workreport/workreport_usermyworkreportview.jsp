<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.cube.model.dto.Work_reportDto"%>
<%@ include file="/common/user_public.jsp" %>
<%	
	Work_reportDto work_reportDto = (Work_reportDto) request.getAttribute("work_reportDto");
%>
        <!-- /#page-wrapper -->
        <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header"><div id="workdockind"></div></h1>
                    	<div style="text-align:right; vertical-align:middle">
                    	<button type="button" id="listbtn" name="listbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:previouspage('<%=request.getParameter("docview")%>');">���</button>
                    	<%
                    	if("temp".equals(request.getParameter("menu"))){
						%>
	                        <button type="button" id="updatebtn" name="updatebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalupdate('<%=work_reportDto.getDoc_seq()%>','<%=work_reportDto.getDoc_name()%>');">����</button>
	                        <button type="button" id="deletebtn" name="deletebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvaldelete('<%=work_reportDto.getDoc_seq()%>','workdoc');">����</button>
	                    <%
                        } else {
	                   	%>		
	                   		<button type="button" id="pdfbtn" name="pdfbtn" class="btn btn-primary" style="margin-bottom:7px">pdf �ٿ�ε�</button>
                    	<%		
                    	}
	                    %>
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
			              			<td><div id="dockind" style="font-weight: bold;"></div></td>
				              	  </tr>
				              	  <tr>
				              	    <th>���� ������</th>
				              	  	 <td><label><%=work_reportDto.getDoc_date() %></label></td>
				              	  </tr>
				              	  <tr>
				              	    <th>���� ���� �Ͻ�</th>
				              	  	 <td><label><%=work_reportDto.getDoc_writetime() %></label></td>
				              	  </tr>
				              	  <tr>
				              	    <th>������ ���� �Ͻ�</th>
				              	  	 <td><label><%=work_reportDto.getWorkdoc_finaltime() %></label></td>
				              	  </tr>
				              	  <tr>
			              			<th>������</th>
			              			<td><label><%=work_reportDto.getDoc_writer() %></label></td>
				              	  </tr>
				              	  <tr>
				              	    <th>����޴� ��</th>
				              	  	<td><label><%=work_reportDto.getConfirmlist() %></label></td>
				              	  </tr>
				              	  <tr>
			              			<th>��������</th>
			              			<td><div id="viewkind" style="font-weight: bold;"></div></td>
			              		  </tr>
				              		<tr>
				              			<th>����</th>
				              			<td><label><%=work_reportDto.getDoc_subject() %></label></td>
				              		</tr>
				              		<tr>
				              			<th><div id="daywork"></div></th>
				              			<td><p><%=work_reportDto.getWorkdoc_daycontent() %></p></td>
				              		</tr>
				              		<tr>
				              			<th><div id="nextwork"></div></th>
				              			<td><p><%=work_reportDto.getWorkdoc_nextcontent() %></p></td>
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
                            <table style="width:100%">
                            <thead>
                             <tr>
								<td style="width:10%; text-align: center; font-weight: bold;">[<%=employeesDto.getDepartment_name() %>]<br><%=employeesDto.getGarde_name() %> <br> <%=employeesDto.getName() %></td>
								<td width="80%" height="80" >
								<textarea class="form-control" rows="3" id="workmemocontent" name="workmemocontent"></textarea>
								</td>
								<td align="center" colspan="2">
								<span><button type="button" class="btn btn-primary btn-lg" id="mwrite" style="width:100px; height:45px; padding-top: 7px;">���</button></span>
								</td>
							  </tr>
							  </thead>
							</table>
							<table>
								<tbody id="memolist"></tbody>
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
    
    <script type="text/javascript" src="<%=root%>/js/approval/approval.js"></script>

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
    	if("���� ���� ����"=="<%=work_reportDto.getWorkdoc_kind()%>"){
    		$("#workdockind").html("���� ���� ���� ���� ��ȸ");
    		$("#dockind").html("���� ���� ����");
			$("#daywork").html("���� ����");
			$("#nextwork").html("���� ��ȹ");
    	} else if("�ְ� ���� ����"=="<%=work_reportDto.getWorkdoc_kind()%>"){
    		$("#workdockind").html("�ְ� ���� ���� ���� ��ȸ");
    		$("#dockind").html("�ְ� ���� ����");
			$("#daywork").html("�̹��� ����");
			$("#nextwork").html("������ ��ȹ");
    	} else if("���� ���� ����"=="<%=work_reportDto.getWorkdoc_kind()%>"){
    		$("#workdockind").html("���� ���� ���� ���� ��ȸ");
    		$("#dockind").html("���� ���� ����");
			$("#daywork").html("�̹��� ����");
			$("#nextwork").html("������ ��ȹ");
    	} 
    	
    	if("��ü����"=="<%=work_reportDto.getWorkdoc_open()%>"){
    		$("#viewkind").html("ȸ�� ��ü ����");
    	} else if("�����"=="<%=work_reportDto.getWorkdoc_open()%>"){
    		$("#viewkind").html("�����");
    	} else {
    		$("#viewkind").html("�μ� ����");
    	}
    	
    	getMemoList();
    	$("#mwrite").click(function(){
    		console.log("��Ϲ�ư");
    		writeMemo();
    	});
    	
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    
    function writeMemo(){
    	$.ajax({
    		type: "POST",
    		dataType: 'json',
    		url : "<%=root%>/usermyworkreportreply",
    		data: {act:"write", seq: "<%=work_reportDto.getDoc_seq()%>", mcontent: $("#workmemocontent").val()},
    		success:function(data){
    			$("#workmemocontent").text("");
    			memoList(data);
    		},
    		error: function(e){
    			alert("����");
    		}
    	});
    }
    
    function getMemoList(){
    	$.ajax({
    		type: "POST",
    		dataType: 'json',
    		url: "<%=root%>/usermyworkreportreply",
    		data: {act: "list", seq: "<%=work_reportDto.getDoc_seq()%>" },
    		success:function(data) {
    			memoList(data);
    		},
    		error:function(e){
    			alert("����");
    		}
    	});
    }
    
    function memoList(data){
    	var len = data.memolist.length;
    	
    	var output="";
    	for(var i=0; i<len; i++ ){
    		var mseq = data.memolist[i].mseq;
    		var seq = data.memolist[i].seq;
    		var mname = data.memolist[i].mname;
    		var mcontent = data.memolist[i].mcontent;
    		var mlogtime = data.memolist[i].mlogtime;
    		var mid = data.memolist[i].mid;
    		output += "<tr>";
    		output += "	<td width=\"10%\" height=\"50px\"><b>" + mname + "</b></td>";
    		output += "	<td width=\"2%\">";
    		output += "	<td width=\"60%\"><div>" + mcontent + "</div></td>";
    		output += "	<td width=\"13%\">" + mlogtime + "</td>";
    		output += "	<td width=\"5%\">";
    		if(mid == "<%=employeesDto.getEmployee_id()%>") {
    			output += "<a href=\"javascript:mvModifyMemo('" + mseq + "');\">����</a>";
    			output += "|";
    			output += "<a href=\"javascript:deleteMemo('" + mseq + "');\">����</a>";
    		}
    		output += "</td>";
    		output += "</tr>";
    		
    		output += "<tr>";
    		output += "	<td colspan=\"5\">";
    		output += "	<div id=\"modiform" + mseq + "\" style=\"display: none;\">";
    		output += "	<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
    		output += "	<tr>";
    		output += "		<td width=\"5%\"></td>";
    		output += "		<td width=\"75%\" height=\"80\">";
    		output += "		<input name=\"mcontent\" id=\"mcontent" + mseq + "\" type=\"text\" height=\"60\" size=\"150\" maxlength=\"200\" ";
    		output += "		 style=\"height: 80px; spacing: 10px;\" value=\"" + mcontent + "\">";
    		output += "		</td>";
    		output += "		<td align=\"center\">";
    		output += "<button type=\"button\" id=\"mmodify\" name=\"mmodify\" class=\"btn btn-primary\" style=\"margin-bottom:7px\" onclick=\"javascript:modifyMemo('"+mseq+"');\">���</button>";
    		output += "<button type=\"button\" id=\"mcancel\" name=\"mcancel\" class=\"btn btn-primary\" style=\"margin-bottom:7px\" onclick=\"javascript:cancelMemo('"+mseq+"');\">���</button>";
    		output += "		</td>";
    		output += "	</tr>";
    		output += "	</table>";
    		output += "	</div>";
    		output += "	</td>";
    		output += "</tr>";
    		
    		output += "<tr>";
    		output += "	<td class=\"bg_board_title_02\" height=\"1\" colspan=\"5\"";
    		output += "		style=\"overflow: hidden; padding: 0px\"></td>";
    		output += "</tr>";
    		
    		$("#memolist").empty();
    		$("#memolist").append(output);
    	}
    }
    
    function mvModifyMemo(mseq){
    	$("#modiform"+mseq).css("display","");
    }
    
    function deleteMemo(mseq){
    	if(confirm("�ۼ��� ����� ����ðڽ��ϱ�?")){
    		$.ajax({
    			type: "GET",
    			dataType: 'json',
    			url: "<%=root%>/usermyworkreportreply",
    			data: {act: "delete", seq: "<%=work_reportDto.getDoc_seq()%>", mseq: mseq},
    			success:function(data){
    				memoList(data);
    			},
    			error: function(e){
    				alert("����");
    			}
    		});
    	}
    }
    
    function cancelMemo(mseq){
    	$("#modiform"+mseq).css("display","none");
    }
    
    function modifyMemo(mseq){
    	if($("#mcontent"+mseq).val()){
    	$.ajax({
    		type: "POST",
    		dataType: 'json',
    		url: "<%=root%>/usermyworkreportreply",
    		data: {act: "modify", seq: "<%=work_reportDto.getDoc_seq()%>", mseq:mseq, mcontent: $("#mcontent"+mseq).val()},
    		success:function(data){
    			memoList(data);
    		},
    		error:function(e){
    			alert("����");
    		}
    	});
    	} else {
    		alert("��� ������ �Է����ּ���");
    		return;
    	}
    }
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