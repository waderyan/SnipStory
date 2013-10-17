$(function () {

	$('#refresh').click(function() {
		var table = $("#invitee-table");
		table.empty();

		function populateTable (tableItems) {
			for (var i = 0; i < tableItems.length; i++) {
				table.append(
					'<tr>' +
						'<td>' + (i+1) + '</td>' +
						'<td>' + tableItems[i].name + '</td>' +
						'<td>'+ tableItems[i].email + '</td>' +
					'</tr>'
				);
			}
		}

		$.ajax({
			type: 'GET',
			dataType: "json",
			url: 'http://localhost:9000/admin/invitees',
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