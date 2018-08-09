package com.example.summan.impairedglove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mode extends AppCompatActivity {

    Button user, caretaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        user = (Button) findViewById(R.id.btuser);
        caretaker = (Button) findViewById(R.id.btct);


        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mode.this, Main.class);
                startActivity(i);
            }
        });
        caretaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mode.this, CareTakerLogin.class);
                startActivity(i);
            }
        });
    }
}

