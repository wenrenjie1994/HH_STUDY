package com.liujinji.serviceonline;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ServiceItem {
    private final String id;//子项ID
    private final String contain;//子项内容
    private final Type type;//子项类型

    public static enum Type {
        DATA, VOICE, SMS, WIRED_WAN, FREE_APP //上网数据，语音时常，短信包，有线网络，定向APP
    }
}
