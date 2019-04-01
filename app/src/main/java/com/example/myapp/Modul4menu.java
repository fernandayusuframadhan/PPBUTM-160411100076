package com.example.myapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Modul4menu extends AppCompatActivity {

    private ArrayList<String> llistitem = new ArrayList<>();
    private ArrayList<String> llistjumlah = new ArrayList<>();
    private ArrayList<String> llistsajian = new ArrayList<>();

    EditText inputnama, textcount, bayar;
    TextView namapemesan, menuid, sajian, bahasa;
    RadioGroup radiosajian, radiobahasa;
    RadioButton hangat, dingin, bindo, bing;
    Button plus, min, order;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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

        llistitem.add("arabica");
        llistjumlah.add("0");
        llistsajian.add("");

        llistitem.add("robusta");
        llistjumlah.add("0");
        llistsajian.add("");

        llistitem.add("american");
        llistjumlah.add("0");
        llistsajian.add("");

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mAdapter = new Modul4RecycleViewAdapter(this, llistitem, llistjumlah, llistsajian);
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }

    public void pilihbahasaing(View view){
        int selectedID = radiobahasa.getCheckedRadioButtonId();
        if (selectedID==bing.getId()){
            namapemesan.setText(getString(R.string.ENpemesan));
            inputnama.setHint(getString(R.string.ENinputnama));
            bahasa.setText(getString(R.string.ENbahasa));
            order.setText(getString(R.string.ENorder));
        }
    }

    public void pilihbahasaind(View view){
        int selectedID = radiobahasa.getCheckedRadioButtonId();
        if (selectedID==bindo.getId()){
            namapemesan.setText(getString(R.string.IDNpemesan));
            inputnama.setHint(getString(R.string.IDNinputnama));
            bahasa.setText(getString(R.string.IDNbahasa));
            order.setText(getString(R.string.IDNorder));
        }
    }

    public void pesan(View view){
        Intent intent = new Intent(getApplicationContext(), Modul4pembayaran.class);
        intent.putExtra("namaa", inputnama.getText().toString());
        intent.putExtra("jeniskopi", llistitem);
        intent.putExtra("jenisajian", llistsajian);
        intent.putExtra("jumlahh", llistjumlah);
        startActivity(intent);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                int index = data.getIntExtra("index", 0);
                llistjumlah.set(index, data.getStringExtra("jumlah"));
                llistsajian.set(index, data.getStringExtra("sajian"));

                mAdapter.notifyDataSetChanged();
            }
        }
    }
}
