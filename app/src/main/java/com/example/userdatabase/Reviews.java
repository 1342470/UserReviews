package com.example.userdatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Reviews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        gohome();
        Database db = new Database(getApplicationContext());
        Button getReviews = findViewById(R.id.getReviews);
        Button getFoodItems = findViewById(R.id.getFoodItems);
        getReviews.setOnClickListener(
                v -> {

                            Cursor get = db.getReviewData();
                            if (get.getCount() == 0) {
                                // show message
                                Toast.makeText(Reviews.this, "Nothing found", Toast.LENGTH_LONG).show();
                                return;
                            }

                            StringBuffer buffer = new StringBuffer();
                            while (get.moveToNext()) {
                                buffer.append("id :" + get.getString(1) + "\n");
                                buffer.append("food_id :" + get.getString(2) + "\n");
                                buffer.append("reviewDescription :" + get.getString(3) + "\n");
                                buffer.append("rating :" + get.getString(4) + "\n");

                            }

                            // Show all data
                            showMessage("Reviews", buffer.toString());
                        }
                );

        getFoodItems.setOnClickListener(
                v -> {

                    Cursor get = db.getFoodData();
                    if (get.getCount() == 0) {
                        // show message
                        Toast.makeText(Reviews.this, "Nothing found", Toast.LENGTH_LONG).show();
                        return;
                    }

                    StringBuffer buffer2 = new StringBuffer();
                    while (get.moveToNext()) {
                        buffer2.append("id :" + get.getString(1) + "\n");
                        buffer2.append("shop_id :" + get.getString(2) + "\n");
                        buffer2.append("foodDescription :" + get.getString(3) + "\n");
                        buffer2.append("vegan :" + get.getString(4) + "\n");
                        buffer2.append("price :" + get.getString(5) + "\n");
                    }

                    // Show all data
                    showMessage("All food items", buffer2.toString());
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    private void gohome() {
        Button gohome = findViewById(R.id.GoHome);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reviews.this,MainActivity.class );
                startActivity(intent);
            }
        });

    }
}