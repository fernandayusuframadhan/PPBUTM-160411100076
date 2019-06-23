package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, buttonproject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        buttonproject= findViewById(R.id.buttonproject);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModul1();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModul2();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModul3();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModul4();
            }
        });

        buttonproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityProject();
            }
        });
    }

    public void openModul1(){
        Intent intent = new Intent(this, Modul1.class);
        startActivity(intent);
    }

    public void openModul2(){
        Intent intent = new Intent(this, Modul2.class);
        startActivity(intent);
    }

    public void openModul3(){
        Intent intent = new Intent(this, Modul3.class);
        startActivity(intent);
    }

    public void openModul4(){
        Intent intent = new Intent(this, Modul4.class);
        startActivity(intent);
    }

    public void openActivityProject(){
        Intent intent = new Intent(this, ActivityProject.class);
        startActivity(intent);
    }
}
