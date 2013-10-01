package models.entity;

import java.util.Date;

public class ImageItem extends MediaItem {

	public ImageItem (String description, Date date, String loc, String category, String filepath) {
		super (description, date, loc, category, filepath);
	}
}