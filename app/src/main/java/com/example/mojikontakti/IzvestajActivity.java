package com.example.mojikontakti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.mojikontakti.FormularActivity.drzava;
import static com.example.mojikontakti.FormularActivity.grad;
import static com.example.mojikontakti.FormularActivity.ime;
import static com.example.mojikontakti.FormularActivity.kategorija;
import static com.example.mojikontakti.FormularActivity.mail;
import static com.example.mojikontakti.FormularActivity.nadimak;
import static com.example.mojikontakti.FormularActivity.podsetnik;
import static com.example.mojikontakti.FormularActivity.prezime;
import static com.example.mojikontakti.FormularActivity.rodjendan;
import static com.example.mojikontakti.FormularActivity.telefon;
import static com.example.mojikontakti.FormularActivity.ulicaIbr;

public class IzvestajActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izvestaj);
        getSupportActionBar().hide();


        Intent intent = getIntent();

        String ime_ = intent.getStringExtra(ime);
        String prezime_ = intent.getStringExtra(prezime);
        String telefon_ = intent.getStringExtra(telefon);
        String grad_ = intent.getStringExtra(grad);
        String mail_ = intent.getStringExtra(mail);
        String nadimak_ = intent.getStringExtra(nadimak);
        String ulicaIbr_ = intent.getStringExtra(ulicaIbr);
        String drzava_ = intent.getStringExtra(drzava);
        String kategorija_ =    intent.getStringExtra(kategorija);
        String podsetnik_ = intent.getStringExtra(podsetnik);
        String rodjendan_ = intent.getStringExtra(rodjendan);

        ((TextView)findViewById(R.id.texViewOpstiPodaci)).setText("" +
                "Uspesno je napravljen kontakt "+ime_+" "+prezime_+", zvani " +
                "" +nadimak_+" koji je svrstan u kategoriju: "+kategorija_+".");
        ((TextView)findViewById(R.id.texViewRodjendan)).setText("Rodjen je dana "+rodjendan_);
        ((TextView)findViewById(R.id.texViewAdresa)).setText("Ova osoba stanuje" +
                " na adresi: "+ulicaIbr_+", "+grad_+", "+drzava_+".");
        ((TextView)findViewById(R.id.texViewTelefon)).setText("Broj telefona za kontakt je: "+telefon_);
        ((TextView)findViewById(R.id.texViewMail)).setText("Adresa elektronske poste je: "+mail_);



        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IzvestajActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}
