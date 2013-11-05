package models.admin;

import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class FeedbackInfo extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Required
	public String feature;

	@Required
	public String email;

	@Required
	public String feedback;

	public FeedbackInfo (String feature, String email, String feedbackInfo) {
		this.feature = feature;
		this.email = email;
		this.feedback = feedbackInfo;
	}

	public static Finder<Long, FeedbackInfo> find = new Finder<Long, FeedbackInfo>(Long.class, FeedbackInfo.class);

	public static List<FeedbackInfo> all() {
		return find.all();
	}

	public static void create (String feature, String email, String feedbackInfo) {
		new FeedbackInfo(feature, email, feedbackInfo).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}
}
