package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Modul4isimenu extends AppCompatActivity {

    RadioGroup radiosajian;
    RadioButton hangat, dingin;
    TextView judul;
    EditText textcount;
    Button plus, min, order;

    Integer jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul4isimenu);

        radiosajian = findViewById(R.id.radiosajian);
        hangat = findViewById(R.id.hangat4);
        dingin = findViewById(R.id.dingin4);
        judul = findViewById(R.id.judul);
        textcount = findViewById(R.id.textcount4);
        plus = findViewById(R.id.plus4);
        min = findViewById(R.id.min4);
        order = findViewById(R.id.buttonOK);

        jumlah = 0;
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlah++;
                if (jumlah > 100){
                    jumlah = 100;
                }
                textcount.setText(jumlah.toString());
            }
        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlah--;
                if (jumlah < 0){
                    jumlah = 0;
                }
                textcount.setText(jumlah.toString());
            }
        });

        Intent intent = getIntent();
        final int index = intent.getIntExtra("index", 0);
        String judulmenu = intent.getStringExtra("menuselect");
        String jumlah = intent.getStringExtra("jumlahmenu");
        String sajian = intent.getStringExtra("sajian");

        judul.setText(judulmenu);

        if (sajian.equals("hangat")){
            hangat.setChecked(true);
        }else  if (sajian.equals("dingin")){
            dingin.setChecked(true);
        }

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("index", index);
                intent.putExtra("jumlah", textcount.getText().toString());

                int selectedID = radiosajian.getCheckedRadioButtonId();
                if (selectedID== hangat.getId()){
                    intent.putExtra("sajian", "hangat");
                }else {
                    intent.putExtra("sajian", "dingin");
                }
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
