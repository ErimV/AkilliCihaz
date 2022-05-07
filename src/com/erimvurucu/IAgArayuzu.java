package com.erimvurucu;

import java.io.IOException;

public interface IAgArayuzu {
    void mesajGoruntule(String msj);
    void mesajGoruntule(String msj, double dgr);
    void bekle(int sn) throws InterruptedException;
    String veriAl();
    void kullaniciDogrula() throws InterruptedException, IOException;
}
