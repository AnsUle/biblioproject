package Models;

import utilitaires.Saisie;

import java.util.*;


public class Bibliotheque {
    private static List<Abonne> abonnes  = new ArrayList<>();
    private static List<Livre> livres = new ArrayList<>();
    private static Map<String, String> prets = new HashMap<>() {
    }; // Clé = id_livre, Valeur = id_abonne

    public static List<Abonne> getAbonnes() {
        return abonnes;
    }

    public static List<Livre> getLivres() {
        return livres;
    }

    public static Map<String, String> getPrets() {
        return prets;
    }

    //private static Saisie saisie;

    /* public Bibliotheque() {
        this.abonnes = new ArrayList<>();
        this.livres = new ArrayList<>();
        this.prets = new HashMap<>();
        this.saisie = new Saisie();
    }*/

    public static void ajouterAbonne() {
        Abonne abonne = Saisie.lireAbonne();
        abonnes.add(abonne);
        Saisie.messageInfos("Abonné ajouté :", 0);
    }

    public static void ajouterLivre() {
        Livre livre = Saisie.lireLivre();
        livres.add(livre);
        Saisie.messageInfos("Livre ajouté : ", 1);
    }

    public static void emprunterLivre() {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("merci de saisir l'id du livre");
        String idLivre = scanner.nextLine();
        System.out.println("merci de saisir le numero abonne");
        String idAbonne = scanner.nextLine();
        Livre livre = trouverLivreParId(idLivre);
        Abonne abonne = trouverAbonneParId(idAbonne);

        if (livre == null) {
            System.out.println("Le livre n'existe pas.");
        } else if (abonne == null) {
            System.out.println("L'abonné n'existe pas.");
        } else if (prets.containsKey(idLivre)) {
            System.out.println("Le livre est déjà emprunté.");
        } else {
            prets.put(idLivre, idAbonne);
            System.out.println("Le livre " + livre.toString() + " a été emprunté par " + abonne.toString());
        }*/
        Saisie.lirePret();
    }

    public static void retournerLivre() {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("merci de saisir l'id du livre");
        String idLivre = scanner.nextLine();
        if (!prets.containsKey(idLivre)) {
            System.out.println("Le livre n'est pas emprunté.");
        } else {
            String abonneId = prets.remove(idLivre);
            Livre livre = trouverLivreParId(idLivre);
            Abonne abonne = trouverAbonneParId(abonneId);
            System.out.println("Le livre " + livre.toString() + "a été retourné par " + abonne.toString());
        }*/
        Saisie.lireRetour();
    }

    public static void afficherAbonnes() {
        if (abonnes.isEmpty()) {
            System.out.println("Aucun abonné inscrit.");
        } else {
            for (Abonne abonne : abonnes) {
                System.out.println(abonne);
            }
        }
    }

    public static void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("Aucun livre dans la bibliothèque.");
        } else {
            for (Livre livre : livres) {
                String statut = prets.containsKey(livre.getId()) ? "Emprunté" : "Disponible";
                System.out.println(livre + ", Statut: " + statut);
            }
        }
    }

    public static void afficherPrets() {
        if (prets.isEmpty()) {
            System.out.println("Aucun prêt en cours.");
        } else {
            for (Map.Entry<String, String> entry : prets.entrySet()) {
                String idLivre = entry.getKey();
                String idAbonne = entry.getValue();
                Livre livre = trouverLivreParId(idLivre);
                Abonne abonne = trouverAbonneParId(idAbonne);
                System.out.println("Le livre " + livre.toString() +  "est emprunté par " + abonne.toString());
            }
        }
    }

    public static Livre trouverLivreParId(String idLivre) {
        for (Livre livre : livres) {
            if (livre.getId().equals(idLivre)) {
                return livre;
            }
        }
        return null;
    }

    public static Abonne trouverAbonneParId(String idAbonne) {
        for (Abonne abonne : abonnes) {
            if (Objects.equals(abonne.getIdAbonne(), idAbonne)) {
                return abonne;
            }
        }
        return null;
    }

    /*
    public void menu() {
        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Ajouter un abonné");
            System.out.println("2. Ajouter un livre");
            System.out.println("3. Emprunter un livre");
            System.out.println("4. Retourner un livre");
            System.out.println("5. Afficher les abonnés");
            System.out.println("6. Afficher les livres");
            System.out.println("7. Afficher les prêts");
            System.out.println("8. Quitter");
            System.out.print("Choix : ");
            int choix = saisie.lireInt("");

            switch (choix) {
                case 1:
                    ajouterAbonne();
                    break;
                case 2:
                    ajouterLivre();
                    break;
                case 3:
                    emprunterLivre();
                    break;
                case 4:
                    retournerLivre();
                    break;
                case 5:
                    afficherAbonnes();
                    break;
                case 6:
                    afficherLivres();
                    break;
                case 7:
                    afficherPrets();
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }
    }*/
}

