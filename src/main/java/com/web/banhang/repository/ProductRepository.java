package com.web.banhang.repository;

import com.web.banhang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByNameProduct(String nameProducd);

}
