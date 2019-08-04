drop table if exists tb_product;
drop table if exists tb_product_comment;
drop table if exists tb_user;

-- 商品表
create table tb_product
(
   id                   int unsigned not null auto_increment comment '主键',
   name                 varchar(100) comment '商品名称',
   cover_image          varchar(100) comment '商品封面图片',
   price                int not null default 0 comment '商品价格(分)',
   primary key (id)
);
-- 商品评论表
create table tb_product_comment
(
   id                   int unsigned not null auto_increment comment '主键',
   product_id           int unsigned comment '所属商品',
   author_id            int unsigned comment '作者Id',
   content              varchar(200) comment '评论内容',
   created              TIMESTAMP comment '创建时间',
   primary key (id)
);
-- 用户表
create table tb_user
(
   id                   int unsigned not null auto_increment comment '主键',
   nickname             varchar(50) comment '用户昵称',
   avatar               varchar(255) comment '用户头像',
   primary key (id)
);
