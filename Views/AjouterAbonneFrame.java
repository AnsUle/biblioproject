package Views;

import Models.Abonne;
import Models.Bibliotheque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class AjouterAbonneFrame extends JFrame {

    private static final AtomicInteger compteurAbonne = new AtomicInteger(1);
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField telephoneField;
    private JTextField emailField;
    private JLabel dateInscriptionLabel;
    private JLabel numeroAbonneLabel;

    public AjouterAbonneFrame() {
        setTitle("Ajouter un Abonné");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Champs pour les informations de l'abonné
        panel.add(new JLabel("Nom:"));
        nomField = new JTextField();
        panel.add(nomField);

        panel.add(new JLabel("Prénom:"));
        prenomField = new JTextField();
        panel.add(prenomField);

        panel.add(new JLabel("Téléphone:"));
        telephoneField = new JTextField();
        panel.add(telephoneField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        // Champs pour la date d'inscription et le numéro d'abonné
        panel.add(new JLabel("Date d'inscription:"));
        dateInscriptionLabel = new JLabel(getDateInscription());
        panel.add(dateInscriptionLabel);

        panel.add(new JLabel("Numéro d'abonné:"));
        numeroAbonneLabel = new JLabel(generateNumeroAbonne());
        panel.add(numeroAbonneLabel);

        // Bouton pour soumettre
        JButton submitButton = new JButton("Ajouter");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ajouterAbonne();  // Appel de la méthode qui peut potentiellement lancer une exception
                } catch (Exception ex) {
                    // Afficher une boîte de dialogue en cas d'erreur
                    JOptionPane.showMessageDialog(AjouterAbonneFrame.this, "Erreur lors de l'ajout de l'abonné : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(submitButton);

        add(panel);
    }

    private String getDateInscription() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(new Date());
    }

    private String generateNumeroAbonne() {
        return String.format("AB%04d", compteurAbonne.getAndIncrement());
    }

    private void ajouterAbonne() throws Exception {
        // Récupérer les valeurs des champs
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String telephone = telephoneField.getText();
        String email = emailField.getText();
        String dateInscription = dateInscriptionLabel.getText();
        String numeroAbonne = numeroAbonneLabel.getText();

        if (nom.isEmpty() || prenom.isEmpty() || telephone.isEmpty() || email.isEmpty()) {
            throw new Exception("Tous les champs doivent être remplis.");
        }

        // Créer un nouvel abonné avec un numéro d'abonné unique
        Abonne abonne = new Abonne(nom, prenom, telephone, email);

        // Ajouter l'abonné à la bibliothèque
        Bibliotheque.ajouterAbonne(this, abonne);

        // Afficher un message de confirmation
        JOptionPane.showMessageDialog(this, "Abonné ajouté : " + abonne.toString());

        // Fermer la fenêtre après l'ajout
        dispose();
    }
}


