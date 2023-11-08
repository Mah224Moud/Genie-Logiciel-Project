package fr.ufrsciencestech.view;

import fr.ufrsciencestech.controller.Controleur;
import fr.ufrsciencestech.model.Modele;
import java.awt.*;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author Mamoudou
 */
public class VueGraphSwing extends JFrame implements VueG {

    private JButton inc;
    private JButton dec;
    private JButton reset;
    private JButton boycotte;

    private JLabel compteur;
    private JLabel info;

    private JPanel top;
    private JPanel topLeft;
    private JPanel topRight;
    private JPanel bottom;
    private JPanel emptyPanel;

    private JComboBox panierList;
    private JComboBox countryList;

    private JTextArea show;

    private JMenuBar menuBar;
    private JMenu options;
    private JMenuItem quit;
    private JMenuItem createFruit;
    private JMenuItem newPanier;

    /**
     * This is the constructor for the VueGraphSwing class. It calls the
     * superclass constructor with the title "Basket", then calls the methods to
     * instantiate the components, initialize them, initialize the variable
     * names, and set the view specifications.
     *
     * @return void
     */
    public VueGraphSwing() {
        super("Panier");
        instanciation();

        initComponent();

        initVariablesNames();

        vueSpecs();
    }

    /**
     * This method sets the specifications for the VueGraphSwing frame. It packs
     * the frame, makes it visible, sets the minimum size, and sets the default
     * close operation.
     *
     * @return void
     */
    public void vueSpecs() {
        this.pack();
        this.setVisible(true);
        this.setMinimumSize(new Dimension(1000, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method instantiates the components used in the VueGraphSwing frame.
     * It creates the buttons, labels, panels, combo boxes, text area, and menu
     * items.
     *
     * @return void
     */
    public void instanciation() {
        inc = new JButton("+");
        dec = new JButton("-");
        reset = new JButton("Vider le panier");
        boycotte = new JButton("Boycotter");

        compteur = new JLabel("0", JLabel.CENTER);
        info = new JLabel("", JLabel.CENTER);

        top = new JPanel();
        bottom = new JPanel();
        topLeft = new JPanel();
        topRight = new JPanel();
        emptyPanel = new JPanel();

        countryList = new JComboBox();
        panierList = new JComboBox();

        show = new JTextArea();

        menuBar = new JMenuBar();
        options = new JMenu("Options");
        quit = new JMenuItem("Quitter");;
        createFruit = new JMenuItem("Créer un fruit");
        newPanier = new JMenuItem("Créer un panier");
    }

    /**
     * This method initializes the components used in the VueGraphSwing frame.
     * It sets the models for the combo boxes, sets the layouts for the panels,
     * adds the components to the panels, sets the editable property of the text
     * area, adds the menu items to the menu, sets the menu bar, and adds the
     * panels and text area to the main panel.
     *
     * @return void
     */
    public void initComponent() {

        panierList.setModel(new DefaultComboBoxModel<>());
        countryList.setModel(new DefaultComboBoxModel<>());

        // top panel
        top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
        top.add(topLeft);
        top.add(emptyPanel);
        top.add(topRight);

        // topLeft panel
        topLeft.setLayout(new java.awt.GridLayout(1, 3));
        topLeft.add(inc);
        topLeft.add(dec);
        topLeft.add(panierList);

        // topRight panel
        topRight.setLayout(new java.awt.GridLayout(1, 2));
        topRight.add(countryList);
        topRight.add(boycotte);

        // topCenter panel
        //emptyPanel.setBackground(Color.gray);
        emptyPanel.setPreferredSize(new Dimension(10, 1));

        // bottom panel
        bottom.setLayout(new java.awt.GridLayout(1, 3));
        bottom.add(compteur);
        bottom.add(reset);
        bottom.add(info);

        // textarea
        show.setEditable(false);

        //menu
        menuBar.add(options);

        this.setJMenuBar(menuBar);
        //option menu
        options.add(createFruit);
        options.add(newPanier);
        options.add(quit);

        // main panel
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        add(show, BorderLayout.CENTER);
    }

    /**
     * This method sets the names for the components used in the VueGraphSwing
     * frame. These names can be used for automated testing to identify the
     * components.
     *
     * @return void
     */
    public void initVariablesNames() {
        inc.setName("plus");
        dec.setName("moins");
        reset.setName("reset");
        compteur.setName("Affichage");
        show.setName("info");
        boycotte.setName("boycotte");
        createFruit.setName("addFruitDlg");
        quit.setName("quit");
        newPanier.setName("special");
    }

    /**
     * This method initializes the panierList combo box with the given data. It
     * removes all existing items from the combo box, then adds each element
     * from the data list as a new item.
     *
     * @param donnees The list of data to add to the combo box.
     * @return void
     */
    public void initPanier(List<String> donnees) {

        panierList.removeAllItems();
        for (String element : donnees) {
            panierList.addItem(element);
        }
    }

    /**
     * This method initializes the countryList combo box with the given
     * countries. It removes all existing items from the combo box, then adds
     * each country from the list as a new item.
     *
     * @param countries The list of countries to add to the combo box.
     * @return void
     */
    public void initCountries(List<String> countries) {
        countryList.removeAllItems();
        for (String element : countries) {
            countryList.addItem(element);
        }
    }

    /**
     * This method adds the given controller as an ActionListener to the
     * buttons.
     *
     * @param c The controller to add as an ActionListener.
     * @return void
     */
    public void addControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
        getReset().addActionListener(c);
        getBoycotte().addActionListener(c);
        getFruit().addActionListener(c);
        getQuit().addActionListener(c);
        getNewPanier().addActionListener(c);
    }

    /**
     * This method disposes the VueGraphSwing frame, effectively closing it.
     *
     * @return void
     */
    public void quit() {
        this.dispose();
    }

    /**
     * This method returns the currently selected item in the panierList combo
     * box. If no item is selected, it returns null.
     *
     * @return String The currently selected item, or null if no item is
     * selected.
     */
    public String getSelectedPanierItem() {
        Object selectedItem = panierList.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.toString();
        }
        return null;
    }

    /**
     * This method sets the selected item in the panierList combo box to the
     * given item. If the given item is null, it does nothing.
     *
     * @param selectedItem The item to select in the combo box.
     * @return void
     */
    public void setSelectedPanierItem(String selectedItem) {
        // Assurez-vous que le paramètre `selectedItem` est non null
        if (selectedItem != null) {
            panierList.setSelectedItem(selectedItem);
        }
    }

    /**
     * This method returns the currently selected item in the countryList combo
     * box. If no item is selected, it returns null.
     *
     * @return String The currently selected item, or null if no item is
     * selected.
     */
    public String getSelectedCountryItem() {
        Object selectedItem = countryList.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.toString();
        }
        return null;
    }

