package de.omilke.demo.haushaltsbuch;

import java.util.ArrayList;
import java.util.List;

public class Kategorie {

    private final String name;
    private final List<Kategorie> unterkategorien = new ArrayList<>();

    public Kategorie(String name) {

        this.name = name;
    }

    public void addUnterkategorie(Kategorie kategorie) {

        Kategorie unterkategorie = new Kategorie(String.format("%s.%s", this.name, kategorie.name));
        unterkategorien.add(unterkategorie);
    }

    public boolean isUnterkategorieVon(Kategorie kategorie) {

        return false;


    }
}