package com.test.automation.project.testautomationjavaservicebackend.api.controllers;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import com.test.automation.project.testautomationjavaservicebackend.api.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarsSearchController {

    @Autowired
    private CarsService carsService;

    @RequestMapping(method = RequestMethod.GET, value = "search")
    public List<Car> searchCarsByPriceRange(@RequestParam(value = "initialPrice", defaultValue = "0.0") String initialPrice,
                                            @RequestParam(value = "finalPrice", defaultValue = "0.0") String finalPrice) throws Exception {
        return carsService.searchCarsByPriceRange(Double.parseDouble(initialPrice), Double.parseDouble(finalPrice));
    }

    @RequestMapping(method = RequestMethod.GET, value = "searchBrands")
    public List<Car> filterCarsByBrands(@RequestParam(value = "brands", defaultValue = "Mazda, B, C") String brands) throws Exception {
        return carsService.searchCarsByBrands(brands);
    }

}
