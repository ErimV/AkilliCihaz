package com.erimvurucu.Logging;

import java.io.IOException;

public interface ISubject {
    void ekle(IObserver yetkili) throws IOException;
}
