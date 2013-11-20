package controllers.landing;

import controllers.routes;
import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.landing.*;

public class Secured extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(controllers.landing.routes.Admin.login());
    }
}
