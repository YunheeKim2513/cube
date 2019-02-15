<?xml version="1.0" encoding="EUC-KR"?>
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.User_timeDto"%> 
<%
System.out.println("test");
String root=request.getContextPath();
List<User_timeDto> list=(List<User_timeDto>)request.getAttribute("timelist");
%>   
<!DOCTYPE schedulelist SYSTEM "<%=root%>/xml/schedule.dtd">
<timelist>
	<%for(User_timeDto user_timeDto : list) {%>
	<time>
		<intime>[출근] <%=user_timeDto.getUsercheckin_time() %></intime>
		<outtime>[퇴근] <%=user_timeDto.getUsercheckout_time() %></outtime>
		<startdate><%=user_timeDto.getUsercheckin_date() %></startdate>
		<enddate><%=user_timeDto.getUsercheckout_date() %></enddate>
	</time>
	<%} %>
</timelist>