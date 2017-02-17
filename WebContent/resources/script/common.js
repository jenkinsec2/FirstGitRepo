

var curDt = new Date();
function disablementFunction(day){       
    if (curDt==undefined){
        curDt = day.date.getDate();
    }
    return (curDt.getTime() - day.date.getTime() > 0);
}

function scalePage(){
	var hgt=jQuery(window).height()-jQuery("#header").height();
	jQuery("#page").css({'height' : hgt + 'px'});
	jQuery("#page-content").css({'height' : hgt + 'px'});
    jQuery("#page-content .content-container").css({'height': (hgt-40) + 'px' });
    jQuery("#page-content .left-menu").css({'height': hgt + 'px'});
}

function formatSSN(obj, e) {
	var key = e.keyCode || e.charCode;
	if (key != 8) {
		var ssnVal = obj.value;
		var ssnLength = ssnVal.length;
		if (ssnLength == 3 || ssnLength == 6) {
			ssnVal = ssnVal + "-";
			obj.value = ssnVal;
		}
	}
}
