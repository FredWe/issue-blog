function $(id) {
	return typeof id === "string" ? document.getElementById(id) : id;
}
var Util = (function(document, util) {
	util = util || {};

	util.addEventListener = function(element, type, listener) {
		if (element.addEventListener) {
			element.addEventListener(type, listener, false);
		} else {
			element.attachEvent('on' + type, listener);
		}
	}
	return util;
})(document, Util);