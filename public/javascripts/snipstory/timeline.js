
function Timeline() {
	this.el = $('#timeline');
	this.chapters = [];
}

Timeline.prototype.paint = function() {
	// chapters paint
}

function Chapter() {
	this.events = [];
}

Chapter.prototype.paint = function() {
	// paints the chapters on the timeline
}

function LifeEvent() {
	this.position = '';
	this.storyitems = [];
}

LifeEvent.prototype.paint = function() {
	// paints the life event icon in the chapter on the timeline
}

LifeEvent.protoptye.displayItems = function() {
	// displays all story items
}

/**
$(document).ready(function() {
	$('#carousel-demo1').scrollingCarousel();	

	$('.timelineItem').click(function(e) {
		//enlarges selected timeline item. (Also shrinks current enlarged item, if currently selected)
		$('.timelineItem').css('border', 'none');
		$('.normalTimelineItem').removeClass('normalTimelineItem');
  		$(e.target).css('border', '5px solid black');	  	
  		$('.enlargedTimelineItem').addClass('normalTimelineItem');
  		$('.enlargedTimelineItem').removeClass('enlargedTimelineItem');
  		
  		
  		$(e.target).addClass('enlargedTimelineItem');
  		
	});		
});
*/
