package com.erimvurucu;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InternetKullanicisi implements IObserver{
    private final String kullanici_adi;
    private final LocalDateTime tarih;

    public InternetKullanicisi(String kullanici_adi, LocalDateTime tarih){
        this.kullanici_adi = kullanici_adi;
        this.tarih = tarih;
    }

    // Giris yapanin kaydini tutma methodu
    @Override
    public void keepLog(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        try {
            FileWriter myWriter = new FileWriter("C:/Users/erimv/IdeaProjects/NYAT_Proje/src/log.txt",true);
            myWriter.write(System.lineSeparator() + this.kullanici_adi + " " + dtf.format(this.tarih));
            myWriter.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
