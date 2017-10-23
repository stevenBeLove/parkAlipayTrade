/***用户名为；qtfans  ****/
create sequence seq_sysSaleSeq 
minvalue 200       
maxvalue 99999999  
start with 200    
increment by 1   
nocache;

create sequence seq_scale 
minvalue 50       
maxvalue 99999999  
start with 50    
increment by 1   
nocache;

create sequence seq_agency 
minvalue 50       
maxvalue 99999999  
start with 50    
increment by 1   
nocache;


create table tb_fans_sys_filter
(
  id   INTEGER not null  PRIMARY KEY,
  name VARCHAR2(50),
  url  VARCHAR2(200),
  roles  varchar2(100),
  permissions     VARCHAR2(50)
);
comment on table tb_fans_sys_filter is 'Url过滤表';
comment on column tb_fans_sys_filter.name is '名称';
comment on column tb_fans_sys_filter.url is 'URL地址';
comment on column tb_fans_sys_filter.roles is '角色列表';
comment on column tb_fans_sys_filter.permissions is '权限操作符';

create unique index idx_fans_filterurl on tb_fans_sys_filter(url);

create table tb_fans_sys_user (
  id  INTEGER not null,
  organization_id INTEGER,
  nickname VARCHAR2(100),
  username VARCHAR2(100),
  password VARCHAR2(100),
  salt VARCHAR2(100),
  role_ids VARCHAR2(100),
  locked char(1),
  createDate timestamp
);
alter table tb_fans_sys_user add constraint idx_pk primary key(id);
create unique index idx_fans_username on tb_fans_sys_user(username);
create index idx_fans_organization on tb_fans_sys_user(organization_id);



comment on table tb_fans_sys_user is '系统用户表';
comment on column tb_fans_sys_user.id is '主键Id';
comment on column tb_fans_sys_user.organization_id is '机构Id';
comment on column tb_fans_sys_user.nickname is '昵称';
comment on column tb_fans_sys_user.username is '用户名';
comment on column tb_fans_sys_user.password is '密码';
comment on column tb_fans_sys_user.salt is '加密盐';
comment on column tb_fans_sys_user.role_ids is '权限Id';
comment on column tb_fans_sys_user.locked is '是否锁定0可用1锁定';


create table tb_fans_sys_organization (
  id INTEGER not null,
  name VARCHAR2(100),
  parent_id INTEGER,
  parent_ids VARCHAR2(100),
  available char(1)
);
alter table tb_fans_sys_organization add constraint pk_fans_sys_organization primary key(id);
create index idx_fans_org_parent_id on tb_fans_sys_organization(parent_id);
create index idx_fans_org_parent_ids on tb_fans_sys_organization(parent_ids);

comment on table tb_fans_sys_organization is '组织机构表';
comment on column tb_fans_sys_organization.id is '主键Id';
comment on column tb_fans_sys_organization.name is '机构名称';
comment on column tb_fans_sys_organization.parent_id is '父编号';
comment on column tb_fans_sys_organization.parent_ids is '父编号列表';
comment on column tb_fans_sys_organization.available is '是否可用:0可用 1不可用';


create table tb_fans_sys_resource (
  id INTEGER not null,
  name VARCHAR2(100),
  type VARCHAR2(50),
  url VARCHAR2(200),
  parent_id INTEGER,
  parent_ids VARCHAR2(100),
  permission VARCHAR2(100),
  available char(1),
  icon varchar2(100)
);
alter table tb_fans_sys_resource add constraint tb_fans_sys_res_id primary key(id);
create index idx_tb_fans_sys_res_parent_id on tb_fans_sys_resource(parent_id);
create index idx_tb_fans_sys_res_parent_ids on tb_fans_sys_resource(parent_ids);

comment on table tb_fans_sys_resource is '系统资源表';
comment on column tb_fans_sys_resource.id is '主键Id';
comment on column tb_fans_sys_resource.name is '资源名称';
comment on column tb_fans_sys_resource.type is '资源类型';
comment on column tb_fans_sys_resource.url is '资源路径';
comment on column tb_fans_sys_resource.parent_id is '父编号';
comment on column tb_fans_sys_resource.parent_ids is '父编号列表';
comment on column tb_fans_sys_resource.permission is '权限字符串';
comment on column tb_fans_sys_resource.available is '是否可用:0可用 1不可用';
comment on column tb_fans_sys_resource.icon is '图标';

create table tb_fans_sys_role (
  id INTEGER not null,
  role VARCHAR2(100),
  description VARCHAR2(100),
  resource_ids VARCHAR2(4000),
  available char(1)
);
alter table tb_fans_sys_role add constraint pk_fans_sys_role_id primary key(id);


comment on table tb_fans_sys_role is '权限资源表';
comment on column tb_fans_sys_role.id is '主键Id';
comment on column tb_fans_sys_role.role is '权限名称';
comment on column tb_fans_sys_role.description is '描述';
comment on column tb_fans_sys_role.resource_ids is '资源列表Id';
comment on column tb_fans_sys_role.available is '是否可用:0可用 1不可用';




insert into tb_fans_sys_user (ID, ORGANIZATION_ID, USERNAME, PASSWORD, SALT, ROLE_IDS, LOCKED, NICKNAME)
values (1, 1, 'admin', '42b27bcfc84a0ddc3c462faedbc60a68', 'YWRtaW4=', '1,', '0', '超级管理员');

