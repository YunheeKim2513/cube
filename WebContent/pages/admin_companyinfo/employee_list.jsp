<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.EmployeesListDto"%>
<%@ include file="/common/admin_public.jsp"%>
<%
List<EmployeesListDto> list=(List<EmployeesListDto>)request.getAttribute("emplist");
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
<form id="eForm" name="eForm" method="get" value="">
	<input type="hidden" id="act" name="act" value="">
	<input type="hidden" id="id" name="id" value="">
    <div id="wrapper">

        <!-- Navigation -->
        

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">사원 관리</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            사원 리스트
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>no</th>
                                        <th>사원 이름</th>
                                        <th>사원 번호</th>
                                        <th>부서 명</th>
                                        <th>직급 명</th>
                                        <th>근무 조</th>
                                        <th>E-mail</th>
                                        <th>주소</th>
                                        <th>휴대폰 번호</th>
                                        <th>자택 번호</th>
                                        <th>성별</th>
                                        <th>결혼여부</th>
                                        <th>입사일</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<%
                                    if(list!=null){
                                    	int seq=1;
                                    	int len=list.size();
                                    	for(int i=0;i<len;i++){%>
                                    <tr class="even gradeC" id="<%=list.get(i).getEmployee_id() %>">
                                    	<td><%=seq++%></td>
                                        <td><%=list.get(i).getName() %></td>
                                        <td><%=list.get(i).getEmployee_id() %></td>
                                        <td><%=list.get(i).getDepartment_name() %></td>
                                        <td class="center"><%=list.get(i).getGrade_name() %></td>
                                        <td><%=list.get(i).getGroup_standard() %>
                                        <td><%=list.get(i).getEmail1() %>@<%=list.get(i).getEmail2() %></td>
                                        <td><%=list.get(i).getZip1() %> <%=list.get(i).getZip2() %> 
                                        	<%=list.get(i).getAddr1() %> <%=list.get(i).getAddr2() %></td>
                                        <td><%=list.get(i).getHp1() %>-<%=list.get(i).getHp2() %>-<%=list.get(i).getHp3() %></td>
                                        <td><%=list.get(i).getHn1() %>-<%=list.get(i).getHn2() %>-<%=list.get(i).getHn3() %></td>
                                        <td><%=list.get(i).getGender() %></td>
                                        <td><%=list.get(i).getMarraige() %></td>
                                        <td><%=list.get(i).getHire_date() %></td>
                                    	<td><input type="button" onclick="javascript:update(this);" value="수 정"></td>
                                    </tr>
                                    <%
                                    	}
                                    } else {%>
                                    	<h3>데이터가 없습니다.</h3>
                                    <%} %>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            
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
</form>    
    <!-- /#wrapper -->

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
	function update(obj){
		var tr_id=obj.parentNode.parentNode.id
		
		document.getElementById("act").value = "mvupdate";
		document.getElementById("id").value = tr_id;
		document.eForm.action = "<%=root%>/emp";
		document.eForm.submit();
	}
	</script>
</body>

</html>
