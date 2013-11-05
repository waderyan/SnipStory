package models.snipstory;

import play.db.ebean.*;

import javax.persistence.*;

@Entity
public class StoryPage extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@ManyToOne
	public LifeStory lifestory;

	public StoryPage(LifeStory lifestory) {
		this.lifestory = lifestory;
	}

}