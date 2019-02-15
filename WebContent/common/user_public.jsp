<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, com.cube.model.dto.Confirmlist_infoDto, com.cube.model.dto.EmployeesDto"%>
<%
String root = request.getContextPath();
String index =  root+"/index.jsp";
String pages = root + "/pages";
String SE2 = root + "/SE2";
EmployeesDto employeesDto = (EmployeesDto) session.getAttribute("userInfo");
String user_diligence_time = pages + "/user_diligence/user_diligence_time.jsp"; //user
String admin_diligence_search = pages + "/admin_diligence/admin_diligence_search.jsp";
String admin_diligence_statistics = pages + "/admin_diligence/admin_diligence_statistics.jsp";
String admin_diligence_time = pages + "/admin_diligence/admin_diligence_time.jsp";
String admin_diligence_happyday = pages + "/admin_diligence/admin_diligence_happyday.jsp"; 
String admin_confirm_confirmlist = pages + "/admin_confirm/admin_confirm_confirmlist.jsp";
String admin_confirm_docmanage = pages + "/admin_confirm/admin_confirm_docmanage.jsp";
%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>User_Cube</title>

	

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
	<link href="<%=root %>/calendar/jquery.minical.css" rel="stylesheet" type="text/css">
	
	<style>
	ul, li { list-style: none; }
	
	.demo-3 i {
	  position: absolute;
	  right: 30px;
	  bottom: 10px;
	}
	
	.container { margin: 150px auto; }
	</style>	

	<script type="text/javascript" src="<%=root%>/js/httpRequest.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>

