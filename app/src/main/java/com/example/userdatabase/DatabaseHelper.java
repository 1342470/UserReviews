package com.example.userdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "foodReviewsDB", null, 7);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "" +
                "CREATE TABLE IF NOT EXISTS review(" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "food_id integer, " +
                "reviewDescription text, " +
                "rating integer, " +
                "FOREIGN KEY (food_id) REFERENCES food (id) " +
                ")";
        String createShopTable = "" +
                "CREATE TABLE IF NOT EXISTS shop(" +
                "id integer PRIMARY KEY AUTOINCREMENT, " +
                "location text, " +
                "name text" +
                ")";
        String createFoodInfoTable = "" +
                "CREATE TABLE IF NOT EXISTS food(" +
                "id integer PRIMARY KEY AUTOINCREMENT, " +
                "shop_id integer, " +
                "food_name text, " +
                "foodDescription text, " +
                "vegan text, " +
                "price text," +
                "FOREIGN KEY (shop_id) REFERENCES shop (id) " +
                ")";
        db.execSQL(createUserTable);
        db.execSQL(createShopTable);
        db.execSQL(createFoodInfoTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS review");
        db.execSQL("DROP TABLE IF EXISTS food");
        db.execSQL("DROP TABLE IF EXISTS shop");

        onCreate(db);
    }
}


