package de.omilke.demo.haushaltsbuch;

import java.util.Objects;
import java.util.UUID;

public class EintragId {

    private final UUID id = UUID.randomUUID();

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof EintragId)) {
            return false;
        }

        EintragId eintragId = (EintragId) o;
        return Objects.equals(id, eintragId.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
