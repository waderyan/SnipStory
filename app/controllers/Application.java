package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(TITLE));
    }

    public static Result learnMore() {
    	return ok(main.render(LEARNTITLE, learnMore.render(LEARNTITLE)));
    }

    public static Result learnMoreDetails() {
    	return ok(main.render(DETAILSTITLE, learnMoreDetails.render(DETAILSTITLE)));
    }

    private final static String TITLE = "My Life Story";
    private final static String LEARNTITLE = "Learn More";
    private final static String DETAILSTITLE = "Details";

}
