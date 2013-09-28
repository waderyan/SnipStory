package models.entity;

import common.util.StringUtils;

/**
 * Class represents an <code>Abstract</code> <code>StoryItem</code>.
 * <code>StoryItem</code>s can be a variety of different types. Story items are what makes 
 * up someone's life story. 
 */
public abstract class StoryItem extends UniqueEntity {

	//
	// Fields
	// 
	
	private String _description;
	private Date _date;
	private String _location; // TODO - not sure if string is the best type.
	private String _category; // TODO - may need to be enum
	private String _filepath;

	// 
	// Constructor
	// 
	
	protected StoryItem (String description, Date date, String loc, String category, String filepath) {
		if (!isValidParams(description, date, loc, category, filepath)) {
			throw new IllegalArgumentException ("invalid parameters for story item");
		}
		_description = description;
		_date = date;
		_location = location;
		_category = category;
		_filepath = filepath;
	}

	private boolean isValidParams (String description, Date date, String loc, String category, String filepath) {
		return !StringUtils.isEmptyOrNull(descriptioin, loc, category, filepath) && isValidDate(date);
	}

	private boolean isValidDate(Date date) {
		return date != null;
	}
}