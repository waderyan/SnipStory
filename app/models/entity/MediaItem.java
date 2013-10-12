package models.entity;

import java.util.Date;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class MediaItem extends StoryItem {

	public MediaItem (String description, Date date, String loc, String category, String filepath) {
		super (description, date, loc, category, filepath);
	}
}