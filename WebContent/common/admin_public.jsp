<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, com.cube.model.dto.EmployeesDto"%>
<%
String root = request.getContextPath();
String index =  root+"/index.jsp";
String pages = root + "/pages";
String SE2 = root + "/SE2";

String admin_home = pages+"/home/admin_home.jsp";
String admin_confirm_confirmlist = pages + "/admin_confirm/admin_confirmlist.jsp";
String admin_confirm_docmanage = pages + "/admin_confirm/admin_confirm_docmanage.jsp";
//String admin_diligence_happyday = pages+"/admin_diligence/admin_diligence_happyday.jsp";
//String admin_diligence_search = pages+"/admin_diligence/admin_diligence_search.jsp";
String admin_diligence_statistics = pages+"/admin_diligence/admin_diligence_statistics.jsp";
String admin_diligence_time = pages+"/admin_diligence/admin_diligence_time.jsp";

EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");

%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin_Cube</title>

	

    <!-- Bootstrap Core CSS -->
    <link href="<%=root %>/css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=root %>/css/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="<%=root %>/css/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%=root %>/css/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=root %>/css/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=root %>/css/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<link rel="stylesheet" href="<%=root %>/calendar/font-awesome.min.css">
	<link href="<%=root%>/calendar/jquery.minical.css" rel="stylesheet" type="text/css">
	
	<style>
	ul, li { list-style: none; }
	
	.demo-3 i {
	  position: absolute;
	  right: 30px;
	  bottom: 10px;
	}
	
	.container { margin: 150px auto; }
	
	</style>	
  
	   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
	
  
	<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>


<!-- ----------------twohands---------------------------- -->
	
	
	<!-- emp_list, fire_list-->
	
	 <style type="text/css">
	table.table-style-three {
		font-family: verdana, arial, sans-serif;
		font-size: 11px;
		color: #333333;
		border-width: 1px;
		border-color: #3A3A3A;
		border-collapse: collapse;
	}
	table.table-style-three th {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #FFA6A6;
		background-color: #D56A6A;
		color: #ffffff;
	}
	table.table-style-three tr:hover td {
		cursor: pointer;
	}
	table.table-style-three tr:nth-child(even) td{
		background-color: #F7CFCF;
	}
	table.table-style-three td {
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #FFA6A6;
		background-color: #ffffff;
	}
	

	</style>
	
	<!-- emp_list, fire_list -->



<!-- ----------------twohands---------------------------- -->


</head>

<body onload="drawChart()">
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
               	
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="<%=root%>/adminhome?act=admin_home"><span><img src="<%=root%>/img/logo/cubelogo.png" style="width:30px; height:30px"></span>CUBE GROUPWARE</a>
           		
            </div>
            <!-- /.navbar-header -->
 
 		
            <ul class="nav navbar-top-links navbar-right">
            <li><div style="margin-right:10px; font-size:14px; !import"><b>User Name &nbsp&nbsp:</b></div></li><li><div style="margin-right:25px; color:rgb(51, 102, 204);">admin</div></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                       
                        
                        <li><a href="<%=root%>/login?act=logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
<!-- 왼쪽메뉴바 -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search..." style="height:33px">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            	</span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="<%=admin_home%>"><i class="fa fa-home fa-fw"></i> HOME </a>
                        </li>
                        <li>
                            <a href="<%=admin_confirm_confirmlist%>"><i class="fa fa-cog fa-fw"></i>회사정보관리<span class="fa arrow"></span></a>
                        	  <ul class="nav nav-second-level">
                                        <li>                
                                           <a href="#"><i class="fa fa-user-plus fa-fw"></i>사원관리</a>
                                             <ul class="nav nav-third-level">
	                                              <li>
	                                            	<a href="<%=root%>/emp?act=mvwrite"><i class="fa fa-caret-right fa-fw"></i>회원등록</a>
	                                       		  </li>
	                                       		  <li>
	                                            	<a href="<%=root%>/emp?act=list"><i class="fa fa-caret-right fa-fw"></i>회원리스트</a>
	                                       		  </li>
	                                       		  <li>
	                                            	<a href="<%=root%>/emp?act=firelist"><i class="fa fa-caret-right fa-fw"></i>퇴사자</a>
	                                       		  </li>
                                             </ul>
                                        </li>
                                        <li>
                                            <a href="#"> <i class="fa fa-users fa-fw"></i>부서직급관리</a>
                                             <ul class="nav nav-third-level">
	                                              <li>
	                                            	<a href="<%=root%>/depart?act=list"><i class="fa fa-caret-right fa-fw"></i>부서</a>
	                                       		  </li>
	                                       		  <li>
	                                            	<a href="<%=root%>/grade?act=list"><i class="fa fa-caret-right fa-fw"></i>직급</a>
	                                       		  </li> 
                                             </ul>
                                        </li>
                              </ul>
                        </li>
                        <li>
                            <a href="<%=root%>/adminhome?act=helpdesk_list"><i class="fa fa-clipboard fa-fw"></i>HELP DESK</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i>업무지원<span class="fa arrow"></span></a>
                             <ul class="nav nav-second-level">
                                        <li>                
                                           <a href="#"> <i class="fa fa-clock-o fa-fw"></i>근태관리</a>
                                             <ul class="nav nav-third-level">
	                                              <li>
	                                            	<a href="<%=root%>/admindiligence?act=departsearch"><i class="fa fa-caret-right fa-fw"></i>사원별 근태현황</a>
	                                       		  </li>
	                                       	<%-- 	  <li>
	                                            	<a href="<%=admin_diligence_statistics%>"><i class="fa fa-caret-right fa-fw"></i>근태현황 통계</a>
	                                       		  </li> --%>
	                                       		  <li>
	                                            	<a href="<%=admin_diligence_time%>"><i class="fa fa-caret-right fa-fw"></i>출/퇴근 시간설정</a>
	                                       		  </li>
	                                       		   <li>
	                                            	<a href="<%=root%>/admindiligence?act=happypage"><i class="fa fa-caret-right fa-fw"></i>근무일/휴일 자동설정</a>
	                                       		  </li>
                                             </ul>
                                        </li>
                                        <li>
                                            <a href="#"> <i class="fa fa-table fa-fw"></i>전자 결재관리</a>
                                             <ul class="nav nav-third-level">
	                                              <li>
	                                            	<a href="<%=root%>/adminapproval?act=admin_confirmlist"><i class="fa fa-caret-right fa-fw"></i>결재선 설정</a>
	                                       		  </li>
	                                       		  <li>
	                                            	<a href="<%=root%>/adminapproval?act=confirm_docmanage"><i class="fa fa-caret-right fa-fw"></i>문서별 결재 관리</a>
	                                       		  </li> 
                                             </ul>
                                        </li>
                              </ul>
                        </li>
                       
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>