
# --- !Ups

create table user (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  birthdate                 datetime,
  constraint pk_user primary key (id))
;

create table life_story (
  id                bigint auto_increment not null,
  user_id  					bigint,
  constraint pk_life_story primary key (id),
  constraint fk_user foreign key (user_id) references user
);

create table story_page (
  id  						    bigint auto_increment not null,
  life_story_id  			bigint,
  date                datetime,
  constraint pk_life_story_page primary key (id),
  constraint fk_life_story foreign key (life_story_id) references life_story)
;

create table story_item (
  id                        bigint auto_increment not null,
  life_story_page_id  		  bigint,
  description               varchar(255),
  date                      datetime,
  location                  varchar(255),
  category                  varchar(255),
  type                      varchar(8),
  constraint pk_story_item primary key (id),
  constraint fk_life_story_event foreign key (life_story_page_id) references life_story_page)
;

create table story_item_meta_data (
  id                        bigint auto_increment not null,
  storyitem_id              bigint,
  name                      varchar(255),
  value                     varchar(255),
  constraint pk_story_item_meta_data primary key (id),
  constraint fk_story_item foreign key (storyitem_id) references story_item)
;

create table story_chapter (
  id                        bigint auto_increment not null,
  life_story_id             bigint,
  startyear                 int,
  endyear                   int,
  constraint pk_story_chapter primary key (id),
  constraint fk_life_story foreign key (life_story_id) references life_story)
);

# --- !Downs

drop table user;

drop table life_story;

drop table story_page;

drop table story_item;

drop table story_item_meta_data;

drop table story_chapter;

