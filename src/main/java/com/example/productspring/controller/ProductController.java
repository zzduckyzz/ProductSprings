package com.example.productspring.controller;

import com.example.productspring.entity.Product;
import com.example.productspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/getAll")
    public List<Product> listAll(){
        return productService.listAll();
    }
    @GetMapping
    public Product getProduct(@PathVariable int productId){
        Product theProduct = productService.get(customerId);
        if(theCustomer == null){
            throw new CustomerNotFoundException("Customer id not found -" + customerId);
        }
        return theCustomer;
    }


    @PostMapping("/addProduct")
    public Product Create(@RequestBody Product product) {
        Product product1 = productService.save(product);
        return product1;
    }
    @PutMapping("/buy")
    public ResponseEntity<Product> update(@RequestBody Product theProduct) {
        Product product = productService.update(theProduct.getId(),theProduct);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @DeleteMapping({"/{productId}"})
    public ResponseEntity<String> deletepbyId(@PathVariable("productId") int theId) {
        try {
            productService.deletebyId(theId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Not find by id: " + e,HttpStatus.NO_CONTENT);
        }

    }
}
