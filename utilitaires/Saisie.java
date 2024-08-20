package utilitaires;

import Models.Abonne;
import Models.Bibliotheque;
import Models.Livre;
import Models.Materiel;

import javax.swing.*;
import javax.swing.text.View;
import java.util.Scanner;
import Views.RetournerLivre;

import static java.awt.AWTEventMulticaster.add;

public class Saisie {

    private static Scanner scanner = new Scanner(System.in);

    public static String lireString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int lireInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Ce n'est pas un nombre valide. Veuillez réessayer.");
            scanner.next(); // Clear invalid input
            System.out.print(message);
        }
        int valeur = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        return valeur;
    }
    public static boolean lireBoolean(String message) {
        System.out.print(message);
        String reponse = scanner.nextLine().trim().toLowerCase();
        return reponse.equals("oui") || reponse.equals("o");
    }

    public static Abonne lireAbonne() {
        String nom = lireString("Entrez le nom de l'abonné : ");
        String prenom = lireString("Entrez le prénom de l'abonné : ");
        String telephone = lireString("Entrez le téléphone de l'abonné : ");
        String email = lireString("Entrez l'email de l'abonné : ");

        return new Abonne(nom, prenom, telephone, email);
    }
    public static Livre lireLivre() {
        String titre = lireString("Entrez le titre du livre : ");
        boolean disponible = lireBoolean("Le livre est-il disponible ? (oui/non) : ");
        String auteur = lireString("Entrez le nom de l'auteur : ");
        String editeur = lireString("Entrez l'éditeur : ");
        int anneePublication = lireInt("Entrez l'année de publication : ");
        int quantite = lireInt("Entrez la quantité du livre : ");

        return new Livre(Materiel.genererIdUnique(), titre, disponible, auteur, editeur, anneePublication, quantite);
    }

    public static void lirePret() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("merci de saisir l'id du livre");
        String idLivre = scanner.nextLine();
        System.out.println("merci de saisir le numero abonne");
        String idAbonne = scanner.nextLine();
        Livre livre = Bibliotheque.trouverLivreParId(idLivre);
        Abonne abonne = Bibliotheque.trouverAbonneParId(idAbonne);

        if (livre == null) {
            System.out.println("Le livre n'existe pas.");
        } else if (abonne == null) {
            System.out.println("L'abonné n'existe pas.");
        } else if (Bibliotheque.getPrets().containsKey(idLivre)) {
            System.out.println("Le livre est déjà emprunté.");
        } else {
            Bibliotheque.getPrets().put(idLivre, idAbonne);
            System.out.println("Le livre " + livre.toString() + " a été emprunté par " + abonne.toString());
        }

    }
    public static void lireRetour(String idLivre, JTextArea resultArea) {
        //String idLivre = Bibliotheque.getLivres().getLast().getIdLivrefield
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Merci de saisir l'ID du livre :");
        String idLivre = scanner.nextLine();*/

        // Vérifie si le livre est emprunté
        if (!Bibliotheque.getPrets().containsKey(idLivre)) {
            resultArea.setText("Le livre avec l'ID " + idLivre + " n'est pas actuellement emprunté.");
            return;
        }

        // Récupère l'ID de l'abonné qui a emprunté le livre
        String abonneId = Bibliotheque.getPrets().remove(idLivre);

        // Récupère le livre et l'abonné correspondants
        Livre livre = Bibliotheque.trouverLivreParId(idLivre);
        Abonne abonne = Bibliotheque.trouverAbonneParId(abonneId);

        // Vérifie si le livre existe
        if (livre == null) {
            resultArea.setText("Le livre avec l'ID " + idLivre + " n'existe pas dans la bibliothèque.");
            return;
        }

        // Vérifie si l'abonné existe
        if (abonne == null) {
            resultArea.setText("L'abonné avec l'ID " + abonneId + " n'existe pas dans la bibliothèque.");
            return;
        }

        // Marque le livre comme disponible
        livre.setDisponible(true);

        resultArea.setText("Le livre \"" + livre.getTitre() + "\" a été retourné par " + abonne.getPrenom() + " " + abonne.getNom() + ".");
    }


    public static void messageInfos(JFrame frame, String message, int type) {

        switch (type) {
            case 0:
                //System.out.println(message + Bibliotheque.getAbonnes().getLast().toString());
                JOptionPane.showMessageDialog(frame, (message + Bibliotheque.getAbonnes().getLast().toString()));
                break;
            case 1:
                //System.out.println(message + Bibliotheque.getLivres().getLast().toString());
                JOptionPane.showMessageDialog(frame, (message + Bibliotheque.getLivres().getLast().toString()));
                break;
            default:
                break;
        }
    }

    }

