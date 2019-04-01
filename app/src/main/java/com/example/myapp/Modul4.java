package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modul4 extends AppCompatActivity {

    EditText username, password;
    Button butsign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul4);

        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
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
        String passs = "76";
        String userr = username.getText().toString();
        String pasword = password.getText().toString();

        Intent intent = new Intent(this, Modul4menu.class);

        if (userr.length() > 0){
            if (userr.matches(user) && (pasword.matches(passs))) {
                startActivity(intent);
                finish();
            }else{
                Toast toast = Toast.makeText(getApplicationContext(),"Username atau Password Salah", Toast.LENGTH_SHORT);
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
