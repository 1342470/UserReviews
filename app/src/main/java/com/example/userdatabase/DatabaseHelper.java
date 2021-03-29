package com.example.userdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "MyFirstDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE IF NOT EXISTS reivew(food_info_id integer PRIMARY KEY,Discription text, rating integer, FOREIGN KEY (id) REFERENCES foodInfo (id) )";
        String createShopTable = "CREATE TABLE IF NOT EXISTS shopInfo(id int, location text, ShopName text)";
        String createFoodInfoTable = "CREATE TABLE IF NOT EXISTS foodInfo(id int, Shop_id int, Food_Name text, discriotion text, Vegan boolean, Image blob, Price real)";
        db.execSQL(createUserTable);
        db.execSQL(createShopTable);
        db.execSQL(createFoodInfoTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DropReviewTable = "DROP TABLE IF EXISTS review";
        String DropShopTable = "DROP TABLE IF EXISTS review";
        String DropFoodInfoTable = "DROP TABLE IF EXISTS review";
        db.execSQL(DropReviewTable);
        db.execSQL(DropShopTable);
        db.execSQL(DropFoodInfoTable);

        onCreate(db);
    }
}


