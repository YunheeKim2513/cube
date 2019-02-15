<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%@ include file="/common/admin_public.jsp" %>

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
<form id="eokForm" name="eokForm" method="post" value="">
		<input type="hidden" id="act" name="act" value="">
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
                            사원 등록
                        </div>
                        <!-- /.panel-heading -->
                        <table align="center">
                        	<tr><td><font color="white">.</font></td></tr>
                        	<tr align="center"><td><h2>사원 등록 실패</h2></td></tr>
                        	<tr align="center"><td><font color="white">.</font></td></tr>
                        	<tr align="center"><td><font color="white">.</font></td></tr>
                        	<tr align="center"><td><font color="white">.</font></td></tr>
                        	<tr align="center">
                        		<td align="center">
                        			<input type="button" value="사원 등록" onclick="javascript:signup();">
                        			<font color="white">.....</font>
                        			<input type="button" value="사원 리스트" onclick="javascript:emplist();">
                        		</td>
                        	</tr>
                        	<tr align="center"><td><font color="white">.</font></td></tr>
                        	<tr align="center"><td><font color="white">.</font></td></tr>
                        </table>
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
    function signup(){
    	document.getElementById("act").value="mvwrite";
    	document.eokForm.action = "<%=root%>/emp";
		document.eokForm.submit();
    }
    
    function emplist(){
    	document.getElementById("act").value="list";
    	document.eokForm.action = "<%=root%>/emp";
		document.eokForm.submit();
    }
    </script>
    
</body>

</html>
