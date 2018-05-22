package de.omilke.demo.haushaltsbuch.infrastructure;

import de.omilke.demo.haushaltsbuch.Eintrag;
import de.omilke.demo.haushaltsbuch.EintragRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEintragRepository implements EintragRepository {

    private final List<Eintrag> eintraege = new ArrayList<>();

    @Override
    public void speichereEintrag(Eintrag eintrag) {

        if (!eintraege.contains(eintrag)) {
            this.eintraege.add(eintrag);
        }
    }

    @Override
    public void entferneEintrag(Eintrag eintrag) {

        eintraege.remove(eintrag);
    }

    @Override
    public List<Eintrag> alleEintraege() {

        return eintraege;
    }
}
