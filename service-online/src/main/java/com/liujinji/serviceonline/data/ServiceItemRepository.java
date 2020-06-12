package com.liujinji.serviceonline.data;

import com.liujinji.serviceonline.ServiceItem;

public interface ServiceItemRepository {
    Iterable<ServiceItem> findAll();
    ServiceItem findOne(String id);
    ServiceItem save(ServiceItem serviceItem);
}
