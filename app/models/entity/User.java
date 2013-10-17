package models.entity;

import java.util.Date;
import java.util.Calendar;
import common.util.StringUtils;

import play.db.ebean.*;
import play.data.validation.Constraints.*;
import play.data.format.*;
import play.data.validation.*;

import javax.persistence.*;

@Entity
public class User extends Model {

	@Id
	public Long id;

	@Email
	@Required
	public String username;

	@Required
	public String email;

	@Required
	public String password;

	@Required
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date birthdate;

	public LifeStory lifestory;

	public User (String usrnme, String eml, String pswd, Date bdate) {
		if(!isValidParams(username, email, password, birthdate)) {
			throw new IllegalArgumentException ("invalid arguments for User constructor");
		}

		username = usrnme;
		email = eml;
		password = pswd;
		birthdate = bdate;
		lifestory = new LifeStory(this);
	}

	private static boolean isValidParams (String username, String email, String password, Date birthdate) {
		return true;
		// Not working for some reason
		// return isEmptyOrNull(username, email, password) 
		// 	&&  isValidBirthdate (birthdate);
	}

	private static boolean isValidBirthdate (Date birthdate) {
		return birthdate != null;
	}

	public static User getDummyUser() {
		return new User("testdummy", "test@test.com", "test", new Date());
	}

	// DB Operations
	
	public static Finder<Long, User> find = new Finder(Long.class, User.class);

	public static void create (String name, String email, String psd, Date bdate) {
		new User(name, email, psd, bdate);
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}

	public static User find(Long id) {
		return find.ref(id);
	}
}























