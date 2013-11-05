package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    private final static String TITLE = "SnipStory";

    public static Result index() {
        return ok(index.render(TITLE, landing.render()));
    }

    public static Result landingV2() {
    	return ok(index.render(TITLE, landingv2.render()));
    }

    public static Result landingV3() {
    	return ok(index.render(TITLE, landingv3.render()));
    }
}
