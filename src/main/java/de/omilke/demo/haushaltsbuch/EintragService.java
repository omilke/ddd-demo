package de.omilke.demo.haushaltsbuch;

import de.omilke.demo.haushaltsbuch.infrastructure.InMemoryEintragRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EintragService {

    //@Inject | @Autowired | etc..
    EintragRepository eintragRepository = new InMemoryEintragRepository();


    public List<Eintrag> alleEintraegeZu(Kategorie kategorie) {

        return eintragRepository
                .alleEintraege().stream()
                    .filter(eintrag -> eintrag.gehoertZu(kategorie))
                .collect(Collectors.toList());

    }

}
