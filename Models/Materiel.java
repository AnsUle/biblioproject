package Models;

import java.util.Random;
import java.util.Scanner;

public class Materiel {
    protected static final String CHARACTERS ="ABCDEFGHIJKLMNOPQRST0123456789";
    protected static final int ID_LENGTH = 8;
    protected String id; // id unique pour chaque materiel
    protected String titre;
    protected boolean disponible; //nbre exemple dispo

    //Constructeur avec validations
    public Materiel(String id, String titre, boolean disponible) {
        this.id = genererIdUnique();// genere un nouvel ID alphanumerique
        setTitre(titre);
        this.disponible = disponible;
    }
    //methode pour generer un ID alphanumerique
    public static String genererIdUnique() {
        StringBuilder idBuilder = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < ID_LENGTH; i++) {
            int index = rand.nextInt(CHARACTERS.length());
            idBuilder.append(CHARACTERS.charAt(index));
        }
        return idBuilder.toString();
    }
    //getter

    public String getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setId(String id) {
        Scanner sc = new Scanner(System.in);
        while (id == null|| id.trim().isEmpty()){
            System.out.println( " Le titre ne peut pas etre vide. Merci de saisir un livre");
            id = sc.nextLine();
        }
        this.id = id;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setTitre( String titre) {
        while (titre == null || titre.trim().isEmpty()){
            System.out.println( " Le titre ne peut pas etre vide");
            Scanner sc = new Scanner(System.in);
            titre = sc.nextLine();
        }
        this.titre = titre;
    }
    public String toString() {
        return "id\n" + id + "\nTitre\n " + titre + "\ndisponible\n" + disponible;
    }
}
