package com.kozyrev.amazon.vehicles;

/**
 * Created by skozyrev on 11/5/17.
 */
public abstract class Car<T extends Transmission, E extends Engine> {
    protected T transmission;
    protected E engine;

    protected Car(T transmission, E engine) {
        this.transmission = transmission;
        this.engine = engine;
    }
}
