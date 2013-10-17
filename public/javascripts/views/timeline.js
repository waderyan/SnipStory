
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

	
/*

*/