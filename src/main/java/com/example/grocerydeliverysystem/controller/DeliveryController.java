package com.example.grocerydeliverysystem.controller;

import com.example.grocerydeliverysystem.model.Delivery;
import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.repositories.DeliveryRepo;
import com.example.grocerydeliverysystem.service.DeliveryService;
import com.example.grocerydeliverysystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/delivery")
@CrossOrigin(origins = "http://localhost:63342")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @GetMapping
    public List<Delivery> getListOfDeliveries(){
        return deliveryService.getListOfDeliveries();
    }

    @PostMapping
    public ResponseEntity<Delivery> addDeliveryInfo(@RequestBody Delivery delivery){
        deliveryService.addDeliveryInfo(delivery);
        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delivery> addDeliveryInfo(@PathVariable int id, @RequestBody Delivery delivery){
        try {
            deliveryService.updateDeliveryInfo(id,delivery);
            return new ResponseEntity<>(delivery, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Delivery> addDeliveryInfo(@PathVariable int id){
        try {
            deliveryService.deleteDeliveryInfo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
