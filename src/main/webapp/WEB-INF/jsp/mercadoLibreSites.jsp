<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-script-type" content="text/javascript">
<title>Tacs web application</title>
<spring:url value="/resources" var="resourcesUrl" />
<script type="text/javascript" src="${resourcesUrl}/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="${resourcesUrl}/js/utils.js"></script>

<script>
	$(document).ready(function(){
		var sites = eval('${sites}');
		for(var i in sites){
			var idColumn = createColumn(eval(sites[i]).id);
			var nameColumn = createColumn(getLinkForUrl('<spring:url value="/site/' + eval(sites[i]).id +'"/>', eval(sites[i]).name));
			$("#sitesTable").append('<tr>' + idColumn + nameColumn + '</tr>');
		}
	});
	
	
</script>
</head>

<body>
	<h1>Sites de Mercado Libre</h1>
	<table id="sitesTable" border="1px;">
		<tr style="background: blue;color:white;">
			<td>Id</td>
			<td>Nombre</td>		
		</tr>
	</table>
</body>
</html>