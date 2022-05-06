package com.erimvurucu;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private double sicaklik;

    @Override
    public double sicaklikDondur() {
        Random r = new Random();
        this.sicaklik = 0 + (70 - 0) * r.nextDouble();
        return this.sicaklik;
    }

    public String toString() {
        return String.format("%lf",sicaklik);
    }
}
