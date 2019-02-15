<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.cube.util.*"%>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=root %>/css/admin_companyinfo/check/style.css" type="text/css">
<script type="text/javascript">
function idcheck(){
	if(document.getElementById("id").value == "") {
		alert("검색 아이디 입력!!");
		return;
	} else if(document.getElementById("id").value.length<4||document.getElementById("id").value.length>12) {
		alert("4~12자로 입력!!");
		return;
	}else {
		document.idform.action = "<%=root%>/emp";
		document.idform.submit();
	}
}

function iduse(id) {
	//opener.document.joinform.id.value=id;
	opener.document.getElementById("employee_id").value=id;
	self.close();
}
</script>
</head>
<body>
	<center>
		<form name="idform" method="get" action="" onsubmit="return false;">
			<input type="hidden" name="act" value="idcheck">
			<h3>아이디 중복 검사</h3>
			<table width="350">
				<tr>
					<td class="td3">검색할 아이디를 입력하세요</td>
				</tr>
				<tr>
					<td class="td3">(4~12자로 입력하세요.)</td>
				</tr>
				<tr>
					<td class="td4" style="text-align: center"><input type="text"
						name="id" id="id"
						onkeypress="javascript:if(event.keyCode == 13){ idcheck(); }">
						<input type="button" value="검색" onclick="javascript:idcheck();">
					</td>
				</tr>
				<%
					String id = request.getParameter("id");
					if (id == null) {
				%>
				<tr>
					<td class="td4">검색할 아이디를 정확히 입력한 후 검색 버튼을 클릭하세요..</td>
				</tr>
				<%
					} else {
						int count = Integer.parseInt(request.getParameter("count"));
						if(count==0){
				%>
				<tr>
					<td class="td4"><b><%=id%></b>는 사용 가능 합니다.</td>
					<input type="button" value="사용" onclick="javascript:iduse('<%=id%>');">
				</tr>
				<%} else { %>
				<tr>
					<td class="td4"><b><%=id%></b>는 사용 할 수 없습니다.<br> 다른 아이디로 검색하세요.</td>
					<%
					}
				}
					%>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>