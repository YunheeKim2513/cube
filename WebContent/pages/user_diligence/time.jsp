<%@page import="com.sun.rowset.internal.Row"%>
<%@page import="com.sun.xml.internal.ws.util.StringUtils"%>
<%@ page language="java" contentType="text/plain; charset=EUC-KR"
    pageEncoding="EUC-KR" import = "java.util.*, java.text.*"%>
<%
response.setDateHeader("Expires", 0);
response.setHeader("Pragma", "no-cache");
if (request.getProtocol().equals("HTTP/1.1")) {
 response.setHeader("Cache-Control", "no-cache");
}

DateFormat dateFormat = new SimpleDateFormat("a h:mm:ss");
String time = dateFormat.format(new Date());
//System.out.println(time);






%>
<%=time %>
