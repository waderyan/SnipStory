package models.snipstory;

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

	@Required
	@OneToOne
	public LifeStory lifestory;

	public User (String username, String email, String password, Date birthdate) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
		this.lifestory = new LifeStory(this);
	}

	public static User getDummyUser() {
		return new User("testdummy", "test@test.com", "test", new Date());
	}

	// DB Operations
	
	public static Finder<Long, User> find = new Finder(Long.class, User.class);

	public static void create (String name, String email, String psd, Date bdate) {
		new User(name, email, psd, bdate).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}

	public static User find(Long id) {
		return find.ref(id);
	}
}























