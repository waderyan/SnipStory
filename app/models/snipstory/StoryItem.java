package models.snipstory;

import java.util.Date;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class StoryItem extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@ManyToOne
	public StoryPage event;

	@Required
	public String description;

	@Required
	public Date date;

	@Required
	public String location;

	@Required
	public String category;

	@Required
	public String filepath;

	
	public StoryItem (StoryPage event, String description, Date date, String loc, String category, String filepath) {
		this.event = event;
		this.description = description;
		this.date = date;
		this.location = loc;
		this.category = category;
		this.filepath = filepath;
	}

}