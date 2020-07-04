delete from pkg_Order_pkgs;
delete from ServicePackage_Item;
delete from ServicePackage;
delete from pkg_Order;

delete from ServiceItem;
insert into ServiceItem (id, contain, type)
                values ('data-20', '20G流量', 'DATA');
insert into ServiceItem (id, contain, type)
                values ('data-30', '30G流量', 'DATA');
insert into ServiceItem (id, contain, type)
                values ('data-40', '40G流量', 'DATA');
insert into ServiceItem (id, contain, type)
                values ('sms-100', '100条短信包', 'SMS');
insert into ServiceItem (id, contain, type)
                values ('sms-200', '200条短信包', 'SMS');
insert into ServiceItem (id, contain, type)
                values ('voice-100', '100分钟语音包', 'VOICE');
insert into ServiceItem (id, contain, type)
                values ('voice-200', '200分钟语音包', 'VOICE');
insert into ServiceItem (id, contain, type)
                values ('lan-500', '500Mbps宽带', 'WIRED_WAN');
insert into ServiceItem (id, contain, type)
                values ('lan-1000', '1000Mbps宽带', 'WIRED_WAN');
insert into ServiceItem (id, contain, type)
                values ('free-am', 'AppleMusic定向包', 'FREE_APP');
insert into ServiceItem (id, contain, type)
                values ('free-tv', '视频定向包', 'FREE_APP');