package models.snipstory;

import java.sql.Date;

import play.data.validation.Constraints.Required;
import play.db.ebean.*;

import javax.persistence.*;

@Entity
public class StoryPage extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@ManyToOne
	public StoryChapter chapter;
	
	@Required
	public Date date;

	public StoryPage(StoryChapter chapter, Date date) {
		this.chapter = chapter;
		this.date = date;
	}
	
	// DB Operations
	
	public static Finder<Long, StoryPage> find = new Finder<Long, StoryPage>(Long.class, StoryPage.class);

	public static void create (StoryChapter chapter, Date date) {
		new StoryPage(chapter, date).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}

	public static StoryPage find(Long id) {
		return find.ref(id);
	}

}