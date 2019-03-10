package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Modul1 extends AppCompatActivity {

    Button buttonM1;
    Button buttonM2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul1);

        buttonM1 = findViewById(R.id.buttonM1);
        buttonM2 = findViewById(R.id.buttonM2);

        buttonM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNo1();
            }
        });

        buttonM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNo2();
            }
        });
    }

    private void openNo1(){
        Intent intent = new Intent(this, Modul1no1.class);
        startActivity(intent);
    }

    private void openNo2(){
        Intent intent = new Intent(this, Modul1no2.class);
        startActivity(intent);
    }
}
