package models.entity;

import java.util.Date;

public class VideoItem extends MediaItem {

	public VideoItem (String description, Date date, String loc, String category, String filepath) {
		super (description, date, loc, category, filepath);
	}
}