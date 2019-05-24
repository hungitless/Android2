package com.example.exe3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BanDocDatabase extends SQLiteOpenHelper {
    private static String DB_NAME = "dbBanDoc.db";
    private static int DB_VERSION = 1;
    private static final String TB_BanDoc = "tbBanDoc";
    private static final String COL_BANDOC_MA = "bandoc_ma";
    private static final String COL_BANDOC_TEN = "bandoc_ten";
    private static final String COL_BANDOC_SDT = "bandoc_SDT";
    public BanDocDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_BanDoc);
        onCreate(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String scriptTBBanDoc= "CREATE TABLE " + TB_BanDoc + "(" +
                COL_BANDOC_MA + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COL_BANDOC_TEN + " TEXT, " +
                COL_BANDOC_TEN +  " TEXT) ";
        //Execute script
        db.execSQL(scriptTBBanDoc);
    }
    public void getSach(ArrayList<BanDoc> bandoc)
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TB_BanDoc, new String[]{COL_BANDOC_MA, COL_BANDOC_TEN, COL_BANDOC_SDT,
        }, null,null,null, null, null);
        if(cursor.moveToFirst()) {
            do {
                BanDoc s = new BanDoc();
                s.setsMa(cursor.getString(cursor.getColumnIndex(COL_BANDOC_MA)));
                s.setsTen(cursor.getString(cursor.getColumnIndex(COL_BANDOC_TEN)));
                s.setnSDT(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_BANDOC_SDT))));
                bandoc.add(s);
            } while (cursor.moveToNext());
        }
    }
    public void getAllData(ArrayList<Sach> bandoc) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from "+TB_BanDoc;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()) {
            do {
                Sach s = new Sach();
                s.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_BANDOC_MA))));
                s.setTenSach(cursor.getString(cursor.getColumnIndex(COL_BANDOC_TEN)));
                s.setTenTG(cursor.getString(cursor.getColumnIndex(COL_BANDOC_SDT)));
                bandoc.add(s);

            } while (cursor.moveToNext());
        }
    }
    public void saveBanDoc(BanDoc s)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_BANDOC_MA, s.getsMa());
        values.put(COL_BANDOC_TEN, s.getsTen());
        values.put(COL_BANDOC_SDT, s.getnSDT());
        db.insert(TB_BanDoc, null, values);
        db.close();
    }
    public void deleteBanDoc(String ma)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM tbBanDoc WHERE bandoc_ma=" + ma;
        db.execSQL(query);
    }
}

