package de.omilke.demo.haushaltsbuch;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KategorieTest {


    @Test
    public void isUnterkategorie() {

        Kategorie parent = Kategorie.of("parent");

        //Teil von sich selbst
        assertThat(parent.isUnterkategorieVon(parent)).isTrue();

        Kategorie child = Kategorie.of("child");
        parent.addUnterkategorie(child);

        //
        assertThat(child.isUnterkategorieVon(parent)).isTrue();
        assertThat(parent.isUnterkategorieVon(child)).isFalse();
    }
}