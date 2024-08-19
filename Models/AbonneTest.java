package Models;

import org.junit.jupiter.api.Test;

class AbonneTest {
    Abonne abonne ;

    @Test
    void getIdAbonne() {
        abonne = new Abonne("doe","john","0789020034","anna.sul@gmail.com");
    }

    @Test
    void getDateInscription() {
    }

    @Test
    void testToString() {
    }
}