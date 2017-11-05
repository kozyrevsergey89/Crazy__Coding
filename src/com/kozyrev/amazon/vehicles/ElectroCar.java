package com.kozyrev.amazon.vehicles;

/**
 * Created by skozyrev on 11/5/17.
 */
public class ElectroCar extends Car<ETransmission, EEngine> {
    public <T extends ETransmission, E extends EEngine> ElectroCar(T eTransmission, E eEngine) { // todo discuss
        super(eTransmission, eEngine);
    }
}
