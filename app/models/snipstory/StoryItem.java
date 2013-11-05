package models.snipstory;

import java.util.Date;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class StoryItem extends Model {

	private static final long serialVersionUID = 1L;

	public enum StoryItemType {
		Text,
		Audio,
		Video,
		Image
	}
	
	@Id
	public Long id;

	@ManyToOne
	public StoryPage page;

	@Required
	public String description;

	@Required
	public Date date;

	@Required
	public String location;

	@Required
	public String category;
	
	@Required
	public String type;

	public StoryItem (StoryPage page, String description, Date date, String loc, String category, StoryItemType type) {
		this.page = page;
		this.description = description;
		this.date = date;
		this.location = loc;
		this.category = category;
		this.type = type.name();
	}
	
	// DB Operations
	
	public static Finder<Long, StoryItem> find = new Finder<Long, StoryItem>(Long.class, StoryItem.class);

	public static void create (StoryPage page, String description, Date date, String loc, String category, StoryItemType type) {
		new StoryItem(page, description, date, loc, category, type).save();
	}

	public static void delete (Long id) {
		find.ref(id).delete();
	}

	public static StoryItem find(Long id) {
		return find.ref(id);
	}

}