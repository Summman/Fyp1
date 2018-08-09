package com.example.summan.impairedglove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.summan.impairedglove.activities.TextRecog;


public class Main extends AppCompatActivity {

    private ImageView voiceMail;
    private ImageView tr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voiceMail = (ImageView) findViewById(R.id.vm);
        tr = (ImageView) findViewById(R.id.tr);

        voiceMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main.this, VoiceMail.class);
                startActivity(i);
            }
        });


        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main.this, TextRecog.class);
                startActivity(i);
            }
        });

    }
}