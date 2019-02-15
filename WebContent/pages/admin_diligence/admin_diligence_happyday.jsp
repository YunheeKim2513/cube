<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.cube.model.dto.HappyDayDto, java.util.List"%>
<%@ include file="/common/admin_public.jsp"%>
<% 
	 List<HappyDayDto> happyDayDtolist= (List<HappyDayDto>) request.getAttribute("happydaydto");
//System.out.println(happyDayDtolist);
%>
<!-- /#page-wrapper -->
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">휴일 자동설정</h1>
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
					<table width="100%" id="happyt"
						class="table table-striped table-bordered table-hover"
						cid="dataTables-example">

						<tr>

							<td width="60%" align="left"><b>휴일이름 설정</b></td>
							<th width="40%" colspan="4">일시</th>
						</tr>
						<tr>
							<td align="center">
							<input type="text" class="form-controltext" name="happyname" style="width: 98%; height: 35px; !implort" id="happytext"></td>

							<td colspan="4">
							
							<span class="col-lg-5" style="margin-right:60px; margin-left:20px;">
									<form class="demo-3">
										<input type='text' class="form-control" id="scal1">
									</form>
							</span> 
							<span class="col-lg-5">
									<form class="demo-3">
										<input type='text' class="form-control" id="scal2">
									</form>
							</span>
							</td>
							<!-- 	<td valign="middle" align="center"><input type="button"
								class="btn btn-primary" value="삭제" onclick=""></td> -->
						</tr>
						<tr style="background:white;">
						
							<td colspan="5" style="height:60px; !import"><label></label><center>
							<input type="button" class="btn btn-primary" value="추가" id="addbtn" style="width:40%; !import"></center><br>
							</td>
						</tr>
						<tr>
							<td colspan="5" style="background:#f8f8f8;"><b>등록된 휴일목록</b></td>

						</tr>

						<tr>
							<th>휴일이름</th>
							<th style="width: 5%; !import" >일련번호</th>
							<th style="width: 33%; !import">일시</th>
							<!-- <th>삭제</th> -->

						</tr>
						<tbody id="happyDayDtolist">
					<%-- <% 
          		  
                 // for(HappyDayDto happyDayDto : happyDayDtolist){
                	  
                	  int size = happyDayDtolist.size(); 
                      for(int i=0; i<size; i++){
                    	  HappyDayDto happyDayDto = happyDayDtolist.get(i); 
                	  
                 %>	
					<tr>
					<td><%=happyDayDto.getHappy_name()%></td>
					<td colspan="3"><%=happyDayDto.getHappy_stat()%>-<%=happyDayDto.getHappy_end()%></td>
					<td valign="middle" align="center"><input type="button" class="btn btn-primary" value="삭제" id="deletehappy"></td>
					</tr>
					<%} %> --%>
						</tbody>
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
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript">
    function viewarticle(seq,dockind){
    	document.location.href="<%=root%>/userreportdoc?act=returnviewarticle&seq="+seq+"&dockind="+encodeURI(dockind)+"&docview=userreturndoc";
    }
    </script>
 <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
	<script src="<%=root %>/calendar/jquery.minical.js"></script> 
	<script>
	$("form.demo-1 :text").minical();
	$("form.demo-2 :text").minical({
	        inline: true
	      });
		  $("form.demo-3 :text").minical({
	        trigger: "i.trigger-icon"
	      });
	</script>

	<script src="<%=root%>/js/admin/happday.js" charset="utf-8"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=root %>/css/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=root %>/css/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="<%=root %>/css/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%=root %>/css/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<%=root %>/css/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=root %>/css/dist/js/sb-admin-2.js"></script>
	
	<!-- dockind -->
    <script type="text/javascript">
    function dockind(docname){
    	$.ajax({
    		type:"POST",
    		dataType:'json',
    		url:"<%=root%>/usersenddoc",
    		data: {act:"approval_userreport"},
    		success:function(data){
    			doclist(data);
    		},
    		error:function(e){
    			alert("에러");
    		}
    	});
    }
    
    function doclist(data){
    	var len = "";
    	var output="";
    	output += "<tr class="odd gradeX">";
    	output += "<td></td>";
    	output += "<td></td>";
    	output += "<td></td>";
    	output += "<td class="center"></td>";
    	output += "<td class="center"></td>";
    	output += "<td class="center"></td>";
    	output += "<td class="center"></td>";
    	output += "</tr>";
    		
    }
    
    
    </script>
</body>
</html>
