package com.example.grocerydeliverysystem.controller;

import com.example.grocerydeliverysystem.model.Delivery;
import com.example.grocerydeliverysystem.model.OrderProduct;
import com.example.grocerydeliverysystem.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/orderProduct")
public class OrderProductController {
    @Autowired
    OrderProductService orderProductService;

    @GetMapping
    public List<OrderProduct> getListOfOrderProducts(){
        return orderProductService.getListOfOrderProducts();
    }

    @PostMapping
    public ResponseEntity<OrderProduct> addDeliveryInfo(@RequestBody OrderProduct orderProduct){
        orderProductService.addOrderProduct(orderProduct);
        return new ResponseEntity<>(orderProduct, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderProduct> addDeliveryInfo(@PathVariable int id, @RequestBody OrderProduct orderProduct){
        try {
            orderProductService.updateOrderProduct(id,orderProduct);
            return new ResponseEntity<>(orderProduct, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderProduct> addDeliveryInfo(@PathVariable int id){
        try {
            orderProductService.deleteOrderProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
