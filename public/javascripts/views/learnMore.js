$(function () {

	function LearnMoreInfo (heading, txt, imgsrc) {
		this.heading = heading;
		this.txt = txt;
		var imgFolder = '/assets/images/learnMore/'
		this.imgsrc = imgFolder + imgsrc;
		this.headingId = heading.replace(/ /g,'');
	}

	function interestBtnHandler (btn, headingId) {
		// Add analytic information here. 
		// Could make some Google Analytics call. 
		console.log("I am interested in " + headingId+ "!");

		var ratingDiv = $('<div>Does this interest you?</div>');

		$(btn).replaceWith(ratingDiv);
	}

	function createLearnMoreRow (info, side) {
		var row = $('<div></div>');
		row.addClass('row-fluid border');

		var item = $('<div></div>');
		item.addClass('span4 offset1 padded text-left');
		item.append('<h2>' + info.heading + '</h2>');
		item.append('<p>' + info.txt + '</p>');

		var btn = $('<button>Does this interest you?</button>');
		btn.addClass('btn btn-default');
		btn.click(function () {
			interestBtnHandler(this, info.headingId)
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

	info.forEach(function (item, index) {
		view.append(createLearnMoreRow(item, index % 2 == 0 ? 'left' : 'right'));
	});
});







