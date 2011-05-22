/**
 * Este script es el encargado de manejar la creacion de las tablas de 
 * categorias de mercado libre y la navegacion entre las mismas.
 */

$(document).ready(function(){
	var infoCategory = $.parseJSON($("#categoryInfo").val());
	setTitle("Subcategorias de: " + infoCategory.name);
	createCategoryInfoTable(infoCategory);	
});
	
function createCategoryInfoTable(infoCategory){
	
	for(var i in infoCategory.children_categories){
		var categoriesColumn = infoCategory.children_categories[i].name + ", ";
		var url = $("#categoriesUrl").val() + infoCategory.children_categories[i].id;
		var link = getLinkForUrl(url, infoCategory.children_categories[i].name);
		var cantidadItems = infoCategory.children_categories[i].total_items_in_this_category;
		appendRowToTable($("#categoryInfoTable"), createColumn(link) + createColumn(cantidadItems));
		
	}	
	
}