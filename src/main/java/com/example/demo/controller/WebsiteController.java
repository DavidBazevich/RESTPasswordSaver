package com.example.demo.controller;

import com.example.demo.model.Website;
import com.example.demo.service.IWebsiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/websites")
@AllArgsConstructor
public class WebsiteController {

    private final IWebsiteService websiteService;

    @GetMapping
    public List<Website> findAllSites(){
        return websiteService.findAllSites();
    }

    @GetMapping("/{name}")
    public Website findByName(@PathVariable String name){
        return websiteService.findByName(name);
    }

    @PostMapping("save_site")
    public String addWebsite(@RequestBody Website website){
        websiteService.saveWebsite(website);
        return "OK!";
    }

    @PutMapping("update_site")
    public Website updateWebsite(@RequestBody Website website){
        return websiteService.updateWebsite(website);
    }

    @DeleteMapping("delete_site/{name}")
    public void deleteWebsite(@PathVariable String name){
        websiteService.deleteWebsite(name);
    }


}
