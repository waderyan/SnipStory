package models.entity;

import common.util.StringUtils;
import java.util.Date;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public abstract class StoryItem extends Model {

	@Id
	public Long id;

	@Required
	public String description;

	@Required
	public Date date;

	@Required
	public String location;

	@Required
	public String category;

	@Required
	public String filepath;

	
	public StoryItem (String pdescription, Date pdate, String ploc, String pcategory, String pfilepath) {
		if (!isValidParams(pdescription, pdate, ploc, pcategory, pfilepath)) {
			throw new IllegalArgumentException ("invalid parameters for story item");
		}
		description = pdescription;
		date = pdate;
		location = ploc;
		category = pcategory;
		filepath = pfilepath;
	}

	private boolean isValidParams (String description, Date date, String loc, String category, String filepath) {
		return !StringUtils.isEmptyOrNull(description, loc, category, filepath) && isValidDate(date);
	}

	private boolean isValidDate(Date date) {
		return date != null;
	}
}