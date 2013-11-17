package models.snipstory;


import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class StoryChapter extends Model {

	@Id
	public Long id;

	@ManyToOne
	public LifeStory lifestory;

	public StoryChapter(LifeStory lifestory) {
		this.lifestory = lifestory;
	}

}