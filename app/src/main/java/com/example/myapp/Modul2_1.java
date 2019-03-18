package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Modul2_1 extends AppCompatActivity {

    TextView namapemesan, harga, kembali;
    EditText totalUang;
    Button bayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul2_1);

        namapemesan = findViewById(R.id.nama);
        harga = findViewById(R.id.harga);
        kembali = findViewById(R.id.kembali);
        totalUang = findViewById(R.id.totaluang);
        bayar =findViewById(R.id.bayar);

        String pesanan, nama;
        Intent intent2 = getIntent();

        nama = intent2.getStringExtra("namaa");
        pesanan = intent2.getStringExtra("isidata");

        namapemesan.setText(nama);
        harga.setText(pesanan);
    }

    public void bayar(View view){
        Integer total, jumuang, kembalian;
        total = Integer.valueOf(harga.getText().toString());
        jumuang = Integer.valueOf(totalUang.getText().toString());
        if (jumuang > total){
            kembalian = jumuang - total;
            kembali.setText("Kembali : " + kembalian.toString());
        }
        else if (jumuang < total){
            kembali.setText("Kurang");
        }
    }
}
