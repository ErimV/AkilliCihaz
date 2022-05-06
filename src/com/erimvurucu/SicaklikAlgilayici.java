package com.erimvurucu;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private double sicaklik;

    @Override
    public double sicaklikDondur() {
        this.sicaklik = 24.2;
        return this.sicaklik;
    }
}
