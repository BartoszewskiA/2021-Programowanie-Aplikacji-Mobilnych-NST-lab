package com.example.lab06p01_pin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner01;
    EditText editText01;
    Button button01;
    String[] piny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner01 = findViewById(R.id.spinner01);
        editText01 = findViewById(R.id.editText01);
        button01 = findViewById(R.id.button01);
        piny = getResources().getStringArray(R.array.hasla);
        dodajSluchacze();
    }

    private void dodajSluchacze() {
        editText01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (sprawdzHaslo(charSequence.toString())) button01.setEnabled(true);
                else
                    button01.setEnabled(false);
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencja = new Intent(getApplicationContext(), MainActivity2.class);
                intencja.putExtra("user",spinner01.getSelectedItem().toString());
                startActivity(intencja);
            }
        });

        spinner01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                button01.setEnabled(false);
                editText01.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private boolean sprawdzHaslo(String s) {
        int id = (int)spinner01.getSelectedItemId();
        if (s.equals(piny[id]))
            return true;
        else
            return false;
    }
}