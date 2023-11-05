package fr.ufrsciencestech.view;

import fr.ufrsciencestech.controller.Controleur;
import fr.ufrsciencestech.model.Modele;
import fr.ufrsciencestech.panier.Fruit;
import fr.ufrsciencestech.panier.PanierPleinException;
import fr.ufrsciencestech.utils.Panier;
import fr.ufrsciencestech.utils.Utils;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author mamoudou
 */
public class AddDlg extends JDialog implements VueG {

    private JPanel panel;

    private JComboBox panierList;

    private JTextField countryInput;
    private JTextField priceInput;

    private JLabel cLabel;
    private JLabel pLabel;

    private JButton addFruit;

    public AddDlg(JFrame parent, boolean modal, List<String> donnees, Panier p, Controleur c) {
        super(parent, modal);
        instanciation();

        initComponent();

        initVariablesNames();

        vueSpecs();

        initPanierAdd(donnees);

        addButton(p, c);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Modele m = (Modele) evt.getSource();
    }

    @Override
    public void addControleur(Controleur c) {
        getAddFruit().addActionListener(c);
    }

    private void instanciation() {
        panel = new JPanel();

        panierList = new JComboBox();

        countryInput = new JTextField();
        priceInput = new JTextField();

        cLabel = new JLabel("Entrer le pays: ");
        pLabel = new JLabel("Entrer le prix: ");

        addFruit = new JButton("Ajouter au panier");
    }

    private void initComponent() {
        panierList.setModel(new DefaultComboBoxModel<>());

        panel.setLayout(new java.awt.GridLayout(2, 2));
        panel.add(cLabel);
        panel.add(countryInput);
        panel.add(pLabel);
        panel.add(priceInput);

        this.add(panierList, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(addFruit, BorderLayout.SOUTH);
    }

    private void initVariablesNames() {
        addFruit.setName("addToPanel");
    }

    private void vueSpecs() {
        this.setSize(400, 150);
        this.setTitle("Créer un fruit");
        this.setLocation(150, 100);
    }

    public void initPanierAdd(List<String> donnees) {

        panierList.removeAllItems();
        for (String element : donnees) {
            panierList.addItem(element);
        }
    }

    public String getCountryInput() {
        return countryInput.getText().toString();
    }
    
    public JTextField getCountryInputs() {
        return countryInput;
    }
    
    public JTextField getPriceInputs() {
        return priceInput;
    }
    public String getPriceInput() {
        return priceInput.getText().toString();
    }

    public JButton getAddFruit() {
        return addFruit;
    }

    public String getSelectedElement() {
        return this.panierList.getSelectedItem().toString();
    }

    public void addButton(final Panier p, final Controleur c) {
        addFruit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String countryInputText = getCountryInput();
                String priceInputText = getPriceInput();
                String selectedElement = getSelectedElement();

                String infoMessage = getInvalidInfoMessage(countryInputText, priceInputText);
                if (infoMessage != null) {
                    c.getM().setInfo(infoMessage);
                } else {
                    try {
                        double prix = Double.valueOf(priceInputText);
                        updatePanierAndResetFields(p, c, selectedElement, prix, countryInputText);
                    } catch (NumberFormatException ex) {
                        // Gérer l'erreur si le prix n'est pas un nombre valide
                        c.getM().setInfo("Price");
                    } catch (PanierPleinException ex) {
                        Logger.getLogger(AddDlg.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    private String getInvalidInfoMessage(String country, String price) {
        if (!isOriginValid(country) && !isPriceValid(price)) {
            return "Country and price";
        } else if (!isOriginValid(country)) {
            return "Country";
        } else if (!isPriceValid(price)) {
            return "Price";
        }
        return null;
    }

    private void updatePanierAndResetFields(Panier p, Controleur c, String selectedElement, double prix, String origine) throws PanierPleinException {
        updatePanier(p, "fr.ufrsciencestech.panier." + selectedElement, prix, origine);
        c.getVue().setShow(c.getM().getPanier().toString());
        c.getM().update(1);
        c.updateCountries();
        c.getM().setInfo("");
        panierList.setSelectedIndex(0);
        countryInput.setText("");
        priceInput.setText("");
    }

    public void updatePanier(Panier p, String className, double prix, String origine) throws PanierPleinException {
        try {
            Fruit fruit = Utils.createFruitWithParams(className, prix, origine);
            p.ajout(fruit);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddDlg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddDlg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddDlg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isPriceValid(String price) {
        if (price == null || price.isEmpty()) {
            return false;
        }
        return price.matches("\\d+(\\.\\d+)?");
    }

    public boolean isOriginValid(String origin) {
        if (origin == null || origin.isEmpty()) {
            return false;
        }
        return origin.matches("^[a-zA-Z]+");
    }

}
