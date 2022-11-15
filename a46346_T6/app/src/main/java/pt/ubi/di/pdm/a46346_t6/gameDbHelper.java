package pt.ubi.di.pdm.a46346_t6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class gameDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "a46346.db";
    private static final int DATABASE_VERSION = 1;

    public gameDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key, password TEXT)");
        db.execSQL("create table classificacoes(username TEXT primary key, score INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists classificacoes");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result = db.insert("users", null, values);
        if (result == -1) return false;
        else return true;
    }

    public Boolean insertDataScore(String username, int score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("score", score);

        long result = db.insert("classificacoes", null, values);
        if (result == -1) return false;
        else return true;
    }

    public Boolean chechusername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean chechusernameSco(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from classificacoes where username=?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean chechusernamepassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?", new String[] {username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }


}
