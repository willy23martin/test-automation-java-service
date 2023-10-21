package com.test.automation.project.testautomationjavaservicebackend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Car {
    private String image;
    private String name;
    private double price;
    private String describe;
    private String marca;
}
