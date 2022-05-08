package com.erimvurucu;

public class DigerSQL implements IVeritabani{
    // Dummy SQL sinifi
    @Override
    public Boolean kullanici_adiDogrula(String kullanici_adi){
        System.out.println("Kullanici dogrulaniyor...");
        return null;
    }

    @Override
    public Boolean sifreDogrula(String kullanici_adi, String sifre){
        System.out.println("Sifre dogrulaniyor...");
        return null;
    }
}
