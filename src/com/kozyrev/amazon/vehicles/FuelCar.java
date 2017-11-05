package com.kozyrev.amazon.vehicles;

/**
 * Created by skozyrev on 11/5/17.
 */
public class FuelCar extends Car<ManTransmission, FuelEngine> {
    public FuelCar(ManTransmission transmission, FuelEngine fuelEngine) {
        super(transmission, fuelEngine);
    }
}
