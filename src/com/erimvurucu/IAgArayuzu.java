package com.erimvurucu;

public interface IAgArayuzu {
    public void mesajGoruntule(String msj);
    public void ekranTemizle();
    public void bekle(int sn) throws InterruptedException;
    public String veriAl();
    public void kullaniciDogrula() throws InterruptedException;
}
