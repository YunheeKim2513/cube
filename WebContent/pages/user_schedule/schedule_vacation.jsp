<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.cube.model.dto.ScheduleDto,com.cube.model.dto.DepartmentsDto,com.cube.model.dto.EmployeesListDto"%>
<%@ include file="/common/user_public.jsp"%>
<%
List<ScheduleDto> schedule_list=(List<ScheduleDto>)request.getAttribute("slist");
List<DepartmentsDto> depart_list=(List<DepartmentsDto>)request.getAttribute("dlist");
List<EmployeesListDto> emp_list=(List<EmployeesListDto>)request.getAttribute("elist");


%>

	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="<%=root %>/js/user_schedule/jquery.treemenu.js"></script>
	<script>
	$(function(){
        $("div#participant div#tree").treemenu({delay:300}).openActive();
    });
	</script>



<link href="<%=root %>/css/user_schedule/jquery.treemenu.css" rel="stylesheet" type="text/css">
<style type="text/css">
.divtable {display:table;}
.divtr {display:table-row;}
.divtd {display:table-cell;
  		padding: .8em .5em; /* �������� ���� ���� */
  		font-family: inherit;  /* ��Ʈ ��� */
}

select {
  width: 100px; /* ���ϴ� �ʺ��� */
  padding: .8em .5em; /* �������� ���� ���� */
  font-family: inherit;  /* ��Ʈ ��� */
  background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%; /* ����Ƽ�� ȭ��ǥ ��ü */  
  border: 1px solid #999; 
  border-radius: 0px; /* iOS �ձٸ𼭸� ���� */
  -webkit-appearance: none; /* ����Ƽ�� ���� ���߱� */
  -moz-appearance: none;
  appearance: none;
  background: url(�̹��� ���) no-repeat 95% 50%;  /* ȭ��ǥ ����� �̹��� */ 
}

/* IE 10, 11�� ����Ƽ�� ȭ��ǥ ����� */
select::-ms-expand { 
  display: none;
}






.tree { background-color:#2C3E50; color:#46CFB0;}
.tree li,
.tree li > a,
.tree li > span {
    padding: 4pt;
    border-radius: 4px;
}

.tree li a {
   color:#46CFB0;
    text-decoration: none;
    line-height: 20pt;
    border-radius: 4px;
}

.tree li a:hover {
    background-color: #34BC9D;
    color: #fff;
}

.active {
    background-color: #34495E;
    color: white;
}

.active a {
    color: #fff;
}

.tree li a.active:hover {
    background-color: #34BC9D;
}


</style>


<!-- /#page-wrapper -->
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">���� ����</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	
	<form id="private" name="private" method="post">
		<input type="hidden" id="act" name="act" value="write">
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">�ް� ����</div>
				<div>
					<div class="panel-body">
						<table>
							<tr>
								<td style="width: 100%" colspan="3">
									<div id="calendar"></div></td>
							</tr>
						</table>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	 </form>
	<!-- /.row -->
	
	
</div>	
		<!-- /.row -->
		<!-- /.row -->
	<!-- /#wrapper -->


	<!-- jQuery -->
	<script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>



	<!-- Big Calendar -->
	<script type="text/javascript" src="<%=root%>/js/user_schedule/schedule_vacation.js"></script>
	<link href='<%=root%>/css/calendar/fullcalendar.css' rel='stylesheet' />
	<link href='<%=root%>/css/calendar/fullcalendar.print.css'
		rel='stylesheet' media='print' />
	<script src='<%=root%>/lib/moment.min.js'></script>
	<!-- <script src='<%=root%>/lib/jquery.min.js'></script> -->
	<script src='<%=root%>/js/calendar/fullcalendar.min.js'></script>


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