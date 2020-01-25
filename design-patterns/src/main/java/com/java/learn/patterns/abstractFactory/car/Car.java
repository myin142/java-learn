package com.java.learn.patterns.abstractFactory.car;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Can be interface, abstract class or a concrete factory that is inherited from
 */
@AllArgsConstructor
@Getter
public abstract class Car {

    private String name;
    private int seatCount;

    public abstract CarFuel getFuelType();
    public abstract CarTransmission getTransmissionType();
}
