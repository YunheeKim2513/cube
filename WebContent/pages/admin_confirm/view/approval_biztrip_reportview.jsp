<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.cube.model.dto.*"%>
<%@ include file="/common/admin_public.jsp" %>
<% Biztrip_reportDto biztrip_reportDto = (Biztrip_reportDto) request.getAttribute("biztrip_report"); %>
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header"><%=biztrip_reportDto.getDoc_name() %></h1>
                    	<div style="text-align:right; vertical-align:middle">
                    		<button type="button" id="listbtn" name="listbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:previouspage('<%=request.getParameter("docview")%>');">���</button>
	                        <!-- <button type="button" id="updatebtn" name="updatebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalupdates('<%--=biztrip_reportDto.getDoc_seq()--%>','<%--=biztrip_reportDto.getDoc_name()--%>');">����</button>
	                        <button type="button" id="deletebtn" name="deletebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvaldelete('<%--=biztrip_reportDto.getDoc_seq()--%>','biztrip_report');">����</button> -->
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
                            <table width="100%" class="table table-striped table-bbiztriped table-hover">
                                <thead>
					              <tr>
					                <th>������ȣ</th>
					                <td><%=biztrip_reportDto.getDoc_seq() %></td>
					                <th rowspan="5" style="text-align:center; vertical-align:middle">��<br><br><br><br>��</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">�����</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">���缱</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">���缱</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">���缱</th>
					              </tr>
					              <tr>
					                <th>��������</th>
					                <td>
					                  <label><%=biztrip_reportDto.getDoc_name() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>��������</th>
					                <td>
					                  <label><span id="docstate" name="docstate" ><%=biztrip_reportDto.getDoc_state() %></span></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                  <label><%=biztrip_reportDto.getDoc_writer() %></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok1" name="approvalok1" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=biztrip_reportDto.getConfirmlistname1() %></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok2" name="approvalok2" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=biztrip_reportDto.getConfirmlistname2() %></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok3" name="approvalok3" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=biztrip_reportDto.getConfirmlistname3() %></span>
					                </td>
					              </tr>
					              <tr>
					                <th>�μ�</th>
					                <td><label><%=employeesDto.getDepartment_name() %></label></td>
					              </tr>
					              <tr>
					                <th>�����</th>
					                <td><label><%=biztrip_reportDto.getDoc_writer() %><label></td>
					              </tr>
					              <tr>
					                <th>�����</th>
					                <td colspan="6">
                           		 	   <label><%=biztrip_reportDto.getDoc_date() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>���źμ�</th>
					                <td colspan="6">
					                  <label><%=biztrip_reportDto.getDoc_receiver() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>�����μ�</th>
					                <td colspan="6">
					                  <label><%=biztrip_reportDto.getDoc_reference() %></label>
					                </td>
					              </tr>
					              <!-- <tr>
					                <th>����÷��</th>
					                <td colspan="6">
					                  <input class="form-controltext" readonly="">&nbsp;&nbsp;&nbsp;&nbsp;
					                  <button type="button" class="btn btn-primary">÷���ϱ�</button>
					                </td>
					              </tr> -->
					              <tr>
					                <th>����</th>
					                <td colspan="6">
					                  <label><%=biztrip_reportDto.getDoc_subject() %></label>
					                </td>
					              </tr>
					              <tr>
					              	<tbody>
					              		<tr>
					              			<th>����Ⱓ</th>
					              			<td colspan="6">
						              			<label><%=biztrip_reportDto.getBiztrip_report_start() %></label> ~ <label><%=biztrip_reportDto.getBiztrip_report_end() %></label>
					              			</td>
					              		</tr>
					              		<tr>
					              			<th>������</th>
					              			<td colspan="6"><label><%=biztrip_reportDto.getBiztrip_report_route() %></label></td>
					              		</tr>
					              		<tr>
					              			<th>���� ���� ����</th>
					              			<td colspan="6"><p><label><%=biztrip_reportDto.getBiztrip_report_content() %></label></p></td>
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
    
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
       <script type="text/javascript">
		$(document).ready(function () {
			if(<%=biztrip_reportDto.getConfirmlist_ok()%>==1){
				if('�ݷ�'=='<%=biztrip_reportDto.getDoc_state()%>'){
					$("#approvalok1").append('�ݷ�');
					$("#approvalok1").show();						
				} else{
				var data = "<%=biztrip_reportDto.getConfirmlistname1()%>";
				var output =data.split(')');
				console.log(output[1]);
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				}
			} else if(<%=biztrip_reportDto.getConfirmlist_ok()%>==2){
				var data = "<%=biztrip_reportDto.getConfirmlistname1()%>";
				var output =data.split(')');
				console.log(output[1]);
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				if('�ݷ�'=='<%=biztrip_reportDto.getDoc_state()%>'){
					$("#approvalok2").append('�ݷ�');
					$("#approvalok2").show();						
				} else{
				data = "<%=biztrip_reportDto.getConfirmlistname2()%>";
				output =data.split(')');
				console.log(output[1]);
				$("#approvalok2").append(output[1]);
				$("#approvalok2").show();
				}
			} else if(<%=biztrip_reportDto.getConfirmlist_ok()%>==3){
				var data = "<%=biztrip_reportDto.getConfirmlistname1()%>";
				var output =data.split(')');
				console.log(output[1]);
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				data = "<%=biztrip_reportDto.getConfirmlistname2()%>";
				output =data.split(')');
				console.log(output[1]);
				$("#approvalok2").append(output[1]);
				$("#approvalok2").show();
				if('�ݷ�'=='<%=biztrip_reportDto.getDoc_state()%>'){
					$("#approvalok3").append('�ݷ�');
					$("#approvalok3").show();						
				} else{
				data = "<%=biztrip_reportDto.getConfirmlistname3()%>";
				output =data.split(')');
				console.log(output[1]);
				$("#approvalok3").append(output[1]);
				$("#approvalok3").show();
				}
			}
		});
		
	</script>
       <!-- jQuery -->
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>
    
    <script type="text/javascript" src="<%=root%>/js/approval/approval.js"></script>
    
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


</body>

</html>
