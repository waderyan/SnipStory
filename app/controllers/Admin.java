package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.libs.Json.toJson;

import models.*;
import views.html.*;

public class Admin extends Controller {

	public static Result index () {
		return redirect(routes.Admin.reports());
	}

	public static Result reports () {
		return ok(views.html.reports.render(InviteeUser.all()));
	}

	public static Result getInvitees () {
	    return ok(toJson(InviteeUser.all()));
	}

	public static Result addInvitee () {
		DynamicForm requestData = new DynamicForm().bindFromRequest();
		// TODO need some SQL Sanitation either here or in InviteeUser.create
		InviteeUser.create(requestData.get("name"), requestData.get("email"));
		return ok();
	}
	
}