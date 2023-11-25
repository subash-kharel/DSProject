package com.product.catalog.controller;

import com.product.catalog.model.Catalog;
import com.product.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value="v1/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    @RolesAllowed({ "ADMIN", "USER" })
    public List<Catalog> getAllCatalogs(){
        return catalogService.getAllCatalog();
    }

    @RolesAllowed({ "ADMIN" })
    @PostMapping
    public Catalog createCatalogItem(@RequestBody Catalog catalog) {
        return catalogService.createCatalogItem(catalog);
    }

    @GetMapping("/{id}")
    @RolesAllowed({ "ADMIN", "USER" })
    public Catalog getCatalogItemById(@PathVariable int id) {
        return catalogService.getCatalogItemById(id);
    }

    @PutMapping("/{id}")
    @RolesAllowed({ "ADMIN", "USER" })
    public Catalog updateCatalogItem(@PathVariable int id, @RequestBody Catalog updatedCatalog) {
        return catalogService.updateCatalogItem(id, updatedCatalog);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed({ "ADMIN"})
    public void deleteCatalogItem(@PathVariable int id) {
        catalogService.deleteCatalogItem(id);
    }

}
