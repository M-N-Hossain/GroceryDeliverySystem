package com.example.grocerydeliverysystem.controller;

import com.example.grocerydeliverysystem.model.DeliveryInfo;
import com.example.grocerydeliverysystem.service.DeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/delivery")
@CrossOrigin(origins = "http://localhost:63342")
public class DeliveryInfoController {
    @Autowired
    DeliveryInfoService deliveryInfoService;

    @GetMapping
    public List<DeliveryInfo> getListOfDeliveryInfos(){
        return deliveryInfoService.getListOfDeliveryInfos();
    }

    @PostMapping
    public ResponseEntity<DeliveryInfo> addDeliveryInfo(@RequestBody DeliveryInfo deliveryInfo){
        deliveryInfoService.addDeliveryInfo(deliveryInfo);
        return new ResponseEntity<>(deliveryInfo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryInfo> addDeliveryInfo(@PathVariable int id, @RequestBody DeliveryInfo deliveryInfo){
        try {
            deliveryInfoService.updateDeliveryInfo(id, deliveryInfo);
            return new ResponseEntity<>(deliveryInfo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeliveryInfo> addDeliveryInfo(@PathVariable int id){
        try {
            deliveryInfoService.deleteDeliveryInfo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
