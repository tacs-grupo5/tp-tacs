/**
 * Este script es el encargado de cargar los sitios de mercado libre en una tabla
 * y manejar la navegacion hacia cada uno de ellos.
 */

$(document).ready(function(){
	setTitle("Sitios de Mercado Libre");
	createSitesTable();
});

function createSitesTable(){
	var sites = $.parseJSON($("#sitesInfo").val());
	for(var i in sites){
		var idColumn = createColumn(sites[i].id);
		var nameColumn = createColumn(getLinkForUrl($("#siteUrl").val() + sites[i].id , sites[i].name));
		appendRowToTable($("#sitesTable"),idColumn + nameColumn);
		
	}
}