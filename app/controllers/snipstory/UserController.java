package controllers.snipstory;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.snipstory.User;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;

import static play.libs.Json.toJson;

public class UserController extends Controller {

	public static Result getUser(Long id) {
		User user = User.find(id);
		assert user != null;
		return ok(toJson(user));
	}
	
	public static Result addUser() {
		DynamicForm request = new DynamicForm().bindFromRequest();
		
		User response;
		try {
			String name = request.get("name");
			String email = request.get("email");
			String password = request.get("password");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d = sdf.parse(request.get("birthdate"));
			response = User.create(name, email, password, d);
			
		} catch (ParseException e) {
			return badRequest();
		}
		
		return ok(toJson(response));
	}
	
	public static Result updateUser(Long id) {
		User user = User.find(id);
		DynamicForm request = new DynamicForm().bindFromRequest();
		
		user.username = request.get("username");
		user.email = request.get("email");
		user.password = request.get("password");
		
		user.update();
		
		return ok();
	}
    
}