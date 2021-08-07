package com.example.productspring.controller;

import com.example.productspring.Exception.ProductNotFoundException;
import com.example.productspring.entity.Product;
import com.example.productspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public List<Product> getCustomer(){
        return productService.getProducts();
    }
    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId){
        Product theProduct = productService.getProduct(productId);
        if(theProduct == null){
            throw new ProductNotFoundException("Customer id not found -" + productId);
        }
        return theProduct;
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product theProduct){
        theProduct.setId(0);
        productService.saveProduct(theProduct);
        return theProduct;
    }
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product theProduct){
        productService.saveProduct(theProduct);
        return theProduct;
    }
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId){
        Product tempProduct = productService.getProduct(productId);
        if(tempProduct == null){
            throw new ProductNotFoundException("not found" + productId);
        }
        productService.deleteProduct(productId);
        return "delete" + productId;
    }
    @PostMapping("/buy/{productId}/{qty}")
    public String buyProduct(@PathVariable int id, @PathVariable int qty) {

        Product product =  productService.getProduct(id);
        product.setQuantity(product.getQuantity() - qty);

        productService.saveProduct(product);

        return "Buy Product id - " + id + ", with quantity - " + qty + "| quantity remaining in stock - " + product.getQuantity();

    }

}
