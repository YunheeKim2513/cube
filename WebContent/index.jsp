<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"  import="com.cube.model.dto.EmployeesDto"%>
<% 
String root = request.getContextPath();
%>

<%

	response.sendRedirect(root + "/login?act=loginPage"); 
%>