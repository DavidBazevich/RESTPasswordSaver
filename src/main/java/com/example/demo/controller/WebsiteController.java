package com.example.demo.controller;

import com.example.demo.model.Website;
import com.example.demo.service.IWebsiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/websites")
@AllArgsConstructor
public class WebsiteController {

    private final IWebsiteService websiteService;

    @GetMapping
    public ResponseEntity<List<Website>> findAllSites(){
        List<Website> websites = websiteService.findAllSites();
        if (!websites.isEmpty()) return ResponseEntity.ok(websites);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Website> findByName(@PathVariable String name){
        Website website = websiteService.findByName(name);
        if(website != null) return ResponseEntity.ok(website);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("save_site")
    public ResponseEntity<String> addWebsite(@RequestBody Website website){
        websiteService.saveWebsite(website);
        return new ResponseEntity<>("Website was added", HttpStatus.CREATED);
    }

    @PutMapping("update_site")
    public Website updateWebsite(@RequestBody Website website){
        return websiteService.updateWebsite(website);
    }

    @DeleteMapping("delete_site/{name}")
    public ResponseEntity<String> deleteWebsite(@PathVariable String name){
        List<Website> websites = websiteService.findAllSites();
        Website thisWebsite = websiteService.findByName(name);
        if (websites.contains(thisWebsite)){
            websiteService.deleteWebsite(name);
            return ResponseEntity.ok("Job was delete");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
