$(function () {

	$('#refresh-invitees').click(function() {
		var table = $("#invitee-table");
		table.empty();

		function populateTable (tableItems) {
			for (var i = 0; i < tableItems.length; i++) {
				var email = tableItems[i].email;
				var name = tableItems[i].name;
				var createdAt = tableItems[i].createdat;
				table.append(
					'<tr>' +
						'<td>' + (i+1) + '</td>' +
						'<td>' + name + '</td>' +
						'<td><a href="mailto:'+ email + '">' + email + '</a></td>' +
						'<td>' + createdAt + '</td>' +
					'</tr>'
				);
			}
		}

		$.ajax({
			type: 'GET',
			dataType: "json",
			url: 'http://' + document.location.host + '/admin/invitees',
			success: function (data) {
				populateTable(data);
				$("#invitees-table").tablesorter( {sortList: [[3,1]], widgets: ['zebra']} );
			},
			error: function(xhr) {
				console.log("ERROR!");
				console.dir(xhr);
			}
		});
		$("#invitees-table").trigger("update");	// don't reinitialize tablesorter again, just update
	});

	$('#refresh-feedback').click(function() {
		var table = $("#feedback-table");
		table.empty();

		function populateTable (tableItems) {
			tableItems.forEach(function (item, i) {
				table.append(
					'<tr>' +
						'<td>' + (i+1) + '</td>' +
						'<td>' + item.feature + '</td>' +
						'<td><a href="mailto:'+ item.email + '">' + item.email + '</a></td>' +
						'<td>' + item.feedback + '</td>' +
					'</tr>'
				);
			});
		}

		$.ajax({
			type: 'GET',
			dataType: "json",
			url: 'http://' + document.location.host + '/admin/feedback',
			success: function (data) {
				populateTable(data);
				$("#feedbacks-table").tablesorter( {sortList: [[1,0]], widgets: ['zebra']} );
			},
			error: function(xhr) {
				console.log("ERROR!");
				console.dir(xhr);
			}
		});
		$("#feedbacks-table").trigger("update");
	});


	// Populate tables on page load.
	$('#refresh-feedback').click();
	$('#refresh-invitees').click();


});