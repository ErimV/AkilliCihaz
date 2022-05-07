package com.erimvurucu;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private double sicaklik;

    @Override
    public double sicaklikDondur(IEyleyici eyleyici) {
        Random r = new Random();
        if (eyleyici.getDurum()) this.sicaklik = 16 + (22 - 16) * r.nextDouble();
        else if (!eyleyici.getDurum()) this.sicaklik = 22 + (28 - 22) * r.nextDouble();

        return this.sicaklik;
    }
}