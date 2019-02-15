<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/common/admin_public.jsp"%>

<%
String thetime = request.getParameter("thetime");
String timelate = request.getParameter("timelate");

/*  int thetime1 = Integer.parseInt(thetime); 

int timelate1 = Integer.parseInt(timelate);  */

System.out.println(thetime+"====="+timelate);

%>

<!-- /#page-wrapper -->

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12 col-mg-6 col-sg-4">
			<br>

			<table align="left">
				<tr>
					<td>
						<!-- userInfo -->


						<div class="container-fluid well span6"
							style="position: relative; float: left; width: 450px; margin-top:7%; margin-left:2%;">


							<table class="col-lg-12 col-mg-6 col-sg-4">
								<tr>
									<td>
										<div class="span2">
											<img
												src="<%=root%>\img\member\admin.jpg"
												class="img-circle" style="height:125px; !import">
										</div>
									</td>
									<td width="50px"></td>
									<td align="left">
										<table>
											<tr>

												<div class="span8">
													<h3>관 리 자</h3>
													<h6>Email: cdbsgmlc@naver.com</h6>
													<!-- <h6>Ubication: Colombia</h6> -->
													<!-- <h6>Old: 1 Year</h6> -->
													
												</div>
											</tr>
											
											<tr>
											
											</tr>
										</table>
									</td>
									
								</tr>
							</table>
							
						
						
						</div>
		
						
							</div> 
					</td>
					
				</tr>
				<tr>
					<td>
						<!-- userInfo end --> <!--차트시작-->
						<div align="left" class="col-lg-12 col-mg-6 col-sg-4"
							style="position: relative; float:left; width:105%; margin-top:15%;">
							<div class="panel panel-default">
								<div class="panel-heading"><b>근태 통계</b></div>
								<!-- /.panel-heading -->


								<div id="chart_div1"
									style="position: relative; width: 400px; height: 400px;"></div>


								<!-- <div id="chart_div2"
									style="position: relative; width: 400px; height: 400px;"></div> -->

							</div>
						</div> <!--차트끝-->
					
					</td>
					<td>
					
					
					</td>			
				</tr>
			</table>


<table><tr><td style="width:1400px; !import">


	
							<!-- /.col-lg-6 -->
				<div style="overflow:auto; height:500px;padding:2%;">
			<div class="col-lg-12 col-mg-6 col-sg-4"
				style="position: relative; float: rigt; width:100%;">
				
				
			
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                          <i class="fa fa-bullhorn"></i><b>  Help Desk</b>
                        </div>
                        <div class="panel-body">
                          <div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th>일련번호</th>
										<th>글내용</th>
										<th>작성자</th>
										<th>날짜</th>
									</tr>
								</thead>
								<a href="<%=root%>/adminhome?act=helpdesk_list">
								<tbody id="nolist">
									
								</tbody>
								</a>
							</table>
						</div>
						
                        </div>
                       
                    </div>
             
				
				

				<!-- /.col-lg-6 -->
			</div>
			</div>
			
			<div style="overflow:auto; height:500px; padding:2%;">
			<div class="col-lg-12 col-mg-6 col-sg-4"
				style="position: relative; float: rigt; width: 100%;">

				<div class="panel panel-default">
					<div class="panel-heading"><b>한 눈에 문서</b></div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr><td style="width: 30%">
										<div class="input-group custom-search-form">
											<input type="text" class="form-control"
												placeholder="Search..." style="height: 33px"> <span
												class="input-group-btn">
												<button class="btn btn-default" type="button">
													<i class="fa fa-search"></i>
												</button>
											</span>
										</div>
</td><td style="width:25%">
										<select name="dataTables-example_length"
											aria-controls="dataTables-example"
											class="form-control input-sm">
											<option value="10">감찰부</option>
											<option value="25">회계부</option>
											<option value="50">마케팅부</option>
											<option value="100">전산부</option></select>
											</td>
									</tr>
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
			</div>
			<!-- /.panel -->

			<!-- /.col-lg-6 -->


</td></tr></table>



		</div>


	</div>


</div>
</div>




<!-- jQuery -->


<script src="<%=root%>/css/vendor/jquery/jquery.min.js"></script>


<script type="text/javascript" src="<%=root %>/css/jquery.jqplot.1.0.9.d96a669/jquery.jqplot.js"></script>
<script type="text/javascript" src="<%=root %>/css/jquery.jqplot.1.0.9.d96a669/plugins/jqplot.pieRenderer.js"></script>


<link rel="stylesheet" type="text/css" href="<%=root %>/css/jquery.jqplot.1.0.9.d96a669/jquery.jqplot.css" />

<script>

$(document).ready(function(){ 

	$.ajax({
		type : "POST",
		dataType : 'json',// 데이타 타입을 text으로 받겠다.
		url : "<%=root%>/adminhome",
		data : {
			act : "chart"
	
		},
		success : function(data) {// 알아서 맞춰준다.
			
			//employeeList(data);
			
			var len =data.employeelist.length;
			for(var i=0; i<len; i++){
			var thetime = data.employeelist[i].thetime;
			var timelate = data.employeelist[i].timelate;
			}
			
			
		    s1 = [['정상출근', thetime], ['지각비율', timelate]];
		         
		     $.jqplot('chart_div1', [s1], {
		        grid: {
		            drawBorder: false, 
		            drawGridlines: false,
		            background: '#ffffff',
		            shadow:false
		        },
		        axesDefaults: {
		             
		        },
		        seriesDefaults:{
		            renderer:$.jqplot.PieRenderer,
		            rendererOptions: {
		                showDataLabels: true
		            }
		        },
		        legend: {
		            show: true,
		            rendererOptions: {
		                numberRows: 1
		            },
		            location: 's'
		        }
		    }); 
		     


		},
		error : function(e) {
			alert("에러!");
		}
	});




	
});



function employeeList(data) {
	var len = data.employeelist.length;
	for(var i=0; i<len; i++){
		var thetime = data.employeelist[i].thetime;
		var timelate = data.employeelist[i].timelate;
	}
		}


</script>

<script>
var bapprovallist;

$(document).ready(function() {
	$.ajax({
		type : "POST",
		dataType : 'json',// 데이타 타입을 json으로 받겠다.
		url : "<%=root%>/adminhome",
		data : {
			act : "admin_homelist"
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



<script type="text/javascript" src="<%=root%>/js/admin/adminhome.js" charset="utf-8"></script>



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