<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.Work_reportDto"%>
<%@ include file="/common/user_public.jsp" %>
<% 
List<Work_reportDto> work_reportlist = (List<Work_reportDto>) request.getAttribute("work_reportlist");
%>
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">받은 업무보고 > 받은 업무보고 확인</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover"  id="dataTables-example">
                                <thead>
                                	<!-- <tr>
                                		<th>문서종류</th>
                                		<td colspan="1">
                                		    <label></label>
                                            <select class="form-control" id="workdockind" name="workdockind" onchage="javascript:dockind(this.value)">
                                            	<option>-- 문서 종류 --</option>
                                                <option>일일 업무 보고</option>
                                                <option>주간 업무 보고</option>
                                                <option>월간 업무 보고</option>
                                            </select>
                                		</td>
                                		<th>기안일</th>
                                		<td colspan="3" style="vertical-align:middle">
                               		 	    <span class="col-lg-4" style="margin-right:50px">
											      <form class="demo-3">
											        <input type='text' class="form-control">
											      </form>
											</span>
											<span class="col-lg-4">
											      <form class="demo-3">
											        <input type='text' class="form-control">
											      </form>
										    </span>
                                		</td>
                                	</tr> -->
                                    <tr>
                                        <th>종류</th>
                                        <th>보고일</th>
                                        <th>부서</th>
                                        <th>보고자</th>
                                        <th>공개</th>
                                        <th>제목</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                    <%
                                    	for(Work_reportDto work_reportDto : work_reportlist){
                                    %><tr class="odd gradeX">
                                        <td onclick="javascript:viewarticle('<%=work_reportDto.getDoc_seq() %>','<%=work_reportDto.getDoc_name() %>');"><%=work_reportDto.getWorkdoc_kind() %></td>
                                        <td onclick="javascript:viewarticle('<%=work_reportDto.getDoc_seq() %>','<%=work_reportDto.getDoc_name() %>');"><%=work_reportDto.getDoc_date() %></td>
                                        <td onclick="javascript:viewarticle('<%=work_reportDto.getDoc_seq() %>','<%=work_reportDto.getDoc_name() %>');"><%=work_reportDto.getDoc_dep() %></td>
                                        <td onclick="javascript:viewarticle('<%=work_reportDto.getDoc_seq() %>','<%=work_reportDto.getDoc_name() %>');"><%=work_reportDto.getDoc_writer() %></td>
                                        <td onclick="javascript:viewarticle('<%=work_reportDto.getDoc_seq() %>','<%=work_reportDto.getDoc_name() %>');"><%=work_reportDto.getWorkdoc_open() %></td>
                                        <td onclick="javascript:viewarticle('<%=work_reportDto.getDoc_seq() %>','<%=work_reportDto.getDoc_name() %>');"><%=work_reportDto.getDoc_subject() %></td>
                                      </tr>
                                    <%		
                                    	}
                                    %>
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
            
            <!-- /.row -->
            
            <!-- /.row -->
            
        </div>
    <!-- /#wrapper -->
<!-- jQuery -->
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript">
    function viewarticle(seq,dockind){
    	document.location.href="<%=root%>/userreportdoc?act=allviewarticle&seq="+seq+"&dockind="+encodeURI(dockind)+"&docview=receiveworkreport";
    }
    </script>
 <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
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
	
</body>

</html>
