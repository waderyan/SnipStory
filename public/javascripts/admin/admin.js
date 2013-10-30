$(function () {

	$('#refresh-invitees').click(function() {
		var table = $("#invitee-table");
		table.empty();
		var totalInvitees = $("#total-invitees");
		totalInvitees.empty();
		var pages = $("#show-pages");
		pages.empty();

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
			totalInvitees.append("(" + tableItems.length + ")");
		}

		$.ajax({
			type: 'GET',
			dataType: "json",
			url: 'http://' + document.location.host + '/admin/invitees',
			success: function (data) {
				populateTable(data);
			},
			error: function(xhr) {
				console.log("ERROR!");
				console.dir(xhr);
			}
		});
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
			},
			error: function(xhr) {
				console.log("ERROR!");
				console.dir(xhr);
			}
		});
	});

	$('#sort-a').click(function() {
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
			url: 'http://' + document.location.host + '/admin/invitees/sortNameA',
			success: function (data) {
				populateTable(data);
			},
			error: function(xhr) {
				console.log("ERROR!");
				console.dir(xhr);
			}
		});

	});

	$('#sort-z').click(function() {
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
			url: 'http://' + document.location.host + '/admin/invitees/sortNameZ',
			success: function (data) {
				populateTable(data);
			},
			error: function(xhr) {
				console.log("ERROR!");
				console.dir(xhr);
			}
		});

	});

	$('#sort-recent').click(function() {
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
			url: 'http://' + document.location.host + '/admin/invitees/sortRecent',
			success: function (data) {
				populateTable(data);
			},
			error: function(xhr) {
				console.log("ERROR!");
				console.dir(xhr);
			}
		});

	});

	$('#sort-first').click(function() {
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
			url: 'http://' + document.location.host + '/admin/invitees/sortFirst',
			success: function (data) {
				populateTable(data);
			},
			error: function(xhr) {
				console.log("ERROR!");
				console.dir(xhr);
			}
		});

	});

	// Populate tables on page load.
	$('#refresh-feedback').click();
	$('#refresh-invitees').click();

});