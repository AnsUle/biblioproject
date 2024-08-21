package Models;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Personne {
    protected String nom;
    protected String prenom;
    protected String email;
    protected String telephone;

    protected static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    protected static final String TELEPHONE_REGEX = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]?\\d{2}){4}$";
    protected static final String NAME_REGEX = "^[a-zA-Z]\\w*$";
    protected Logger logger = Logger.getLogger(this.getClass().getName());

    public Personne(String nom, String prenom, String telephone, String email) {
        this.nom = validateNom(nom);
        this.prenom = validatePrenom(prenom);
        this.telephone = validateTelephone(telephone);
        this.email = validateEmail(email);
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    // Setters with validation
    public void setEmail(String email) {
        this.email = validateEmail(email);
    }

    public void setTelephone(String telephone) {
        this.telephone = validateTelephone(telephone);
    }

    public void setNom(String nom) {
        this.nom = validateNom(nom);
    }

    public void setPrenom(String prenom) {
        this.prenom = validatePrenom(prenom);
    }

    // Validation methods
    private String validateEmail(String email) {
        if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("Email invalide. Merci de fournir un email valide.");
        }
        return email;
    }

    private String validateTelephone(String telephone) {
        if (telephone == null){
            //capture l'erreur dans les logs sans lancer une exception
            logger.log(Level.SEVERE, "Erreur : Telphone est null");
        return null;
    }
        if (nom.trim().isEmpty()){
            throw new IllegalArgumentException("Nom ne peut pas etre vide");
        }
        if (!Pattern.matches(TELEPHONE_REGEX, telephone)) {
            throw new IllegalArgumentException("Numéro de téléphone invalide. Merci de fournir un numéro valide.");
        }
        return telephone;
    }

    private String validateNom(String nom) {
        if (nom == null ){
            logger.log(Level.SEVERE, "Erreur : le nom est null");
            return null;
        }
        if (nom.trim().isEmpty()){
            throw new IllegalArgumentException("Nom ne peut pas etre vide");
        }
        if (!Pattern.matches(NAME_REGEX, nom)) {
            throw new IllegalArgumentException("nom invalide. Merci de fournir un nom valide.");
        }
        return nom;
    }

    private String validatePrenom(String prenom) {
        if (prenom == null){
            logger.log(Level.SEVERE, "Erreur : le prenom est null");
            return null;
        }
        if (prenom.trim().isEmpty()){
            throw new IllegalArgumentException("Prenom ne peut pas etre vide");
        }
        if (!Pattern.matches(NAME_REGEX, prenom)) {
            throw new IllegalArgumentException(" Prénom invalide. Merci de fournir un prenom valide.");
        }
        return prenom;
    }

    @Override
    public String toString() {
        return "\nNom:\n" + nom + "\nPrénom:\n" + prenom + "\nEmail:\n" + email + "\nTéléphone:\n" + telephone;
    }
}
