package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.libs.Json.toJson;
import play.Logger;

import models.admin.*;
import views.html.*;

public class Admin extends Controller {

	public static Result index () {
		return redirect(routes.Admin.reports());
	}

	@Security.Authenticated(Secured.class)
	public static Result reports () {
		return ok(views.html.admin.reports.render());
	}

	public static Result getInvitees () {
	    return ok(toJson(InviteeUser.all()));
	}

	public static Result addInvitee () {
		DynamicForm requestData = new DynamicForm().bindFromRequest();
		InviteeUser.create(requestData.get("name"), requestData.get("email"));
		return ok();
	}

	public static Result addFeedback () {
		DynamicForm requestData = new DynamicForm().bindFromRequest();
		FeedbackInfo.create(requestData.get("feature"), requestData.get("email"), requestData.get("details"));
		return ok();
	}

	public static Result getFeedback () {
		return ok(toJson(FeedbackInfo.all()));
	}
	
	// Login & Authentication
	
	public static class Login {
		public String email;
		public String password;
		
		public String validate() {
			if (AdminUser.authenticate(email, password) == null) {
				return "Invalid user or password";
			}
			return null;
		}
	}
	
	public static Result login() {
		return ok(
			views.html.admin.login.render(Form.form(Login.class))
		);
	}
	
	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(views.html.admin.login.render(loginForm));
		} else {
			session().clear();
			session("email", loginForm.get().email);
			return redirect(
				routes.Admin.index()
			);
		}
	}
	
	
	
}
