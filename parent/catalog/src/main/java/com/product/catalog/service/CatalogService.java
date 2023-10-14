package com.product.catalog.service;

import com.product.catalog.model.Catalog;
import com.product.catalog.repository.CatelogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private CatelogRepository catalogRepository;

    public List<Catalog> getAllCatalog(){
        return catalogRepository.findAll();
    }

    public Catalog getCatalogItemById(int id) {
        return catalogRepository.findById(id).orElse(null);
    }

    public Catalog createCatalogItem(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    //todo: create custom messages
    public Catalog updateCatalogItem(int id, Catalog updatedCatalog) {
        if (catalogRepository.existsById(id)) {
            updatedCatalog.setId(id);
            return catalogRepository.save(updatedCatalog);
        }
        return null;
    }

    public void deleteCatalogItem(int id) {
        catalogRepository.deleteById(id);
    }


}
