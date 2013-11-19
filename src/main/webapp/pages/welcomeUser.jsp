<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
	<h1>Struts 2 Hello World Example</h1>
 
	<h4>
		Hello
		<s:property value="username" />
	</h4>
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>Last Login</th>
		</tr>
	<s:iterator value="list" var="users">
		<tr>
			<td><s:property value="#users.userName"/></td>
		    <td><s:property value="#users.lastLogin"/></td>
	    </tr>
	</s:iterator>
	</table>
	<h3></h3>
 
</body>
</html>