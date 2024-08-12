public class Materiel {
    protected String id; // id unique pour chaque materiel
    protected String titre;
    protected int quantite; //nbre exemple dispo

    //Constructeur avec validations
    public Materiel(String id, String titre, int quantite) {
        setId(id);
        setTitre(titre);
        setQuantite(quantite);
    }
    //getter
    public String getId() {
        return id;
    }
    public String getTitre(String titre) {
        return titre;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setId(String id) {
        if (id == null|| id.trim().isEmpty()){
            throw new IllegalArgumentException( " Le titre ne peut pas etre vide");
        }
        this.id = id;
    }
    public void setQuantite(int quantite) {
        if (quantite < 0){
            throw new IllegalArgumentException( " Le quantite ne peut pas etre negative");
        }
        this.quantite = quantite;
    }
    public void setTitre( String titre) {
        if (titre == null || titre.trim().isEmpty()){
            throw new IllegalArgumentException( " Le titre ne peut pas etre vide");
        }
        this.titre = titre;
    }
    public String toString() {
        return "Identifiant\n" + id + "\nTitre\n " + titre + "\nQuantite disponible\n" + quantite;
    }
}
