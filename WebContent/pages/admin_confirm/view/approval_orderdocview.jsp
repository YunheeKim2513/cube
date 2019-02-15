<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.cube.model.dto.*"%>
<%@ include file="/common/admin_public.jsp" %>
<% OrderdocDto orderdocDto = (OrderdocDto) request.getAttribute("orderdocwrite"); %>
        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
				<div class="col-lg-12">
                    	<h1 class="page-header"><%=orderdocDto.getDoc_name() %></h1>
                    	 <div style="text-align:right; vertical-align:middle">
                    		<button type="button" id="listbtn" name="listbtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:previouspage('<%=request.getParameter("docview")%>');">목록</button>
	                    <!--    <button type="button" id="updatebtn" name="updatebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvalupdates('<%--=orderdocDto.getDoc_seq()--%>','<%--=orderdocDto.getDoc_name()--%>');">수정</button>
	                        <button type="button" id="deletebtn" name="deletebtn" class="btn btn-primary" style="margin-bottom:7px" onclick="javascript:approvaldelete('<%--=orderdocDto.getDoc_seq()--%>','vacdoc');">삭제</button> -->
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
					                <td><%=orderdocDto.getDoc_seq() %></td>
					                <th rowspan="5" style="text-align:center; vertical-align:middle">결<br><br><br><br>재</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">기안자</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					                <th rowspan="2" style="text-align:center; vertical-align:middle">결재선</th>
					              </tr>
					              <tr>
					                <th>문서종류</th>
					                <td>
					                  <label><%=orderdocDto.getDoc_name() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>문서상태</th>
					                <td>
					                  <label><span id="docstate" name="docstate" ><%=orderdocDto.getDoc_state() %></span></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                  <label><%=orderdocDto.getDoc_writer() %></label>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok1" name="approvalok1" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=orderdocDto.getConfirmlistname1() %></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok2" name="approvalok2" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=orderdocDto.getConfirmlistname2() %></span>
					                </td>
					                <td rowspan="3" style="text-align:center; vertical-align:middle">
					                <div id="approvalok3" name="approvalok3" style="border:0.3em double #FF0000; padding:0pt; width:60px; height:30px; font-size:11px; overflow:hidden; margin:auto; font-weight:bold; color:#ff0000; line-height:20px; margin-bottom:3px; text-align:center; display:none"></div>
					                  <span><%=orderdocDto.getConfirmlistname3() %></span>
					                </td>
					              </tr>
					              <tr>
					                <th>부서</th>
					                <td><label><%=employeesDto.getDepartment_name() %></label></td>
					              </tr>
					              <tr>
					                <th>기안자</th>
					                <td><label><%=orderdocDto.getDoc_writer() %><label></td>
					              </tr>
					              <tr>
					                <th>기안일</th>
					                <td colspan="6">
                           		 	   <label><%=orderdocDto.getDoc_date() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>수신부서</th>
					                <td colspan="6">
					                  <label><%=orderdocDto.getDoc_receiver() %></label>
					                </td>
					              </tr>
					              <tr>
					                <th>참조부서</th>
					                <td colspan="6">
					                  <label><%=orderdocDto.getDoc_reference() %></label>
					                </td>
					              </tr>
					              <!-- <tr>
					                <th>파일첨부</th>
					                <td colspan="6">
					                  <input class="form-controltext" readonly="">&nbsp;&nbsp;&nbsp;&nbsp;
					                  <button type="button" class="btn btn-primary">첨부하기</button>
					                </td>
					              </tr> -->
					              <tr>
					                <th>제목</th>
					                <td colspan="6">
					                  <label><%=orderdocDto.getDoc_subject() %></label>
					                </td>
					              </tr>
					              <tr>
					              	<th>내용</th>
					                <td colspan="6">
					                	<p><%=orderdocDto.getOrderdoc_content() %></p>
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
			if(<%=orderdocDto.getConfirmlist_ok()%>==1){
				if('반려'=='<%=orderdocDto.getDoc_state()%>'){
					$("#approvalok1").append('반려');
					$("#approvalok1").show();						
				} else{
				var data = "<%=orderdocDto.getConfirmlistname1()%>";
				var output =data.split(')');
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				}
			} else if(<%=orderdocDto.getConfirmlist_ok()%>==2){
				var data = "<%=orderdocDto.getConfirmlistname1()%>";
				var output =data.split(')');
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				if('반려'=='<%=orderdocDto.getDoc_state()%>'){
					$("#approvalok2").append('반려');
					$("#approvalok2").show();						
				} else{
				data = "<%=orderdocDto.getConfirmlistname2()%>";
				output =data.split(')');
				$("#approvalok2").append(output[1]);
				$("#approvalok2").show();
				}
			} else if(<%=orderdocDto.getConfirmlist_ok()%>==3){
				var data = "<%=orderdocDto.getConfirmlistname1()%>";
				var output =data.split(')');
				$("#approvalok1").append(output[1]);
				$("#approvalok1").show();
				data = "<%=orderdocDto.getConfirmlistname2()%>";
				output =data.split(')');
				$("#approvalok2").append(output[1]);
				$("#approvalok2").show();
				if('반려'=='<%=orderdocDto.getDoc_state()%>'){
					$("#approvalok3").append('반려');
					$("#approvalok3").show();						
				} else{
				data = "<%=orderdocDto.getConfirmlistname3()%>";
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
