package Models;

public class Bibliothecaire extends Personne {
    private String identifiant;
    private static int compteur = 0;
    private String mdp;

    public Bibliothecaire(String nom, String prenom,  String telephone, String email,String mdp) {
        super(nom, prenom, telephone, email);
        this.identifiant = genererIdentifiantBib();
        this.mdp = mdp;
    }
    private static String genererIdentifiantBib() {
        compteur++;
        return "BIB " + String.format("%02d", compteur);
    }
    public String getMdp() {
        return mdp;
    }
    public String getIdentifiant() {

        return identifiant;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    //Affichage
    @Override
    public String toString() {
        return "\nBIBLIOTECAIRE\n" + "Identifiant : \n" + identifiant + super.toString();
    }
}