<body>
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
                <a class="navbar-brand" href="<%=root%>/userhome?act=user_home"><span><img src="<%=root%>/img/logo/cubelogo.png" style="width:30px; height:30px"></span>CUBE GROUPWARE</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
             <li><div style="margin-right:10px; font-size:14px; !import"><b>User ID&nbsp&nbsp:</b></div></li><li><div style="margin-right:25px; color:rgb(500, 100, 100); font-size:14px; !import"><b><%=employeesDto.getEmployee_id()%></b></div></li>
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
                        <li><a href="<%=root%>/mypage?act=gomypage"><i class="fa fa-user fa-fw"></i> My Page </a>
                        </li>
                        
                        <li class="divider"></li>
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
                            <a href="<%=root%>/userhome?act=user_home"><i class="fa fa-home fa-fw"></i> HOME </a>
                        </li>
                        <li>
                            <a href="<%=root%>/userdiligence?act=user_diligence_time"><i class="fa fa-sign-in fa-fw"></i> 근태관리 </a>
                        </li>
                         <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i>전자결재<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <!-- <li>
                                    <a href="<%--=root--%>/userapprovalmain?act=approval_main">전자 결재 메인</a>
                                </li> -->
                              <li>
                                    <a href="<%=root%>/userapprovalmain?act=approval_business">회사 전체 문서</a>
                                </li>
                                <li>
                                    <a href="<%=root%>/userapprovalmain?act=approval_department">부서 전체 문서</a>
                                </li>
                                <li>
                                    <a href="#">결재 문서 작성<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="<%=root%>/userdocwrite?act=approval_signdocwrite"><i class="fa fa-caret-right fa-fw"></i>기안서</a>
                                        </li>
                                        <li>
                                            <a href="<%=root%>/userdocwrite?act=approval_orderdocwrite"><i class="fa fa-caret-right fa-fw"></i>품의서</a>
                                        </li>
                                        <li>
                                            <a href="<%=root%>/userdocwrite?act=approval_vacdoc"><i class="fa fa-caret-right fa-fw"></i>휴가계</a>
                                        </li>
                                        <li>
                                            <a href="<%=root%>/userdocwrite?act=approval_biztripdoc"><i class="fa fa-caret-right fa-fw"></i>출장 신청서</a>
                                        </li>
                                        <li>
                                            <a href="<%=root%>/userdocwrite?act=approval_biztrip_report"><i class="fa fa-caret-right fa-fw"></i>출장 결과 보고서</a>
                                        </li>
                                        <li>
                                            <a href="<%=root%>/userdocwrite?act=approval_deaddoc"><i class="fa fa-caret-right fa-fw"></i>사직서</a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-paperclip fa-fw"></i>받은 결재 문서함<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                		<li>
                                    		<a href="<%=root%>/usernook?act=approval_nook"><i class="fa fa-caret-right fa-fw"></i>미결재 문서</a>
                                		</li>
                                		<li>
                                    		<a href="<%=root%>/usernook?act=approval_okok"><i class="fa fa-caret-right fa-fw"></i>결재 완료 문서</a>
                                		</li>
                                	</ul>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-paperclip fa-fw"></i>올린 결재 문서함<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                		<li>
                                    		<a href="<%=root %>/usersavedoc?act=approval_usersavedoc"><i class="fa fa-caret-right fa-fw"></i>회수문서</a>
                                		</li>
                                		<li>
                                    		<a href="<%=root %>/usersenddoc?act=approval_userreport"><i class="fa fa-caret-right fa-fw"></i>상신문서</a>
                                		</li>
                                		<li>
                                    		<a href="<%=root %>/userreturndoc?act=approval_userreturn"><i class="fa fa-caret-right fa-fw"></i>반려문서</a>
                                		</li>
                                		<li>
                                    		<a href="<%=root %>/userwithdrawdoc?act=approval_userwithdrawdoc"><i class="fa fa-caret-right fa-fw"></i>결재완료</a>
                                		</li>
                                	</ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> 업무관리<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                           	 <li>
                                 <a href="#"><i class="fa fa-paperclip fa-fw"></i>내 업무보고<span class="fa arrow"></span></a>
                                 <ul class="nav nav-third-level">
                             		<li>
                                   		<a href="<%=root%>/usermyworkreport?act=myworkreport"><i class="fa fa-check-square-o fa-fw"></i>업무 보고 작성</a>
	                                </li>
	                                <li>
	                                    <a href="<%=root%>/usermyworkreport?act=usermyworkcheck"><i class="fa fa-check-square-o fa-fw"></i>올린 업무 보고 확인</a>
	                                </li>
                             	</ul>
                             </li>
                             <li>
                                 <a href="#"><i class="fa fa-paperclip fa-fw"></i>받은 업무보고<span class="fa arrow"></span></a>
                                 <ul class="nav nav-third-level">
	                                <li>
	                                    <a href="<%=root%>/usermyworkreport?act=receiveworkcheck"><i class="fa fa-check-square-o fa-fw"></i>받은 업무 보고 확인</a>
	                                </li>
                             	</ul>
                             </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-calendar-o fa-fw"></i> 일정관리<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=root%>/schedule_all?act=list"><i class="fa fa-check-square-o fa-fw"></i>전체 일정</a>
                                </li>
                                <li>
                                    <a href="<%=root%>/schedule_private?act=list"><i class="fa fa-check-square-o fa-fw"></i>개인 일정</a>
                                </li>
                                <li>
                                    <a href="<%=root%>/schedule_department?act=list"><i class="fa fa-check-square-o fa-fw"></i>부서 일정</a>
                                </li>
                                <li>
                                    <a href="<%=root%>/schedule_company?act=list"><i class="fa fa-check-square-o fa-fw"></i>회사 일정</a>
                                </li>
                                <li>
                                    <a href="<%=root%>/pages/user_schedule/schedule_search.jsp"><i class="fa fa-check-square-o fa-fw"></i>일정 검색</a>
                                </li>
                                <li>
                                    <a href="<%=root%>/schedule_vacation?act=list""><i class="fa fa-check-square-o fa-fw"></i>휴가 일정</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=root%>/adminhome?act=userhelpdesk_list"><i class="fa fa-clipboard fa-fw"></i>HELP DESK</a>
                        </li>
                       <!--  <li>
                            <a href="<%=root%>/adminhome?act=helpdesk_list"><i class="fa fa-calendar-o fa-fw"></i> HELP DESK<span class="fa arrow"></span></a>
                        </li> -->
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
 
