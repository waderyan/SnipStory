# --- !Ups
insert into account (email, name, password)
values ('snipstory@gmail.com', 'Admin', 'crocker123');

create table feedback_info (
  id                        bigint not null,
  importance_rating         varchar(255),
  feedback                  varchar(255),
  constraint pk_feedback_info primary key (id))
;

# --- !Downs

drop table if exists feedback_info;

delete from account where name = 'Admin';