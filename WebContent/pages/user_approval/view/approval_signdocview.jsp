<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.cube.model.dto.*"%>
<%@ include file="/common/user_public.jsp" %>
<% SigndocDto signdocDto = (SigndocDto) request.getAttribute("signdocwrite"); %>
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header"><%=signdocDto.getDoc_name() %></h1>
                    	<div style="text-align:right; vertical-align:middle">
                    	<button type="button" id="listbtn" name="listbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:previouspage('<%=request.getParameter("docview")%>');">목록</button>
                    	<%
                    	if("approval".equals(request.getParameter("menu"))){
                    	%>
							<button type="button" id="confbtn" name="confbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalok(<%=signdocDto.getConfirmlist_ok()%>,'<%=signdocDto.getDoc_seq()%>', '<%=employeesDto.getEmployee_id()%>', '<%=signdocDto.getDoc_name() %>')">결재</button>
							<!-- <button type="button" id="deferbtn" name="deferbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalok(<%--=signdocDto.getConfirmlist_ok()%>,'<%=signdocDto.getDoc_seq()%>', '<%=employeesDto.getEmployee_id()%>', '<%=signdocDto.getDoc_name() --%>')">보류</button> -->
							<button type="button" id="returnbtn" name="returnbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalcancel(<%=signdocDto.getConfirmlist_ok()%>,'<%=signdocDto.getDoc_seq()%>', '<%=employeesDto.getEmployee_id()%>')">반려</button>
						<% 
                    	} else if("temp".equals(request.getParameter("menu"))){
						%>
							<button type="button" id="reportbtn" name="reportbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalreport('<%=signdocDto.getDoc_seq()%>');">상신하기</button>
	                        <button type="button" id="updatebtn" name="updatebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalupdate('<%=signdocDto.getDoc_seq()%>','<%=signdocDto.getDoc_name()%>');">수정</button>
	                        <button type="button" id="deletebtn" name="deletebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvaldelete('<%=signdocDto.getDoc_seq()%>','signdoc');">삭제</button>
	                    <%
	                   	} else if("report".equals(request.getParameter("menu"))){
	       				%>
	   	                    <button type="button" id="returnbtn" name="deletebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalsave('<%=signdocDto.getDoc_seq()%>');">회수</button>
	   	                <%
	                    } else if("return".equals(request.getParameter("menu"))){
        				%>
    	                	<button type="button" id="newdocbtn" name="newdocbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:newpage('<%=signdocDto.getDoc_name()%>');">새로작성</button>
    	                <%
                        } else {
	                   	%>		
	                   		<!--  <button type="button" id="pdfbtn" name="pdfbtn" class="btn btn-primary" style="margin-bottom:7px">pdf 다운로드</button>-->
                    	<%		
                    	}
	                    %>
                        </div>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
					              <tr>
					                <th>문서번호</th>
					                <td><%=signdocDto.getDoc_seq() %></td>
					                <th rowspan="5" style="text-align:center; vertical-align:middle">결<br><br><br><br>재</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">기안자</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					              </tr>
					              <tr>
					                <th>문서종류</th>
					                <td>
					                  <label><%=signdocDto.getDoc_name() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>문서상태</th>
					                <td>
					                  <label><span id="docstate" name="docstate" ><%=signdocDto.getDoc_state() %></span></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                  <label><%=signdocDto.getDoc_writer() %></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok1" name="approvalok1" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=signdocDto.getConfirmlistname1() %></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok2" name="approvalok2" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=signdocDto.getConfirmlistname2() %></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok3" name="approvalok3" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=signdocDto.getConfirmlistname3() %></span>
					                </td>
					              </tr>
					              <tr>
					                <th>부서</th>
					                <td><label><%=employeesDto.getDepartment_name() %></label></td>
					              </tr>
					              <tr>
					                <th>기안자</th>
					                <td><label><%=signdocDto.getDoc_writer() %><label></td>
					              </tr>
					              <tr>
					                <th>기안일</th>
					                <td colspan="6">
                           		 	   <label><%=signdocDto.getDoc_date() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>수신부서</th>
					                <td colspan="6">
					                  <label><%=signdocDto.getDoc_receiver() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>참조부서</th>
					                <td colspan="6">
					                  <label><%=signdocDto.getDoc_reference() %></label>
					                </td>
					              </tr>
					             <!-- <tr>
					                <th>파일다운로드</th>
					                <td colspan="6">
					                <form action="uploadPro.jsp" method="post" enctype="multipart/form-data">
										<input type="text" name="name"><br>
										<input type="file" name="file" value="<%=signdocDto.getDocsave_file()%>"><br>
										<input type="submit" name="업로드"><br>
									</form>
					                </td>
					              </tr> --> 
					              <tr>
					                <th>제목</th>
					                <td colspan="6">
					                  <label><%=signdocDto.getDoc_subject() %></label>
					                </td>
					              </tr>
					              <tr>
					              	<th>내용</th>
					                <td colspan="6">
					                	<p><%=signdocDto.getSigndoc_content() %></p>
					                </td>
					              </tr>
					            </thead>

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
    
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
    
    <script type="text/javascript">
		$(document).ready(function () {
			if(<%=signdocDto.getConfirmlist_ok()%>==1){
				if('반려'=='<%=signdocDto.getDoc_state()%>'){
					$("#approvalok1").append('반려');
					$("#approvalok1").show();						
				} else{
				var data = "<%=signdocDto.getConfirmlistname1()%>";
				var output =data.split(')');
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				}
			} else if(<%=signdocDto.getConfirmlist_ok()%>==2){
				var data = "<%=signdocDto.getConfirmlistname1()%>";
				var output =data.split(')');
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				if('반려'=='<%=signdocDto.getDoc_state()%>'){
					$("#approvalok2").append('반려');
					$("#approvalok2").show();						
				} else{
				data = "<%=signdocDto.getConfirmlistname2()%>";
				output =data.split(')');
				$("#approvalok2").append(output[1]);
				$("#approvalok2").show();
				}
			} else if(<%=signdocDto.getConfirmlist_ok()%>==3){
				var data = "<%=signdocDto.getConfirmlistname1()%>";
				var output =data.split(')');
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				data = "<%=signdocDto.getConfirmlistname2()%>";
				output =data.split(')');
				$("#approvalok2").append(output[1]);
				$("#approvalok2").show();
				if('반려'=='<%=signdocDto.getDoc_state()%>'){
					$("#approvalok3").append('반려');
					$("#approvalok3").show();						
				} else{
				data = "<%=signdocDto.getConfirmlistname3()%>";
				output =data.split(')');
				$("#approvalok3").append(output[1]);
				$("#approvalok3").show();
				}
			}
		});
	</script>
       <!-- jQuery -->
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>

	<script type="text/javascript" src="<%=root%>/js/approval/approval.js"></script>
	
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
    
	<!-- SE2 -->
	
	<script type="text/javascript" src="<%=root %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript">
	
	var oEditors = [];
	
	// 추가 글꼴 목록
	//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];
	
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "ir1",
		sSkinURI: "<%=SE2%>/SmartEditor2Skin.jsp",	
		htParams : {
			bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
			fOnBeforeUnload : function(){
				//alert("완료!");
			}
		}, //boolean
		fOnAppLoad : function(){
			//예제 코드
			//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
		},
		fCreator: "createSEditor2"
		});
		
		function pasteHTML() {
			var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
			oEditors.getById["ir1"].exec("PASTE_HTML", [sHTML]);
		}
		
		function showHTML() {
			var sHTML = oEditors.getById["ir1"].getIR();
			alert(sHTML);
		}
			
		function submitContents(elClickedObj) {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
			// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
			
			try {
				elClickedObj.form.submit();
			} catch(e) {}
		}
		
		function setDefaultFont() {
			var sDefaultFont = '궁서';
			var nFontSize = 24;
			oEditors.getById["ir1"].setDefaultFont(sDefaultFont, nFontSize);
		}
	</script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=root %>/css/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=root %>/css/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Flot Charts JavaScript -->
    <script src="<%=root %>/css/vendor/flot/excanvas.min.js"></script>
    <script src="<%=root %>/css/vendor/flot/jquery.flot.js"></script>
    <script src="<%=root %>/css/vendor/flot/jquery.flot.pie.js"></script>
    <script src="<%=root %>/css/vendor/flot/jquery.flot.resize.js"></script>
    <script src="<%=root %>/css/vendor/flot/jquery.flot.time.js"></script>
    <script src="<%=root %>/css/vendor/flot-tooltip/jquery.flot.tooltip.min.js"></script>
    <script src="<%=root %>/css/data/flot-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=root %>/css/dist/js/sb-admin-2.js"></script>


</body>

</html>
