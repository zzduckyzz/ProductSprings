package com.example.productspring.service;

import com.example.productspring.dao.ProductRepository;
import com.example.productspring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;


    @Override
    @Transactional
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProduct(Product theProduct) {
        productRepository.save(theProduct);
    }

    @Override
    public Product getProduct(int pId) {
        return productRepository.getById(pId);
    }

    @Override
    public void deleteProduct(int pId) {
        productRepository.deleteById(pId);
    }


}
