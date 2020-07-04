create table if not exists ServiceItem (
  id varchar(50) not null,
  contain varchar(50) not null,
  type varchar(50) not null
);

create table if not exists ServicePackage (
  id identity,
  name varchar(50) not null,
  createdAt timestamp not null
);

create table if not exists ServicePackage_Item (
  service_package bigint not null,
  service_item varchar(4) not null
);

alter table ServicePackage_Item
    add foreign key (service_package) references ServicePackage(id);
alter table ServicePackage_Item
    add foreign key (service_item) references ServiceItem(id);

create table if not exists pkg_Order (
	id identity,
	deliveryName varchar(50) not null,
	deliveryProvince varchar(50) not null,
	deliveryCity varchar(50) not null,
	deliveryAddress varchar(50) not null,
	ccNumber varchar(16) not null,
	ccExpiration varchar(50) not null,
	ccCVV varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists pkg_Order_pkgs (
	pkgOrder bigint not null,
	pkg bigint not null
);

alter table pkg_Order_pkgs
    add foreign key (pkgOrder) references pkg_Order(id);
alter table pkg_Order_pkgs
    add foreign key (pkg) references ServicePackage(id);
