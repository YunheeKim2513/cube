<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.cube.model.dto.ScheduleDto,com.cube.model.dto.DepartmentsDto,com.cube.model.dto.EmployeesListDto"%>
<%@ include file="/common/user_public.jsp"%>
<%
List<ScheduleDto> schedule_list=(List<ScheduleDto>)request.getAttribute("slist");
List<DepartmentsDto> depart_list=(List<DepartmentsDto>)request.getAttribute("dlist");
List<EmployeesListDto> emp_list=(List<EmployeesListDto>)request.getAttribute("elist");
String change="00";
Calendar cal=Calendar.getInstance();
int year=cal.get(Calendar.YEAR);
int month=cal.get(Calendar.MONTH)+1;
int day=cal.get(Calendar.DAY_OF_MONTH);
int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
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
  		padding: .8em .5em; /* 여백으로 높이 설정 */
  		font-family: inherit;  /* 폰트 상속 */
}

select {
  width: 100px; /* 원하는 너비설정 */
  padding: .8em .5em; /* 여백으로 높이 설정 */
  font-family: inherit;  /* 폰트 상속 */
  background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%; /* 네이티브 화살표 대체 */  
  border: 1px solid #999; 
  border-radius: 0px; /* iOS 둥근모서리 제거 */
  -webkit-appearance: none; /* 네이티브 외형 감추기 */
  -moz-appearance: none;
  appearance: none;
  background: url(이미지 경로) no-repeat 95% 50%;  /* 화살표 모양의 이미지 */ 
}

