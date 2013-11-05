package models.snipstory;


import play.db.ebean.*;

import javax.persistence.*;

@Entity
public class StoryEvent extends Model {

	@Id
	public Long id;

	@ManyToOne
	public LifeStory lifestory;

	public StoryEvent(LifeStory lifestory) {
		this.lifestory = lifestory;
	}

}