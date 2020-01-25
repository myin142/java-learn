package com.java.learn.patterns.abstractFactory.car.bmw;

import com.java.learn.patterns.abstractFactory.car.Car;
import com.java.learn.patterns.abstractFactory.car.CarFuel;
import com.java.learn.patterns.abstractFactory.car.CarTransmission;

public class BMWRoadster extends Car {

    public BMWRoadster() {
        super("BMW Z4 Roadster", 2);
    }

    @Override
    public CarFuel getFuelType() {
        return CarFuel.Gasoline;
    }

    @Override
    public CarTransmission getTransmissionType() {
        return CarTransmission.Manual;
    }
}
