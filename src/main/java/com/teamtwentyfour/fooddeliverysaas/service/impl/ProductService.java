package com.teamtwentyfour.fooddeliverysaas.service.impl;

import com.teamtwentyfour.fooddeliverysaas.dto.ProductRequest;
import com.teamtwentyfour.fooddeliverysaas.dto.ProductResponse;
import com.teamtwentyfour.fooddeliverysaas.exception.ProductNotFoundException;
import com.teamtwentyfour.fooddeliverysaas.model.Product;
import com.teamtwentyfour.fooddeliverysaas.repository.ProductRepository;
import com.teamtwentyfour.fooddeliverysaas.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements ProductServiceImpl {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .desc(productRequest.getDesc())
                .price(productRequest.getPrice())
                .storeid(productRequest.getStoreid())
                .build();
        product.setCreatedAt(LocalDateTime.now());
        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    @Override
    public List<ProductResponse> getProduct(String id) {
        final Optional<Product> product = productRepository.findById(id);

        return product.stream().map(this::mapToProductResponse).toList();
    }

    @Override
    public void update(ProductRequest newProduct) {
        final Product product = productRepository.findById(newProduct.getId()).orElseThrow(ProductNotFoundException::new);
        if(!(newProduct.getName() == null)){
            product.setName(newProduct.getName());
        }
        if(!(newProduct.getDesc() == null)){
            product.setDesc(newProduct.getDesc());
        }
        if(newProduct.getPrice() != 0){
            product.setPrice(newProduct.getPrice());
        }
        if(!(newProduct.getStoreid() == null)){
            product.setStoreid(newProduct.getStoreid());
        }
        product.setUpdatedAt(LocalDateTime.now());
        productRepository.save(product);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponse> getProductsByStore(String storeid) {
        List<Product> products = productRepository.findByStoreid(storeid);

        return products.stream().map(this::mapToProductResponse).toList();
    }


    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .desc(product.getDesc())
                .price(product.getPrice())
                .storeid(product.getStoreid())
                .build();
    }

    private void nowCreated(Product product) {
        product.setCreatedAt(LocalDateTime.now());
    }

    private void nowUpdated(Product product) {
        product.setUpdatedAt(LocalDateTime.now());
    }
}
