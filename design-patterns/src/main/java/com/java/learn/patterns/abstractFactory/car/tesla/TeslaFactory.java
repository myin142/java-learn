package com.java.learn.patterns.abstractFactory.car.tesla;

import com.java.learn.patterns.abstractFactory.car.Car;
import com.java.learn.patterns.abstractFactory.car.CarFactory;

public class TeslaFactory implements CarFactory {
    @Override
    public Car createSportsCar() {
        return new TeslaRoadster();
    }

    @Override
    public Car createCheapestCar() {
        return new TeslaModelThree();
    }
}
