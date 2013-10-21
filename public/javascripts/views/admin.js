$(function () {

	$('#refresh').click(function() {
		var table = $("#invitee-table");
		table.empty();

		function populateTable (tableItems) {
			for (var i = 0; i < tableItems.length; i++) {
				var email = tableItems[i].email;
				var name = tableItems[i].name;
				table.append(
					'<tr>' +
						'<td>' + (i+1) + '</td>' +
						'<td>' + name + '</td>' +
						'<td><a href="mailto:'+ name + '">' + name + '</a></td>' +
					'</tr>'
				);
			}
		}

		$.ajax({
			type: 'GET',
			dataType: "json",
			url: 'http://' + document.location.host + '/admin/invitees',
			success: function (data) {
				populateTable(data)
			},
			error: function(xhr) {
				console.log("ERROR!");
				console.dir(xhr);
			}
		});
	});
});