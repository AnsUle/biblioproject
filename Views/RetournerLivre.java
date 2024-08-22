package Views;

import utilitaires.Saisie;
import javax.swing.*;


public class RetournerLivre extends JFrame {
    private JTextField idLivreField;
    private JTextArea resultArea;

    public RetournerLivre() {
        setTitle("Retours");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel idLivreLabel = new JLabel("Saisir l'ID du livre :");
        idLivreLabel.setBounds(50, 30, 200, 30);
        add(idLivreLabel);

        idLivreField = new JTextField();
        idLivreField.setBounds(50, 60, 300, 30);
        add(idLivreField);

        JButton submitButton = new JButton("Retourner le Livre");
        submitButton.setBounds(50, 100, 150, 30);
        add(submitButton);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 140, 600, 100);
        resultArea.setEditable(false);
        add(resultArea);

        submitButton.addActionListener(e -> {
            String idLivre = idLivreField.getText().trim();
            Saisie.lireRetour(idLivre, resultArea); // Appel de la méthode avec JTextArea
        });

        setVisible(true);
    }
}
