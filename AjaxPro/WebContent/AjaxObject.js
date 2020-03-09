/*var xhr = getXMLHttp();*/

function getXMLHttp() {
	var xmlhttp = null;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		try {
			xmlhttp = new ActiveXObject(Msxml2.XMLHTTP);
		} catch (e) {
			xmlhttp = new ActiveXObject(Microsoft.XMLHTTP);
		}
	}
	return xmlhttp;
}