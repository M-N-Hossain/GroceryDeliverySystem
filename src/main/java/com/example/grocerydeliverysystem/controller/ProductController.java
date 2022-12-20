package com.example.grocerydeliverysystem.controller;

import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystemException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:63342")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getListOfProduct(){
        return productService.getListOfProduct();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        try {
            productService.updateProduct(id,product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id){
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/specificProduct")
    public ResponseEntity<Product> getProductByName(@RequestParam String name){
        try {
            return new ResponseEntity<>(productService.getProductByName(name), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
