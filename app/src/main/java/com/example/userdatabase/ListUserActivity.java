package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        LinearLayout container = findViewById(R.id.LayoutContainer);

        Database db = new Database(getApplicationContext());
        Cursor userlist = db.getreviewlist();
        userlist.moveToFirst();

        do {
            String name = userlist.getString(0);
            TextView textBox = new TextView(this);
            textBox.setText(name);
            container.addView(textBox);

        }while(userlist.moveToNext());

        Button backBtn = findViewById(R.id.back);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListUserActivity.this, AddUserActivity.class));
            }
        });
    }

    }
