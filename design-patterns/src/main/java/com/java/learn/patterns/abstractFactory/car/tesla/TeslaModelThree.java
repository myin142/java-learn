package com.java.learn.patterns.abstractFactory.car.tesla;

import com.java.learn.patterns.abstractFactory.car.Car;
import com.java.learn.patterns.abstractFactory.car.CarFuel;
import com.java.learn.patterns.abstractFactory.car.CarTransmission;

public class TeslaModelThree extends Car {

    public TeslaModelThree() {
        super("Tesla Model 3", 5);
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
