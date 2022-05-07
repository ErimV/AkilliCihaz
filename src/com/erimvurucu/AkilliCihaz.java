package com.erimvurucu;

import static com.erimvurucu.AkilliCihazDurum.*;

public class AkilliCihaz {
    private AkilliCihazDurum durum = Kapali;
    private final IAgArayuzu agArayuzu;
    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici sicaklikAlgilayici;

    public AkilliCihaz() {
        eyleyici = new Eyleyici();
        sicaklikAlgilayici = new SicaklikAlgilayici();
        agArayuzu = new AgArayuzu();
    }

    public void basla() throws InterruptedException {
        this.durum = AcilisTestiYapiliyor;
        agArayuzu.kullaniciDogrula();
        this.durum = Bekle;

        while(this.durum != ServisDisi){
            agArayuzu.mesajGoruntule(
                    """
                            ---------------------
                            1. Sicaklik Goruntule
                            2. Sogutucu Calistir
                            3. Iptal
                            ---------------------
                            """
            );
            agArayuzu.mesajGoruntule("Seciminiz(1, 2, 3):");
            String secim = agArayuzu.veriAl();
            switch (secim) {
                case "1" -> {
                    agArayuzu.mesajGoruntule(secim + ". secenek secildi.");
                    this.durum = Algila;
                    double sicaklik = sicaklikAlgilayici.sicaklikDondur(eyleyici);
                    agArayuzu.mesajGoruntule("---------------------\nSicaklik: ", sicaklik);
                    this.durum = Bekle;
                }
                case "2" -> {
                    agArayuzu.mesajGoruntule(secim + ". secenek secildi.");
                    this.durum = IslemYapiliyor;
                    if (eyleyici.getDurum()) {
                        eyleyici.sogutucuKapat();
                        agArayuzu.mesajGoruntule("---------------------\nSogutucu kapatildi.");
                    } else if (!eyleyici.getDurum()) {
                        eyleyici.sogutucuAc();
                        agArayuzu.mesajGoruntule("---------------------\nSogutucu acildi.");
                    }
                    this.durum = Bekle;
                }
                case "3" -> {
                    agArayuzu.mesajGoruntule(secim + ". secenek secildi.");
                    agArayuzu.mesajGoruntule("Islem iptal edildi.");
                    this.durum = ServisDisi;
                }
                default ->
                        agArayuzu.mesajGoruntule("Hatali secim yapildi.('1', '2', '3' degerlerinden birini giriniz.)");
            }

        }

    }

    public void setDurum(AkilliCihazDurum durum) {
        this.durum = durum;
    }
}
