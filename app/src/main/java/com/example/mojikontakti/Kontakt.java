package com.example.mojikontakti;

public class Kontakt {

    /**
     * enum tip koji sluzi za oznacavanje kategorije korisnika
     */
    public enum KATEGORIJA{OMILJENI,PRIJATELJI,PORODICA,POZNANICI}

    private String ime, telefon;
    private KATEGORIJA kategorija;


    public Kontakt(String ime, String tel) {
        this.ime = ime;
        this.telefon = tel;

    }
    public Kontakt(String ime, String tel,KATEGORIJA kategorija) {
        this.ime = ime;
        this.telefon = tel;
        this.kategorija = kategorija;

    }
    /**
     * getIme() vraca string privatnog atributa ime;
     */
    public String getIme() {
        return ime;
    }
    /**
     * setIme() postavlja vrednost privatnog atributa ime;
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * getTelefon() vraca string privatnog atributa telefon;
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * setTelefon() postavlja vrednost privatnog atributa telefon;
     */
    public void setTelefon(String t) {
        this.telefon = t;
    }

    /**
     * getKategorija() vraca enum tip privatnog atributa kategorija;
     * Za sve vrednosti KATEGORIJE pogledati Kontakt.KATEGORIJA javni enum
     * @return kategoriju kojoj kontakt pripada
     */
    public KATEGORIJA getKategorija(){return kategorija; }

    /**
     * setKategorija() postavlja vrednost enum tipa privatnog atributa kategorija;
     * Za sve vrednosti KATEGORIJE pogledati Kontakt.KATEGORIJA javni enum
     */
    public void setKategorija(KATEGORIJA k){kategorija =k; }

    @Override
   public String toString(){
        return getIme()+", tel: "+getTelefon();
    }


}