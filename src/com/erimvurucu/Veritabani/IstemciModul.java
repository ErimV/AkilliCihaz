package com.erimvurucu.Veritabani;

public class IstemciModul {
    IVeritabaniFactory veritabaniFactory;
    public IstemciModul(IVeritabaniFactory veritabaniFactory){
        this.veritabaniFactory = veritabaniFactory;
    }

    public IVeritabani basla(){
        return veritabaniFactory.factoryMethod();
    }
}
