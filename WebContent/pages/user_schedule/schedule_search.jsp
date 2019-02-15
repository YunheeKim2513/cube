<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.ScheduleDto" %>
<%@ include file="/common/user_public.jsp" %>
<%
List<ScheduleDto> list=(List<ScheduleDto>)request.getAttribute("scheduleList");

Calendar cal=Calendar.getInstance();
int year=cal.get(Calendar.YEAR);
int month=cal.get(Calendar.MONTH)+1;
int day=cal.get(Calendar.DAY_OF_MONTH);
int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
%>
<!DOCTYPE html>
<html lang="en">
 
<head>

    <meta charset="EUC-KR">
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
<form id="ssForm" name="ssForm" method="post" >
	<input type="hidden" id="act" name="act" value="">
	<input type="hidden" id="id" name="id" value="">
    <div id="wrapper">

        <!-- Navigation -->

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">일정 관리</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            일정 검색
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                       		<!-- /.table-responsive -->
                            <div class="well">
                            
                                <table class="table table-striped table-bordered table-hover">
                                	<tr>
                                		<td></td>
                                		<td><input type="button" id="1day" onclick="javascript:oneday();" value="당일">
                                			<input type="button" id="1week" onclick="javascript:oneweek();" value="1주일">
                                			<input type="button" id="1month" onclick="javascript:onemonth();" value="1개월">
                                			<input type="button" id="3month" onclick="javascript:threemonth();" value="3개월">
                                		</td>
                                	</tr>
                                	<tr>
                                		<td>조회 일</td>
                                		<td><form class="demo-3">
                                     		<input type='text' id="nodayinputtext" name="nodayinputtext" value="" class="form-control" style="width:60%; display:none">
                                    		</form>
                              				<span class="col-lg-4" style="margin-left:-16px">
                                    			<form class="demo-3">
                                      				<input type='text' id="dayinputtext1" name="dayinputtext1" value="" class="form-control" style="width:60%; text-align:center">
                                    			</form>
                              				</span>
                              				<input type='text' id="daytext1" name="daytext1" value="" class="form-control" style="width:60%; display:none">
                              				
                              				<form class="demo-3">
                                     		<input type='text' id="nodayinputtext" name="nodayinputtext" value="" class="form-control" style="width:60%; display:none">
                                    		</form>
                              				<span class="col-lg-4" style="margin-left:-16px">
                                    			<form class="demo-3">
                                      				<input type='text' id="dayinputtext2" name="dayinputtext2" value="" class="form-control" style="width:60%; text-align:center">
                                    			</form>
                              				</span>
                              				<input type='text' id="daytext2" name="daytext2" value="" class="form-control" style="width:60%; display:none">
                               			</td>
                                	</tr>
                                	<tr>
                                		<td>일정 구분</td>
                                		<td><select id="kind" name="kind">
												<option value="개인">개인</option>		
												<option value="부서">부서</option>
												<option value="회사">회사</option>		
												<option value="휴가">휴가</option>		
											</select>
										</td>
                                	</tr>
                                	
                                </table>
                                <a id="search_button" class="btn btn-default btn-lg btn-block" target="_blank">검색</a>
                                <a id="list_button" class="btn btn-default btn-lg btn-block" target="_blank">전체 리스트</a>
                            </div>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>no</th>
                                        <th>일정구분</th>
                                        <th>등록자</th>
                                        <th>부서</th>
                                        <th>직급</th>
                                        <th>일자</th>
                                        <th>일정명</th>
                                        <th>일정내용</th>
                                        <th>수정/삭제</th>
                                    </tr>
                                </thead>
                                <tbody id="search_list">
                                    
                                </tbody>
                            </table>
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
																		<option value="회사">회사</option>
																		<option value="부서">부서</option>
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
                                                  	 	<button type="submit" class="btn btn-primary" id="scheduleUpdate" >등록</button>&nbsp;&nbsp;&nbsp;
                                                  	 	<button type="button" class="btn btn-primary" data-dismiss="modal">취소</button>
												   		 </div>
                                                    </div>
                                                </div>
                                                </div>
                                                <!-- /.modal-content -->
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

	<!-- Calendar -->
   <script src="<%=root %>/calendar/jquery.minical.js"></script>
   <script>
   $("form.demo-1 :text").minical();
   $("form.demo-2 :text").minical({inline: true});
   $("form.demo-3 :text").minical({trigger: "i.trigger-icon"});
   </script>
	
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
    var start;
    var end;

	$(document).ready(function() {
		getList();
    	$('#search_button').click(function(){
    		getSearchList();
    	});
    	$('#list_button').click(function(){
    		getList();
    	});
    });
    
    var search_list;
    
    function getList(){
    	$.ajax({
    	      type: "POST",
    	      dataType: 'json',
    	      url: "<%=root%>/schedule_search",
    	      data: { act: "list" },
    	      success:function(data) {
    	    	  List(data);
    	      },
    	      error: function(e){
    	    	  alert("Error!!");
    	      }
    	});
    }
    function getSearchList(){
    	var a=document.getElementById("kind").value;
    	var b=document.getElementById("dayinputtext1").value;
    	var c=document.getElementById("dayinputtext2").value;
    	$.ajax({
    	      type: "POST",
    	      dataType: 'json',
    	      url: "<%=root%>/schedule_search",
    	      contentType: "application/x-www-form-urlencoded; charset=euc-kr",
    	      data: { act: "search",
	    	  		  kind: encodeURIComponent(a), 
	    	  		  start: b, 
	    	  		  end: c 
    	      },
    	      success:function(data) {
    	    	  List(data);
    	      },
    	      error: function(e){
    	    	  alert("Error!!");
    	      }
    	});
    }
    
    function List(data){
    	var len=data.schedulelist.length;
    	var output = "";
    	for(var i=0;i<len;i++){
    		var seq=i+1;
    		var schedule_seq=data.schedulelist[i].schedule_seq;
    		var employee_id=data.schedulelist[i].employee_id;
    		var employee_name=data.schedulelist[i].employee_name;
    		var schedule_kind=data.schedulelist[i].schedule_kind;
    		var department_name=data.schedulelist[i].department_name;
    		var grade_name=data.schedulelist[i].grade_name;
    		var schedule_date=data.schedulelist[i].schedule_startdate+"~"+data.schedulelist[i].schedule_enddate;
    		var schedule_subject=data.schedulelist[i].schedule_subject;
    		var schedule_content=data.schedulelist[i].schedule_content;
    		start=data.schedulelist[i].schedule_startdate;
    		end=data.schedulelist[i].schedule_enddate;
    		
    		output += "<tr class=\"odd gradeX\" id=\"schedule_seq\" value=\"schedule_seq\" >";
			output += "	<td id=\"seq\">"+seq+"</td>";
			output += "	<td>"+schedule_kind+"</td>";
			output += "	<td>"+employee_name+"</td>";
			output += "	<td>"+department_name+"</td>";
			output += "	<td>"+grade_name+"</td>";
			output += "	<td>"+schedule_date+"</td>";
			output += "	<td>"+schedule_subject+"</td>";
			output += "	<td>"+schedule_content+"</td>";
    		if(employee_id!="<%=employeesDto.getEmployee_id() %>"){
    			output += "	<td></td>";
    		} else {
    			output += "	<td><input type=\"button\" value=\"수정\" onclick=\"javascript:scheduleView('" + schedule_seq + "');\">";
    			output += "		<input type=\"button\" value=\"삭제\" onclick=\"javascript:scheduleDelete('" + schedule_seq + "');\"></td>";
    		}
			output += "</tr>";
			
			jQuery("#search_list").empty();
			jQuery("#search_list").append(output);
    	}
   	}
