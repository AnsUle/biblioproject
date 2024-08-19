package Models;

import java.util.Scanner;

public class Livre extends Materiel {
    private String auteur;
    private String editeur;
    private int anneePublictation;
    private int quantité;

    //Constructeur avec validations supplementaires pour livre
    public Livre(String id,String titre,boolean disponible, String  auteur, String editeur, int anneePublictation, int quantite) {
        super(id, titre,disponible);
        setAuteur(auteur);
        setEditeur(editeur);
        setQuantite(quantite);
        setAnneePublication(anneePublictation);
    }
    // getter et setter specifique à livre
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        Scanner sc = new Scanner(System.in);
        while (auteur == null || auteur.trim().isEmpty()) {
            System.out.println(" auteur ne peut pas etre vide. Merci de saisir auteur");
            auteur = sc.nextLine();
        }
        this.auteur = auteur;
    }
    public int getQuantite() {
        return quantité;
    }
    public void setQuantite(int quantite) {
        while (quantite <= 0) {
            System.out.println("merci de saisir une quantité correct");
            Scanner scanner = new Scanner(System.in);
            quantite = scanner.nextInt();
        }
        this.quantité = quantite;
    }
    public String getEditeur() {
        return editeur;
    }
    public void setEditeur(String editeur) {
        Scanner sc = new Scanner(System.in);
        while (editeur == null || editeur.trim().isEmpty()) {
            System.out.println(" editeur ne peut pas etre vide. veuillez saisir un editeur");
            editeur = sc.nextLine();
        }
        this.editeur = editeur;
    }
    public int getAnneePublictation() {
        return anneePublictation;
    }
    public void setAnneePublication(int anneePublictation) {
        Scanner sc = new Scanner(System.in);
        int anneeCourant = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        while (anneePublictation <= 0 || anneePublictation > anneeCourant) {
            System.out.println(" Annee de publication incorrecte");
            anneePublictation = sc.nextInt();
        }
        this.anneePublictation = anneePublictation;
    }
    //Affichage des informations specifiques à livre
    @Override
    public String toString() {
        return super.toString() + "\nAuteur\n" + auteur + "\nEditeur\n" + editeur + "\nAnnee de Publication\n" + anneePublictation;
    }
}
