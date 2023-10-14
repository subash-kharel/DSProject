package com.product.catalog.controller;

import com.product.catalog.model.Catalog;
import com.product.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public List<Catalog> getAllCatalogs(){
        return catalogService.getAllCatalog();
    }

    @PostMapping
    public Catalog createCatalogItem(@RequestBody Catalog catalog) {
        return catalogService.createCatalogItem(catalog);
    }

    @GetMapping("/{id}")
    public Catalog getCatalogItemById(@PathVariable int id) {
        return catalogService.getCatalogItemById(id);
    }

    @PutMapping("/{id}")
    public Catalog updateCatalogItem(@PathVariable int id, @RequestBody Catalog updatedCatalog) {
        return catalogService.updateCatalogItem(id, updatedCatalog);
    }

    @DeleteMapping("/{id}")
    public void deleteCatalogItem(@PathVariable int id) {
        catalogService.deleteCatalogItem(id);
    }

}
