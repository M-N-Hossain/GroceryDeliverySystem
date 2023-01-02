package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.model.Van;
import com.example.grocerydeliverysystem.repositories.VanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VanService {

    @Autowired
    VanRepo vanRepo;

    public List<Van> getListOfVan(){
        return vanRepo.findAll();
    }
}
