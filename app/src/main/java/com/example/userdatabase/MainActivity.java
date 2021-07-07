package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper dbhelper = new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
//        addReviewBtn();
        listReviewsBtn();
        addEatery();


    }


    private void addEatery() {
        Button skipnew = findViewById(R.id.add_eating_place);
        skipnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddRewviewActivity.class));
            }
        });
    }

//    private void addReviewBtn() {
//        Button skipnew = findViewById(R.id.GOTODATA);
//        skipnew.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, AddRewviewActivity.class));
//            }
//        });
//    }

    private void listReviewsBtn() {
        Button listreview = findViewById(R.id.listreviews);
        listreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Reviews.class));
            }
        });
    }


}

