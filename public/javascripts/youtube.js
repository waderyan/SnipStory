var tag = document.createElement('script'); 
tag.src = "http://www.youtube.com/player_api"; 
var firstScriptTag = document.getElementsByTagName('script')[0]; 
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

var player;
function onYouTubePlayerAPIReady() {
	player = new YT.Player('player', { 
			height: '500', 
			width: '640', 
			videoId: '0416vgHMiRg', 
			events: { 
			'onReady': onPlayerReady, 
			'onStateChange': onPlayerStateChange 
		} 
	}); 
	}

function onPlayerReady(event) {
	// starts the video immediately.
	// event.target.playVideo();
}

function onPlayerStateChange(event) {
	if (event.data ==YT.PlayerState.PLAYING) {
		_gaq.push(['_trackEvent', 'Video-Start', 'Play', player.getVideoUrl() ]); 
	} 
	if (event.data ==YT.PlayerState.ENDED) {
		_gaq.push(['_trackEvent', 'Video-End', 'Watch to End', player.getVideoUrl() ]); 
	}  
}

