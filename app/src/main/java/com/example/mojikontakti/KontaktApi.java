package com.example.mojikontakti;

import java.util.LinkedList;

class KontaktApi {

    static LinkedList<Kontakt> getMyContacts(){
        LinkedList<Kontakt> list = new LinkedList<>();

        list.add(new Kontakt("Pera", "pera@gmail.com", Kontakt.KATEGORIJA.OMILJENI));
        list.add(new Kontakt("Pera", "perica95",Kontakt.KATEGORIJA.OMILJENI));
        list.add(new Kontakt("Milos", "+3816666666",Kontakt.KATEGORIJA.POZNANICI));
        list.add(new Kontakt("Dragan", "dragan",Kontakt.KATEGORIJA.POZNANICI));
        list.add(new Kontakt("Marica", "564231", Kontakt.KATEGORIJA.PRIJATELJI));
        list.add(new Kontakt("Zivan", "zivan@gmail.com", Kontakt.KATEGORIJA.PRIJATELJI));
        list.add(new Kontakt("Goran", "goran@gmail.com", Kontakt.KATEGORIJA.PORODICA));
        list.add(new Kontakt("Pera", "+345", Kontakt.KATEGORIJA.PORODICA));

        return list;
    }

    /**
    *Ova funkcija vraca listu kontakata sa zadatom kategorijom kojoj pripadaju
    * @param k se zadaje kao Kontakt.KATEGORIJA.
    * @return LinkedList<Kontakt>
    **/
    static LinkedList<Kontakt> getContactsFromCategory(Kontakt.KATEGORIJA k){
        LinkedList<Kontakt> kategorija = new LinkedList<>();
        LinkedList<Kontakt> list = KontaktApi.getMyContacts();
        for(Kontakt kontakt: list){

            if(kontakt.getKategorija()==k){
                kategorija.add(kontakt);
            }

        }
        return kategorija;
    }




}