var schedule_seq;
    function View(data){
    	var len=data.schedulelist.length;
    	var output = "";
    	if(len!=0){
    		schedule_seq=data.schedulelist[0].schedule_seq;
    		//alert("view : "+schedule_seq);
    		var schedule_kind=data.schedulelist[0].schedule_kind;
    		var schedule_subject=data.schedulelist[0].schedule_subject;
    		var schedule_content=data.schedulelist[0].schedule_content;
    		var start=data.schedulelist[0].schedule_startdate;
    		var end=data.schedulelist[0].schedule_enddate;
    		var date1=start.split("-");
		       var syear=date1[0];
		       var smonth=date1[1];
		       var sday=date1[2];
		    var date2=end.split("-");
		       var eyear=date2[0];
		       var emonth=date2[1];
		       var eday=date2[2];
    		document.getElementById("kind").value=schedule_kind;
    		document.getElementById("schedule_subject").value=schedule_subject;
    		document.getElementById("content").value=schedule_content;
    		document.getElementById("startyear").value=syear;
    		document.getElementById("startmonth").value=smonth;
    		document.getElementById("startday").value=sday;
    		document.getElementById("endyear").value=eyear;
    		document.getElementById("endmonth").value=emonth;
    		document.getElementById("endday").value=eday;
    		
    		
    	}
   	}
	
    function scheduleView(seq){
    	//alert("scheduleView : "+seq);
    	jQuery.ajax({
    	    type: "POST",
    	    dataType: 'json',
    	    url: "<%= root %>/schedule_search",
    	    data: { act: "view", seq: seq },
    	    success:function(data) {
    	    	View(data);
    	    },
    	    error: function(e) {
    	    	alert("에러!!");
    	    }
        });
    	$('#scheduleupdate').modal('show')
    }
    
    $("#scheduleUpdate").click(function(){
    	var seq=schedule_seq;
    	//alert("seq : "+seq);
    	var kind=document.getElementById("division").value;
		var subject=document.getElementById("schedule_subject").value;
		var content=document.getElementById("content").value;
		var startdate=document.getElementById("startyear").value
						+"-"+document.getElementById("startmonth").value
						+"-"+document.getElementById("startday").value;
		var enddate=document.getElementById("endyear").value
					+"-"+document.getElementById("endmonth").value
					+"-"+document.getElementById("endday").value;	
    	jQuery.ajax({
    	    type: "POST",
    	    dataType: 'json',
    	    url: "<%= root %>/schedule_search",
    	    contentType: "application/x-www-form-urlencoded; charset=euc-kr",
    	    data: { act: "update",
    	    		seq: seq,
    	    		subject: encodeURIComponent(subject),
    	    		content: encodeURIComponent(content),
    	    		kind: encodeURIComponent(kind), 
    	    		startdate: startdate,
    	    		enddate: enddate
    	    },
    	    success:function(data) {
    	    	List(data);
    	    },
    	    error: function(e) {
    	    	alert("에러!!");
    	    }
        });
    });
        
	function scheduleDelete(seq){
		jQuery.ajax({
    	    type: "POST",
    	    dataType: 'json',
    	    url: "<%= root %>/schedule_search",
    	    data: { act: "delete", seq: seq },
    	    success:function(data) {
    	    	List(data);
    	    },
    	    error: function(e) {
    	    	alert("에러!!");
    	    }
        });
    }
	
    </script>
    

	<script type="text/javascript">

	//검색
    function schedule_search(){
    		document.getElementById("act").value = "search";
    		document.ssForm.action = "<%=root%>/schedule";
    		document.ssForm.submit();
    }

	
	//당일, 1주일, 1개월, 3개월 버튼
	function oneday(){
		document.getElementById("dayinputtext1").value=todate();
		document.getElementById("dayinputtext2").value=todate();
	}
	function oneweek(){
		document.getElementById("dayinputtext1").value=todate();
		document.getElementById("dayinputtext2").value=week1();	
	}
	function onemonth(){
		document.getElementById("dayinputtext1").value=todate();
		document.getElementById("dayinputtext2").value=month1();
	}
	function threemonth(){
		document.getElementById("dayinputtext1").value=todate();
		document.getElementById("dayinputtext2").value=month3();
	}
	
	function todate(){
		var date = new Date();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return date.getFullYear()+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
	}
	function week1(){
		var date = new Date();
		var m = date.getMonth()+1;
		var d = date.getDate()+7;
		if(m>12){
			m=m-12;
			return (date.getFullYear()+1)+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
		} else {
			return date.getFullYear()+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
		}
	}
	function month1(){
		var date = new Date();
		var m = date.getMonth()+2;
		var d = date.getDate();
		if(m>12){
			m=m-12;
			return (date.getFullYear()+1)+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
		} else {
			return date.getFullYear()+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
		}
	}
	function month3(){
		var date = new Date();
		var m = date.getMonth()+4;
		var d = date.getDate();
		if(m>12){
			m=m-12;
			return (date.getFullYear()+1)+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
		} else {
			return date.getFullYear()+'-'+(m>9?m:'0'+m)+'-'+(d>9?d:'0'+d);
		}
	}
	</script>
</body>

</html>
