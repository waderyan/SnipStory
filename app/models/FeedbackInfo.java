package models;

import java.util.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class FeedbackInfo extends Model {
	
	@Id
	public Long id;

	// This should be an enum but I don't have time to figure out how that works with the db right now.
	@Required
	public String importanceRating;

	@Required
	public String feedback;

	public FeedbackInfo (String rating, String feedbackInfo) {
		importanceRating = rating;
		feedback = feedbackInfo;
	}

	public static Finder<Long, FeedbackInfo> find = new Finder(Long.class, FeedbackInfo.class);

	public static List<FeedbackInfo> all() {
		return find.all();
	}

	public static void create (String rating, String feedbackInfo) {
		new FeedbackInfo(rating, feedbackInfo).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}
}
