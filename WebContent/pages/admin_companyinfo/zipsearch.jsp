<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.ZipDto" %>
<%
String root=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= root %>/css/admin_companyinfo/check/style.css" type="text/css">
<script type="text/javascript">
function dongcheck(){
   if(document.getElementById("dong").value == "") {
      alert("�˻� �� �Է�!");
      return;
   } else {
      document.zipform.action = "<%= root %>/emp";
      document.zipform.submit();
   }
}

function selectzip(z1, z2, address){
	console.log(z1+" "+z2+" "+address);
	opener.document.getElementById("post1").value=z1;
	opener.document.getElementById("post2").value=z2;
	opener.document.getElementById("address1").value=address;
	self.close();
}
</script>
</head>
<body>
<center>
<form name="zipform" method="get" action="">
<input type="hidden" name="act" value="zipsearch">
<h3>�����ȣ�˻�</h3>
<table width="350">
<tr>
   <td class="td3">�˻��� ���� �Է��ϼ���<br>(��: ���ﵿ, ����)</td>
</tr>
<tr>
   <td class="td4">
   <input type="text" name="dong" id="dong" onkeypress="javascript:if(event.keyCode == 13){ dongcheck(); }">
   <input type="button" value="�˻�" id="btnsearch" onclick="javascript:dongcheck();">
   </td>
</tr>
<%
String dong = (String) request.getAttribute("searchdong");
System.out.println(dong);
if(dong == null) {
%>
<tr>
   <td class="td4">
   ���̸��� ��Ȯ�� �Է��ϼ���.
   </td>
</tr>
<%
} else {
   List<ZipDto> list = (List<ZipDto>) request.getAttribute("ziplist");//����ȯ
   if(list.size() !=0) {
      for(ZipDto zipDto : list) {
%>
<tr>
   <td class="td4">
   <a href="javascript:selectzip('<%=zipDto.getZip1() %>', '<%= zipDto.getZip2() %>', 
   '<%=zipDto.getSido() %> <%= zipDto.getGugun() %> <%=zipDto.getDong() %>')">
   <%=zipDto.getZip1() %> - <%= zipDto.getZip2() %>
   <%=zipDto.getSido() %> <%= zipDto.getGugun() %> <%=zipDto.getDong() %>
   </a>
   </td>
</tr>

<tr>
<% 
      }
    } else {
%>
   <td class="td4">
   <b><%= dong %></b>�� ���� �˻� ����� �����ϴ�.<br>
   </td>
<%
}
}
%>