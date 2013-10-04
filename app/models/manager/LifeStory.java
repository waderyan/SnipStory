package models.manager;

import models.entity.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This <code>class</code> stores a <code>collection</code> of story items.
 * @author  wadeanderson
 */
public class LifeStory {

	//
	// Fields
	// 
	
	// Possibly we remove this list and store it all in the db
	private List <LifeStoryEvent> _events;
	private User _user;

	//
	//Constructor
	//
	
	/**
	 * @param  user != null
	 * @return new <code>LifeStory</code>
	 */
	public LifeStory (User user) {
		if (!isValidParams(user)) {
			throw new IllegalArgumentException("invalid user");
		}
		_user = user;
		_events = new ArrayList<LifeStoryEvent>();
	}

	/**
	 * Checks that the parameters are valid.
	 * @param  user
	 * @return true if params are valid, false otherwise
	 */
	private static boolean isValidParams (User user) {
		return user != null;
	}

	/**
	 * Add a <code>LifeStoryEvent</code>
	 * @param LifeStoryEvent [description]
	 */
	public void add (LifeStoryEvent lifeStoryEvent) {
		if (lifeStoryEvent != null) {
			throw new IllegalArgumentException ("story item cannot be null");
		}
		_events.add(lifeStoryEvent);
	}

	/**
	 * Remove a <code>LifeStoryEvent</code>
	 * @param LifeStoryEvent [description]
	 */
	public void remove (LifeStoryEvent lifeStoryEvent) {
		if (lifeStoryEvent != null) {
			throw new IllegalArgumentException ("story item cannot be null");
		}
		_events.remove(lifeStoryEvent);
	}

	/**
	 * Find a specific <code>LifeStoryEvent</code>
	 * @param  itemData [description]
	 * @return specific <code>LifeStoryEvent</code>
	 */
	public LifeStoryEvent find (LifeStoryEvent itemData) {
		if (itemData != null) {
			throw new IllegalArgumentException ("itemData cannot be null");
		}
		return null;
	}

	/**
	 * @return read-only <code>Collection</code> of <code>LifeStoryEvent</code>s.
	 */
	public List<LifeStoryEvent> getLifeStoryEvents () {
		return Collections.unmodifiableList(_events);
	}

}