<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tacs web application</title>
<script type="text/javascript" src="resources/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="resources/js/test.js"></script>

<script>
	$(document).ready(function(){
		var sites = eval('${sites}');
		for(var i in sites){
			$("#sitesTable").append('<tr><td>' + eval(sites[i]).id + 
					'</td><td>' + eval(sites[i]).name + "</td></tr>");
		}
	});
</script>
</head>

<body>
	<table id="sitesTable" border="1px;">
		<tr style="background: blue;color:white;">
			<td>Id</td>
			<td>Nombre</td>		
		</tr>
	</table>
</body>
</html>