<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
String root = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
  <title>Dynatree - Example</title>

  <script src="<%=root %>/modal/jquery/jquery.js" type="text/javascript"></script>
  <script src="<%=root %>/modal/jquery/jquery-ui.custom.js" type="text/javascript"></script>
  <script src="<%=root %>/modal/jquery/jquery.cookie.js" type="text/javascript"></script>

  <link href="<%=root %>/modal/src/skin-vista/ui.dynatree.css" rel="stylesheet" type="text/css">
  <script src="<%=root %>/modal/src/jquery.dynatree.js" type="text/javascript"></script>

  <!-- (Irrelevant source removed.) -->

<script type="text/javascript">
  $(function(){
    // Initialize the tree inside the <div>element.
    // The tree structure is read from the contained <ul> tag.
    $("#tree").dynatree({
      title: "Programming Sample",
      onActivate: function(node) {
        $("#echoActive").text(node.data.title);
//        alert(node.getKeyPath());
        if( node.data.url )
          window.open(node.data.url, node.data.target);
      },
      onDeactivate: function(node) {
        $("#echoSelected").text("-");
      },
      onFocus: function(node) {
        $("#echoFocused").text(node.data.title);
      },
      onBlur: function(node) {
        $("#echoFocused").text("-");
      },
      onLazyRead: function(node){
        var fakeJsonResult = [
          { title: 'Lazy node 1', isLazy: true },
          { title: 'Simple node 2', select: true }
        ];
//        alert ("Let's pretend we're using this AJAX response to load the branch:\n " + jsonResult);
        function fakeAjaxResponse() {
          return function() {
            node.addChild(fakeJsonResult);
            // Remove the 'loading...' status:
            node.setLazyNodeStatus(DTNodeStatus_Ok);
          };
        }
        window.setTimeout(fakeAjaxResponse(), 1500);
      }
    });
    $("#btnToggleExpand").click(function(){
        $("#tree").dynatree("getRoot").visit(function(node){
          node.toggleExpand();
        });
        return false;
      });
      $("#btnCollapseAll").click(function(){
        $("#tree").dynatree("getRoot").visit(function(node){
          node.expand(false);
        });
        return false;
      });
  });    
</script>
</head>

<body class="example">
    <a href="#" id="btnExpandAll">Expand all</a> -
    <a href="#" id="btnCollapseAll">Collapse all</a> -
  <div id="tree1">
    <ul>
      
      <li id="id5" class="expanded folder">Advanced examples
        <ul>
          <li data="key: 'node5.1'">item5.1: Using data attribute as an alternative way to specify a key.
          <li data="key: 'node5.3', isFolder: true">item5.1: Using data attribute as an alternative way to specify a folder.
          <li id="id5.2">Sub-item 5.2
          <li>Item without a key. Keys are optional (generated automatically), but may be used in the callbacks
        </ul>
    </ul>
  </div>
  <div id="tree2">
    <ul>
      
      <li id="id5" class="expanded folder">Advanced examples
        <ul>
          <li data="key: 'node5.1'">item5.1: Using data attribute as an alternative way to specify a key.
          <li data="key: 'node5.3', isFolder: true">item5.1: Using data attribute as an alternative way to specify a folder.
          <li id="id5.2">Sub-item 5.2
          <li>Item without a key. Keys are optional (generated automatically), but may be used in the callbacks
        </ul>
    </ul>
  </div>
  <div>Active node: <span id="echoActive">-</span></div>
  <div>Focused node: <span id="echoFocused">-</span></div>
  <!-- (Irrelevant source removed.) -->
</body>
</html>