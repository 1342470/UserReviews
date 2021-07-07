package com.example.userdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "MyFirstDB", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "" +
                "CREATE TABLE IF NOT EXISTS review(" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "description text, " +
                "rating integer, " +
                "FOREIGN KEY (id) REFERENCES foodInfo (id) " +
                ")";
        String createShopTable = "" +
                "CREATE TABLE IF NOT EXISTS shop(" +
                "id INT PRIMARY KEY AUTOINCREMENT, " +
                "location text, " +
                "shop_name text" +
                ")";
        String createFoodInfoTable = "" +
                "CREATE TABLE IF NOT EXISTS food(" +
                "id int PRIMARY KEY AUTOINCREMENT, " +
                "shop_id int, " +
                "food_name text, " +
                "description text, " +
                "vegan boolean, " +
                "image blob, " +
                "price real," +
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


