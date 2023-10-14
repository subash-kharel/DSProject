package com.product.catalog.repository;

import com.product.catalog.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatelogRepository extends JpaRepository<Catalog, Integer> {
}
