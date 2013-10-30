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

	public String createdat;

	public InviteeUser (String pname, String pemail) {
		name = pname;
		email = pemail;
	}

	public static Finder<Long, InviteeUser> find = new Finder(Long.class, InviteeUser.class);

	public static List<InviteeUser> all() {
		return find.all();
	}

	public static List<InviteeUser> alphabetize(boolean reverse) {
		List<InviteeUser> invitees = null;
		if (reverse)
			invitees = find.orderBy().desc("name").findList();
		else
			invitees = find.orderBy().asc("name").findList();
		return invitees;
	}

	public static List<InviteeUser> sortByDate(boolean first) {
		List<InviteeUser> invitees = null;
		if (!first)
			invitees = find.orderBy().desc("createdat").findList();
		else
			invitees = find.orderBy().asc("createdat").findList();
		return invitees;	
	}

	// public static List<InviteeUser> show() {
		// return find.findPagingList(2).getPage(1);
	// }

	public static void create (String name, String email) {
		new InviteeUser(name, email).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}
}
