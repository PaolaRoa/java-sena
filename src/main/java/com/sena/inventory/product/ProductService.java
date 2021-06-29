package com.sena.inventory.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductRepository productRepository1) {
        this.productRepository = productRepository1;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public boolean deleteProduct(int id){

       try {
           productRepository.deleteById(id);
           return true;
       }
       catch (Exception e){
            e.printStackTrace();
       }
        return false;
    }

    public Product getProduct(int id){
        return productRepository.getById(id);
    }

    public Product editProduct(Product product){

        boolean exists = productRepository.existsById(product.getId());
        if(exists){
            Product productInDB = productRepository.findById(product.getId()).get();
            if(productInDB != null){
                productInDB.setName(product.getName());
                productInDB.setBrand(product.getBrand());
                productInDB.setCost(product.getCost());
                productInDB.setPrice(product.getPrice());
                return productRepository.save(productInDB);
            }

        }
        return null;

    }

    public Boolean logicDelete(int id){
        boolean exists = productRepository.existsById(id);
        if(exists) {
            Product productInDB = productRepository.findById(id).get();
            productInDB.setStatus(false);
            productRepository.save(productInDB);
        }

        return exists;
    }

    public List<Product> findGreaterThan(Double price) {
        return productRepository.findByPriceGreaterThan(price);
    }
}