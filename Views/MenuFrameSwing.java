package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrameSwing extends JFrame {

    public MenuFrameSwing() {
        setTitle("Menu Bibliotheque");
        setSize(400, 300);
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
            MenuFrameSwing frame = new MenuFrameSwing();
            frame.setVisible(true);
        });
    }
}
