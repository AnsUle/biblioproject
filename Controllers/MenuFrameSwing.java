package Controllers;

import Models.*;
import Views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MenuFrameSwing extends JFrame {

    private static HashMap<String, Bibliothecaire> bibliothecaires = new HashMap<>();


    public MenuFrameSwing() {
        setTitle("Menu Bibliotheque");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Créer un panneau principal avec une disposition en grille
        JPanel panel = new JPanel();
         panel = new JPanel(new GridLayout(0, 1));
        ;

        // Créer des boutons pour chaque option du menu
        JButton btnAjouterAbonne = new JButton("Ajouter un abonné");
        JButton btnAjouterLivre = new JButton("Ajouter un livre");
        JButton btnEmprunterLivre = new JButton("Emprunter un livre");
        JButton btnRetournerLivre = new JButton("Retourner un livre");
        JButton btnAfficherBase = new JButton("Afficher la base");
        //JButton btnAfficherLivres = new JButton("Afficher les livres");
        //JButton btnAfficherPrets = new JButton("Afficher les prêts");
        JButton btnQuitter = new JButton("Quitter");

        // Ajouter les boutons au panneau
        panel.add(btnAjouterAbonne);
        panel.add(btnAjouterLivre);
        panel.add(btnEmprunterLivre);
        panel.add(btnRetournerLivre);
        panel.add(btnAfficherBase);
        //panel.add(btnAfficherLivres);
        //panel.add(btnAfficherPrets);
        panel.add(btnQuitter);

        // Ajouter des actions pour chaque bouton
        btnAjouterAbonne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la fenêtre pour ajouter un abonné
                new AjouterAbonneFrame().setVisible(true);
            }
        });

        btnAjouterLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la fenêtre pour ajouter un abonné
                new AjouterLivreFrame().setVisible(true);
            }
        });
        btnEmprunterLivre.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmprunterLivreFrame().setVisible(true);
            }
        });
        btnAfficherBase.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BibliothequeApp().setVisible(true);
            }
        });
        btnRetournerLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RetournerLivre().setVisible(true);
            }
        });

        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Quitter l'application
            }
        });

        // Ajouter le panneau au cadre
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            initBibliothecaires();
            // Créer et afficher la page de login
            LoginPage loginPage = new LoginPage(bibliothecaires);
            JFrame dummyFrame = new JFrame();  // Frame temporaire juste pour le parent de la dialog
            if (loginPage.showLoginDialog(dummyFrame)) {
                // Si l'authentification réussit, on lance l'application principale
                initObjet();
                MenuFrameSwing frame = new MenuFrameSwing();
                frame.setVisible(true);
            } else {
                // Sinon, on ferme l'application
                System.exit(0);
            }
        });
    }

    private static void initBibliothecaires() {
        bibliothecaires.put("admin", new Bibliothecaire("suleyman","anna","0789020034","anna@yahoo.fr","bonjour01"));
        bibliothecaires.put("user1", new Bibliothecaire("merlin", "user1", "0789020034","anna@yahoo.fr","bonjour02"));
        // Ajoute ici d'autres bibliothécaires si besoin
    }

    private static void initObjet() {

        Abonne ab1 = new Abonne("DOE", "John", "0789020035", "john@doe.fr");
        Abonne ab2 = new Abonne("NGHANE", "MAELYS", "0789020635", "mae@ngh.fr");
        Abonne ab3  = new Abonne("MERLIN", "MAEL", "0789020838", "merlinou@mael.fr");

        Bibliotheque.ajouterAbonne(null,ab1);
        Bibliotheque.ajouterAbonne(null,ab2);
        Bibliotheque.ajouterAbonne(null,ab3);

        Livre liv1 = new Livre("AZERT123","prada",true,"anna","cedric",1985,1);
        Livre liv2 = new Livre("BONJO153","chanel",true,"fred","hachette",2005,1);
        Livre liv3 = new Livre("LOVEO123","dior",true,"musso","ayrolles",2010,1);

        Bibliotheque.ajouterLivre(null,liv1);
        Bibliotheque.ajouterLivre(null,liv2);
        Bibliotheque.ajouterLivre(null,liv3);

    }
}
