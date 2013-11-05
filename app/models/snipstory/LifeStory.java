package models.snipstory;

import play.db.ebean.*;

import javax.persistence.*;

@Entity
public class LifeStory extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@OneToOne
	public User user;

	public LifeStory (User user) {
		this.user = user;
	}

}