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
        Boolean devam = true;

        while(devam){
            agArayuzu.mesajGoruntule(menu);
            String secim = agArayuzu.veriAl();
            agArayuzu.mesajGoruntule("Seciminiz: " + secim);
            switch(secim){
                case "1":
                    double sicaklik = sicaklikAlgilayici.sicaklikDondur();
                    agArayuzu.mesajGoruntule(sicaklik);
                    break;
                case "2":
                    if (eyleyici.getDurum() == true){
                        eyleyici.sogutucuKapat();
                        agArayuzu.mesajGoruntule("Sogutucu kapatildi.");
                    }
                    else if (eyleyici.getDurum() == false){
                        eyleyici.sogutucuAc();
                        agArayuzu.mesajGoruntule("Sogutucu acildi.");
                    }
                    break;
                case "3":
                    agArayuzu.mesajGoruntule("Islem iptal edildi.");
                    devam = false;
                    break;
                default:
                    agArayuzu.mesajGoruntule("Hatali secim yapildi.('1', '2', '3' degerlerinden birini giriniz.)");
            }

        }

    }
}
