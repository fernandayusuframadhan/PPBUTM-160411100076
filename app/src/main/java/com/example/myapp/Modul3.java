package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modul3 extends AppCompatActivity {

    EditText username, pass;
    Button butsign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul3);

        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        butsign = findViewById(R.id.butsign);

        butsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin();
            }
        });
    }

    public void signin(){
        String user = "yusuf";
        String passs = "abcd";
        String userr = username.getText().toString();
        String pasword = pass.getText().toString();

        Intent intent = new Intent(this, Modul2.class);

        if (userr.length() > 0){
            if (userr.matches(user) && (pasword.matches(passs))) {
                startActivity(intent);
                finish();
            }else{
                Toast toast = Toast.makeText(getApplicationContext(),"Username dan Password Salah", Toast.LENGTH_SHORT);
                toast.show();;
            }
        }else{
            if (userr.isEmpty()){
                Toast toast = Toast.makeText(getApplicationContext(),"Username tidak ada",Toast.LENGTH_SHORT);
                toast.show();
            }else if (pasword.isEmpty()){
                Toast toast = Toast.makeText(getApplicationContext(),"Password tidak ada",Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }
}
