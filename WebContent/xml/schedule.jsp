<?xml version="1.0" encoding="EUC-KR"?>
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.List, com.cube.model.dto.ScheduleDto"%> 
<%
String root=request.getContextPath();
List<ScheduleDto> list=(List<ScheduleDto>)request.getAttribute("schedulelist");
%>   
<!DOCTYPE schedulelist SYSTEM "<%=root%>/xml/schedule.dtd">
<schedulelist>
	<%for(ScheduleDto scheduleDto : list) {%>
	<schedule>
		<id><%=scheduleDto.getEmployee_id() %></id>
		<seq><%=scheduleDto.getSchedule_seq() %></seq>
		<subject><%=scheduleDto.getSchedule_subject() %></subject>
		<content><%=scheduleDto.getSchedule_content() %></content>
		<startdate><%=scheduleDto.getSchedule_startdate() %></startdate>
		<enddate><%=scheduleDto.getSchedule_enddate() %></enddate>
		<participant><%=scheduleDto.getSchedule_participant() %></participant>
		<kind><%=scheduleDto.getSchedule_kind() %></kind>
	</schedule>
	<%} %>
</schedulelist>