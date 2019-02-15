<%@page import="com.cube.model.dto.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.Confirmlist_infoDto, com.cube.model.dto.EmployeesDto"%>
<%@ include file="/common/user_public.jsp" %>
<%
	NoticeDto noticeDto = (NoticeDto) request.getAttribute("noticeDto");
%>
        <!-- /#page-wrapper -->
        <form name ="helpForm" id="helpForm" method="post" action="">
               <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header">HELP</h1>
                    		<div style="text-align: right;">
	                        	<button type="button" id="registorok" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:previouspage('noticeview');">목록</button>
	                        	<%if(employeesDto.getEmployee_id().equals(noticeDto.getEmployee_id()) && !("처리완료".equals(noticeDto.getNotice_state()))){ %>
	                        	<button type="button" id="update" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:mvupdatepage('<%=noticeDto.getNotice_seq()%>');">수정</button>
	                        	<%} %>
	                        	<%if("admin".equals(employeesDto.getEmployee_id()) && !("처리완료".equals(noticeDto.getNotice_state()))){ %>
	                        	<button type="button" id="complite" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:compliteok('<%=noticeDto.getNotice_seq()%>');">처리완료</button>
	                        	<%} %>
	                        </div>
                        </div>
                </div>
                <!-- /.col-lg-12 -->
          
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" style="border-color:#888; border-width:1.5px; border-radius: 50%;">
                                <thead>
					              <tr>
					              <th style="border-color:#888; border-width:1.5px; background-color:#eee; width:7%;" rowspan="2"><img src="<%=root%>/img/logo/cubelogo.png" width="35px" height="8.5%"></th>
					                <th style="background-color:#d6e9c6; border-color:#888; border-width:1.5px; color:#3c763d;">글번호</th>
					                <th style="background-color:#d6e9c6; border-color:#888; border-width:1.5px; color:#3c763d;">문서상태</th>
					                <th style="background-color:#d6e9c6; border-color:#888; border-width:1.5px; color:#3c763d;">부서</th>
					                <th style="background-color:#d6e9c6; border-color:#888; border-width:1.5px; color:#3c763d;">작성자</th>
					                <th style="background-color:#d6e9c6; border-color:#888; border-width:1.5px; color:#3c763d;">작성일</th>
					                <th style="background-color:#d6e9c6; border-color:#888; border-width:1.5px; color:#3c763d;">처리 완료일</th>
					                </tr>
					                <tr>
					                
					                <td style="border-color:#888; border-width:1.5px;"><center><%=noticeDto.getNotice_seq() %></center></td>
					             
					                <td style="border-color:#888; border-width:1.5px;">
					                  <center><%=noticeDto.getNotice_state() %></center>
					                </td>
					              
					                <td style="border-color:#888; border-width:1.5px;"><center><%=noticeDto.getEmployee_dep() %></center></td>
					             
					                <td style="border-color:#888; border-width:1.5px;"><center><%=noticeDto.getNotic_writer() %></center></td>
					              
					                <td style="border-color:#888; border-width:1.5px;"><center><%=noticeDto.getNotice_date() %></center></td>
					              
					                <td style="border-color:#888; border-width:1.5px;"><center><%=noticeDto.getNotice_complite() %></center></td>
					              </tr>
					              <tr>
					                <th style="background-color:#d6e9c6; border-color:#888; border-width:1.5px; color:#3c763d;">제목</th>
					                <td colspan="6" style="border-color:#888; border-width:1.5px;"><%=noticeDto.getNotice_subject()%></td>
					              </tr>
					              <tr>
					                <th style="background-color:#d6e9c6; border-color:#888; border-width:1.5px; color:#3c763d;">내용</th>
					                	<td colspan="6"  style="border-color:#888; border-width:1.5px;"><%=noticeDto.getNotice_content()%></td>
					              </tr>
					            </thead>
                            </table>
                            <table style="width:100%" >
                            <thead>
                             <tr>
								<td style="width:10%; text-align: center; font-weight: bold;">[&nbsp&nbsp&nbsp<%=employeesDto.getDepartment_name() %>&nbsp&nbsp&nbsp]<br>(<%=employeesDto.getGarde_name() %>) <%=employeesDto.getName() %></td>
								<td width="80%" height="80" >
								<textarea class="form-control" rows="3" id="workmemocontent" name="workmemocontent"></textarea>
								</td>
								<td align="center" colspan="2">
								<span><button type="button" class="btn btn-primary btn-lg" id="mwrite" style="width:100px; height:75px; padding-top: 7px;">등록</button></span>
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
    </form>
    
     <!--/#wrapper -->

       <!-- jQuery -->
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>

	<script type="text/javascript" src="<%=root%>/js/approval/approval.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=root %>/css/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=root %>/css/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=root %>/css/dist/js/sb-admin-2.js"></script>

	
	
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    getMemoList();
	$("#mwrite").click(function(){
		writeMemo();
	});
    
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    
    function writeMemo(){
    	$.ajax({
    		type: "POST",
    		dataType: 'json',
    		url : "<%=root%>/helpdeskreply",
    		data: {act:"write", seq: "<%=noticeDto.getNotice_seq()%>", mcontent: $("#workmemocontent").val()},
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
    		url: "<%=root%>/helpdeskreply",
    		data: {act: "list", seq: "<%=noticeDto.getNotice_seq()%>" },
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
    		
    		
    	}
    	$("#workmemocontent").val("");
    	$("#memolist").empty();
		$("#memolist").append(output);
    }
    
    function mvModifyMemo(mseq){
    	$("#modiform"+mseq).css("display","");
    }
    
    function deleteMemo(mseq){
    	if(confirm("작성한 댓글을 지우시겠습니까?")){
    		$.ajax({
    			type: "GET",
    			dataType: 'json',
    			url: "<%=root%>/helpdeskreply",
    			data: {act: "delete", seq: "<%=noticeDto.getNotice_seq()%>", mseq: mseq},
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
    		url: "<%=root%>/helpdeskreply",
    		data: {act: "modify", seq: "<%=noticeDto.getNotice_seq()%>", mseq:mseq, mcontent: $("#mcontent"+mseq).val()},
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
    
    function mvupdatepage(seq){
    	document.location.href="<%=root%>/adminhome?act=mvupdate&seq="+seq;
    }
    
    function compliteok(seq){
    	document.location.href="<%=root%>/adminhome?act=complite&seq="+seq;
    }
    </script>
    
</body>
</html>
