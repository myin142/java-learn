package com.java.learn.patterns.abstractFactory.car.tesla;

import com.java.learn.patterns.abstractFactory.car.Car;
import com.java.learn.patterns.abstractFactory.car.CarFuel;
import com.java.learn.patterns.abstractFactory.car.CarTransmission;

public class TeslaRoadster extends Car {

    public TeslaRoadster() {
        super("Tesla Roadster", 4);
    }

    @Override
    public CarFuel getFuelType() {
        return CarFuel.Electric;
    }

    @Override
    public CarTransmission getTransmissionType() {
        return CarTransmission.Automatic;
    }
}
