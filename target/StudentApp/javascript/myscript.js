function crunchifyAjax() {
    	var currentSem = $('#currentSem').val();
		var branch = $('#branch').val();				
		var data = 'currentSem='
				+ encodeURIComponent(currentSem)
				+ '&branch='
				+ encodeURIComponent(branch);
		alert(data);
        $.ajax({
            url : 'getSemSubjects.std',
            //type : GET,
            data : data,
            success : function(response) {
                $('#semSubjectsDiv').html(response);
            }
        });
    }