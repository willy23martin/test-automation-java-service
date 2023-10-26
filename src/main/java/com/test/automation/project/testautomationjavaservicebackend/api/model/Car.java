package com.test.automation.project.testautomationjavaservicebackend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Data
@AllArgsConstructor
@ToString
public class Car {
    private String image;
    private String name;
    private double price;
    private String describe;
    private String marca;

    @Override
    public boolean equals(Object car){
        return Double.compare(this.price, ((Car)car).getPrice()) == 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.price);
    }
}
