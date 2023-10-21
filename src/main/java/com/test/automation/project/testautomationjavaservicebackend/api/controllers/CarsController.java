package com.test.automation.project.testautomationjavaservicebackend.api.controllers;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import com.test.automation.project.testautomationjavaservicebackend.api.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarsController {

    @Autowired
    private CarsService carsService;

    @RequestMapping(method = RequestMethod.GET, path = "/cars")
    public List<Car> getCars() {
        return carsService.getCars();
    }

}
