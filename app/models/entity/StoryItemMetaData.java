package models.entity;

import common.util.StringUtils;

/**
 * This class stores information regarding the meta data of story items. 
 */
public class StoryItemMetaData extends UniqueEntity {
	
	private String _name;
	private String _value;

	public StoryItemMetaData (UUID id, String name, String value) {
		super (id);
		_name = name;
		_value = value;
	}

	private static isValidParams (String name, String value) {
		return !StringUtils.isEmptyOrNull(name, value);
	}
}