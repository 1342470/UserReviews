package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddFoodItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_iterm);
        Database db = new Database(getApplicationContext());

        long rId = getIntent().getLongExtra("rID", 0);

        String rName = db.getRestaurant(rId);

        TextView rNameLabel = findViewById(R.id.reviewRNameText);
        rNameLabel.setText(rName);
        TextView foodName = findViewById(R.id.foodName);
        TextView description = findViewById(R.id.discriptionInput);
        TextView vegan = findViewById(R.id.VeganCheck);
        TextView price = findViewById(R.id.PriceInput);
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //save the review with the food ID.
                //you will get back a review ID.

                String foodValue = foodName.getText().toString();
                String descriptionValue = description.getText().toString();
                String priceValue = price.getText().toString();
                String veganValue = vegan.getText().toString();
                ContentValues values = new ContentValues();
                values.put("shop_id", rId);
                values.put("food_name", foodValue);
                values.put("foodDescription", descriptionValue);
                values.put("vegan", veganValue);
                values.put("price", priceValue);

                long foodId = db.addFoodItem(values);
                if (foodValue.length() != 0 || descriptionValue.length() != 0 || priceValue.length() != 0 || vegan.length() != 0) {
                    if (foodId != -1) {
                        Intent intent = new Intent(AddFoodItemActivity.this, AddReview.class);
                        intent.putExtra("foodID", foodId);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AddFoodItemActivity.this, "unable to add food", Toast.LENGTH_LONG).show();
                    }

                }else{Toast.makeText(AddFoodItemActivity.this, "unable to add food as one or more of the fields are empty", Toast.LENGTH_LONG).show();}
            }
        });


    }
}
