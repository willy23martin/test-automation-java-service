package com.test.automation.project.testautomationjavaservicebackend.api.services;

import com.test.automation.project.testautomationjavaservicebackend.api.database.CarsDAO;
import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure.ArbolBinario;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    private CarsDAO carsDAO;

    private ArbolBinario<Car> carsBinaryTree;

    public List<Car> getCars() {
        return carsBinaryTree.recorrerInorden();
    }

    public List<Car> searchCarsByPriceRange(double initialPrice, double finalPrice) {
        return null;
    }

    public List<Car> searchCarsByBrands(String brands) {
        return null;
    }

    @PostConstruct
    public void loadCarsDataInMemory(){
        carsBinaryTree = new ArbolBinario<>();
        for (Car car: carsDAO.getCarsDatabase()) {
            carsBinaryTree.agregarElemento(car);
        }
    }
}
