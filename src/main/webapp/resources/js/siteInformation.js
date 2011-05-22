/**
 * Este script es el encargado de crear la tabla de categorias principales
 * para un sitio en particular y manejar la navegacion hacia las subcategorias.
 */

$(document).ready(function(){
	var infoSite = $.parseJSON($("#siteInfo").val());
	setTitle("Categorias del sitio: " + infoSite.name);
	setBackLink();
	createSiteInfoTable(infoSite);			
});

function setBackLink(){
	$("#backLink").html("Volver");
	$("#backLink").attr("href", $("#sitesUrl").val());
}

function createSiteInfoTable(infoSite){
	
	for(var i in infoSite.categories){
		var categoriesColumn = infoSite.categories[i].name + ", ";
		
		var url = $("#categoryInfoUrl").val() + infoSite.categories[i].id;
		var link = getLinkForUrl(url, infoSite.categories[i].name);
		appendRowToTable($("#siteInfoTable"), createColumn(link));	
	}
	
	
}