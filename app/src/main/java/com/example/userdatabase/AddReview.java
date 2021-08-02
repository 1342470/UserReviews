package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        Database db = new Database(getApplicationContext());
        long foodId = getIntent().getLongExtra("foodID",0);

        TextView comments = findViewById(R.id.reviewInput);
        TextView rating = findViewById(R.id.ratingInput);


        Button submit = findViewById(R.id.saveBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ratingValue = rating.getText().toString();
                String commentValue = comments.getText().toString();
                ContentValues values = new ContentValues();
                values.put("reviewDescription",commentValue);
                values.put("rating",ratingValue);
                values.put("food_id",foodId);
                long success = db.addreview(values);
                if(ratingValue.length() != 0 || commentValue.length() != 0) {
                    if (success != -1) {
                        Intent intent = new Intent(AddReview.this, Success.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AddReview.this, "unable to add food review", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(AddReview.this, "unable to add food review as one or more of the fields are empty", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}