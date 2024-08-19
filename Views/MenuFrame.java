package Views;

import Models.Bibliotheque;
import utilitaires.Saisie;

public class MenuFrame {

    public static void menu() {
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
            int choix = Saisie.lireInt("");

            switch (choix) {
                case 1:
                    Bibliotheque.ajouterAbonne();
                    break;
                case 2:
                    Bibliotheque.ajouterLivre();
                    break;
                case 3:
                    Bibliotheque.emprunterLivre();
                    break;
                case 4:
                    Bibliotheque.retournerLivre();
                    break;
                case 5:
                    Bibliotheque.afficherAbonnes();
                    break;
                case 6:
                    Bibliotheque.afficherLivres();
                    break;
                case 7:
                    Bibliotheque.afficherPrets();
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }
    }


}
