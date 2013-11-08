# --- !Ups
ALTER TABLE invitee_user ADD COLUMN landing_site varchar(100) default '/';
ALTER TABLE feedback_info ADD COLUMN landing_site varchar(100) default '/';

# --- !Downs

ALTER TABLE invitee_user drop column landing_site;
ALTER TABLE feedback_info drop column landing_site;
