package com.erimvurucu;

import java.io.IOException;

public interface ISubject {
    void ekle(IObserver yetkili) throws IOException;
}
