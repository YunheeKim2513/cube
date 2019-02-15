<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/common/admin_public.jsp"%>

<!-- /#page-wrapper -->
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">근태현황통계</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">

				<div class="panel-heading"></div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="100%"
						class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<tr valign="middle" align="center">
							<td>부서</td>
							<td><select name="depselect">
									<option value="administration" selected>경영기획팀</option>
									<option value="marketing">마케팅팀</option>
									<option value="accounting">재무회계팀</option>
									<option value="HR">인사팀</option>
									<option value="sales">영업팀</option>
							</select></td>
							<td>검색기간이 들어갈 자리</td>
							<td>검색기간이 들어갈 자리</td>
						</tr>
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
<script src="<%=root%>/css/vendor/jquery/jquery.min.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
	$(document).ready(function() {
		$('#dataTables-example').DataTable({
			responsive : true
		});
	});
</script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=root%>/css/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=root%>/css/vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script
	src="<%=root%>/css/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script
	src="<%=root%>/css/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script
	src="<%=root%>/css/vendor/datatables-responsive/dataTables.responsive.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=root%>/css/dist/js/sb-admin-2.js"></script>



</body>

</html>
