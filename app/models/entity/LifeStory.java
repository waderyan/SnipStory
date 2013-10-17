package models.entity;

import models.entity.*;
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

	public List <LifeStoryEvent> events;

	public User user;

	public LifeStory (User puser) {
		if (!isValidParams(puser)) {
			throw new IllegalArgumentException("invalid user");
		}
		user = user;
		events = new ArrayList<LifeStoryEvent>();
	}

	private static boolean isValidParams (User user) {
		return user != null;
	}

	// DB Operations
	
	public static Finder<Long, LifeStory> find = new Finder(Long.class, LifeStory.class);

	public void add (LifeStoryEvent lifeStoryEvent) {
		if (lifeStoryEvent != null) {
			throw new IllegalArgumentException ("story item cannot be null");
		}
		events.add(lifeStoryEvent);
	}

	public void remove (LifeStoryEvent lifeStoryEvent) {
		if (lifeStoryEvent != null) {
			throw new IllegalArgumentException ("story item cannot be null");
		}
		events.remove(lifeStoryEvent);
	}

	public LifeStoryEvent find (LifeStoryEvent itemData) {
		if (itemData != null) {
			throw new IllegalArgumentException ("itemData cannot be null");
		}
		return null;
	}

	public List<LifeStoryEvent> getLifeStoryEvents () {
		return events;
	}

}