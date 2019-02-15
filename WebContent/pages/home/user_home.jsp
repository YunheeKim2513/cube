<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR" import="com.cube.model.dto.Doc_info_detailDto, java.net.InetAddress"%>
<%@ include file="/common/user_public.jsp"%>
<%
//System.out.println(employeesDto.getSave_picture()+"====="+employeesDto.getSave_folder());
 
 InetAddress ip = InetAddress.getLocalHost(); 
 
String ipadress=ip.getHostAddress();

System.out.println(ipadress);
%>
<!-- /#page-wrapper -->
<div id="page-wrapper">
   <div class="row">
      <div class="col-lg-12">
      </div>
      <!-- /.col-lg-12 -->
   </div>
   <!-- /.row -->
   <div class="row">
      <div class="col-lg-12">
         <div >
            <div class="panel-body">
               			<table>
				<tr>
					<td>
						<!-- userInfo -->


						<div class="container-fluid well span6"
							style="position: relative; float: left; width: 450px;">


							<table class="col-lg-12 col-mg-6 col-sg-4">
								<tr>
									<td>
										<div class="span2">
											<img
												src="picture/<%=employeesDto.getSave_folder()%>/<%=employeesDto.getSave_picture()%>" 
												style="width: 100px; height: auto;"
												src="http://<%=ipadress%>/<%=root%>/picture/<%=employeesDto.getSave_folder()%>/<%=employeesDto.getSave_picture()%>"
												class="img-circle">
										</div>
									</td>
									<td width="50px"></td>
									<td align="left">
										<table>
											<tr>

												<div class="span8">
													<h3><%=employeesDto.getName()%></h3>
													<h6><%=employeesDto.getGarde_name()%></h6>
													<h6><%=employeesDto.getEmail1()%>@<%=employeesDto.getEmail2()%></h6>
												
													
												</div>
											</tr>
											
											
											
										</table>
									</td>
								</tr>
							</table>
							</div> 


</td><td style="width:5%;"></td><td style="position:relative; align:left; width:70%;">

			<div style="overflow:auto; height:300px;padding:2%;">
			<!-- /.col-lg-6 -->
			<div class="col-lg-12 col-mg-6 col-sg-4">
				<div class="panel panel-default">
					<div class="panel-heading"><b>전체 문서 확인</b></div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th width="20%">일련번호</th>
										<th>문서이름</th>
										<th></th>
										<th>작성일</th>
										<th>작성자</th>
									</tr>
								</thead>
								<tbody id="a">
		
								</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->

	</div>
	</div>
</td></tr><tr><td style="width:100%" colspan="3">
<div id="calendar"></div>
</td></tr></table>
               
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
<input type="button" id="startbutton" name="startbutton" value="" onclick="javascript:starttime();" style="display:none">
</div>
<!-- /#wrapper -->


<!-- jQuery -->
<script src="<%=root%>/css/vendor/jquery/jquery.min.js"></script>


<script>
var bapprovallist;

$(document).ready(function() {
	$.ajax({
		type : "POST",
		dataType : 'json',// 데이타 타입을 json으로 받겠다.
		url : "<%=root%>/userhome",
		data : {
			act : "user_homelist"
		},
		success : function(data) {// 알아서 맞춰준다.
		
			
			//bapprovalList(data);
			
				len = data.bapprovallist.length;// jsonlist
	
	bapprovallist = document.getElementById("a"); // tbody


	for (var i = 0; i < len; i++) {
		
		var doc_seq = data.bapprovallist[i].doc_seq;
		var doc_name = data.bapprovallist[i].doc_name;
		var doc_subject = data.bapprovallist[i].doc_subject;
		var doc_date = data.bapprovallist[i].doc_date;
		var doc_writer = data.bapprovallist[i].doc_writer;

		var row = selectcreateRow(doc_seq, doc_name, doc_subject, doc_date, doc_writer);
	
	
 		bapprovallist.appendChild(row);
 		

	}
			
		},
		error : function(e) {
			alert("에러!");
		}
	});
	
	




	function selectcreateCell(data) {
		
		var cell = document.createElement("td");// <td></td>

		cell.setAttribute("bgcolor", "#ffffff");// <td bgcolor="#99ffff"></td>
		cell.setAttribute("align", "center");

		var txtNode = document.createTextNode(data);// "java2"

		cell.appendChild(txtNode);// <td bgcolor="#99ffff">java2</td>

		return cell;

	}


	function selectcreateRow(doc_seq, doc_name, doc_subject,
			doc_date, doc_writer) {

		var row = document.createElement("tr");

		
		row.appendChild(selectcreateCell(doc_seq));
		row.appendChild(selectcreateCell(doc_name));
		row.appendChild(selectcreateCell(doc_subject));
		row.appendChild(selectcreateCell(doc_date));
		row.appendChild(selectcreateCell(doc_writer));

		// row.appendChild(createBtn(btn));

		return row;
	}

});



</script> 

<!-- Big Calendar -->
<script type="text/javascript" src="<%=root %>/js/bigcalendar.js"></script>	
<link href='<%=root%>/css/calendar/fullcalendar.css' rel='stylesheet' />
<link href='<%=root%>/css/calendar/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='<%=root%>/lib/moment.min.js'></script>
<script src='<%=root%>/lib/jquery.min.js'></script>
<script src='<%=root%>/js//calendar/fullcalendar.min.js'></script>


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