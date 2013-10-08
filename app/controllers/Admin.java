package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import views.html.*;

public class Admin extends Controller {

	public static Result index () {
		return redirect(routes.Admin.reports());
	}

	public static Result reports () {
		return ok(views.html.reports.render(InviteeUser.all()));
	}

	public static Result addInvitee () {
		DynamicForm requestData = new DynamicForm().bindFromRequest();

		String name = requestData.get("name");
		String email = requestData.get("email");

		InviteeUser.create(name, email);
		Logger.info(name + " " + email);

		return ok();
	}
	
}