package com.example.demo.controller;


import com.example.demo.model.Website;
import com.example.demo.service.IWebsiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("websites")
@AllArgsConstructor
public class FormController {

    IWebsiteService websiteService;

    @GetMapping
    public String allWebsites(Model model) {
        List<Website> websites = websiteService.findAllSites();
        model.addAttribute("websites", websites);
        return "site";
    }

}
