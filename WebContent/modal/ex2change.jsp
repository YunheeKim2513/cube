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
           
            //��������
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
          
           //��������            
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
          console.log(jsonInfo.substring(8,jsonInfo.length-1)); //������ f12������ ��忡�� confole�� Ȯ�� ����
          alert(jsonInfo);
        });
         
      });
       
      </script>
</head>
<body>
	<br>
	<br>
	<a id="checkJson" style="cursor: pointer">Ȯ��</a>
</body>
</html>