    //public void update(Observable m, Object compte){     //This method is called whenever the observed object is changed
    //      getAffiche().setText(((Integer) compte).toString());
    //}
    /**
     * This method is called when a bound property is changed. It gets the
     * source of the event, casts it to a Modele, then updates the text of the
     * affiche and info labels based on the properties of the Modele.
     *
     * @param evt The event object.
     * @return void
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Modele m = (Modele) evt.getSource();
        getAffiche().setText(((Integer) m.getCompteur()).toString());
        getInfo().setText(m.getInfo());
    }

    /**
     * This method returns the "inc" JButton.
     *
     * @return JButton The "inc" JButton.
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * This method sets the "inc" JButton.
     *
     * @param inc The JButton to set as "inc".
     * @return void
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * This method returns the "dec" JButton.
     *
     * @return JButton The "dec" JButton.
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * This method sets the "dec" JButton.
     *
     * @param dec The JButton to set as "dec".
     * @return void
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    /**
     * This method returns the "reset" JButton.
     *
     * @return JButton The "reset" JButton.
     */
    public JButton getReset() {
        return reset;
    }

    /**
     * This method sets the "reset" JButton.
     *
     * @param reset The JButton to set as "reset".
     * @return void
     */
    public void setReset(JButton reset) {
        this.reset = reset;
    }

