package controllers.snipstory;

import play.mvc.*;

public class Dashboard extends Controller {

    public static Result index() {

        return ok(
        	views.html.dashboard.dashboard.render(
	        	views.html.dashboard.toolbar.render(), 
	        	views.html.dashboard.timeline.render(), 
	        	views.html.dashboard.storyitemsview.render()
	    	)
        );
    }
}