package com.example.kalkulatornapiwkow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView wynik;
    EditText cenaJedzenia,standardowyNapiwek;
    RatingBar ocenaJedzenia;
    RadioButton dobraObsluga,normalnaObsluga,zlaObsluga;
    RadioGroup jakoscObslugi;
    Button oblicz;
    float obliczonyWynik;
    float obliczonyNapiwek;
    float liczbaCenaJedzenia;
    float liczbaStandardowyNapiwek;
    float liczbaOcenaJedzenia;
    float liczbaJakoscObslugi=0;
    String wiadomosc="Cena zamówienia: 0\nNapiwek: 0\nSuma: 0\n";;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wynik = (TextView)findViewById(R.id.wynik);
        cenaJedzenia = (EditText)findViewById((R.id.cenaJedzenia));
        standardowyNapiwek = (EditText)findViewById((R.id.standardowyNapiwek));
        ocenaJedzenia = (RatingBar)findViewById(R.id.ocenaJedzenia);
        dobraObsluga = (RadioButton)findViewById((R.id.dobraObsluga));
        normalnaObsluga = (RadioButton)findViewById((R.id.normalnaObsluga));
        zlaObsluga = (RadioButton)findViewById((R.id.zlaObsluga));
        oblicz = (Button)findViewById((R.id.oblicz));
        jakoscObslugi = (RadioGroup)findViewById((R.id.jakoscObslugi));
        wynik.setText(wiadomosc);
        oblicz.setOnClickListener(v -> {
            liczbaCenaJedzenia = Float.parseFloat(cenaJedzenia.getText().toString());
            liczbaStandardowyNapiwek = Float.parseFloat(standardowyNapiwek.getText().toString());
            liczbaOcenaJedzenia = ocenaJedzenia.getRating()/2;
            if (dobraObsluga.isChecked()){
                liczbaJakoscObslugi = 2;
            }
            if(normalnaObsluga.isChecked()){
                liczbaJakoscObslugi = 1;
            }
            if(zlaObsluga.isChecked()){
                liczbaJakoscObslugi = 0;
            }
            obliczonyNapiwek = (float)Math.round(100*(liczbaCenaJedzenia*(liczbaStandardowyNapiwek/100)+liczbaOcenaJedzenia+liczbaJakoscObslugi))/100;
            obliczonyWynik = liczbaCenaJedzenia + obliczonyNapiwek;
            wiadomosc="Cena zamówienia: "+liczbaCenaJedzenia+"\n" + "Napiwek: " + obliczonyNapiwek + "\n" + "Suma: "+obliczonyWynik+"\n";
            wynik.setText(wiadomosc);
        });

    }
}