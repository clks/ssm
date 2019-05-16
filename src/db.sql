-- 创建user表---------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(20) UNIQUE ,
  `password` varchar(255)
)DEFAULT CHARSET=utf8;
insert into `user` (name, password) values ('admin', '123456');
insert into `user` (name, password) values ('zhangsan', '123456');
insert into `user` (name, password) values ('lisi', '123456');

CREATE TABLE role(
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(20) 
)DEFAULT CHARSET=utf8;
insert into `role` (name) values ('admin');
insert into `role` (name) values ('common');
insert into `role` (name) values ('test');

CREATE TABLE user_role(
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `userId` bigint(20)  ,
  `roleId` bigint(20)  
)DEFAULT CHARSET=utf8;

insert into user_role (`userId`,`roleId`) values (1,2);
insert into user_role (`userId`,`roleId`) values (2,1);
insert into user_role (`userId`,`roleId`) values (3,3);

CREATE TABLE permission(
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(20),
   type int,
   code varchar(255),
   url varchar(255)
	
)DEFAULT CHARSET=utf8;
insert into permission (name,type,code,url) values ('Dashboard',1,'menu_dashboard','/menu/dashboard');
insert into permission (name,type,code,url) values ('Charts',1,'menu_charts','/menu/charts');
insert into permission (name,type,code,url) values ('Tables',1,'menu_tables','/menu/tables');
insert into permission (name,type,code,url) values ('Components',1,'menu_components','/menu/components');
insert into permission (name,type,code,url) values ('Example Pages',1,'menu_example_pages','/menu/examplepages');
insert into permission (name,type,code,url) values ('Menu Levels',1,'menu_menu_levels','/menu/menulevels');
insert into permission (name,type,code,url) values ('Link',1,'menu_link','/menu/link');

CREATE TABLE role_permission(
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `permissionId` bigint(20)  ,
  `roleId` bigint(20)  
)DEFAULT CHARSET=utf8;

insert into role_permission (`permissionId`,`roleId`) values (1,1);
insert into role_permission (`permissionId`,`roleId`) values (2,1);
insert into role_permission (`permissionId`,`roleId`) values (3,1);
insert into role_permission (`permissionId`,`roleId`) values (4,1);
insert into role_permission (`permissionId`,`roleId`) values (5,1);
insert into role_permission (`permissionId`,`roleId`) values (6,1);
insert into role_permission (`permissionId`,`roleId`) values (7,1);

insert into role_permission (`permissionId`,`roleId`) values (1,2);
insert into role_permission (`permissionId`,`roleId`) values (2,2);
insert into role_permission (`permissionId`,`roleId`) values (3,2);

insert into role_permission (`permissionId`,`roleId`) values (1,3);
insert into role_permission (`permissionId`,`roleId`) values (4,3);
insert into role_permission (`permissionId`,`roleId`) values (5,3);




create table menu(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	parentId INT,
	url VARCHAR(100),
	levels INT,
	orders INT,
	style VARCHAR(100),
	createTime DateTime,
	updateTime DateTime,
	PRIMARY KEY ( id )
);
insert into menu (name,url,levels,style,  createTime, updateTime) values ('Dashboard','menu/dashboard',1,'fa-dashboard', current_date(), current_date());
insert into menu (name,url,levels,style,  createTime, updateTime) values ('Charts', 'menu/charts', 1, 'fa-area-chart',current_date(), current_date());
insert into menu (name,url,levels,style,  createTime, updateTime) values ('Tables', 'menu/tables', 1, 'fa-table',current_date(), current_date());
insert into menu (name,url,levels,style,  createTime, updateTime) values ('Components', 'menu/components', 1,' fa-wrench', current_date(), current_date());
insert into menu (name,url,levels,style,  createTime, updateTime) values ('Example Pages', 'menu/examplepages', 1, 'fa-file',current_date(), current_date());
insert into menu (name,url,levels,style,  createTime, updateTime) values ('Menu Levels', 'menu/menulevels', 1, 'fa-sitemap',current_date(), current_date());
insert into menu (name,url,levels,style,  createTime, updateTime) values ('Link', 'menu/link', 1, 'fa-link',current_date(), current_date());

insert into menu (name,parentId,levels,  createTime, updateTime) values ('Navbar',4,2, current_date(), current_date());
insert into menu (name,parentId,levels,  createTime, updateTime) values ('Cards',4,2, current_date(), current_date());

insert into menu (name,parentId,levels,  createTime, updateTime) values ('Login Page',5,2, current_date(), current_date());
insert into menu (name,parentId,levels,  createTime, updateTime) values ('Registration Page',5,2, current_date(), current_date());
insert into menu (name,parentId,levels,  createTime, updateTime) values ('Forgot Password Page',5,2, current_date(), current_date());
insert into menu (name,parentId,levels,  createTime, updateTime) values ('Blank Page',5,2, current_date(), current_date());

insert into menu (name,parentId,levels,  createTime, updateTime) values ('Second Level Item',6,2, current_date(), current_date());
insert into menu (name,parentId,levels,  createTime, updateTime) values ('Second Level Item',6,2, current_date(), current_date());
insert into menu (name,parentId,levels,  createTime, updateTime) values ('Second Level Item',6,2, current_date(), current_date());
insert into menu (name,parentId,levels,  createTime, updateTime) values ('Third Level',6,2, current_date(), current_date());


insert into menu (name,parentId,levels,  createTime, updateTime) values ('Third Level Item',17,3, current_date(), current_date());
insert into menu (name,parentId,levels,  createTime, updateTime) values ('Third Level Item',17,3, current_date(), current_date());
insert into menu (name,parentId,levels,  createTime, updateTime) values ('Third Level Item',17,3, current_date(), current_date());