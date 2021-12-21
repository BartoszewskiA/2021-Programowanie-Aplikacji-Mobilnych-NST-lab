package com.example.lab06p01_pin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView kto = findViewById(R.id.kto);
        Bundle paczka = getIntent().getExtras();
        kto.setText(paczka.getString("user"));
    }
}