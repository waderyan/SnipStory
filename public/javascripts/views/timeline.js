
	$(document).ready(function() {
		$('#carousel-demo1').scrollingCarousel();	

		$('.timelineItem').click(function(e) {
			$('.timelineItem').css('border', 'none');
	  		$(e.target).css('border', '5px solid black');
	  		$('.enlargedTimelineItem').removeClass('enlargedTimelineItem');		
	  		$(e.target).addClass('enlargedTimelineItem');
	});		
	});

	
