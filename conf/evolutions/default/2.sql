
# --- !Ups

insert into account (email, name, password) values ('snipstory@gmail.com', 'admin', 'crocker123');

# --- !Downs

delete from account where email = 'snipstory@gmail.com';