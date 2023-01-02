package com.example.grocerydeliverysystem.controller;

import com.example.grocerydeliverysystem.model.Van;
import com.example.grocerydeliverysystem.service.VanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/van")
@CrossOrigin(origins = "http://localhost:63342")
public class VanController {

    @Autowired
    VanService vanService;

    @GetMapping
    public List<Van> getListOfVan (){
        return vanService.getListOfVan();
    }
}
