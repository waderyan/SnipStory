package controllers;

import play.*;
import play.mvc.*;
import models.entity.*;

import views.html.*;

public class Dashboard extends Controller {

    public static Result index() {
    	User user = User.getDummyUser();
        return ok(
        	views.html.dashboard.render(
	        	toolbar.render(user), 
	        	timeline.render(user), 
	        	storyitemsview.render(user)
	    	)
        );
    }

    // Below will be ajax get and post methods

}