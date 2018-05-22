package de.omilke.demo.haushaltsbuch;

import java.util.Objects;

public class Eintrag {

    private final EintragId eintragId;

    private Betrag betrag;
    private Datum datum;
    private Kommentar kommentar;
    private Kategorie kategorie;

    public Eintrag(Betrag betrag, Datum datum, Kommentar kommentar, Kategorie kategorie) {

        eintragId = new EintragId();

        this.betrag = betrag;
        this.datum = datum;

        this.kommentar = kommentar;
        this.kategorie = kategorie;
    }

    public boolean isTeilVon(Kategorie kategorie) {

        return this.kategorie.isUnterkategorieVon(kategorie);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Eintrag)) {
            return false;
        }

        Eintrag eintrag = (Eintrag) o;
        return Objects.equals(eintragId, eintrag.eintragId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eintragId);
    }
}
