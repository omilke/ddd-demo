package de.omilke.demo.haushaltsbuch;

public class Eintrag {

    private final EintragId eintragId = new EintragId();

    private Betrag betrag;
    private Datum datum;
    private Kommentar kommentar;
    private Kategorie kategorie;

    public Eintrag(Betrag betrag, Datum datum, Kommentar kommentar, Kategorie kategorie) {

        this.betrag = betrag;
        this.datum = datum;

        this.kommentar = kommentar;
        this.kategorie = kategorie;
    }

    public boolean gehoertZu(Kategorie kategorie) {

        return this.kategorie.isUnterkategorieVon(kategorie);
    }

}
