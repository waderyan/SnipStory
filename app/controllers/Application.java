package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    private final static String TITLE = "My Life Story";

    public static Result index() {
        return ok(index.render(TITLE));
    }
}
