import java.util.regex.Pattern;

public class Personne {
    protected String nom;
    protected String prenom;
    protected String email;
    protected String telephone;

    protected static final String EMAIL_REGEX = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    protected static final String TELEPHONE_REGEX = "^0[1-9]([-. ]?[0-9]{2}){4}$";

    public Personne(String nom, String prenom, String email, String telephone) {
        setNom(nom);
        setPrenom(prenom);
        setEmail (email);
        setTelephone(telephone);
    }
    // mise en place de getter absence de setter pour eviter les modif apres premiere sasit
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
    public void setEmail(String email) {
        if (email == null ||!Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("Email invalid");
        }
        this.email = email;
    }
    public void setTelephone(String telephone) {
        if (telephone == null || !Pattern.matches(TELEPHONE_REGEX, telephone)) {
            throw new IllegalArgumentException("Telephone invalid");
        }
        this.telephone = telephone;
    }

    public void setNom(String nom) {
            if (nom == null || nom.trim().isEmpty()) {
                throw new IllegalArgumentException(" Nom ne peut pas etre vide");
            }
            this.nom = nom;
    }
    public void setPrenom(String prenom) {
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new IllegalArgumentException(" Prenom ne peut pas etre vide");
        }
        this.prenom = prenom;
    }

    public String toString() {
        return "\nNOM\n" + nom + "\nPRENOM\n" + prenom + "\nADRESSE MAIL\n" + email + "\nTELEPHONE\n" + telephone;
    }
}
