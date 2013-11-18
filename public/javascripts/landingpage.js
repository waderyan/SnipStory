
$(function () {

	function invokeAdwordConversionEvent() {
		trackConv(1019536516, 'nXXlCJTIvwgQhMmT5gM');
	}

	$("#signup-btn").click(function () {
		var emailfield = $("#invite-email-field");
		var namefield = $("#invite-name-field");
		var form = $("#invite-form");

		if ( !FormValidation.validateEmail(emailfield.val()) ) {
			emailfield.css("border-color","red");
			if ( !FormValidation.validateName(namefield.val())) {
				namefield.css("border-color", "red");
			}
			return;
		}

		function thankUser () {
			form.empty();
			form.append(
				'<h2 class="form-signup-heading">Thank you!</h2>' +
				'<div id="joined-thankyou">' + 
					'<h4 class="form-signup-heading">We\'ll be contacting you soon. Contact us at <a href="mailto:snipstory@gmail.com">snipstory@gmail.com</a></h4>' +
					'<div>' + 
						'<a class="landing-btn pull-left btn btn-large btn-primary" href="#learnMore">Learn More Below.</a>' + 
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
				email: emailfield.val(),
				landingSite: document.location.pathname + ''
			},
			success: function () {
				thankUser();
				invokeAdwordConversionEvent();
			},
			error: function (xhr) {
				thankUser();
			}

		});
	});

	$('#survey').click(function () {
		_gaq.push(['_trackEvent', 'survey-btn' + '-' + document.location.pathname, 'clicked']);
	});

	$('#googleplus').click(function () {
		_gaq.push(['_trackEvent', 'facebook-btn' + '-' + document.location.pathname, 'clicked']);
	});

	function FormValidation () {}

	FormValidation.validateEmail = function(emailCan) {
			var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    		return re.test(emailCan);
	}

	FormValidation.validateName = function(nameCan) {
		return nameCan != null && nameCan.trim() != "";
	}

	function CookieHandler () {}

	CookieHandler.decode = function(s) {
		return decodeURIComponent(s.replace(/\+/g, ' '));
	}

	CookieHandler.getCookieValue = function (key) {
		var cookies = document.cookie.split('; ');
		for (var i = 0, parts; (parts = cookies[i] && cookies[i].split('=')); i++) {
			if (CookieHandler.decode(parts.shift()) === key) {
				return CookieHandler.decode(parts.join('=')).replace(/"/g,'');
			}
		}
		return null;
	}

	CookieHandler.isCookie = function(key) {
		return document.cookie.indexOf(key) != -1;
	}

	function LearnMoreInfo (heading, txt, imgsrc, btnPrompt) {
		var imgFolder = '/assets/images/landing/'

		this.heading = heading;
		this.txt = txt;
		this.imgsrc = imgFolder + imgsrc;
		this.headingId = heading.replace(/ /g,'');
		this.btnPrompt = btnPrompt;
	}

	LearnMoreInfo.thankUser = function(view) {
		view.empty();
		view.append(
			'<h3>Thank you!</h3>' +
			'<h4>Your feedback is greatly appreciated.</h4>'
		);
	}

	LearnMoreInfo.submitFeedback = function(view, formid, email) {
		if (!email) {
			email = $('#email-comments' + formid).val();
		}
		var comments = $('#commentBox' + formid);

		$.ajax({
			url: "http://" + document.location.host + "/admin/addFeedback",
			type: "POST",
			data: {
				email : email,
				feature: formid,
				details: comments.val(),
				landingSite: document.location.pathname
			},
			success: function () {
				LearnMoreInfo.thankUser(view);
				if (email) invokeAdwordConversionEvent();
			},
			error: function (xhr) {
				console.log("failure!");
				LearnMoreInfo.thankUser(view);
			}
		});
	}

	LearnMoreInfo.createFeedbackForm = function (info, hasEmail) {
		var view = $('<div class="feedback"></div>');

		// Only add the email if its needed
		if (!hasEmail) {
			var email = $('<input id="email-comments' + info.headingId + '" type="text" class="landing-email input-block-level" placeholder="Email Address">');
			view.append(email);
		}
		
		// create text area
		view.append($('<textarea maxlength="255" rows="3" id="commentBox' + info.headingId + '" placeholder="' + info.btnPrompt + '"></textarea>'));

		// create submit btn
		var submitBtn = $('<button class="landing-btn btn btn-success btn-large">Send</button>');
		submitBtn.click(function() {
			LearnMoreInfo.submitFeedback(view, info.headingId, hasEmail ? CookieHandler.getCookieValue('invitee-email') : null);
		});

		view.append(submitBtn);

		return view;
	}

	LearnMoreInfo.createLearnMoreRow = function (info, side) {
		var row = $(document.createElement('div'));
		row.addClass('row-fluid border');

		// Learn More text
		var item = $('<div></div>').addClass('span6 padded text-left ' + ((side == 'left') ? 'offset1' : ''));
		item.append('<h2>' + info.heading + '</h2>');
		item.append('<p>' + info.txt + '</p>');

		// User Prompt btn
		var btn = $('<button>' + info.btnPrompt + '</button>');
		btn.addClass('landing-btn btn btn-primary btn-large');
		btn.click(function () {
			_gaq.push(['_trackEvent', 'btn-' + info.headingId + '-' + document.location.pathname, 'clicked']);
			$(btn).replaceWith(LearnMoreInfo.createFeedbackForm(info, CookieHandler.isCookie('invitee-email')));
		});

		item.append(btn);
		
		// Learn More Image
		var imgDiv = $('<div><img src="' + info.imgsrc + '"></div>');
		imgDiv.addClass('span5 padded' + ((side == 'left') ? 'offset1' : ''));

		// Alternate which side were on
		if (side == 'left') {
			row.append(item);
			row.append(imgDiv);
		} else {
			row.append(imgDiv);
			row.append(item);
		}

		return row;
	}

	LearnMoreInfo.shuffle = function(arr) {
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

	info = LearnMoreInfo.shuffle(info); 

	info.forEach(function (item, index) {
		view.append(LearnMoreInfo.createLearnMoreRow(item, index % 2 == 0 ? 'left' : 'right'));
	});
});

