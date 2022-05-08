package com.erimvurucu.Veritabani;

public class DigerSQLFactory implements IVeritabaniFactory {
    @Override
    public IVeritabani factoryMethod() {
        return new DigerSQL();
    }
}
