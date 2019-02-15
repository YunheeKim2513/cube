<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=EUC-KR">
  <title>Dynatree - Example</title>

  <script src="<%=root %>/modal/jquery/jquery.js" type="text/javascript"></script>
  <script src="<%=root %>/modal/jquery/jquery-ui.custom.js" type="text/javascript"></script>
  <script src="<%=root %>/modal/jquery/jquery.cookie.js" type="text/javascript"></script>

  <link href="<%=root %>/modal/src/skin-vista/ui.dynatree.css" rel="stylesheet" type="text/css">
  <script src="<%=root %>/modal/src/jquery.dynatree.js" type="text/javascript"></script>

  <!-- (Irrelevant source removed.) -->

<script type="text/javascript">
  $(function(){
    $("#tree").dynatree({
      onActivate: function(node) {
        $("#echoActive").text(node.data.title);
      },
      onDeactivate: function(node) {
        $("#echoActive").text("-");
      }
    });
  });
</script>
</head>

<body class="example">
  <div id="tree"> 
  <ul>
		<li>aaaa</li>
		<li>aaaa</li>
		<li>aaaa</li>
		<li>aaaa</li>
	</ul> 
   </div>
	 

  <div>Active node: <span id="echoActive">-</span></div>

</body>
</html>