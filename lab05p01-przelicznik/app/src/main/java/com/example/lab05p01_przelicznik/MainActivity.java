package com.example.lab05p01_przelicznik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView walutaZrodlowa, walutaDocelowa;
    Spinner spinnerZrodlowa, spinnerDocelowa;
    SeekBar suwak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        znajdzKontrolki();
        spinnerDocelowa.setSelection(1);
        dodajSluchaczSuwaka();



    }

    private void przelicz() {
        int wartoscZr = Integer.parseInt(walutaZrodlowa.getText().toString());
        double wartoscDoc=0;
        double wartoscPrzeliczeniowa=0;

        switch((int) spinnerZrodlowa.getSelectedItemId())
        {
            case 0: wartoscPrzeliczeniowa=wartoscZr; break;
            case 1: wartoscPrzeliczeniowa=wartoscZr * 4.85; break;
            case 2: wartoscPrzeliczeniowa=wartoscZr * 3.85; break;
        }

        switch((int) spinnerDocelowa.getSelectedItemId())
        {
            case 0: wartoscDoc=wartoscPrzeliczeniowa; break;
            case 1: wartoscDoc=wartoscPrzeliczeniowa / 4.85; break;
            case 2: wartoscDoc=wartoscPrzeliczeniowa / 3.85; break;
        }

        wartoscDoc=Math.round(wartoscDoc*100)/100.0;

        walutaDocelowa.setText(String.valueOf(wartoscDoc));

    }

    private void dodajSluchaczSuwaka() {
        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                walutaZrodlowa.setText(String.valueOf(i));
                przelicz();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void znajdzKontrolki() {
        walutaZrodlowa = findViewById(R.id.walutaZrodlowa);
        walutaDocelowa = findViewById(R.id.walutaDocelowa);
        spinnerZrodlowa  = findViewById(R.id.spinnerZrodlowa);
        spinnerDocelowa  = findViewById(R.id.spinnerDocelowa);
        suwak = findViewById(R.id.suwak);
    }
}