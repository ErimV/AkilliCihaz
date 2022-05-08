package com.erimvurucu.AkilliCihaz;

public class Eyleyici implements IEyleyici {
    private Boolean sogutucuDurum = false;

    @Override
    public void sogutucuAc() {
        this.sogutucuDurum = true;
    }

    @Override
    public void sogutucuKapat() {
        this.sogutucuDurum = false;
    }

    public Boolean getDurum() {
        return sogutucuDurum;
    }
}
