package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.model.DeliveryInfo;
import com.example.grocerydeliverysystem.repositories.DeliveryInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeliveryInfoService {
    @Autowired
    DeliveryInfoRepo deliveryInfoRepo;

    public List<DeliveryInfo> getListOfDeliveryInfos(){
        return deliveryInfoRepo.findAll();
    }

    public void addDeliveryInfo(DeliveryInfo deliveryInfo){
        deliveryInfoRepo.save(deliveryInfo);
    }

    public DeliveryInfo updateDeliveryInfo(int id, DeliveryInfo deliveryInfo){
        Optional<DeliveryInfo> retrieveDelivery = deliveryInfoRepo.findById(id);
        if (retrieveDelivery.isPresent()){
            retrieveDelivery.get().setDeliveryDate(deliveryInfo.getDeliveryDate());
            retrieveDelivery.get().setFromWarehouse(deliveryInfo.getFromWarehouse());
            retrieveDelivery.get().setDestination(deliveryInfo.getDestination());
            return deliveryInfoRepo.save(retrieveDelivery.get());
        }
        else {
            throw new NoSuchElementException("Delivery info is not exist");
        }
    }

    public void deleteDeliveryInfo(int id){
        deliveryInfoRepo.deleteById(id);
    }
}
