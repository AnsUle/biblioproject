public class Livre extends Materiel {
    private String auteur;
    private String editeur;
    private int anneePublictation;

    //Constructeur avec validations supplementaires pour livre
    public Livre(String id,String titre,int quantite,String auteur, String editeur, int anneePublictation) {
        super(id, titre, quantite);
        setAuteur(auteur);
        setEditeur(editeur);
        setAnneePublication(anneePublictation);
    }
    // getter et setter specifique à livre
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        if (auteur == null || auteur.trim().isEmpty()) {
            throw new IllegalArgumentException(" auteur ne peut pas etre vide");
        }
        this.auteur = auteur;
    }
    public String getEditeur() {
        return editeur;
    }
    public void setEditeur(String editeur) {
        if (editeur == null || editeur.trim().isEmpty()) {
            throw new IllegalArgumentException(" editeur ne peut pas etre vide");
        }
        this.editeur = editeur;
    }
    public int getAnneePublictation() {
        return anneePublictation;
    }
    public void setAnneePublication(int anneePublictation) {
        int anneeCourant = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        if (anneePublictation <= 0 || anneePublictation > anneeCourant) {
            throw new IllegalArgumentException(" Annee de publication incorrecte");
        }
        this.anneePublictation = anneePublictation;
    }
    //Affichage des informations specifiques à livre
    @Override
    public String toString() {
        return super.toString() + "\nAuteur\n" + auteur + "\nEditeur\n" + editeur + "\nAnnee de Publication\n" + anneePublictation;
    }
}
