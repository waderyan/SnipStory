
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

create table life_story (
  id                        bigint auto_increment not null,
  constraint pk_life_story primary key (id))
;

create table media_item (
  id                        bigint auto_increment not null,
  description               varchar(255),
  date                      datetime,
  location                  varchar(255),
  category                  varchar(255),
  filepath                  varchar(255),
  constraint pk_media_item primary key (id))
;

create table story_item (
  id                        bigint auto_increment not null,
  description               varchar(255),
  date                      datetime,
  location                  varchar(255),
  category                  varchar(255),
  filepath                  varchar(255),
  constraint pk_story_item primary key (id))
;

create table story_item_meta_data (
  id                        bigint auto_increment not null,
  storyitem_id              bigint,
  name                      varchar(255),
  value                     varchar(255),
  constraint pk_story_item_meta_data primary key (id))
;

create table text_item (
  id                        bigint auto_increment not null,
  description               varchar(255),
  date                      datetime,
  location                  varchar(255),
  category                  varchar(255),
  filepath                  varchar(255),
  constraint pk_text_item primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  birthdate                 datetime,
  constraint pk_user primary key (id))
;

alter table story_item_meta_data add constraint fk_story_item_meta_data_storyitem_1 foreign key (storyitem_id) references story_item (id) on delete restrict on update restrict;
create index ix_story_item_meta_data_storyitem_1 on story_item_meta_data (storyitem_id);


# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table account;

drop table feedback_info;

drop table invitee_user;

drop table life_story;

drop table media_item;

drop table story_item;

drop table story_item_meta_data;

drop table text_item;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

