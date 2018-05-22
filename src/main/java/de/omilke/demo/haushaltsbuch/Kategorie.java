package de.omilke.demo.haushaltsbuch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Kategorie {

    private KategorieName name;

    private final List<Kategorie> unterkategorien = new ArrayList<>();

    Kategorie(KategorieName name) {
        this.name = name;
    }

    public void addUnterkategorie(Kategorie kategorie) {

        //Namenskonvention durchsetzen
        kategorie.name = new KategorieName(String.format("%s.%s", this.name, kategorie.name));
        unterkategorien.add(kategorie);
    }

    public boolean isUnterkategorieVon(Kategorie zuPruefendeKategorie) {

        return  (isKategorie(zuPruefendeKategorie)) ||
                (isEnthalten(zuPruefendeKategorie.unterkategorien));
    }

    private boolean isEnthalten(List<Kategorie> zuPruefendeKategorien) {


        return zuPruefendeKategorien.contains(this);
    }

    private boolean isKategorie(Kategorie zuPruefendeKategorie) {

        return this.equals(zuPruefendeKategorie);
    }

    public static Kategorie  of(String name) {

        return new Kategorie(new KategorieName(name));
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Kategorie)) {
            return false;
        }
        Kategorie kategorie = (Kategorie) o;
        return Objects.equals(name, kategorie.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}