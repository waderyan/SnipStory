
# --- !Ups

create table account (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (email))
;

create table feedback_info (
  id                        bigint auto_increment not null,
  feature                   text,
  email                     varchar(255),
  feedback                  varchar(255),
  constraint pk_feedback_info primary key (id))
;

create table invitee_user (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  email                     varchar(255),
  constraint pk_invitee_user primary key (id))
;


# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table account;

drop table feedback_info;

drop table invitee_user;

