$(function () {

	function LearnMoreInfo (heading, txt, imgsrc) {
		this.heading = heading;
		this.txt = txt;
		var imgFolder = '/assets/images/landing/'
		this.imgsrc = imgFolder + imgsrc;
		this.headingId = heading.replace(/ /g,'');
	}
	
	function createLearnMoreRow (info, side) {

		function createFeedbackForm (headingId) {

			function createRating () {
				var opts = [
					'Extreme Importance',
					'High Importance',
					'Average Importance',
					'Meh Importance'
				];

				var div = $(document.createElement('div'));
				div.append('<em>How important would you rate this feature?  </em>');

				var select = $('<select id="rating"></select>');
				opts.forEach(function (opt) {
					select.append('<option>' + opt + '</option>');
				});

				div.append(select);
				return div;
			}

			var feedbackDiv = $('<div class="feedback"></div>');
			var ratingDiv = createRating();
			var commentBox = $('<textarea rows="3" id="commentBox" placeholder="Share with us your thoughts..."></textarea>');
			var submitBtn = $('<button class="btn btn-success">Submit Feedback</button>');
			submitBtn.click(function() {
				var option = $("#rating").val();
				var comments = $("#commentBox").val();

				var request = $.ajax({
					url: "http://localhost:9000/admin/addFeedback",
					type: "POST",
					data: {rating : option, details: comments},
					success: function () {
						feedbackDiv.empty();
						feedbackDiv.append(
						'<h3 class="form-signup-heading">Thank you!</h3>' +
						'<h4>Your feedback is greatly appreciated.</h4>'
						);
					},
					error: function (xhr) {
						console.log("failure!");
						console.dir(xhr);
					}
				});
			});

			feedbackDiv.append(ratingDiv);
			feedbackDiv.append(commentBox);
			feedbackDiv.append(submitBtn);

			return feedbackDiv;
		}

		var row = $(document.createElement('div'));
		row.addClass('row-fluid border');

		var item = $('<div></div>').addClass('span4 offset1 padded text-left');
		item.append('<h2>' + info.heading + '</h2>');
		item.append('<p>' + info.txt + '</p>');

		var btn = $('<button>I love this!</button>');
		btn.addClass('btn btn-default');
		btn.click(function () {
			_gaq.push(['_trackEvent', 'btn-' + info.headingId, 'clicked']);
			$(btn).replaceWith(createFeedbackForm(info.headingId));
		});

		item.append(btn);
		
		var imgDiv = $('<div><img src="' + info.imgsrc + '"></div>');
		imgDiv.addClass('span6 offset1 padded');

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
			, 'We let you organize your memories the same way that you remember them. Your Timeline is divided into Chapters (such as “College Years”), and Chapters consist of Events (like “Graduation” or “Dorm Pranks”). Arrange your memories based on what makes sense to you, not based on the sizes of the shoeboxes in your attic.'
			, 'img3.jpg'
		), new LearnMoreInfo (
			'Made to be Shared'
			, 'No one likes to play alone, so share your events with friends and family through social media or email. Or link events together with your friends and family to create stories collaboratively.'
			, 'img3.jpg'
		), new LearnMoreInfo (
			'Simple to Print'
			, 'Creating hard copies of your digital memories couldn’t be simpler. Print specific events or all of them. Print it yourself or let us do it and we’ll ship it to you for free.'
			, 'img3.jpg'
		), new LearnMoreInfo (
			'Enhance your Timeline'
			, 'Pictures, Video, Audio, or Text--whatever form your life takes, we can handle it. Our audio captioning feature allows you to record every detail without ever touching a keyboard.'
			, 'img3.jpg'
		), new LearnMoreInfo (
			'Easy as Pie'
			, 'We use large icons, simple menus, and drag-and-drop functionality to make recording your memories easy. Feel like an expert from your first time on the site.'
			, 'img3.jpg'
		), new LearnMoreInfo (
			'For the Road'
			, 'Have some downtime in the airport? Our mobile app brings your life to your phone.  Easily record or enhance the details of your events on the go.'
			, 'img3.jpg'
		)
	];

	var view = $('#learnMore');
	view.addClass('landing-main container-fluid');

	info = shuffle(info); 

	info.forEach(function (item, index) {
		view.append(createLearnMoreRow(item, index % 2 == 0 ? 'left' : 'right'));
	});
});




