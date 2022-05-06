package com.erimvurucu;

public class AgArayuzu implements IAgArayuzu{
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
    public void veriAl() {

    }

    @Override
    public void kullaniciDogrula() {

    }
}
