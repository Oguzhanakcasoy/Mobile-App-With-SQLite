package com.example.finalproje3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ogrenci_veritabani";
    private static final String TABLE_NAME = "ogrenci_tablosu";
    private static final int DATABASE_VERSION = 1;

    private static final String AD = "ad_soyad";
    private static final String MAIL = "mail";
    private static final String ADRES = "adres";
    private static final String ID = "_id";


    public Veritabani(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tablo_olustur = "CREATE TABLE " + TABLE_NAME +
                " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AD + " TEXT, " +
                MAIL + " TEXT, " +
                ADRES + " TEXT);";

        db.execSQL(tablo_olustur);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long KayıtEkle(Ogrenci ogrenci) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(AD, ogrenci.getAdSoyad());
        cv.put(MAIL, ogrenci.getMail());
        cv.put(ADRES, ogrenci.getAdres());

        Long id = db.insert(TABLE_NAME, null, cv);
        db.close();
        return id;
    }

    public List<Ogrenci> TumKayitlariGetir() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunlar = new String[]{AD, MAIL, ADRES, ID};
        Cursor c = db.query(TABLE_NAME, sutunlar, null, null, null, null, null);

        int adsirano = c.getColumnIndex(AD);
        int mailsirano = c.getColumnIndex(MAIL);
        int adresssirano = c.getColumnIndex(ADRES);


        List<Ogrenci> ogrenciList = new ArrayList<Ogrenci>();
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Ogrenci ogrenci = new Ogrenci();
            ogrenci.setAdSoyad(c.getString(adsirano));
            ogrenci.setMail(c.getString(mailsirano));
            ogrenci.setAdres(c.getString(adresssirano));

            ogrenciList.add(ogrenci);

        }
        db.close();

        return ogrenciList;
    }
}

  /*  public void Sil(Long id) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,ID+"=",null);
        db.close();
    }
     public void Guncelle(Long ad, long mail, long adres ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AD, ad);
        cv.put(MAIL, mail);
        cv.put(ADRES, adres);
        db.update(TABLE_NAME, cv, ID + "=" + ad, null);
        db.close();
    }*/
