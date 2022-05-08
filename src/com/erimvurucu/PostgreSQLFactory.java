package com.erimvurucu;

public class PostgreSQLFactory implements IVeritabaniFactory{
    @Override
    public IVeritabani factoryMethod() {
        return new PostgreSQL();
    }
}
