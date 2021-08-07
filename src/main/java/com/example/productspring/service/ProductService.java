package com.example.productspring.service;

import com.example.productspring.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listAll();

    public Product Create(Product product);

    public Product getById(int pid);

    public Product update(int id, Product theProduct);

    public Product save(Product theProduct);

    public void deletebyId(int theId);

}
