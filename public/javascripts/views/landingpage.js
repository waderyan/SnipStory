
(function ($) {

	SS_Video = Backbone.Model.extend({
		vidFile: ''
	});

	SS_Gallery = Backbone.Model.extend({
		images: []
	});

	SS_Description = Backbone.Model.extend({
		defaults: {
			text: 'Not specified',
			imgName: 'Not specified'
		}
	});

	// Will need to move all of this to its own model file
	SS_DescriptionList = Backbone.Collection.extend({

		descriptions: [],

		add: function(descr) {
			descriptions.push(descr);
		}
		model: SS_Description
	});

	var ss_descriptions = new SS_DescriptionList([
		new SS_Description({text: 'Wade Anderson', imgName: 'img Name to be added'})
	]);


	//
	//
	// View
	// 
	// 

	SS_GalleryView = Backbone.View.extend({

	});

	SS_VideoView = Backbone.View.extend({

	});

	SS_DescriptionListView = Backbone.View.extend({

	});

	SS_DescriptionView = Backbone.View.extend({

	});

	SS_Heading = Backbone.View.extend({

		el: $('heading'),
		
		initialize: function () {
			this.render();
		},
		render: function () {

		}
	});

}) (jQuery);



























