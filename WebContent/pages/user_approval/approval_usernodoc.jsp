<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.Doc_info_detailDto"%>
<%@ include file="/common/user_public.jsp" %>
<% 
List<Doc_info_detailDto> nolistapprovallist = (List<Doc_info_detailDto>) request.getAttribute("nolistapprovallist");
%>
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">���� ���� ������ > �̰��� ����</h1>
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
                                		<th>��������</th>
                                		<td colspan="2">
                                		    <label></label>
                                            <select class="form-control" id="dockind" name="dockind" onchage="javascript:dockind(this.value)">
                                            	<option>-- ���� ���� --</option>
                                                <option>��ȼ�</option>
                                                <option>ǰ�Ǽ�</option>
                                                <option>�ް���</option>
                                                <option>����Ű�</option>
                                                <option>����������</option>
                                                <option>������</option>
                                            </select>
                                		</td>
                                		<th>�����</th>
                                		<td colspan="4" style="vertical-align:middle">
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
                                	</tr>-->
                                    <tr>
                                        <th>������ȣ</th>
                                        <th>��������</th>
                                        <th>��Ⱥμ�</th>
                                        <th>�����</th>
                                        <th>�����</th>
                                        <th>����Ϸ��</th>
                                        <th>����</th>
                                    </tr>
                                </thead> 
                                <tbody>
                                    
                                    <%
                                    System.out.println(nolistapprovallist.size());
                                    	for(Doc_info_detailDto doc_info_detailDto : nolistapprovallist){
                                    %><tr class="odd gradeX">
                                    	<td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_seq() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_name() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_dep() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_date() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_writer() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getConfirmlist_ok() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_subject() %></td>
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
    	document.location.href="<%=root%>/userreportdoc?act=approvalviewarticle&seq="+seq+"&dockind="+encodeURI(dockind)+"&docview=usernodoc";
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
