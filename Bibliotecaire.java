public class Bibliotecaire extends Personne{
    private String identifiant;
    private static int compteur = 0;

    public Bibliotecaire(String nom, String prenom,String email,String telephone) {
        super(nom, prenom, email, telephone);
        this.identifiant = genererIdentifiantBib();
    }
    private static String genererIdentifiantBib() {
        compteur++;
        return "BIB " + String.format("%02d", compteur);
    }
    public String getIdentifiant() {
        return identifiant;
    }
    //Affichage
    @Override
    public String toString() {
        return "\nBIBLIOTECAIRE\n" + "Identifiant : \n" + identifiant + super.toString();
    }
}
