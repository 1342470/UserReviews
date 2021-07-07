package com.example.userdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

public class Database extends DatabaseHelper {
    public Database(@Nullable Context context){
        super(context);
    }


    public long addreview(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("review", null, values);
    }

    public long addRestaurant(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("store", null, values);
    }

    public Cursor getreviewlist(){
        SQLiteDatabase db = this.getReadableDatabase();
        String table = "review";
        String[] columns = {"food_info_id int,Discription text, rating int"};
        String Seleciton = "";
        String[] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = " DESC";
        String limit = "100";

        Cursor cursor = db.query(table, columns, Seleciton, selectionArgs, groupBy, having, orderBy, limit);

        return cursor;
    }
}