package com.example.userdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Reviews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        LinearLayout container = findViewById(R.id.LayoutContainer);
        gohome();

        Database db = new Database(getApplicationContext());
        Cursor userlist = db.getreviewlist();
        userlist.moveToFirst();

        do {
            String name = userlist.getString(0);
            TextView textBox = new TextView(this);
            textBox.setText(name);
            container.addView(textBox);

        }while(userlist.moveToNext());
    }

    private void gohome() {
        Button gohome = findViewById(R.id.GoHome);
            gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}