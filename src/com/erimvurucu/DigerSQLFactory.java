package com.erimvurucu;

public class DigerSQLFactory implements IVeritabaniFactory{
    @Override
    public IVeritabani factoryMethod() {
        return new DigerSQL();
    }
}
