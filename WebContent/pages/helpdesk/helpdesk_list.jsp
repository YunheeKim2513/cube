<%@page import="com.cube.model.dto.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.Doc_info_detailDto"%>
<%@ include file="/common/admin_public.jsp" %>
<% 
	List<NoticeDto> noticelist = (List<NoticeDto>) request.getAttribute("noticelist");
%>
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">HELP DESK</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading" style="text-align: right; vertical-align: middle;">
                        <button type="button" id="mvreportbtn" name="mvreportbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:mvreport();">작성하기</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover"  id="dataTables-example">
                               <thead>
                                    <tr>
                                        <th>글번호</th>
                                        <th>부서</th>
                                        <th>작성자</th>
                                        <th>글상태</th>
                                        <th>작성일</th>
                                        <th>제목</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for(NoticeDto noticeDto : noticelist){
                                    	%>
                                    	<tr>
	                                    	<td onclick="javascript:viewarticle('<%=noticeDto.getNotice_seq()%>')"><%=noticeDto.getNotice_seq() %></td>
	                                    	<td onclick="javascript:viewarticle('<%=noticeDto.getNotice_seq()%>')"><%=noticeDto.getEmployee_dep() %></td>
	                                    	<td onclick="javascript:viewarticle('<%=noticeDto.getNotice_seq()%>')"><%=noticeDto.getNotic_writer() %></td>
	                                    	<td onclick="javascript:viewarticle('<%=noticeDto.getNotice_seq()%>')"><%=noticeDto.getNotice_state() %></td>
	                                    	<td onclick="javascript:viewarticle('<%=noticeDto.getNotice_seq()%>')"><%=noticeDto.getNotice_date() %></td>
	                                    	<td onclick="javascript:viewarticle('<%=noticeDto.getNotice_seq()%>')"><%=noticeDto.getNotice_subject() %></td>
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
    function viewarticle(seq){
    	document.location.href="<%=root%>/adminhome?act=noticeview&seq="+seq;
    }
    
    function mvreport(){
    	document.location.href="<%=root%>/adminhome?act=mvhlepwrite";
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
