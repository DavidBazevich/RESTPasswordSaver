package com.example.demo.repository;

import com.example.demo.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebsitesRepository extends JpaRepository<Website, Long> {
    void deleteByWebsiteName(String name);
    Website findWebsiteByWebsiteName(String name);
}