    /**
     * This method returns the "compteur" JLabel, which is used for display.
     *
     * @return JLabel The "compteur" JLabel.
     */
    public JLabel getAffiche() {
        return compteur;
    }

    /**
     * This method sets the "compteur" JLabel, which is used for display.
     *
     * @param compteur The JLabel to set as "compteur".
     * @return void
     */
    public void setAffiche(JLabel compteur) {
        this.compteur = compteur;
    }

    /**
     * This method returns the "panierList" JComboBox.
     *
     * @return JComboBox The "panierList" JComboBox.
     */
    public JComboBox getPanierList() {
        return panierList;
    }

    /**
     * This method sets the "panierList" JComboBox.
     *
     * @param panierList The JComboBox to set as "panierList".
     * @return void
     */
    public void setPanierList(JComboBox panierList) {
        this.panierList = panierList;
    }

    /**
     * This method returns the "show" JTextArea.
     *
     * @return JTextArea The "show" JTextArea.
     */
    public JTextArea getShow() {
        return show;
    }

    /**
     * This method sets the text of the "show" JTextArea.
     *
     * @param text The text to set in the "show" JTextArea.
     * @return void
     */
    public void setShow(String text) {
        show.setText(text);
    }

    /**
     * This method returns the "boycotte" JButton.
     *
     * @return JButton The "boycotte" JButton.
     */
    public JButton getBoycotte() {
        return boycotte;
    }

    /**
     * This method sets the "boycotte" JButton.
     *
     * @param boycotte The JButton to set as "boycotte".
     * @return void
     */
    public void setBoycotte(JButton boycotte) {
        this.boycotte = boycotte;
    }

    /**
     * This method returns the "compteur" JLabel.
     *
     * @return JLabel The "compteur" JLabel.
     */
    public JLabel getCompteur() {
        return compteur;
    }

    /**
     * This method sets the "compteur" JLabel.
     *
     * @param compteur The JLabel to set as "compteur".
     * @return void
     */
    public void setCompteur(JLabel compteur) {
        this.compteur = compteur;
    }

    /**
     * This method returns the "info" JLabel.
     *
     * @return JLabel The "info" JLabel.
     */
    public JLabel getInfo() {
        return info;
    }

    /**
     * This method sets the "info" JLabel.
     *
     * @param info The JLabel to set as "info".
     * @return void
     */
    public void setInfo(JLabel info) {
        this.info = info;
    }

    /**
     * This method returns the "countryList" JComboBox.
     *
     * @return JComboBox The "countryList" JComboBox.
     */
    public JComboBox getCountryList() {
        return countryList;
    }

    /**
     * This method sets the "countryList" JComboBox.
     *
     * @param countryList The JComboBox to set as "countryList".
     * @return void
     */
    public void setCountryList(JComboBox countryList) {
        this.countryList = countryList;
    }

    /**
     * This method returns the "createFruit" JMenuItem.
     *
     * @return JMenuItem The "createFruit" JMenuItem.
     */
    public JMenuItem getFruit() {
        return createFruit;
    }

    /**
     * This method returns the "quit" JMenuItem.
     *
     * @return JMenuItem The "quit" JMenuItem.
     */
    public JMenuItem getQuit() {
        return quit;
    }

    /**
     * This method returns the "newPanier" JMenuItem.
     *
     * @return JMenuItem The "newPanier" JMenuItem.
     */
    public JMenuItem getNewPanier() {
        return newPanier;
    }
}
