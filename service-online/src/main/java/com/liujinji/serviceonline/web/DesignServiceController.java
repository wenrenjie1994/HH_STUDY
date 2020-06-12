package com.liujinji.serviceonline.web;

import com.liujinji.serviceonline.ServiceItem;
import com.liujinji.serviceonline.ServiceItem.Type;
import com.liujinji.serviceonline.ServicePackage;
import com.liujinji.serviceonline.data.ServiceItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignServiceController {
    private final ServiceItemRepository serviceItemRepository;

    @Autowired
    public DesignServiceController(ServiceItemRepository serviceItemRepository) {
        this.serviceItemRepository = serviceItemRepository;
    }

    @GetMapping
    public String showDesignPage(Model model) {
        List<ServiceItem> serviceItems = new ArrayList<>();
        serviceItemRepository.findAll().forEach(serviceItems::add);

        Type[] types = ServiceItem.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(serviceItems, type));
        }
        model.addAttribute("design", new ServicePackage());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid ServicePackage design, Errors errors) {
        if (errors.hasErrors()) {
            log.warn("校验不通过");
            return "/home";
        }
        log.info("Processing design: " + design);
        return "redirect:/orders";
    }

    private List<ServiceItem> filterByType(List<ServiceItem> serviceItems, Type type) {
        return serviceItems.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
