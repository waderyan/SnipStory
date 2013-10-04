package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(TITLE));
    }

    public static Result learnMore() {
    	return ok(main.render(TITLE, learnMore.render(TITLE)));
    }

    private final static String TITLE = "My Life Story";

}
