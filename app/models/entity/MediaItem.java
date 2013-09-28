package models.entity;

public abstract class MediaItem extends StoryItem {

	protected MediaItem (String description, Date date, String loc, String category, String filepath) {
		super (description, date, loc, category, filepath);
	}
}