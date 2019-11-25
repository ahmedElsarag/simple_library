package com.example.books;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SqlConnection extends SQLiteOpenHelper {

    public static final String dbName = "library.db";

    public SqlConnection(Context context) {
        super(context, dbName, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table books (id INTEGER PRIMARY KEY AUTOINCREMENT , bookTitle TEXT , description TEXT , imgSource TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        onCreate(db);
    }

    public boolean insertData (String title , String description , String imgSource){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("bookTitle",title);
        contentValues.put("description",description);
        contentValues.put("imgSource",imgSource);

        long result = sqLiteDatabase.insert("books",null,contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor showData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from books",null);
        return cr;
    }

    public void update (String id ,String title ,String description){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("bookTitle",title);
        contentValues.put("description",description);

        sqLiteDatabase.update("books",contentValues,"id= ?",new String[]{id});
    }

    public void delete (String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("books","id= ?",new String[]{id});
    }
}
