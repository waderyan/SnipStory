package controllers;

import play.*;
import play.mvc.*;
import models.entity.*;

import views.html.*;

public class Dashboard extends Controller {

    public static Result index() {
        User user = User.getDummyUser();
        // We still need to figure out how the state will be mantained. 

        return ok(
        	views.html.dashboard.dashboard.render(
	        	views.html.dashboard.toolbar.render(), 
	        	views.html.dashboard.timeline.render(), 
	        	views.html.dashboard.storyitemsview.render()
	    	)
        );
    }
}