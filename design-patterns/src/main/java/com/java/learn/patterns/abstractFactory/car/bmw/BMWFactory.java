package com.java.learn.patterns.abstractFactory.car.bmw;

import com.java.learn.patterns.abstractFactory.car.Car;
import com.java.learn.patterns.abstractFactory.car.CarFactory;

public class BMWFactory implements CarFactory {

    @Override
    public Car createSportsCar() {
        return new BMWRoadster();
    }

    @Override
    public Car createCheapestCar() {
        return new BMWOneSeries();
    }

}
