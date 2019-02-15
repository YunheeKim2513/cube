<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%
	String root = request.getContextPath();
	%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script>
       
      $(function() {
         
        $("#checkJson").click(function() {
           
            //상위폴더
            var highfolderArray = new Array();
            var highfolderInfo = new Object();
            highfolderInfo.title="Folder2";
            highfolderInfo.isFolder=true;
            highfolderInfo.key = "folder2";
            highfolderArray.push(highfolderInfo);
            var highfolderInfo1 = new Object();
	        highfolderInfo1.title="Folder3";
	        highfolderInfo1.isFolder=true;
	        highfolderInfo1.key = "folder3";
	        highfolderArray.push(highfolderInfo1);
          
           //하위폴더            
            var childrenArray = new Array();
            var childrenInfo = new Object();
            childrenInfo.title = "Sub-item 2.1";
            childrenArray.push(childrenInfo);
            childrenInfo.title = "Sub-item 2.2";
            childrenArray.push(childrenInfo);
            highfolderInfo.children = childrenArray;
            
            var totalInfo = new Object();
          totalInfo.high = highfolderArray;
          var jsonInfo = JSON.stringify(totalInfo);
          console.log(jsonInfo.substring(8,jsonInfo.length-1)); //브라우저 f12개발자 모드에서 confole로 확인 가능
          alert(jsonInfo);
        });
         
      });
       
      </script>
</head>
<body>
	<br>
	<br>
	<a id="checkJson" style="cursor: pointer">확인</a>
</body>
</html>
