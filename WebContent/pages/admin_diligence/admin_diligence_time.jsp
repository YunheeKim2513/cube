<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="com.cube.model.dto.DiligencegroupDto, com.cube.model.dto.Admin_timeSelectDto, com.cube.model.dto.EmployeesDto, com.cube.model.dto.Admin_timeSelectDto"%>
<%@ include file="/common/admin_public.jsp"%>
<%
	List<DiligencegroupDto> list = (List<DiligencegroupDto>) request.getAttribute("diligencegroup");

   List<Admin_timeSelectDto> admintime_list = (List<Admin_timeSelectDto>) request.getAttribute("admin_timeselectlist");
   
	//JSONObject diligencegrouplist = (JSONObject) request.getAttribute("diligencegrouplist"); 
   	
%>

<!-- /#page-wrapper -->

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">출퇴근 시간설정</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
		
				<!-- /.panel-heading -->
				<div class="panel-body">
					<table width="100%"
						class="table table-striped table-bordered table-hover"
						id="dataTables-example2">
						<tr>
							<td valign="middle" align="center" colspan="2"
								background-color="#c0c0c0" style=" background-color:#e7e7e7;"><b>출근시간</b></td>
							<td valign="middle" align="center" style="background-color:white;"><select name="starttime"
								border="1" style="height: 40px; " id="starttime">
									<option value="오전" selected>&nbsp&nbsp오전&nbsp&nbsp</option>
									<option value="오후">&nbsp&nbsp오후&nbsp&nbsp</option>
							</select></td>
							<td valign="middle" align="center" style="background-color:white;"><input type="text"
								name="starthour" style="height: 40px;" id="starthour">&nbsp&nbsp<b>시</b></td>
							<td valign="middle" align="center" style="background-color:white;"><input type="text"
								name="startmin" style="height: 40px;" id="startmin">&nbsp&nbsp<b>분</b></td>
							<td colspan="3" valign="middle" align="center" id="" name="" style=" background-color:#e7e7e7;"><b>근태그룹설정</b></td>
						</tr>
						<tr>
							<td valign="middle" align="center" colspan="2"
								background-color="#c0c0c0" style=" background-color:#e7e7e7;"><b>퇴근시간</b></td>
							<td valign="middle" align="center" style="background-color:white;"><select name="endtime"
								id="endtime" style="height: 40px;">
									<option value="오후" selected>&nbsp&nbsp오후&nbsp&nbsp</option>
									<option value="오전">&nbsp&nbsp오전&nbsp&nbsp</option>
							</select></td>
							<td valign="middle" align="center"><input type="text"
								name="endhour" id="endhour" style="height: 40px;">&nbsp&nbsp<b>시</b></td>
							<td valign="middle" align="center"><input type="text"
								name="endmin" id="endmin" style="height: 40px;">&nbsp&nbsp<b>분</b></td>
							<td colspan="3" rowsapn="2" valign="middle" align="center">
								<select name="adminend" style="height: 40px;"
								id="diligenceselect">
									<option value="" selected>&nbsp&nbsp--------근태종류--------&nbsp&nbsp</option>

									<option value="야간">야간</option>
									<option value="주간">주간</option>

							</select>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name=""
								style="height: 40px; width: 25%;" id="diligencegrouptext">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<button type="button" class="btn btn-primary"
									id="diligencegroupInputbtn">설정</button>
							</td>
							
						</tr>
						
						<tr>
							<td valign="middle" align="center" colspan="2"
								background-color="#c0c0c0" style=" background-color:#e7e7e7;"><b>근태그룹</b></td>
							<td colspan="3" valign="middle" align="center" style="background-color:white; border:1;">
							<select name="group" style="height: 40px; width: 50%;" id="diligencelist">
									 <option value="" selected>----------------------------그룹선택----------------------------</option>
							
									<!-- <option id="diligencelist"></option>  -->
							
									<%-- data.
										String key = "kind";
										int size = list.size();
										for (int i = 0; i < size; i++) {
											DiligencegroupDto diligencegroupDto = list.get(i);
									--%>
									<!-- <option value="<%--=diligencegroupDto.getGroup_standard()%>"><%=diligencegroupDto.getGroup_standard()--%></option> -->

									<%--
										}
									--%>
							</select>&nbsp&nbsp&nbsp&nbsp
								<button type="button" class="btn btn-primary" id="diligencesave">근태 저장</button></td>
<td style="background-color:white; border:0;"></td>
						</tr>
					</table>

					<!-- 리스트-->

					<!-- /.panel-heading -->
					<!-- <div class="panel-body"> -->
						<!-- <div id="dataTables-example_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap no-footer"> -->
						<!-- 	<div class="row">
								<div class="col-sm-6">
									<div class="dataTables_length" id="dataTables-example_length" >
										<label>Show <select name="dataTables-example_length"
											aria-controls="dataTables-example"
											class="form-control input-sm"><option value="10">10</option>
												<option value="25">25</option>
												<option value="50">50</option>
												<option value="100">100</option></select> entries
										</label>
										
								
									</div>
									
								</div>
								<div class="col-sm-6">
									<div id="dataTables-example_filter" class="dataTables_filter">
									
								
										<label>Search:<input type="search"
											class="form-control input-sm" placeholder=""
											aria-controls="dataTables-example"></label>
									</div>
									
								</div> 
								
							</div> -->
						
								<div class="panel-heading">
									    
									<button type="button" class="btn btn-primary" id="alldeck">모두선택해제</button>							
											
									<button type="button" class="btn btn-primary" id="allck">모두선택</button>
									
									<button type="button" class="btn btn-primary" id="deletebtn">삭제</button>
									
                        		</div>
                        		<div style="overflow:auto; height:500px; padding:2%; ">
									<table width="100%" class="table table-striped table-bordered table-hover"  id="dataTables-example1">
										<thead>
									
											<tr role="row">
											
												<th tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 294px; background-color:#e7e7e7;">일련번호</th>
												<th class="sorting_asc" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-sort="ascending"
													aria-label="Rendering engine: activate to sort column descending"
													style="width: 268px; background-color:#e7e7e7;" >그룹이름</th>
												<th class="sorting" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													style="width: 321px; background-color:#e7e7e7;" >출근시간</th>
												<th class="sorting" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 294px; background-color:#e7e7e7;" >퇴근시간</th>
												<th tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 294px; background-color:#e7e7e7;">삭제</th>
											
											</tr>
										
										</thead>
										
										<tbody id="diligencegrouplist">
				
										</tbody>
										
									</table>
							</div>
						
						<!-- </div> -->
						<!-- /.table-responsive -->

					</div>
					<!-- /.panel-body -->

					<!-- 리스트-->
	
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
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

<script src="<%=root%>/js/admin/diligence.js" charset="utf-8"></script>



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