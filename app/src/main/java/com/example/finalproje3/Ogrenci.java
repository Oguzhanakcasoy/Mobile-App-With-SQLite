package com.example.finalproje3;

public class Ogrenci {

    private String AdSoyad;
    private String Mail;
    private String Adres;

    public Ogrenci() {
    }

    public Ogrenci(String adSoyad, String mail, String adres) {
        AdSoyad = adSoyad;
        Mail = mail;
        Adres = adres;
    }

    public void setAdSoyad(String adSoyad) {

        AdSoyad = adSoyad;
    }

    public void setMail(String mail) {

        Mail = mail;
    }

    public void setAdres(String adres) {

        Adres = adres;
    }

    public String getAdSoyad() {

        return AdSoyad;
    }

    public String getMail() {

        return Mail;
    }

    public String getAdres() {

        return Adres;
    }

}
