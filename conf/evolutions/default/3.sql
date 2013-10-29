# --- !Ups
alter table invitee_user
	ADD COLUMN createdat TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP;
# --- !Downs
