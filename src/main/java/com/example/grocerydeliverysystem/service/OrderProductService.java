package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.model.OrderProduct;
import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.repositories.OrderProductRepo;
import com.example.grocerydeliverysystem.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepo orderProductRepo;
    @Autowired
    ProductRepo productRepo;

    public List<OrderProduct> getListOfOrderProducts(){
        return orderProductRepo.findAll();
    }

    public void addOrderProduct(OrderProduct productOrder){
            orderProductRepo.save(productOrder);
    }

    public OrderProduct updateOrderProduct(int id, OrderProduct productOrder){
        Optional<OrderProduct> retrieveOrderProduct = orderProductRepo.findById(id);
        if (retrieveOrderProduct.isPresent()){
            retrieveOrderProduct.get().setQuantity(productOrder.getQuantity());
            retrieveOrderProduct.get().setTotalPrice(productOrder.getTotalPrice());
            retrieveOrderProduct.get().setProductID(productOrder.getProductID());
            retrieveOrderProduct.get().setDeliverID(productOrder.getDeliverID());
            return orderProductRepo.save(retrieveOrderProduct.get());
        }
        else {
            throw new NoSuchElementException("Delivery info is not exist");
        }
    }

    public void deleteOrderProduct(int id){
        orderProductRepo.deleteById(id);
    }
}
