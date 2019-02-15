<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.cube.model.dto.EmployeesDto"%>
<% 
String root = request.getContextPath();

%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>

	<link rel='stylesheet prefetch' href='https://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.css'>
     <link rel='stylesheet prefetch' href='<%=root%>/css/style.css'>   
   

<title>Login</title>
</head>
<body style=" background: #00589F !important;">
<center>
   <div class="container">
  <div class="row">
    <div class="Absolute-Center is-Responsive">
      <div id="logo-container"><img src="/cubegroupware/img/logo/cubelogo.png" style="height:100px"></div>
      <br>
      <div class="col-sm-12 col-md-10 col-md-offset-1">

        <form name="loginForm" id="loginForm" method="post" action="" >
        <input type="hidden" id="act" name="act" value="loginInfo">
	<%-- 	<input type="hidden" id="working" name="working" value="<%=employeesDto.getWorking()%>"> --%>
         
          <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input class="form-control" type="text" name='username' id='username' placeholder="username" value=""/>          
          </div>
          <div class="form-group input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input class="form-control" type="password" name='password' id='password' placeholder="password" value=""/>     
          </div>
      
            <div class="col-sm-6 col-md-6 col-lg-6">
              <input type="radio" name='logincheck' id='member' value="member">Member
              </div>
              <div class="col-sm-6 col-md-6 col-lg-6">
              <input type="radio" name='logincheck' id='admin' value="admin">Admin
              </div>
              <br>&nbsp;
       
          <div class="form-group">
          
            <button type="button" class="btn btn-def btn-block" onclick="loginCheck()">Login</button>
          </div>
      
        </form>        
      </div>  
    </div>    
  </div>
</div>
	<script type="text/javascript" src="<%=root %>/js/login.js"></script>
	
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js'></script>

    
    </center>
</body>
</html>