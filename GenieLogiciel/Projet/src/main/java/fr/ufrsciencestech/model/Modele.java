/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.model;

import fr.ufrsciencestech.utils.Utils;
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
public class Modele // extends Observable
{

    private int compteur; // compteur toujours positif
    private Panier panier;
    private String info;

    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * This method adds a PropertyChangeListener to the model.
     * The listener will be notified when the "value" property changes.
     *
     * @param l The PropertyChangeListener to be added.
     * @return void
     */
    public void addObserver(PropertyChangeListener l) {
        pcs.addPropertyChangeListener("value", l);
    }

    /**
     * This is the constructor of the Modele class.
     * It initializes the counter (compteur) to 0 and the info string to an empty
     * string.
     *
     * @return An instance of the Modele class.
     */
    public Modele() {
        compteur = 0;
        info = "";
    }

    /**
     * This method updates the counter (compteur) by a given increment.
     * It first saves the old value of the counter.
     * Then it adds the increment to the counter.
     * If the counter becomes negative, it resets the counter to 0.
     * Finally, it fires a property change event for the "value" property with the
     * old and new values of the counter.
     *
     * @param incr The increment to be added to the counter.
     * @return void
     */
    public void update(int incr) {
        int old = this.compteur;
        compteur += incr;
        if (compteur < 0) {
            compteur = 0;
        }

        pcs.firePropertyChange("value", old, this.compteur);
        // setChanged(); //marks this Observable object as having been changed; the
        // hasChanged method will now return true
        // notifyObservers(getCompteur()); //if this object has changed, as indicated by
        // the hasChanged method, then notify all of its observers and then call the
        // clearChanged method to indicate that this object has no longer changed
    }

    /**
     * This method resets the counter (compteur) to 0.
     * It first saves the old value of the counter.
     * Then it sets the counter to 0.
     * Finally, it fires a property change event for the "value" property with the
     * old and new values of the counter.
     *
     * @return void
     */
    public void reset() {
        int old = getCompteur();
        setCompteur(0);
        pcs.firePropertyChange("value", old, getCompteur());
    }

    /**
     * This method sets the basket (panier) with a given maximum capacity.
     * It creates a new Panier object with the given maximum capacity and assigns it
     * to the panier.
     *
     * @param contenanceMax The maximum capacity of the new panier.
     * @return void
     */
    public void setPanier(int contenanceMax) {
        panier = new Panier(contenanceMax);
    }

    /**
     * This method gets the basket (panier) from the model.
     *
     * @return Panier The panier of the model.
     */
    public Panier getPanier() {
        return this.panier;
    }

    /**
     * This method gets the list of fruits in the basket (panier).
     * It first gets the panier from the model.
     * Then it gets the list of fruits from the panier and returns it.
     *
     * @return List<String> The list of fruits in the panier.
     */
    public List<String> getPanierList() {
        List<String> donnees = new ArrayList<>();

        List<String> classNames = Utils.listClassNamesInPackage("fr.ufrsciencestech.panier");

        for (String className : classNames) {

            if (!className.contains("Exception") && !className.contains("Fruit")) {
                donnees.add(className);
            }
        }
        return donnees;
    }

    /**
     * This method gets the value of the counter (compteur).
     *
     * @return int The value of the counter.
     */
    public int getCompteur() {
        return compteur;
    }

    /**
     * This method sets the value of the counter (compteur).
     * It first saves the old value of the counter.
     * Then it sets the counter to the given value.
     * If the counter becomes negative, it resets the counter to 0.
     * Finally, it fires a property change event for the "value" property with the
     * old and new values of the counter.
     *
     * @param compteur The new value of the counter.
     * @return void
     */
    public void setCompteur(int compteur) {
        int old = this.compteur;
        this.compteur = compteur;
        if (this.compteur < 0) {
            this.compteur = 0;
        }

        pcs.firePropertyChange("value", old, this.compteur);
        // setChanged(); //marks this Observable object as having been changed; the
        // hasChanged method will now return true
        // notifyObservers(getCompteur()); //if this object has changed, as indicated by
        // the hasChanged method, then notify all of its observers and then call the
        // clearChanged method to indicate that this object has no longer changed
    }

    /**
     * This method gets the info string from the model.
     *
     * @return String The info string of the model.
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method sets the info string in the model.
     * It first saves the old value of the info string.
     * Then it sets the info string to the given value.
     * Finally, it fires a property change event for the "value" property with the
     * old and new values of the info string.
     *
     * @param info The new value of the info string.
     * @return void
     */
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
            case "Country":
                this.info = "L'origine que avez saisie est invalide !!!";
                break;
            case "Price":
                this.info = "Le prix que avez saisie est invalide !!!";
                break;
            case "Country and price":
                this.info = "L'origine et le prix sont obligatoires !!!";
                break;

            default:
                this.info = country + " a été boycotté";
        }
        pcs.firePropertyChange("value", old, this.info);
    }
}
