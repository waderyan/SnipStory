
$(function () {

	$("#signup-btn").click(function () {
		var emailfield = $("#invite-email-field");
		var namefield = $("#invite-name-field");
		var form = $("#invite-form");

		function validateEmail (emailCan) {
			var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    		return re.test(emailCan);
		}

		function validateName (nameCan) {
			return nameCan != null && nameCan.trim() != "";
		}

		if ( !validateEmail(emailfield.val()) ) {
			emailfield.css("border-color","red");
			if ( !validateName(namefield.val())) {
				namefield.css("border-color", "red");
			}
			return;
		}

		function thankUser () {
			form.empty();
			form.append(
				'<h2 class="form-signup-heading">Thank you!</h2>' +
				'<div id="joined-thankyou">' + 
					'<h4>We\'ll be contacting you soon. Contact us at <a href="mailto:snipstory@gmail.com">snipstory@gmail.com</a></h4>' +
					'<div>' + 
						'<a class="pull-left btn btn-large btn-primary" href="#learnMore">Learn More Below.</a>' + 
						//'<button id="pull-right share-btn" class="btn btn-large btn-primary">Share.</button>' + 
					'</div>' +
				'</div>'
			);
		}

		$.ajax({
			type: "POST",
			url: "http://" + document.location.host + "/admin/addInvitee",
			data: {
				name: namefield.val(),
				email: emailfield.val()
			},
			success: function () {
				thankUser();
			},
			error: function (xhr) {
				thankUser();
			}

		});
	});

	function LearnMoreInfo (heading, txt, imgsrc, btnPrompt) {
		var imgFolder = '/assets/images/landing/'

		this.heading = heading;
		this.txt = txt;
		this.imgsrc = imgFolder + imgsrc;
		this.headingId = heading.replace(/ /g,'');
		this.btnPrompt = btnPrompt;
	}

	function createLearnMoreRow (info, side) {

		function createFeedbackForm (headingId) {

			var formid = headingId;
			var feedbackDiv = $('<div class="feedback"></div>');
			// TODO this is temporary - we should be able to track them with cookies.
			var email = $('<input id="email-comments' + formid + '" type="text" class="input-block-level" placeholder="Email Address">');
			var commentBox = $('<textarea maxlength="255" rows="3" id="commentBox' + formid + '" placeholder="' + info.btnPrompt + '"></textarea>');
			var submitBtn = $('<button class="btn btn-success btn-large">Send</button>');
			submitBtn.click(function() {

				function thankUser () {
					feedbackDiv.empty();
					feedbackDiv.append(
						'<h3>Thank you!</h3>' +
						'<h4>Your feedback is greatly appreciated.</h4>'
					);
				}

				var email = $('#email-comments' + formid);
				var comments = $('#commentBox' + formid);

				if (email.val() == null || email.val().trim() == "") {
					email.css("border-color","red");
					if (comments.val() == null || comments.val().trim() == "") {
						comments.css("border-color", "red");
					}
					return;
				}

				console.log(headingId);

				$.ajax({
					url: "http://" + document.location.host + "/admin/addFeedback",
					type: "POST",
					data: {
						email : email.val(),
						feature: headingId,
						details: comments.val()
					},
					success: function () {
						thankUser();
					},
					error: function (xhr) {
						console.log("failure!");
						thankUser();
					}
				});
			});

			feedbackDiv.append(email);
			feedbackDiv.append(commentBox);
			feedbackDiv.append(submitBtn);

			return feedbackDiv;
		}

		var row = $(document.createElement('div'));
		row.addClass('row-fluid border');

		var item = $('<div></div>').addClass('span6 padded text-left ' + ((side == 'left') ? 'offset1' : ''));
		item.append('<h2>' + info.heading + '</h2>');
		item.append('<p>' + info.txt + '</p>');

		var btn = $('<button>' + info.btnPrompt + '</button>');
		btn.addClass('btn btn-primary btn-large');
		btn.click(function () {
			_gaq.push(['_trackEvent', 'btn-' + info.headingId, 'clicked']);
			$(btn).replaceWith(createFeedbackForm(info.headingId));
		});

		item.append(btn);
		
		var imgDiv = $('<div><img src="' + info.imgsrc + '"></div>');
		imgDiv.addClass('span5 padded' + ((side == 'left') ? 'offset1' : ''));

		if (side == 'left') {
			row.append(item);
			row.append(imgDiv);
		} else {
			row.append(imgDiv);
			row.append(item);
		}

		return row;
	}

	function shuffle(arr) {
		var currentIndex = arr.length,
			tempVal,
			randIndex;

		while (0 != currentIndex) {
			randIndex = Math.floor(Math.random() * currentIndex);
			currentIndex -= 1;

			tempVal = arr[currentIndex];
			arr[currentIndex] = arr[randIndex];
			arr[randIndex] = tempVal;
		}

		return arr;
	}

	var info = [
		new LearnMoreInfo (
			'Intuitively Organized'
			, 'We let you organize your memories the same way that you remember them. Arrange your memories based on what makes sense to you, not based on the sizes of the shoeboxes in your attic.'
			, 'LearnMoreOrganize.png'
			, 'Tell us how you organize your life story.'
		), new LearnMoreInfo (
			'Made to be Shared'
			, 'No one likes to play alone, so share your events with friends and family through social media or email. Or link events together with your friends and family to create stories collaboratively.'
			, 'LearnMoreCollaborate.png'
			, 'Who do you want to share with?'
		), new LearnMoreInfo (
			'Simple to Print'
			, 'Creating hard copies of your digital memories couldn’t be simpler. Print specific events or all of them. Print it yourself or let us do it and we’ll ship it to you for free.'
			, 'LearnMorePrint.png'
			, 'What formats would you like?'
		), new LearnMoreInfo (
			'Enhance your Timeline'
			, 'Pictures, Video, Audio, or Text--whatever form your life takes, we can handle it. Our audio captioning feature allows you to record every detail without ever touching a keyboard.'
			, 'LearnMoreMedia.png'
			, 'What is important for you to save?'
		), new LearnMoreInfo (
			'Easy as Pie'
			, 'We use large icons, simple menus, and drag-and-drop functionality to make recording your memories easy. Feel like an expert from your first time on the site.'
			, 'LearnMorePie.png'
			, 'What makes an app easy for you?'
		), new LearnMoreInfo (
			'For the Road'
			, 'Have some downtime in the airport? Our mobile app brings your life to your phone.  Easily record or enhance the details of your events on the go.'
			, 'LearnMoreMobile.png'
			, 'How would you go mobile?'
		)
	];

	var view = $('#learnMore');
	view.addClass('landing-main container-fluid');

	info = shuffle(info); 

	info.forEach(function (item, index) {
		view.append(createLearnMoreRow(item, index % 2 == 0 ? 'left' : 'right'));
	});
});

