package com.example.mojikontakti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinkedList<Kontakt> list = KontaktApi.getMyContacts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();
        findViewById(R.id.buttonOmiljeni).setOnClickListener(this);
        findViewById(R.id.buttonPorodica).setOnClickListener(this);
        findViewById(R.id.buttonPrijatelji).setOnClickListener(this);
        findViewById(R.id.buttonPoznanici).setOnClickListener(this);
        findViewById(R.id.imageButton).setOnClickListener(this);
        prikaziListu(list);
    }


    @Override
    public void onClick(View v) {
        System.out.println("ID KLIKNUTOG DUGMETA JE "+v.getId()+" a ja zelim "+Integer.toString(R.id.btnOsvezi));
        switch (v.getId()){
            case R.id.buttonOmiljeni: prikaziListu(KontaktApi.getContactsFromCategory(Kontakt.KATEGORIJA.OMILJENI));break;
            case R.id.buttonPrijatelji: prikaziListu(KontaktApi.getContactsFromCategory(Kontakt.KATEGORIJA.PRIJATELJI));break;
            case R.id.buttonPorodica: prikaziListu(KontaktApi.getContactsFromCategory(Kontakt.KATEGORIJA.PORODICA));break;
            case R.id.buttonPoznanici:prikaziListu(KontaktApi.getContactsFromCategory(Kontakt.KATEGORIJA.POZNANICI));break;
            case R.id.imageButton:;
            case R.id.btnDodajKontakt:
                Intent intent = new Intent(MainActivity.this,FormularActivity.class);
                startActivity(intent);break;
            case R.id.btnOsvezi: prikaziListu(KontaktApi.getMyContacts());break;
        }



    }

    public void prikaziListu(LinkedList<Kontakt> list){
        LinearLayout scrollView = (LinearLayout)findViewById(R.id.scrollViewLinearLayout);

        LayoutInflater inflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       scrollView.removeAllViews();
        int brojac=0;

        for(Kontakt k:list){

            assert inflater != null;
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

        assert inflater != null;
        ConstraintLayout cl = (ConstraintLayout) inflater.inflate(R.layout.donja_dugmad,null);
        scrollView.addView(cl);
        findViewById(R.id.btnDodajKontakt).setOnClickListener(this);
        findViewById(R.id.btnOsvezi).setOnClickListener(this);
    }

}
