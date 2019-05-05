-- author: paulo.f.rodriguez@gmail.com

use gitfinder;

create table properties(
    id int not null auto_increment,
    `key` varchar(256) unique not null,
    `value` varchar(256) not null,
    PRIMARY KEY (`id`)
);

