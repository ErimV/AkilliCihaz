package com.erimvurucu;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Veritabani implements IVeritabani{

    private Connection baglan(){
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilliCihaz", "postgres", "12345");

            System.out.println("Veritabanina baglanildi!");

        } catch (Exception e) {
            System.out.println("Veritabanina baglanti kurulamadi!");
            e.printStackTrace();
        }
        return conn;
    }

    public void kullanici_adiDogrula(String kullanici_adi){
        Connection conn = this.baglan();
        try
        {
            String sql= "SELECT *  FROM \"yetkili\" WHERE \"kullanici_adi\"="+ kullanici_adi;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            while(rs.next())
            {
                String username  = rs.getString("kullanici_adi");
                System.out.println("Hoşgeldiniz" + kullanici_adi);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sifreDogrula(String sifre){

    }

}
