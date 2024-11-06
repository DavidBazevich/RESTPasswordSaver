package com.example.demo.service;

import com.example.demo.model.Website;

import java.util.List;


public interface IWebsiteService {
    List<Website> findAllSites();
    void saveWebsite(Website website);
    Website findByName(String name);
    Website updateWebsite(Website website);
    void deleteWebsite(String name);
}
