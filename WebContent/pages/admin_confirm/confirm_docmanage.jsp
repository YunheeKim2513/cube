<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.Doc_info_detailDto"%>
<%@ include file="/common/admin_public.jsp" %>
<% 
List<Doc_info_detailDto> doclist = (List<Doc_info_detailDto>) request.getAttribute("doclist");
%>
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">문서별 결재 관리</h1>
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
                                		<td colspan="2">
                                		    <label></label>
                                            <select class="form-control" id="dockind" name="dockind" onchage="javascript:dockind(this.value)">
                                            	<option>-- 문서 종류 --</option>
                                                <option>기안서</option>
                                                <option>품의서</option>
                                                <option>휴가계</option>
                                                <option>출장신고서</option>
                                                <option>출장결과보고서</option>
                                                <option>사직서</option>
                                            </select>
                                		</td>
                                		<th>기안일</th>
                                		<td colspan="5" style="vertical-align:middle">
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
                                        <th>문서번호</th>
                                        <th>문서종류</th>
                                        <th>기안자</th>
                                        <th>기안일</th>
                                        <th>상태</th>
                                        <th>제목</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                    	for(Doc_info_detailDto doc_info_detailDto : doclist){
                                    %><tr class="odd gradeX">
                                    	<td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_seq() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_name() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_writer() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_date() %></td>
                                        <td onclick="javascript:viewarticle('<%=doc_info_detailDto.getDoc_seq() %>','<%=doc_info_detailDto.getDoc_name() %>');"><%=doc_info_detailDto.getDoc_state() %></td>
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
		<!-- dockind -->
    <script type="text/javascript">
    function viewarticle(seq,dockind){
    	document.location.href="<%=root%>/adminapproval?act=viewarticle&seq="+seq+"&dockind="+encodeURI(dockind)+"&docview=docmanage";
    }
    </script>
 <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
        
    });
    /*getBusinessList();
    function getBusinessList() {
    	$.ajax({
    		type: "POST",
    		dataType: 'json',
    		url: "<%= root %>/userapprovalmain",
    		data: { act: "businesslist"},
    		success:function(data) {
    		 businessList(data);
    		},
    		error:function(e){
    			alert("error");
    		}
    	});
    }
    function businessList(data) {
    	var len = data.bapprovallist.length;
    	var output="";  
    	for(var i=0;i<len;i++) {
    		var docseq = data.bapprovallist[i].doc_seq;
    		var docname = data.bapprovallist[i].doc_name;
    		var docdate = data.bapprovallist[i].doc_date;
    		var docwriter = data.bapprovallist[i].doc_writer;
    		var docdep = data.bapprovallist[i].doc_dep;
    		var confirmname = data.bapprovallist[i].confirmname;
    		var docstate = data.bapprovallist[i].doc_state;
    		var docsubject = data.bapprovallist[i].doc_subject;
    		var confirmstate = data.bapprovallist[i].confirm_state;
    		var confirmokdate = data.bapprovallist[i].confirm_complite_date;
    		output="<tr class=\"odd gradeX\">";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+docseq+"</td>";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+docname+"</td>";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+docdep+"</td>";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+docwriter+"</td>";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+docdate+"</td>";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+confirmokdate+"</td>";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+confirmstate+"</td>";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+docstate+"</td>";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+confirmname+"</td>";
    		output="<td onclick=\"javascript:viewarticle('"+docseq+"','"+docname+"');\">"+docsubject+"</td>";
    		output="</tr>";
    		$("#businesslistview").empty();
    		$("#businesslistview").append(output); 
    	}
    	  	
    	
		
    }*/
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
