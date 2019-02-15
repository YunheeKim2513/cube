<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.cube.model.dto.DiligencegroupDto, com.cube.model.dto.Admin_timeSelectDto, com.cube.model.dto.EmployeesDto, com.cube.model.dto.Admin_timeSelectDto"%>
<%@ include file="/common/admin_public.jsp"%>
<%
	List<DiligencegroupDto> list = (List<DiligencegroupDto>) request.getAttribute("diligencegroup");

   List<Admin_timeSelectDto> admintime_list = (List<Admin_timeSelectDto>) request.getAttribute("admin_timeselectlist");
%>
<!DOCTYPE memberlist SYSTEM "<%=root%>/xml/diligence.dtd">

<diligencelist>
<%
for(DiligencegroupDto giligencegroupDto : list){//향상된 for문
%>	
	<diligence>
	
		<group_standard><%=giligencegroupDto.getGroup_standard()%></group_standard>
		
		
	</diligence>
<%	
	}
%>	
</diligencelist>