<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="java.util.List, com.cube.model.dto.EmployeesListDto"
	import="com.cube.model.dto.DepartmentsDto, com.cube.model.dto.GradesDto"%>
<%@ include file="/common/admin_public.jsp"%>
<%
	List<DepartmentsDto> dlist = (List<DepartmentsDto>) request.getAttribute("departlist");
	List<GradesDto> glist=(List<GradesDto>)request.getAttribute("gradelist");
	List<String> grlist=(List<String>)request.getAttribute("grouplist");
	EmployeesListDto employeesListDto=(EmployeesListDto)request.getAttribute("empupdate");
%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js" ></script>

<title>SB Admin 2 - Bootstrap Admin Theme</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="<%=root%>/css/admin_companyinfo/skin_css/input.css"
	rel="stylesheet" type="text/css">



<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<form id="uForm" name="uForm" method="post" enctype="multipart/form-data">
		<input type="hidden" id="act" name="act" value="update">
		
		<div id="wrapper">

			<!-- Navigation -->

			<div id="page-wrapper">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">회사 정보 관리</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">사원 정보 수정</div>
							<!-- /.panel-heading -->
							<div>
								<table width="80%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td align="center">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td>
													<table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td><font color="white">.</font></td>
														</tr>
														<tr>
															<td><font color="white">.</font></td>
														</tr>
													</table></td>
												</tr>
											</table>

											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="type2" align="center">

												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>
												<tr>
													<td height="13" align="center"><font color="blue">* 은 필수 입력사항 입니다.</font></td>
													
												</tr>
												
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>
												<tr>
													<td height="13" align="left">사원 번호<font color="blue">*</font></td>
													<td><input name="employee_id" type="text" id="employee_id" size="15"
														class="input" value="<%=employeesListDto.getEmployee_id() %>" readonly="readonly">
													</td>
												</tr>


												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>

												<tr>
													<td height="13" align="left">사원 이름<font color="blue">*</font></td>
													<td><input name="employee_name" type="text" id="employee_name" size="15"
														class="input" value="<%=employeesListDto.getName() %>">
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>

												<tr>
													<td height="25" align="left">비밀 번호<font color="blue">*</font></td>
													<td><input name="pwd" type="password" id="pwd"
														size="15" class="input" value="<%=employeesListDto.getPass() %>">
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>
												<tr>
													<td height="13" align="left">부     서<font color="blue">*</font></td>
													
													<td><select id="department" name="department">
													<%
													if(dlist!=null){
														int dlen=dlist.size();
														for(int i=0;i<dlen;i++) {
															if((dlist.get(i).getDepartment_id().equals(employeesListDto.getDepartment_id()))) {%>
													  	<option value="<%=dlist.get(i).getDepartment_id() %>" selected="selected"><%=dlist.get(i).getDepartment_name() %></option>
													<%		} else {%>
														<option value="<%=dlist.get(i).getDepartment_id() %>"><%=dlist.get(i).getDepartment_name() %></option>														
															<%}
														}
													} else {%>
														 <option value="empty">부서가 없습니다.</option>
													<%}%>
													</select></td>
													
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>
												<tr>
													<td height="13" align="left">직     급<font color="blue">*</font></td>
													<td><select id="grade" name="grade">
													  <%
													if(glist!=null){
														int glen=glist.size();
														for(int i=0;i<glen;i++) {
															if((glist.get(i).getGrade_id().equals(employeesListDto.getGrade_id()))) {
														%>
													  <option value="<%=glist.get(i).getGrade_id() %>"><%=glist.get(i).getGrade_name() %></option>
													<%		} else {%>
														<option value="<%=glist.get(i).getGrade_id() %>"><%=glist.get(i).getGrade_name() %></option>
															<%}
														}
													} else {%>
														 <option value="empty">직급이 없습니다.</option>
													<%}%>
													</select></td> 
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>
												<tr>
													<td height="13" align="left">근     무</td>
													<td><select id="group" name="group">
													  <%
													if(grlist!=null){
														int grlen=grlist.size();
														for(int i=0;i<grlen;i++) {%>
													  <option value="<%=grlist.get(i) %>"><%=grlist.get(i) %></option>
													<%	}
													} else {%>
														 <option value="empty">근무조가 없습니다.</option>
													<%}%>
													</select></td> 
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>
												<tr>
													<td height="13" align="left">프로필 이미지</td>
													<td><table width="100%" border="0" cellspacing="0" cellpadding="3" class="type2">
															<tr>
	
	<script>
	jQuery(function() {
		jQuery("#imgInp").on('change', function(){
			var thumbext = document.getElementById('imgInp').value//파일을 추가한 input 박스의 값
			thumbext = thumbext.slice(thumbext.indexOf(".") + 1).toLowerCase();//파일 확장자를 잘라내고, 비교를 위해 소문자로 만듭니다.
			if(thumbext != "jpg" && thumbext != "png" &&  thumbext != "gif" &&  thumbext != "bmp"){ //확장자를 확인합니다.
				alert('썸네일은 이미지 파일(jpg, png, gif, bmp)만 등록 가능합니다.');
				document.getElementById("imgInp").value="";
				document.blah.src="<%=root%>/css/admin_companyinfo/skin_images/noimage.gif";
				return;
			} else {
				readURL(this);
			}
           });
		});

       function readURL(input) {
           if (input.files && input.files[0]) {
           var reader = new FileReader();

           reader.onload = function (e) {
           	jQuery('#blah').attr('src', e.target.result);
              }
             reader.readAsDataURL(input.files[0]);
           }
       }
 
	</script>	
																<%if(employeesListDto.getSave_picture()!=null) {%>		
																<td width="90">												
																<img id="blah" name="blah"
																	src="picture/<%=employeesListDto.getSave_folder()%>/<%=employeesListDto.getSave_picture() %>"
																	width="80" height="70" border="0" >
																	</td>
																<td valign="top">
																<br> <br> 
																<input type="file" name="imgInp"
																	id="imgInp" style="width: 98%; display: block;"
																	class="input" value="<%=employeesListDto.getSave_picture()%>"></td>
																<%} else {%>
																<td width="90">
																<img id="blah" name="blah"
																	src="<%=root%>/css/admin_companyinfo/skin_images/noimage.gif"
																	width="80" height="70" border="0">
																
																</td>
																<td valign="top">
																<br> <br> 
																<input type="file" name="imgInp"
																	id="imgInp" style="width: 98%; display: block;"
																	class="input" ></td>
																<%} %>	
															</tr>
														</table></td>
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>

												<tr>
													<td height="13" align="left">E-mail</td>
													<td><input type="text" id="email1" name="email1" size="12"
														class="input" value="<%=employeesListDto.getEmail1() %>" style="ime-mode: disabled">
														@ <input type="text" id="email2" name="email2" size="12"
														class="input" value="<%=employeesListDto.getEmail2() %>" style="ime-mode: disabled">
														<SELECT
														onChange='javascript:mform.email2.value=this.value;'
														name="email3" class="input">
															<OPTION value="">직접입력</OPTION>
															<OPTION value="hanmail.net">hanmail.net</OPTION>
															<OPTION value="yahoo.co.kr">yahoo.co.kr</OPTION>
															<OPTION value="lycos.co.kr">lycos.co.kr</OPTION>
															<OPTION value="korea.com">korea.com</OPTION>
															<OPTION value="hanafos.com">hanafos.com</OPTION>
															<OPTION value="empal.com">empal.com</OPTION>
															<OPTION value="dreamwiz.com">dreamwiz.com</OPTION>
															<OPTION value="naver.com">naver.com</OPTION>
															<OPTION value="hotmail.com">hotmail.com</OPTION>
															<OPTION value="hanmir.com">hanmir.com</OPTION>
															<OPTION value="netian.com">netian.com</OPTION>
															<OPTION value="freechal.com">freechal.com</OPTION>
															<OPTION value="chollian.net">chollian.net</OPTION>
															<OPTION value="hitel.net">hitel.net</OPTION>
															<OPTION value="paran.com">paran.com</OPTION>
													</SELECT></td>
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>

												<tr>
													<td height="37" align="left">주 소<font color="blue">*</font></td>
													<td><table width="98%" border="0" class="type2">
															<tr>
																<td width="70">우편번호</td>
																<td><input name="post1" type="text" id="post1"
																	size="3" maxlength="3" class="input" value="<%=employeesListDto.getZip1() %>" readonly="readonly">
																	- <input name="post2" type="text" id="post2" size="3"
																	maxlength="3" class="input" value="<%=employeesListDto.getZip2() %>" readonly="readonly"> <img
																	src="<%=root%>/css/admin_companyinfo/skin_images/btn_post.gif"
																	width="53" height="19" align="absmiddle"
																	style="cursor: pointer;" onclick="javascript:openzip();"></td>
															</tr>
															<tr>
																<td>주소</td>
																<td><input name="address1" type="text"
																	id="address1" size="40" class="input" value="<%=employeesListDto.getAddr1() %>" readonly="readonly"></td>
															</tr>
															<tr>
																<td>상세 주소</td>
																<td><input name="address2" type="text"
																	id="address2" size="40" class="input" value="<%=employeesListDto.getAddr2() %>"></td>
															</tr>
														</table></td>
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>

												<tr>
													<td height="13" align="left">휴대폰 번호<font color="blue">*</font></td>
													<td><input name="tel1" type="text" id="tel1"
														size="5" maxlength="5" class="input" value="<%=employeesListDto.getHp1() %>"> -
														<input name="tel2" type="text" id="tel2" size="5"
														maxlength="5" class="input" value="<%=employeesListDto.getHp2() %>"> - 
														<input name="tel3" type="text" id="tel3" size="5" maxlength="5"
														class="input" value="<%=employeesListDto.getHp3() %>"></td>
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>

												<tr>
													<td height="13" align="left">자택 번호</td>
													<td><input name="htel1" type="text" id="htel1"
														size="5" maxlength="5" class="input" value="<%=employeesListDto.getHn1() %>"> -
														<input name="htel2" type="text" id="htel2" size="5"
														maxlength="5" class="input" value="<%=employeesListDto.getHn2() %>"> - <input
														name="htel3" type="text" id="htel3" size="5"
														maxlength="5" class="input" value="<%=employeesListDto.getHn3() %>"></td>
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>
												
												<tr>
													<td height="13" align="left">성별</td>
													
													<%if("man".equals(employeesListDto.getGender())) {%>
													<td><input type="radio" name="gender" value="man" checked="checked">남자
													<input type="radio" name="gender" value="woman">여자</td>
													<%} else if("woman".equals(employeesListDto.getGender())) {%>
													<td><input type="radio" name="gender" value="man">남자
													<input type="radio" name="gender" value="woman" checked="checked">여자</td>
													<%} else {%>
													<td><input type="radio" name="gender" value="man">남자
													<input type="radio" name="gender" value="woman">여자</td>
													<%} %>
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>
												
												<tr>
													<td height="13" align="left">결혼 여부</td>
													<%if("unmarried".equals(employeesListDto.getMarraige())) {%>
													<td><input type="radio" name="marry" value="unmarried" checked="checked">미혼
														<input type="radio" name="marry" value="married">기혼</td>
													<%} else if("married".equals(employeesListDto.getMarraige())) {%>
													<td><input type="radio" name="marry" value="unmarried">미혼
														<input type="radio" name="marry" value="married" checked="checked">기혼</td>
													<%} else {%>
													<td><input type="radio" name="marry" value="unmarried">미혼
														<input type="radio" name="marry" value="married">기혼</td>
													<%} %>
												</tr>
												<tr>
													<td height="1" align="left" bgcolor="#e1e1e1"></td>
													<td height="1" bgcolor="#e1e1e1"></td>
												</tr>
												<tr height="1">
													<td align="left"></td>
													<td></td>
												</tr>

											</table>
											<br>

											<table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="type">
												<tr>
													<td height="10" align="center"></td>
												</tr>
											</table>
											<table width="100%" border="0" align="center">
												<tr>
													<td align="center">
													<input type="button" value="수정" onclick="javascript:update();">
													<input type="reset" value="취소">
													</td>
												</tr>
												<tr>
	   												<td><font color="white">.</font></td>
										   		</tr>
										   		<tr>
										   			<td><font color="white">.</font></td>
										   		</tr>
											</table>
										</td>
									</tr>
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

				<!-- /.row -->
			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->
	</form>
	<!-- jQuery -->
	<script src="<%=root%>/css/vendor/jquery/jquery.min.js"></script>

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
	
	<script type="text/javascript">
	function update(){
		document.getElementById("act").value = "update";
		document.uForm.action = "<%=root%>/emp?act=update";
		document.uForm.submit();
	}
	
	function openzip(){
		window.open("<%=root%>/emp?act=mvzip","zipsearch","top=200, left=300, width=400, height=300, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
	}
	</script>


</body>

</html>
