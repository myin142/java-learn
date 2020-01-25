package com.java.learn.patterns.abstractFactory.car;

import com.java.learn.patterns.abstractFactory.car.bmw.BMWFactory;
import com.java.learn.patterns.abstractFactory.car.tesla.TeslaFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {

    @Test
    void createTeslaCars() {
        printCars(new TeslaFactory(), "Tesla Cars");
    }

    @Test
    void createBMWCars() {
        printCars(new BMWFactory(), "BMW Cars");
    }

    private void printCars(CarFactory carFactory, String message) {
        System.out.println(message);
        System.out.println("------------------------");
        printCar(carFactory.createSportsCar(), "Sport Car");
        printCar(carFactory.createCheapestCar(), "Cheapest Car");
    }

    private void printCar(Car car, String prefix) {
        System.out.println(prefix + ": " + car.getName() + " with " + car.getSeatCount() + " seats.");
        System.out.println("Transmission: " + car.getTransmissionType());
        System.out.println("Fuel: " + car.getFuelType());
        System.out.println();
    }

}
