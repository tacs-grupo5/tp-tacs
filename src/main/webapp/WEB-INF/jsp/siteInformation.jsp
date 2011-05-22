<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources" var="resourcesUrl" />
<script type="text/javascript" src="${resourcesUrl}/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="${resourcesUrl}/js/utils.js"></script>
<script type="text/javascript" src="${resourcesUrl}/js/siteInformation.js"></script>

<title>Insert title here</title>
</head>
<body>
	<input type="hidden" id="categoryInfoUrl" value='<spring:url value="/categories/" />' />
	<input type="hidden" id="siteInfo" value='${siteInfo}' />
	<h1 id="title"></h1>
	<table id="siteInfoTable">
		<tr>
			<td>Categorias</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	
</body>
</html>
