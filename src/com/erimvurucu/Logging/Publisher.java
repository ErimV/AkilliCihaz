package com.erimvurucu.Logging;

import java.io.IOException;

public class Publisher implements ISubject {

    public void ekle(IObserver yetkili) throws IOException {
        yetkili.keepLog();
    }
}
