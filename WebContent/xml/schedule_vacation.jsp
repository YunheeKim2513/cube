<?xml version="1.0" encoding="EUC-KR"?>
<%@page import="com.cube.model.dto.EmployeesListDto"%>
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.VacationListDto"%> 
<%
String root=request.getContextPath();
List<VacationListDto> list=(List<VacationListDto>)request.getAttribute("vacationlist");
%>   
<!DOCTYPE schedulelist SYSTEM "<%=root%>/xml/schedule.dtd">
<vacationlist>
	<%for(VacationListDto vacationListDto : list) {%>
	<vacation>
		<employee>[<%=vacationListDto.getDepartment_name() %>] <%=vacationListDto.getGrade_name() %> <%=vacationListDto.getEmployee_name() %></employee>
		<startdate><%=vacationListDto.getSchedule_startdate() %></startdate>
		<enddate><%=vacationListDto.getSchedule_enddate() %></enddate>
	</vacation>
	<%} %>
</vacationlist>