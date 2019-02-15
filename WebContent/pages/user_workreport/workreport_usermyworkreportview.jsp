<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.cube.model.dto.Work_reportDto"%>
<%@ include file="/common/user_public.jsp" %>
<%	
	Work_reportDto work_reportDto = (Work_reportDto) request.getAttribute("work_reportDto");
%>
        <!-- /#page-wrapper -->
        <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header"><div id="workdockind"></div></h1>
                    	<div style="text-align:right; vertical-align:middle">
                    	<button type="button" id="listbtn" name="listbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:previouspage('<%=request.getParameter("docview")%>');">목록</button>
                    	<%
                    	if("temp".equals(request.getParameter("menu"))){
						%>
	                        <button type="button" id="updatebtn" name="updatebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalupdate('<%=work_reportDto.getDoc_seq()%>','<%=work_reportDto.getDoc_name()%>');">수정</button>
	                        <button type="button" id="deletebtn" name="deletebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvaldelete('<%=work_reportDto.getDoc_seq()%>','workdoc');">삭제</button>
	                    <%
                        } else {
	                   	%>		
	                   		<button type="button" id="pdfbtn" name="pdfbtn" class="btn btn-primary" style="margin-bottom:7px">pdf 다운로드</button>
                    	<%		
                    	}
	                    %>
                        </div>
                    	<br>
                </div>
            </div>
                <!-- /.col-lg-12 -->
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                 <tr>
			              			<th>문서종류</th>
			              			<td><div id="dockind" style="font-weight: bold;"></div></td>
				              	  </tr>
				              	  <tr>
				              	    <th>업무 보고일</th>
				              	  	 <td><label><%=work_reportDto.getDoc_date() %></label></td>
				              	  </tr>
				              	  <tr>
				              	    <th>최초 생성 일시</th>
				              	  	 <td><label><%=work_reportDto.getDoc_writetime() %></label></td>
				              	  </tr>
				              	  <tr>
				              	    <th>마지막 수정 일시</th>
				              	  	 <td><label><%=work_reportDto.getWorkdoc_finaltime() %></label></td>
				              	  </tr>
				              	  <tr>
			              			<th>보고자</th>
			              			<td><label><%=work_reportDto.getDoc_writer() %></label></td>
				              	  </tr>
				              	  <tr>
				              	    <th>보고받는 자</th>
				              	  	<td><label><%=work_reportDto.getConfirmlist() %></label></td>
				              	  </tr>
				              	  <tr>
			              			<th>공개여부</th>
			              			<td><div id="viewkind" style="font-weight: bold;"></div></td>
			              		  </tr>
				              		<tr>
				              			<th>제목</th>
				              			<td><label><%=work_reportDto.getDoc_subject() %></label></td>
				              		</tr>
				              		<tr>
				              			<th><div id="daywork"></div></th>
				              			<td><p><%=work_reportDto.getWorkdoc_daycontent() %></p></td>
				              		</tr>
				              		<tr>
				              			<th><div id="nextwork"></div></th>
				              			<td><p><%=work_reportDto.getWorkdoc_nextcontent() %></p></td>
				              		</tr>
				              		<tr>
					                <th>파일첨부</th>
					                <td colspan="6" >
					                  <div class="form-group" style="margin:auto">
                                            <input type="file" id="workfilename" name="workfilename" value="">
                                      </div>
					                </td>
					              </tr>
					           </thead>
                            </table>
                            <table style="width:100%">
                            <thead>
                             <tr>
								<td style="width:10%; text-align: center; font-weight: bold;">[<%=employeesDto.getDepartment_name() %>]<br><%=employeesDto.getGarde_name() %> <br> <%=employeesDto.getName() %></td>
								<td width="80%" height="80" >
								<textarea class="form-control" rows="3" id="workmemocontent" name="workmemocontent"></textarea>
								</td>
								<td align="center" colspan="2">
								<span><button type="button" class="btn btn-primary btn-lg" id="mwrite" style="width:100px; height:45px; padding-top: 7px;">등록</button></span>
								</td>
							  </tr>
							  </thead>
							</table>
							<table>
								<tbody id="memolist"></tbody>
							</table>
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
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>
    
    <script type="text/javascript" src="<%=root%>/js/approval/approval.js"></script>

	<!-- Calendar -->
	<script src="<%=root %>/calendar/jquery.minical.js"></script>
	<script>
	$("form.demo-1 :text").minical();
	$("form.demo-2 :text").minical({inline: true});
	$("form.demo-3 :text").minical({trigger: "i.trigger-icon"});
	</script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
    	if("일일 업무 보고"=="<%=work_reportDto.getWorkdoc_kind()%>"){
    		$("#workdockind").html("일일 업무 보고 문서 조회");
    		$("#dockind").html("일일 업무 보고");
			$("#daywork").html("오늘 한일");
			$("#nextwork").html("내일 계획");
    	} else if("주간 업무 보고"=="<%=work_reportDto.getWorkdoc_kind()%>"){
    		$("#workdockind").html("주간 업무 보고 문서 조회");
    		$("#dockind").html("주간 업무 보고");
			$("#daywork").html("이번주 한일");
			$("#nextwork").html("다음주 계획");
    	} else if("월간 업무 보고"=="<%=work_reportDto.getWorkdoc_kind()%>"){
    		$("#workdockind").html("월간 업무 보고 문서 조회");
    		$("#dockind").html("월간 업무 보고");
			$("#daywork").html("이번달 한일");
			$("#nextwork").html("다음달 계획");
    	} 
    	
    	if("전체공개"=="<%=work_reportDto.getWorkdoc_open()%>"){
    		$("#viewkind").html("회사 전체 공개");
    	} else if("비공개"=="<%=work_reportDto.getWorkdoc_open()%>"){
    		$("#viewkind").html("비공개");
    	} else {
    		$("#viewkind").html("부서 공개");
    	}
    	
    	getMemoList();
    	$("#mwrite").click(function(){
    		console.log("등록버튼");
    		writeMemo();
    	});
    	
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    
    function writeMemo(){
    	$.ajax({
    		type: "POST",
    		dataType: 'json',
    		url : "<%=root%>/usermyworkreportreply",
    		data: {act:"write", seq: "<%=work_reportDto.getDoc_seq()%>", mcontent: $("#workmemocontent").val()},
    		success:function(data){
    			$("#workmemocontent").text("");
    			memoList(data);
    		},
    		error: function(e){
    			alert("에러");
    		}
    	});
    }
    
    function getMemoList(){
    	$.ajax({
    		type: "POST",
    		dataType: 'json',
    		url: "<%=root%>/usermyworkreportreply",
    		data: {act: "list", seq: "<%=work_reportDto.getDoc_seq()%>" },
    		success:function(data) {
    			memoList(data);
    		},
    		error:function(e){
    			alert("에러");
    		}
    	});
    }
    
    function memoList(data){
    	var len = data.memolist.length;
    	
    	var output="";
    	for(var i=0; i<len; i++ ){
    		var mseq = data.memolist[i].mseq;
    		var seq = data.memolist[i].seq;
    		var mname = data.memolist[i].mname;
    		var mcontent = data.memolist[i].mcontent;
    		var mlogtime = data.memolist[i].mlogtime;
    		var mid = data.memolist[i].mid;
    		output += "<tr>";
    		output += "	<td width=\"10%\" height=\"50px\"><b>" + mname + "</b></td>";
    		output += "	<td width=\"2%\">";
    		output += "	<td width=\"60%\"><div>" + mcontent + "</div></td>";
    		output += "	<td width=\"13%\">" + mlogtime + "</td>";
    		output += "	<td width=\"5%\">";
    		if(mid == "<%=employeesDto.getEmployee_id()%>") {
    			output += "<a href=\"javascript:mvModifyMemo('" + mseq + "');\">수정</a>";
    			output += "|";
    			output += "<a href=\"javascript:deleteMemo('" + mseq + "');\">삭제</a>";
    		}
    		output += "</td>";
    		output += "</tr>";
    		
    		output += "<tr>";
    		output += "	<td colspan=\"5\">";
    		output += "	<div id=\"modiform" + mseq + "\" style=\"display: none;\">";
    		output += "	<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">";
    		output += "	<tr>";
    		output += "		<td width=\"5%\"></td>";
    		output += "		<td width=\"75%\" height=\"80\">";
    		output += "		<input name=\"mcontent\" id=\"mcontent" + mseq + "\" type=\"text\" height=\"60\" size=\"150\" maxlength=\"200\" ";
    		output += "		 style=\"height: 80px; spacing: 10px;\" value=\"" + mcontent + "\">";
    		output += "		</td>";
    		output += "		<td align=\"center\">";
    		output += "<button type=\"button\" id=\"mmodify\" name=\"mmodify\" class=\"btn btn-primary\" style=\"margin-bottom:7px\" onclick=\"javascript:modifyMemo('"+mseq+"');\">등록</button>";
    		output += "<button type=\"button\" id=\"mcancel\" name=\"mcancel\" class=\"btn btn-primary\" style=\"margin-bottom:7px\" onclick=\"javascript:cancelMemo('"+mseq+"');\">취소</button>";
    		output += "		</td>";
    		output += "	</tr>";
    		output += "	</table>";
    		output += "	</div>";
    		output += "	</td>";
    		output += "</tr>";
    		
    		output += "<tr>";
    		output += "	<td class=\"bg_board_title_02\" height=\"1\" colspan=\"5\"";
    		output += "		style=\"overflow: hidden; padding: 0px\"></td>";
    		output += "</tr>";
    		
    		$("#memolist").empty();
    		$("#memolist").append(output);
    	}
    }
    
    function mvModifyMemo(mseq){
    	$("#modiform"+mseq).css("display","");
    }
    
    function deleteMemo(mseq){
    	if(confirm("작성한 댓글을 지우시겠습니까?")){
    		$.ajax({
    			type: "GET",
    			dataType: 'json',
    			url: "<%=root%>/usermyworkreportreply",
    			data: {act: "delete", seq: "<%=work_reportDto.getDoc_seq()%>", mseq: mseq},
    			success:function(data){
    				memoList(data);
    			},
    			error: function(e){
    				alert("에러");
    			}
    		});
    	}
    }
    
    function cancelMemo(mseq){
    	$("#modiform"+mseq).css("display","none");
    }
    
    function modifyMemo(mseq){
    	if($("#mcontent"+mseq).val()){
    	$.ajax({
    		type: "POST",
    		dataType: 'json',
    		url: "<%=root%>/usermyworkreportreply",
    		data: {act: "modify", seq: "<%=work_reportDto.getDoc_seq()%>", mseq:mseq, mcontent: $("#mcontent"+mseq).val()},
    		success:function(data){
    			memoList(data);
    		},
    		error:function(e){
    			alert("에러");
    		}
    	});
    	} else {
    		alert("댓글 내용을 입력해주세요");
    		return;
    	}
    }
    </script>
    

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

	<script src="<%=root %>/modal/jquery/jquery-ui.custom.js" type="text/javascript"></script>
	<script src="<%=root %>/modal/jquery/jquery.cookie.js" type="text/javascript"></script>
	<link href="<%=root %>/modal/src/skin-vista/ui.dynatree.css" rel="stylesheet" type="text/css">
	<script src="<%=root %>/modal/src/jquery.dynatree.js" type="text/javascript"></script>
	<script type="text/javascript">
	 $(function(){
	   // Initialize the tree inside the <div>element.
	   // The tree structure is read from the contained <ul> tag.
	   $("#tree").dynatree({
	     onActivate: function(node) {
	  		var parameter="act=confirmbtn&confirmname="+encodeURI(node.data.title);
	  		sendRequest("<%=root%>/userdocwrite",parameter,receiveParams, "GET");
	  		function receiveParams() {
	  			if(httpRequest.readyState==4){
	  				if(httpRequest.status==200){
	   					document.getElementById("eids").value = node.data.key;
	   					document.getElementById("employees").value = node.data.title;
	  					} 
	  				}
	  			}
	     if( node.data.url )
	       window.open(node.data.url, node.data.target);
	     },
	     onDeactivate: function(node) {
	       $("#echoSelected").text("-");
	     },
	     onFocus: function(node) {
	       $("#echoFocused").text(node.data.title);
	     },
	     onBlur: function(node) {
	       $("#echoFocused").text("-");
	     },
	     onLazyRead: function(node){
	       var fakeJsonResult = [
	         { title: 'Lazy node 1', isLazy: true },
	         { title: 'Simple node 2', select: true }
	       ];
	     }
	   });
	   $("#btnExpandAll").click(function(){
	       $("#tree").dynatree("getRoot").visit(function(node){
	         node.expand(true);
	       });
	       return false;
	     });
	     $("#btnCollapseAll").click(function(){
	       $("#tree").dynatree("getRoot").visit(function(node){
	         node.expand(false);
	       });
	       return false;
	     });
	 });  
	 
	 $("input:radio[name=workreportkind]").click(function(){
		var workreportkind=$("input:radio[name=workreportkind]:checked").val();
		if($("#dayreport").val()==workreportkind){
			$("#worksubject").val("");
			$("#daywork").html("오늘 한일");
			$("#nextwork").html("내일 계획");
		} else if($("#weekreport").val()==workreportkind){
			var weekstartsubject=$.datepicker.formatDate('yy-mm-dd', new Date());
			var date = new Date(); 
			date.setDate(date.getDate() + 6);
			var weekendsubject=$.datepicker.formatDate('yy-mm-dd', date);
			$("#worksubject").val("["+weekstartsubject+"]"+"~"+"["+weekendsubject+"] 주간 업무 보고");
			$("#daywork").html("이번주 한일");
			$("#nextwork").html("다음주 계획");
		} else if($("#monthreport").val()==workreportkind){
			var monthsubject=$.datepicker.formatDate('yy-mm', new Date());
			$("#worksubject").val("["+monthsubject+"] 월간 업무 보고");
			$("#daywork").html("이번달 한일");
			$("#nextwork").html("다음달 계획");
		}	 
	 });
	 
	 $("#worksubmit").click(function(){
		if(!$("#eids").val()){
			alert("보고 받는 자를 선택해 주시기랍니다.");
		} else if(!$("#worksubject").val()){
			alert("제목을 작성해주시기바랍니다.");
		} else if(!$("#daycontent").val()){
			alert("오늘 한 일을 작성해주시기바랍니다.");
		} else if(!$("#nextcontent").val()){
			alert("내일 한 일을 작성해주시기바랍니다.");
		} else {
			if(confirm("업뭅보고를 올리시겠습니까?")==true){
				$("#daytext").val(document.getElementById("dayinputtext").value);
				document.userworkForm.action="<%=root%>/usermyworkreport";
				$("#userworkForm").submit();
			} else
				return;
		}
	 });
	 </script>
</body>
</html>