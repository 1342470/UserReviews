package com.example.userdatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listReviewsBtn();
        addEatery();
        viewEatery();

        Button exit = findViewById(R.id.Exit);
        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }




    private void addEatery() {
        Button skipnew = findViewById(R.id.add_eating_place);
        skipnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddEatery.class));
            }
        });
    }




    private void listReviewsBtn() {
        Button listreview = findViewById(R.id.listreviews);
        listreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Reviews.class));
            }
        });
    }

    private void viewEatery() {
        Button gotoViewEater = findViewById(R.id.view_food_places);
        gotoViewEater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAllShopData();
            }
        });
    }

    public void viewAllShopData() {
        Database db = new Database(getApplicationContext());
        Cursor res = db.getAllShopData();
                    if(res.getCount() == 0) {
                        // show message
                        showMessage("Error","Nothing found");
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("id :"+ res.getString(0)+"\n");
                        buffer.append("location :"+ res.getString(1)+"\n");
                        buffer.append("name :"+ res.getString(2)+"\n");
                    }

                    // Show all data
                    showMessage("Shop data",buffer.toString());
                }



    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}



