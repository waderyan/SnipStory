package models.snipstory;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class LifeStory extends Model {

	@Id
	public Long id;

	@OneToOne
	public User user;

	public LifeStory (User user) {
		this.user = user;
	}

}