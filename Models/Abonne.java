package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Abonne extends Personne {
    private static int compteur = 0;// compteur statique pour generer des ID uniques
    private String idAbonne;
    private String dateInscription;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //constructeur
    public Abonne(String nom, String prenom, String telephone,String email) {
        super(nom, prenom, telephone, email);
        this.idAbonne = genererIdAbonne().toUpperCase();
        this.dateInscription = LocalDate.now().format(DATE_FORMATTER);
    }

    //Methode pour generer automatiquement id de l abonne
    private static String genererIdAbonne() {
        compteur++;
        return "ABN" + String.format("%05d", compteur);
    }
    // mise en place des setter et getter
    public String getIdAbonne() {
        return idAbonne;
    }
    public String getDateInscription() {
        return dateInscription;

    }
    //affichage
    @Override
    public String toString() {
        return "\nID\n"+ idAbonne + super.toString() + "\nDate Inscription\n" + dateInscription;
    }
}
