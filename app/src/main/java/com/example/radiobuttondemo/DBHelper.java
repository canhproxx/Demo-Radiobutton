package com.example.radiobuttondemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TEN_DATABASE = "QuanLyHoaDon";
    public static final String TEN_TABLE = "CTHoaDon";
    public static final String COT_ID = "_ID";
    public static final String COT_SP = "_SanPham";
    public static final String COT_NV = "_NhanVien";
    public static final String COT_NGAY = "_Ngay";
    public static final String COT_SL = "_SoLuong";

    private static final String TAO_BANG_CTHOADON = " "
            + "create table" + TEN_TABLE + "("
            + COT_ID + " integer primary key autoincrement ,"
            + COT_SP + "text not null, "
            + COT_NV + " text not null ,"
            + COT_NGAY + " text not null ,"
            + COT_SL + " text not null);";

    public DBHelper(Context context) {
        super(context, TEN_DATABASE, null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TAO_BANG_CTHOADON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}