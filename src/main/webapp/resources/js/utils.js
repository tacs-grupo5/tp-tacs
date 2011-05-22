/**
 * 
 */

function getLinkForUrl(url, name){
	var link = '<a href=\"' + url + '\">' + name + '</a>';
	return link;
}

function createColumn(content){
	return '<td>' + content + '</td>';
}

function appendRowToTable(table, rowContent){
	$(table).append('<tr>' + rowContent +'</tr>');
}

function setTitle(title){
	$("#title").html(title);
}