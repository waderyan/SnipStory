# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table invitee_user (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  constraint pk_invitee_user primary key (id))
;

create sequence invitee_user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists invitee_user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists invitee_user_seq;

