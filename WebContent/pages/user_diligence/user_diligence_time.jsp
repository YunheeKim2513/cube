<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/common/user_public.jsp"%>

<!-- /#page-wrapper 
<form id="diligenceTimeForm" name="diligenceTimeForm" method="get" action="">

 <input type="hidden" id="act" name="act" value="getstarttime">
-->	

<div id="page-wrapper">
	<div class="row">

		<div class="col-lg-12">
			<h1 class="page-header">근태관리</h1>
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
							<tr>
								<td colspan="3">&nbsp;출퇴근체크</td>
							<tr>
								<td valign="middle" align="center" rowspan="2">
								<label></label>
									<h4><b><div id="showtime" style="height: 30px; vertical-align: middel"></div></b></h4>
								</td>
								<td>&nbsp;&nbsp;<input type="button"
									class="btn btn-primary" id="inbutton" name="inbutton"
									value="출근" > &nbsp;&nbsp;
									<input class="form-controltext" readonly="" type="text"
									id="intime" name="intime"></td>
							</tr>
							<tr>
								<td>&nbsp;&nbsp;<input type="button" id="outbutton"
									class="btn btn-primary" value="퇴근"> &nbsp;&nbsp;<input
									class="form-controltext" readonly="" type="text" id="outtime"
									name="outtime"></td>
							</tr>
						</table>
					
				
					
					<!--big calendar-->
					<div id="calendar"></div>
					<!--big calendar-->	
					

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
	<input type="button" id="startbutton" name="startbutton" value=""
		onclick="javascript:starttime();" style="display: none">
</div>
<!-- /#wrapper 
</form>
-->
<!-- jQuery -->
<script src="<%=root%>/css/vendor/jquery/jquery.min.js"></script>


<!-- Big Calendar -->
<script type="text/javascript" src="<%=root %>/js/user_diligence/diligence_time.js"></script>	
<link href='<%=root%>/css/calendar/fullcalendar.css' rel='stylesheet' />
<link href='<%=root%>/css/calendar/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='<%=root%>/lib/moment.min.js'></script>
<script src='<%=root%>/lib/jquery.min.js'></script>
<script src='<%=root%>/js//calendar/fullcalendar.min.js'></script>

<!-- Custom Theme JavaScript -->
<script src="<%=root%>/css/dist/js/sb-admin-2.js"></script>


<script type="text/javascript" charset='utf-8'>
	$(document).ready(function() {
		$("#startbutton").trigger("click");
		$("#startbutton").hide();
	});

	var httpRequest;
</script>

<script type="text/javascript" src="<%=root%>/js/user/diligence.js"></script>

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




</body>

</html>