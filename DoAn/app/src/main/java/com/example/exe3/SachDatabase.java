package com.example.exe3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SachDatabase extends SQLiteOpenHelper {
    private static String DB_NAME = "dbSach.db";
    private static int DB_VERSION = 1;

    //Define table Monhoc
    private static final String TB_SACH = "tbSach";
    private static final String COL_SACH_ID = "sach_id";
    private static final String COL_SACH_TEN = "sach_ten";
    private static final String COL_SACH_TENTACGIA = "sach_tentacgia";
    private static final String COL_SACH_NSX = "sach_nxb";
    private static final String COL_SACH_NGAYNHAPKHO = "sach_ngaynhapkho";

    public SachDatabase(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_SACH);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String scriptTBMonHocs = "CREATE TABLE " + TB_SACH + "(" +
                COL_SACH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COL_SACH_TEN + " TEXT, " +
                COL_SACH_TENTACGIA + " TEXT, " +
                COL_SACH_NSX + " TEXT, " +
                COL_SACH_NGAYNHAPKHO + " TEXT ) ";
        //Execute script
        db.execSQL(scriptTBMonHocs);
    }

    public void getSach(ArrayList<Sach> sachh)
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TB_SACH, new String[]{COL_SACH_ID, COL_SACH_TEN, COL_SACH_TENTACGIA,
                COL_SACH_NSX,COL_SACH_NSX,COL_SACH_NGAYNHAPKHO}, null,null,null, null, null);
        if(cursor.moveToFirst()) {
            do {
                Sach s = new Sach();
                s.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_SACH_ID))));
                s.setTenSach(cursor.getString(cursor.getColumnIndex(COL_SACH_TEN)));
                s.setTenTG(cursor.getString(cursor.getColumnIndex(COL_SACH_TENTACGIA)));
                s.setNSX(cursor.getString(cursor.getColumnIndex(COL_SACH_NSX)));
                s.setNgayNhapKho(cursor.getString(cursor.getColumnIndex(COL_SACH_NGAYNHAPKHO)));
                sachh.add(s);
            } while (cursor.moveToNext());
        }
    }

    public ArrayList<Sach> getAllData(ArrayList<Sach> sachh) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TB_SACH, new String[]{COL_SACH_ID, COL_SACH_NGAYNHAPKHO, COL_SACH_NSX, COL_SACH_TEN, COL_SACH_TENTACGIA}, null, null, null, null, null);

        if(cursor.moveToFirst()) {
            do {
                Sach s = new Sach();
                s.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_SACH_ID))));
                s.setTenSach(cursor.getString(cursor.getColumnIndex(COL_SACH_TEN)));
                s.setTenTG(cursor.getString(cursor.getColumnIndex(COL_SACH_TENTACGIA)));
                s.setNSX(cursor.getString(cursor.getColumnIndex(COL_SACH_NSX)));
                s.setNgayNhapKho(cursor.getString(cursor.getColumnIndex(COL_SACH_NGAYNHAPKHO)));
                sachh.add(s);

            } while (cursor.moveToNext());
        }

        return sachh;
    }

    public void saveSach(Sach s)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SACH_ID, s.getId());
        values.put(COL_SACH_TEN, s.getTenSach());
        values.put(COL_SACH_TENTACGIA, s.getTenTG());
        values.put(COL_SACH_NSX, s.getNSX());
        values.put(COL_SACH_NGAYNHAPKHO, s.getNgayNhapKho());
        db.insert(TB_SACH, null, values);
        db.close();
    }

    public void deleteSach(String ma)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM tbSach WHERE sach_id=" + ma;
        db.execSQL(query);
    }

    public void updateSach (Sach sach)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_SACH_TEN, sach.getTenSach());
        cv.put(COL_SACH_TENTACGIA, sach.getTenTG());
        cv.put(COL_SACH_NSX, sach.getNSX());
        cv.put(COL_SACH_NGAYNHAPKHO, sach.getNgayNhapKho());
        db.update(TB_SACH, cv, "sach_id=?" , new String[]{String.valueOf(sach.getId())});
        db.close();
    }

}
