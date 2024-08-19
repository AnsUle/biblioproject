package test;

import Models.Personne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    private Personne personne;

    @BeforeEach
    void setUp() {
        // Initialisation d'une instance de Personne pour chaque test
        personne = new Personne("Doe", "John", "0123456789", "john.doe@example.com");
    }

    @Test
    void testGetNom() {
        assertEquals("Doe", personne.getNom());
    }

    @Test
    void testGetPrenom() {
        assertEquals("John", personne.getPrenom());
    }

    @Test
    void testGetEmail() {
        assertEquals("john.doe@example.com", personne.getEmail());
    }

    @Test
    void testGetTelephone() {
        assertEquals("0123456789", personne.getTelephone());
    }

    @Test
    void testSetNomValide() {
        personne.setNom("Smith");
        assertEquals("Smith", personne.getNom());
    }

    @Test
    void testSetPrenomValide() {
        personne.setPrenom("Jane");
        assertEquals("Jane", personne.getPrenom());
    }

    @Test
    void testSetEmailValide() {
        personne.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", personne.getEmail());
    }

    @Test
    void testSetTelephoneValide() {
        personne.setTelephone("0987654321");
        assertEquals("0987654321", personne.getTelephone());
    }

    @Test
    void testSetNomInvalide() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personne.setNom("");
        });
        assertEquals("Le nom ne peut pas être vide.", exception.getMessage());
    }

    @Test
    void testSetPrenomInvalide() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personne.setPrenom("");
        });
        assertEquals("Le prénom ne peut pas être vide.", exception.getMessage());
    }

    @Test
    void testSetEmailInvalide() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personne.setEmail("invalid-email");
        });
        assertEquals("Email invalide. Merci de fournir un email valide.", exception.getMessage());
    }

    @Test
    void testSetTelephoneInvalide() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personne.setTelephone("123");
        });
        assertEquals("Numéro de téléphone invalide. Merci de fournir un numéro valide.", exception.getMessage());
    }

    @Test
    void testToString() {
        String expected = "Nom: Doe\nPrénom: John\nEmail: john.doe@example.com\nTéléphone: 0123456789";
        assertEquals(expected, personne.toString());
    }
}
