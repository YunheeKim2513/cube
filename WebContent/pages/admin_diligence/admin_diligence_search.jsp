<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.List, java.text.SimpleDateFormat, com.cube.model.dto.Confirmlist_infoDto, com.cube.model.dto.EmployeesDto, com.cube.model.dto.EmployeeDilDto, com.cube.model.dto.User_timeDto, com.cube.model.dto.Admin_timeDto"%>
<%@ include file="/common/admin_public.jsp"%>
<%
	 List<EmployeeDilDto> employeelist =(List<EmployeeDilDto>) request.getAttribute("employeelist");

	EmployeesDto employeesDto2 = (EmployeesDto)request.getAttribute("userInfo");
	
	Admin_timeDto admin_timeDto = (Admin_timeDto)request.getAttribute("admin_timeStandard");


%>

        <!-- /#page-wrapper -->
               <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">사원별 근태현황</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        <button type="button" class="btn btn-primary btn-lg"  style="width:7%; height:35px; padding-top: 7px; " id="allck">모두선택</button>
                        <button type="button" class="btn btn-primary btn-lg"  style="width:7%; height:35px; padding-top: 7px; " id="alldeck">모두해제</button>
                        <button type="button" class="btn btn-primary btn-lg" style="width:5%; height:35px; padding-top: 7px; " id="modify">수정</button>
                        <button type="button" class="btn btn-primary btn-lg" style="width:5%; height:35px; padding-top: 7px; " id="cancle">취소</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                            <table width="100%" class="table table-striped table-bordered table-hover"  id="dataTables-example">
                                <thead >
                       
                                    <tr>
                                        <th style="width:8%;"></th>
                                        <th style="width:17%">부서</th>
                                        <th style="width:17%">직급</th>
                                        <th style="width:17%">사원명(id)</th>
                                        <th style="width:8%">재직여부</th>
                                        <th style="width:17%">정상출근비율</th>
                                        <th>지각비율</th>
                                    
                                    </tr>
                                </thead>
                                
                             
                                <tbody>
                    
                        		 <%
                        	int idx=0; int num=0;
                        		  int size = employeelist.size(); 
                                  for(int i=0; i<size; i++){
                                	  EmployeeDilDto employeeDilDto = employeelist.get(i); 
                                 
                                  %> 
                                   <tr class="odd gradeX" name="check" >
                 
                               
                                   		<td class="center"><center><input type="checkbox" name="checkname" id="ch<%=i%>" value="<%=i%>"></center></td>
                                        <td><center><%=employeeDilDto.getDepartment_name()%></center></td>
                                        <td><center><%=employeeDilDto.getGarde_name()%></center></td>
                                        <td class="center" id="employee" name="employee" value="<%=employeeDilDto.getEmployee_id()%>"><center><%=employeeDilDto.getName()%>(<%=employeeDilDto.getEmployee_id()%>)</center></td>      
                                        <td class="center"><center>
                                    
                                <% String working = "y";
                                if(employeeDilDto.getWorking() == working){%>
										퇴직
                                      
                                        <%}else{%>
                                        	재직중
                                        <%}%> 
                                        </center></td> 
                                        
                                      	
                                      
                                        <td class="center" id="<%=idx++%>a"><center>
                                       <%GregorianCalendar today = new GregorianCalendar();
                                       double maxday = today.getActualMaximum(today.DAY_OF_MONTH);
                                       
                                       double satart = Double.parseDouble(String.format("%.2f", Integer.parseInt(employeeDilDto.getNomal_limit())/maxday*100));
                                       %> 
                                 
                                    <%=satart%>%
                                        </center></td> 
                                        
                                        <td class="center" id="<%=num++%>b"><center>
                                                   <%GregorianCalendar today2 = new GregorianCalendar();
                                       double maxday2 = today2.getActualMaximum(today2.DAY_OF_MONTH);
                                       
                                       double satart2 = Double.parseDouble(String.format("%.2f", Integer.parseInt(employeeDilDto.getEndtime())/maxday2*100));
                                       %> 
                                 
                                    <%=satart2%>%   
                                     
                                        
                                        </center></td>
                    
                    			
                                      <%}%>	 
                                    </tr>
                         	 
                                    
                                </tbody>
                            
                              
                            </table>
                        
                            <label></label>
                            <center><button type="button" class="btn btn-primary btn-lg" id="savebtn" style="width:50%; height:40px; padding-top:7px;">저장</button></center>
                        	 <label></label>
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
    <!--리스트 js -->
	<script>
	
	var len =<%=size%>;

	$("#allck").click(function() {
//alert("모두선택?");
		for (var i = 0; i < len; i++) {// 첨부터 체크를 하려면 이렇게 초기화를 해야 한다.

			$("input[type=checkbox]").prop("checked", true);

		}

	});

	$("#alldeck").click(function() {
		//alert("모두해제?");
		for (var i = 0; i < len; i++) {// 첨부터 체크를 하려면 이렇게 초기화를 해야 한다.

			$("input[type=checkbox]").prop("checked", false);
				
		}

	});
	
	function vv() {
		
	
	var save = $("input:checkbox[name=checkname]:checked").attr('value');
		
	
	for (var i = 0; i < len; i++) {
		
			if(save == i){
		 document.getElementById(i+"a").innerHTML="<input type='text' width='500px' class='a'>&nbsp&nbsp%";
		 document.getElementById(i+"b").innerHTML="<input type='text' width='500px' class='b'>&nbsp&nbsp%";
			}
		}
		
	
	}
	
	$("#modify").click(function() {
		alert("수정 들어오니?");
		
		 if( $("input:checkbox[name=checkname]:checked").length ==0 ){
			    alert("수정할 항목을 하나만 체크해주세요.");
			    return;
		 
		 }else if($("input:checkbox[name=checkname]:checked").length ==1 ){
			
			 $("input:checkbox[name=checkname]:checked").each(function() {
				
				 vv();
	 
			 });
		 }else{
			 
			 for (var i = 0; i < len; i++) {
			 	 document.getElementById(i+"b").innerHTML="<input type='text' width='500px' class='b'>&nbsp&nbsp%";
				 document.getElementById(i+"a").innerHTML="<input type='text' width='500px'class='a' >&nbsp&nbsp%";
				
					
			}
		 }
	});
	
	
	$("#cancle").click(function() {
		//alert("취소?");
		 location.reload();
		
	});
	
	$("#savebtn").click(function() {
		alert("저장?");
		
		 
/* 		for (var i = 0; i < len; i++) {
			document.getElementById(i+"b").innerHTML="<td>1.00%</td>";
		}
		 */

		var save = $("input:checkbox[name=checkname]:checked").attr('value');
			
		
		for (var i = 0; i < len; i++) {
			
				if(save == i){
			 document.getElementById(i+"a").innerHTML="<td><center>1.00%</center></td>";
			 document.getElementById(i+"b").innerHTML="<td><center>2.00%</center></td>";
				}
			}
			
		 
			
			 
/* 			 $.ajax({
					type : "POST",
					dataType : 'text',// 데이타 타입을 json으로 받겠다.
					url : root + control,
					data : {
						act : "deletebtn", admintime_seq : seqnum
					},
					success : function() {// 알아서 맞춰준다.
						//alert("삭제 컨트롤러로~ 고고싱~!");
						 bb();
					},
					error : function(e) {
						alert("에러!");
					}
				}); */
		
	});
	
	


	</script>

