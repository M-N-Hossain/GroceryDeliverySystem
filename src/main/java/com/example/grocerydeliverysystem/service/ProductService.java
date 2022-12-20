package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.repositories.OrderProductRepo;
import com.example.grocerydeliverysystem.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderProductRepo orderProductRepo;

    public List<Product> getListOfProduct(){
        return productRepo.findAll();
    }

    public void addProduct(Product product){
        productRepo.save(product);
    }

    public Product updateProduct(long id, Product product){
        Optional<Product> retrieveProduct = productRepo.findById(id);
        if (retrieveProduct.isPresent()){
            retrieveProduct.get().setName(product.getName());
            retrieveProduct.get().setWeight(product.getWeight());
            retrieveProduct.get().setPrice(product.getPrice());
            return productRepo.save(retrieveProduct.get());
        }
        else {
            throw new NoSuchElementException("Product is not exist");
        }
    }

    public void deleteProduct(long id){
        Optional<Product> retrievedProduct = productRepo.findById(id);
        if (retrievedProduct.isPresent()){
//            orderProductRepo.deleteByProductID(retrievedProduct.get());
            productRepo.deleteById(id);
        }


    }

    public Product getProductByName(String name){
        Optional<Product> retrievedProducts = Optional.ofNullable(productRepo.getProductsByName(name));
        if (retrievedProducts.isPresent()){
            return retrievedProducts.get();
        }
        else {
            throw new NoSuchElementException("Product is not exist");
        }

    }

}
