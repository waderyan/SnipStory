package models.admin;

import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class InviteeUser extends Model {
	
	@Id
	public Long id;

	@Required
	public String name;

	@Required
	public String email;

	public InviteeUser (String name, String email) {
		this.name = name;
		this.email = email;
	}

	public static Finder<Long, InviteeUser> find = new Finder(Long.class, InviteeUser.class);

	public static List<InviteeUser> all() {
		return find.all();
	}

	public static void create (String name, String email) {
		new InviteeUser(name, email).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}
}