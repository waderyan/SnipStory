package controllers.snipstory;

import models.snipstory.User;
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
		return TODO;
	}
	
	public static Result updateUser(Long id) {
		return TODO;
	}
    
}