package com.test.automation.project.testautomationjavaservicebackend.api.services;

import com.test.automation.project.testautomationjavaservicebackend.api.database.CarsDAO;
import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure.ArbolBinario;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarsService {

    @Autowired
    private CarsDAO carsDAO;

    private ArbolBinario<Car> carsBinaryTree;

    public List<Car> getCars() {
        return carsBinaryTree.recorrerInorden();
    }

    public List<Car> searchCarsByPriceRange(double initialPrice, double finalPrice) throws IllegalArgumentException {
        validatePriceRange(initialPrice, finalPrice);
        List<Car> filteredCarsByPriceRange = new ArrayList<>();
        for (Car car: carsBinaryTree.recorrerInorden()) {
            int comparisonAgainstInitialPrice = Double.compare(car.getPrice(), initialPrice);
            int comparisonAgainstFinalPrice = Double.compare(car.getPrice(), finalPrice);
            if(carPriceIsBetweenRange(comparisonAgainstInitialPrice, comparisonAgainstFinalPrice)) {
                filteredCarsByPriceRange.add(car);
            }
        }
        return filteredCarsByPriceRange;
    }

    private void validatePriceRange(double initialPrice, double finalPrice) throws IllegalArgumentException {
        if(Double.compare(initialPrice, finalPrice) > 0) {
            throw new IllegalArgumentException("finalPrice should be greater than the initialPrice");
        }
    }

    private static boolean carPriceIsBetweenRange(int comparisonAgainstInitialPrice, int comparisonAgainstFinalPrice) {
        return comparisonAgainstInitialPrice >= 0 && comparisonAgainstFinalPrice <= 0;
    }

    public List<Car> searchCarsByBrands(String brands) {
        List<Car> filteredCarsByBrand = new ArrayList<>();
        for (Car car: carsBinaryTree.recorrerInorden()) {
            if(brands.contains(car.getMarca())) {
                filteredCarsByBrand.add(car);
            }
        }
        return filteredCarsByBrand;
    }

    @PostConstruct
    public void loadCarsDataInMemory(){
        carsBinaryTree = new ArbolBinario<>();
        for (Car car: carsDAO.getCarsDatabase()) {
            carsBinaryTree.agregarElemento(car);
        }
    }
}
