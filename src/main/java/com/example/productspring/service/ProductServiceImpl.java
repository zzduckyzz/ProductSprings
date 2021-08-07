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
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product Create(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product getById(int pid) {
        return productRepository.getById(pid);
    }

    @Override
    @Transactional
    public Product update(int id, Product theProduct) {
        Product product = productRepository.findById(id).get();
        product.setQuantity(product.getQuantity() - theProduct.getQuantity());
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product save(Product theProduct) {
        return productRepository.save(theProduct);
    }

    @Override
    @Transactional
    public void deletebyId(int theId) {
        productRepository.deleteById(theId);
    }
}
