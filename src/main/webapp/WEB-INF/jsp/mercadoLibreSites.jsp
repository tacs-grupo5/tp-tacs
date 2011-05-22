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
<script type="text/javascript" src="${resourcesUrl}/js/mercadoLibreSites.js"></script>
<link rel="stylesheet" href="${resourcesUrl}/css/estilos.css" />

</head>

<body>
	<input type="hidden" id="siteUrl" value='<spring:url value="/site/" />' />
	<input type="hidden" id="sitesInfo" value='${sites}' />
	<h1 id="title"></h1>
	<table id="sitesTable">
		<tr>
			<th>Id</th>
			<th>Nombre</th>		
		</tr>
	</table>
</body>
</html>