package com.erimvurucu;

public class AkilliCihaz {
    private String menu =   "1. Sicaklik Goruntule\n" +
                            "2. Sogutucu Calistir\n" +
                            "3. Iptal\n";

    private final IAgArayuzu agArayuzu;
    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici sicaklikAlgilayici;

    public AkilliCihaz() {
        eyleyici = new Eyleyici();
        sicaklikAlgilayici = new SicaklikAlgilayici();
        agArayuzu = new AgArayuzu();
    }

    public void basla() throws InterruptedException {
        agArayuzu.kullaniciDogrula();

        agArayuzu.mesajGoruntule(menu);
    }
}
