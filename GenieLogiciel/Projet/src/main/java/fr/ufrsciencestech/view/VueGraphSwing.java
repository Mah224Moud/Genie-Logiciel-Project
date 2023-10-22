/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private JLabel boycotteAffichage;
    private JLabel boycotteInfo;

    private JPanel top;
    private JPanel topLeft;
    private JPanel topRight;
    private JPanel bottom;
    private JPanel emptyPanel;

    private JComboBox panierList;
    private JComboBox countryList;

    private JTextArea info;

    public VueGraphSwing() {
        super("Panier");
        instanciation();

        initComponent();

        initVariablesNames();

        vueSpecs();
    }

    public void vueSpecs() {
        this.pack();
        this.setVisible(true);
        this.setMinimumSize(new Dimension(1000, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void instanciation() {
        inc = new JButton("+");
        dec = new JButton("-");
        reset = new JButton("Reset");
        boycotte = new JButton("Boycotter");

        compteur = new JLabel("0", JLabel.CENTER);
        boycotteAffichage = new JLabel("", JLabel.CENTER);
        boycotteInfo = new JLabel("Liste des pays", JLabel.CENTER);

        top = new JPanel();
        bottom = new JPanel();
        topLeft = new JPanel();
        topRight = new JPanel();
        emptyPanel = new JPanel();
        
        
        countryList = new JComboBox();
        panierList = new JComboBox();

        info = new JTextArea();
    }

    public void initComponent() {

        panierList.setModel(new DefaultComboBoxModel<>());
        countryList.setModel(new DefaultComboBoxModel<>());

        // top panel
        top.setLayout(new java.awt.GridLayout(1, 3));
        top.add(topLeft);
        top.add(emptyPanel);
        top.add(topRight);

        // topLeft panel
        topLeft.setLayout(new java.awt.GridLayout(1, 3));
        topLeft.add(inc);
        topLeft.add(dec);
        topLeft.add(panierList);

        // topRight panel
        topRight.setLayout(new java.awt.GridLayout(1, 3));
        topRight.add(boycotteInfo);
        topRight.add(countryList);
        topRight.add(boycotte);
        
        // topCenter panel
        emptyPanel.setBackground(Color.gray);

        // bottom panel
        bottom.setLayout(new java.awt.GridLayout(1, 3));
        bottom.add(compteur);
        bottom.add(reset);
        bottom.add(boycotteAffichage);

        // textarea
        info.setEditable(false);

        // main panel
        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        add(info, BorderLayout.CENTER);
    }

    public void initVariablesNames() {
        inc.setName("plus");
        dec.setName("moins");
        reset.setName("reset");
        compteur.setName("Affichage");
        info.setName("info");
        boycotte.setName("boycotte");
    }

    public void initPanier(List<String> donnees) {

        panierList.removeAllItems();
        for (String element : donnees) {
            panierList.addItem(element);
        }
    }
    
    public void initCountries(List<String> countries){
        countryList.removeAllItems();
        for (String element : countries) {
            countryList.addItem(element);
        }
    }

    public void addControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
        getReset().addActionListener(c);
        getBoycotte().addActionListener(c);
    }

    public String getSelectedPanierItem() {
        Object selectedItem = panierList.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.toString();
        }
        return null;
    }
    
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
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Modele m = (Modele) evt.getSource();
        getAffiche().setText(((Integer) m.getCompteur()).toString());
        getBoycotteAffichage().setText(m.getCountry());
    }

    /**
     * @return the inc
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * @param inc the inc to set
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    public JButton getReset() {
        return reset;
    }

    public void setReset(JButton reset) {
        this.reset = reset;
    }

    /**
     * @return the affiche
     */
    public JLabel getAffiche() {
        return compteur;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JLabel compteur) {
        this.compteur = compteur;
    }

    public JComboBox getPanierList() {
        return panierList;
    }

    public void setPanierList(JComboBox panierList) {
        this.panierList = panierList;
    }

    public JTextArea getInfo() {
        return info;
    }

    public void setInfo(String text) {
        info.setText(text);
    }

    public JButton getBoycotte() {
        return boycotte;
    }

    public void setBoycotte(JButton boycotte) {
        this.boycotte = boycotte;
    }

    public JLabel getCompteur() {
        return compteur;
    }

    public void setCompteur(JLabel compteur) {
        this.compteur = compteur;
    }

    public JLabel getBoycotteAffichage() {
        return boycotteAffichage;
    }

    public void setBoycotteAffichage(JLabel boycotteAffichage) {
        this.boycotteAffichage = boycotteAffichage;
    }

    public JLabel getBoycotteInfo() {
        return boycotteInfo;
    }

    public void setBoycotteInfo(JLabel boycotteInfo) {
        this.boycotteInfo = boycotteInfo;
    }

    public JComboBox getCountryList() {
        return countryList;
    }

    public void setCountryList(JComboBox countryList) {
        this.countryList = countryList;
    }

}
