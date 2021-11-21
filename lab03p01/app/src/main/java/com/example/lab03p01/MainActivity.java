package com.example.lab03p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button p0,p1,p2;
    Random random;
    TextView wylosowana, odpowiedz;
    int liczbaLosowa;
    int[] tablica =  new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        p0 = findViewById(R.id.button00);
        p1 = findViewById(R.id.button01);
        p2 = findViewById(R.id.button02);
        wylosowana = findViewById(R.id.wylosowana);
        odpowiedz = findViewById(R.id.odpowiedz);
        liczbaLosowa = random.nextInt(3) + 1;
        wylosowana.setText(String.valueOf(liczbaLosowa));
        losujOpisyPrzyciskow();
        dodajSluchacze();

    }

    private void dodajSluchacze() {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                boolean trafione = false;
                switch (id)
                {
                    case R.id.button00: if (tablica[0]==liczbaLosowa) trafione=true; break;
                    case R.id.button01: if (tablica[1]==liczbaLosowa) trafione=true; break;
                    case R.id.button02: if (tablica[2]==liczbaLosowa) trafione=true; break;
                }
                if (trafione)
                    odpowiedz.setText("OK");
                else
                    odpowiedz.setText("NO");
            }
        };
        p0.setOnClickListener(sluchacz);
        p1.setOnClickListener(sluchacz);
        p2.setOnClickListener(sluchacz);
    }

    private void losujOpisyPrzyciskow() {
        int poz =0;
        while (poz<3)
        {
            boolean powtorzenie = false;
            do {
                powtorzenie = false;
                tablica[poz] = random.nextInt(3)+1;
                for (int i=0; i<poz; i++)
                    if (tablica[i]==tablica[poz])
                        powtorzenie = true;
            } while(powtorzenie);
            poz++;
        }
        p0.setText(String.valueOf(tablica[0]));
        p1.setText(String.valueOf(tablica[1]));
        p2.setText(String.valueOf(tablica[2]));

    }
}