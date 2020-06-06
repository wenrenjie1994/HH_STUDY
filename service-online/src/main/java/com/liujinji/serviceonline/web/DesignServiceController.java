package com.liujinji.serviceonline.web;

import com.liujinji.serviceonline.ServiceItem;
import com.liujinji.serviceonline.ServiceItem.Type;
import com.liujinji.serviceonline.ServicePackage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignServiceController {
    @GetMapping
    public String showDesignPage(Model model) {
        List<ServiceItem> serviceItems = Arrays.asList(
                new ServiceItem("sms-50", "50条短信包", Type.SMS),
                new ServiceItem("sms-100", "100条短信包", Type.SMS),
                new ServiceItem("vo-100", "100分钟通话", Type.VOICE),
                new ServiceItem("vo-200", "200分钟通话", Type.VOICE),
                new ServiceItem("data-10", "10GB流量", Type.DATA),
                new ServiceItem("data-20", "20GB流量", Type.DATA),
                new ServiceItem("wan-300", "300Mbps宽带", Type.WIRED_WAN),
                new ServiceItem("wan-500", "500Mbps宽带", Type.WIRED_WAN),
                new ServiceItem("free-qm", "QQ音乐定向", Type.FREE_APP),
                new ServiceItem("free-am", "Apple Music定向", Type.FREE_APP)
        );
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(serviceItems, type));
        }
        model.addAttribute("design",new ServicePackage());
        return "design";
    }

    private List<ServiceItem> filterByType(List<ServiceItem> serviceItems, Type type) {
        return serviceItems.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
