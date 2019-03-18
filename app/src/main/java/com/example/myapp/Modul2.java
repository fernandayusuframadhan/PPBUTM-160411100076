package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Modul2 extends AppCompatActivity {

    TextView namapemesan, menuid, sajian, bahasa;
    CheckBox arabica, robusta, american;
    EditText inputnama, textcount, bayar;
    Button plus, min, order;
    RadioGroup radiosajian, radiobahasa;
    RadioButton hangat, dingin, bindo, bing;

    Integer jumlah;
    Integer idarabica = 11000, idrobusta = 10000, idamerican = 12000, idhangat = 2000, iddingin = 2500;
    Integer pesanan, menu1, menu2, menu3, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul2);

        namapemesan = findViewById(R.id.namapemesan);

        menuid = findViewById(R.id.menuid);
        sajian = findViewById(R.id.sajian);
        bahasa = findViewById(R.id.bahasa);
        inputnama = findViewById(R.id.inputnama);
        textcount = findViewById(R.id.textcount);

        plus = findViewById(R.id.plus);
        min = findViewById(R.id.min);

        order = findViewById(R.id.order);
        hangat = findViewById(R.id.hangat);
        dingin = findViewById(R.id.dingin);
        radiobahasa = findViewById(R.id.radiobahasa);
        radiosajian = findViewById(R.id.radiosajian);
        bindo = findViewById(R.id.bindo);
        bing = findViewById(R.id.bing);

        arabica = findViewById(R.id.arabica);
        robusta = findViewById(R.id.robusta);
        american= findViewById(R.id.american);

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

    }

    public void pesan(View view){

        Intent intent2 = new Intent(getApplication(), Modul2_1.class);

        String nama = inputnama.getText().toString();

        pesanan = Integer.valueOf(textcount.getText().toString());

        int selectedID = radiosajian.getCheckedRadioButtonId();
        if (pesanan > 0){
            String result;
            if (selectedID == dingin.getId() && (arabica.isChecked() || robusta.isChecked() || american.isChecked())){
                if (arabica.isChecked()){
                    menu1 = (idarabica + iddingin) * pesanan;
                    menu2 = 0;
                    menu3 = 0;
                    if (robusta.isChecked()){
                        menu2 = (idrobusta + iddingin) * pesanan;
                        menu3 = 0;
                    }else if (american.isChecked()){
                        menu2 = 0;
                        menu3 = (idamerican + iddingin) * pesanan;
                    }else if (robusta.isChecked() && american.isChecked()){
                        menu2 = (idrobusta + iddingin) * pesanan;
                        menu3 = (idamerican + iddingin) * pesanan;
                    }
                    total = menu1 + menu2 + menu3;
                }
                else if (robusta.isChecked()){
                    menu1 = 0;
                    menu2 = (idrobusta + iddingin)*pesanan;
                    menu3 = 0;
                    if (arabica.isChecked()){
                        menu1 = (idarabica + iddingin) * pesanan;
                        menu3 = 0;
                    }
                    else if (american.isChecked()){
                        menu1 = 0;
                        menu3 = (idamerican + iddingin) * pesanan;
                    }
                    else if (arabica.isChecked() && american.isChecked()){
                        menu1 = (idarabica + iddingin) * pesanan;
                        menu3 = (idamerican + iddingin) * pesanan;
                    }
                    total = menu1 + menu2 + menu3;
                }
                else if (american.isChecked()){
                    menu1 = 0;
                    menu2 = 0;
                    menu3 = (idamerican + iddingin)*pesanan;
                    if (arabica.isChecked()){
                        menu1 = (idarabica + iddingin) * pesanan;
                        menu2 = 0;
                    }
                    else if (robusta.isChecked()){
                        menu1 = 0;
                        menu2 = (idrobusta + iddingin) * pesanan;
                    }
                    else if (arabica.isChecked() && robusta.isChecked()){
                        menu1 = (idarabica + iddingin) * pesanan;
                        menu2 = (idrobusta + iddingin) * pesanan;
                    }
                    total = menu1 + menu2 + menu3;
                }

                result = total.toString();
                intent2.putExtra("namaa", nama);
                intent2.putExtra("isidata", result);
                startActivity(intent2);
            }
            else if (selectedID==hangat.getId() && (arabica.isChecked() || robusta.isChecked() || american.isChecked())){
                if (arabica.isChecked()){
                    menu1 = (idarabica + idhangat)*pesanan;
                    menu2 = 0;
                    menu3 = 0;
                    if (robusta.isChecked()){
                        menu2 = (idrobusta + idhangat) * pesanan;
                        menu3 = 0;
                    }
                    else if (american.isChecked()){
                        menu2 = 0;
                        menu3 = (idamerican + idhangat) * pesanan;
                    }
                    else if (robusta.isChecked() && american.isChecked()){
                        menu2 = (idrobusta + idhangat) * pesanan;
                        menu3 = (idamerican + idhangat) * pesanan;
                    }
                    total = menu1 + menu2 + menu3;
                }
                else if (robusta.isChecked()){
                    menu1 = 0;
                    menu2 = (idrobusta + idhangat)*pesanan;
                    menu3 = 0;
                    if (arabica.isChecked()){
                        menu1 = (idarabica + idhangat) * pesanan;
                        menu3 = 0;
                    }
                    else if (american.isChecked()){
                        menu1 = 0;
                        menu3 = (idamerican + idhangat) * pesanan;
                    }
                    else if (arabica.isChecked() && american.isChecked()){
                        menu1 = (idarabica + idhangat) * pesanan;
                        menu3 = (idamerican + idhangat) * pesanan;
                    }
                    total = menu1 + menu2 + menu3;
                }
                else if (american.isChecked()){
                    menu1 = 0;
                    menu2 = 0;
                    menu3 = (idamerican + idhangat)*pesanan;
                    if (arabica.isChecked()){
                        menu1 = (idarabica + idhangat) * pesanan;
                        menu2 = 0;
                    }
                    else if (robusta.isChecked()){
                        menu1 = 0;
                        menu2 = (idrobusta + idhangat) * pesanan;
                    }
                    else if (arabica.isChecked() && robusta.isChecked()){
                        menu1 = (idarabica + idhangat) * pesanan;
                        menu2 = (idrobusta + idhangat) * pesanan;
                    }
                    total = menu1 + menu2 + menu3;
                }
                result = total.toString();
                intent2.putExtra("namaa", nama);
                intent2.putExtra("isidata", result);
                startActivity(intent2);
            }
        }
    }

    public void pilihbahasaing(View view){
        int selectedID = radiobahasa.getCheckedRadioButtonId();
        if (selectedID==bing.getId()){
            namapemesan.setText(getString(R.string.ENpemesan));
            inputnama.setText(getString(R.string.ENinputnama));
            menuid.setText(getString(R.string.ENmenukopi));
            sajian.setText(getString(R.string.ENsajian));
            bahasa.setText(getString(R.string.ENbahasa));
            hangat.setText(getString(R.string.ENhangat));
            dingin.setText(getString(R.string.ENdingin));
            order.setText(getString(R.string.ENorder));
        }
    }

    public void pilihbahasaind(View view){
        int selectedID = radiobahasa.getCheckedRadioButtonId();
        if (selectedID==bindo.getId()){
            namapemesan.setText(getString(R.string.IDNpemesan));
            inputnama.setText(getString(R.string.IDNinputnama));
            menuid.setText(getString(R.string.IDNmenukopi));
            sajian.setText(getString(R.string.IDNsajian));
            bahasa.setText(getString(R.string.IDNbahasa));
            hangat.setText(getString(R.string.IDNhangat));
            dingin.setText(getString(R.string.IDNdingin));
            order.setText(getString(R.string.IDNorder));
        }
    }

}
