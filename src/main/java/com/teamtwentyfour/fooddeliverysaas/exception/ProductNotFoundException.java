package com.teamtwentyfour.fooddeliverysaas.exception;

public class ProductNotFoundException extends BaseException{

    public ProductNotFoundException(){
        super("Product Not Found.");
    }
}
