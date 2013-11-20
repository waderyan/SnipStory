package controllers.landing;

import play.*;
import play.mvc.*;

import views.html.landing.*;

public class Application extends Controller {

    private final static String TITLE = "SnipStory";

    public static Result index() {
        return ok(landingmain.render(TITLE, landing.render()));
    }

    public static Result landingV2() {
    	return ok(landingmain.render(TITLE, landingv2.render()));
    }

    public static Result landingV3() {
    	return ok(landingmain.render(TITLE, landingv3.render()));
    }
}
