package models.snipstory;

import play.data.validation.Constraints.Required;
import play.db.ebean.*;

import javax.persistence.*;

@Entity
public class StoryChapter extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@ManyToOne
	public LifeStory lifestory;
	
	@Required
	public int startyear;
	
	@Required
	public int endyear;

	public StoryChapter(LifeStory lifestory, int startyear, int endyear) {
		this.lifestory = lifestory;
		this.startyear = startyear;
		this.endyear = endyear;
	}
	
	// DB Operations
	
	public static Finder<Long, StoryChapter> find = new Finder<Long, StoryChapter>(Long.class, StoryChapter.class);

	public static void create(LifeStory lifestory, int startyear, int endyear) {
		new StoryChapter(lifestory, startyear, endyear).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}

	public static StoryChapter find(Long id) {
		return find.ref(id);
	}

}