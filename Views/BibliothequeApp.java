package Views;

import Models.Abonne;
import Models.Bibliotheque;
import Models.Livre;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BibliothequeApp extends JFrame {

    private JTextField searchAbonneField;
    private JTextField searchPretField;
    private JTextField searchLivreField;
    private JTable abonneTable;
    private JTable pretTable;
    private JTable livreTable;

    public BibliothequeApp() {
        setTitle("Gestion Base de Donnee");
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        initUI();
    }

    private void initUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panneau des abonnés
        JPanel abonnePanel = new JPanel(new BorderLayout());
        abonnePanel.setBorder(BorderFactory.createTitledBorder("Liste des Abonnés"));

        searchAbonneField = new JTextField(20);
        JButton searchAbonneButton = new JButton("Rechercher Abonné");

        JPanel abonneSearchPanel = new JPanel();
        abonneSearchPanel.add(new JLabel("Nom: "));
        abonneSearchPanel.add(searchAbonneField);
        abonneSearchPanel.add(searchAbonneButton);

        abonneTable = new JTable();
        JScrollPane abonneScrollPane = new JScrollPane(abonneTable);

        abonnePanel.add(abonneSearchPanel, BorderLayout.NORTH);
        abonnePanel.add(abonneScrollPane, BorderLayout.CENTER);

        // Panneau des prêts
        JPanel pretPanel = new JPanel(new BorderLayout());
        pretPanel.setBorder(BorderFactory.createTitledBorder("Liste des Prêts"));
        pretPanel.setSize(500,600);
        searchPretField = new JTextField(20);
        JButton searchPretButton = new JButton("Rechercher Prêt");

        JPanel pretSearchPanel = new JPanel();
        pretSearchPanel.add(new JLabel("Livre ID ou Abonné ID: "));
        pretSearchPanel.add(searchPretField);
        pretSearchPanel.add(searchPretButton);

        pretTable = new JTable();
        JScrollPane pretScrollPane = new JScrollPane(pretTable);

        pretPanel.add(pretSearchPanel, BorderLayout.NORTH);
        pretPanel.add(pretScrollPane, BorderLayout.CENTER);

        // Panneau des livres
        JPanel livrePanel = new JPanel(new BorderLayout());
        livrePanel.setBorder(BorderFactory.createTitledBorder("Liste des Livres"));

        searchLivreField = new JTextField(20);
        JButton searchLivreButton = new JButton("Rechercher Livre");

        JPanel livreSearchPanel = new JPanel();
        livreSearchPanel.add(new JLabel("Titre ou Livre ID: "));
        livreSearchPanel.add(searchLivreField);
        livreSearchPanel.add(searchLivreButton);

        livreTable = new JTable();
        JScrollPane livreScrollPane = new JScrollPane(livreTable);

        livrePanel.add(livreSearchPanel, BorderLayout.NORTH);
        livrePanel.add(livreScrollPane, BorderLayout.CENTER);

        // Ajouter les panneaux dans la fenêtre principale
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(abonnePanel, BorderLayout.SOUTH);
        leftPanel.add(pretPanel, BorderLayout.NORTH);
        //leftPanel.setPreferredSize(new Dimension(1000, 1200));

        // Split Pane pour séparer gauche (abonnés/prêts) et droite (livres)
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, livrePanel);
        splitPane.setDividerLocation(600);
        splitPane.setEnabled(false);

        mainPanel.add(splitPane, BorderLayout.CENTER);

        add(mainPanel);


        // Remplir les tableaux au démarrage
        populateAbonneTable(Bibliotheque.getAbonnes());
        populatePretTable(Bibliotheque.getPrets());
        populateLivreTable(Bibliotheque.getLivres());

        // Ajout des listeners pour les boutons de recherche
        searchAbonneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchAbonneField.getText();
                List<Abonne> filteredAbonnes = Bibliotheque.getAbonnes().stream()
                        .filter(a -> a.getNom().toLowerCase().contains(searchQuery.toLowerCase()))
                        .collect(Collectors.toList());
                populateAbonneTable(filteredAbonnes);
            }
        });

        searchPretButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchPretField.getText();
                Map<String, String> filteredPrets = Bibliotheque.getPrets().entrySet().stream()
                        .filter(entry -> entry.getKey().contains(searchQuery) || entry.getValue().contains(searchQuery))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                populatePretTable(filteredPrets);
            }
        });

        searchLivreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchLivreField.getText();
                List<Livre> filteredLivres = Bibliotheque.getLivres().stream()
                        .filter(l -> l.getTitre().toLowerCase().contains(searchQuery.toLowerCase()) ||
                                l.getId().toLowerCase().contains(searchQuery.toLowerCase()))
                        .collect(Collectors.toList());
                populateLivreTable(filteredLivres);
            }
        });
    }
//
    private void populateAbonneTable(List<Abonne> abonnes) {
        String[] columnNames = {"Nom", "Email","Telephone", "ID"};
        String[][] data = new String[abonnes.size()][4];

        for (int i = 0; i < abonnes.size(); i++) {
            data[i][0] = abonnes.get(i).getNom();
            data[i][1] = abonnes.get(i).getEmail();
            data[i][2] = abonnes.get(i).getTelephone();
            data[i][3] = abonnes.get(i).getIdAbonne();
        }

        abonneTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void populatePretTable(Map<String, String> prets) {
        String[] columnNames = {"Livre ID", "Abonné ID"};
        String[][] data = new String[prets.size()][2];

        int i = 0;
        for (Map.Entry<String, String> entry : prets.entrySet()) {
            data[i][0] = entry.getKey();
            data[i][1] = entry.getValue();
            i++;
        }

        pretTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void populateLivreTable(List<Livre> livres) {
        String[] columnNames = {"Livre ID", "Titre", "Auteur"};
        String[][] data = new String[livres.size()][3];

        for (int i = 0; i < livres.size(); i++) {
            data[i][0] = livres.get(i).getId();
            data[i][1] = livres.get(i).getTitre();
            data[i][2] = livres.get(i).getAuteur();
        }

        livreTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
