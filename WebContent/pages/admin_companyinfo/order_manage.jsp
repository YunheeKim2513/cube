<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" %>
<%@ include file="/common/admin_public.jsp"%>

<!-- /#page-wrapper -->
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">���� ����</h1>
			<div style="text-align: right; vertical-align: middle">
				<select class="form-control22">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

<div id="main">

		<div id="left">
			<div>
				<font color="white">.</font>
			</div>
			<div class="order">
				<div class="order">���Ѻ� ����� ���Ѽ����Դϴ�.</div>
				<div></div>
			</div>

			<div id="list">
				<div>������</div>
				<div class="order">
					<input type="image" src="../../img/admin_companyinfo/plus.png" border="0" onclick=""><font
						color="white">..</font>�濵������<br>
				</div>
				<div class="order">
					<img src="../../img/admin_companyinfo/pointer.png"><font color="white">..</font>������ȹ��
					<br>
				</div>
				<div class="order">
					<input type="image" src="../../img/admin_companyinfo/plus.png" border="0" onclick=""><font
						color="white">..</font>����2�� <br>
				</div>
				<div class="order">
					<input type="image" src="../../img/admin_companyinfo/plus.png" border="0" onclick=""><font
						color="white">..</font>����1�� <br>
				</div>
			</div>
		</div>
		<div id="right">
			<div style="float: right; position: relative; right: 10%">
				<input type="button" id="save" value="����" onClick="">
			</div>
			<div>
				<font color="white">.</font>
			</div>
			<div>
				<font color="white">.</font>
			</div>
			<div>
				<table class="table-style-three">
					<thead>
						<tr>
							<th><input type="checkbox" name="chk_info" value="HTML"
								checked="checked" onclick="javascript:showemp();"></th>
							<th>�μ�</th>
							<th>����</th>
							<th>�̸�</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th><input type="checkbox" name="chk_info" value="HTML"
								checked="checked"></th>
							<td>235312</td>
							<td>John</td>
							<td>Doe</td>
						</tr>
						<tr>
							<th><input type="checkbox" name="chk_info" value="HTML"
								checked="checked"></th>
							<td>235312</td>
							<td>John</td>
							<td>Doe</td>
						</tr>
						<tr>
							<th><input type="checkbox" name="chk_info" value="HTML"
								checked="checked"></th>
							<td>235312</td>
							<td>John</td>
							<td>Doe</td>
						</tr>
						<tr>
							<th><input type="checkbox" name="chk_info" value="HTML"
								checked="checked"></th>
							<td>235312</td>
							<td>John</td>
							<td>Doe</td>
						</tr>
						<tr>
							<th><input type="checkbox" name="chk_info" value="HTML"
								checked="checked"></th>
							<td>235312</td>
							<td>John</td>
							<td>Doe</td>
						</tr>
						<tr>
							<th><input type="checkbox" name="chk_info" value="HTML"
								checked="checked"></th>
							<td>235312</td>
							<td>John</td>
							<td>Doe</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>



	<!-- /.row -->
</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="<%=root%>/css/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=root%>/css/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=root%>/css/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Flot Charts JavaScript -->
<script src="<%=root%>/css/vendor/flot/excanvas.min.js"></script>
<script src="<%=root%>/css/vendor/flot/jquery.flot.js"></script>
<script src="<%=root%>/css/vendor/flot/jquery.flot.pie.js"></script>
<script src="<%=root%>/css/vendor/flot/jquery.flot.resize.js"></script>
<script src="<%=root%>/css/vendor/flot/jquery.flot.time.js"></script>
<script
	src="<%=root%>/css/vendor/flot-tooltip/jquery.flot.tooltip.min.js"></script>
<script src="<%=root%>/css/data/flot-data.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=root%>/css/dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
	$(document).ready(function() {
		$('#dataTables-example').DataTable({
			responsive : true
		});
	});
</script>

</body>

</html>
