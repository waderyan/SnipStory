package models.entity;

import common.util.StringUtils;
import java.util.Date;
import java.util.UUID;

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

	private static boolean isValidParams (String name, String value) {
		return !StringUtils.isEmptyOrNull(name, value);
	}
}