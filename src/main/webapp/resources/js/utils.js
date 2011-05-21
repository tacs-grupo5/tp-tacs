/**
 * 
 */

function getLinkForUrl(url, name){
	var link = '<a href=\"' + url + '\">' + name + '</a>';
	return link;
}

function createTable(sites){
	var sites = eval(sites);
	for(var i in sites){
		$("#sitesTable").append(createSiteRow(eval(sites[i])));
	}
}

function createSiteRow(site){
	var idColumn = createColumn(site.id);
	var nameColumn = createColumn(getLinkForUrl('<spring:url value="/site/' + site.id +'">', site.name));
	alert(nameColumn);
	return '<tr>' + idColumn + nameColumn + '</tr>';	
	
}

function createColumn(content){
	return '<td>' + content + '</td>';
}