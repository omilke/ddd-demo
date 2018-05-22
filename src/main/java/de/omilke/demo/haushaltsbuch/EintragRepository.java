package de.omilke.demo.haushaltsbuch;

import java.util.List;

public interface EintragRepository {

    void speichereEintrag(Eintrag eintrag);
    void entferneEintrag(Eintrag eintrag);
    List<Eintrag> alleEintraege();

}