<!-- SmallCalendar -->
<script src="<%=root%>/calendar/jquery.minical.js"></script>
<script>
	$("form.demo-1 :text").minical();
	$("form.demo-2 :text").minical({
		inline : true
	});
	$("form.demo-3 :text").minical({
		trigger : "i.trigger-icon"
	});
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
    
    <!--Modal-->

   <script src="<%=root %>/modal/jquery/jquery-ui.custom.js" type="text/javascript"></script>
   <script src="<%=root %>/modal/jquery/jquery.cookie.js" type="text/javascript"></script>
   <link href="<%=root %>/modal/src/skin-vista/ui.dynatree.css" rel="stylesheet" type="text/css">
   <script src="<%=root %>/modal/src/jquery.dynatree.js" type="text/javascript"></script>
   <script type="text/javascript">
   var btnids;
    $(function(){
      // Initialize the tree inside the <div>element.
      // The tree structure is read from the contained <ul> tag.
      $("#tree1").dynatree({
        onActivate: function(node) {
           var parameter="act=confirmbtn&confirmname="+encodeURI(node.data.title);
           sendRequest("<%=root%>/userdocwrite",parameter,receiveParams, "GET");
           function receiveParams() {
              if(httpRequest.readyState==4){
                 if(httpRequest.status==200){
                	 if(btnids=="departsearchtext"){
                         document.getElementById("departsearchtext").value = node.data.title;
	                 }
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
      $("#tree2, #tree3").dynatree({
          onActivate: function(node) {
             var parameter="act=docconfirmbtn&confirmname="+encodeURI(node.data.title);
             sendRequest("<%=root%>/userdocwrite",parameter,receiveParams, "GET");
             function receiveParams() {
                if(httpRequest.readyState==4){
                   if(httpRequest.status==200){
                      if(btnids=="receivebtn"){
                         $("#receiveinputbox").val(node.data.title);
                      } else if(btnids=="signreferencebtn"){
                         $("#referenceinputbox").val(node.data.title);
                      }
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
          $("#tree1, #tree2, #tree3").dynatree("getRoot").visit(function(node){
            node.expand(true);
          });
          return false;
        });
        $("#btnCollapseAll").click(function(){
          $("#tree1, #tree2, #tree3").dynatree("getRoot").visit(function(node){
            node.expand(false);
          });
          return false;
        });
    });  
    function confirmline(optionval) {
      var parameter="act=docconfirmnum&confirmname="+encodeURI(optionval);
      sendRequest("<%=root%>/userdocwrite",parameter,receiveParam, "GET");
   }
   
   function test(btval, btid){
      btnids=btid;
      if(btval=="appoint"){
         return;
      } else {
         var btstr = btid.substr(btid.length-1);
         var str = "signconfirmname"+btstr;
         var str1 = "signdoc_approval"+btstr;
         document.getElementById(str).innerHTML = "";
         document.getElementById(str1).value="appoint";
         document.getElementById(str1).innerHTML="지정";
         event.stopPropagation();
      }
   }
   
   function receiveParam() {
      if(httpRequest.readyState==4){
         if(httpRequest.status==200){
            result = httpRequest.responseText;
            var result1 = result.split(' ');
            for(var i=0; i<result1.length; i++){
               var str = "signconfirmname"+i;
               var str1 = "signdoc_approval"+i;
               if(result1[i]!="null" && result1[i].length!=6){
                  document.getElementById(str).innerHTML = result1[i];
                  document.getElementById(str1).value="cancel";
                  document.getElementById(str1).innerHTML="취소";
               } else{
                  document.getElementById(str).innerHTML = "";
                  document.getElementById(str1).value="appoint";
                  document.getElementById(str1).innerHTML="지정";
               }
            }
         } 
      }   
   }
   </script>

<script src="<%=root%>/js/user/diligencesearch.js" charset='euc-kr'></script>


    
</body>

</html>

