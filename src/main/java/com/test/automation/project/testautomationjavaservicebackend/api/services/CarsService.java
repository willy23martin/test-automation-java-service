package com.test.automation.project.testautomationjavaservicebackend.api.services;

import com.test.automation.project.testautomationjavaservicebackend.api.database.CarsDAO;
import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import com.test.automation.project.testautomationjavaservicebackend.api.model.binarytree.ArbolBinarioBusqueda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    private CarsDAO carsDAO;

    private ArbolBinarioBusqueda arbolBinarioBusqueda;

    public List<Car> getCars() {
        return carsDAO.getCarsDatabase();
    }

    public List<Car> searchCarsByPriceRange(double initialPrice, double finalPrice) {
        return null;
    }

    public List<Car> searchCarsByBrands(String brands) {
        return null;
    }
}
