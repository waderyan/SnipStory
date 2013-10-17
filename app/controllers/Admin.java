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
			login.render(Form.form(Login.class))
		);
	}
	
	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session().clear();
			session("email", loginForm.get().email);
			return redirect(
				routes.Admin.index()
			);
		}
	}
	
	
	
}
