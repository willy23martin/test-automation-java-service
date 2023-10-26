package com.test.automation.project.testautomationjavaservicebackend.api.controllers;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import com.test.automation.project.testautomationjavaservicebackend.api.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping( "/cars")
    public List<Car> getCars() {
        System.out.println("Calling cars endpoint to retrieve them.");
        return carsService.getCars();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Car> searchCarsByPriceRange(@RequestParam(value = "initialPrice", defaultValue = "0.0") String initialPrice,
                                            @RequestParam(value = "finalPrice", defaultValue = "0.0") String finalPrice) throws Exception {
        return carsService.searchCarsByPriceRange(Double.parseDouble(initialPrice), Double.parseDouble(finalPrice));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchBrands")
    public List<Car> filterCarsByBrands(@RequestParam(value = "brands", defaultValue = "BMW,Kia,Porche") String brands) throws Exception {
        return carsService.searchCarsByBrands(brands);
    }

}
