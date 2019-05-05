-- author: paulo.f.rodriguez@gmail.com

use gitfinder;

-- section trending
create table if not exists  repositories(
    id bigint not null auto_increment,
    `author` varchar(255)  not null,
    `name` varchar(255) not null,
    `url` varchar(1000) not null,
    `description` varchar(255) not null,
    `language` varchar(255) not null,
    `language_color` varchar(255) not null,
    `stars` bigint not null,
    `forks` bigint not null,
    `current_period_stars` bigint not null,
    PRIMARY KEY (`id`)
)engine=InnoDB;

create table if not exists  builtby(
    id bigint not null auto_increment,
    `username` varchar(255) unique not null,
    `href` varchar(255) unique not null,
    `avatar` varchar(1000)  not null,
    PRIMARY KEY (`id`)
)engine=InnoDB;

create table if not exists repo_builtby(
   repo_id bigint not null,
   built_by_id bigint not null
)engine=InnoDB;

alter table repo_builtby add constraint FK3 foreign key (repo_id) references repositories (id);
alter table repo_builtby add constraint FK4 foreign key (built_by_id) references builtby (id);


-- section starred

create table if not exists  `license` (
  `id` int(11) NOT NULL auto_increment,
    `key`varchar(255),
    `name`varchar(255),
    `spdx_id`varchar(255),
    `url`varchar(255),
    `node_id`varchar(255),
    primary key (`id`)
);


CREATE TABLE if not exists `owner` (
  `id` int(11) NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `events_url` varchar(255) DEFAULT NULL,
  `followers_url` varchar(255) DEFAULT NULL,
  `following_url` varchar(255) DEFAULT NULL,
  `gists_url` varchar(255) DEFAULT NULL,
  `gravatar_id` varchar(255) DEFAULT NULL,
  `html_url` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `node_id` varchar(255) DEFAULT NULL,
  `organizations_url` varchar(255) DEFAULT NULL,
  `received_events_url` varchar(255) DEFAULT NULL,
  `repos_url` varchar(255) DEFAULT NULL,
  `site_admin` bit(1) DEFAULT NULL,
  `starred_url` varchar(255) DEFAULT NULL,
  `subscriptions_url` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE if not exists  `item` (
  `id` int(11) NOT NULL,
  `_private` bit(1) DEFAULT NULL,
  `archive_url` varchar(255) DEFAULT NULL,
  `archived` bit(1) DEFAULT NULL,
  `assignees_url` varchar(255) DEFAULT NULL,
  `blobs_url` varchar(255) DEFAULT NULL,
  `branches_url` varchar(255) DEFAULT NULL,
  `clone_url` varchar(255) DEFAULT NULL,
  `collaborators_url` varchar(255) DEFAULT NULL,
  `comments_url` varchar(255) DEFAULT NULL,
  `commits_url` varchar(255) DEFAULT NULL,
  `compare_url` varchar(255) DEFAULT NULL,
  `contents_url` varchar(255) DEFAULT NULL,
  `contributors_url` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `default_branch` varchar(255) DEFAULT NULL,
  `deployments_url` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `disabled` bit(1) DEFAULT NULL,
  `downloads_url` varchar(255) DEFAULT NULL,
  `events_url` varchar(255) DEFAULT NULL,
  `fork` bit(1) DEFAULT NULL,
  `forks` int(11) DEFAULT NULL,
  `forks_count` int(11) DEFAULT NULL,
  `forks_url` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `git_commits_url` varchar(255) DEFAULT NULL,
  `git_refs_url` varchar(255) DEFAULT NULL,
  `git_tags_url` varchar(255) DEFAULT NULL,
  `git_url` varchar(255) DEFAULT NULL,
  `has_downloads` bit(1) DEFAULT NULL,
  `has_issues` bit(1) DEFAULT NULL,
  `has_pages` bit(1) DEFAULT NULL,
  `has_projects` bit(1) DEFAULT NULL,
  `has_wiki` bit(1) DEFAULT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  `hooks_url` varchar(255) DEFAULT NULL,
  `html_url` varchar(255) DEFAULT NULL,
  `issue_comment_url` varchar(255) DEFAULT NULL,
  `issue_events_url` varchar(255) DEFAULT NULL,
  `issues_url` varchar(255) DEFAULT NULL,
  `keys_url` varchar(255) DEFAULT NULL,
  `labels_url` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `languages_url` varchar(255) DEFAULT NULL,
  `merges_url` varchar(255) DEFAULT NULL,
  `milestones_url` varchar(255) DEFAULT NULL,
  `mirror_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `node_id` varchar(255) DEFAULT NULL,
  `notifications_url` varchar(255) DEFAULT NULL,
  `open_issues` int(11) DEFAULT NULL,
  `open_issues_count` int(11) DEFAULT NULL,
  `pulls_url` varchar(255) DEFAULT NULL,
  `pushed_at` varchar(255) DEFAULT NULL,
  `releases_url` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `ssh_url` varchar(255) DEFAULT NULL,
  `stargazers_count` int(11) DEFAULT NULL,
  `stargazers_url` varchar(255) DEFAULT NULL,
  `statuses_url` varchar(255) DEFAULT NULL,
  `subscribers_url` varchar(255) DEFAULT NULL,
  `subscription_url` varchar(255) DEFAULT NULL,
  `svn_url` varchar(255) DEFAULT NULL,
  `tags_url` varchar(255) DEFAULT NULL,
  `teams_url` varchar(255) DEFAULT NULL,
  `trees_url` varchar(255) DEFAULT NULL,
  `updated_at` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `watchers` int(11) DEFAULT NULL,
  `watchers_count` int(11) DEFAULT NULL,
  `license_key` varchar(255) DEFAULT NULL,
  `owner_id` int(11) ,
  license_id int(11),
  PRIMARY KEY (`id`)


) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table item  add constraint FK1 foreign key (owner_id) references owner (id);
alter table item  add constraint FK2 foreign key (license_id) references license (id);
