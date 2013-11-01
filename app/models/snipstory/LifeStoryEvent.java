package models.snipstory;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class LifeStoryEvent extends Model {

	@Id
	public Long id;

	@ManyToOne
	public LifeStory lifestory;

	public LifeStoryEvent(LifeStory lifestory) {
		this.lifestory = lifestory;
	}

}