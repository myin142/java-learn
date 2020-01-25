package com.java.learn.patterns.abstractFactory.car.bmw;

import com.java.learn.patterns.abstractFactory.car.Car;
import com.java.learn.patterns.abstractFactory.car.CarFuel;
import com.java.learn.patterns.abstractFactory.car.CarTransmission;

public class BMWOneSeries extends Car {

    public BMWOneSeries() {
        super("BMW M135i xDrive", 5);
    }

    @Override
    public CarFuel getFuelType() {
        return CarFuel.Gasoline;
    }

    @Override
    public CarTransmission getTransmissionType() {
        return CarTransmission.Automatic;
    }
}
