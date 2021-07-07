package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class AddRewviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView username = findViewById(R.id.username);
        TextView location = findViewById(R.id.Location);
        TextView description = findViewById(R.id.discriptionInput);
        TextView rating = findViewById(R.id.RatingInput);
        CheckBox vegan = findViewById(R.id.VeganCheck);

        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameValue = username.getText().toString();
                String locationValue = location.getText().toString();
                String discriptionValue = description.getText().toString();
                String ratingValue = rating.getText().toString();
                ContentValues values = new ContentValues();
                values.put("", userNameValue);
                values.put("", locationValue);
                values.put("", discriptionValue);
                values.put("", ratingValue);
                Database db = new Database(getApplicationContext());
                db.addreview(values);
            }
        });
    }
}