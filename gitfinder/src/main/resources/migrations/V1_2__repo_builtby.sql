use gitfinder;

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





alter table repo_builtby add constraint FK1 foreign key (repo_id) references repositories (id);
alter table repo_builtby add constraint FK2 foreign key (built_by_id) references builtby (id);

