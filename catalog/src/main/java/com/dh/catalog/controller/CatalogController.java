package com.dh.catalog.controller;

import com.dh.catalog.model.Subject;
import com.dh.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CatalogController {
    private CatalogService catalogService;

    @Autowired
    private CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/catalog/findAll")
    public List<Subject> findAll() {
        return catalogService.findAll();
    }

}