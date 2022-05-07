package com.erimvurucu;

import static com.erimvurucu.AkilliCihazDurum.Kapali;

public class AkilliCihazUygulamasi {
    public static void main(String[] args) throws InterruptedException {
        AkilliCihaz akilliCihaz = new AkilliCihaz();
        akilliCihaz.basla();
        akilliCihaz.setDurum(Kapali);
    }
}
