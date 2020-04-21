package com.example.mojikontakti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList<Kontakt> list = KontaktApi.getMyContacts();

        getSupportActionBar().hide();


        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FormularActivity.class);
                startActivity(intent);
            }
        });




        LinearLayout scrollView = (LinearLayout)findViewById(R.id.scrollViewLinearLayout);

        LayoutInflater inflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int brojac=0;
        for(Kontakt k:list){

            ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.kontakt,null);
            ConstraintLayout linija=(ConstraintLayout) inflater.inflate(R.layout.linija,null);
            ((TextView)cl.findViewById(R.id.ime)).setText(k.getIme());
            ((TextView)cl.findViewById(R.id.telefon)).setText(k.getTelefon());

            if(Build.VERSION.SDK_INT>= 23)
            if(brojac %2==0){
                cl.setBackgroundColor(getColor(R.color.colorParniKontakt));
            }
            brojac++;

            scrollView.addView(cl);
            if(brojac != list.size()) scrollView.addView(linija);
        }

        ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.donja_dugmad,null);
        scrollView.addView(cl);

        cl.findViewById(R.id.dodajKontakt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FormularActivity.class);
                startActivity(intent);
            }
        });
    }


}
