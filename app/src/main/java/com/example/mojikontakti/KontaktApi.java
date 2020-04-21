package com.example.mojikontakti;

import java.util.LinkedList;

public class KontaktApi {

    public static LinkedList<Kontakt> getMyContacts(){
        LinkedList<Kontakt> list = new LinkedList<Kontakt>();

        list.add(new Kontakt("Pera", "pera@gmail.com"));
        list.add(new Kontakt("Pera", "perica95"));
        list.add(new Kontakt("Milos", "+3816666666"));
        list.add(new Kontakt("Dragan", "dragan"));
        list.add(new Kontakt("Marica", "564231"));
        list.add(new Kontakt("Zivan", "zivan@gmail.com"));
        list.add(new Kontakt("Goran", "goran@gmail.com"));
        list.add(new Kontakt("Pera", "+345"));

        return list;
    }


}