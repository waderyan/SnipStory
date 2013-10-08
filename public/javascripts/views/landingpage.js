
$(function () {
	$("#signup-btn").click(function () {
		var emailfield = $("#invite-email-field");
		var namefield = $("#invite-name-field");

		function validateEmail (emailCan) {
			// obtained from http://stackoverflow.com/questions/46155/validate-email-address-in-javascript
			var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    		return re.test(emailCan);
		}

		function validateName (nameCan) {
			return nameCan != null && nameCan.trim() != "";
		}

		if (!validateEmail(emailfield.val()) || !validateName(namefield.val())) {
			alert ("Please fill out proper name and email");
			emailfield.val("");
			namefield.val("");
			return;
		}

		$.ajax({
			type: "POST",
			url: "http://localhost:9000/admin/addInvitee",
			data: {
				name: namefield.val(),
				email: emailfield.val()
			},
			success: function (xhr) {
				console.log("Successfully submitted to db");
				console.dir(xhr);
			},
			error: function (xhr) {
				console.log("failure!");
				console.dir(xhr);
			}

		});
	});
});

