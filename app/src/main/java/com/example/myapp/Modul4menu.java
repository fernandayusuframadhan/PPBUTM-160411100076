package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Modul4menu extends AppCompatActivity {

    EditText inputnama, textcount, bayar;
    TextView namapemesan, menuid, sajian, bahasa;
    RadioGroup radiosajian, radiobahasa;
    RadioButton hangat, dingin, bindo, bing;
    Button plus, min, order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul4menu);

        inputnama = findViewById(R.id.inputnama);
        namapemesan = findViewById(R.id.namapemesan);

        bahasa = findViewById(R.id.bahasa);
        radiobahasa = findViewById(R.id.radiobahasa);
        bindo = findViewById(R.id.bindo);
        bing = findViewById(R.id.bing);

        order = findViewById(R.id.order);

    }

    public void pilihbahasaing(View view){
        int selectedID = radiobahasa.getCheckedRadioButtonId();
        if (selectedID==bing.getId()){
            namapemesan.setText(getString(R.string.ENpemesan));
            inputnama.setText(getString(R.string.ENinputnama));
            bahasa.setText(getString(R.string.ENbahasa));
            order.setText(getString(R.string.ENorder));
        }
    }

    public void pilihbahasaind(View view){
        int selectedID = radiobahasa.getCheckedRadioButtonId();
        if (selectedID==bindo.getId()){
            namapemesan.setText(getString(R.string.IDNpemesan));
            inputnama.setText(getString(R.string.IDNinputnama));
            bahasa.setText(getString(R.string.IDNbahasa));
            order.setText(getString(R.string.IDNorder));
        }
    }

    public void pesan(View view){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                startActivity(new Intent(getApplicationContext(), Modul4about.class));
                return true;
            case R.id.logout:
                startActivity(new Intent(getApplicationContext(), Modul4.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
