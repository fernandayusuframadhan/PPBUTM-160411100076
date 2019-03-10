package com.example.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Modul1no2 extends AppCompatActivity {

    EditText berat;
    EditText tinggi;
    Button hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul1no2);

        berat = findViewById(R.id.BB);
        tinggi = findViewById(R.id.TB);
        hitung = findViewById(R.id.hitung);
        hasil = findViewById(R.id.hasil);
    }

    public void hitung(View view){
        float BMI = 0;
        String status;
        try
        {
            BMI =  Float.valueOf(berat.getText().toString()) / ((Float.valueOf(tinggi.getText().toString())/100) * (Float.valueOf(tinggi.getText().toString())/100));

            if(BMI < 18.5){
                status = "Under weight";
            }
            else if(BMI < 24.9){
                status = "Normal Weight";
            }
            else if(BMI < 29.9){
                status = "Over Weight";
            }
            else if(BMI < 34.9){
                status = "Obesity 1";
            }
            else if (BMI < 39.9){
                status = "Obesity 2";
            }
            else{
                status = "Obesity 3";
            }
        }
        catch (Exception e)
        {
            status = "salah";
        }

        hasil.setText(String.valueOf(BMI) + " " + status);
    }
}
