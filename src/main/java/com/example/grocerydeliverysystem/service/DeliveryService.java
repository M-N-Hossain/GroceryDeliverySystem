package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.model.Delivery;
import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.repositories.DeliveryRepo;
import com.example.grocerydeliverysystem.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepo deliveryRepo;

    public List<Delivery> getListOfDeliveries(){
        return deliveryRepo.findAll();
    }

    public void addDeliveryInfo(Delivery delivery){
        deliveryRepo.save(delivery);
    }

    public Delivery updateDeliveryInfo(int id, Delivery delivery){
        Optional<Delivery> retrieveDelivery = deliveryRepo.findById(id);
        if (retrieveDelivery.isPresent()){
            retrieveDelivery.get().setDeliveryDate(delivery.getDeliveryDate());
            retrieveDelivery.get().setFromWarehouse(delivery.getFromWarehouse());
            retrieveDelivery.get().setDestination(delivery.getDestination());
            return deliveryRepo.save(retrieveDelivery.get());
        }
        else {
            throw new NoSuchElementException("Delivery info is not exist");
        }
    }

    public void deleteDeliveryInfo(int id){
        deliveryRepo.deleteById(id);
    }
}
