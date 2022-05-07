package com.erimvurucu;

import java.io.IOException;

import static com.erimvurucu.AkilliCihazDurum.Kapali;

public class AkilliCihazUygulamasi {
    public static void main(String[] args) throws InterruptedException, IOException {
        AkilliCihaz akilliCihaz = new AkilliCihaz();
        akilliCihaz.basla();
        akilliCihaz.setDurum(Kapali);
    }
}
