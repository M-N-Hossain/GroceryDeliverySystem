package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.model.OrderProduct;
import com.example.grocerydeliverysystem.repositories.OrderProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderProductService {
    @Autowired
    OrderProductRepo orderProductRepo;

    public List<OrderProduct> getListOfOrderProducts(){
        return orderProductRepo.findAll();
    }

    public void addOrderProduct(OrderProduct productOrder){

        orderProductRepo.save(productOrder);
    }


    public OrderProduct updateOrderProduct(long id, OrderProduct productOrder){
        Optional<OrderProduct> retrieveOrderProduct = orderProductRepo.findById(id);
        if (retrieveOrderProduct.isPresent()){
            retrieveOrderProduct.get().setQuantity(productOrder.getQuantity());
            retrieveOrderProduct.get().setTotalWeight(productOrder.getTotalWeight());
            retrieveOrderProduct.get().setTotalPrice(productOrder.getTotalPrice());
            retrieveOrderProduct.get().setProductID(productOrder.getProductID());
            retrieveOrderProduct.get().setDeliveryInfoID(productOrder.getDeliveryInfoID());
            retrieveOrderProduct.get().setVanID(productOrder.getVanID());
            return orderProductRepo.save(retrieveOrderProduct.get());
        }
        else {
            throw new NoSuchElementException("Order product is not exist");
        }
    }

    public void deleteOrderProduct(long id){
        orderProductRepo.deleteById(id);
    }
}
