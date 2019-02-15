<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%String root =request.getContextPath(); %>
<!doctype html>
<html>
<head>
<meta charset="euc-kr">
<title>JQuery Calendar Demo</title>

	<link rel="stylesheet" href="<%=root %>/css/style.css" />
	
	<script type="text/javascript" src="<%=root %>/js/calendar.js"></script>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	
		<!-- jQuery -->
    <script src="<%=root %>/css/vendor/jquery/jquery.min.js"></script>

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
</head>
<body>

<div>
	<div><h2>calendar 1</h2></div>
	<div class="jquery-calendar"></div>

	<div><h2>calendar 2</h2></div>
	<div class="jquery-calendar"></div>
</div>

<div>
	<div><h2>Date-Picker</h2></div>
	<div><h3>Date Picker<h3></div>
	<input class="date-picker" type="text"/>
<div>

<div>
	<h3>디폴트 날짜 지정<h3>
</div>
<input class="date-picker" type="text" value="2015-12-25"/>

</body>
</html>
