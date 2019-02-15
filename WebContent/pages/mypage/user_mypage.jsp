<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.cube.model.dto.Doc_info_detailDto, java.net.InetAddress, java.util.List, com.cube.model.dto.EmployeesListDto"%>
<%@ include file="/common/user_public.jsp"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js" ></script>
<%

/* InetAddress ip = InetAddress.getLocalHost(); 

String ipadress=ip.getHostAddress();
 */
//System.out.println(ipadress);
 
 EmployeesListDto employeesListDto=(EmployeesListDto)request.getAttribute("myupdate");
 
 System.out.println(employeesListDto.getZip1());

%> 
	<form id="uForm" name="uForm" method="post" enctype="multipart/form-data">
		<input type="hidden" id="act" name="act" value="mypageinsert">
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
            
            
		              <!-- /.row -->
		            
		            <div class="row">
		                <div class="col-lg-12 col-mg-6 col-sg-3">
		                    <div class="panel panel-default">
		                        <div class="panel-heading">
		                     <b>MyPage</b> <div class="fa col-sg-3">
		                           <i class="fa-heart"></i>
		                            </div>
		                        </div>
		                       
		                        <!-- /.panel-heading -->
		                        <div class="panel-body">
		                            <!-- Nav tabs -->
		                            <ul class="nav nav-tabs">
		                              <!--   <li class="active"><a href="#home" data-toggle="tab">Home</a>
		                                </li> -->
		                                <li><a href="#profile" data-toggle="tab">Profile</a>
		                                </li>
		                                <li><a href="#messages" data-toggle="tab">Messages</a>
		                                </li>
		                            
		                            </ul>
		
		                            <!-- Tab panes -->
		                            <div class="tab-content">
		                               
		                                <div class="tab-pane fade in active" id="profile">
        

        
        
				   <div class="panel panel-red" style="margin:5%">
                        <div class="panel-heading">
                           My Profile Modify
                        </div>
                        <div class="panel-body">
        
						                      <!-- 프로필 시작 -->    <!-- class="container-fluid well span6" -->       	
									<!--  	<div class="col-lg-12 col-mg-6 col-sg-4"
											style="position: relative; float: left; margin-top:2%; margin-left:1%; background-color:white;">
				
                         -->
											<table class="col-lg-12 col-mg-6 col-sg-4">
												<tr>
												<td width="10%"></td>
													<td>
														<div class="span2">
												
															<img
																src="picture/<%=employeesDto.getSave_folder()%>/<%=employeesDto.getSave_picture()%>" 
																style="width: 120px; height: auto;"
																<%-- src="http://<%=ipadress%>/<%=root%>/picture/<%=employeesDto.getSave_folder()%>/<%=employeesDto.getSave_picture()%>" --%>
																<%-- src="http://183.101.196.135/<%=root%>/picture/<%=employeesDto.getSave_folder()%>/<%=employeesDto.getSave_picture()%>" --%>
																class="img-circle">
														</div>
													</td>
													<td  width="5%"></td>
													<td align="left">
														<table>
															<tr>
				
																<div class="span8">
																<table>
																<tr height="20px"></tr>
																	<tr>
																		<td><b>User_Name</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td width="60%"><%=employeesDto.getName()%></td><td></td>
																	</tr>
																	<tr height="20px"><td></td><td></td><td></td><td></td></tr>
																	<tr>
																		<td><b>User_Grade</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td><%=employeesDto.getGarde_name()%></td><td></td>
																	</tr>
																	<tr height="20px"><td></td><td></td><td></td><td></td></tr>
																	<tr>
																		<td><b>User_Email</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><%-- <td><%=employeesDto.getEmail1()%>@<%=employeesDto.getEmail2()%></td> --%>
																	
																	<td><input type="text" id="email1" name="email1" size="12"
														class="input" value="<%=employeesDto.getEmail1() %>" style="ime-mode: disabled">
														@ <input type="text" id="email2" name="email2" size="12"
														class="input" value="<%=employeesDto.getEmail2() %>" style="ime-mode: disabled">
														</td><td><SELECT
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
																<tr height="20px"></tr>
																	<tr>
																		<td><b>User_Password</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td><input name="pwd" type="password" id="pwd"
														size="15" class="input" value="<%=employeesDto.getPass() %>"></td>
																	</tr>
																	<tr height="20px"></tr>
																	<!-- 여기서부터 수정 -->
																	<tr>
																		<td><b>User_Team</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td><%=employeesDto.getGroup_standard()%></td>
																	</tr>
																	<tr height="20px"></tr>
																	<tr>
																		<td><b>User_Picture</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
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
																<%if(employeesDto.getSave_picture()!=null) {%>		
																<td>												
																<img id="blah" name="blah"
																	src="picture/<%=employeesDto.getSave_folder()%>/<%=employeesDto.getSave_picture() %>"
																	height="70">
																</td>
																<td>
																
																<input type="file" name="imgInp"
																	id="imgInp" style="display: block;"
																	class="input" value="<%=employeesDto.getSave_picture()%>">
																</td>
																<%} else {%>
																<td>
																<img id="blah" name="blah"
																	src="<%=root%>/css/admin_companyinfo/skin_images/noimage.gif"
																	height="70" border="0">
																
																</td>
																<td>
																
																<input type="file" name="imgInp"
																	id="imgInp" style="display: block; margin-left:2%;"
																	class="input" >
																</td>
																<%} %>
														
																	</tr>
																	<tr height="10px"></tr>
																	<tr>
																		<td><b>User_Adress</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
																		<td colspan="3"><table width="98%" border="0" class="type2">
															<tr>
															
																<td width="70px">우편번호</td>
																<td><input name="post1" type="text" id="post1"
																	size="3" maxlength="3" class="input" value="<%=employeesListDto.getZip1()%>" readonly="readonly">
																	- <input name="post2" type="text" id="post2" size="3"
																	maxlength="3" class="input" value="<%=employeesListDto.getZip2()%>" readonly="readonly"> 
																	<button type="button" class="btn btn-warning" style="height:29px; margin-bottom:1%; background-color:#d9534f; !import" onclick="javascript:openzip();"> 검색 </button></td>
															</tr>
															
															<tr>
																<td>주소</td>
																<td><input name="address1" type="text"
																	id="address1" size="40" class="input" value="<%=employeesListDto.getAddr1() %>" readonly="readonly"></td>
															</tr>
															<tr height="2px"></tr>
															<tr>
																<td>상세 주소</td>
																<td><input name="address2" type="text"
																	id="address2" size="40" class="input" value="<%=employeesListDto.getAddr2() %>"></td>
															</tr>
														</table></td><td></td>
																	</tr>
																	<tr height="15px"></tr>
																	<tr>
																		<td><b>User_Phone</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
																		<td colspan="3"><input name="tel1" type="text" id="tel1" size="5" maxlength="5" class="input" value="<%=employeesListDto.getHp1() %>"> -
																			<input name="tel2" type="text" id="tel2" size="5" maxlength="5" class="input" value="<%=employeesListDto.getHp2() %>"> - 
																			<input name="tel3" type="text" id="tel3" size="5" maxlength="5" class="input" value="<%=employeesListDto.getHp3() %>">
																		</td><td width="75%" rowspan="4" align="right"><img src="<%=root%>/img/mypage/wellng.png" height="70%"></td>
																	</tr>
																	<tr>
																		<td><b>User_HomeNumber</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td colspan="3"><input name="htel1" type="text" id="htel1"
														size="5" maxlength="5" class="input" value="<%=employeesListDto.getHn1() %>"> -
														<input name="htel2" type="text" id="htel2" size="5"
														maxlength="5" class="input" value="<%=employeesListDto.getHn2() %>"> - <input
														name="htel3" type="text" id="htel3" size="5"
														maxlength="5" class="input" value="<%=employeesListDto.getHn3() %>"></td><td></td>
																	</tr>
																	
																	<tr>
																		<td><b>User_Gender</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td width="30%">
													
													<%if("man".equals(employeesListDto.getGender())) {%>
													<input type="radio" name="gender" value="man" checked="checked"  style="margin-left:5%; !import">남자
													<input type="radio" name="gender" value="woman" style="margin-left:10%; margin-right:5%; !import">여자
													<%} else if("woman".equals(employeesListDto.getGender())) {%>
													<input type="radio" name="gender" value="man"  style="margin-left:5%; !import">남자
													<input type="radio" name="gender" value="woman" checked="checked" style="margin-left:10%; margin-right:5%; !import">여자
													<%} else {%>
													<input type="radio" name="gender" value="man" style="margin-right:5%; !import">남자
													<input type="radio" name="gender" value="woman" style="margin-left:10%; margin-right:5%; !import">여자
													<%} %></td><td></td>
																	</tr>
																	
																	<tr>
																		<td><b>User_Marriage</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><%if("unmarried".equals(employeesListDto.getMarraige())) {%>
													<td><input type="radio" name="marry" value="unmarried" checked="checked" style="margin-right:5%; !import">미혼
														<input type="radio" name="marry" value="married" style="margin-left:10%; margin-right:5%; !import">기혼</td>
													<%} else if("married".equals(employeesListDto.getMarraige())) {%>
													<td><input type="radio" name="marry" value="unmarried" style="margin-right:5%; !import">미혼
														<input type="radio" name="marry" value="married" checked="checked" style="margin-left:10%; margin-right:5%; !import">기혼</td>
													<%} else {%>
													<td><input type="radio" name="marry" value="unmarried" style="margin-right:5%; !import">미혼
														<input type="radio" name="marry" value="married" style="margin-left:10%; margin-right:5%; !import">기혼</td>
													<%} %><td></td>
																	</tr>
																<tr height="20px"></tr>
																</table>
																
																</div>
																
															</tr>
															
															
															
														</table>
													</td>
												</tr>
											</table>
											
											<!-- </div>  -->
						                         <!-- 프로필 끝 -->       	
						                         
											</div>
                        <div class="panel-footer">
                            <button type="button" class="btn btn-warning" id="picture_modify" style="background-color:#d9534f;" onclick="javascript:update();">수정</button>
                        </div>
                    </div>
		                           
		                                </div>
		                                <div class="tab-pane fade" id="messages">
		                                     <div class="panel panel-default">
                    
                       					 <div class="panel-body">
											<a class="btn btn-block btn-social btn-bitbucket" href="sms:">
			                                <i class="glyphicon-envelope"></i><b>SMS발송</b></a>
			                              
			                                </div></div>
		                                </div>
		                             
		                            </div>
		                        </div>
		                        <!-- /.panel-body -->
		                    </div>
		                    <!-- /.panel -->
		                </div>
            
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

<!-- jQuery -->
<script src="<%=root%>/css/vendor/jquery/jquery.min.js"></script>


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
		document.getElementById("act").value = "mypageinsert";
		document.uForm.action = "<%=root%>/mypage?act=mypageinsert";
		document.uForm.submit();
	}
	
	function openzip(){
		window.open("<%=root%>/emp?act=mvzip","zipsearch","top=200, left=300, width=400, height=300, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
	}
	</script>

</body>
</html>