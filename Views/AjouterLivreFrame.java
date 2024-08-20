package Views;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Bibliotheque;
import Models.Livre;
import Models.Materiel;

public class AjouterLivreFrame extends JFrame {

    private JTextField titreField;
    private JCheckBox disponibleCheckBox;
    private JTextField auteurField;
    private JTextField editeurField;
    private JTextField anneePublicationField;
    private JTextField quantiteField;

    public AjouterLivreFrame() {
        setTitle("Ajouter un Livre");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création des composants du formulaire
        JLabel titreLabel = new JLabel("Titre du Livre :");
        titreField = new JTextField(20);

        JLabel disponibleLabel = new JLabel("Disponible :");
        disponibleCheckBox = new JCheckBox("Oui");

        JLabel auteurLabel = new JLabel("Auteur :");
        auteurField = new JTextField(20);

        JLabel editeurLabel = new JLabel("Éditeur :");
        editeurField = new JTextField(20);

        JLabel anneePublicationLabel = new JLabel("Année de Publication :");
        anneePublicationField = new JTextField(4);

        JLabel quantiteLabel = new JLabel("Quantité :");
        quantiteField = new JTextField(4);

        JButton submitButton = new JButton("Ajouter le Livre");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterLivre();
            }
        });

        // Disposition des composants dans le panel
        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(titreLabel);
        panel.add(titreField);
        panel.add(disponibleLabel);
        panel.add(disponibleCheckBox);
        panel.add(auteurLabel);
        panel.add(auteurField);
        panel.add(editeurLabel);
        panel.add(editeurField);
        panel.add(anneePublicationLabel);
        panel.add(anneePublicationField);
        panel.add(quantiteLabel);
        panel.add(quantiteField);
        panel.add(new JLabel()); // Placeholder
        panel.add(submitButton);

        // Ajout du panel à la fenêtre
        add(panel);

        setVisible(true);
    }

    private void ajouterLivre() {
        try {
            String titre = titreField.getText().trim();
            if (titre.isEmpty()) throw new IllegalArgumentException("Le titre ne peut pas être vide.");

            boolean disponible = disponibleCheckBox.isSelected();

            String auteur = auteurField.getText().trim();
            if (auteur.isEmpty()) throw new IllegalArgumentException("L'auteur ne peut pas être vide.");

            String editeur = editeurField.getText().trim();
            if (editeur.isEmpty()) throw new IllegalArgumentException("L'éditeur ne peut pas être vide.");

            int anneePublication;
            try {
                anneePublication = Integer.parseInt(anneePublicationField.getText().trim());
                int anneeCourante = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                if (anneePublication <= 0 || anneePublication > anneeCourante) {
                    throw new IllegalArgumentException("L'année de publication est incorrecte.");
                }
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("L'année de publication doit être un nombre entier.");
            }

            int quantite;
            try {
                quantite = Integer.parseInt(quantiteField.getText().trim());
                if (quantite <= 0) throw new IllegalArgumentException("La quantité doit être un nombre positif.");
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("La quantité doit être un nombre entier.");
            }

            // Création de l'objet Livre
            Livre livre = new Livre(Materiel.genererIdUnique(), titre, disponible, auteur, editeur, anneePublication, quantite);
            Bibliotheque.ajouterLivre(this, livre);
            // Afficher un message de confirmation
            JOptionPane.showMessageDialog(this, "Le livre a été ajouté avec succès !" + livre.toString());

            // Réinitialiser le formulaire
            resetForm();

        } catch (IllegalArgumentException ex) {
            // Affichage du message d'erreur
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetForm() {
        titreField.setText("");
        disponibleCheckBox.setSelected(false);
        auteurField.setText("");
        editeurField.setText("");
        anneePublicationField.setText("");
        quantiteField.setText("");
    }

}
