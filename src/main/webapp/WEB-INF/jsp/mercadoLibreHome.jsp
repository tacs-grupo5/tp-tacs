<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ml</title>
    <spring:url value="/resources" var="resourcesUrl" />
    <script type="text/javascript" src="${resourcesUrl}/js/jquery-1.5.1.min.js"></script>
    <script type="text/javascript" src="${resourcesUrl}/js/chico-min-0.6.4.js"></script>
    <script type="text/javascript" src="${resourcesUrl}/js/mercadoLibreHome.js"></script>
    <link type="text/css" rel="Stylesheet" href="${resourcesUrl}/css/chico-mesh.css" />
    <link type="text/css" rel="Stylesheet" href="${resourcesUrl}/css/mercadoLibreHomeStyle.css" />
    <link rel="stylesheet" href="http://chico-ui.com.ar/sites/all/themes/chico/css/chico.css">    
  
</head>
<body>
    <div id="ml">
        <div class="header">
            <div class="ch-g5-8">
                <div class="leftcolumn box">
                    <div class="ch-g1-10">
                        Path:
                    </div>
                    <div class="paises ch-g2-10">
                    </div>
                    <div class="path ch-g7-10">
                    </div>
                </div>
            </div>
            <div class="search ch-g3-8">
                <div class="rightcolumn box">
                    <label for="txtSearch">
                        Buscar
                    </label>
                    <input type="text" name="txtSearch" class="mlTxtSearch" />
                    <input type="button" name="btnSearch" value="Buscar" class="btn mlBtnSearch" />
                </div>
            </div>
            <div class="clearfix">
            </div>
        </div>
        <div>
            <div class="categories ch-g1-4">
                <div class="leftcolumn box">
                    <h5>
                        Categorías
                    </h5>
                    <ul>
                    </ul>
                </div>
            </div>
            <div class="items ch-g3-4">
                <div class="rightcolumn box">
                    <h5>
                        Items <span class="itemsCount"></span>
                    </h5>
                    <ul class="listado">
                    </ul>
                </div>
            </div>
            <div class="clearfix">
            </div>
        </div>
    </div>
</body>
</html>