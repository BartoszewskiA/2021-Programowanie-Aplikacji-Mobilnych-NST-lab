package com.example.w02p01_rownkw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editA, editB, editC;
    TextView wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        editC = findViewById(R.id.editC);
        wynik = findViewById(R.id.wynik);
    }

    public void licz(View view) {
//        double a =  Double.parseDouble(editA.getText().toString());
//        double b =  Double.parseDouble(editB.getText().toString());
//        double c =  Double.parseDouble(editC.getText().toString());
        String s;
        //--------------------------------------
        s = editA.getText().toString();
        if (s.equals("") || s.equals("-"))
        {
            s="0";
            editA.setText(s);
        }
        double a = Double.parseDouble(s);
        //---------------------------------------
        s = editB.getText().toString();
        if (s.equals("") || s.equals("-"))
        {
            s="0";
            editB.setText(s);
        }
        double b = Double.parseDouble(s);
        //----------------------------------------
        s = editC.getText().toString();
        if (s.equals("") || s.equals("-"))
        {
            s="0";
            editC.setText(s);
        }
        double c = Double.parseDouble(s);
        //------------------------------------------
        s = "";
        double delta = b*b - 4*a*c;
        s += "Delta = ";
        s += String.valueOf(delta);
        s += "\n";
        if (delta > 0)
        {
            double x1 = (-b - Math.sqrt(delta))/(2*a);
            double x2 = (-b + Math.sqrt(delta))/(2*a);
            s += "x1 = ";
            s += String.valueOf(x1);
            s += "\n";
            s += "x2 = ";
            s += String.valueOf(x2);
        }
        else if(delta == 0)
        {
            double x0 = (-b)/(2*a);
            s += "x0 = ";
            s += String.valueOf(x0);
        }
        else
        {
            s += "Brak rozwiązań";
        }
        wynik.setText(s);
    }

    public void zeruj(View view)
    {
        editA.setText("");
        editB.setText("");
        editC.setText("");
        wynik.setText("");
    }
}