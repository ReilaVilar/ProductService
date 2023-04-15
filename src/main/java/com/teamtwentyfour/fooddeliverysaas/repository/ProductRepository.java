package com.teamtwentyfour.fooddeliverysaas.repository;

import com.teamtwentyfour.fooddeliverysaas.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Page<Product> findAll(Pageable pageable);

    List<Product> findByStoreid(String id);


}
