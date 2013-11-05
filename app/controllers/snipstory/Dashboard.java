package controllers.snipstory;

import play.mvc.*;

import views.html.dashboard.*;;

public class Dashboard extends Controller {

    public static Result index() {
        return ok(dashboard.render(toolbar.render(), timeline.render(), storyitemsview.render()));
    }
}