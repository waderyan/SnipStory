package models.entity;

import java.util.Date;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class TextItem extends StoryItem {

	public TextItem (String description, Date date, String loc, String category, String filepath) {
		super (description, date, loc, category, filepath);
	}
}