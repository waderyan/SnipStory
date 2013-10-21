
# --- !Ups

create table account (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (email))
;

create table feedback_info (
  id                        bigint not null,
  importance_rating         varchar(255),
  feedback                  varchar(255),
  constraint pk_feedback_info primary key (id))
;

create table invitee_user (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  constraint pk_invitee_user primary key (id))
;

create table life_story (
  id                        bigint not null,
  constraint pk_life_story primary key (id))
;

create table media_item (
  id                        bigint not null,
  description               varchar(255),
  date                      timestamp,
  location                  varchar(255),
  category                  varchar(255),
  filepath                  varchar(255),
  constraint pk_media_item primary key (id))
;

create table story_item (
  id                        bigint not null,
  description               varchar(255),
  date                      timestamp,
  location                  varchar(255),
  category                  varchar(255),
  filepath                  varchar(255),
  constraint pk_story_item primary key (id))
;

create table story_item_meta_data (
  id                        bigint not null,
  storyitem_id              bigint,
  name                      varchar(255),
  value                     varchar(255),
  constraint pk_story_item_meta_data primary key (id))
;

create table text_item (
  id                        bigint not null,
  description               varchar(255),
  date                      timestamp,
  location                  varchar(255),
  category                  varchar(255),
  filepath                  varchar(255),
  constraint pk_text_item primary key (id))
;

create table user (
  id                        bigint not null,
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  birthdate                 timestamp,
  constraint pk_user primary key (id))
;

create sequence account_seq;

create sequence feedback_info_seq;

create sequence invitee_user_seq;

create sequence life_story_seq;

create sequence media_item_seq;

create sequence story_item_seq;

create sequence story_item_meta_data_seq;

create sequence text_item_seq;

create sequence user_seq;

alter table story_item_meta_data add constraint fk_story_item_meta_data_storyi_1 foreign key (storyitem_id) references story_item (id) on delete restrict on update restrict;
create index ix_story_item_meta_data_storyi_1 on story_item_meta_data (storyitem_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists account;

drop table if exists feedback_info;

drop table if exists invitee_user;

drop table if exists life_story;

drop table if exists media_item;

drop table if exists story_item;

drop table if exists story_item_meta_data;

drop table if exists text_item;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists account_seq;

drop sequence if exists feedback_info_seq;

drop sequence if exists invitee_user_seq;

drop sequence if exists life_story_seq;

drop sequence if exists media_item_seq;

drop sequence if exists story_item_seq;

drop sequence if exists story_item_meta_data_seq;

drop sequence if exists text_item_seq;

drop sequence if exists user_seq;

