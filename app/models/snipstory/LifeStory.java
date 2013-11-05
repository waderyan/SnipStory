package models.snipstory;

import play.data.validation.Constraints.Required;
import play.db.ebean.*;

import javax.persistence.*;

@Entity
public class LifeStory extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@OneToOne
	@Required
	public User user;

	public LifeStory (User user) {
		this.user = user;
	}
	
	// DB Operations
	
	public static Finder<Long, LifeStory> find = new Finder<Long, LifeStory>(Long.class, LifeStory.class);

	public static void create(User user) {
		new LifeStory(user).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}

	public static LifeStory find(Long id) {
		return find.ref(id);
	}


}