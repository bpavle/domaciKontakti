package com.example.mojikontakti;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.ArrayList;

public class FormularActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_formular);
        getSupportActionBar().hide();


        Spinner spinerDrzava = (Spinner) findViewById(R.id.spinnerDrzava);
        Spinner spinerKategorija = (Spinner) findViewById(R.id.spinnerKategorija);

        final EditText etIme = (EditText) findViewById(R.id.editTextIme);
        final EditText etPrezime = (EditText) findViewById(R.id.editTextPrezime);
        final EditText etTelefon  = (EditText) findViewById(R.id.editTextTelefon);
        final EditText etGrad = (EditText) findViewById(R.id.editTextGrad);
        final EditText etMail = (EditText) findViewById(R.id.editTextMail);
        final EditText etNadimak = (EditText) findViewById(R.id.editTextNadimak);
        final EditText etUlica = (EditText) findViewById(R.id.editTextUlica);
        final EditText etBroj  = (EditText) findViewById(R.id.editTextBroj);

        Switch swPodsetnik = (Switch)findViewById(R.id.switchUkljuciPodsetnik);

        final DatePicker datePicker = (DatePicker)findViewById(R.id.datePickerRodjendan);



        ArrayList<String> listaKategorija = new ArrayList<>();
        listaKategorija.add("OMILJENI");
        listaKategorija.add("PORODICA");
        listaKategorija.add("POZNANICI");
        listaKategorija.add("PRIJATELJI");

        ArrayAdapter<String> adapterKategorija = new ArrayAdapter<>(this,R.layout.spinne_item,listaKategorija );
        spinerKategorija.setAdapter(adapterKategorija);

        ArrayList<String> listaDrzava = new ArrayList<>();
        listaDrzava.add("Srbija");
        listaDrzava.add("Hrvatska");
        listaDrzava.add("Crna Gora");
        listaDrzava.add("Slovenija");
        listaDrzava.add("Bosna i Hercegovina");
        listaDrzava.add("Severna Makedonija");
        ArrayAdapter<String> adapterDrzava = new ArrayAdapter<>(this,R.layout.spinne_item,listaDrzava);
        spinerDrzava.setAdapter(adapterDrzava);




        findViewById(R.id.btnDodajKontakt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormularActivity.this,IzvestajActivity.class);

            }
        });

        findViewById(R.id.btnPonisti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etBroj.setText("");
                etGrad.setText("");
                etIme.setText("");
                etMail.setText("");
                etNadimak.setText("");
                etPrezime.setText("");
                etTelefon.setText("");
                etUlica.setText("");



            }
        });


        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularActivity.this,MainActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setExitTransition(new Slide(Gravity.RIGHT));
                    startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(FormularActivity.this).toBundle());

                } else {
                    startActivity(intent);
                }

            }
        });

    }
}
