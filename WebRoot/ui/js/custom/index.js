jQuery(document).ready(function(){
								
	///// TRANSFORM CHECKBOX /////							
	jQuery('input:checkbox').uniform();
	if(jQuery('#actionmsg').html() != ''){
		jQuery('.nousername').fadeIn();
		jQuery('#jsmsg').hide();
	}
	///// LOGIN FORM SUBMIT /////
	jQuery('#login').submit(function(){
		if(jQuery.trim(jQuery('#username').val()) == '' || jQuery.trim(jQuery('#password').val()) == '') {
			jQuery('.nousername').fadeIn();
			jQuery('#jsmsg').html('用户名或密码不能为空！');
			jQuery('#jsmsg').fadeIn();
			jQuery('#actionmsg').hide();
			return false;
		}
	});
	
	///// ADD PLACEHOLDER /////
	jQuery('#username').attr('placeholder','用户名');
	jQuery('#password').attr('placeholder','密码');
});
