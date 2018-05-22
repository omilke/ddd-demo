package de.omilke.demo.haushaltsbuch;

import java.util.Objects;

public class KategorieName {

    private final String name;

    public KategorieName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof KategorieName)) {
            return false;
        }
        KategorieName that = (KategorieName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
