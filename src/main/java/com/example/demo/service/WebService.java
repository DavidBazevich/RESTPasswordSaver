package com.example.demo.service;

import com.example.demo.model.Website;
import com.example.demo.repository.WebsitesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WebService implements IWebsiteService{

    private final WebsitesRepository websitesRepository;

    @Override
    public List<Website> findAllSites() {
        return websitesRepository.findAll();
    }

    @Override
    public void saveWebsite(Website website) {
        websitesRepository.save(website);
    }

    @Override
    public Website findByName(String name) {
        return websitesRepository.findWebsiteByWebsiteName(name);
    }

    @Override
    public Website updateWebsite(Website website) {
        return websitesRepository.save(website);
    }

    @Override
    @Transactional
    public void deleteWebsite(String name) {
        websitesRepository.deleteByWebsiteName(name);
    }
}
