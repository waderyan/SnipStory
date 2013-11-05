package models.snipstory;

import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class StoryChapter extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@ManyToOne
	public LifeStory lifestory;

	public StoryChapter(LifeStory lifestory) {
		this.lifestory = lifestory;
	}

}