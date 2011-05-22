/**
 * Este script es el encargado de manejar la creacion de las tablas de 
 * categorias de mercado libre y la navegacion entre las mismas.
 */

$(document).ready(function(){
	var infoCategory = $.parseJSON($("#categoryInfo").val());
	setTitle("Subcategorias de: " + infoCategory.name);
	setBackLink();
	createCategoryInfoTable(infoCategory);	
});
	
function setBackLink(){
	
	$("#backLink").html("Volver");
	$("#backLink").attr("href", getBackUrl());
}

function createCategoryInfoTable(infoCategory){
	
	for(var i in infoCategory.children_categories){
		var categoriesColumn = infoCategory.children_categories[i].name + ", ";
		var url = $("#categoriesUrl").val() + infoCategory.children_categories[i].id;
		var link = getLinkForUrl(url, infoCategory.children_categories[i].name);
		var cantidadItems = infoCategory.children_categories[i].total_items_in_this_category;
		appendRowToTable($("#categoryInfoTable"), createColumn(link) + createColumn(cantidadItems));		
	}	
	
}

function getBackUrl(){
	var infoCategory = $.parseJSON($("#categoryInfo").val());
	if(infoCategory.path_from_root.length == 1){
		return $("#siteUrl").val() + infoCategory.id.substring(0, 3);
		
	}else{
		return $("#categoriesUrl").val() + infoCategory.path_from_root[infoCategory.path_from_root.length - 2].id; 
	}
}
