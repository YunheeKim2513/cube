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
		alert("�˻� ���̵� �Է�!!");
		return;
	} else if(document.getElementById("id").value.length<4||document.getElementById("id").value.length>12) {
		alert("4~12�ڷ� �Է�!!");
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
			<h3>���̵� �ߺ� �˻�</h3>
			<table width="350">
				<tr>
					<td class="td3">�˻��� ���̵� �Է��ϼ���</td>
				</tr>
				<tr>
					<td class="td3">(4~12�ڷ� �Է��ϼ���.)</td>
				</tr>
				<tr>
					<td class="td4" style="text-align: center"><input type="text"
						name="id" id="id"
						onkeypress="javascript:if(event.keyCode == 13){ idcheck(); }">
						<input type="button" value="�˻�" onclick="javascript:idcheck();">
					</td>
				</tr>
				<%
					String id = request.getParameter("id");
					if (id == null) {
				%>
				<tr>
					<td class="td4">�˻��� ���̵� ��Ȯ�� �Է��� �� �˻� ��ư�� Ŭ���ϼ���..</td>
				</tr>
				<%
					} else {
						int count = Integer.parseInt(request.getParameter("count"));
						if(count==0){
				%>
				<tr>
					<td class="td4"><b><%=id%></b>�� ��� ���� �մϴ�.</td>
					<input type="button" value="���" onclick="javascript:iduse('<%=id%>');">
				</tr>
				<%} else { %>
				<tr>
					<td class="td4"><b><%=id%></b>�� ��� �� �� �����ϴ�.<br> �ٸ� ���̵�� �˻��ϼ���.</td>
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