package controllers;

import static play.libs.Json.toJson;

import java.io.InputStream;

import models.admin.AdminUser;
import models.admin.FeedbackInfo;
import models.admin.InviteeUser;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

public class Admin extends Controller {

	static final int COOKIE_DURATION = 60 * 60 * 24 * 3;

	public static Result index () {
		return redirect(routes.Admin.reports());
	}

	@Security.Authenticated(Secured.class)
	public static Result reports () {
		return ok(views.html.admin.reports.render());
	}

	@Security.Authenticated(Secured.class)
	public static Result getInvitees () {
	    return ok(toJson(InviteeUser.all()));
	}

	@Security.Authenticated(Secured.class)
	public static Result exportInvitees() {
		InputStream is = InviteeUser.getDynamicStreamForCSV();
		response().setHeader("Content-disposition","attachment; filename=snipstory-invitees.csv");
		return ok(is);
	}

	public static Result addInvitee () {
		DynamicForm requestData = new DynamicForm().bindFromRequest();
		InviteeUser.create(requestData.get("name"), requestData.get("email"));
		response().setCookie("invitee-email", requestData.get("email"), COOKIE_DURATION); 
		return ok();
	}

	public static Result addFeedback () {
		DynamicForm requestData = new DynamicForm().bindFromRequest();
		FeedbackInfo.create(requestData.get("feature"), requestData.get("email"), requestData.get("details"));
		response().setCookie("invitee-email", requestData.get("email"), COOKIE_DURATION); 
		return ok();
	}

	public static Result getFeedback () {
		return ok(toJson(FeedbackInfo.all()));
	}
	
	// ***********************************************************
	// **********    Login & Authentication    *******************
	// ***********************************************************
	
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
