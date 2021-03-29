package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView username = findViewById(R.id.username);

        Button Sumbit = findViewById(R.id.submit);

        Sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameValue = username.getText().toString();
                ContentValues values = new ContentValues();
                values.put("", userNameValue);

                Database db = new Database(getApplicationContext());
                db.addreview(values);
            }
        });
    }
}