/* IE 10, 11의 네이티브 화살표 숨기기 */
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
			<h1 class="page-header">일정 관리</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	
	<form id="private" name="private" method="post">
		<input type="hidden" id="act" name="act" value="write">
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">개인 일정</div>
				<div>
					<div class="panel-body">
						<table>
							<tr>
								<td style="width: 100%" colspan="3">
									<div id="calendar"></div></td>
     
                                            
									<!-- Modal -->
									
                                        <div class="modal fade" id="schedulewrite" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header" style="padding-right:30px">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h4 class="modal-title" id="myModalLabel">일정 등록</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                    	
													
														<div class="divtable">
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd">일정구분</div>
																<br>
																<div class="divtd">
																	<select id="division" name="division" >
																		<option value="개인">개인</option>
																	</select>
																</div>
															</div>
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd">일정명</div>
																<br>
																<div class="divtd">
																	<input type="text" id="schedule_subject" name="schedule_subject">
																</div>
															</div>
															
															
															
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd">기간 설정</div>
																<br>
																<div class="divtd">
																
													<select id="startyear" name="startyear">
													<%for(int x=year+10; x>=year-20; x--) {
														if(x==year) {%>
													<option selected="selected" value="<%=x %>"><%=x %></option>														
													<%	} else {%>
													<option value="<%=x %>"><%=x %></option>
													<%	}
													} %>
													</select>
													년
													<select id="startmonth" name="startmonth">
													<%for(int y=1; y<=12; y++) {
														if(y<10){
															change="0"+y;
														} else {
															change=y+"";
														}
														if(y==month) {%>
													<option selected="selected" value="<%=change %>"><%=change %></option>														
													<%	} else {%>
													<option value="<%=change %>"><%=change %></option>
													<%	}
													} %>
													</select>
													월
													<select id="startday" name="startday">
													<%for(int z=1; z<=31; z++) {
														if(z<10){
															change="0"+z;
														} else {
															change=z+"";
														}
														if(z==day) {%>
														<option selected="selected" value="<%=change %>"><%=change %></option>
													<%	} else {%>	
														<option value="<%=change %>"><%=change %></option>														
													<%	}
													}%>
													</select>
							                    	일
																</div>
															</div>
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd"></div>
																<br>
																<div class="divtd">
																
													<select id="endyear" name="endyear">
													<%for(int x=year+10; x>=year-20; x--) {
														if(x==year) {%>
														<option selected="selected" value="<%=x %>"><%=x %></option>														
														<%	} else {%>
														<option value="<%=x %>"><%=x %></option>
													<%	}
													} %>
													</select>
													년
													<select id="endmonth" name="endmonth">
													<%for(int y=1; y<=12; y++) {
														if(y<10){
															change="0"+y;
														} else {
															change=y+"";
														}
														if(y==month) {%>
													<option selected="selected" value="<%=change %>"><%=change %></option>														
													<%	} else {%>
													<option value="<%=change %>"><%=change %></option>
													<%	}
													} %>
													</select>
													월
													<select id="endday" name="endday">
													<%for(int z=1; z<=31; z++) {
														if(z<10){
															change="0"+z;
														} else {
															change=z+"";
														}
														if(z==day) {%>
														<option selected="selected" value="<%=change %>"><%=change %></option>
													<%	} else {%>	
														<option value="<%=change %>"><%=change %></option>														
													<%	}
													}%>
													</select>
							                    	일
																</div>
															</div>
															
															
															
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd">내용</div>
																<br>
																<div class="divtd">
																	<textarea rows="4" cols="50" id="content" name="content"></textarea>
																</div>
															</div>
															<div class="divtr"><br></div>
															<div class="divtr"><br></div>
														</div>
														<div class="modal-footer">
                                                  	 	<button type="submit" class="btn btn-primary" id="schedulePwrite">등록</button>&nbsp;&nbsp;&nbsp;
                                                  	 	<button type="button" class="btn btn-primary" data-dismiss="modal">취소</button>
												   		 </div>
                                                    </div>
                                                </div>
                                                </div>
                                                <!-- /.modal-content -->
                                            </div>
                                            
                                            
                                            
                                            
                                            
                                            <div class="modal fade" id="scheduleupdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header" style="padding-right:30px">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h4 class="modal-title" id="myModalLabel">일정 등록</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                    	
													
														<div class="divtable">
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd">일정구분</div>
																<br>
																<div class="divtd">
																	<select id="division" name="division" >
																		<option value="개인">개인</option>
																	</select>
																</div>
															</div>
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd">일정명</div>
																<br>
																<div class="divtd">
																	<input type="text" id="schedule_subject" name="schedule_subject" value="">
																</div>
															</div>
															
															
															
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd">기간 설정</div>
																<br>
																<div class="divtd">
																
													<select id="startyear" name="startyear">
													<%for(int x=year+10; x>=year-20; x--) {
														if(x==year) {%>
													<option selected="selected" value="<%=x %>"><%=x %></option>														
													<%	} else {%>
													<option value="<%=x %>"><%=x %></option>
													<%	}
													} %>
													</select>
													년
													<select id="startmonth" name="startmonth">
													<%for(int y=1; y<=12; y++) {
														if(y==month) {%>
													<option selected="selected" value="<%=y %>"><%=y %></option>														
													<%	} else {%>
													<option value="<%=y %>"><%=y %></option>
													<%	}
													} %>
													</select>
													월
													<select id="startday" name="startday">
													<%for(int z=1; z<=31; z++) {
														if(z==day) {%>
														<option selected="selected" value="<%=z %>"><%=z %></option>
													<%	} else {%>	
														<option value="<%=z %>"><%=z %></option>														
													<%	}
													}%>
													</select>
							                    	일
																</div>
															</div>
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd"></div>
																<br>
																<div class="divtd">
																
													<select id="endyear" name="endyear">
													<%for(int x=year+10; x>=year-20; x--) {
														if(x==year) {%>
														<option selected="selected" value="<%=x %>"><%=x %></option>														
														<%	} else {%>
														<option value="<%=x %>"><%=x %></option>
													<%	}
													} %>
													</select>
													년
													<select id="endmonth" name="endmonth">
													<%for(int y=1; y<=12; y++) {
														if(y==month) {%>
													<option selected="selected" value="<%=y %>"><%=y %></option>														
													<%	} else {%>
													<option value="<%=y %>"><%=y %></option>
													<%	}
													} %>
													</select>
													월
													<select id="endday" name="endday">
													<%for(int z=1; z<=31; z++) {
														if(z==day) {%>
														<option selected="selected" value="<%=z %>"><%=z %></option>
													<%	} else {%>	
														<option value="<%=z %>"><%=z %></option>														
													<%	}
													}%>
													</select>
							                    	일
																</div>
															</div>
															
															
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd">내부 참여자</div>
																<br>
																<div class="divtd">
																	<input type="text" id="participant_text" value="" readonly="readonly">
																	<input type="button" class="btn btn-primary" id="participant_button" value="조회" onclick="" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#participant">
																</div>
															</div>
															<div class="divtr">
																<br>
																<div class="divtd"></div>
																<div class="divtd">내용</div>
																<br>
																<div class="divtd">
																	<textarea rows="4" cols="50" id="content" name="content"></textarea>
																</div>
															</div>
															<div class="divtr"><br></div>
															<div class="divtr"><br></div>
														</div>
														<div class="modal-footer">
                                                  	 	<button type="submit" class="btn btn-primary" id="schedulePwrite" >등록</button>&nbsp;&nbsp;&nbsp;
                                                  	 	<button type="button" class="btn btn-primary" data-dismiss="modal">취소</button>
												   		 </div>
                                                    </div>
                                                </div>
                                                </div>
                                                <!-- /.modal-content -->
                                            </div>
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                           <div class="modal fade" id="participant" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header" style="padding-right:30px">
                                                    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h4 class="modal-title" id="myModalLabel">내부 참여자</h4>
                                                    </div>        
                                                    <div class="modal-body">
                                                      <div id="tree">
                                                      		<%int idx=1;
                                                      		int dlen=depart_list.size();
                                                      		int elen=emp_list.size();
                                                      		for(int i=0; i<dlen; i++) {%>
                                                      			<ul>
	                                                       			<li id="cid<%=idx++ %>" class="depart"><%=depart_list.get(i).getDepartment_name() %>
                                                      			<%for(int j=0; j<elen; j++) {%>
                                                      				<ul>
                                                      				<%if((depart_list.get(i).getDepartment_id())
                                                      						.equals(emp_list.get(j).getDepartment_id())){%>
	                                                       				<li class="emp" id="<%=emp_list.get(j).getEmployee_id() %>">[<%=emp_list.get(j).getGrade_name() %>] <%=emp_list.get(j).getName() %></li>
	                                                       		<%	}%>
	                                                       			</ul>
                                                      			<%}%>
                                                      				</li>
	                                                       		</ul>
                                                       		<%}%>
                                                       	</div>
                                                     </div>
                                                    <div class="modal-footer">
                                                  	 	<button type="submit" class="btn btn-primary" id="btnExpandAll">등록</button>&nbsp;&nbsp;&nbsp;
												       <button type="button" class="btn btn-primary" data-dismiss="modal">취소</button>
												    </div>
                                                </div>
                                                </div>
                                                <!-- /.modal-content -->
                                            </div>
                                           
                                            <!-- /.modal-dialog -->
                                            
                                        </div>
                                       <!-- /.modal -->
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
	<script type="text/javascript" src="<%=root%>/js/user_schedule/schedule_private.js"></script>
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

	<script>
	$("#schedulePwrite").click(function () {
		if(document.getElementById("schedule_subject").value=="") {
			alert("일정명을 입력하시오!!");
			return;
		} else if(document.getElementById("content").value=="") {
			alert("내용을 입력하시오!!");
			return;
		} else {
			document.private.action="<%=root%>/schedule_private";
            $("#private").submit();
		}
	});
	</script>

	</body>

	</html>