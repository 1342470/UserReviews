package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.userdatabase.AddUserActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper dphhelper = new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
        gotToNewUser();
        gotoReviews();



    }

    private void gotToNewUser() {
        Button skipnew = findViewById(R.id.GOTODATA);
        skipnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddUserActivity.class));
            }
        });
    }

    private void gotoReviews() {
        Button listreview = findViewById(R.id.listreviews);
        listreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Reviews.class));
            }
        });
    }


}

