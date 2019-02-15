<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.GradesDto"%>
<%@ include file="/common/admin_public.jsp" %>
<%
List<GradesDto> list=(List<GradesDto>)request.getAttribute("gradelist");
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<form id="gForm" name="gForm" method="get" value="">
	<input type="hidden" id="act" name="act" value="">
	<input type="hidden" id="id" name="id" value="">
    <div id="wrapper">

        <!-- Navigation -->

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">부서/직급 관리</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            직급
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                       		<!-- /.table-responsive -->
                            <div class="well">
                            
                                <table class="table table-striped table-bordered table-hover">
                                	<tr>
                                		<td>직급명</td>
                                		<td><input type="text" style="width:300px" id="grade_name" name="grade_name"></td>
                                		
                                	</tr>
                                	<tr>
                                		<td>직급번호</td>
                                		<td><input type="text" style="width:300px" id="grade_id" name="grade_id"></td>
                                		
                                	</tr>
                                </table>
                                <a class="btn btn-default btn-lg btn-block" target="_blank" href="javascript:grade_write();">추가</a>
                            </div>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>no</th>
                                        <th>직급 명</th>
                                        <th>직급 번호</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                    if(list!=null){
                                    	int seq=1;
                                    	int len=list.size();
                                    	for(int i=0;i<len;i++){%>
                                    <tr class="odd gradeX" id="<%=list.get(i).getGrade_id() %>">
                                   		<td><%=seq++ %></td>
                                        <td><%=list.get(i).getGrade_name() %></td>
                                        <td><%=list.get(i).getGrade_id() %></td>
                                        <td><input type="button" value="삭제" onclick="javascript:what(this);"></td>
                                    </tr>
                                    <%
                                    	}
                                    } else {%>
                                    	<h3>데이터가 없습니다.</h3>
                                    <%
                                    }%>
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
            
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
</form>
    <!-- jQuery -->
    <script src="<%=root%>/css/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=root%>/css/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=root%>/css/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="<%=root%>/css/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%=root%>/css/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<%=root%>/css/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=root%>/css/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
    
	<script type="text/javascript">
    function grade_write(){
    	if(document.getElementById("grade_id").value==""){
    		alert("직급 번호를 입력하시오.");
    		return;
    	} else if(document.getElementById("grade_name").value==""){
    		alert("직급 명을 입력하시오.");
    		return;
    	} else {
    		document.getElementById("act").value = "write";
    		document.gForm.action = "<%=root%>/grade";
    		document.gForm.submit();
    	}
    }
    
    </script>
   	
   	<script type="text/javascript">
	function what(obj){
			var tr_id=obj.parentNode.parentNode.id
			gradedelete(tr_id);
			
			
			var tr=$(obj).parent().parent();
			tr.remove();
	}
	function gradedelete(id){
		document.getElementById("act").value = "delete";
		document.getElementById("id").value = id;
		document.gForm.action = "<%=root%>/grade";
		document.gForm.submit();
	}
	</script>
</body>

</html>
