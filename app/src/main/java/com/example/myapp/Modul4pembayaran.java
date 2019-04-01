package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Modul4pembayaran extends AppCompatActivity {

    TextView nama, harga, kembali;
    EditText totaluang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul4pembayaran);

        nama = findViewById(R.id.nama4);
        harga = findViewById(R.id.harga4);
        kembali =findViewById(R.id.kembali4);
        totaluang = findViewById(R.id.totaluang4);

        Intent intent = getIntent();
        String namaa = intent.getStringExtra("namaa");
        ArrayList<String> jeniskopi = intent.getStringArrayListExtra("jeniskopi");
        ArrayList<String> jenisajian = intent.getStringArrayListExtra("jenisajian");
        ArrayList<String> jumlahh = intent.getStringArrayListExtra("jumlahh");

        int total = 0;

        if (Integer.valueOf(jumlahh.get(0)) > 0){
            if (jenisajian.get(0).equals("dingin")){
                total = total + Integer.valueOf(jumlahh.get(0)) * 5500;
            }else{
                total = total + Integer.valueOf(jumlahh.get(0)) * 6000;
            }
        }
        else if (Integer.valueOf(jumlahh.get(1)) > 0){
            if (jenisajian.get(1).equals("dingin")){
                total = total + Integer.valueOf(jumlahh.get(1)) * 7500;
            }else{
                total = total + Integer.valueOf(jumlahh.get(1)) * 8000;
            }
        }
        else if (Integer.valueOf(jumlahh.get(2)) > 0){
            if (jenisajian.get(2).equals("dingin")){
                total = total + Integer.valueOf(jumlahh.get(2)) * 9000;
            }else{
                total = total + Integer.valueOf(jumlahh.get(2)) * 9500;
            }
        }

        nama.setText(namaa);
        harga.setText(total+"");
    }

    public void bayar(View view){
        Integer total, jumuang, kembalian;
        total = Integer.valueOf(harga.getText().toString());
        jumuang = Integer.valueOf(totaluang.getText().toString());
        if (jumuang > total){
            kembalian = jumuang - total;
            kembali.setText("Kembali : " + kembalian.toString());
        }
        else if (jumuang < total){
            kembali.setText("Kurang");
        }
    }
}
