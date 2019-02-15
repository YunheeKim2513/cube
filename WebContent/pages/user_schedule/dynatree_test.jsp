<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/common/user_public.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<input type="button" class="btn btn-primary" id="participant_button" value="조회" onclick="" style="width:60px; height:35px; padding-top: 7px;" data-toggle="modal" data-target="#participant">
	<div class="modal fade" id="participant" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="padding-right: 30px">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">일정 등록</h4>
				</div>
				<div class="modal-body">

					<!-- Add a <div> element where the tree should appear: -->
					<div id="tree"></div>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>

	<!-- jQuery -->
	<script src="<%=root%>/css/vendor/jquery/jquery.min.js"></script>


	<!-- Big Calendar -->
	<script type="text/javascript" src="<%=root%>/js/bigcalendar.js"></script>
	<link href='<%=root%>/css/calendar/fullcalendar.css' rel='stylesheet' />
	<link href='<%=root%>/css/calendar/fullcalendar.print.css'
		rel='stylesheet' media='print' />
	<script src='<%=root%>/lib/moment.min.js'></script>
	<script src='<%=root%>/lib/jquery.min.js'></script>
	<script src='<%=root%>/js/calendar/fullcalendar.min.js'></script>





	<!-- Bootstrap Core JavaScript -->
	<script src="<%=root%>/css/vendor/bootstrap/js/bootstrap.min.js"></script>


	<!-- Metis Menu Plugin JavaScript -->
	<script src="<%=root%>/css/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script
		src="<%=root%>/css/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=root%>/css/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="<%=root%>/css/vendor/datatables-responsive/dataTables.responsive.js"></script>


	<!-- Custom Theme JavaScript -->
	<script src="<%=root%>/css/dist/js/sb-admin-2.js"></script>
<!-- Include the required JavaScript libraries: -->
<script src="<%=root%>/modal/jquery2/jquery/jquery.js" type="text/javascript"></script>
<script src="<%=root%>/modal/jquery2/jquery/jquery-ui.custom.js"
	type="text/javascript"></script>
<script src="<%=root%>/modal/jquery2/jquery/jquery.cookie.js"
	type="text/javascript"></script>

<link href="<%=root%>/modal/jquery2/src/skin-vista/ui.dynatree.css"
	rel="stylesheet" type="text/css">
<script src="<%=root%>/modal/jquery2/src/jquery.dynatree.js"
	type="text/javascript"></script>

<!-- Add code to initialize the tree when the document is loaded: -->
<script type="text/javascript">
	$(function() {
		// Attach the dynatree widget to an existing <div id="tree"> element
		// and pass the tree options as an argument to the dynatree() function:
		$("#tree").dynatree({
			onActivate : function(node) {
				alert("1");
				// A DynaTreeNode object is passed to the activation handler
				// Note: we also get this event, if persistence is on, and the page is reloaded.
				alert("You activated " + node.data.title);
			},
			persist : true,
			children : [ // Pass an array of nodes.
			{
				title : "Item 1"
			}, {
				title : "Folder 2",
				isFolder : true,
				children : [ {
					title : "Sub-item 2.1"
				}, {
					title : "Sub-item 2.2"
				} ]
			}, {
				title : "Item 3"
			} ]
		});
	});
</script>

</body>
</html>

