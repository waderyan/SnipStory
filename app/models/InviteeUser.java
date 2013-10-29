package models;

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

	public InviteeUser (String pname, String pemail) {
		name = pname;
		email = pemail;
	}

	public static Finder<Long, InviteeUser> find = new Finder(Long.class, InviteeUser.class);

	public static List<InviteeUser> all() {
		return find.all();
	}
	
	public static List<InviteeUser> findPage(int pageNumber) {
		int pageSize = 10;
		List<InviteeUser> invitees =
			find.where()
			.findPagingList(pageSize)
			.getPage(1);
		return invitees;
	}

	public static void create (String name, String email) {
		new InviteeUser(name, email).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}
}
