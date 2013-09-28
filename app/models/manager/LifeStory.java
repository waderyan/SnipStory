package models.manager;

import models.entity;
import java.util.List;
import java.util.ArrayList;

/**
 * This <code>class</code> stores a <code>collection</code> of story items.
 * @author  wadeanderson
 */
public class LifeStory {

	//
	// Fields
	// 
	
	// Possibly we remove this list and store it all in the db
	private List <StoryItem> _storyItems;
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
		_storyItems = new ArrayList<StoryItem>();
	}

	/**
	 * Checks that the parameters are valid.
	 * @param  user
	 * @return true if params are valid, false otherwise
	 */
	private static isValidParams (User user) {
		return user != null;
	}

	/**
	 * Add a <code>StoryItem</code>
	 * @param storyItem [description]
	 */
	public void add (StoryItem storyItem) {
		if (storyItem != null) {
			throw new IllegalArgumentException ("story item cannot be null");
		}
		_storyItems.add(storyItem);
	}

	/**
	 * Remove a <code>StoryItem</code>
	 * @param storyItem [description]
	 */
	public void remove (StoryItem storyItem) {
		if (storyItem != null) {
			throw new IllegalArgumentException ("story item cannot be null");
		}
		_storyItems.remove(storyItem);
	}

	/**
	 * Find a specific <code>StoryItem</code>
	 * @param  itemData [description]
	 * @return specific <code>StoryItem</code>
	 */
	public StoryItem find (StoryItem itemData) {
		if (itemData != null) {
			throw new IllegalArgumentException ("itemData cannot be null");
		}
		return _storyItems.find(itemData);
	}

	/**
	 * @return read-only <code>Collection</code> of <code>StoryItem</code>s.
	 */
	public List<StoryItem> getStoryItems () {
		return Collections.unmodifiableList(_storyItems);
	}

}