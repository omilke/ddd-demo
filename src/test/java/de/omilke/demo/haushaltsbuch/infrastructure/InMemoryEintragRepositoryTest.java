package de.omilke.demo.haushaltsbuch.infrastructure;

import de.omilke.demo.haushaltsbuch.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;


public class InMemoryEintragRepositoryTest {

    @Test
    public void alleEintraege() {

        InMemoryEintragRepository eintragRepository = new InMemoryEintragRepository();

        assertThat(eintragRepository.alleEintraege()).isEmpty();

        Kategorie kategorie = Kategorie.of("Beispielkategorie");
        Betrag betrag = new Betrag(BigDecimal.TEN);
        Datum datum = new Datum(LocalDate.of(2018, Month.MAY, 15));
        Kommentar kommentar = new Kommentar("Kommentar");

        //Eintrag ist jetzt vorhanden
        Eintrag first = new Eintrag(betrag, datum, kommentar, kategorie);
        eintragRepository.speichereEintrag(first);
        assertThat(eintragRepository.alleEintraege()).hasSize(1);

        //gleicher eintrag, nicht derselbe Eintrag ist korrekt ergänzt
        Eintrag second = new Eintrag(betrag, datum, kommentar, kategorie);
        eintragRepository.speichereEintrag(second);
        assertThat(eintragRepository.alleEintraege()).hasSize(2);

        //bereits vorhandener Eintrag wird wiedererkannt
        eintragRepository.speichereEintrag(first);
        assertThat(eintragRepository.alleEintraege()).hasSize(2);


        //... und wieder entfernen
        eintragRepository.entferneEintrag(second);
        assertThat(eintragRepository.alleEintraege()).hasSize(1);

        eintragRepository.entferneEintrag(first);
        assertThat(eintragRepository.alleEintraege()).isEmpty();

    }
}