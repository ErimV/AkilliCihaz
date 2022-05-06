package com.erimvurucu;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AgArayuzu implements IAgArayuzu{

    private Boolean onay = false;
    private int count = 0;
    private final IVeritabani veritabani;

    public AgArayuzu() {
        veritabani = new Veritabani();
    }

    @Override
    public void mesajGoruntule(String msj) {
        System.out.println(msj);
    }

    @Override
    public void ekranTemizle() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void bekle(int sn) throws InterruptedException {
        TimeUnit.SECONDS.sleep(sn);
    }

    @Override
    public String veriAl() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    @Override
    public void kullaniciDogrula() throws InterruptedException {
        while(onay == false){
            this.mesajGoruntule("Kullanici Adi: ");
            String username = this.veriAl();
            while(veritabani.kullanici_adiDogrula(username)){
                this.bekle(1);
                if(count == 0){
                    this.mesajGoruntule("Kullanici onaylandi.");
                }
                this.mesajGoruntule(username +" icin sifrenizi giriniz: ");
                String password = this.veriAl();
                if(veritabani.sifreDogrula(username, password)){
                    this.bekle(1);
                    this.mesajGoruntule("Sifre dogru.");
                    this.mesajGoruntule("Hosgeldiniz " + username);
                    onay = true;
                    break;
                }
                else {
                    this.bekle(1);
                    this.mesajGoruntule("Sifre yanlis, tekrar giriniz... ");
                    count++;
                }
            }
            if(veritabani.kullanici_adiDogrula(username) == false) {
                this.bekle(1);
                this.mesajGoruntule("Kullanici bulunamadi, tekrar giriniz... ");
            }
        }

    }
}
