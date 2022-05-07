package com.erimvurucu;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AgArayuzu implements IAgArayuzu{
    private final IVeritabaniFactory veritabaniFactory;

    public AgArayuzu() {
        this.veritabaniFactory = new PostgreSQLFactory();
    }

    @Override
    public void mesajGoruntule(String msj) {
        System.out.println(msj);
    }

    public void mesajGoruntule(String msj, double dgr) {
        System.out.printf(msj + "%.1f\n",dgr);
    }

    @Override
    public void bekle(int sn) throws InterruptedException {
        TimeUnit.SECONDS.sleep(sn);
    }

    @Override
    public String veriAl() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    @Override
    public void kullaniciDogrula() throws InterruptedException, IOException {
        IstemciModul istemciModul = new IstemciModul(veritabaniFactory);
        IVeritabani veritabani = istemciModul.basla();
        boolean onay = false;
        int count = 0;
        while(!onay){
            this.mesajGoruntule("Kullanici Adi: ");
            String username = this.veriAl();

            this.mesajGoruntule("Kullanici dogrulaniyor...");
            while(veritabani.kullanici_adiDogrula(username)){
                this.bekle(1);
                if(count == 0){
                    this.mesajGoruntule("Kullanici onaylandi.");
                    this.bekle(1);
                }
                this.mesajGoruntule(username +" icin sifrenizi giriniz: ");
                String password = this.veriAl();
                this.mesajGoruntule("Sifre dogrulaniyor...");
                if(veritabani.sifreDogrula(username, password)){
                    this.bekle(1);
                    this.mesajGoruntule("Sifre dogru.");
                    this.mesajGoruntule("Sisteme giris basarili.\nHosgeldiniz " + username + "...");
                    Yetkili yetkili = new Yetkili(username, LocalDateTime.now());
                    Publisher p = new Publisher();
                    p.ekle(yetkili);
                    this.bekle(1);
                    onay = true;
                    break;
                }
                else {
                    this.bekle(1);
                    this.mesajGoruntule("Sifre yanlis, tekrar giriniz... ");
                    count++;
                }
            }
            if(!veritabani.kullanici_adiDogrula(username)) {
                this.bekle(1);
                this.mesajGoruntule("Kullanici bulunamadi, tekrar giriniz... ");
            }
        }

    }
}
