package models.snipstory;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class StoryItemMetaData extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@ManyToOne
	public StoryItem storyItem;

	@Required
	public String name;

	@Required
	public String value;

	public StoryItemMetaData (StoryItem storyItem, String name, String val) {
		this.storyItem = storyItem;
		this.name = name;
		this.value = val;
	}

}