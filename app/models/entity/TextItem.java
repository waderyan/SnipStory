package models.entity;

import java.util.Date;

public class TextItem extends StoryItem {

	public TextItem (String description, Date date, String loc, String category, String filepath) {
		super (description, date, loc, category, filepath);
	}
}