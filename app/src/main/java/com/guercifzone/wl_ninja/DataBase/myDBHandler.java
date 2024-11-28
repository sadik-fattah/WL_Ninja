package com.guercifzone.wl_ninja.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.guercifzone.wl_ninja.Models.Websites;

import java.util.ArrayList;
import java.util.List;

public class myDBHandler extends SQLiteOpenHelper {
 private static final int DATABASE_VERSION = 1;
 private static final String DATABASE_NAME= "site.db";
 private static final String TABLE_NAME= "site_table";
 private static final String COLUMN_ID= "id";
 private static final String COLUMN_NAME="url";

    public myDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
      String query = "CREATE TABLE "+ TABLE_NAME + " (" +
              COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
              COLUMN_NAME + " TEXT);";
      db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
onCreate(db);
    }
    public void addUrl(Websites website){
        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME,website.get_url());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public void deleteUrl(String url){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + "=\"" + url + "\";");
    }
    public List<String> databaseToString()
    {

        SQLiteDatabase db=getWritableDatabase();
        String query ="SELECT * FROM " + DATABASE_NAME;

        List<String> dbstring=new ArrayList<>();

        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        int i=0;
        if(c.moveToNext()) {
            do {

                if (c.getString(c.getColumnIndex(COLUMN_NAME)) != null) {

                    String bstring = "";
                    bstring += c.getString(c.getColumnIndex("url"));
                    dbstring.add(bstring);
                }
            } while (c.moveToNext());
        }
        c.close();
        return dbstring;
    }
}
