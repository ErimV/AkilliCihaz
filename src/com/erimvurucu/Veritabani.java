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
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akilliCihaz", "postgres", "12345");

            //System.out.println("Veritabanina baglanildi!");

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

            if(rs.next())
            {
                //String username  = rs.getString("kullanici_adi");
                //System.out.println("Kullanici " + username + " onaylandi!");
                return true;
            }
            /*
            else {
                System.out.println("Kullanici onaylanamadi!");
                return false;
            }

             */

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

            if(rs.next())
            {
                //System.out.println("Hosgeldiniz " + kullanici_adi);
                return true;
            }

            rs.close();
            stmt.close();
            /*
            else {
            System.out.println(kullanici_adi + " icin sifre hatali!");
            return false;
        }

             */
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
