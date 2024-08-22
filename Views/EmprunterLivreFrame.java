package Views;

import Models.Abonne;
import Models.Bibliotheque;
import Models.Livre;
import Models.Pret;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class EmprunterLivreFrame extends JFrame {

    private JTextField idLivreField;
    private JTextField idAbonneField;
    private JTextField datePretField;
    private JTextField dateRetourField;
    private JCheckBox enCoursCheckBox;

    public EmprunterLivreFrame() {
        setTitle("Gestion des Prêts");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(7, 2));

        // Elements de l'interface
        JLabel idLivreLabel = new JLabel("ID du Livre:");
        idLivreField = new JTextField();

        JLabel idAbonneLabel = new JLabel("ID de l'Abonné:");
        idAbonneField = new JTextField();

        JLabel datePretLabel = new JLabel("Date du Prêt:");
        datePretField = new JTextField(LocalDate.now().toString());
        datePretField.setEditable(false);

        JLabel dateRetourLabel = new JLabel("Date de Retour:");
        dateRetourField = new JTextField();
        dateRetourField.setEditable(false);

        JLabel enCoursLabel = new JLabel("En Cours:");
        enCoursCheckBox = new JCheckBox();
        enCoursCheckBox.setEnabled(false);
        enCoursCheckBox.setSelected(true);

        JButton creerPretButton = new JButton("Créer Prêt");
        creerPretButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creerPret();
            }
        });

        // Ajout des éléments à l'interface
        add(idLivreLabel);
        add(idLivreField);
        add(idAbonneLabel);
        add(idAbonneField);
        add(datePretLabel);
        add(datePretField);
        add(dateRetourLabel);
        add(dateRetourField);
        add(enCoursLabel);
        add(enCoursCheckBox);
        add(new JLabel()); // Espace vide
        add(creerPretButton);
    }

    private void creerPret() {
        String idLivre = idLivreField.getText();
        String idAbonne = "ABN"+idAbonneField.getText();

        Livre livre = Bibliotheque.trouverLivreParId(idLivre);
        Abonne abonne = Bibliotheque.trouverAbonneParId(idAbonne);

        if (livre == null) {
            JOptionPane.showMessageDialog(this, "Le livre n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (abonne == null) {
            JOptionPane.showMessageDialog(this, "L'abonné n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else if (Bibliotheque.getPrets().containsKey(idLivre)) {
            JOptionPane.showMessageDialog(this, "Le livre est déjà emprunté.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Bibliotheque.getPrets().put(idLivre, idAbonne);
            Pret pret = new Pret(livre, abonne);
            dateRetourField.setText(pret.getDateRetour().toString());
            enCoursCheckBox.setSelected(pret.getEnCours());
            JOptionPane.showMessageDialog(this, "Le livre " + livre.toString() + " a été emprunté par " + abonne.toString());

            //reinitialisé la saise
            resetForm();
        }
    }
    private void resetForm() {
        idLivreField.setText("");
        enCoursCheckBox.setSelected(false);
        datePretField.setText("");
        dateRetourField.setText("");
        idAbonneField.setText("");
    }

}

