package models.admin;

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

import com.csvreader.CsvWriter;

@SuppressWarnings("serial")
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

	public String createdat;


	@SuppressWarnings({ "unchecked", "rawtypes" })
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

	public static ByteArrayInputStream getDynamicStream() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		CsvWriter csv = new CsvWriter(stream, ',', Charset.forName("UTF8"));
		try {
			csv.write("id");
			csv.write("name");
			csv.write("email");
			csv.write("created\n");
			csv.endRecord();
			List<InviteeUser> invitees = find.all();
			for (InviteeUser invitee : invitees) {
				csv.write(invitee.id + "");
				csv.write(invitee.name);
				csv.write(invitee.email);
				csv.write(invitee.createdat + "\n");
				csv.endRecord();
				csv.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		csv.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}

	public static void create (String name, String email) {
		new InviteeUser(name, email).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}
}
