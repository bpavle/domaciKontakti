package com.example.mojikontakti;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import java.util.Locale;

public class FormularActivity extends AppCompatActivity {

    public static String ime = "ime";
    public static String prezime = "prezime";
    public static String telefon = "telefon";
    public static String grad = "grad";
    public static String mail = "mail";
    public static String nadimak = "nadimak";
    public static String ulicaIbr = "ulicaIbr";
    public static String drzava = "drzava";
    public static String kategorija = "kategorija";
    public static String podsetnik = "podsetnik";
    public static String rodjendan = "rodjendan";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_formular);
        getSupportActionBar().hide();


        final Spinner spinerDrzava = (Spinner) findViewById(R.id.spinnerDrzava);
        final Spinner spinerKategorija = (Spinner) findViewById(R.id.spinnerKategorija);

        final EditText etIme = (EditText) findViewById(R.id.editTextIme);
        final EditText etPrezime = (EditText) findViewById(R.id.editTextPrezime);
        final EditText etTelefon  = (EditText) findViewById(R.id.editTextTelefon);
        final EditText etGrad = (EditText) findViewById(R.id.editTextGrad);
        final EditText etMail = (EditText) findViewById(R.id.editTextMail);
        final EditText etNadimak = (EditText) findViewById(R.id.editTextNadimak);
        final EditText etUlica = (EditText) findViewById(R.id.editTextUlica);
        final EditText etBroj  = (EditText) findViewById(R.id.editTextBroj);

        final Switch swPodsetnik = (Switch)findViewById(R.id.switchUkljuciPodsetnik);

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

                intent.putExtra(ime,etIme.getText().toString());
                intent.putExtra(prezime,etPrezime.getText().toString());
                intent.putExtra(ulicaIbr,etUlica.getText().toString()+etBroj.getText().toString());
                intent.putExtra(mail,etMail.getText().toString());
                intent.putExtra(nadimak,etNadimak.getText().toString());
                intent.putExtra(drzava,spinerDrzava.getSelectedItem().toString());
                intent.putExtra(kategorija,spinerKategorija.getSelectedItem().toString());
                intent.putExtra(grad,etGrad.getText().toString());
                intent.putExtra(rodjendan,String.format("%2d.%2d.%4d",datePicker.getDayOfMonth(),datePicker.getMonth(),datePicker.getYear()));
                intent.putExtra(telefon,etTelefon.getText().toString());
                intent.putExtra(podsetnik,swPodsetnik.getText().toString());

                /*
                intent.putExtra(rodjendan,String.format("%2d.%2d.%4d",datePicker.getDayOfMonth(),datePicker.getMonth(),datePicker.getYear()));*/

                startActivity(intent);
            }
        });

        findViewById(R.id.btnPonisti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etBroj.setText("");
                etGrad.setText("");

                etMail.setText("");
                etNadimak.setText("");
                etPrezime.setText("");
                etTelefon.setText("");
                etUlica.setText("");
                etIme.setText("");


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
