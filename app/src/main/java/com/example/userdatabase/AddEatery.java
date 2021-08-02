package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddEatery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_eatery);

        TextView location = findViewById(R.id.reviewInput);
        TextView storeName = findViewById(R.id.ratingInput);
        Button submit = findViewById(R.id.saveBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locationValue = location.getText().toString();
                String storeValue = storeName.getText().toString();
                ContentValues values = new ContentValues();
                values.put("location", locationValue);
                values.put("name", storeValue);
                Database db = new Database(getApplicationContext());
                long rId = db.addRestaurant(values);
                if (location.length() != 0 || storeName.length() != 0) {
                    if (rId != -1) {
                        Intent intent = new Intent(AddEatery.this, AddFoodItemActivity.class);
                        intent.putExtra("rID", rId);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AddEatery.this,
                                "unable to save new values", Toast.LENGTH_LONG).show();
                    }
                }else{  Toast.makeText(AddEatery.this,
                        "unable to add eater as one or more of the fields are empty", Toast.LENGTH_LONG).show();}
            }
        });

    }
}