/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.model;

import fr.ufrsciencestech.utils.ClassLister;
import fr.ufrsciencestech.utils.Panier;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Mamoudou
 */
public class Modele extends Observable {

    private int compteur;   //compteur toujours positif
    private Panier panier;
    private String info;

    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener l) {
        pcs.addPropertyChangeListener("value", l);
    }

    public Modele() {
        compteur = 0;
        info = "";
    }

    public void update(int incr) {
        int old = this.compteur;
        compteur += incr;
        if (compteur < 0) {
            compteur = 0;
        }

        pcs.firePropertyChange("value", old, this.compteur);
        //setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        //notifyObservers(getCompteur());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
    }

    public void reset() {
        int old = getCompteur();
        setCompteur(0);
        pcs.firePropertyChange("value", old, getCompteur());
    }

    public void setPanier(int contenanceMax) {
        panier = new Panier(contenanceMax);
    }

    public Panier getPanier() {
        return this.panier;
    }

    public List<String> getPanierList() {
        List<String> donnees = new ArrayList<>();

        List<String> classNames = ClassLister.listClassNamesInPackage("fr.ufrsciencestech.panier");

        for (String className : classNames) {

            if (!className.contains("Exception") && !className.contains("Fruit")) {
                donnees.add(className);
            }
        }
        return donnees;
    }

    /**
     * @return the compteur
     */
    public int getCompteur() {
        return compteur;
    }

    /**
     * @param compteur the compteur to set
     *
     */
    public void setCompteur(int compteur) {
        int old = this.compteur;
        this.compteur = compteur;
        if (this.compteur < 0) {
            this.compteur = 0;
        }

        pcs.firePropertyChange("value", old, this.compteur);
        //setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        //notifyObservers(getCompteur());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String country) {
        String old = this.info;

        switch (country) {
            case "":
                this.info = "";
                break;
            case "Choisissez un pays":
                this.info = "Vous n'avez sélectionner aucun pays !!!";
                break;
            case "Choisissez un fruit":
                this.info = "Vous n'avez sélectionner aucun fruit !!!";
                break;
                
            default:
                this.info = country + " a été boycotté";
        }
        pcs.firePropertyChange("value", old, this.info);
    }
}
