<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.cube.util.Encoder, com.cube.util.UrlFormat, com.cube.model.dto.Confirmlist_infoDto"%>
<%

//Confirmlist_infoDto confirmlist_infoDto = (Confirmlist_infoDto) request.getAttribute("confirmline");
//String confrimline = confirmlist_infoDto.getConfirmlist1() +"/"+confirmlist_infoDto.getConfirmlist2()+"/"+confirmlist_infoDto.getConfirmlist3();
//System.out.println("결재선인원전부"+confrimline);
String confirmline = Encoder.isoToUtf(request.getParameter("confirmline"));
System.out.println("체크까지는"+confirmline);

%>

<%=confirmline%>
