<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.cube.model.dto.*"%>
<%@ include file="/common/user_public.jsp" %>
<% BiztripdocDto biztripdocDto = (BiztripdocDto) request.getAttribute("biztripdocwrite"); %>
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header"><%=biztripdocDto.getDoc_name() %></h1>
                    	<div style="text-align:right; vertical-align:middle">
                    	<button type="button" id="listbtn" name="listbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascirpt:previouspage('<%=request.getParameter("docview")%>')">목록</button>
                    	<%
                    	if("approval".equals(request.getParameter("menu"))){
                    	%>
							<button type="button" id="confbtn" name="confbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalok(<%=biztripdocDto.getConfirmlist_ok()%>,'<%=biztripdocDto.getDoc_seq()%>', '<%=employeesDto.getEmployee_id()%>', '<%=biztripdocDto.getDoc_name() %>')">결재</button>
							<!-- <button type="button" id="deferbtn" name="deferbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalok(<%--=biztripdocDto.getConfirmlist_ok()%>,'<%=biztripdocDto.getDoc_seq()%>', '<%=employeesDto.getEmployee_id()%>', '<%=biztripdocDto.getDoc_name() --%>')">보류</button> -->
							<button type="button" id="returnbtn" name="returnbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalcancel(<%=biztripdocDto.getConfirmlist_ok()%>,'<%=biztripdocDto.getDoc_seq()%>', '<%=employeesDto.getEmployee_id()%>')">반려</button>
						<% 
                    	} else if("temp".equals(request.getParameter("menu"))){
						%>
							<button type="button" id="reportbtn" name="reportbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalreport('<%=biztripdocDto.getDoc_seq()%>');">상신하기</button>
	                        <button type="button" id="updatebtn" name="updatebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalupdate('<%=biztripdocDto.getDoc_seq()%>','<%=biztripdocDto.getDoc_name()%>');">수정</button>
	                        <button type="button" id="deletebtn" name="deletebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvaldelete('<%=biztripdocDto.getDoc_seq()%>','biztripdoc');">삭제</button>
	                    <%
                    	} else if("report".equals(request.getParameter("menu"))){
        				%>
    	                    <button type="button" id="returnbtn" name="deletebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalsave('<%=biztripdocDto.getDoc_seq()%>');">회수</button>
    	                <%
                        } else if("return".equals(request.getParameter("menu"))){
        				%>
    	                	<button type="button" id="newdocbtn" name="newdocbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:newpage('<%=biztripdocDto.getDoc_name()%>');">새로작성</button>
    	                <%
                        }  else {
                    	%>		
                    		<!-- <button type="button" id="pdfbtn" name="pdfbtn" class="btn btn-primary" style="margin-bottom:7px">pdf 다운로드</button> -->
                    	<%		
                    	}
	                    %>
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
					                <th>문서번호</th>
					                <td><%=biztripdocDto.getDoc_seq() %></td>
					                <th rowspan="5" style="text-align:center; vertical-align:middle">결<br><br><br><br>재</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">기안자</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					              </tr>
					              <tr>
					                <th>문서종류</th>
					                <td>
					                  <label><%=biztripdocDto.getDoc_name() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>문서상태</th>
					                <td>
					                  <label><span id="docstate" name="docstate" ><%=biztripdocDto.getDoc_state() %></span></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                  <label>><%=biztripdocDto.getDoc_writer() %></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok1" name="approvalok1" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=biztripdocDto.getConfirmlistname1() %></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok2" name="approvalok2" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=biztripdocDto.getConfirmlistname2() %></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok3" name="approvalok3" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=biztripdocDto.getConfirmlistname3() %></span>
					                </td>
					              </tr>
					              <tr>
					                <th>부서</th>
					                <td><label><%=employeesDto.getDepartment_name() %></label></td>
					              </tr>
					              <tr>
					                <th>기안자</th>
					                <td><label><%=biztripdocDto.getDoc_writer() %><label></td>
					              </tr>
					              <tr>
					                <th>기안일</th>
					                <td colspan="6">
                           		 	   <label><%=biztripdocDto.getDoc_date() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>수신부서</th>
					                <td colspan="6">
					                  <label><%=biztripdocDto.getDoc_receiver() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>참조부서</th>
					                <td colspan="6">
					                  <label><%=biztripdocDto.getDoc_reference() %></label>
					                </td>
					              </tr>
					              <tr>
					               <!--  <th>파일첨부</th>
					                <td colspan="6">
					                  <input class="form-controltext" readonly="">&nbsp;&nbsp;&nbsp;&nbsp;
					                  <button type="button" class="btn btn-primary">첨부하기</button>
					                </td>
					              </tr> -->
					              <tr>
					                <th>제목</th>
					                <td colspan="6">
					                  <label><%=biztripdocDto.getDoc_subject() %></label>
					                </td>
					              </tr>
					              <tr>
					              	<tbody>
					              		<tr>
					              			<th>출장기간</th>
					              			<td colspan="6">
						              			<label><%=biztripdocDto.getBiztripdoc_start() %></label> ~ <label><%=biztripdocDto.getBiztripdoc_end() %></label>
					              			</td>
					              		</tr>
					              		<tr>
					              			<th>행선지</th>
					              			<td colspan="6"><label><%=biztripdocDto.getBiztripdoc_route() %></label></td>
					              		</tr>
					              		<tr>
					              			<th>사유</th>
					              			<td colspan="6"><p><label><%=biztripdocDto.getBiztripdoc_content() %></label></p></td>
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
			if(<%=biztripdocDto.getConfirmlist_ok()%>==1){
				if('반려'=='<%=biztripdocDto.getDoc_state()%>'){
					$("#approvalok1").append('반려');
					$("#approvalok1").show();						
				} else{
				var data = "<%=biztripdocDto.getConfirmlistname1()%>";
				var output =data.split(')');
				console.log(output[1]);
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				}
			} else if(<%=biztripdocDto.getConfirmlist_ok()%>==2){
				var data = "<%=biztripdocDto.getConfirmlistname1()%>";
				var output =data.split(')');
				console.log(output[1]);
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				if('반려'=='<%=biztripdocDto.getDoc_state()%>'){
					$("#approvalok2").append('반려');
					$("#approvalok2").show();						
				} else{
				data = "<%=biztripdocDto.getConfirmlistname2()%>";
				output =data.split(')');
				console.log(output[1]);
				$("#approvalok2").append(output[1]);
				$("#approvalok2").show();
				}
			} else if(<%=biztripdocDto.getConfirmlist_ok()%>==3){
				var data = "<%=biztripdocDto.getConfirmlistname1()%>";
				var output =data.split(')');
				console.log(output[1]);
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				data = "<%=biztripdocDto.getConfirmlistname2()%>";
				output =data.split(')');
				console.log(output[1]);
				$("#approvalok2").append(output[1]);
				$("#approvalok2").show();
				if('반려'=='<%=biztripdocDto.getDoc_state()%>'){
					$("#approvalok3").append('반려');
					$("#approvalok3").show();						
				} else{
				data = "<%=biztripdocDto.getConfirmlistname3()%>";
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
