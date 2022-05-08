package com.erimvurucu.Veritabani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQL implements IVeritabani {

    private Connection baglan(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilliCihaz", "postgres", "12345");

        } catch (Exception e) {
            System.out.println("Veritabanina baglanti kurulamadi!");
            e.printStackTrace();
        }
        return conn;
    }

    public Boolean kullanici_adiDogrula(String kullanici_adi){
        Connection conn = this.baglan();
        try
        {
            String sql= String.format("SELECT *  FROM \"yetkili\" WHERE \"kullanici_adi\"='%s'",kullanici_adi);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            if(rs.next()) return true;

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean sifreDogrula(String kullanici_adi, String sifre){
        Connection conn = this.baglan();
        try
        {
            String sql= String.format("SELECT *  FROM \"yetkili\" WHERE \"sifre\"='%s' AND \"kullanici_adi\"='%s'",sifre,kullanici_adi);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            if(rs.next()) return true;

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