insert into tb_fans_sys_user (ID, ORGANIZATION_ID, USERNAME, PASSWORD, SALT, ROLE_IDS, LOCKED, NICKNAME)
values (2, 1, 'test', 'e10adc3949ba59abbe56e057f20f883e', 'YWRtaW4=', '1,', '0', '超级管理员1');

insert into tb_fans_sys_user (ID, ORGANIZATION_ID, USERNAME, PASSWORD, SALT, ROLE_IDS, LOCKED, NICKNAME)
values (3, 1, 'shenji', '447140e7d822c9f936a111e5d26162da', 'YWRtaW4=', '1,', '0', '神机');


insert into tb_fans_sys_role (ID, ROLE, DESCRIPTION, RESOURCE_IDS, AVAILABLE)
values (66, 'operator', '操作员', '53,56,57,58,59,96,97,98,99,100,101,102,103,127,', '0');

insert into tb_fans_sys_role (ID, ROLE, DESCRIPTION, RESOURCE_IDS, AVAILABLE)
values (1, 'superAdmin', '超级管理员', '53,54,56,57,58,59,70,71,74,76,81,82,83,84,85,91,92,96,97,98,99,100,101,102,103,', '1');

insert into tb_fans_sys_role (ID, ROLE, DESCRIPTION, RESOURCE_IDS, AVAILABLE)
values (138, 'develop', '神机研发', '53,54,56,57,58,59,70,71,74,76,81,91,96,97,98,99,100,101,102,103,127,', '0');



insert into tb_fans_sys_filter (ID, NAME, URL, ROLES, PERMISSIONS)
values (129, '重新加载缓存', '/reloadMeta.do', 'operator,', null);



insert into tb_fans_sys_organization (ID, NAME, PARENT_ID, PARENT_IDS, AVAILABLE)
values (108, '运营部', 1, '0/1/', '0');

insert into tb_fans_sys_organization (ID, NAME, PARENT_ID, PARENT_IDS, AVAILABLE)
values (1, '总公司', 0, '0/', '1');

insert into tb_fans_sys_organization (ID, NAME, PARENT_ID, PARENT_IDS, AVAILABLE)
values (2, '技术部', 1, '0/1/', '1');




insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (201, '分润管理', 'menu', null, 1, '0/1/', 'splitfee:view', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (202, '分润查询', 'menu', null, 201, '0/1/201/', 'splitfee:view', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (77, '资源新增', 'button', null, 76, '0/1/70/76/', 'resource:create', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (78, '资源修改', 'button', null, 76, '0/1/70/76/', 'resource:update', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (79, '资源删除', 'button', null, 76, '0/1/70/76/', 'resource:delete', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (80, '资源查看', 'button', null, 76, '0/1/70/76/', 'resource:view', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (81, '角色管理', 'menu', 'role', 70, '0/1/70/', 'role:*', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (82, '角色新增', 'button', null, 81, '0/1/70/81/', 'role:create', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (83, '角色修改', 'button', null, 81, '0/1/70/81/', 'role:update', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (84, '角色删除', 'button', null, 81, '0/1/70/81/', 'role:delete', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (85, '角色查看', 'button', null, 81, '0/1/70/81/', 'role:view', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (86, '组织机构删除', 'button', null, 71, '0/1/70/71/', 'organization:delete', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (87, '组织机构查看', 'button', null, 71, '0/1/70/71/', 'organization:view', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (88, '用户修改', 'button', null, 74, '0/1/70/74/', 'user:update', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (89, '用户删除', 'button', null, 74, '0/1/70/74/', 'user:delete', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (90, '用户查看', 'button', null, 74, '0/1/70/74/', 'user:view', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (91, 'URL管理', 'menu', 'urlFilter', 70, '0/1/70/', 'urlFilter:*', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (92, 'URL新增', 'button', null, 91, '0/1/70/91/', 'urlFilter:create', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (93, 'URL修改', 'button', null, 91, '0/1/70/91/', 'urlFilter:update', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (94, 'URL删除', 'button', null, 91, '0/1/70/91/', 'urlFilter:delete', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (95, 'URL查看', 'button', null, 91, '0/1/70/91/', 'urlFilter:view', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (100, '机构管理', 'menu', null, 1, '0/1/', 'compare:view', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (101, '机构管理', 'menu', 'agency/listPage', 100, '0/1/100/', 'agency:view', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (102, '代理商纵向比较', 'menu', 'zchart.do', 100, '0/1/100/', 'zchart:*', '0', 'cus- cus--icon4');

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (103, '代理商按月统计', 'menu', 'mchart.do', 100, '0/1/100/', 'mchart:*', '0', 'cus- cus--icon9');

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (76, '资源管理', 'menu', 'resource', 70, '0/1/70/', 'resource:*', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (1, '资源', 'menu', null, 0, '0/', null, '1', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (70, '权限管理', 'menu', null, 1, '0/1/', 'manage:*', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (71, '组织机构管理', 'menu', 'organization', 70, '0/1/70/', 'organization:*', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (72, '组织机构新增', 'button', null, 71, '0/1/70/71/', 'organization:create', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (73, '组织机构修改', 'button', null, 71, '0/1/70/71/', 'organization:update', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (74, '用户管理', 'menu', 'user', 70, '0/1/70/', 'user:*', '0', null);

insert into tb_fans_sys_resource (ID, NAME, TYPE, URL, PARENT_ID, PARENT_IDS, PERMISSION, AVAILABLE, ICON)
values (75, '用户新增', 'button', null, 74, '0/1/70/74/', 'user:create', '0', null);


