package com.liujinji.serviceonline;

import lombok.Data;

@Data
public class Order {
    private String name;
    private String province;
    private String city;
    private String address;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
