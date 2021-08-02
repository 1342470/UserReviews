package com.example.userdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

public class Database extends DatabaseHelper {
    public Database(@Nullable Context context){
        super(context);
    }


    public long addFoodItem(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("food", null, values);
    }
    public long addreview(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("review", null, values);
    }

    public long addRestaurant(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("shop", null, values);
    }



    public Cursor getAllShopData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from shop",null);
        return res;
    }


    public String getRestaurant(Long rID) {
        SQLiteDatabase db = this.getReadableDatabase();
        String table = "shop";
        String[] columns = {"name"};
        String selection = "id = "  + rID.toString();
        String[] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = "";
        String limit = "1";
        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public Cursor getReviewData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor get = db.rawQuery("select * from review",null);
        return get;
    }




    public Cursor getFoodData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor get = db.rawQuery("select * from food",null);
        return get;
    }
}