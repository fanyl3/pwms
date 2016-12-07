function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for(var i=0; i<ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1);
		if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
	}
	return "";
}

function CheckForm(form){
	var errmsg = document.getElementById("errmsg");
	alert(errmsg);
	errmsg.innerHTML = "";
	var username = document.getElementById("userName");
	alert(username);
	if(username.value.length == 0){
		errmsg.innerHTML = "用戶名不能为空！";
		alert("break2");
		return false;
	}
	password = document.getElementById("password");
	if(password.value.length == 0){
		errmsg.innerHTML = "密码不能为空！";
		alert("break3");
		return false;
	}
	alert("break4");
	return true;
}