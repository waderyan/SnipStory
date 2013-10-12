
$(function () {
	$("#signup-btn").click(function () {
		var emailfield = $("#invite-email-field");
		var namefield = $("#invite-name-field");
		var form = $("#invite-form");

		function validateEmail (emailCan) {
			// obtained from http://stackoverflow.com/questions/46155/validate-email-address-in-javascript
			var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    		return re.test(emailCan);
		}

		function validateName (nameCan) {
			return nameCan != null && nameCan.trim() != "";
		}

		function clearForm () {
			emailfield.val("");
			namefield.val("");
		}

		if ( !validateEmail(emailfield.val()) ) {
			emailfield.css("border-color","red");
			if ( !validateName(namefield.val())) {
				namefield.css("border-color", "red");
			}
			return;
		}

		$.ajax({
			type: "POST",
			url: "http://localhost:9000/admin/addInvitee",
			data: {
				name: namefield.val(),
				email: emailfield.val()
			},
			success: function () {
				form.empty();
				form.append(
					'<h2 class="form-signup-heading">Thank you!</h2>' +
					'<h4>We\'ll be contacting you soon. ' +
						'If you have any questions or comments please contact <a href="mailto:snipstory@gmail.com">snipstory@gmail.com</a>' +
					'</h4>'
				);
			},
			error: function (xhr) {
				console.log("failure!");
				console.dir(xhr);
			}

		});
	});
});

