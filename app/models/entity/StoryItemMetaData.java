package models.entity;

import common.util.StringUtils;
import java.util.Date;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class StoryItemMetaData extends Model {

	@Id
	public Long id;
	
	@ManyToOne
	public StoryItem storyitem;

	@Required
	public String name;

	@Required
	public String value;

	public StoryItemMetaData (String nme, String val) {
		if (!isValidParams(nme, val)) {
			throw new IllegalArgumentException ("name or value is empty");
		}
		name = nme;
		value = val;
	}

	private static boolean isValidParams (String name, String value) {
		return !StringUtils.isEmptyOrNull(name, value);
	}
}