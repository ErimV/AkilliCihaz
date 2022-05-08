package com.erimvurucu.AkilliCihaz;

import java.io.IOException;

import static com.erimvurucu.AkilliCihaz.AkilliCihazDurum.*;

public class AkilliCihazUygulamasi {
    public static void main(String[] args) throws InterruptedException, IOException {
        AkilliCihaz akilliCihaz = new AkilliCihaz();
        akilliCihaz.setDurum(AcilisTestiYapiliyor);
        akilliCihaz.basla();
        akilliCihaz.setDurum(Kapali);
    }
}
