package com.teamtwentyfour.fooddeliverysaas.service;

import com.teamtwentyfour.fooddeliverysaas.dto.ProductRequest;
import com.teamtwentyfour.fooddeliverysaas.dto.ProductResponse;
import com.teamtwentyfour.fooddeliverysaas.model.Product;

import java.util.List;


public interface ProductServiceImpl {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    List<ProductResponse> getProduct(String id);

    void update(ProductRequest productRequest);

    void delete(String id);

    List<ProductResponse> getProductsByStore(String storeid);


}
