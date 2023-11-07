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

    /**
     * This is the constructor for the AddDlg class.
     * It initializes the instance variables with the specified values, sets up the
     * components, variable names, view specifications, and adds a button.
     *
     * @param parent  The parent frame of the dialog.
     * @param modal   Specifies whether dialog blocks user input to other top-level
     *                windows when shown.
     * @param donnees The list of data to be displayed in the dialog.
     * @param p       The Panier to which the fruits will be added.
     * @param c       The Controleur that will handle the actions performed in the
     *                dialog.
     */
    public AddDlg(JFrame parent, boolean modal, List<String> donnees, Panier p, Controleur c) {
        super(parent, modal);
        instanciation();
        initComponent();
        initVariablesNames();
        vueSpecs();
        initPanierAdd(donnees);
        addButton(p, c);
    }

    /**
     * This method is called when a bound property is changed.
     * It gets the source of the event and casts it to a Modele.
     *
     * @param evt A PropertyChangeEvent object describing the event source and the
     *            property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Modele m = (Modele) evt.getSource();
    }

    /**
     * This method adds a Controleur as an ActionListener to the addFruit button.
     *
     * @param c The Controleur to be added as an ActionListener.
     */
    @Override
    public void addControleur(Controleur c) {
        getAddFruit().addActionListener(c);
    }

    /**
     * This method initializes the components of the dialog.
     * It creates a new JPanel, JComboBox, two JTextFields for country and price
     * input, two JLabels for the input fields, and a JButton to add the fruit to
     * the Panier.
     */
    private void instanciation() {
        panel = new JPanel();

        panierList = new JComboBox();

        countryInput = new JTextField();
        priceInput = new JTextField();

        cLabel = new JLabel("Entrer le pays: ");
        pLabel = new JLabel("Entrer le prix: ");

        addFruit = new JButton("Ajouter au panier");
    }

    /**
     * This method sets up the components of the dialog.
     * It sets the layout of the panel, adds the components to the panel, and adds
     * the panel to the content pane of the dialog.
     */
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

    /**
     * This method sets the names of the components for testing purposes.
     * It assigns a unique name to each component in the dialog.
     */
    private void initVariablesNames() {
        addFruit.setName("addToPanel");
    }

    /**
     * This method sets the specifications of the view.
     * It sets the size, location, default close operation, and visibility of the
     * dialog.
     */
    private void vueSpecs() {
        this.setSize(400, 150);
        this.setTitle("Créer un fruit");
        this.setLocation(150, 100);
    }

    /**
     * This method initializes the JComboBox with the list of data.
     * It adds each item in the list of data to the JComboBox.
     *
     * @param donnees The list of data to be added to the JComboBox.
     */
    public void initPanierAdd(List<String> donnees) {

        panierList.removeAllItems();
        for (String element : donnees) {
            panierList.addItem(element);
        }
    }

    /**
     * This method gets the text entered in the country input field.
     *
     * @return String The text entered in the country input field.
     */
    public String getCountryInput() {
        return countryInput.getText().toString();
    }

    /**
     * This method gets the JTextField for the country input.
     *
     * @return JTextField The JTextField for the country input.
     */
    public JTextField getCountryInputs() {
        return countryInput;
    }

    /**
     * This method gets the JTextField for the price input.
     *
     * @return JTextField The JTextField for the price input.
     */
    public JTextField getPriceInputs() {
        return priceInput;
    }

    /**
     * This method gets the text entered in the price input field.
     *
     * @return String The text entered in the price input field.
     */
    public String getPriceInput() {
        return priceInput.getText().toString();
    }

    /**
     * This method gets the JButton for adding the fruit to the Panier.
     *
     * @return JButton The JButton for adding the fruit to the Panier.
     */
    public JButton getAddFruit() {
        return addFruit;
    }

    /**
     * This method gets the selected item in the JComboBox.
     *
     * @return String The selected item in the JComboBox.
     */
    public String getSelectedElement() {
        return this.panierList.getSelectedItem().toString();
    }

    /**
     * This method adds an ActionListener to the addFruit button.
     * The ActionListener performs the action of adding the selected fruit to the
     * Panier when the button is clicked.
     *
     * @param p The Panier to which the fruit will be added.
     * @param c The Controleur that will handle the action performed.
     */
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
                        c.getM().setInfo("Price");
                    } catch (PanierPleinException ex) {
                        Logger.getLogger(AddDlg.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    /**
     * This method gets the message to be displayed when the information entered is
     * invalid.
     *
     * @return String The message to be displayed when the information entered is
     *         invalid.
     */
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

    /**
     * This method updates the Panier with the selected fruit and resets the input
     * fields.
     * It adds the selected fruit to the Panier, updates the view to show the
     * updated Panier, updates the countries, clears the info message, and resets
     * the input fields.
     *
     * @param p               The Panier to which the fruit will be added.
     * @param c               The Controleur that will handle the action performed.
     * @param selectedElement The selected fruit to be added to the Panier.
     * @param prix            The price of the selected fruit.
     * @param origine         The origin of the selected fruit.
     * @throws PanierPleinException If the Panier is full.
     */
    private void updatePanierAndResetFields(Panier p, Controleur c, String selectedElement, double prix, String origine)
            throws PanierPleinException {
        updatePanier(p, "fr.ufrsciencestech.panier." + selectedElement, prix, origine);
        c.getVue().setShow(c.getM().getPanier().toString());
        c.getM().update(1);
        c.updateCountries();
        c.getM().setInfo("");
        panierList.setSelectedIndex(0);
        countryInput.setText("");
        priceInput.setText("");
    }

    /**
     * This method updates the Panier with a new fruit.
     * It creates a new fruit with the specified class name, price, and origin, and
     * adds it to the Panier.
     *
     * @param p         The Panier to which the fruit will be added.
     * @param className The name of the class that extends Fruit.
     * @param prix      The price of the fruit.
     * @param origine   The origin of the fruit.
     * @throws PanierPleinException If the Panier is full.
     */
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

    /**
     * This method checks if the price entered is valid.
     * It checks if the price is not null, not empty, and matches the regular
     * expression for a number with optional decimal places.
     *
     * @param price The price entered.
     * @return boolean True if the price is valid, false otherwise.
     */
    public boolean isPriceValid(String price) {
        if (price == null || price.isEmpty()) {
            return false;
        }
        return price.matches("\\d+(\\.\\d+)?");
    }

    /**
     * This method checks if the origin entered is valid.
     * It checks if the origin is not null, not empty, and matches the regular
     * expression for a string of alphabetic characters, including accents and
     * spaces.
     *
     * @param origin The origin entered.
     * @return boolean True if the origin is valid, false otherwise.
     */
    public boolean isOriginValid(String origin) {
        if (origin == null || origin.isEmpty()) {
            return false;
        }
        return origin.matches("^[\\p{L} ]+");
    }

}

