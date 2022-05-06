package com.erimvurucu;

public class AkilliCihaz {
    private String menu =   "1. Sicaklik Goruntule\n" +
                            "2. Sogutucu Calistir\n" +
                            "3. Iptal\n";
    private final IAgArayuzu agArayuzu;
    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici sicaklikAlgilayici;
    private final IVeritabani veritabani;

    public AkilliCihaz() {
        eyleyici = new Eyleyici();
        sicaklikAlgilayici = new SicaklikAlgilayici();
        agArayuzu = new AgArayuzu();
        veritabani = new Veritabani();
    }

    public void basla(){
        veritabani.kullanici_adiDogrula("erimvurucu");
        //agArayuzu.mesajGoruntule(menu);
    }
}
