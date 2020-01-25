package com.java.learn.patterns.abstractFactory.car;

/**
 * Can be interface, abstract class or a concrete factory that is inherited from
 */
public interface CarFactory {
    Car createSportsCar();
    Car createCheapestCar();
}
